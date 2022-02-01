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
    catch (Exception localException)
    {
      Logger.e("AudioEncoder", "dequeueInputBuffer e = ", localException);
      if ((21 <= Build.VERSION.SDK_INT) && ((localException instanceof MediaCodec.CodecException)))
      {
        if (23 <= Build.VERSION.SDK_INT) {
          Logger.e("AudioEncoder", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (((MediaCodec.CodecException)localException).isTransient()) {
          return dequeueInputBuffer(paramMediaCodec);
        }
      }
      throw localException;
    }
    catch (Error localError)
    {
      label11:
      break label11;
    }
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
      if (localCMTime.bigThan(CMTime.CMTimeZero)) {}
      for (localCMTime = localCMTime.sub(CMTime.fromMs(200L));; localCMTime = CMTime.CMTimeZero)
      {
        localIDecoderTrack.seekTo(localCMTime, false, false);
        return;
      }
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
    if ((this.mCallback != null) && (this.mSelectedTimeRange != null))
    {
      long l = this.mSelectedTimeRange.getStartUs();
      this.mCallback.onProgress(this.mStatus, (float)(paramLong - l) * 1.0F / (float)this.mSelectedTimeRange.getDurationUs());
    }
  }
  
  private void queueInputBuffer(MediaCodec paramMediaCodec, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    try
    {
      paramMediaCodec.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("AudioEncoder", "queueInputBuffer", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
      {
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e("AudioEncoder", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (((MediaCodec.CodecException)localException).isTransient())
        {
          waitTime(20L);
          queueInputBuffer(paramMediaCodec, paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
        }
      }
      throw localException;
    }
    catch (Error localError)
    {
      label15:
      break label15;
    }
  }
  
  private void readNextSample()
  {
    Object localObject = this.mAudioDecoder.readSample();
    CMTime localCMTime = ((CMSampleBuffer)localObject).getTime();
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
    if (l < -1L) {}
    for (int i = 255;; i = this.mStatus)
    {
      this.mStatus = i;
      return;
    }
  }
  
  private void signalEndOfAudioStream()
  {
    try
    {
      Logger.d("AudioEncoder", "signalEndOfAudioStream: ");
      int i = dequeueInputBuffer(this.mAudioEncoder);
      if (i >= 0) {
        queueInputBuffer(this.mAudioEncoder, i, 0, 0, 0L, 4);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("AudioEncoder", "signalEndOfAudioStream failed", localThrowable);
    }
  }
  
  /* Error */
  private void stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/tencent/tav/core/audio/AudioExportRunner:mStop	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 361	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: ifne +48 -> 57
    //   12: aload_0
    //   13: getfield 80	com/tencent/tav/core/audio/AudioExportRunner:mStop	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   16: iconst_1
    //   17: invokevirtual 364	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   20: aload_0
    //   21: getfield 209	com/tencent/tav/core/audio/AudioExportRunner:mAudioDecoder	Lcom/tencent/tav/decoder/IDecoderTrack;
    //   24: invokeinterface 367 1 0
    //   29: aload_0
    //   30: getfield 188	com/tencent/tav/core/audio/AudioExportRunner:mAudioEncoder	Landroid/media/MediaCodec;
    //   33: invokevirtual 369	android/media/MediaCodec:stop	()V
    //   36: aload_0
    //   37: getfield 188	com/tencent/tav/core/audio/AudioExportRunner:mAudioEncoder	Landroid/media/MediaCodec;
    //   40: invokestatic 375	com/tencent/tav/decoder/MediaCodecManager:releaseCodec	(Landroid/media/MediaCodec;)V
    //   43: aload_0
    //   44: getfield 377	com/tencent/tav/core/audio/AudioExportRunner:mFos	Ljava/io/FileOutputStream;
    //   47: invokevirtual 382	java/io/FileOutputStream:flush	()V
    //   50: aload_0
    //   51: getfield 377	com/tencent/tav/core/audio/AudioExportRunner:mFos	Ljava/io/FileOutputStream;
    //   54: invokevirtual 385	java/io/FileOutputStream:close	()V
    //   57: aload_0
    //   58: iconst_0
    //   59: putfield 82	com/tencent/tav/core/audio/AudioExportRunner:mCancel	Z
    //   62: aload_0
    //   63: monitorexit
    //   64: return
    //   65: astore_1
    //   66: ldc 18
    //   68: ldc_w 387
    //   71: aload_1
    //   72: invokestatic 138	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   75: goto -18 -> 57
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	AudioExportRunner
    //   65	7	1	localException	Exception
    //   78	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	57	65	java/lang/Exception
    //   2	20	78	finally
    //   20	57	78	finally
    //   57	62	78	finally
    //   66	75	78	finally
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
    for (;;)
    {
      int i = this.mAudioEncoder.dequeueOutputBuffer(localBufferInfo, 0L);
      if ((i >= 0) && (isValidBuffer(localBufferInfo)) && (this.mStatus != 2))
      {
        if ((localBufferInfo.flags & 0x4) != 0)
        {
          Logger.d("AudioEncoder", "writeAudioFrame: BUFFER_FLAG_END_OF_STREAM ");
          this.mStatus = 2;
        }
        ByteBuffer localByteBuffer = getOutputBuffer(i);
        localByteBuffer.position(localBufferInfo.offset);
        byte[] arrayOfByte = new byte[localBufferInfo.size + 7];
        localByteBuffer.get(arrayOfByte, 7, localBufferInfo.size);
        EncoderUtils.addADTStoPacket(arrayOfByte, this.mChannelCount);
        Logger.v("AudioEncoder", "dequeue finish - " + localBufferInfo.presentationTimeUs + "--" + localBufferInfo.flags + " -- " + localBufferInfo.size + "  -  " + i + " endUs = " + this.mSelectedTimeRange.getEndUs());
        write(arrayOfByte);
        this.mAudioEncoder.releaseOutputBuffer(i, false);
        if (this.mStatus != 2) {
          notifyProgressUpdate(localBufferInfo.presentationTimeUs);
        }
      }
      while (i < 0)
      {
        return;
        notifyProgressUpdate(this.mSelectedTimeRange.getEndUs());
        continue;
        if (isFinish(localBufferInfo)) {
          confirmFinishAndNotify();
        } else if ((i != -1) && (i != -2)) {
          if ((localBufferInfo.flags & 0x4) != 0)
          {
            Logger.d("AudioEncoder", "writeAudioFrame: BUFFER_FLAG_END_OF_STREAM " + localBufferInfo.size + "/" + localBufferInfo.presentationTimeUs);
            confirmFinishAndNotify();
            this.mAudioEncoder.releaseOutputBuffer(i, false);
          }
          else
          {
            this.mAudioEncoder.releaseOutputBuffer(i, false);
          }
        }
      }
    }
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
        this.mAudioEncoder.queueInputBuffer(j, 0, k, paramCMTime.getTimeUs(), 1);
        i += k;
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
    Logger.d("AudioEncoder", "encoder start - " + this);
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
    Logger.d("AudioEncoder", "encoder finish - " + this + "  mStatus = " + this.mStatus);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.core.audio.AudioExportRunner
 * JD-Core Version:    0.7.0.1
 */