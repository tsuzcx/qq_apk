package com.tencent.mobileqq.guild.widget;

import android.graphics.Canvas;

abstract class RadiusFrameLayout$CanvasRounder
{
  public static CanvasRounder a(RadiusFrameLayout.CornersHolder paramCornersHolder)
  {
    return new RadiusFrameLayout.RealCanvasRounder(paramCornersHolder);
  }
  
  abstract void a(float paramFloat);
  
  abstract void a(int paramInt1, int paramInt2);
  
  abstract void a(Canvas paramCanvas);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.RadiusFrameLayout.CanvasRounder
 * JD-Core Version:    0.7.0.1
 */