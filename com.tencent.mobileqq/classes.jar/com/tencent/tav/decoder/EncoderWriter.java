package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.core.ExportRuntimeException;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory.MediaMuxerCreator;
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
  private IMediaMuxer muxer;
  private volatile boolean muxerStarted = false;
  private volatile int outputAudioTrack = -1;
  private volatile int outputVideoTrack = -1;
  private boolean released = false;
  private volatile MediaCodec.BufferInfo videoBufferInfo = new MediaCodec.BufferInfo();
  private volatile MediaFormat videoEncodeFormat = null;
  private AssetWriterVideoEncoder videoEncoder;
  private Lock videoEncoderLock = new ReentrantLock();
  private boolean videoEncoderStarted = false;
  
  @RequiresApi(api=18)
  public EncoderWriter(String paramString)
  {
    this(paramString, null, null);
  }
  
  @RequiresApi(api=18)
  public EncoderWriter(String paramString, AssetWriterVideoEncoder paramAssetWriterVideoEncoder, MediaMuxerFactory.MediaMuxerCreator paramMediaMuxerCreator)
  {
    Object localObject = paramAssetWriterVideoEncoder;
    if (paramAssetWriterVideoEncoder == null) {
      localObject = new MediaCodecAssetWriterVideoEncoder();
    }
    paramAssetWriterVideoEncoder = paramMediaMuxerCreator;
    if (paramMediaMuxerCreator == null) {
      paramAssetWriterVideoEncoder = MediaMuxerFactory.getMuxerCreator();
    }
    this.muxer = paramAssetWriterVideoEncoder.createMediaMuxer(paramString, 0);
    this.videoEncoder = ((AssetWriterVideoEncoder)localObject);
    this.videoEncoder.setMediaMuxer(this.muxer);
  }
  
  @RequiresApi(api=18)
  private Surface createInputSurface()
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
  private void drainEncoder(boolean paramBoolean, CMSampleBuffer paramCMSampleBuffer, TextureInfo paramTextureInfo)
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
    long l1 = System.currentTimeMillis();
    boolean bool5 = bool1;
    while (((!bool6) && (this.hasVideoTrack)) || ((!bool3) && (this.hasAudioTrack)))
    {
      int j = i;
      if (i != 0)
      {
        signalEndOfVideoStream();
        j = 0;
      }
      long l2;
      StringBuilder localStringBuilder;
      if (!bool6)
      {
        bool1 = writeVideoFrame(paramCMSampleBuffer, paramTextureInfo, paramBoolean);
        l2 = System.currentTimeMillis() - l1;
        if (l2 > 2000L)
        {
          this.hasVideoTrack = (paramBoolean ^ true);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("drainEncoder: 视频写入处理时间超时，提前结束写入， timeCons = ");
          localStringBuilder.append(l2);
          Logger.e("EncoderWriter", localStringBuilder.toString());
          bool1 = true;
        }
      }
      else
      {
        bool1 = bool6;
      }
      boolean bool4 = bool5;
      if (bool5)
      {
        signalEndOfAudioStream();
        bool4 = false;
      }
      boolean bool2 = bool3;
      if (!bool3)
      {
        Logger.d("EncoderWriter", "drainEncoder: writeAudioFrame");
        bool2 = writeAudioFrame(paramBoolean);
        l2 = System.currentTimeMillis() - l1;
        if (l2 > 2000L)
        {
          this.hasAudioTrack = (paramBoolean ^ true);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("drainEncoder: 音频写入处理时间超时，提前结束写入, timeCons = ");
          localStringBuilder.append(l2);
          Logger.e("EncoderWriter", localStringBuilder.toString());
          bool2 = true;
        }
      }
      i = j;
      bool5 = bool4;
      bool6 = bool1;
      bool3 = bool2;
      if (unStarted()) {
        try
        {
          if (unStarted())
          {
            if ((this.hasVideoTrack) && ((this.videoEncoder instanceof MediaCodecAssetWriterVideoEncoder))) {
              this.outputVideoTrack = this.muxer.addTrack(this.videoEncodeFormat);
            }
            if (this.hasAudioTrack) {
              this.outputAudioTrack = this.muxer.addTrack(this.audioEncodeFormat);
            }
            this.muxer.start();
            this.muxerStarted = true;
          }
          i = j;
          bool5 = bool4;
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
    MediaFormat localMediaFormat = paramExportConfig.getVideoFormat();
    fixVideoFormat(localMediaFormat);
    this.videoEncoder.prepare(paramExportConfig, localMediaFormat);
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
          this.videoEncoder.release();
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
      Surface localSurface = this._inputSurface;
      if (localSurface != null)
      {
        try
        {
          this._inputSurface.release();
        }
        catch (Exception localException7)
        {
          Logger.e("EncoderWriter", "release: _inputSurface.release()", localException7);
        }
        this._inputSurface = null;
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
          break label391;
        }
      }
      int i = dequeueOutputBuffer(this.audioEncoder, this.audioBufferInfo);
      if (i == -1)
      {
        if (paramBoolean) {
          break label400;
        }
        paramBoolean = bool1;
      }
      else
      {
        if (i == -2)
        {
          this.audioEncodeFormat = this.audioEncoder.getOutputFormat();
          break label400;
        }
        if (i < 0) {
          break label400;
        }
        Object localObject1 = getOutputBuffer(this.audioEncoder, i);
        if (((this.audioBufferInfo.flags & 0x2) != 0) && (this.muxer.ignoreHeader())) {
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
          break label400;
        }
        Logger.i("EncoderWriter", "writeAudioFrame: BUFFER_FLAG_END_OF_STREAM");
        this.audioPresentationTimeUs = -1L;
        this.hasAudioTrack = false;
        paramBoolean = bool1;
      }
    }
    finally
    {
      for (;;)
      {
        boolean bool1;
        this.audioEncoderLock.unlock();
        for (;;)
        {
          throw localObject2;
        }
        label391:
        if (!paramBoolean) {
          paramBoolean = bool1;
        } else {
          label400:
          paramBoolean = false;
        }
      }
    }
    this.audioEncoderLock.unlock();
    return paramBoolean;
  }
  
  /* Error */
  @RequiresApi(api=18)
  private boolean writeVideoFrame(CMSampleBuffer paramCMSampleBuffer, TextureInfo paramTextureInfo, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 96	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 462 1 0
    //   9: aload_0
    //   10: getfield 147	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   13: aload_1
    //   14: aload_2
    //   15: iload_3
    //   16: invokeinterface 573 4 0
    //   21: istore_3
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 147	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   27: invokeinterface 576 1 0
    //   32: putfield 114	com/tencent/tav/decoder/EncoderWriter:videoEncodeFormat	Landroid/media/MediaFormat;
    //   35: aload_0
    //   36: getfield 147	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   39: invokeinterface 579 1 0
    //   44: ifeq +8 -> 52
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 85	com/tencent/tav/decoder/EncoderWriter:hasVideoTrack	Z
    //   52: aload_0
    //   53: getfield 96	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   56: invokeinterface 492 1 0
    //   61: iload_3
    //   62: ireturn
    //   63: astore_1
    //   64: goto +224 -> 288
    //   67: astore_1
    //   68: bipush 135
    //   70: istore 5
    //   72: iload 5
    //   74: istore 4
    //   76: getstatic 183	android/os/Build$VERSION:SDK_INT	I
    //   79: bipush 23
    //   81: if_icmplt +58 -> 139
    //   84: iload 5
    //   86: istore 4
    //   88: aload_1
    //   89: instanceof 185
    //   92: ifeq +47 -> 139
    //   95: new 227	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   102: astore_2
    //   103: aload_2
    //   104: ldc_w 581
    //   107: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_2
    //   112: bipush 135
    //   114: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_2
    //   119: aload_1
    //   120: checkcast 185	android/media/MediaCodec$CodecException
    //   123: invokevirtual 374	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   126: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_2
    //   131: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 586	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   137: istore 4
    //   139: new 424	com/tencent/tav/core/ExportErrorStatus
    //   142: dup
    //   143: iload 4
    //   145: aload_1
    //   146: invokespecial 589	com/tencent/tav/core/ExportErrorStatus:<init>	(ILjava/lang/Throwable;)V
    //   149: astore_2
    //   150: new 227	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   157: astore_1
    //   158: aload_1
    //   159: ldc_w 591
    //   162: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload_1
    //   167: aload_0
    //   168: getfield 114	com/tencent/tav/decoder/EncoderWriter:videoEncodeFormat	Landroid/media/MediaFormat;
    //   171: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_2
    //   176: aload_1
    //   177: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokevirtual 594	com/tencent/tav/core/ExportErrorStatus:appendMsg	(Ljava/lang/String;)V
    //   183: new 227	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   190: astore_1
    //   191: aload_1
    //   192: ldc_w 596
    //   195: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_1
    //   200: aload_0
    //   201: getfield 147	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   204: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload_1
    //   209: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: ifnull +87 -> 299
    //   215: aload_0
    //   216: getfield 147	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   219: invokeinterface 599 1 0
    //   224: astore_1
    //   225: goto +3 -> 228
    //   228: aload_2
    //   229: aload_1
    //   230: invokevirtual 594	com/tencent/tav/core/ExportErrorStatus:appendMsg	(Ljava/lang/String;)V
    //   233: goto +13 -> 246
    //   236: astore_1
    //   237: ldc 30
    //   239: ldc_w 601
    //   242: aload_1
    //   243: invokestatic 178	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   246: new 227	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   253: astore_1
    //   254: aload_1
    //   255: ldc_w 603
    //   258: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload_1
    //   263: aload_0
    //   264: getfield 128	com/tencent/tav/decoder/EncoderWriter:released	Z
    //   267: invokevirtual 363	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload_2
    //   272: aload_1
    //   273: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokevirtual 594	com/tencent/tav/core/ExportErrorStatus:appendMsg	(Ljava/lang/String;)V
    //   279: new 422	com/tencent/tav/core/ExportRuntimeException
    //   282: dup
    //   283: aload_2
    //   284: invokespecial 431	com/tencent/tav/core/ExportRuntimeException:<init>	(Lcom/tencent/tav/core/ExportErrorStatus;)V
    //   287: athrow
    //   288: aload_0
    //   289: getfield 96	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   292: invokeinterface 492 1 0
    //   297: aload_1
    //   298: athrow
    //   299: ldc_w 605
    //   302: astore_1
    //   303: goto -75 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	EncoderWriter
    //   0	306	1	paramCMSampleBuffer	CMSampleBuffer
    //   0	306	2	paramTextureInfo	TextureInfo
    //   0	306	3	paramBoolean	boolean
    //   74	70	4	i	int
    //   70	15	5	j	int
    // Exception table:
    //   from	to	target	type
    //   0	52	63	finally
    //   76	84	63	finally
    //   88	139	63	finally
    //   139	183	63	finally
    //   183	225	63	finally
    //   228	233	63	finally
    //   237	246	63	finally
    //   246	288	63	finally
    //   0	52	67	java/lang/Throwable
    //   183	225	236	java/lang/Exception
    //   228	233	236	java/lang/Exception
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
  public RenderContext createRenderContext(int paramInt1, int paramInt2)
  {
    return new RenderContext(paramInt1, paramInt2, createInputSurface());
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
        drainEncoder(false, null, null);
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
  public void endWriteVideoSample(CMSampleBuffer paramCMSampleBuffer, TextureInfo paramTextureInfo)
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
      drainEncoder(false, paramCMSampleBuffer, paramTextureInfo);
      this.lock.readLock().unlock();
      return;
    }
    finally
    {
      this.lock.readLock().unlock();
    }
    for (;;)
    {
      throw paramCMSampleBuffer;
    }
  }
  
  public long getAudioPresentationTimeUs()
  {
    return this.audioPresentationTimeUs;
  }
  
  public int getOutHeight()
  {
    return (int)this.videoEncoder.getEncodeSize().height;
  }
  
  public int getOutWidth()
  {
    return (int)this.videoEncoder.getEncodeSize().width;
  }
  
  public AssetWriterVideoEncoder getVideoEncoder()
  {
    return this.videoEncoder;
  }
  
  public long getVideoPresentationTimeUs()
  {
    AssetWriterVideoEncoder localAssetWriterVideoEncoder = this.videoEncoder;
    if (localAssetWriterVideoEncoder == null) {
      return 0L;
    }
    return localAssetWriterVideoEncoder.getEncodePresentationTimeUs();
  }
  
  public boolean isVideoEncodeNeedVideoRenderOutputTexture()
  {
    return this.videoEncoder.isNeedVideoOutputTexture();
  }
  
  public void setEncodeOption(@NonNull ExportConfig paramExportConfig)
  {
    if ((paramExportConfig.getOutputWidth() > 0) && (paramExportConfig.getOutputHeight() > 0))
    {
      this.encodeOption = paramExportConfig.clone();
      IMediaMuxer localIMediaMuxer = this.muxer;
      if (localIMediaMuxer != null) {
        localIMediaMuxer.setExportConfig(paramExportConfig);
      }
      return;
    }
    throw new IllegalArgumentException("width and height must > 0");
  }
  
  public void setVideoSampleRenderContext(RenderContext paramRenderContext)
  {
    this.videoEncoder.setVideoSampleRenderContext(paramRenderContext);
  }
  
  /* Error */
  public void startAudioEncoder()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 98	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 462 1 0
    //   11: new 227	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   18: astore_1
    //   19: aload_1
    //   20: ldc_w 689
    //   23: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_1
    //   28: aload_0
    //   29: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: ldc 30
    //   35: aload_1
    //   36: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 252	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_0
    //   43: aload_0
    //   44: getfield 672	com/tencent/tav/decoder/EncoderWriter:encodeOption	Lcom/tencent/tav/core/ExportConfig;
    //   47: invokespecial 691	com/tencent/tav/decoder/EncoderWriter:prepareAudioEncoder	(Lcom/tencent/tav/core/ExportConfig;)V
    //   50: aload_0
    //   51: iconst_1
    //   52: putfield 87	com/tencent/tav/decoder/EncoderWriter:hasAudioTrack	Z
    //   55: aload_0
    //   56: getfield 412	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   59: invokevirtual 692	android/media/MediaCodec:start	()V
    //   62: aload_0
    //   63: iconst_1
    //   64: putfield 126	com/tencent/tav/decoder/EncoderWriter:audioEncoderStarted	Z
    //   67: aload_0
    //   68: getfield 98	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   71: invokeinterface 492 1 0
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: astore_1
    //   80: aload_0
    //   81: getfield 98	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   84: invokeinterface 492 1 0
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
    //   3: getfield 96	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 462 1 0
    //   11: new 227	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   18: astore_1
    //   19: aload_1
    //   20: ldc_w 695
    //   23: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_1
    //   28: aload_0
    //   29: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: ldc 30
    //   35: aload_1
    //   36: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 252	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_0
    //   43: aload_0
    //   44: getfield 672	com/tencent/tav/decoder/EncoderWriter:encodeOption	Lcom/tencent/tav/core/ExportConfig;
    //   47: invokespecial 697	com/tencent/tav/decoder/EncoderWriter:prepareVideoEncoder	(Lcom/tencent/tav/core/ExportConfig;)V
    //   50: aload_0
    //   51: iconst_1
    //   52: putfield 85	com/tencent/tav/decoder/EncoderWriter:hasVideoTrack	Z
    //   55: aload_0
    //   56: invokespecial 611	com/tencent/tav/decoder/EncoderWriter:createInputSurface	()Landroid/view/Surface;
    //   59: pop
    //   60: aload_0
    //   61: getfield 147	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   64: invokeinterface 699 1 0
    //   69: pop
    //   70: aload_0
    //   71: iconst_1
    //   72: putfield 124	com/tencent/tav/decoder/EncoderWriter:videoEncoderStarted	Z
    //   75: aload_0
    //   76: getfield 96	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   79: invokeinterface 492 1 0
    //   84: aload_0
    //   85: monitorexit
    //   86: return
    //   87: astore_1
    //   88: aload_0
    //   89: getfield 96	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   92: invokeinterface 492 1 0
    //   97: aload_1
    //   98: athrow
    //   99: astore_1
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	EncoderWriter
    //   18	18	1	localStringBuilder	StringBuilder
    //   87	11	1	localObject1	Object
    //   99	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	75	87	finally
    //   75	84	99	finally
    //   88	99	99	finally
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
    drainEncoder(true, null, null);
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
    //   1: getfield 103	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   4: invokeinterface 620 1 0
    //   9: invokeinterface 462 1 0
    //   14: new 227	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   21: astore 15
    //   23: aload 15
    //   25: ldc_w 707
    //   28: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 15
    //   34: lload_1
    //   35: invokevirtual 237	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 15
    //   41: ldc_w 709
    //   44: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_3
    //   49: ifnull +343 -> 392
    //   52: aload_3
    //   53: invokevirtual 711	java/nio/ByteBuffer:limit	()I
    //   56: invokestatic 715	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: astore 14
    //   61: goto +3 -> 64
    //   64: aload 15
    //   66: aload 14
    //   68: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: ldc 30
    //   74: aload 15
    //   76: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 564	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: aload_3
    //   83: ifnull +247 -> 330
    //   86: aload_0
    //   87: getfield 128	com/tencent/tav/decoder/EncoderWriter:released	Z
    //   90: ifeq +6 -> 96
    //   93: goto +237 -> 330
    //   96: aload_3
    //   97: invokevirtual 717	java/nio/ByteBuffer:position	()I
    //   100: istore 4
    //   102: aload_3
    //   103: invokevirtual 711	java/nio/ByteBuffer:limit	()I
    //   106: istore 6
    //   108: lconst_0
    //   109: lstore 9
    //   111: iload 4
    //   113: iload 6
    //   115: if_icmpge +187 -> 302
    //   118: aload_0
    //   119: getfield 128	com/tencent/tav/decoder/EncoderWriter:released	Z
    //   122: istore 13
    //   124: iload 13
    //   126: ifne +176 -> 302
    //   129: aload_0
    //   130: getfield 98	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   133: invokeinterface 462 1 0
    //   138: aload_0
    //   139: aload_0
    //   140: getfield 412	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   143: invokespecial 199	com/tencent/tav/decoder/EncoderWriter:dequeueInputBuffer	(Landroid/media/MediaCodec;)I
    //   146: istore 7
    //   148: iload 4
    //   150: istore 5
    //   152: lload 9
    //   154: lstore 11
    //   156: iload 7
    //   158: iflt +105 -> 263
    //   161: aload_0
    //   162: aload_0
    //   163: getfield 412	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   166: iload 7
    //   168: invokespecial 353	com/tencent/tav/decoder/EncoderWriter:getInputBuffer	(Landroid/media/MediaCodec;I)Ljava/nio/ByteBuffer;
    //   171: astore 14
    //   173: iload 6
    //   175: iload 4
    //   177: isub
    //   178: aload 14
    //   180: invokevirtual 720	java/nio/ByteBuffer:capacity	()I
    //   183: invokestatic 726	java/lang/Math:min	(II)I
    //   186: istore 8
    //   188: iload 4
    //   190: iload 8
    //   192: iadd
    //   193: istore 5
    //   195: aload_3
    //   196: iload 5
    //   198: invokevirtual 546	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   201: pop
    //   202: aload_3
    //   203: iload 4
    //   205: invokevirtual 543	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   208: pop
    //   209: aload 14
    //   211: aload_3
    //   212: invokevirtual 730	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   215: pop
    //   216: aload_0
    //   217: aload_0
    //   218: getfield 412	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
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
    //   238: getfield 672	com/tencent/tav/decoder/EncoderWriter:encodeOption	Lcom/tencent/tav/core/ExportConfig;
    //   241: invokevirtual 733	com/tencent/tav/core/ExportConfig:getAudioChannelCount	()I
    //   244: aload_0
    //   245: getfield 672	com/tencent/tav/decoder/EncoderWriter:encodeOption	Lcom/tencent/tav/core/ExportConfig;
    //   248: invokevirtual 736	com/tencent/tav/core/ExportConfig:getAudioSampleRateHz	()I
    //   251: invokestatic 740	com/tencent/tav/decoder/DecoderUtils:getAudioDuration	(JII)J
    //   254: lstore 11
    //   256: lload 9
    //   258: lload 11
    //   260: ladd
    //   261: lstore 11
    //   263: aload_0
    //   264: getfield 98	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   267: invokeinterface 492 1 0
    //   272: aload_0
    //   273: iconst_0
    //   274: aconst_null
    //   275: aconst_null
    //   276: invokespecial 626	com/tencent/tav/decoder/EncoderWriter:drainEncoder	(ZLcom/tencent/tav/coremedia/CMSampleBuffer;Lcom/tencent/tav/coremedia/TextureInfo;)V
    //   279: iload 5
    //   281: istore 4
    //   283: lload 11
    //   285: lstore 9
    //   287: goto -176 -> 111
    //   290: astore_3
    //   291: aload_0
    //   292: getfield 98	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   295: invokeinterface 492 1 0
    //   300: aload_3
    //   301: athrow
    //   302: aload_3
    //   303: iconst_0
    //   304: invokevirtual 543	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   307: pop
    //   308: aload_3
    //   309: iload 6
    //   311: invokevirtual 546	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   314: pop
    //   315: aload_0
    //   316: getfield 103	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   319: invokeinterface 620 1 0
    //   324: invokeinterface 492 1 0
    //   329: return
    //   330: aload_0
    //   331: getfield 103	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   334: invokeinterface 620 1 0
    //   339: invokeinterface 492 1 0
    //   344: return
    //   345: astore_3
    //   346: goto +24 -> 370
    //   349: astore_3
    //   350: aload_3
    //   351: instanceof 422
    //   354: ifeq +5 -> 359
    //   357: aload_3
    //   358: athrow
    //   359: new 422	com/tencent/tav/core/ExportRuntimeException
    //   362: dup
    //   363: bipush 134
    //   365: aload_3
    //   366: invokespecial 741	com/tencent/tav/core/ExportRuntimeException:<init>	(ILjava/lang/Throwable;)V
    //   369: athrow
    //   370: aload_0
    //   371: getfield 103	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   374: invokeinterface 620 1 0
    //   379: invokeinterface 492 1 0
    //   384: goto +5 -> 389
    //   387: aload_3
    //   388: athrow
    //   389: goto -2 -> 387
    //   392: ldc_w 605
    //   395: astore 14
    //   397: goto -333 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	this	EncoderWriter
    //   0	400	1	paramLong	long
    //   0	400	3	paramByteBuffer	ByteBuffer
    //   100	182	4	i	int
    //   150	130	5	j	int
    //   106	204	6	k	int
    //   146	76	7	m	int
    //   186	49	8	n	int
    //   109	177	9	l1	long
    //   154	130	11	l2	long
    //   122	3	13	bool	boolean
    //   59	337	14	localObject	Object
    //   21	54	15	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   129	148	290	finally
    //   161	188	290	finally
    //   195	256	290	finally
    //   0	48	345	finally
    //   52	61	345	finally
    //   64	82	345	finally
    //   86	93	345	finally
    //   96	108	345	finally
    //   118	124	345	finally
    //   263	279	345	finally
    //   291	302	345	finally
    //   302	315	345	finally
    //   350	359	345	finally
    //   359	370	345	finally
    //   0	48	349	java/lang/Throwable
    //   52	61	349	java/lang/Throwable
    //   64	82	349	java/lang/Throwable
    //   86	93	349	java/lang/Throwable
    //   96	108	349	java/lang/Throwable
    //   118	124	349	java/lang/Throwable
    //   263	279	349	java/lang/Throwable
    //   291	302	349	java/lang/Throwable
    //   302	315	349	java/lang/Throwable
  }
  
  @RequiresApi(api=18)
  public void writeVideoSample(CMSampleBuffer paramCMSampleBuffer, TextureInfo paramTextureInfo)
  {
    Logger.i("EncoderWriter", "writeVideoSample");
    System.currentTimeMillis();
    try
    {
      this.lock.readLock().lock();
      if ((this.videoEncoder instanceof MediaCodecAssetWriterVideoEncoder))
      {
        Surface localSurface = this._inputSurface;
        if (localSurface == null) {
          return;
        }
      }
      drainEncoder(false, paramCMSampleBuffer, paramTextureInfo);
      return;
    }
    finally
    {
      this.lock.readLock().unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.EncoderWriter
 * JD-Core Version:    0.7.0.1
 */