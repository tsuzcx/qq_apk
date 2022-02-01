package com.tencent.mobileqq.guild.widget;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;

class RadiusFrameLayout$RealCanvasRounder
  extends RadiusFrameLayout.CanvasRounder
{
  private final Path a = new Path();
  private final RadiusFrameLayout.CornersHolder b;
  private final RectF c = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
  
  RadiusFrameLayout$RealCanvasRounder(RadiusFrameLayout.CornersHolder paramCornersHolder)
  {
    this.b = paramCornersHolder;
  }
  
  void a(float paramFloat)
  {
    this.a.reset();
    Path localPath = this.a;
    RectF localRectF = this.c;
    Path.Direction localDirection = Path.Direction.CW;
    localPath.addRoundRect(localRectF, new float[] { paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat }, localDirection);
    this.a.close();
  }
  
  void a(int paramInt1, int paramInt2)
  {
    this.c.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.a.reset();
    Path localPath = this.a;
    RectF localRectF = this.c;
    float f1 = this.b.a;
    float f2 = this.b.a;
    float f3 = this.b.b;
    float f4 = this.b.b;
    float f5 = this.b.c;
    float f6 = this.b.c;
    float f7 = this.b.d;
    float f8 = this.b.d;
    Path.Direction localDirection = Path.Direction.CW;
    localPath.addRoundRect(localRectF, new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, localDirection);
    this.a.close();
  }
  
  void a(Canvas paramCanvas)
  {
    paramCanvas.clipPath(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.RadiusFrameLayout.RealCanvasRounder
 * JD-Core Version:    0.7.0.1
 */