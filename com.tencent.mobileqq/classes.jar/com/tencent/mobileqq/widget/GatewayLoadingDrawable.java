package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;

public class GatewayLoadingDrawable
  extends Drawable
{
  private int a;
  private int b;
  private int c;
  private Paint d;
  private float e;
  private int f;
  private Path g;
  private Path h;
  private float i;
  private float j;
  private ValueAnimator k;
  private PathMeasure l;
  private final ValueAnimator m;
  private Bitmap n;
  private Rect o;
  private RectF p;
  private float q;
  private final ValueAnimator r;
  private float s;
  
  public GatewayLoadingDrawable()
  {
    Resources localResources = BaseApplication.getContext().getResources();
    this.d = new Paint();
    this.d.setColor(localResources.getColor(2131168041));
    this.d.setAntiAlias(true);
    this.d.setStyle(Paint.Style.STROKE);
    this.d.setStrokeCap(Paint.Cap.ROUND);
    this.e = Utils.a(1.5F, BaseApplication.getContext().getResources());
    this.d.setStrokeWidth(this.e);
    this.c = -1;
    this.k = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.k.setDuration(1400L).setInterpolator(new LinearInterpolator());
    this.k.setRepeatMode(1);
    this.k.setRepeatCount(-1);
    this.k.addUpdateListener(new GatewayLoadingDrawable.1(this));
    this.r = ValueAnimator.ofInt(new int[] { 0, 255 });
    this.r.setRepeatCount(0);
    this.r.setInterpolator(new LinearInterpolator());
    this.r.setDuration(400L);
    this.r.addUpdateListener(new GatewayLoadingDrawable.2(this));
    this.m = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.m.setDuration(500L).setInterpolator(new LinearInterpolator());
    this.m.setRepeatCount(0);
    this.m.addUpdateListener(new GatewayLoadingDrawable.3(this));
    this.n = BitmapFactory.decodeResource(localResources, 2130846521);
    this.o = new Rect(0, 0, this.n.getWidth(), this.n.getHeight());
  }
  
  private float a(float paramFloat)
  {
    if (paramFloat < 0.5F) {
      return paramFloat;
    }
    double d1 = paramFloat - 0.5F;
    Double.isNaN(d1);
    return (float)(Math.sin(d1 * 3.141592653589793D) * 0.5D + 0.5D);
  }
  
  private float b(float paramFloat)
  {
    if (paramFloat > 0.5F)
    {
      double d1 = paramFloat - 0.5F;
      Double.isNaN(d1);
      return (float)(Math.sin(d1 * 3.141592653589793D) * 0.75D + 0.25D);
    }
    return (float)Math.pow(paramFloat, 2.0D);
  }
  
  public void a()
  {
    this.f = 2;
    this.k.end();
    this.r.start();
    this.m.start();
  }
  
  public void b()
  {
    this.f = 1;
    this.c = 255;
    if (this.r.isRunning()) {
      this.r.end();
    }
    if (this.m.isRunning()) {
      this.m.end();
    }
    if (this.k.isRunning()) {
      this.k.end();
    }
    this.k.start();
  }
  
  public void c()
  {
    if (this.r.isRunning()) {
      this.r.end();
    }
    if (this.m.isRunning()) {
      this.m.end();
    }
    if (this.k.isRunning()) {
      this.k.end();
    }
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Object localObject;
    float f1;
    float f2;
    float f3;
    if ((this.a == 0) && (this.b == 0))
    {
      localObject = getBounds();
      this.a = ((Rect)localObject).width();
      this.b = ((Rect)localObject).height();
      this.s = (Math.min(this.b, this.a) / 2.0F - this.e);
      i1 = this.a;
      f1 = i1 / 2.0F;
      f2 = this.s;
      f3 = i1 / 2.0F;
      i1 = this.b;
      float f4 = i1 / 2.0F;
      float f5 = i1 / 2.0F;
      this.g = new Path();
      this.g.addArc(new RectF(f1 - f2, f4 - f2, f3 + f2, f5 + f2), -90.0F, 360.0F);
      this.h = new Path();
      this.l = new PathMeasure(this.g, false);
      this.j = this.l.getLength();
      f1 = this.s * 1.3F;
      f2 = this.n.getHeight() * f1 / this.n.getWidth();
      i1 = this.a;
      f3 = (i1 - f1) / 2.0F;
      int i2 = this.b;
      this.p = new RectF(f3, (i2 - f2) * 0.57F, (i1 + f1) / 2.0F, (i2 - f2) * 0.57F + f2);
    }
    int i1 = this.f;
    if (i1 == 1)
    {
      this.h.reset();
      f1 = b(this.i);
      f2 = a(this.i);
      localObject = this.l;
      f3 = this.j;
      ((PathMeasure)localObject).getSegment(f1 * f3, f2 * f3, this.h, true);
      paramCanvas.drawPath(this.h, this.d);
      return;
    }
    if (i1 == 2)
    {
      localObject = this.o;
      f1 = this.n.getWidth();
      f2 = this.q;
      ((Rect)localObject).right = ((int)(f1 * f2));
      localObject = this.p;
      ((RectF)localObject).right = (this.s * 1.3F * f2 + ((RectF)localObject).left);
      paramCanvas.drawBitmap(this.n, this.o, this.p, this.d);
      paramCanvas.drawPath(this.g, this.d);
    }
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GatewayLoadingDrawable
 * JD-Core Version:    0.7.0.1
 */