package com.tencent.smtt.sdk.ui.dialog.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class c
  extends Drawable
{
  private float a;
  private float b;
  private float c;
  private float d;
  private Path e;
  private Paint f;
  private RectF g;
  
  public c(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.d = paramFloat3;
    this.c = paramFloat4;
    this.f = new Paint();
    this.f.setStyle(Paint.Style.FILL);
    this.f.setAntiAlias(true);
    this.f.setColor(paramInt);
    this.g = new RectF();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    RectF localRectF = this.g;
    localRectF.left = 0.0F;
    localRectF.top = 0.0F;
    localRectF.right = paramInt1;
    localRectF.bottom = paramInt2;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.e == null) {
      this.e = new Path();
    }
    this.e.reset();
    Path localPath = this.e;
    RectF localRectF = this.g;
    float f1 = this.a;
    float f2 = this.b;
    float f3 = this.d;
    float f4 = this.c;
    Path.Direction localDirection = Path.Direction.CCW;
    localPath.addRoundRect(localRectF, new float[] { f1, f1, f2, f2, f3, f3, f4, f4 }, localDirection);
    this.e.close();
    paramCanvas.drawPath(this.e, this.f);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    this.f.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.f.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.ui.dialog.widget.c
 * JD-Core Version:    0.7.0.1
 */