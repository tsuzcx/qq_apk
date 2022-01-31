package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.WMGroup;

public class WatermarkDynamicFilter
  extends DynamicStickerFilter
{
  private WMGroup wmGroup;
  
  public WatermarkDynamicFilter(StickerItem paramStickerItem, String paramString)
  {
    super(paramStickerItem, paramString);
    this.wmGroup = new WMGroup(paramStickerItem.wmGroupConfig);
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    if (this.wmGroup != null) {
      this.wmGroup.init();
    }
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    if (this.wmGroup != null) {
      this.wmGroup.clear();
    }
  }
  
  public void reset()
  {
    this.wmGroup.reset();
    super.reset();
  }
  
  protected void updateTextureParam(int paramInt, long paramLong)
  {
    if (this.wmGroup != null)
    {
      this.wmGroup.updateTexture(paramLong);
      this.isImageReady = true;
      addParam(new UniformParam.TextureParam("inputImageTexture2", this.wmGroup.getTexture(), 33986));
      return;
    }
    this.isImageReady = false;
    clearTextureParam();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.WatermarkDynamicFilter
 * JD-Core Version:    0.7.0.1
 */