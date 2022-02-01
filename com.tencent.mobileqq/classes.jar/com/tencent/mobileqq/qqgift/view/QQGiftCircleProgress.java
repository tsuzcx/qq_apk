package com.tencent.mobileqq.qqgift.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.widget.RoundImageView;

public class QQGiftCircleProgress
  extends RoundImageView
{
  int a;
  float b;
  int c;
  int d;
  int e = 9;
  int f;
  int g;
  int h;
  int i;
  int j;
  Paint k;
  float l;
  RectF m = new RectF();
  boolean n = true;
  boolean o = true;
  
  public QQGiftCircleProgress(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QQGiftCircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.b = getResources().getDisplayMetrics().density;
    this.c = getResources().getColor(2131166114);
    this.g = getResources().getColor(2131165990);
    this.f = 51;
    this.h = 255;
    this.d = getResources().getColor(2131166040);
    this.k = new Paint();
    this.k.setAntiAlias(true);
    this.k.setStyle(Paint.Style.STROKE);
  }
  
  protected void a(Canvas paramCanvas)
  {
    this.k.setColor(this.c);
    if (this.n) {
      this.k.setAlpha(this.f * 255 / 100);
    }
    this.k.setShadowLayer(this.e, 0.0F, 0.0F, this.d);
    paramCanvas.drawArc(this.m, -90.0F, 360.0F, false, this.k);
    this.k.setColor(this.g);
    if (this.o) {
      this.k.setAlpha(this.h * 255 / 100);
    }
    this.k.setShadowLayer(this.e, 0.0F, 0.0F, this.d);
    RectF localRectF = this.m;
    int i1 = this.a;
    localRectF.set(i1, i1, this.i - i1, this.j - i1);
    localRectF = this.m;
    double d1 = this.l;
    Double.isNaN(d1);
    paramCanvas.drawArc(localRectF, -90.0F, (float)(d1 * 3.6D), false, this.k);
  }
  
  public float getProgress()
  {
    return this.l;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.i = getWidth();
    this.j = getHeight();
    RectF localRectF = this.m;
    int i1 = this.a;
    localRectF.set(i1, i1, this.i - i1, this.j - i1);
    a(paramCanvas);
  }
  
  public void setBgAndProgressColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c = paramInt2;
    this.f = paramInt1;
    this.g = paramInt4;
    this.h = paramInt3;
  }
  
  public void setBgAndProgressUseAlpha(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.n = paramBoolean1;
    this.o = paramBoolean2;
  }
  
  public void setProgress(float paramFloat)
  {
    float f1 = 100.0F;
    if (paramFloat <= 100.0F) {
      f1 = paramFloat;
    }
    this.l = f1;
    f1 = paramFloat;
    if (paramFloat < 0.0F) {
      f1 = 0.0F;
    }
    this.l = f1;
    invalidate();
  }
  
  public void setShadowRadius(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    double d1 = paramFloat * this.b;
    Double.isNaN(d1);
    this.a = ((int)(d1 + 0.5D));
    this.k.setStrokeWidth(this.a);
  }
  
  public void setmShadowColor(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.view.QQGiftCircleProgress
 * JD-Core Version:    0.7.0.1
 */