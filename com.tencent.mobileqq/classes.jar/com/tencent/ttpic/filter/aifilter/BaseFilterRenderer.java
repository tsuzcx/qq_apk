package com.tencent.ttpic.filter.aifilter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.filter.AlphaAdjustFilter;
import com.tencent.ttpic.openapi.filter.Renderer;
import java.util.HashMap;

public final class BaseFilterRenderer
  implements Renderer
{
  private final AlphaAdjustFilter alphaFilter;
  private final BaseFilter filter;
  
  public BaseFilterRenderer(BaseFilter paramBaseFilter)
  {
    this.filter = paramBaseFilter;
    this.alphaFilter = new AlphaAdjustFilter();
  }
  
  public final void addParams(HashMap<String, String> paramHashMap)
  {
    this.filter.addParams(paramHashMap);
    paramHashMap = (String)paramHashMap.get("strength");
    if (paramHashMap != null) {
      this.alphaFilter.setAdjustParam(Float.parseFloat(paramHashMap) / 100.0F);
    }
  }
  
  public final BaseFilter getFilter()
  {
    return this.filter;
  }
  
  public Frame process(Frame paramFrame)
  {
    Frame localFrame1 = this.filter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
    this.alphaFilter.apply();
    this.alphaFilter.setFilterTexture(localFrame1.getTextureId());
    Frame localFrame2 = this.alphaFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
    paramFrame.unlock();
    localFrame1.unlock();
    return localFrame2;
  }
  
  public void release()
  {
    this.filter.ClearGLSL();
    this.alphaFilter.ClearGLSL();
  }
  
  public final void setAlphaParam(float paramFloat)
  {
    this.alphaFilter.setAdjustParam(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.BaseFilterRenderer
 * JD-Core Version:    0.7.0.1
 */