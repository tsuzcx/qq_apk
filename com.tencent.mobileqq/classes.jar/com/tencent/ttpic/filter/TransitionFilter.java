package com.tencent.ttpic.filter;

import com.tencent.filter.Frame;

public class TransitionFilter
  implements ITransitionFilter
{
  private TransitionAlphaFilter mAlphaFilter = new TransitionAlphaFilter();
  private TransitionBlendFilter mBlendFilter = new TransitionBlendFilter();
  private ITransitionFilter mCurrFilter;
  private TransitionMoveFilter mMoveFilter = new TransitionMoveFilter();
  
  public void ApplyGLSLFilter()
  {
    this.mBlendFilter.ApplyGLSLFilter();
    this.mAlphaFilter.ApplyGLSLFilter();
    this.mMoveFilter.ApplyGLSLFilter();
  }
  
  public void ClearGLSL()
  {
    this.mBlendFilter.ClearGLSL();
    this.mAlphaFilter.ClearGLSL();
    this.mMoveFilter.ClearGLSL();
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, Frame paramFrame)
  {
    if (this.mCurrFilter != null) {
      this.mCurrFilter.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, paramDouble, paramFrame);
    }
  }
  
  public void reset()
  {
    if (this.mCurrFilter != null) {
      this.mCurrFilter.reset();
    }
  }
  
  public void setDataPath(String paramString)
  {
    if (this.mCurrFilter != null) {
      this.mCurrFilter.setDataPath(paramString);
    }
  }
  
  public void setLastTex(int paramInt)
  {
    if (this.mCurrFilter != null) {
      this.mCurrFilter.setLastTex(paramInt);
    }
  }
  
  public void setMvPart(FabbyMvPart paramFabbyMvPart)
  {
    switch (paramFabbyMvPart.transitionFunction)
    {
    default: 
      this.mBlendFilter.setItem(paramFabbyMvPart.transitionItem);
      this.mBlendFilter.setDuration(paramFabbyMvPart.transitionDuration);
      this.mBlendFilter.setEaseCurve(paramFabbyMvPart.transitionEase);
      this.mBlendFilter.setMaskType(paramFabbyMvPart.transitionMaskType);
      this.mCurrFilter = this.mBlendFilter;
      return;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      this.mMoveFilter.setDuration(paramFabbyMvPart.transitionDuration);
      this.mMoveFilter.setEaseCurve(paramFabbyMvPart.transitionEase);
      this.mMoveFilter.setMoveOrientation(paramFabbyMvPart.transitionFunction);
      this.mCurrFilter = this.mMoveFilter;
      return;
    }
    this.mAlphaFilter.setDuration(paramFabbyMvPart.transitionDuration);
    this.mAlphaFilter.setEaseCurve(paramFabbyMvPart.transitionEase);
    this.mCurrFilter = this.mAlphaFilter;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mBlendFilter.setRenderMode(paramInt);
    this.mAlphaFilter.setRenderMode(paramInt);
    this.mMoveFilter.setRenderMode(paramInt);
  }
  
  public void updatePreview(long paramLong)
  {
    if (this.mCurrFilter != null) {
      this.mCurrFilter.updatePreview(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.TransitionFilter
 * JD-Core Version:    0.7.0.1
 */