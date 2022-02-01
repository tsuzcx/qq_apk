package com.tencent.tav.decoder;

import android.graphics.Matrix;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import org.jetbrains.annotations.Nullable;

public abstract interface AssetWriterVideoEncoder
{
  public static final String OUTPUT_VIDEO_MIME_TYPE = "video/avc";
  public static final long WRITER_FINISH = -1L;
  
  public abstract Surface createInputSurface();
  
  public abstract MediaFormat getEncodeFormat();
  
  public abstract long getEncodePresentationTimeUs();
  
  public abstract CGSize getEncodeSize();
  
  public abstract Matrix getFrameMatrix();
  
  public abstract String getName();
  
  public abstract boolean isEncodeToEndOfStream();
  
  public abstract boolean isNeedVideoOutputTexture();
  
  public abstract void onOutputTextureUpdate(TextureInfo paramTextureInfo, long paramLong);
  
  public abstract void onRenderRelease();
  
  public abstract boolean prepare(ExportConfig paramExportConfig, MediaFormat paramMediaFormat);
  
  public abstract void release();
  
  public abstract void setMediaMuxer(IMediaMuxer paramIMediaMuxer);
  
  public abstract void setVideoSampleRenderContext(RenderContext paramRenderContext);
  
  public abstract void signalEndOfInputStream();
  
  public abstract boolean start();
  
  public abstract void stop();
  
  public abstract boolean writeVideoSample(@Nullable CMSampleBuffer paramCMSampleBuffer, @Nullable TextureInfo paramTextureInfo, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.AssetWriterVideoEncoder
 * JD-Core Version:    0.7.0.1
 */