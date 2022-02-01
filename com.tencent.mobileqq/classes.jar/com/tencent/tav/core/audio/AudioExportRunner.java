package com.tencent.tav.core.audio;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.MediaCodecManager;
import com.tencent.tav.decoder.logger.Logger;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public class AudioExportRunner
  implements Runnable
{
  static final int EDGE_DURATION_MS = 200;
  private static final int MAX_INPUT_SIZE = 8192;
  private static String MIME = "audio/mp4a-latm";
  static final int PACKET_FPS = 44;
  public static final String TAG = "AudioEncoder";
  private static final long WAIT_TRANSIENT_MS = 20L;
  private boolean enOfAudioInputStream = false;
  IAudioSource<? extends IDecoderTrack> mAudioAsset;
  IDecoderTrack mAudioDecoder;
  private MediaCodec mAudioEncoder;
  private ExportCallback mCallback;
  private boolean mCancel = false;
  private int mChannelCount = 1;
  private FileOutputStream mFos;
  private String mMime = MIME;
  private int mRate = 128000;
  private int mSampleRate = 44100;
  private String mSavePath;
  CMTimeRange mSelectedTimeRange;
  private int mStatus = 0;
  private AtomicBoolean mStop = new AtomicBoolean(false);
  private Thread mThread;
  
  AudioExportRunner(@NonNull IAudioSource<? extends IDecoderTrack> paramIAudioSource, @Nullable CMTimeRange paramCMTimeRange)
  {
    this.mAudioAsset = paramIAudioSource;
    if (paramCMTimeRange == null)
    {
      this.mSelectedTimeRange = new CMTimeRange(CMTime.CMTimeZero, paramIAudioSource.getDuration());
      return;
    }
    this.mSelectedTimeRange = paramCMTimeRange;
  }
  
  private void confirmFinishAndNotify()
  {
    if ((this.mStatus != 2) && (!this.mCancel))
    {
      this.mStatus = 2;
      notifyProgressUpdate(this.mSelectedTimeRange.getEndUs());
    }
  }
  
  private int dequeueInputBuffer(MediaCodec paramMediaCodec)
  {
    try
    {
      int i = paramMediaCodec.dequeueInputBuffer(1000L);
      return i;
    }
    catch (Error localError) {}catch (Exception localException) {}
    Logger.e("AudioEncoder", "dequeueInputBuffer e = ", localException);
    if ((21 <= Build.VERSION.SDK_INT) && ((localException instanceof MediaCodec.CodecException)))
    {
      if (23 <= Build.VERSION.SDK_INT)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("CodecException - isTransient = ");
        MediaCodec.CodecException localCodecException = (MediaCodec.CodecException)localException;
        localStringBuilder.append(localCodecException.isTransient());
        localStringBuilder.append(" , isRecoverable = ");
        localStringBuilder.append(localCodecException.isRecoverable());
        localStringBuilder.append(" , errorCode = ");
        localStringBuilder.append(localCodecException.getErrorCode());
        Logger.e("AudioEncoder", localStringBuilder.toString());
      }
      if (((MediaCodec.CodecException)localException).isTransient()) {
        return dequeueInputBuffer(paramMediaCodec);
      }
    }
    throw localException;
  }
  
  private ByteBuffer getInputBuffer(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return this.mAudioEncoder.getInputBuffer(paramInt);
    }
    return this.mAudioEncoder.getInputBuffers()[paramInt];
  }
  
  private ByteBuffer getOutputBuffer(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return this.mAudioEncoder.getOutputBuffer(paramInt);
    }
    return this.mAudioEncoder.getOutputBuffers()[paramInt];
  }
  
  private void initAudioDecoder()
  {
    try
    {
      this.mAudioDecoder = this.mAudioAsset.getSourceAudioDecoder(this.mSelectedTimeRange);
      this.mAudioDecoder.start();
      CMTime localCMTime = this.mSelectedTimeRange.getStart();
      IDecoderTrack localIDecoderTrack = this.mAudioDecoder;
      if (localCMTime.bigThan(CMTime.CMTimeZero)) {
        localCMTime = localCMTime.sub(CMTime.fromMs(200L));
      } else {
        localCMTime = CMTime.CMTimeZero;
      }
      localIDecoderTrack.seekTo(localCMTime, false, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("AudioEncoder", "initAudioDecoder: ", localThrowable);
    }
  }
  
  private void initAudioEncoder()
  {
    MediaFormat localMediaFormat = MediaFormat.createAudioFormat(MIME, this.mSampleRate, this.mChannelCount);
    localMediaFormat.setInteger("aac-profile", 2);
    localMediaFormat.setInteger("bitrate", this.mRate);
    localMediaFormat.setInteger("max-input-size", 8192);
    this.mAudioEncoder = MediaCodec.createEncoderByType(this.mMime);
    this.mAudioEncoder.configure(localMediaFormat, null, null, 1);
  }
  
  private boolean isFinish(MediaCodec.BufferInfo paramBufferInfo)
  {
    return paramBufferInfo.presentationTimeUs >= this.mSelectedTimeRange.getEndUs();
  }
  
  private boolean isValidBuffer(MediaCodec.BufferInfo paramBufferInfo)
  {
    return (paramBufferInfo.size > 0) && (paramBufferInfo.presentationTimeUs >= this.mSelectedTimeRange.getStartUs()) && (paramBufferInfo.presentationTimeUs <= this.mSelectedTimeRange.getEndUs()) && ((paramBufferInfo.flags & 0x2) == 0);
  }
  
  private void notifyProgressUpdate(long paramLong)
  {
    if (this.mCallback != null)
    {
      CMTimeRange localCMTimeRange = this.mSelectedTimeRange;
      if (localCMTimeRange != null)
      {
        long l = localCMTimeRange.getStartUs();
        this.mCallback.onProgress(this.mStatus, (float)(paramLong - l) * 1.0F / (float)this.mSelectedTimeRange.getDurationUs());
      }
    }
  }
  
  private void queueInputBuffer(MediaCodec paramMediaCodec, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    try
    {
      paramMediaCodec.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      return;
    }
    catch (Error localError) {}catch (Exception localException) {}
    Logger.e("AudioEncoder", "queueInputBuffer", localException);
    if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("CodecException - isTransient = ");
        MediaCodec.CodecException localCodecException = (MediaCodec.CodecException)localException;
        localStringBuilder.append(localCodecException.isTransient());
        localStringBuilder.append(" , isRecoverable = ");
        localStringBuilder.append(localCodecException.isRecoverable());
        localStringBuilder.append(" , errorCode = ");
        localStringBuilder.append(localCodecException.getErrorCode());
        Logger.e("AudioEncoder", localStringBuilder.toString());
      }
      if (((MediaCodec.CodecException)localException).isTransient())
      {
        waitTime(20L);
        queueInputBuffer(paramMediaCodec, paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      }
    }
    throw localException;
  }
  
  private void readNextSample()
  {
    Object localObject = this.mAudioDecoder.readSample();
    CMTime localCMTime = ((CMSampleBuffer)localObject).getTime();
    int i;
    if ((localCMTime.value > 0L) && (localCMTime.getTimeUs() <= this.mSelectedTimeRange.getEndUs()))
    {
      localObject = ((CMSampleBuffer)localObject).getSampleByteBuffer();
      i = ((ByteBuffer)localObject).limit() - ((ByteBuffer)localObject).position();
      byte[] arrayOfByte = new byte[i];
      ((ByteBuffer)localObject).get(arrayOfByte);
      writeAudioSample(localCMTime, i, arrayOfByte);
      return;
    }
    long l = ((CMSampleBuffer)localObject).getState().getStateCode();
    if ((l >= -1L) && (!this.enOfAudioInputStream))
    {
      signalEndOfAudioStream();
      this.enOfAudioInputStream = true;
    }
    if (l < -1L) {
      i = 255;
    } else {
      i = this.mStatus;
    }
    this.mStatus = i;
  }
  
  private void signalEndOfAudioStream()
  {
    try
    {
      Logger.d("AudioEncoder", "signalEndOfAudioStream: ");
      int i = dequeueInputBuffer(this.mAudioEncoder);
      if (i >= 0)
      {
        queueInputBuffer(this.mAudioEncoder, i, 0, 0, 0L, 4);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Logger.e("AudioEncoder", "signalEndOfAudioStream failed", localThrowable);
    }
  }
  
  private void stop()
  {
    try
    {
      if (!this.mStop.get())
      {
        this.mStop.set(true);
        try
        {
          this.mAudioDecoder.release();
          this.mAudioEncoder.stop();
          MediaCodecManager.releaseCodec(this.mAudioEncoder);
          this.mFos.flush();
          this.mFos.close();
        }
        catch (Exception localException)
        {
          Logger.e("AudioEncoder", "stop: ", localException);
        }
      }
      this.mCancel = false;
      return;
    }
    finally {}
  }
  
  private void waitTime(long paramLong)
  {
    try
    {
      wait(paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Logger.e("AudioEncoder", "waitTime: ", localInterruptedException);
    }
  }
  
  private void write(byte[] paramArrayOfByte)
  {
    if (this.mFos == null) {
      this.mFos = new FileOutputStream(this.mSavePath);
    }
    this.mFos.write(paramArrayOfByte);
  }
  
  private void writeAudioSample()
  {
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    int i;
    do
    {
      i = this.mAudioEncoder.dequeueOutputBuffer(localBufferInfo, 0L);
      Object localObject1;
      if ((i >= 0) && (isValidBuffer(localBufferInfo)) && (this.mStatus != 2))
      {
        if ((localBufferInfo.flags & 0x4) != 0)
        {
          Logger.d("AudioEncoder", "writeAudioFrame: BUFFER_FLAG_END_OF_STREAM ");
          this.mStatus = 2;
        }
        Object localObject2 = getOutputBuffer(i);
        ((ByteBuffer)localObject2).position(localBufferInfo.offset);
        localObject1 = new byte[localBufferInfo.size + 7];
        ((ByteBuffer)localObject2).get((byte[])localObject1, 7, localBufferInfo.size);
        EncoderUtils.addADTStoPacket((byte[])localObject1, this.mChannelCount);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("dequeue finish - ");
        ((StringBuilder)localObject2).append(localBufferInfo.presentationTimeUs);
        ((StringBuilder)localObject2).append("--");
        ((StringBuilder)localObject2).append(localBufferInfo.flags);
        ((StringBuilder)localObject2).append(" -- ");
        ((StringBuilder)localObject2).append(localBufferInfo.size);
        ((StringBuilder)localObject2).append("  -  ");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" endUs = ");
        ((StringBuilder)localObject2).append(this.mSelectedTimeRange.getEndUs());
        Logger.v("AudioEncoder", ((StringBuilder)localObject2).toString());
        write((byte[])localObject1);
        this.mAudioEncoder.releaseOutputBuffer(i, false);
        if (this.mStatus != 2) {
          notifyProgressUpdate(localBufferInfo.presentationTimeUs);
        } else {
          notifyProgressUpdate(this.mSelectedTimeRange.getEndUs());
        }
      }
      else if (isFinish(localBufferInfo))
      {
        confirmFinishAndNotify();
      }
      else if ((i != -1) && (i != -2))
      {
        if ((localBufferInfo.flags & 0x4) != 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("writeAudioFrame: BUFFER_FLAG_END_OF_STREAM ");
          ((StringBuilder)localObject1).append(localBufferInfo.size);
          ((StringBuilder)localObject1).append("/");
          ((StringBuilder)localObject1).append(localBufferInfo.presentationTimeUs);
          Logger.d("AudioEncoder", ((StringBuilder)localObject1).toString());
          confirmFinishAndNotify();
          this.mAudioEncoder.releaseOutputBuffer(i, false);
        }
        else
        {
          this.mAudioEncoder.releaseOutputBuffer(i, false);
        }
      }
    } while (i >= 0);
  }
  
  private void writeAudioSample(CMTime paramCMTime, int paramInt, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (paramInt - i > 0)
    {
      int j = this.mAudioEncoder.dequeueInputBuffer(-1L);
      if (j >= 0)
      {
        ByteBuffer localByteBuffer = getInputBuffer(j);
        localByteBuffer.clear();
        int k = Math.min(localByteBuffer.capacity(), paramInt);
        localByteBuffer.put(paramArrayOfByte, i, k);
        i += k;
        this.mAudioEncoder.queueInputBuffer(j, 0, k, paramCMTime.getTimeUs(), 1);
      }
    }
  }
  
  public void cancel()
  {
    try
    {
      this.mCancel = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getRate()
  {
    return this.mRate;
  }
  
  public int getSampleRate()
  {
    return this.mSampleRate;
  }
  
  public String getSavePath()
  {
    return this.mSavePath;
  }
  
  public CMTimeRange getSelectedTimeRange()
  {
    return this.mSelectedTimeRange;
  }
  
  public void prepare()
  {
    initAudioDecoder();
    initAudioEncoder();
  }
  
  public void run()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("encoder start - ");
    localStringBuilder1.append(this);
    Logger.d("AudioEncoder", localStringBuilder1.toString());
    while ((this.mStatus <= 1) && (!this.mCancel)) {
      try
      {
        readNextSample();
        writeAudioSample();
      }
      catch (Throwable localThrowable)
      {
        Logger.e("AudioEncoder", "run: writeAudioSample", localThrowable);
        this.mStatus = 255;
        notifyProgressUpdate(this.mSelectedTimeRange.getEndUs());
      }
    }
    if (this.mCancel)
    {
      this.mStatus = 4;
      notifyProgressUpdate(this.mSelectedTimeRange.getEndUs());
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("encoder finish - ");
    localStringBuilder2.append(this);
    localStringBuilder2.append("  mStatus = ");
    localStringBuilder2.append(this.mStatus);
    Logger.d("AudioEncoder", localStringBuilder2.toString());
    stop();
  }
  
  public void setAsset(IAudioSource<? extends IDecoderTrack> paramIAudioSource)
  {
    this.mAudioAsset = paramIAudioSource;
  }
  
  public void setCallback(ExportCallback paramExportCallback)
  {
    this.mCallback = paramExportCallback;
  }
  
  public void setMime(String paramString)
  {
    this.mMime = paramString;
  }
  
  public void setRate(int paramInt)
  {
    this.mRate = paramInt;
  }
  
  public void setSampleRate(int paramInt)
  {
    this.mSampleRate = paramInt;
  }
  
  public void setSavePath(String paramString)
  {
    this.mSavePath = paramString;
  }
  
  public void setSelectedTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.mSelectedTimeRange = paramCMTimeRange;
  }
  
  public void start()
  {
    try
    {
      if (this.mThread == null)
      {
        this.mAudioEncoder.start();
        this.mThread = new Thread(this);
        this.mThread.start();
        this.mStop.set(false);
        this.mCancel = false;
        this.enOfAudioInputStream = false;
        this.mStatus = 1;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.core.audio.AudioExportRunner
 * JD-Core Version:    0.7.0.1
 */