package com.tencent.tavkit.ciimage;

import android.opengl.GLES20;
import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;

public class CIContext
{
  private final String TAG;
  private CIImageFilter copyFilter;
  private CIImageFilter filter;
  @NonNull
  private final RenderContext renderContext;
  private TextureInfo textureInfo;
  
  public CIContext(@NonNull RenderContext paramRenderContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CIContext@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.TAG = localStringBuilder.toString();
    this.renderContext = paramRenderContext;
  }
  
  @NonNull
  public static TextureInfo newTextureInfo(float paramFloat1, float paramFloat2)
  {
    return newTextureInfo((int)paramFloat1, (int)paramFloat2);
  }
  
  public static TextureInfo newTextureInfo(int paramInt1, int paramInt2)
  {
    return newTextureInfo(paramInt1, paramInt2, false);
  }
  
  @NonNull
  public static TextureInfo newTextureInfo(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    TextureInfo localTextureInfo = new TextureInfo(RenderContext.createTexture(3553), 3553, paramInt1, paramInt2, null, 0);
    localTextureInfo.setFormat(6408);
    if (paramBoolean)
    {
      GLES20.glBindTexture(3553, localTextureInfo.textureID);
      GLES20.glTexImage2D(3553, 0, localTextureInfo.getFormat(), localTextureInfo.width, localTextureInfo.height, 0, localTextureInfo.getFormat(), 5121, null);
    }
    return localTextureInfo;
  }
  
  public static TextureInfo newTextureInfo(CGSize paramCGSize)
  {
    return newTextureInfo(paramCGSize.width, paramCGSize.height);
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
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("release: begin, currentThread = ");
    localStringBuilder.append(Thread.currentThread().getName());
    Logger.d((String)localObject, localStringBuilder.toString());
    localObject = this.filter;
    if (localObject != null) {
      ((CIImageFilter)localObject).release();
    }
    localObject = this.textureInfo;
    if (localObject != null) {
      ((TextureInfo)localObject).release();
    }
    localObject = this.copyFilter;
    if (localObject != null) {
      ((CIImageFilter)localObject).release();
    }
    localObject = this.TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("release: end, currentThread = ");
    localStringBuilder.append(Thread.currentThread().getName());
    Logger.d((String)localObject, localStringBuilder.toString());
  }
  
  @NonNull
  public CMSampleBuffer renderToSampleBuffer(CIImage paramCIImage, CMTime paramCMTime, RenderContext paramRenderContext)
  {
    paramRenderContext.makeCurrent();
    TextureInfo localTextureInfo = this.textureInfo;
    if ((localTextureInfo != null) && ((localTextureInfo.width != paramRenderContext.width()) || (this.textureInfo.height != paramRenderContext.height())))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.CIContext
 * JD-Core Version:    0.7.0.1
 */