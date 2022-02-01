package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.internal.Frame;

public abstract interface ITransitionFilter
{
  public abstract void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, Frame paramFrame);
  
  public abstract void reset();
  
  public abstract void setDataPath(String paramString);
  
  public abstract void setLastTex(int paramInt);
  
  public abstract void updatePreview(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.ITransitionFilter
 * JD-Core Version:    0.7.0.1
 */