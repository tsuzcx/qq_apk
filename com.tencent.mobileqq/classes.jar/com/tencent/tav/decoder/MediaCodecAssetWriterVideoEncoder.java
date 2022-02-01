package com.tencent.tav.decoder;

import android.graphics.Matrix;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.Surface;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.core.ExportRuntimeException;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import java.nio.ByteBuffer;

public class MediaCodecAssetWriterVideoEncoder
  implements AssetWriterVideoEncoder
{
  private static final long WAIT_TRANSIENT_MS = 20L;
  private final String TAG;
  private ExportConfig encodeOption;
  private CGSize encodeSize;
  private Surface inputSurface;
  private boolean isEncodeToEndOfStream;
  private IMediaMuxer muxer;
  private int outHeight;
  private int outWidth;
  private volatile MediaCodec.BufferInfo videoBufferInfo;
  private volatile MediaFormat videoEncodeFormat;
  private MediaCodec videoEncoder;
  private long videoPresentationTimeUs;
  
  public MediaCodecAssetWriterVideoEncoder()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MediaCodecAssetWriterVideoEncoder@");
    localStringBuilder.append(hashCode());
    this.TAG = localStringBuilder.toString();
    this.videoBufferInfo = new MediaCodec.BufferInfo();
    this.videoEncodeFormat = null;
    this.videoPresentationTimeUs = 0L;
    this.isEncodeToEndOfStream = false;
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
      Logger.e(this.TAG, "dequeueOutputBuffer e = ", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
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
        if (((MediaCodec.CodecException)localException).isTransient())
        {
          waitTime(20L);
          return dequeueOutputBuffer(paramMediaCodec, paramBufferInfo);
        }
      }
      throw localException;
    }
  }
  
  private ByteBuffer getOutputBuffer(MediaCodec paramMediaCodec, int paramInt)
  {
    try
    {
      ByteBuffer localByteBuffer = DecoderUtils.getOutputBuffer(paramMediaCodec, paramInt);
      return localByteBuffer;
    }
    catch (Error localError) {}catch (Exception localException) {}
    Logger.e(this.TAG, "getOutputBuffer", localException);
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
        return getOutputBuffer(paramMediaCodec, paramInt);
      }
    }
    throw localException;
  }
  
  private void releaseOutputBuffer(MediaCodec paramMediaCodec, int paramInt, boolean paramBoolean)
  {
    try
    {
      paramMediaCodec.releaseOutputBuffer(paramInt, paramBoolean);
      return;
    }
    catch (Error localError) {}catch (Exception localException) {}
    Logger.e(this.TAG, "releaseOutputBuffer", localException);
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
        releaseOutputBuffer(paramMediaCodec, paramInt, paramBoolean);
      }
    }
    throw localException;
  }
  
  private boolean retryPrepareVideoEncoder(ExportConfig paramExportConfig, MediaFormat paramMediaFormat)
  {
    paramExportConfig.initOutputSize(true, false);
    initSize(paramExportConfig);
    paramMediaFormat.setInteger("profile", 0);
    paramMediaFormat.setInteger("level", 0);
    try
    {
      this.videoEncoder = MediaCodecManager.createEncoderByType("video/avc");
      this.videoEncoder.configure(paramMediaFormat, null, null, 1);
      return true;
    }
    catch (Exception paramExportConfig)
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("retryPrepareVideoEncoder: fail format = ");
      localStringBuilder.append(paramMediaFormat);
      Logger.e(str, localStringBuilder.toString(), paramExportConfig);
      MediaCodecManager.releaseCodec(this.videoEncoder);
      throw new ExportRuntimeException(new ExportErrorStatus(-103, paramExportConfig, paramMediaFormat.toString()));
    }
  }
  
  private boolean validAndCorrectBufferInfo(MediaCodec.BufferInfo paramBufferInfo)
  {
    return (paramBufferInfo.size > 0) && ((paramBufferInfo.flags & 0x4) == 0);
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
  public Surface createInputSurface()
  {
    if ((this.videoEncoder != null) && (this.inputSurface == null))
    {
      Logger.i(this.TAG, "createInputSurface");
      this.inputSurface = this.videoEncoder.createInputSurface();
    }
    return this.inputSurface;
  }
  
  public MediaFormat getEncodeFormat()
  {
    return this.videoEncodeFormat;
  }
  
  public long getEncodePresentationTimeUs()
  {
    return this.videoPresentationTimeUs;
  }
  
  public CGSize getEncodeSize()
  {
    return this.encodeSize;
  }
  
  public Matrix getFrameMatrix()
  {
    return null;
  }
  
  @Nullable
  public String getName()
  {
    if ((this.videoEncoder != null) && (Build.VERSION.SDK_INT >= 18)) {
      return this.videoEncoder.getName();
    }
    return null;
  }
  
  public void initSize(ExportConfig paramExportConfig)
  {
    this.outWidth = paramExportConfig.getOutputWidth();
    this.outHeight = paramExportConfig.getOutputHeight();
    this.encodeSize = new CGSize(this.outWidth, this.outHeight);
  }
  
  public boolean isEncodeToEndOfStream()
  {
    return this.isEncodeToEndOfStream;
  }
  
  public boolean isNeedVideoOutputTexture()
  {
    return false;
  }
  
  public void onOutputTextureUpdate(TextureInfo paramTextureInfo, long paramLong) {}
  
  public void onRenderRelease() {}
  
  public boolean prepare(ExportConfig paramExportConfig, MediaFormat paramMediaFormat)
  {
    this.encodeOption = paramExportConfig;
    initSize(paramExportConfig);
    try
    {
      String str = this.TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("prepareVideoEncoder: format = ");
      ((StringBuilder)localObject).append(paramMediaFormat);
      Logger.i(str, ((StringBuilder)localObject).toString());
      str = "video/avc";
      if (paramMediaFormat.containsKey("mime")) {
        str = paramMediaFormat.getString("mime");
      }
      this.videoEncoder = MediaCodecManager.createEncoderByType(str);
      this.videoEncoder.configure(paramMediaFormat, null, null, 1);
      return true;
    }
    catch (Exception localException)
    {
      Object localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("prepare: fail format = ");
      localStringBuilder.append(paramMediaFormat);
      Logger.e((String)localObject, localStringBuilder.toString(), localException);
    }
    return retryPrepareVideoEncoder(paramExportConfig, paramMediaFormat);
  }
  
  public void release()
  {
    MediaCodec localMediaCodec = this.videoEncoder;
    if (localMediaCodec != null) {
      MediaCodecManager.releaseCodec(localMediaCodec);
    }
  }
  
  public void setMediaMuxer(IMediaMuxer paramIMediaMuxer)
  {
    this.muxer = paramIMediaMuxer;
  }
  
  public void setVideoSampleRenderContext(RenderContext paramRenderContext) {}
  
  @RequiresApi(api=18)
  public void signalEndOfInputStream()
  {
    MediaCodec localMediaCodec = this.videoEncoder;
    if (localMediaCodec != null) {
      localMediaCodec.signalEndOfInputStream();
    }
  }
  
  public boolean start()
  {
    MediaCodec localMediaCodec = this.videoEncoder;
    if (localMediaCodec != null)
    {
      localMediaCodec.start();
      return true;
    }
    return false;
  }
  
  public void stop()
  {
    MediaCodec localMediaCodec = this.videoEncoder;
    if (localMediaCodec != null) {
      localMediaCodec.stop();
    }
  }
  
  public boolean writeVideoSample(CMSampleBuffer paramCMSampleBuffer, TextureInfo paramTextureInfo, boolean paramBoolean)
  {
    paramCMSampleBuffer = this.muxer;
    boolean bool;
    if (paramCMSampleBuffer != null) {
      bool = paramCMSampleBuffer.isMuxerStarted();
    } else {
      bool = false;
    }
    if ((!bool) && (this.videoEncodeFormat != null))
    {
      if (paramBoolean) {}
    }
    else {
      for (;;)
      {
        return true;
        int i = dequeueOutputBuffer(this.videoEncoder, this.videoBufferInfo);
        if (i == -1)
        {
          if (paramBoolean) {
            break;
          }
        }
        else
        {
          if (i == -2)
          {
            this.videoEncodeFormat = this.videoEncoder.getOutputFormat();
            return false;
          }
          if (i < 0) {
            break;
          }
          paramCMSampleBuffer = getOutputBuffer(this.videoEncoder, i);
          if (((this.videoBufferInfo.flags & 0x2) != 0) && (this.muxer.ignoreHeader())) {
            this.videoBufferInfo.size = 0;
          }
          if ((bool) && (validAndCorrectBufferInfo(this.videoBufferInfo)))
          {
            paramTextureInfo = new MediaCodec.BufferInfo();
            paramTextureInfo.set(this.videoBufferInfo.offset, this.videoBufferInfo.size, this.videoBufferInfo.presentationTimeUs, this.videoBufferInfo.flags);
            IMediaMuxer localIMediaMuxer = this.muxer;
            localIMediaMuxer.writeSampleData(localIMediaMuxer.videoTrackIndex(), paramCMSampleBuffer, paramTextureInfo);
            this.videoPresentationTimeUs = this.videoBufferInfo.presentationTimeUs;
          }
          releaseOutputBuffer(this.videoEncoder, i, false);
          if ((this.videoBufferInfo.flags & 0x4) == 0) {
            break;
          }
          Logger.i(this.TAG, "writeVideoFrame: BUFFER_FLAG_END_OF_STREAM");
          this.videoPresentationTimeUs = -1L;
          this.isEncodeToEndOfStream = true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.MediaCodecAssetWriterVideoEncoder
 * JD-Core Version:    0.7.0.1
 */