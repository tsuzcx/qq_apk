package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R.styleable;

public class BubbleFrameLayout
  extends FrameLayout
{
  private static final int a = Color.argb(25, 0, 0, 0);
  private float b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private Path l = new Path();
  private RectF m = new RectF();
  private Paint n = new Paint(1);
  private float o;
  private float p;
  private float q;
  private float r;
  private float s;
  private float t;
  
  public BubbleFrameLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BubbleFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    setPadding(getPaddingLeft() + this.f, getPaddingTop() + this.f, getPaddingRight() + this.f, getPaddingBottom() + this.g + this.f);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.BubbleFrameLayout, 0, 0);
    try
    {
      this.b = paramContext.getFloat(8, 0.6F);
      this.g = paramContext.getDimensionPixelSize(9, 24);
      this.c = paramContext.getDimensionPixelSize(2, 6);
      this.i = paramContext.getDimensionPixelSize(5, 0);
      this.h = paramContext.getDimensionPixelSize(6, 4);
      this.f = paramContext.getDimensionPixelSize(7, 24);
      this.k = paramContext.getColor(4, a);
      this.j = paramContext.getColor(0, -1);
      this.d = paramContext.getColor(1, -1644826);
      this.e = paramContext.getDimensionPixelSize(3, 1);
      paramContext.recycle();
      this.l.setFillType(Path.FillType.WINDING);
      this.n.setShadowLayer(this.f, this.i, this.h, this.k);
      setLayerType(1, this.n);
      setWillNotDraw(false);
      a();
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    int i1 = this.f;
    int i3 = getWidth();
    int i2 = this.f;
    i3 -= i2;
    int i4 = getHeight() - this.g - this.f;
    Object localObject = this.l;
    float f2 = this.c + i1;
    float f1 = i4;
    ((Path)localObject).moveTo(f2, f1);
    localObject = this.m;
    float f3 = i1;
    int i5 = this.c;
    ((RectF)localObject).set(f3, i4 - i5 * 2, i5 * 2 + i1, f1);
    this.l.arcTo(this.m, 90.0F, 90.0F);
    this.l.lineTo(f3, this.c + i2);
    localObject = this.m;
    f2 = i2;
    i5 = this.c;
    ((RectF)localObject).set(f3, f2, i5 * 2 + i1, i5 * 2 + i2);
    this.l.arcTo(this.m, -180.0F, 90.0F);
    this.l.lineTo(i3 - this.c, f2);
    localObject = this.m;
    i5 = this.c;
    f3 = i3 - i5 * 2;
    float f4 = i3;
    ((RectF)localObject).set(f3, f2, f4, i2 + i5 * 2);
    this.l.arcTo(this.m, -90.0F, 90.0F);
    this.l.lineTo(f4, i4 - this.c);
    localObject = this.m;
    i2 = this.c;
    ((RectF)localObject).set(i3 - i2 * 2, i4 - i2 * 2, f4, f1);
    this.l.arcTo(this.m, 0.0F, 90.0F);
    this.q = (getWidth() * this.b);
    this.r = (getHeight() - this.f);
    f2 = this.q;
    i2 = this.g;
    this.o = (f2 - i2);
    this.p = (this.r - i2);
    this.s = (this.o + i2 * 2);
    this.t = this.p;
    this.l.lineTo(this.s, this.t);
    this.l.lineTo(this.q, this.r);
    this.l.lineTo(this.o, this.p);
    this.l.lineTo(i1 + this.c, f1);
    this.l.close();
    paramCanvas.drawPath(this.l, this.n);
    this.l.reset();
    paramCanvas.restore();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.translate(0.0F, this.f / 2);
    this.n.setColor(this.j);
    a(paramCanvas);
    this.n.setStyle(Paint.Style.STROKE);
    this.n.setStrokeWidth(this.e);
    this.n.setColor(this.d);
    a(paramCanvas);
    this.n.setAlpha(255);
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.BubbleFrameLayout
 * JD-Core Version:    0.7.0.1
 */