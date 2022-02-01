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
  private static final int EDGE_DURATION_MS = 200;
  private static final int MAX_INPUT_SIZE = 8192;
  private static final String MIME = "audio/mp4a-latm";
  static final int PACKET_FPS = 44;
  private static final long WAIT_TRANSIENT_MS = 20L;
  private final String TAG;
  private boolean enOfAudioInputStream;
  IAudioSource<? extends IDecoderTrack> mAudioAsset;
  private IDecoderTrack mAudioDecoder;
  private MediaCodec mAudioEncoder;
  private ExportCallback mCallback;
  private boolean mCancel;
  private int mChannelCount;
  private FileOutputStream mFos;
  private String mMime;
  private int mRate;
  private int mSampleRate;
  private String mSavePath;
  CMTimeRange mSelectedTimeRange;
  private int mStatus;
  private AtomicBoolean mStop;
  private Thread mThread;
  
  AudioExportRunner(@NonNull IAudioSource<? extends IDecoderTrack> paramIAudioSource, @Nullable CMTimeRange paramCMTimeRange)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioExportRunner@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.TAG = localStringBuilder.toString();
    this.mMime = "audio/mp4a-latm";
    this.mRate = 128000;
    this.mSampleRate = 44100;
    this.mChannelCount = 1;
    this.mStatus = 0;
    this.mStop = new AtomicBoolean(false);
    this.mCancel = false;
    this.enOfAudioInputStream = false;
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
    Logger.e(this.TAG, "dequeueInputBuffer e = ", localException);
    if ((21 <= Build.VERSION.SDK_INT) && ((localException instanceof MediaCodec.CodecException)))
    {
      if (23 <= Build.VERSION.SDK_INT)
      {
        String str = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("CodecException - isTransient = ");
        MediaCodec.CodecException localCodecException = (MediaCodec.CodecException)localException;
        localStringBuilder.append(localCodecException.isTransient());
        localStringBuilder.append(" , isRecoverable = ");
        localStringBuilder.append(localCodecException.isRecoverable());
        localStringBuilder.append(" , errorCode = ");
        localStringBuilder.append(localCodecException.getErrorCode());
        Logger.e(str, localStringBuilder.toString());
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
      Logger.e(this.TAG, "initAudioDecoder: ", localThrowable);
    }
  }
  
  private void initAudioEncoder()
  {
    MediaFormat localMediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", this.mSampleRate, this.mChannelCount);
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
    Logger.e(this.TAG, "queueInputBuffer", localException);
    if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        String str = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("CodecException - isTransient = ");
        MediaCodec.CodecException localCodecException = (MediaCodec.CodecException)localException;
        localStringBuilder.append(localCodecException.isTransient());
        localStringBuilder.append(" , isRecoverable = ");
        localStringBuilder.append(localCodecException.isRecoverable());
        localStringBuilder.append(" , errorCode = ");
        localStringBuilder.append(localCodecException.getErrorCode());
        Logger.e(str, localStringBuilder.toString());
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
    if ((localCMTime.value > 0L) && (localCMTime.getTimeUs() <= this.mSelectedTimeRange.getEndUs()))
    {
      localObject = ((CMSampleBuffer)localObject).getSampleByteBuffer();
      int i = ((ByteBuffer)localObject).limit() - ((ByteBuffer)localObject).position();
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
      this.mStatus = 255;
    }
  }
  
  private void signalEndOfAudioStream()
  {
    try
    {
      Logger.d(this.TAG, "signalEndOfAudioStream: ");
      int i = dequeueInputBuffer(this.mAudioEncoder);
      if (i >= 0)
      {
        queueInputBuffer(this.mAudioEncoder, i, 0, 0, 0L, 4);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Logger.e(this.TAG, "signalEndOfAudioStream failed", localThrowable);
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
          Logger.e(this.TAG, "stop: ", localException);
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
      Logger.e(this.TAG, "waitTime: ", localInterruptedException);
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
      Object localObject2;
      Object localObject1;
      if ((i >= 0) && (isValidBuffer(localBufferInfo)) && (this.mStatus != 2))
      {
        if ((localBufferInfo.flags & 0x4) != 0)
        {
          Logger.d(this.TAG, "writeAudioFrame: BUFFER_FLAG_END_OF_STREAM ");
          this.mStatus = 2;
        }
        localObject2 = getOutputBuffer(i);
        ((ByteBuffer)localObject2).position(localBufferInfo.offset);
        localObject1 = new byte[localBufferInfo.size + 7];
        ((ByteBuffer)localObject2).get((byte[])localObject1, 7, localBufferInfo.size);
        EncoderUtils.addADTStoPacket((byte[])localObject1, this.mChannelCount);
        localObject2 = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dequeue finish - ");
        localStringBuilder.append(localBufferInfo.presentationTimeUs);
        localStringBuilder.append("--");
        localStringBuilder.append(localBufferInfo.flags);
        localStringBuilder.append(" -- ");
        localStringBuilder.append(localBufferInfo.size);
        localStringBuilder.append("  -  ");
        localStringBuilder.append(i);
        localStringBuilder.append(" endUs = ");
        localStringBuilder.append(this.mSelectedTimeRange.getEndUs());
        Logger.v((String)localObject2, localStringBuilder.toString());
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
          localObject1 = this.TAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("writeAudioFrame: BUFFER_FLAG_END_OF_STREAM ");
          ((StringBuilder)localObject2).append(localBufferInfo.size);
          ((StringBuilder)localObject2).append("/");
          ((StringBuilder)localObject2).append(localBufferInfo.presentationTimeUs);
          Logger.d((String)localObject1, ((StringBuilder)localObject2).toString());
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
    int j = 5;
    int i = 0;
    while (paramInt - i > 0)
    {
      int k = this.mAudioEncoder.dequeueInputBuffer(1000L);
      if (k >= 0)
      {
        ByteBuffer localByteBuffer = getInputBuffer(k);
        localByteBuffer.clear();
        int m = Math.min(localByteBuffer.capacity(), paramInt);
        localByteBuffer.put(paramArrayOfByte, i, m);
        i += m;
        this.mAudioEncoder.queueInputBuffer(k, 0, m, paramCMTime.getTimeUs(), 1);
      }
      else
      {
        j -= 1;
        if (j >= 0) {
          waitTime(20L);
        } else {
          throw new RuntimeException("dequeueInputBuffer fail");
        }
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
    String str1 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("encoder start - ");
    localStringBuilder.append(this);
    Logger.d(str1, localStringBuilder.toString());
    while ((this.mStatus <= 1) && (!this.mCancel)) {
      try
      {
        readNextSample();
        writeAudioSample();
      }
      catch (Throwable localThrowable)
      {
        Logger.e(this.TAG, "run: writeAudioSample", localThrowable);
        this.mStatus = 255;
        notifyProgressUpdate(this.mSelectedTimeRange.getEndUs());
      }
    }
    if (this.mCancel)
    {
      this.mStatus = 4;
      notifyProgressUpdate(this.mSelectedTimeRange.getEndUs());
    }
    String str2 = this.TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("encoder finish - ");
    localStringBuilder.append(this);
    localStringBuilder.append("  mStatus = ");
    localStringBuilder.append(this.mStatus);
    Logger.d(str2, localStringBuilder.toString());
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
        this.mThread = new Thread(this, this.TAG);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.audio.AudioExportRunner
 * JD-Core Version:    0.7.0.1
 */