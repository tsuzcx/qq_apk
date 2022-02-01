package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.core.ExportRuntimeException;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class EncoderWriter
{
  public static final int OUTPUT_AUDIO_AAC_PROFILE = 2;
  public static final int OUTPUT_AUDIO_BIT_RATE = 128000;
  public static final int OUTPUT_AUDIO_CHANNEL_COUNT = 1;
  public static final String OUTPUT_AUDIO_MIME_TYPE = "audio/mp4a-latm";
  public static final int OUTPUT_AUDIO_SAMPLE_RATE_HZ = 44100;
  public static final int OUTPUT_VIDEO_BIT_RATE = 8000000;
  public static final int OUTPUT_VIDEO_COLOR_FORMAT = 2130708361;
  public static final int OUTPUT_VIDEO_FRAME_RATE = 30;
  public static final int OUTPUT_VIDEO_IFRAME_INTERVAL = 1;
  public static final String OUTPUT_VIDEO_MIME_TYPE = "video/avc";
  private static final String TAG = "EncoderWriter";
  private static final long WAIT_TRANSIENT_MS = 20L;
  public static final long WRITER_FINISH = -1L;
  private Surface _inputSurface = null;
  private volatile MediaCodec.BufferInfo audioBufferInfo = new MediaCodec.BufferInfo();
  private volatile MediaFormat audioEncodeFormat = null;
  private MediaCodec audioEncoder;
  private Lock audioEncoderLock = new ReentrantLock();
  private boolean audioEncoderStarted = false;
  private long audioPresentationTimeUs;
  private boolean enOfAudioInputStream = false;
  private boolean enOfVideoInputStream = false;
  private ExportConfig encodeOption;
  private boolean hasAudioTrack = false;
  private boolean hasVideoTrack = false;
  private ReadWriteLock lock = new ReentrantReadWriteLock();
  private MediaMuxer muxer;
  private volatile boolean muxerStarted = false;
  private int outHeight;
  private int outWidth;
  private volatile int outputAudioTrack = -1;
  private volatile int outputVideoTrack = -1;
  private boolean released = false;
  private volatile MediaCodec.BufferInfo videoBufferInfo = new MediaCodec.BufferInfo();
  private volatile MediaFormat videoEncodeFormat = null;
  private MediaCodec videoEncoder;
  private Lock videoEncoderLock = new ReentrantLock();
  private boolean videoEncoderStarted = false;
  private long videoPresentationTimeUs;
  
  @RequiresApi(api=18)
  public EncoderWriter(String paramString)
  {
    this.muxer = new MediaMuxer(paramString, 0);
  }
  
  private int dequeueInputBuffer(MediaCodec paramMediaCodec)
  {
    try
    {
      int i = paramMediaCodec.dequeueInputBuffer(1000L);
      return i;
    }
    catch (Error localError) {}catch (Exception localException) {}
    Logger.e("EncoderWriter", "dequeueInputBuffer e = ", localException);
    if ((21 <= Build.VERSION.SDK_INT) && ((localException instanceof MediaCodec.CodecException)))
    {
      MediaCodec.CodecException localCodecException = (MediaCodec.CodecException)localException;
      loggerCodecException(localCodecException);
      if (localCodecException.isTransient())
      {
        waitTime(20L);
        return dequeueInputBuffer(paramMediaCodec);
      }
    }
    throw localException;
  }
  
  private int dequeueOutputBuffer(MediaCodec paramMediaCodec, MediaCodec.BufferInfo paramBufferInfo)
  {
    try
    {
      int i = paramMediaCodec.dequeueOutputBuffer(paramBufferInfo, 1000L);
      return i;
    }
    catch (Exception localException)
    {
      Logger.e("EncoderWriter", "dequeueOutputBuffer e = ", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
      {
        MediaCodec.CodecException localCodecException = (MediaCodec.CodecException)localException;
        loggerCodecException(localCodecException);
        if (localCodecException.isTransient())
        {
          waitTime(20L);
          return dequeueOutputBuffer(paramMediaCodec, paramBufferInfo);
        }
      }
      throw localException;
    }
  }
  
  @RequiresApi(api=18)
  private void drainEncoder(boolean paramBoolean)
  {
    int i;
    boolean bool1;
    if (paramBoolean)
    {
      if (this.hasVideoTrack)
      {
        if (this._inputSurface == null) {
          i = 1;
        } else {
          signalEndOfVideoStream();
        }
      }
      else {
        i = 0;
      }
      bool1 = this.hasAudioTrack;
    }
    else
    {
      i = 0;
      bool1 = false;
    }
    boolean bool6 = this.hasVideoTrack ^ true;
    boolean bool3 = this.hasAudioTrack ^ true;
    long l = System.currentTimeMillis();
    boolean bool4 = bool1;
    while (((!bool6) && (this.hasVideoTrack)) || ((!bool3) && (this.hasAudioTrack)))
    {
      int j = i;
      if (i != 0)
      {
        signalEndOfVideoStream();
        j = 0;
      }
      bool1 = bool6;
      if (!bool6)
      {
        bool1 = writeVideoFrame(paramBoolean);
        if (System.currentTimeMillis() - l > 2000L)
        {
          this.hasVideoTrack = (paramBoolean ^ true);
          Logger.e("EncoderWriter", "drainEncoder: 视频写入处理时间超时，提前结束写入");
          bool1 = true;
        }
      }
      boolean bool5 = bool4;
      if (bool4)
      {
        signalEndOfAudioStream();
        bool5 = false;
      }
      boolean bool2 = bool3;
      if (!bool3)
      {
        bool2 = writeAudioFrame(paramBoolean);
        if (System.currentTimeMillis() - l > 2000L)
        {
          this.hasAudioTrack = (paramBoolean ^ true);
          Logger.e("EncoderWriter", "drainEncoder: 音频写入处理时间超时，提前结束写入");
          bool2 = true;
        }
      }
      i = j;
      bool4 = bool5;
      bool6 = bool1;
      bool3 = bool2;
      if (unStarted()) {
        try
        {
          if (unStarted())
          {
            if (this.hasVideoTrack) {
              this.outputVideoTrack = this.muxer.addTrack(this.videoEncodeFormat);
            }
            if (this.hasAudioTrack) {
              this.outputAudioTrack = this.muxer.addTrack(this.audioEncodeFormat);
            }
            this.muxer.start();
            this.muxerStarted = true;
          }
          i = j;
          bool4 = bool5;
          bool6 = bool1;
          bool3 = bool2;
        }
        finally {}
      }
    }
  }
  
  private void fixAudioFormat(MediaFormat paramMediaFormat)
  {
    fixStringKey(paramMediaFormat, "mime", "audio/mp4a-latm");
    fixIntegerKey(paramMediaFormat, "sample-rate", 44100);
    fixIntegerKey(paramMediaFormat, "channel-count", 1);
    fixIntegerKey(paramMediaFormat, "bitrate", 128000);
    fixIntegerKey(paramMediaFormat, "aac-profile", 2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fixAudioFormat() called with: format = [");
    localStringBuilder.append(paramMediaFormat);
    localStringBuilder.append("]");
    Logger.d("EncoderWriter", localStringBuilder.toString());
  }
  
  private void fixIntegerKey(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    if ((!paramMediaFormat.containsKey(paramString)) || (paramMediaFormat.getInteger(paramString) <= 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fixIntegerKey: 缺少关键配置：");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", 使用默认值：");
      localStringBuilder.append(paramInt);
      Logger.w("EncoderWriter", localStringBuilder.toString());
      paramMediaFormat.setInteger(paramString, paramInt);
    }
  }
  
  private void fixStringKey(MediaFormat paramMediaFormat, String paramString1, String paramString2)
  {
    if ((!paramMediaFormat.containsKey(paramString1)) || (TextUtils.isEmpty(paramMediaFormat.getString(paramString1))))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fixStringKey: 缺少关键配置：");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", 使用默认值：");
      localStringBuilder.append(paramString2);
      Logger.w("EncoderWriter", localStringBuilder.toString());
      paramMediaFormat.setString(paramString1, paramString2);
    }
  }
  
  private void fixVideoFormat(MediaFormat paramMediaFormat)
  {
    paramMediaFormat.setInteger("color-format", 2130708361);
    fixStringKey(paramMediaFormat, "mime", "video/avc");
    fixIntegerKey(paramMediaFormat, "bitrate", 8000000);
    fixIntegerKey(paramMediaFormat, "frame-rate", 30);
    fixIntegerKey(paramMediaFormat, "i-frame-interval", 1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fixVideoFormat() called with: format = [");
    localStringBuilder.append(paramMediaFormat);
    localStringBuilder.append("]");
    Logger.d("EncoderWriter", localStringBuilder.toString());
  }
  
  private ByteBuffer getInputBuffer(MediaCodec paramMediaCodec, int paramInt)
  {
    try
    {
      ByteBuffer localByteBuffer = DecoderUtils.getInputBuffer(paramMediaCodec, paramInt);
      return localByteBuffer;
    }
    catch (Error localError) {}catch (Exception localException) {}
    Logger.e("EncoderWriter", "getInputBuffer", localException);
    if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
    {
      MediaCodec.CodecException localCodecException = (MediaCodec.CodecException)localException;
      loggerCodecException(localCodecException);
      if (localCodecException.isTransient())
      {
        waitTime(20L);
        return getInputBuffer(paramMediaCodec, paramInt);
      }
    }
    throw localException;
  }
  
  private ByteBuffer getOutputBuffer(MediaCodec paramMediaCodec, int paramInt)
  {
    try
    {
      ByteBuffer localByteBuffer = DecoderUtils.getOutputBuffer(paramMediaCodec, paramInt);
      return localByteBuffer;
    }
    catch (Error localError) {}catch (Exception localException) {}
    Logger.e("EncoderWriter", "getOutputBuffer", localException);
    if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
    {
      MediaCodec.CodecException localCodecException = (MediaCodec.CodecException)localException;
      loggerCodecException(localCodecException);
      if (localCodecException.isTransient())
      {
        waitTime(20L);
        return getOutputBuffer(paramMediaCodec, paramInt);
      }
    }
    throw localException;
  }
  
  private void loggerCodecException(MediaCodec.CodecException paramCodecException)
  {
    if (23 <= Build.VERSION.SDK_INT)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CodecException - isTransient = ");
      localStringBuilder.append(paramCodecException.isTransient());
      localStringBuilder.append(" , isRecoverable = ");
      localStringBuilder.append(paramCodecException.isRecoverable());
      localStringBuilder.append(" , errorCode = ");
      localStringBuilder.append(paramCodecException.getErrorCode());
      Logger.e("EncoderWriter", localStringBuilder.toString());
    }
  }
  
  private void prepareAudioEncoder(ExportConfig paramExportConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AssetWriter prepareAudioEncoder ");
    localStringBuilder.append(this);
    Logger.d("EncoderWriter", localStringBuilder.toString());
    paramExportConfig = paramExportConfig.getAudioFormat();
    fixAudioFormat(paramExportConfig);
    paramExportConfig.setByteBuffer("csd-0", ByteBuffer.wrap(new byte[] { 0, 0 }));
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("prepareAudioEncoder: format = ");
      localStringBuilder.append(paramExportConfig);
      Logger.i("EncoderWriter", localStringBuilder.toString());
      this.audioEncoder = MediaCodecManager.createEncoderByType("audio/mp4a-latm");
      this.audioEncoder.configure(paramExportConfig, null, null, 1);
      return;
    }
    catch (Exception localException)
    {
      MediaCodecManager.releaseCodec(this.audioEncoder);
      throw new ExportRuntimeException(new ExportErrorStatus(-104, localException, paramExportConfig.toString()));
    }
  }
  
  private void prepareVideoEncoder(ExportConfig paramExportConfig)
  {
    String str = paramExportConfig.getOutputVideoMimeType();
    Object localObject = CodecHelper.correctSupportSize(paramExportConfig.getOutputSize(), str);
    this.outHeight = ((int)((CGSize)localObject).height);
    this.outWidth = ((int)((CGSize)localObject).width);
    localObject = paramExportConfig.getVideoFormat();
    fixVideoFormat((MediaFormat)localObject);
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("prepareVideoEncoder: format = ");
      localStringBuilder.append(localObject);
      Logger.i("EncoderWriter", localStringBuilder.toString());
      this.videoEncoder = MediaCodecManager.createEncoderByType(str);
      this.videoEncoder.configure((MediaFormat)localObject, null, null, 1);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("prepareVideoEncoder: 失败，准备重试。format = ");
      localStringBuilder.append(localObject);
      Logger.e("EncoderWriter", localStringBuilder.toString(), localException);
      retryPrepareVideoEncoder(paramExportConfig, (MediaFormat)localObject);
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
    Logger.e("EncoderWriter", "queueInputBuffer", localException);
    if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
    {
      MediaCodec.CodecException localCodecException = (MediaCodec.CodecException)localException;
      loggerCodecException(localCodecException);
      if (localCodecException.isTransient())
      {
        waitTime(20L);
        queueInputBuffer(paramMediaCodec, paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      }
    }
    throw localException;
  }
  
  @RequiresApi(api=18)
  private void release()
  {
    this.released = true;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("AssetWriter release: ");
    ((StringBuilder)localObject1).append(this);
    Logger.d("EncoderWriter", ((StringBuilder)localObject1).toString());
    try
    {
      this.lock.writeLock().lock();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("AssetWriter release ");
      ((StringBuilder)localObject1).append(this);
      Logger.d("EncoderWriter", ((StringBuilder)localObject1).toString());
      localObject1 = this.videoEncoder;
      if (localObject1 != null)
      {
        try
        {
          this.videoEncoder.stop();
        }
        catch (Exception localException1)
        {
          Logger.e("EncoderWriter", "release: videoEncoder.stop()", localException1);
        }
        try
        {
          MediaCodecManager.releaseCodec(this.videoEncoder);
        }
        catch (Exception localException2)
        {
          Logger.e("EncoderWriter", "release: videoEncoder.release()", localException2);
        }
        this.videoEncoder = null;
      }
      MediaCodec localMediaCodec = this.audioEncoder;
      if (localMediaCodec != null)
      {
        try
        {
          this.audioEncoder.stop();
        }
        catch (Exception localException3)
        {
          Logger.e("EncoderWriter", "release: audioEncoder.stop()", localException3);
        }
        try
        {
          MediaCodecManager.releaseCodec(this.audioEncoder);
        }
        catch (Exception localException4)
        {
          Logger.e("EncoderWriter", "release: audioEncoder.release()", localException4);
        }
        this.audioEncoder = null;
      }
      if (this.muxer != null)
      {
        if (this.muxerStarted)
        {
          this.muxerStarted = false;
          try
          {
            this.muxer.stop();
          }
          catch (Exception localException5)
          {
            Logger.e("EncoderWriter", "release: muxer.stop()", localException5);
          }
        }
        try
        {
          this.muxer.release();
        }
        catch (Exception localException6)
        {
          Logger.e("EncoderWriter", "release: muxer.release()", localException6);
        }
        this.muxer = null;
      }
      return;
    }
    finally
    {
      this.lock.writeLock().unlock();
    }
  }
  
  private void releaseOutputBuffer(MediaCodec paramMediaCodec, int paramInt, boolean paramBoolean)
  {
    try
    {
      paramMediaCodec.releaseOutputBuffer(paramInt, paramBoolean);
      return;
    }
    catch (Error localError) {}catch (Exception localException) {}
    Logger.e("EncoderWriter", "releaseOutputBuffer", localException);
    if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
    {
      MediaCodec.CodecException localCodecException = (MediaCodec.CodecException)localException;
      loggerCodecException(localCodecException);
      if (localCodecException.isTransient())
      {
        waitTime(20L);
        releaseOutputBuffer(paramMediaCodec, paramInt, paramBoolean);
      }
    }
    throw localException;
  }
  
  private void retryPrepareVideoEncoder(ExportConfig paramExportConfig, MediaFormat paramMediaFormat)
  {
    Object localObject = paramExportConfig.getOutputVideoMimeType();
    paramExportConfig = CodecHelper.correctSupportSize(paramExportConfig.getOutputSize(), (String)localObject, false);
    this.outWidth = ((int)paramExportConfig.width);
    this.outHeight = ((int)paramExportConfig.height);
    paramMediaFormat.setInteger("width", this.outWidth);
    paramMediaFormat.setInteger("height", this.outHeight);
    paramMediaFormat.setInteger("profile", 0);
    paramMediaFormat.setInteger("level", 0);
    try
    {
      this.videoEncoder = MediaCodecManager.createEncoderByType("video/avc");
      this.videoEncoder.configure(paramMediaFormat, null, null, 1);
      return;
    }
    catch (Exception paramExportConfig)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("prepareVideoEncoder: retry 失败 format = ");
      ((StringBuilder)localObject).append(paramMediaFormat);
      Logger.e("EncoderWriter", ((StringBuilder)localObject).toString(), paramExportConfig);
      MediaCodecManager.releaseCodec(this.videoEncoder);
      throw new ExportRuntimeException(new ExportErrorStatus(-103, paramExportConfig, paramMediaFormat.toString()));
    }
  }
  
  private void signalEndOfAudioStream()
  {
    try
    {
      if (this.enOfAudioInputStream) {
        return;
      }
      Logger.d("EncoderWriter", "signalEndOfAudioStream: ");
      int i = dequeueInputBuffer(this.audioEncoder);
      if (i >= 0)
      {
        queueInputBuffer(this.audioEncoder, i, 0, 0, 0L, 4);
        this.enOfAudioInputStream = true;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Logger.e("EncoderWriter", "signalEndOfAudioStream failed", localThrowable);
      localThrowable.printStackTrace();
    }
  }
  
  @RequiresApi(api=18)
  private void signalEndOfVideoStream()
  {
    Logger.d("EncoderWriter", "signalEndOfVideoStream: ");
    if (this._inputSurface != null)
    {
      if (this.enOfVideoInputStream) {
        return;
      }
      try
      {
        this.videoEncoder.signalEndOfInputStream();
        this.enOfVideoInputStream = true;
        return;
      }
      catch (Throwable localThrowable)
      {
        Logger.e("EncoderWriter", "signalEndOfVideoStream failed", localThrowable);
      }
    }
  }
  
  private boolean unStarted()
  {
    return (!this.muxerStarted) && ((!this.hasVideoTrack) || (this.videoEncodeFormat != null)) && ((!this.hasAudioTrack) || (this.audioEncodeFormat != null));
  }
  
  private boolean validAndCorrectBufferInfo(MediaCodec.BufferInfo paramBufferInfo)
  {
    return paramBufferInfo.size > 0;
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
      localInterruptedException.printStackTrace();
    }
  }
  
  @RequiresApi(api=18)
  private boolean writeAudioFrame(boolean paramBoolean)
  {
    try
    {
      this.audioEncoderLock.lock();
      boolean bool2 = this.muxerStarted;
      bool1 = true;
      if (!bool2) {
        if (this.audioEncodeFormat != null) {
          break label377;
        }
      }
      int i = dequeueOutputBuffer(this.audioEncoder, this.audioBufferInfo);
      if (i == -1)
      {
        if (paramBoolean) {
          break label386;
        }
        paramBoolean = bool1;
      }
      else
      {
        if (i == -2)
        {
          this.audioEncodeFormat = this.audioEncoder.getOutputFormat();
          break label386;
        }
        if (i < 0) {
          break label386;
        }
        Object localObject1 = getOutputBuffer(this.audioEncoder, i);
        if ((this.audioBufferInfo.flags & 0x2) != 0) {
          this.audioBufferInfo.size = 0;
        }
        if (Build.VERSION.SDK_INT >= 19)
        {
          ((ByteBuffer)localObject1).position(this.audioBufferInfo.offset);
          ((ByteBuffer)localObject1).limit(this.audioBufferInfo.offset + this.audioBufferInfo.size);
        }
        paramBoolean = validAndCorrectBufferInfo(this.audioBufferInfo);
        if (paramBoolean)
        {
          paramBoolean = this.muxerStarted;
          if (paramBoolean) {
            try
            {
              MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
              localBufferInfo.set(this.audioBufferInfo.offset, this.audioBufferInfo.size, this.audioBufferInfo.presentationTimeUs, this.audioBufferInfo.flags);
              this.muxer.writeSampleData(this.outputAudioTrack, (ByteBuffer)localObject1, localBufferInfo);
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("writeAudioFrame:  ");
              ((StringBuilder)localObject1).append(this.audioBufferInfo.presentationTimeUs);
              Logger.v("EncoderWriter", ((StringBuilder)localObject1).toString());
              this.audioPresentationTimeUs = this.audioBufferInfo.presentationTimeUs;
            }
            catch (Exception localException)
            {
              Logger.e("EncoderWriter", "writeAudioFrame: ", localException);
            }
          }
        }
        releaseOutputBuffer(this.audioEncoder, i, false);
        if ((this.audioBufferInfo.flags & 0x4) == 0) {
          break label386;
        }
        Logger.i("EncoderWriter", "writeAudioFrame: BUFFER_FLAG_END_OF_STREAM");
        this.audioPresentationTimeUs = -1L;
        this.hasAudioTrack = false;
        paramBoolean = bool1;
      }
    }
    finally
    {
      label386:
      for (;;)
      {
        boolean bool1;
        this.audioEncoderLock.unlock();
        for (;;)
        {
          throw localObject2;
        }
        label377:
        if (!paramBoolean) {
          paramBoolean = bool1;
        } else {
          paramBoolean = false;
        }
      }
    }
    this.audioEncoderLock.unlock();
    return paramBoolean;
  }
  
  /* Error */
  @RequiresApi(api=18)
  private boolean writeVideoFrame(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 93	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 462 1 0
    //   9: aload_0
    //   10: getfield 119	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   13: istore 5
    //   15: iconst_1
    //   16: istore 4
    //   18: iload 5
    //   20: ifne +13 -> 33
    //   23: aload_0
    //   24: getfield 111	com/tencent/tav/decoder/EncoderWriter:videoEncodeFormat	Landroid/media/MediaFormat;
    //   27: ifnonnull +535 -> 562
    //   30: goto +3 -> 33
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 435	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   38: aload_0
    //   39: getfield 107	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   42: invokespecial 185	com/tencent/tav/decoder/EncoderWriter:dequeueOutputBuffer	(Landroid/media/MediaCodec;Landroid/media/MediaCodec$BufferInfo;)I
    //   45: istore_2
    //   46: iload_2
    //   47: iconst_m1
    //   48: if_icmpne +13 -> 61
    //   51: iload_1
    //   52: ifne +520 -> 572
    //   55: iload 4
    //   57: istore_1
    //   58: goto +228 -> 286
    //   61: iload_2
    //   62: bipush 254
    //   64: if_icmpne +17 -> 81
    //   67: aload_0
    //   68: aload_0
    //   69: getfield 435	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   72: invokevirtual 534	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   75: putfield 111	com/tencent/tav/decoder/EncoderWriter:videoEncodeFormat	Landroid/media/MediaFormat;
    //   78: goto +494 -> 572
    //   81: iload_2
    //   82: iflt +490 -> 572
    //   85: aload_0
    //   86: aload_0
    //   87: getfield 435	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   90: iload_2
    //   91: invokespecial 326	com/tencent/tav/decoder/EncoderWriter:getOutputBuffer	(Landroid/media/MediaCodec;I)Ljava/nio/ByteBuffer;
    //   94: astore 6
    //   96: aload_0
    //   97: getfield 107	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   100: getfield 537	android/media/MediaCodec$BufferInfo:flags	I
    //   103: iconst_2
    //   104: iand
    //   105: ifeq +11 -> 116
    //   108: aload_0
    //   109: getfield 107	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   112: iconst_0
    //   113: putfield 525	android/media/MediaCodec$BufferInfo:size	I
    //   116: aload_0
    //   117: getfield 119	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   120: ifeq +121 -> 241
    //   123: aload_0
    //   124: aload_0
    //   125: getfield 107	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   128: invokespecial 549	com/tencent/tav/decoder/EncoderWriter:validAndCorrectBufferInfo	(Landroid/media/MediaCodec$BufferInfo;)Z
    //   131: ifeq +110 -> 241
    //   134: new 104	android/media/MediaCodec$BufferInfo
    //   137: dup
    //   138: invokespecial 105	android/media/MediaCodec$BufferInfo:<init>	()V
    //   141: astore 7
    //   143: aload 7
    //   145: aload_0
    //   146: getfield 107	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   149: getfield 540	android/media/MediaCodec$BufferInfo:offset	I
    //   152: aload_0
    //   153: getfield 107	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   156: getfield 525	android/media/MediaCodec$BufferInfo:size	I
    //   159: aload_0
    //   160: getfield 107	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   163: getfield 552	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   166: aload_0
    //   167: getfield 107	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   170: getfield 537	android/media/MediaCodec$BufferInfo:flags	I
    //   173: invokevirtual 556	android/media/MediaCodec$BufferInfo:set	(IIJI)V
    //   176: new 247	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   183: astore 8
    //   185: aload 8
    //   187: ldc_w 576
    //   190: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload 8
    //   196: aload 7
    //   198: invokestatic 582	com/tencent/tav/report/TAVReportUtils:a	(Landroid/media/MediaCodec$BufferInfo;)Ljava/lang/String;
    //   201: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: ldc 30
    //   207: aload 8
    //   209: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 266	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: aload_0
    //   216: getfield 132	com/tencent/tav/decoder/EncoderWriter:muxer	Landroid/media/MediaMuxer;
    //   219: aload_0
    //   220: getfield 115	com/tencent/tav/decoder/EncoderWriter:outputVideoTrack	I
    //   223: aload 6
    //   225: aload 7
    //   227: invokevirtual 560	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   230: aload_0
    //   231: aload_0
    //   232: getfield 107	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   235: getfield 552	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   238: putfield 584	com/tencent/tav/decoder/EncoderWriter:videoPresentationTimeUs	J
    //   241: aload_0
    //   242: aload_0
    //   243: getfield 435	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   246: iload_2
    //   247: iconst_0
    //   248: invokespecial 493	com/tencent/tav/decoder/EncoderWriter:releaseOutputBuffer	(Landroid/media/MediaCodec;IZ)V
    //   251: aload_0
    //   252: getfield 107	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   255: getfield 537	android/media/MediaCodec$BufferInfo:flags	I
    //   258: iconst_4
    //   259: iand
    //   260: ifeq +312 -> 572
    //   263: ldc 30
    //   265: ldc_w 586
    //   268: invokestatic 372	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload_0
    //   272: ldc2_w 36
    //   275: putfield 584	com/tencent/tav/decoder/EncoderWriter:videoPresentationTimeUs	J
    //   278: aload_0
    //   279: iconst_0
    //   280: putfield 82	com/tencent/tav/decoder/EncoderWriter:hasVideoTrack	Z
    //   283: iload 4
    //   285: istore_1
    //   286: aload_0
    //   287: getfield 93	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   290: invokeinterface 485 1 0
    //   295: iload_1
    //   296: ireturn
    //   297: astore 6
    //   299: goto +245 -> 544
    //   302: astore 6
    //   304: bipush 135
    //   306: istore_3
    //   307: iload_3
    //   308: istore_2
    //   309: getstatic 160	android/os/Build$VERSION:SDK_INT	I
    //   312: bipush 23
    //   314: if_icmplt +62 -> 376
    //   317: iload_3
    //   318: istore_2
    //   319: aload 6
    //   321: instanceof 162
    //   324: ifeq +52 -> 376
    //   327: new 247	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   334: astore 7
    //   336: aload 7
    //   338: ldc_w 588
    //   341: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload 7
    //   347: bipush 135
    //   349: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 7
    //   355: aload 6
    //   357: checkcast 162	android/media/MediaCodec$CodecException
    //   360: invokevirtual 342	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   363: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 7
    //   369: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 593	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   375: istore_2
    //   376: new 392	com/tencent/tav/core/ExportErrorStatus
    //   379: dup
    //   380: iload_2
    //   381: aload 6
    //   383: invokespecial 596	com/tencent/tav/core/ExportErrorStatus:<init>	(ILjava/lang/Throwable;)V
    //   386: astore 7
    //   388: new 247	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   395: astore 6
    //   397: aload 6
    //   399: ldc_w 598
    //   402: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload 6
    //   408: aload_0
    //   409: getfield 111	com/tencent/tav/decoder/EncoderWriter:videoEncodeFormat	Landroid/media/MediaFormat;
    //   412: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload 7
    //   418: aload 6
    //   420: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokevirtual 601	com/tencent/tav/core/ExportErrorStatus:appendMsg	(Ljava/lang/String;)V
    //   426: new 247	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   433: astore 6
    //   435: aload 6
    //   437: ldc_w 603
    //   440: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload 6
    //   446: aload_0
    //   447: getfield 435	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   450: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: aload 6
    //   456: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: ifnull +118 -> 577
    //   462: aload_0
    //   463: getfield 435	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   466: invokevirtual 606	android/media/MediaCodec:getName	()Ljava/lang/String;
    //   469: astore 6
    //   471: goto +3 -> 474
    //   474: aload 7
    //   476: aload 6
    //   478: invokevirtual 601	com/tencent/tav/core/ExportErrorStatus:appendMsg	(Ljava/lang/String;)V
    //   481: goto +15 -> 496
    //   484: astore 6
    //   486: ldc 30
    //   488: ldc_w 608
    //   491: aload 6
    //   493: invokestatic 155	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   496: new 247	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   503: astore 6
    //   505: aload 6
    //   507: ldc_w 610
    //   510: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload 6
    //   516: aload_0
    //   517: getfield 125	com/tencent/tav/decoder/EncoderWriter:released	Z
    //   520: invokevirtual 331	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload 7
    //   526: aload 6
    //   528: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokevirtual 601	com/tencent/tav/core/ExportErrorStatus:appendMsg	(Ljava/lang/String;)V
    //   534: new 390	com/tencent/tav/core/ExportRuntimeException
    //   537: dup
    //   538: aload 7
    //   540: invokespecial 399	com/tencent/tav/core/ExportRuntimeException:<init>	(Lcom/tencent/tav/core/ExportErrorStatus;)V
    //   543: athrow
    //   544: aload_0
    //   545: getfield 93	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   548: invokeinterface 485 1 0
    //   553: goto +6 -> 559
    //   556: aload 6
    //   558: athrow
    //   559: goto -3 -> 556
    //   562: iload_1
    //   563: ifne +9 -> 572
    //   566: iload 4
    //   568: istore_1
    //   569: goto -283 -> 286
    //   572: iconst_0
    //   573: istore_1
    //   574: goto -288 -> 286
    //   577: ldc_w 612
    //   580: astore 6
    //   582: goto -108 -> 474
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	585	0	this	EncoderWriter
    //   0	585	1	paramBoolean	boolean
    //   45	336	2	i	int
    //   306	12	3	j	int
    //   16	551	4	bool1	boolean
    //   13	6	5	bool2	boolean
    //   94	130	6	localByteBuffer	ByteBuffer
    //   297	1	6	localObject1	Object
    //   302	80	6	localThrowable	Throwable
    //   395	82	6	localObject2	Object
    //   484	8	6	localException	Exception
    //   503	78	6	localObject3	Object
    //   141	398	7	localObject4	Object
    //   183	25	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	15	297	finally
    //   23	30	297	finally
    //   33	46	297	finally
    //   67	78	297	finally
    //   85	116	297	finally
    //   116	241	297	finally
    //   241	283	297	finally
    //   309	317	297	finally
    //   319	376	297	finally
    //   376	426	297	finally
    //   426	471	297	finally
    //   474	481	297	finally
    //   486	496	297	finally
    //   496	544	297	finally
    //   0	15	302	java/lang/Throwable
    //   23	30	302	java/lang/Throwable
    //   33	46	302	java/lang/Throwable
    //   67	78	302	java/lang/Throwable
    //   85	116	302	java/lang/Throwable
    //   116	241	302	java/lang/Throwable
    //   241	283	302	java/lang/Throwable
    //   426	471	484	java/lang/Exception
    //   474	481	484	java/lang/Exception
  }
  
  public boolean audioTrackWritable()
  {
    boolean bool1 = this.hasAudioTrack;
    boolean bool2 = true;
    if ((bool1) && ((this.muxerStarted) || (this.audioEncodeFormat == null))) {
      return true;
    }
    for (;;)
    {
      try
      {
        if (this.hasAudioTrack)
        {
          bool1 = bool2;
          if (!this.muxerStarted)
          {
            if (this.audioEncodeFormat != null) {
              break label66;
            }
            bool1 = bool2;
          }
          return bool1;
        }
      }
      finally {}
      label66:
      bool1 = false;
    }
  }
  
  @RequiresApi(api=18)
  public Surface createInputSurface()
  {
    try
    {
      if ((this._inputSurface == null) && (this.hasVideoTrack)) {
        this._inputSurface = this.videoEncoder.createInputSurface();
      }
      Surface localSurface = this._inputSurface;
      return localSurface;
    }
    finally {}
  }
  
  @RequiresApi(api=18)
  public void endWriteAudioSample()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("endWriteAudioSample:");
    localStringBuilder.append(this);
    Logger.d("EncoderWriter", localStringBuilder.toString());
    try
    {
      this.lock.readLock().lock();
      if ((!this.released) && (!this.enOfAudioInputStream))
      {
        Logger.d("EncoderWriter", "endWriteAudioSample: ");
        try
        {
          int i = dequeueInputBuffer(this.audioEncoder);
          if (i >= 0)
          {
            queueInputBuffer(this.audioEncoder, i, 0, 0, 0L, 4);
            this.enOfAudioInputStream = true;
          }
        }
        catch (Throwable localThrowable)
        {
          Logger.e("EncoderWriter", "endWriteAudioSample failed", localThrowable);
        }
        drainEncoder(false);
        return;
      }
      return;
    }
    finally
    {
      this.lock.readLock().unlock();
    }
  }
  
  @RequiresApi(api=18)
  public void endWriteVideoSample()
  {
    Logger.d("EncoderWriter", "endWriteVideoSample: ");
    try
    {
      this.lock.readLock().lock();
      boolean bool = this.released;
      if (bool) {}
      do
      {
        do
        {
          this.lock.readLock().unlock();
          return;
        } while (this._inputSurface == null);
        bool = this.enOfVideoInputStream;
      } while (bool);
      try
      {
        this.videoEncoder.signalEndOfInputStream();
        this.enOfVideoInputStream = true;
      }
      catch (Throwable localThrowable)
      {
        Logger.e("EncoderWriter", "endWriteVideoSample failed", localThrowable);
      }
      drainEncoder(false);
      this.lock.readLock().unlock();
      return;
    }
    finally
    {
      this.lock.readLock().unlock();
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public long getAudioPresentationTimeUs()
  {
    return this.audioPresentationTimeUs;
  }
  
  public int getOutHeight()
  {
    return this.outHeight;
  }
  
  public int getOutWidth()
  {
    return this.outWidth;
  }
  
  public long getVideoPresentationTimeUs()
  {
    return this.videoPresentationTimeUs;
  }
  
  public void setEncodeOption(@NonNull ExportConfig paramExportConfig)
  {
    if ((paramExportConfig.getOutputWidth() > 0) && (paramExportConfig.getOutputHeight() > 0))
    {
      this.encodeOption = paramExportConfig.clone();
      return;
    }
    throw new IllegalArgumentException("width and height must > 0");
  }
  
  /* Error */
  public void startAudioEncoder()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 95	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 462 1 0
    //   11: new 247	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   18: astore_1
    //   19: aload_1
    //   20: ldc_w 662
    //   23: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_1
    //   28: aload_0
    //   29: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: ldc 30
    //   35: aload_1
    //   36: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 266	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_0
    //   43: aload_0
    //   44: getfield 652	com/tencent/tav/decoder/EncoderWriter:encodeOption	Lcom/tencent/tav/core/ExportConfig;
    //   47: invokespecial 664	com/tencent/tav/decoder/EncoderWriter:prepareAudioEncoder	(Lcom/tencent/tav/core/ExportConfig;)V
    //   50: aload_0
    //   51: iconst_1
    //   52: putfield 84	com/tencent/tav/decoder/EncoderWriter:hasAudioTrack	Z
    //   55: aload_0
    //   56: getfield 380	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   59: invokevirtual 665	android/media/MediaCodec:start	()V
    //   62: aload_0
    //   63: iconst_1
    //   64: putfield 123	com/tencent/tav/decoder/EncoderWriter:audioEncoderStarted	Z
    //   67: aload_0
    //   68: getfield 95	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   71: invokeinterface 485 1 0
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: astore_1
    //   80: aload_0
    //   81: getfield 95	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   84: invokeinterface 485 1 0
    //   89: aload_1
    //   90: athrow
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	EncoderWriter
    //   18	18	1	localStringBuilder	StringBuilder
    //   79	11	1	localObject1	Object
    //   91	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	67	79	finally
    //   67	76	91	finally
    //   80	91	91	finally
  }
  
  /* Error */
  @RequiresApi(api=18)
  public void startVideoEncoder()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 93	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 462 1 0
    //   11: new 247	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   18: astore_1
    //   19: aload_1
    //   20: ldc_w 668
    //   23: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_1
    //   28: aload_0
    //   29: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: ldc 30
    //   35: aload_1
    //   36: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 266	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_0
    //   43: aload_0
    //   44: getfield 652	com/tencent/tav/decoder/EncoderWriter:encodeOption	Lcom/tencent/tav/core/ExportConfig;
    //   47: invokespecial 670	com/tencent/tav/decoder/EncoderWriter:prepareVideoEncoder	(Lcom/tencent/tav/core/ExportConfig;)V
    //   50: aload_0
    //   51: iconst_1
    //   52: putfield 82	com/tencent/tav/decoder/EncoderWriter:hasVideoTrack	Z
    //   55: aload_0
    //   56: invokevirtual 671	com/tencent/tav/decoder/EncoderWriter:createInputSurface	()Landroid/view/Surface;
    //   59: pop
    //   60: aload_0
    //   61: getfield 435	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   64: invokevirtual 665	android/media/MediaCodec:start	()V
    //   67: aload_0
    //   68: iconst_1
    //   69: putfield 121	com/tencent/tav/decoder/EncoderWriter:videoEncoderStarted	Z
    //   72: aload_0
    //   73: getfield 93	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   76: invokeinterface 485 1 0
    //   81: aload_0
    //   82: monitorexit
    //   83: return
    //   84: astore_1
    //   85: aload_0
    //   86: getfield 93	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   89: invokeinterface 485 1 0
    //   94: aload_1
    //   95: athrow
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	EncoderWriter
    //   18	18	1	localStringBuilder	StringBuilder
    //   84	11	1	localObject1	Object
    //   96	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	72	84	finally
    //   72	81	96	finally
    //   85	96	96	finally
  }
  
  @RequiresApi(api=18)
  public void stop()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AssetWriter stop ");
    localStringBuilder.append(this);
    Logger.d("EncoderWriter", localStringBuilder.toString());
    if (this.released) {
      return;
    }
    if ((!this.videoEncoderStarted) && (!this.audioEncoderStarted)) {
      return;
    }
    this.videoEncoderStarted = false;
    this.audioEncoderStarted = false;
    drainEncoder(true);
    release();
  }
  
  public boolean videoTrackWritable()
  {
    boolean bool1 = this.hasVideoTrack;
    boolean bool2 = true;
    if ((bool1) && ((this.muxerStarted) || (this.videoEncodeFormat == null))) {
      return true;
    }
    for (;;)
    {
      try
      {
        if (this.hasVideoTrack)
        {
          bool1 = bool2;
          if (!this.muxerStarted)
          {
            if (this.videoEncodeFormat != null) {
              break label66;
            }
            bool1 = bool2;
          }
          return bool1;
        }
      }
      finally {}
      label66:
      bool1 = false;
    }
  }
  
  /* Error */
  @RequiresApi(api=18)
  public void writeAudioSample(long paramLong, ByteBuffer paramByteBuffer)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 100	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   4: invokeinterface 623 1 0
    //   9: invokeinterface 462 1 0
    //   14: new 247	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   21: astore 15
    //   23: aload 15
    //   25: ldc_w 679
    //   28: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 15
    //   34: lload_1
    //   35: invokevirtual 565	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 15
    //   41: ldc_w 681
    //   44: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_3
    //   49: ifnull +341 -> 390
    //   52: aload_3
    //   53: invokevirtual 683	java/nio/ByteBuffer:limit	()I
    //   56: invokestatic 687	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: astore 14
    //   61: goto +3 -> 64
    //   64: aload 15
    //   66: aload 14
    //   68: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: ldc 30
    //   74: aload 15
    //   76: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 568	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: aload_3
    //   83: ifnull +245 -> 328
    //   86: aload_0
    //   87: getfield 125	com/tencent/tav/decoder/EncoderWriter:released	Z
    //   90: ifeq +6 -> 96
    //   93: goto +235 -> 328
    //   96: aload_3
    //   97: invokevirtual 689	java/nio/ByteBuffer:position	()I
    //   100: istore 4
    //   102: aload_3
    //   103: invokevirtual 683	java/nio/ByteBuffer:limit	()I
    //   106: istore 6
    //   108: lconst_0
    //   109: lstore 9
    //   111: iload 4
    //   113: iload 6
    //   115: if_icmpge +185 -> 300
    //   118: aload_0
    //   119: getfield 125	com/tencent/tav/decoder/EncoderWriter:released	Z
    //   122: istore 13
    //   124: iload 13
    //   126: ifne +174 -> 300
    //   129: aload_0
    //   130: getfield 95	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   133: invokeinterface 462 1 0
    //   138: aload_0
    //   139: aload_0
    //   140: getfield 380	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   143: invokespecial 176	com/tencent/tav/decoder/EncoderWriter:dequeueInputBuffer	(Landroid/media/MediaCodec;)I
    //   146: istore 7
    //   148: iload 4
    //   150: istore 5
    //   152: lload 9
    //   154: lstore 11
    //   156: iload 7
    //   158: iflt +105 -> 263
    //   161: aload_0
    //   162: aload_0
    //   163: getfield 380	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   166: iload 7
    //   168: invokespecial 321	com/tencent/tav/decoder/EncoderWriter:getInputBuffer	(Landroid/media/MediaCodec;I)Ljava/nio/ByteBuffer;
    //   171: astore 14
    //   173: iload 6
    //   175: iload 4
    //   177: isub
    //   178: aload 14
    //   180: invokevirtual 692	java/nio/ByteBuffer:capacity	()I
    //   183: invokestatic 698	java/lang/Math:min	(II)I
    //   186: istore 8
    //   188: iload 4
    //   190: iload 8
    //   192: iadd
    //   193: istore 5
    //   195: aload_3
    //   196: iload 5
    //   198: invokevirtual 547	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   201: pop
    //   202: aload_3
    //   203: iload 4
    //   205: invokevirtual 544	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   208: pop
    //   209: aload 14
    //   211: aload_3
    //   212: invokevirtual 702	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   215: pop
    //   216: aload_0
    //   217: aload_0
    //   218: getfield 380	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   221: iload 7
    //   223: iconst_0
    //   224: iload 8
    //   226: lload_1
    //   227: lload 9
    //   229: ladd
    //   230: iconst_0
    //   231: invokespecial 449	com/tencent/tav/decoder/EncoderWriter:queueInputBuffer	(Landroid/media/MediaCodec;IIIJI)V
    //   234: iload 8
    //   236: i2l
    //   237: aload_0
    //   238: getfield 652	com/tencent/tav/decoder/EncoderWriter:encodeOption	Lcom/tencent/tav/core/ExportConfig;
    //   241: invokevirtual 705	com/tencent/tav/core/ExportConfig:getAudioChannelCount	()I
    //   244: aload_0
    //   245: getfield 652	com/tencent/tav/decoder/EncoderWriter:encodeOption	Lcom/tencent/tav/core/ExportConfig;
    //   248: invokevirtual 708	com/tencent/tav/core/ExportConfig:getAudioSampleRateHz	()I
    //   251: invokestatic 712	com/tencent/tav/decoder/DecoderUtils:getAudioDuration	(JII)J
    //   254: lstore 11
    //   256: lload 9
    //   258: lload 11
    //   260: ladd
    //   261: lstore 11
    //   263: aload_0
    //   264: getfield 95	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   267: invokeinterface 485 1 0
    //   272: aload_0
    //   273: iconst_0
    //   274: invokespecial 629	com/tencent/tav/decoder/EncoderWriter:drainEncoder	(Z)V
    //   277: iload 5
    //   279: istore 4
    //   281: lload 11
    //   283: lstore 9
    //   285: goto -174 -> 111
    //   288: astore_3
    //   289: aload_0
    //   290: getfield 95	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   293: invokeinterface 485 1 0
    //   298: aload_3
    //   299: athrow
    //   300: aload_3
    //   301: iconst_0
    //   302: invokevirtual 544	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   305: pop
    //   306: aload_3
    //   307: iload 6
    //   309: invokevirtual 547	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   312: pop
    //   313: aload_0
    //   314: getfield 100	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   317: invokeinterface 623 1 0
    //   322: invokeinterface 485 1 0
    //   327: return
    //   328: aload_0
    //   329: getfield 100	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   332: invokeinterface 623 1 0
    //   337: invokeinterface 485 1 0
    //   342: return
    //   343: astore_3
    //   344: goto +24 -> 368
    //   347: astore_3
    //   348: aload_3
    //   349: instanceof 390
    //   352: ifeq +5 -> 357
    //   355: aload_3
    //   356: athrow
    //   357: new 390	com/tencent/tav/core/ExportRuntimeException
    //   360: dup
    //   361: bipush 134
    //   363: aload_3
    //   364: invokespecial 713	com/tencent/tav/core/ExportRuntimeException:<init>	(ILjava/lang/Throwable;)V
    //   367: athrow
    //   368: aload_0
    //   369: getfield 100	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   372: invokeinterface 623 1 0
    //   377: invokeinterface 485 1 0
    //   382: goto +5 -> 387
    //   385: aload_3
    //   386: athrow
    //   387: goto -2 -> 385
    //   390: ldc_w 612
    //   393: astore 14
    //   395: goto -331 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	this	EncoderWriter
    //   0	398	1	paramLong	long
    //   0	398	3	paramByteBuffer	ByteBuffer
    //   100	180	4	i	int
    //   150	128	5	j	int
    //   106	202	6	k	int
    //   146	76	7	m	int
    //   186	49	8	n	int
    //   109	175	9	l1	long
    //   154	128	11	l2	long
    //   122	3	13	bool	boolean
    //   59	335	14	localObject	Object
    //   21	54	15	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   129	148	288	finally
    //   161	188	288	finally
    //   195	256	288	finally
    //   0	48	343	finally
    //   52	61	343	finally
    //   64	82	343	finally
    //   86	93	343	finally
    //   96	108	343	finally
    //   118	124	343	finally
    //   263	277	343	finally
    //   289	300	343	finally
    //   300	313	343	finally
    //   348	357	343	finally
    //   357	368	343	finally
    //   0	48	347	java/lang/Throwable
    //   52	61	347	java/lang/Throwable
    //   64	82	347	java/lang/Throwable
    //   86	93	347	java/lang/Throwable
    //   96	108	347	java/lang/Throwable
    //   118	124	347	java/lang/Throwable
    //   263	277	347	java/lang/Throwable
    //   289	300	347	java/lang/Throwable
    //   300	313	347	java/lang/Throwable
  }
  
  @RequiresApi(api=18)
  public void writeVideoSample()
  {
    try
    {
      this.lock.readLock().lock();
      Surface localSurface = this._inputSurface;
      if (localSurface == null) {
        return;
      }
      drainEncoder(false);
      return;
    }
    finally
    {
      this.lock.readLock().unlock();
    }
  }
  
  @RequiresApi(api=18)
  public void writeVideoSample(long paramLong, ByteBuffer paramByteBuffer)
  {
    if (this._inputSurface != null) {
      return;
    }
    int i = 1;
    while (i != 0) {
      try
      {
        this.videoEncoderLock.lock();
        int j = dequeueInputBuffer(this.videoEncoder);
        if (j >= 0)
        {
          ByteBuffer localByteBuffer = getInputBuffer(this.videoEncoder, j);
          i = paramByteBuffer.limit();
          int k = paramByteBuffer.position();
          localByteBuffer.put(paramByteBuffer);
          queueInputBuffer(this.videoEncoder, j, 0, i - k, paramLong, 0);
          i = 0;
        }
        this.videoEncoderLock.unlock();
        drainEncoder(false);
      }
      finally
      {
        this.videoEncoderLock.unlock();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.EncoderWriter
 * JD-Core Version:    0.7.0.1
 */