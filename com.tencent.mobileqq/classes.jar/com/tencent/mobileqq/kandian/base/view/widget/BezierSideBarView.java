package com.tencent.mobileqq.kandian.base.view.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.utils.DisplayUtils;

public class BezierSideBarView
  extends View
{
  protected Paint a = new Paint();
  ValueAnimator b;
  protected Drawable c;
  private Paint d = new Paint();
  private int e;
  private int f;
  private Path g = new Path();
  private int h;
  private int i;
  private float j;
  private float k;
  private Bitmap l;
  
  public BezierSideBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BezierSideBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BezierSideBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.k = ((int)DisplayUtils.a(paramContext, 18.0F));
    this.e = -16777216;
    this.i = ((int)DisplayUtils.a(paramContext, 18.0F));
    this.d = new Paint();
    this.d.setAntiAlias(true);
    this.d.setStyle(Paint.Style.FILL);
    this.d.setColor(-1);
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.a.setStyle(Paint.Style.FILL);
    this.a.setColor(this.e);
    paramAttributeSet = BitmapFactory.decodeResource(paramContext.getResources(), 2130844358);
    if (paramAttributeSet != null) {
      this.l = Bitmap.createScaledBitmap(paramAttributeSet, (int)DisplayUtils.a(paramContext, 7.0F), (int)DisplayUtils.a(paramContext, 12.0F), true);
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    this.g.reset();
    this.g.moveTo(this.f, getTopEndY());
    int m = this.h;
    int n = this.i;
    m -= n * 2;
    double d1 = this.f;
    double d2 = n;
    double d3 = Math.cos(0.7853981633974483D);
    Double.isNaN(d2);
    double d4 = this.j;
    Double.isNaN(d4);
    Double.isNaN(d1);
    n = (int)(d1 - d2 * d3 * d4);
    d1 = m;
    d2 = this.i;
    d3 = Math.sin(0.7853981633974483D);
    Double.isNaN(d2);
    Double.isNaN(d1);
    int i1 = (int)(d1 + d2 * d3);
    Object localObject = this.g;
    float f1 = this.f;
    float f2 = m;
    float f3 = n;
    ((Path)localObject).quadTo(f1, f2, f3, i1);
    d1 = this.f;
    d2 = getCenterX();
    Double.isNaN(d1);
    m = (int)(d1 - d2);
    n = this.h;
    int i2 = this.i;
    i1 = i2 * 2 + n;
    d1 = i1;
    d2 = i2;
    d3 = Math.cos(0.7853981633974483D);
    Double.isNaN(d2);
    Double.isNaN(d1);
    i2 = (int)(d1 - d2 * d3);
    this.g.quadTo(m, n, f3, i2);
    localObject = this.g;
    i2 = this.f;
    ((Path)localObject).quadTo(i2, i1, i2, getBottomEndY());
    this.g.close();
    paramCanvas.drawPath(this.g, this.a);
    localObject = this.l;
    if ((localObject != null) && (this.c == null))
    {
      i1 = ((Bitmap)localObject).getWidth();
      i2 = this.l.getHeight();
      int i3 = m + 50;
      int i4 = n - i2 / 2;
      localObject = new Rect(0, 0, i1, i2);
      Rect localRect = new Rect(i3, i4, i1 + i3, i2 + i4);
      this.d.setAlpha((int)(this.j * 255.0F));
      paramCanvas.drawBitmap(this.l, (Rect)localObject, localRect, this.d);
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((Drawable)localObject).getIntrinsicWidth();
      i1 = this.c.getIntrinsicHeight() / 2;
      paramCanvas.save();
      paramCanvas.translate(m + 50, n - i1);
      this.c.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  public void a()
  {
    a(null);
  }
  
  public void a(float paramFloat, int paramInt)
  {
    this.h = paramInt;
    if (paramFloat < 0.0F) {
      return;
    }
    float f2 = this.k;
    float f1 = paramFloat;
    if (paramFloat > f2) {
      f1 = f2;
    }
    this.j = (f1 / this.k);
    invalidate();
  }
  
  public void a(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    if (this.b == null) {
      this.b = new ValueAnimator();
    }
    this.b.cancel();
    this.b.setFloatValues(new float[] { this.j, 0.0F });
    this.b.addUpdateListener(new BezierSideBarView.1(this, paramAnimatorUpdateListener));
    this.b.start();
  }
  
  protected int getBottomEndY()
  {
    int m = this.h;
    int n = this.i;
    return m + n * 2 + n;
  }
  
  public double getCenterX()
  {
    double d1 = this.i * 1.8F;
    double d2 = Math.sin(1.570796326794897D);
    Double.isNaN(d1);
    double d3 = this.j;
    Double.isNaN(d3);
    return d1 * d2 * d3;
  }
  
  public int getCenterY()
  {
    return this.h;
  }
  
  public int getRadius()
  {
    return this.i;
  }
  
  public float getRatio()
  {
    return this.j;
  }
  
  protected int getTopEndY()
  {
    return this.h - this.i * 3;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.f = getMeasuredWidth();
    this.h = (getMeasuredHeight() / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.BezierSideBarView
 * JD-Core Version:    0.7.0.1
 */