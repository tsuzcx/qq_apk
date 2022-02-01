package com.tencent.tavkit.ciimage;

import android.graphics.Matrix;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.TextureInfo;

class RendererWrapper
  extends Renderer
{
  private int clearColor;
  private TextureInfo destTextureInfo;
  private final Renderer oesRenderer = new Renderer();
  private final Renderer rgbRenderer = new Renderer();
  
  public void clearBufferBuffer(int paramInt)
  {
    this.clearColor = paramInt;
    this.oesRenderer.clearBufferBuffer(paramInt);
    this.rgbRenderer.clearBufferBuffer(paramInt);
  }
  
  public void release()
  {
    this.oesRenderer.release();
    this.rgbRenderer.release();
  }
  
  public TextureInfo render(TextureInfo paramTextureInfo, Matrix paramMatrix1, Matrix paramMatrix2, float paramFloat, CGRect paramCGRect)
  {
    if (paramTextureInfo == null) {
      return null;
    }
    if (paramTextureInfo.textureType == 36197) {
      return this.oesRenderer.render(paramTextureInfo, paramMatrix1, paramMatrix2, paramFloat, paramCGRect);
    }
    return this.rgbRenderer.render(paramTextureInfo, paramMatrix1, paramMatrix2, paramFloat, paramCGRect);
  }
  
  public void setOutputTextureInfo(TextureInfo paramTextureInfo)
  {
    this.destTextureInfo = paramTextureInfo;
    this.oesRenderer.setOutputTextureInfo(paramTextureInfo);
    this.rgbRenderer.setOutputTextureInfo(paramTextureInfo);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CIImageFilter{program=");
    localStringBuilder.append(this.program);
    localStringBuilder.append(", clearColor=");
    localStringBuilder.append(this.clearColor);
    localStringBuilder.append(", destTextureInfo=");
    localStringBuilder.append(this.destTextureInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.RendererWrapper
 * JD-Core Version:    0.7.0.1
 */