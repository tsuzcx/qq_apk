package com.tencent.tavkit.ciimage;

import android.graphics.Matrix;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.TextureInfo;

class CIImageFilter
  extends TextureFilter
{
  private final String TAG;
  private int clearColor;
  private TextureInfo destTextureInfo;
  private TextureFilter oesFilter;
  private TextureFilter rgbFilter;
  
  CIImageFilter()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CIImageFilter@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.TAG = localStringBuilder.toString();
    if (this.rgbFilter == null) {
      this.rgbFilter = new TextureFilter();
    }
    if (this.oesFilter == null) {
      this.oesFilter = new TextureFilter();
    }
  }
  
  private TextureInfo tryApplyOESFilter(TextureInfo paramTextureInfo, Matrix paramMatrix1, Matrix paramMatrix2, float paramFloat, CGRect paramCGRect)
  {
    return this.oesFilter.applyFilter(paramTextureInfo, paramMatrix1, paramMatrix2, paramFloat, paramCGRect);
  }
  
  private TextureInfo tryApplyRGBFilter(TextureInfo paramTextureInfo, Matrix paramMatrix1, Matrix paramMatrix2, float paramFloat, CGRect paramCGRect)
  {
    return this.rgbFilter.applyFilter(paramTextureInfo, paramMatrix1, paramMatrix2, paramFloat, paramCGRect);
  }
  
  public TextureInfo applyFilter(TextureInfo paramTextureInfo, Matrix paramMatrix1, Matrix paramMatrix2, float paramFloat, CGRect paramCGRect)
  {
    if (paramTextureInfo != null)
    {
      if (paramTextureInfo.textureType == 36197) {
        return tryApplyOESFilter(paramTextureInfo, paramMatrix1, paramMatrix2, paramFloat, paramCGRect);
      }
      return tryApplyRGBFilter(paramTextureInfo, paramMatrix1, paramMatrix2, paramFloat, paramCGRect);
    }
    return null;
  }
  
  public void clearBufferBuffer(int paramInt)
  {
    this.clearColor = paramInt;
    TextureFilter localTextureFilter = this.oesFilter;
    if (localTextureFilter != null) {
      localTextureFilter.clearBufferBuffer(paramInt);
    }
    localTextureFilter = this.rgbFilter;
    if (localTextureFilter != null) {
      localTextureFilter.clearBufferBuffer(paramInt);
    }
  }
  
  public void release()
  {
    TextureFilter localTextureFilter = this.oesFilter;
    if (localTextureFilter != null) {
      localTextureFilter.release();
    }
    localTextureFilter = this.rgbFilter;
    if (localTextureFilter != null) {
      localTextureFilter.release();
    }
  }
  
  public void setOutputTextureInfo(TextureInfo paramTextureInfo)
  {
    this.destTextureInfo = paramTextureInfo;
    TextureFilter localTextureFilter = this.oesFilter;
    if (localTextureFilter != null) {
      localTextureFilter.setOutputTextureInfo(paramTextureInfo);
    }
    localTextureFilter = this.rgbFilter;
    if (localTextureFilter != null) {
      localTextureFilter.setOutputTextureInfo(paramTextureInfo);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.CIImageFilter
 * JD-Core Version:    0.7.0.1
 */