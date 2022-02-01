package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.animation.LinearInterpolator;

public class IdentifierDrawable
  extends Drawable
{
  public static int a;
  public int b = Color.argb(255, 137, 208, 67);
  public int c = Color.argb(255, 255, 66, 34);
  private Paint d = new Paint();
  private int e;
  private int f = -872415232;
  private int g = 0;
  private PorterDuffXfermode h = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
  private int i;
  private int j;
  private int k;
  private int l = Color.argb(127, 255, 255, 255);
  private int m = -1;
  private ValueAnimator n;
  
  private void a()
  {
    this.n = ValueAnimator.ofInt(new int[] { 0, 100 });
    this.n.addUpdateListener(new IdentifierDrawable.1(this));
    this.n.setDuration(3000L);
    this.n.setInterpolator(new LinearInterpolator());
    this.n.start();
  }
  
  private void c(int paramInt)
  {
    ValueAnimator localValueAnimator = this.n;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning()) && (paramInt == 7)) {
      this.n.cancel();
    }
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void b(int paramInt)
  {
    if (this.i != paramInt)
    {
      this.i = paramInt;
      paramInt = this.i;
      if (paramInt == 6)
      {
        a();
        return;
      }
      c(paramInt);
      this.m = -1;
      invalidateSelf();
    }
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Object localObject = getBounds();
    paramCanvas.save();
    int i3 = ((Rect)localObject).centerX();
    int i4 = ((Rect)localObject).centerY();
    int i5 = this.j;
    paramCanvas.clipRect((Rect)localObject);
    paramCanvas.drawColor(this.f);
    if (this.i > a)
    {
      this.d.setStyle(Paint.Style.FILL);
      this.d.setColor(this.g);
      this.d.setXfermode(this.h);
      float f1 = i3;
      float f2 = i4;
      float f3 = i5;
      paramCanvas.drawCircle(f1, f2, f3, this.d);
      int i6 = this.i;
      if (i6 > 1)
      {
        int i2 = this.b;
        int i1 = i2;
        switch (i6)
        {
        default: 
          i1 = i2;
          break;
        case 7: 
          i1 = -1;
          break;
        case 5: 
        case 6: 
          i1 = this.l;
          break;
        case 2: 
        case 4: 
          i1 = this.c;
        }
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setXfermode(null);
        this.d.setColor(i1);
        this.d.setStrokeWidth(this.k);
        paramCanvas.drawCircle(f1, f2, f3, this.d);
        if (this.m != -1)
        {
          localObject = new RectF(i3 - i5, i4 - i5, i3 + i5, i4 + i5);
          this.d.setStyle(Paint.Style.STROKE);
          this.d.setXfermode(null);
          this.d.setColor(-1);
          this.d.setStrokeWidth(this.k);
          paramCanvas.drawArc((RectF)localObject, 270.0F, this.m / 100.0F * 360.0F, false, this.d);
        }
      }
    }
    paramCanvas.restore();
  }
  
  public int getOpacity()
  {
    return this.e;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.IdentifierDrawable
 * JD-Core Version:    0.7.0.1
 */