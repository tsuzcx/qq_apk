package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.filter.ComposeFilter;

public class EffectFilters4Pitu
  extends AEChainI
{
  private ComposeFilter composeFilter = new ComposeFilter();
  private BaseFilter curFilter;
  private BaseFilter mAlphafilter = new AlphaAdjustFilter();
  private BaseFilter nextFilter;
  private BaseFilter preFilter;
  private boolean showNextFilter;
  private boolean showPreFilter;
  private VideoFilterBase specificFilter;
  private float xNextOffset;
  private float xPreOffset;
  
  private Frame RenderProcess(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2;
    if ((this.specificFilter != null) && (this.specificFilter.isValid())) {
      localObject2 = this.specificFilter.RenderProcess(paramInt1, paramInt2, paramInt3);
    }
    for (;;)
    {
      Object localObject1 = localObject2;
      Frame localFrame;
      if (this.showNextFilter)
      {
        localObject1 = localObject2;
        if (this.nextFilter != null)
        {
          localFrame = this.nextFilter.RenderProcess(paramInt1, paramInt2, paramInt3);
          this.composeFilter.addParam(new UniformParam.TextureParam("inputImageTexture2", localFrame.getTextureId(), 33986));
          this.composeFilter.setOffset(1.0F - this.xNextOffset);
          localObject1 = this.composeFilter.RenderProcess(((Frame)localObject2).getTextureId(), paramInt2, paramInt3);
          localFrame.unlock();
          ((Frame)localObject2).unlock();
        }
      }
      localObject2 = localObject1;
      if (this.showPreFilter)
      {
        localObject2 = localObject1;
        if (this.preFilter != null)
        {
          localFrame = this.preFilter.RenderProcess(paramInt1, paramInt2, paramInt3);
          this.composeFilter.addParam(new UniformParam.TextureParam("inputImageTexture2", ((Frame)localObject1).getTextureId(), 33986));
          this.composeFilter.setOffset(this.xPreOffset);
          localObject2 = this.composeFilter.RenderProcess(localFrame.getTextureId(), paramInt2, paramInt3);
          localFrame.unlock();
          ((Frame)localObject1).unlock();
        }
      }
      return localObject2;
      localObject1 = this.curFilter.RenderProcess(paramInt1, paramInt2, paramInt3);
      this.mAlphafilter.addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt1, 33986));
      localObject2 = this.mAlphafilter.RenderProcess(((Frame)localObject1).getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height);
      ((Frame)localObject1).unlock();
    }
  }
  
  private void updateNextFilterPos(BaseFilter paramBaseFilter)
  {
    if (paramBaseFilter == null) {
      return;
    }
    float f1 = 1.0F - this.xNextOffset * 2.0F;
    float f2 = 1.0F - this.xNextOffset;
    paramBaseFilter.setPositions(new float[] { f1, -1.0F, f1, 1.0F, 1.0F, 1.0F, 1.0F, -1.0F });
    paramBaseFilter.setTexCords(new float[] { f2, 0.0F, f2, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F });
  }
  
  private void updatePreFilterPos(BaseFilter paramBaseFilter)
  {
    if (paramBaseFilter == null) {
      return;
    }
    float f1 = this.xPreOffset * 2.0F - 1.0F;
    float f2 = this.xPreOffset;
    paramBaseFilter.setPositions(new float[] { -1.0F, -1.0F, -1.0F, 1.0F, f1, 1.0F, f1, -1.0F });
    paramBaseFilter.setTexCords(new float[] { 0.0F, 0.0F, 0.0F, 1.0F, f2, 1.0F, f2, 0.0F });
  }
  
  public void ApplyComposeFilter()
  {
    this.mAlphafilter.apply();
    this.composeFilter.apply();
  }
  
  public void ApplyGLSLFilters(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.preFilter != null) {
      this.preFilter.applyFilterChain(paramBoolean, paramInt1, paramInt2);
    }
    if (this.curFilter != null) {
      this.curFilter.applyFilterChain(paramBoolean, paramInt1, paramInt2);
    }
    if (this.nextFilter != null) {
      this.nextFilter.applyFilterChain(paramBoolean, paramInt1, paramInt2);
    }
  }
  
  public void clearComposeFilter()
  {
    this.mAlphafilter.ClearGLSL();
    this.composeFilter.ClearGLSL();
  }
  
  public void clearGLSLs()
  {
    if (this.preFilter != null) {
      this.preFilter.ClearGLSL();
    }
    if (this.curFilter != null) {
      this.curFilter.ClearGLSL();
    }
    if (this.nextFilter != null) {
      this.nextFilter.ClearGLSL();
    }
  }
  
  public boolean isShowFilterProgress()
  {
    return (this.showPreFilter) || (this.showNextFilter);
  }
  
  public Frame render(Frame paramFrame)
  {
    return RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
  }
  
  public void setCurFilterAlpha(float paramFloat)
  {
    this.mAlphafilter.setAdjustParam(paramFloat);
  }
  
  public void setFilters(BaseFilter paramBaseFilter1, BaseFilter paramBaseFilter2, BaseFilter paramBaseFilter3)
  {
    this.preFilter = paramBaseFilter1;
    this.curFilter = paramBaseFilter2;
    this.nextFilter = paramBaseFilter3;
    this.specificFilter = null;
  }
  
  public void setNextFilterAlpha(float paramFloat)
  {
    if (this.nextFilter != null) {
      this.nextFilter.setAdjustParam(paramFloat);
    }
  }
  
  public void setNextFilterOffset(float paramFloat)
  {
    this.xNextOffset = paramFloat;
  }
  
  public void setPreFilterAlpha(float paramFloat)
  {
    if (this.preFilter != null) {
      this.preFilter.setAdjustParam(paramFloat);
    }
  }
  
  public void setPreFilterOffset(float paramFloat)
  {
    this.xPreOffset = paramFloat;
  }
  
  public void setShowNextFilter(boolean paramBoolean)
  {
    this.showNextFilter = paramBoolean;
  }
  
  public void setShowPreFilter(boolean paramBoolean)
  {
    this.showPreFilter = paramBoolean;
  }
  
  public void setSpecificFilter(VideoFilterBase paramVideoFilterBase)
  {
    this.specificFilter = paramVideoFilterBase;
  }
  
  public void stopFilterProgress()
  {
    this.showPreFilter = false;
    this.showNextFilter = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.EffectFilters4Pitu
 * JD-Core Version:    0.7.0.1
 */