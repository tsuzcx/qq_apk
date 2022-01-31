package com.tencent.plato;

import android.view.View;

public abstract interface IPlatoSurface
{
  public abstract void addView(View paramView);
  
  public abstract void addView(View paramView, int paramInt1, int paramInt2);
  
  public abstract void attachRender(ISurfaceRender paramISurfaceRender);
  
  public abstract int getHeightMeasureSpec();
  
  public abstract int getWidthMeasureSpec();
  
  public abstract void removeAllViews();
  
  public abstract void removeView(View paramView);
  
  public abstract boolean wasMeasure();
  
  public static abstract interface ISurfaceRender
  {
    public abstract void refreshSurface();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.IPlatoSurface
 * JD-Core Version:    0.7.0.1
 */