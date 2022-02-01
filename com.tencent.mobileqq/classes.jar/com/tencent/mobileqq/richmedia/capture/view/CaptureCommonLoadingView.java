package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class CaptureCommonLoadingView
  extends View
{
  private static float a;
  private Paint b;
  private Paint c;
  private Path d;
  private int e;
  private int f;
  private int g;
  private int h;
  private RectF i;
  private RectF j;
  private int k;
  private int l;
  private float m;
  private float n;
  private float o;
  
  public CaptureCommonLoadingView(Context paramContext)
  {
    super(paramContext);
    int i1 = this.g;
    float f1 = i1 - 16843176;
    int i2 = this.h;
    this.j = new RectF(f1, i2 - 16843176, i1 + 16843176, i2 + 16843176);
    this.k = 100;
    this.l = 0;
    this.m = a(2.0F, getContext());
    this.n = a(17.5F, getContext());
    this.o = a(2.5F, getContext());
    a();
  }
  
  public CaptureCommonLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i1 = this.g;
    float f1 = i1 - 16843176;
    int i2 = this.h;
    this.j = new RectF(f1, i2 - 16843176, i1 + 16843176, i2 + 16843176);
    this.k = 100;
    this.l = 0;
    this.m = a(2.0F, getContext());
    this.n = a(17.5F, getContext());
    this.o = a(2.5F, getContext());
    a();
  }
  
  public CaptureCommonLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramInt = this.g;
    float f1 = paramInt - 16843176;
    int i1 = this.h;
    this.j = new RectF(f1, i1 - 16843176, paramInt + 16843176, i1 + 16843176);
    this.k = 100;
    this.l = 0;
    this.m = a(2.0F, getContext());
    this.n = a(17.5F, getContext());
    this.o = a(2.5F, getContext());
    a();
  }
  
  public static int a(float paramFloat, Context paramContext)
  {
    if (a == 0.0F) {
      a = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(paramFloat * a);
  }
  
  private void a()
  {
    this.b = new Paint(1);
    this.b.setStyle(Paint.Style.FILL);
    this.b.setColor(2130706432);
    this.c = new Paint(1);
    this.b.setStyle(Paint.Style.FILL);
    this.c.setColor(0);
    this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    this.d = new Path();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    RectF localRectF = this.i;
    float f1 = this.m;
    paramCanvas.drawRoundRect(localRectF, f1, f1, this.b);
    paramCanvas.drawCircle(this.g, this.h, this.n, this.c);
    paramCanvas.drawCircle(this.g, this.h, this.n - this.o, this.b);
    f1 = this.l * 360.0F / this.k;
    this.d.moveTo(this.g, this.h);
    this.d.arcTo(this.j, 270.0F, f1);
    paramCanvas.drawPath(this.d, this.c);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.e = paramInt1;
    this.f = paramInt2;
    paramInt1 = this.e;
    this.g = (paramInt1 / 2);
    paramInt2 = this.f;
    this.h = (paramInt2 / 2);
    this.i = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
    float f1 = this.n - this.o;
    paramInt1 = this.g;
    float f2 = paramInt1;
    paramInt2 = this.h;
    this.j = new RectF(f2 - f1, paramInt2 - f1, paramInt1 + f1, paramInt2 + f1);
  }
  
  public void setCorner(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void setMax(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setProgress(int paramInt)
  {
    this.l = paramInt;
    invalidate();
    if (this.l == this.k) {
      setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CaptureCommonLoadingView
 * JD-Core Version:    0.7.0.1
 */