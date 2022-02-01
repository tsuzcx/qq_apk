package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class ProgressCircle
  extends View
{
  public boolean a = true;
  public boolean b = false;
  public int c;
  public int d;
  public int e = 2;
  public Paint.Style f = Paint.Style.STROKE;
  private Paint g;
  private RectF h;
  private int i;
  private int j;
  private int k;
  
  public ProgressCircle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  protected void a()
  {
    this.g = new Paint();
    this.h = new RectF();
    this.j = 2;
    this.k = 18;
    this.c = getResources().getColor(2131168049);
    this.d = getResources().getColor(2131168049);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1 = getWidth();
    int i2 = getHeight();
    int m = i1;
    int n = i2;
    if (i1 != i2)
    {
      if (i1 < i2) {
        m = i1;
      } else {
        m = i2;
      }
      n = m;
    }
    this.g.setAntiAlias(true);
    this.g.setColor(-1);
    paramCanvas.drawColor(0);
    Object localObject = this.h;
    i1 = this.j;
    ((RectF)localObject).left = (i1 / 2);
    ((RectF)localObject).top = (i1 / 2);
    ((RectF)localObject).right = (m - i1 / 2);
    ((RectF)localObject).bottom = (n - i1 / 2);
    this.g.setStrokeWidth(i1);
    this.g.setColor(this.c);
    this.g.setStyle(this.f);
    paramCanvas.drawArc(this.h, -90.0F, 360.0F, false, this.g);
    this.g.setColor(this.d);
    this.g.setStrokeWidth(this.j * this.e);
    localObject = this.h;
    i1 = this.j;
    ((RectF)localObject).left = i1;
    ((RectF)localObject).top = i1;
    ((RectF)localObject).right = (m - i1);
    ((RectF)localObject).bottom = (n - i1);
    paramCanvas.drawArc((RectF)localObject, -90.0F, this.i / 100.0F * 360.0F, false, this.g);
    if (this.a)
    {
      m /= 2;
      n /= 2;
      this.g.setStyle(Paint.Style.FILL);
      this.g.setStrokeWidth(this.j);
      i1 = this.k;
      paramCanvas.drawRect(new RectF(m - i1 / 2, n - i1 / 2, m + i1 / 2, n + i1 / 2), this.g);
    }
    if (this.b)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append("%");
      localObject = ((StringBuilder)localObject).toString();
      this.g.setTextSize(40.0F);
      this.g.setStrokeWidth(1.0F);
      this.g.setColor(-1);
      this.g.setStyle(Paint.Style.FILL);
      float f1 = this.g.measureText((String)localObject);
      Paint.FontMetricsInt localFontMetricsInt = this.g.getFontMetricsInt();
      m = (int)((getWidth() - f1) / 2.0F);
      n = (getHeight() - (localFontMetricsInt.descent - localFontMetricsInt.ascent)) / 2;
      i1 = -localFontMetricsInt.ascent;
      paramCanvas.drawText((String)localObject, m, n + i1, this.g);
    }
  }
  
  public void setProgress(int paramInt)
  {
    this.i = paramInt;
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProgressCircle
 * JD-Core Version:    0.7.0.1
 */