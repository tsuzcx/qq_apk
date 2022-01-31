package com.tencent.tavkit.ciimage;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;

public class CIContext
{
  private final String TAG = "CIContext@" + Integer.toHexString(hashCode());
  private CIImageFilter copyFilter;
  private CIImageFilter filter;
  @NonNull
  private final RenderContext renderContext;
  private TextureInfo textureInfo;
  
  public CIContext(@NonNull RenderContext paramRenderContext)
  {
    this.renderContext = paramRenderContext;
  }
  
  @NonNull
  public static TextureInfo newTextureInfo(float paramFloat1, float paramFloat2)
  {
    return newTextureInfo((int)paramFloat1, (int)paramFloat2);
  }
  
  public static TextureInfo newTextureInfo(int paramInt1, int paramInt2)
  {
    return new TextureInfo(RenderContext.createTexture(3553), 3553, paramInt1, paramInt2, null, 0);
  }
  
  private void setDestImage(TextureInfo paramTextureInfo)
  {
    if (this.filter == null) {
      this.filter = new CIImageFilter();
    }
    this.filter.setOutputTextureInfo(paramTextureInfo);
  }
  
  public void clear(int paramInt)
  {
    this.filter.clearBufferBuffer(paramInt);
  }
  
  public TextureInfo convertImageToTexture(CIImage paramCIImage, TextureInfo paramTextureInfo)
  {
    if (paramTextureInfo == null) {
      return null;
    }
    if (this.copyFilter == null) {
      this.copyFilter = new CIImageFilter();
    }
    this.copyFilter.setOutputTextureInfo(paramTextureInfo);
    this.copyFilter.clearBufferBuffer(-16777216);
    paramCIImage.draw(this.copyFilter);
    return paramTextureInfo;
  }
  
  @NonNull
  public RenderContext getRenderContext()
  {
    return this.renderContext;
  }
  
  public void release()
  {
    Logger.d(this.TAG, "release: begin, currentThread = " + Thread.currentThread().getName());
    if (this.filter != null) {
      this.filter.release();
    }
    if (this.textureInfo != null) {
      this.textureInfo.release();
    }
    if (this.copyFilter != null) {
      this.copyFilter.release();
    }
    Logger.d(this.TAG, "release: end, currentThread = " + Thread.currentThread().getName());
  }
  
  @NonNull
  public CMSampleBuffer renderToSampleBuffer(CIImage paramCIImage, CMTime paramCMTime, RenderContext paramRenderContext)
  {
    paramRenderContext.makeCurrent();
    if ((this.textureInfo != null) && ((this.textureInfo.width != paramRenderContext.width()) || (this.textureInfo.height != paramRenderContext.height())))
    {
      this.textureInfo.release();
      this.textureInfo = null;
    }
    if (this.textureInfo == null) {
      this.textureInfo = newTextureInfo(paramRenderContext.width(), paramRenderContext.height());
    }
    setDestImage(this.textureInfo);
    clear(-16777216);
    paramCIImage.draw(this.filter);
    return new CMSampleBuffer(paramCMTime, this.textureInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.CIContext
 * JD-Core Version:    0.7.0.1
 */