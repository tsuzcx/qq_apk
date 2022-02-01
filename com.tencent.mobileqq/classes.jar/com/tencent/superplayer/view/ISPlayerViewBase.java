package com.tencent.superplayer.view;

public abstract interface ISPlayerViewBase
{
  public abstract boolean setDegree(int paramInt);
  
  public abstract void setScaleParam(float paramFloat);
  
  public abstract void setVideoWidthAndHeight(int paramInt1, int paramInt2);
  
  public abstract void setViewCallBack(ISPlayerViewBase.ViewCreateCallBack paramViewCreateCallBack);
  
  public abstract void setViewViewTagId(String paramString);
  
  public abstract void setXYaxis(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.view.ISPlayerViewBase
 * JD-Core Version:    0.7.0.1
 */