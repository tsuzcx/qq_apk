package com.tencent.mobileqq.flashshow.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.tencent.biz.flashshow.impl.R.styleable;

public class RoundProgressBar
  extends View
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private float g;
  private String h = "0%";
  private Rect i;
  private Paint j;
  private RectF k;
  
  public RoundProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.dD, paramInt, 0);
    this.a = paramContext.getDimensionPixelSize(R.styleable.dJ, (int)TypedValue.applyDimension(2, 16.0F, getResources().getDisplayMetrics()));
    this.b = paramContext.getColor(R.styleable.dI, -16777216);
    this.d = paramContext.getColor(R.styleable.dE, -16777216);
    this.c = paramContext.getDimensionPixelSize(R.styleable.dF, (int)TypedValue.applyDimension(1, 1.0F, getResources().getDisplayMetrics()));
    this.e = paramContext.getColor(R.styleable.dG, -16777216);
    this.f = paramContext.getInt(R.styleable.dH, 10);
    paramContext.recycle();
    a();
  }
  
  private void a()
  {
    this.i = new Rect();
    this.j = new Paint(1);
    this.j.setAntiAlias(true);
    this.k = new RectF();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.j.setColor(this.d);
    this.j.setStyle(Paint.Style.STROKE);
    this.j.setStrokeWidth(this.c);
    this.j.setStrokeCap(Paint.Cap.ROUND);
    int m = getWidth() / 2;
    int n = m - this.c;
    float f1 = m;
    paramCanvas.drawCircle(f1, f1, n, this.j);
    this.j.setColor(this.e);
    Object localObject = this.k;
    float f2 = m - n;
    float f3 = n + m;
    ((RectF)localObject).set(f2, f2, f3, f3);
    paramCanvas.drawArc(this.k, -90.0F, this.g, false, this.j);
    this.j.reset();
    this.j.setAntiAlias(true);
    this.j.setColor(this.b);
    this.j.setTextSize(this.a);
    localObject = this.j;
    String str = this.h;
    ((Paint)localObject).getTextBounds(str, 0, str.length(), this.i);
    paramCanvas.drawText(this.h, f1 - this.i.width() / 2.0F, f1 + this.i.height() / 2.0F, this.j);
  }
  
  public void setProgress(int paramInt)
  {
    this.g = (paramInt * 3.6F);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Math.round(this.g / 360.0F * 100.0F));
    localStringBuilder.append("%");
    this.h = localStringBuilder.toString();
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.RoundProgressBar
 * JD-Core Version:    0.7.0.1
 */