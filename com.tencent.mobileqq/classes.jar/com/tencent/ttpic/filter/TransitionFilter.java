package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.openapi.filter.FabbyMvPart;
import com.tencent.ttpic.openapi.model.StickerItem;

public class TransitionFilter
  implements ITransitionFilter
{
  private TransitionAlphaFilter mAlphaFilter = new TransitionAlphaFilter();
  private TransitionBlendFilter mBlendFilter = new TransitionBlendFilter();
  private ITransitionFilter mCurrFilter;
  private TransitionMoveFilter mMoveFilter = new TransitionMoveFilter();
  
  public void ApplyGLSLFilter(String paramString)
  {
    this.mBlendFilter.apply();
    this.mAlphaFilter.apply();
    this.mMoveFilter.apply();
    setDataPath(paramString);
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, Frame paramFrame)
  {
    ITransitionFilter localITransitionFilter = this.mCurrFilter;
    if (localITransitionFilter != null) {
      localITransitionFilter.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, paramDouble, paramFrame);
    }
  }
  
  public void clearGLSL()
  {
    this.mBlendFilter.clearGLSL();
    this.mAlphaFilter.clearGLSL();
    this.mMoveFilter.clearGLSL();
  }
  
  public boolean needRender()
  {
    return this.mCurrFilter != null;
  }
  
  public void reset()
  {
    this.mBlendFilter.reset();
    this.mAlphaFilter.reset();
    this.mMoveFilter.reset();
  }
  
  public void setDataPath(String paramString)
  {
    this.mBlendFilter.setDataPath(paramString);
    this.mMoveFilter.setDataPath(paramString);
    this.mAlphaFilter.setDataPath(paramString);
  }
  
  public void setLastTex(int paramInt)
  {
    ITransitionFilter localITransitionFilter = this.mCurrFilter;
    if (localITransitionFilter != null) {
      localITransitionFilter.setLastTex(paramInt);
    }
  }
  
  public void setMvPart(FabbyMvPart paramFabbyMvPart)
  {
    int i = paramFabbyMvPart.transitionFunction;
    if (i != 0)
    {
      if ((i != 1) && (i != 2) && (i != 3) && (i != 4))
      {
        if (i != 5)
        {
          this.mCurrFilter = null;
          return;
        }
        this.mAlphaFilter.setDuration(paramFabbyMvPart.transitionDuration);
        this.mAlphaFilter.setEaseCurve(paramFabbyMvPart.transitionEase);
        this.mCurrFilter = this.mAlphaFilter;
        return;
      }
      this.mMoveFilter.setDuration(paramFabbyMvPart.transitionDuration);
      this.mMoveFilter.setEaseCurve(paramFabbyMvPart.transitionEase);
      this.mMoveFilter.setMoveOrientation(paramFabbyMvPart.transitionFunction);
      this.mCurrFilter = this.mMoveFilter;
      return;
    }
    if ((paramFabbyMvPart.transitionItem != null) && (!paramFabbyMvPart.transitionItem.id.isEmpty()))
    {
      this.mBlendFilter.setItem(paramFabbyMvPart.transitionItem);
      this.mBlendFilter.setDuration(paramFabbyMvPart.transitionDuration);
      this.mBlendFilter.setEaseCurve(paramFabbyMvPart.transitionEase);
      this.mBlendFilter.setMaskType(paramFabbyMvPart.transitionMaskType);
      this.mCurrFilter = this.mBlendFilter;
      return;
    }
    this.mCurrFilter = null;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mBlendFilter.setRenderMode(paramInt);
    this.mAlphaFilter.setRenderMode(paramInt);
    this.mMoveFilter.setRenderMode(paramInt);
  }
  
  public void updatePreview(long paramLong)
  {
    ITransitionFilter localITransitionFilter = this.mCurrFilter;
    if (localITransitionFilter != null) {
      localITransitionFilter.updatePreview(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.TransitionFilter
 * JD-Core Version:    0.7.0.1
 */