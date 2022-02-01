package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

public class MetaballView
  extends View
{
  float[] a = new float[2];
  float[] b = new float[2];
  float[] c = new float[2];
  float[] d = new float[2];
  float[] e = new float[2];
  float[] f = new float[2];
  float[] g = new float[2];
  float[] h = new float[2];
  float[] i = new float[2];
  float[] j = new float[2];
  float[] k = new float[2];
  float[] l = new float[2];
  float[] m = new float[2];
  Path n = new Path();
  private Paint o = new Paint();
  private float p = 1.0F;
  private float q = 10.0F;
  private final int r = 2;
  private int s = 60;
  private final float t = 0.3F;
  private float u;
  private ArrayList<MetaballView.Circle> v = new ArrayList();
  private float w;
  private MetaballView.MoveAnimation x;
  private MetaballView.Circle y;
  
  public MetaballView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public MetaballView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
    a();
  }
  
  public MetaballView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private float a(float[] paramArrayOfFloat)
  {
    return (float)Math.sqrt(paramArrayOfFloat[0] * paramArrayOfFloat[0] + paramArrayOfFloat[1] * paramArrayOfFloat[1]);
  }
  
  private float a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f1 = paramArrayOfFloat1[0] - paramArrayOfFloat2[0];
    float f2 = paramArrayOfFloat1[1] - paramArrayOfFloat2[1];
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private void a()
  {
    this.q = getRadius();
    this.s = getItemDivider();
    float f1 = this.q * 1.3F;
    this.o.setColor(-16395392);
    this.o.setStyle(Paint.Style.FILL);
    this.o.setAntiAlias(true);
    MetaballView.Circle localCircle = new MetaballView.Circle(this, null);
    float f2 = this.q;
    localCircle.a = new float[] { this.s + f2, f1 };
    localCircle.b = (f2 / 4.0F * 3.0F);
    this.v.add(localCircle);
    int i1 = 1;
    while (i1 < 2)
    {
      localCircle = new MetaballView.Circle(this, null);
      f2 = this.q;
      localCircle.a = new float[] { (2.0F * f2 + this.s) * i1, f1 };
      localCircle.b = f2;
      this.v.add(localCircle);
      i1 += 1;
    }
    f1 = this.q;
    this.u = ((f1 * 2.0F + this.s) * 2.0F - f1 * 2.0F);
  }
  
  private void a(float paramFloat1, float paramFloat2, float[] paramArrayOfFloat)
  {
    double d2 = paramFloat1;
    double d3 = Math.cos(d2);
    double d1 = paramFloat2;
    Double.isNaN(d1);
    paramArrayOfFloat[0] = ((float)(d3 * d1));
    d2 = Math.sin(d2);
    Double.isNaN(d1);
    paramArrayOfFloat[1] = ((float)(d2 * d1));
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Object localObject1 = (MetaballView.Circle)this.v.get(paramInt2);
    Object localObject2 = (MetaballView.Circle)this.v.get(paramInt1);
    float f4 = a(((MetaballView.Circle)localObject1).a, ((MetaballView.Circle)localObject2).a);
    float f3 = ((MetaballView.Circle)localObject1).b;
    float f1 = ((MetaballView.Circle)localObject2).b;
    if (f4 > paramFloat3)
    {
      paramCanvas.drawCircle(localObject2.a[0], localObject2.a[1], f1, this.o);
    }
    else
    {
      f1 *= ((1.0F - f4 / paramFloat3) * 0.3F + 1.0F);
      paramCanvas.drawCircle(localObject2.a[0], localObject2.a[1], f1, this.o);
    }
    float f2 = 0.0F;
    if (f3 != 0.0F)
    {
      if (f1 == 0.0F) {
        return;
      }
      if (f4 <= paramFloat3)
      {
        float f6 = f3 - f1;
        if (f4 <= Math.abs(f6)) {
          return;
        }
        float f5 = f3 + f1;
        if (f4 < f5)
        {
          paramFloat3 = f3 * f3;
          f7 = f4 * f4;
          f8 = f1 * f1;
          f2 = (float)Math.acos((paramFloat3 + f7 - f8) / (f3 * 2.0F * f4));
          paramFloat3 = (float)Math.acos((f8 + f7 - paramFloat3) / (f1 * 2.0F * f4));
        }
        else
        {
          paramFloat3 = 0.0F;
        }
        float f7 = (float)Math.atan2(localObject2.a[1] - localObject1.a[1], localObject2.a[0] - localObject1.a[0]);
        float f8 = (float)Math.acos(f6 / f4);
        float f9 = (f8 - f2) * paramFloat1;
        f6 = f7 + f2 + f9;
        f2 = f7 - f2 - f9;
        double d1 = f7;
        Double.isNaN(d1);
        double d2 = paramFloat3;
        Double.isNaN(d2);
        Double.isNaN(d2);
        double d3 = f8;
        Double.isNaN(d3);
        double d4 = paramFloat1;
        Double.isNaN(d4);
        d3 = (3.141592653589793D - d2 - d3) * d4;
        paramFloat3 = (float)(d1 + 3.141592653589793D - d2 - d3);
        Double.isNaN(d1);
        Double.isNaN(d2);
        f7 = (float)(d1 - 3.141592653589793D + d2 + d3);
        a(f6, f3, this.a);
        a(f2, f3, this.b);
        a(paramFloat3, f1, this.c);
        a(f7, f1, this.d);
        this.e[0] = (this.a[0] + localObject1.a[0]);
        this.e[1] = (this.a[1] + localObject1.a[1]);
        this.f[0] = (this.b[0] + localObject1.a[0]);
        this.f[1] = (this.b[1] + localObject1.a[1]);
        this.g[0] = (this.c[0] + localObject2.a[0]);
        this.g[1] = (this.c[1] + localObject2.a[1]);
        this.h[0] = (this.d[0] + localObject2.a[0]);
        this.h[1] = (this.d[1] + localObject2.a[1]);
        localObject1 = this.i;
        localObject2 = this.e;
        f8 = localObject2[0];
        float[] arrayOfFloat = this.g;
        localObject1[0] = (f8 - arrayOfFloat[0]);
        localObject2[1] -= arrayOfFloat[1];
        paramFloat1 = Math.min(paramFloat1 * paramFloat2, a((float[])localObject1) / f5) * Math.min(1.0F, 2.0F * f4 / f5);
        paramFloat2 = f3 * paramFloat1;
        paramFloat1 = f1 * paramFloat1;
        a(f6 - 1.570796F, paramFloat2, this.j);
        a(paramFloat3 + 1.570796F, paramFloat1, this.k);
        a(f7 - 1.570796F, paramFloat1, this.l);
        a(f2 + 1.570796F, paramFloat2, this.m);
        this.n.reset();
        localObject1 = this.n;
        localObject2 = this.e;
        ((Path)localObject1).moveTo(localObject2[0], localObject2[1]);
        localObject1 = this.n;
        localObject2 = this.e;
        paramFloat1 = localObject2[0];
        arrayOfFloat = this.j;
        paramFloat2 = arrayOfFloat[0];
        paramFloat3 = localObject2[1];
        f1 = arrayOfFloat[1];
        localObject2 = this.g;
        f2 = localObject2[0];
        arrayOfFloat = this.k;
        ((Path)localObject1).cubicTo(paramFloat2 + paramFloat1, paramFloat3 + f1, arrayOfFloat[0] + f2, localObject2[1] + arrayOfFloat[1], localObject2[0], localObject2[1]);
        localObject1 = this.n;
        localObject2 = this.h;
        ((Path)localObject1).lineTo(localObject2[0], localObject2[1]);
        localObject1 = this.n;
        localObject2 = this.h;
        paramFloat1 = localObject2[0];
        arrayOfFloat = this.l;
        paramFloat2 = arrayOfFloat[0];
        paramFloat3 = localObject2[1];
        f1 = arrayOfFloat[1];
        localObject2 = this.f;
        f2 = localObject2[0];
        arrayOfFloat = this.m;
        ((Path)localObject1).cubicTo(paramFloat2 + paramFloat1, paramFloat3 + f1, arrayOfFloat[0] + f2, localObject2[1] + arrayOfFloat[1], localObject2[0], localObject2[1]);
        localObject1 = this.n;
        localObject2 = this.e;
        ((Path)localObject1).lineTo(localObject2[0], localObject2[1]);
        this.n.close();
        paramCanvas.drawPath(this.n, this.o);
      }
    }
  }
  
  private void b()
  {
    clearAnimation();
    postInvalidate();
  }
  
  private void c()
  {
    this.x = new MetaballView.MoveAnimation(this, null);
    this.x.setDuration(1000L);
    this.x.setInterpolator(new AccelerateDecelerateInterpolator());
    this.x.setRepeatCount(-1);
    this.x.setRepeatMode(2);
    startAnimation(this.x);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {}
  
  protected int getItemDivider()
  {
    return (int)((IUIToolsApi)QRoute.api(IUIToolsApi.class)).dp2px(getContext(), 20.0F);
  }
  
  protected int getRadius()
  {
    return (int)((IUIToolsApi)QRoute.api(IUIToolsApi.class)).dp2px(getContext(), 10.0F);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (getVisibility() == 0) {
      c();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (getVisibility() == 0) {
      b();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.y = ((MetaballView.Circle)this.v.get(0));
    this.y.a[0] = (this.u * this.w + this.q);
    float f1 = this.y.a[0];
    float[] arrayOfFloat = this.y.a;
    int i1 = 1;
    paramCanvas.drawCircle(f1, arrayOfFloat[1], this.y.b, this.o);
    int i2 = this.v.size();
    while (i1 < i2)
    {
      a(paramCanvas, i1, 0, 0.6F, this.p, this.q * 2.0F);
      i1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(resolveSizeAndState((int)((this.q * 2.0F + this.s) * 2.0F), paramInt1, 0), resolveSizeAndState((int)(this.q * 2.0F * 1.4F), paramInt2, 0));
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if ((paramInt == 0) && (getVisibility() == 0)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt == 0)
    {
      b();
      return;
    }
    c();
  }
  
  public void setPaintMode(int paramInt)
  {
    Paint localPaint = this.o;
    Paint.Style localStyle;
    if (paramInt == 0) {
      localStyle = Paint.Style.STROKE;
    } else {
      localStyle = Paint.Style.FILL;
    }
    localPaint.setStyle(localStyle);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.MetaballView
 * JD-Core Version:    0.7.0.1
 */