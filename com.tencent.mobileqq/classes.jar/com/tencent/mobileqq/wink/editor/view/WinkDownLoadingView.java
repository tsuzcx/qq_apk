package com.tencent.mobileqq.wink.editor.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class WinkDownLoadingView
  extends View
{
  private static float o;
  protected Paint a;
  protected Paint b;
  protected Path c;
  protected int d;
  protected int e;
  protected RectF f;
  protected RectF g;
  protected long h;
  protected long i;
  protected float j;
  protected float k;
  protected float l;
  boolean m;
  boolean n;
  private int p;
  private int q;
  
  public WinkDownLoadingView(Context paramContext)
  {
    super(paramContext);
    int i1 = this.d;
    float f1 = i1 - 16843176;
    int i2 = this.e;
    this.g = new RectF(f1, i2 - 16843176, i1 + 16843176, i2 + 16843176);
    this.h = 100L;
    this.i = 0L;
    this.j = a(2.0F, getContext());
    this.k = a(17.5F, getContext());
    this.l = a(2.5F, getContext());
    this.m = false;
    this.n = true;
    a();
  }
  
  public WinkDownLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i1 = this.d;
    float f1 = i1 - 16843176;
    int i2 = this.e;
    this.g = new RectF(f1, i2 - 16843176, i1 + 16843176, i2 + 16843176);
    this.h = 100L;
    this.i = 0L;
    this.j = a(2.0F, getContext());
    this.k = a(17.5F, getContext());
    this.l = a(2.5F, getContext());
    this.m = false;
    this.n = true;
    a();
  }
  
  public WinkDownLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramInt = this.d;
    float f1 = paramInt - 16843176;
    int i1 = this.e;
    this.g = new RectF(f1, i1 - 16843176, paramInt + 16843176, i1 + 16843176);
    this.h = 100L;
    this.i = 0L;
    this.j = a(2.0F, getContext());
    this.k = a(17.5F, getContext());
    this.l = a(2.5F, getContext());
    this.m = false;
    this.n = true;
    a();
  }
  
  private static int a(float paramFloat, Context paramContext)
  {
    if (o == 0.0F) {
      o = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(paramFloat * o);
  }
  
  protected void a()
  {
    this.a = new Paint(1);
    this.a.setStyle(Paint.Style.FILL);
    this.a.setColor(2130706432);
    this.b = new Paint(1);
    this.b.setStyle(Paint.Style.FILL);
    this.b.setColor(0);
    this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    this.c = new Path();
  }
  
  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.m)
    {
      localRectF = this.f;
      f1 = this.j;
      paramCanvas.drawRoundRect(localRectF, f1, f1, this.a);
      return;
    }
    RectF localRectF = this.f;
    float f1 = this.j;
    paramCanvas.drawRoundRect(localRectF, f1, f1, this.a);
    long l1 = this.i;
    if (l1 >= 0L)
    {
      long l2 = this.h;
      if (l1 <= l2)
      {
        f1 = (float)l1 * 360.0F / (float)l2;
        if (this.n)
        {
          paramCanvas.drawCircle(this.d, this.e, this.k, this.b);
          paramCanvas.drawCircle(this.d, this.e, this.k - this.l, this.a);
          this.c.reset();
          this.c.moveTo(this.d, this.e);
          this.c.arcTo(this.g, 270.0F, f1);
          paramCanvas.drawPath(this.c, this.b);
          return;
        }
        paramCanvas.drawArc(this.g, 270.0F, f1, false, this.b);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.p = paramInt1;
    this.q = paramInt2;
    paramInt1 = this.p;
    this.d = (paramInt1 / 2);
    paramInt2 = this.q;
    this.e = (paramInt2 / 2);
    this.f = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
    float f1 = this.k - this.l;
    paramInt1 = this.d;
    float f2 = paramInt1;
    paramInt2 = this.e;
    this.g = new RectF(f2 - f1, paramInt2 - f1, paramInt1 + f1, paramInt2 + f1);
  }
  
  public void setBgColor(int paramInt)
  {
    this.a.setColor(paramInt);
  }
  
  public void setBgCorner(float paramFloat)
  {
    this.j = paramFloat;
  }
  
  public void setMax(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setProgress(long paramLong)
  {
    this.i = paramLong;
    if (this.i == this.h) {
      setVisibility(4);
    }
    invalidate();
  }
  
  public void setProgressColor(int paramInt)
  {
    this.b.setColor(paramInt);
  }
  
  public void setProgressSizeAndMode(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.k = paramFloat1;
    this.l = paramFloat2;
    paramFloat1 = this.k - this.l;
    int i1 = this.d;
    float f1 = i1;
    int i2 = this.e;
    this.g = new RectF(f1 - paramFloat1, i2 - paramFloat1, i1 + paramFloat1, i2 + paramFloat1);
    this.n = paramBoolean;
    if (this.n)
    {
      this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.b.setStyle(Paint.Style.FILL);
      return;
    }
    this.b.setStrokeWidth(paramFloat2);
    this.b.setXfermode(null);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeCap(Paint.Cap.ROUND);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.view.WinkDownLoadingView
 * JD-Core Version:    0.7.0.1
 */