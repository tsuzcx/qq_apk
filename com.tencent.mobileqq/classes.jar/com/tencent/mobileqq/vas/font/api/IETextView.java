package com.tencent.mobileqq.vas.font.api;

import android.content.res.Resources;
import android.graphics.Paint;

public abstract interface IETextView
{
  public abstract int getETMaxWidth();
  
  public abstract void getLocationInWindow(int[] paramArrayOfInt);
  
  public abstract int getMaxEms();
  
  public abstract int getMaxLines();
  
  public abstract int getPaddingBottom();
  
  public abstract int getPaddingLeft();
  
  public abstract int getPaddingRight();
  
  public abstract int getPaddingTop();
  
  public abstract Paint getPaint();
  
  public abstract Resources getResources();
  
  public abstract CharSequence getText();
  
  public abstract float getTextSize();
  
  public abstract int getVisibility();
  
  public abstract boolean hasSelected();
  
  public abstract int highlightBackgroundColor();
  
  public abstract void invalidate();
  
  public abstract boolean isCacheMeasureResult();
  
  public abstract void onAnimationEnd(int paramInt);
  
  public abstract void setIsFounderAnimating(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.font.api.IETextView
 * JD-Core Version:    0.7.0.1
 */