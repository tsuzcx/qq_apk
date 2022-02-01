package com.tencent.mobileqq.ocr.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;

public class TDCircleProgressView
  extends View
{
  private int a;
  private Paint b;
  private Paint c;
  private Paint d;
  private float e;
  private int f = Color.rgb(107, 203, 250);
  private int g;
  private float h;
  private Context i;
  
  public TDCircleProgressView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TDCircleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TDCircleProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.i = paramContext;
    this.g = 2;
    this.e = a(paramContext, 4.0F);
    this.b = new Paint();
    this.b.setAntiAlias(true);
    this.b.setStrokeWidth(this.e);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setColor(Color.rgb(144, 144, 144));
    this.b.setStrokeCap(Paint.Cap.ROUND);
    this.c = new Paint();
    this.c.setAntiAlias(true);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setStrokeWidth(this.e);
    this.c.setColor(this.f);
    this.c.setStrokeCap(Paint.Cap.ROUND);
    int j = this.g;
    if (j == 1) {
      this.h = -180.0F;
    } else if (j == 2) {
      this.h = -90.0F;
    } else if (j == 3) {
      this.h = 0.0F;
    } else if (j == 4) {
      this.h = 90.0F;
    }
    this.d = new Paint();
    this.d.setTextSize(a(paramContext, 11.0F));
    this.d.setTextAlign(Paint.Align.CENTER);
    this.d.setStyle(Paint.Style.FILL);
    this.d.setColor(Color.rgb(144, 144, 144));
  }
  
  public int getCurrent()
  {
    return this.a;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = this.e;
    Object localObject = new RectF(f1 / 2.0F, f1 / 2.0F, getWidth() - this.e / 2.0F, getHeight() - this.e / 2.0F);
    paramCanvas.drawArc((RectF)localObject, 0.0F, 360.0F, false, this.b);
    f1 = this.a * 360 / 100;
    paramCanvas.drawArc((RectF)localObject, this.h, f1, false, this.c);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("%");
    paramCanvas.drawText(((StringBuilder)localObject).toString(), getWidth() / 2, getHeight() / 2 + a(this.i, 4.0F), this.d);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (paramInt1 >= paramInt2) {
      paramInt1 = paramInt2;
    }
    setMeasuredDimension(paramInt1, paramInt1);
  }
  
  public void setCurrent(int paramInt)
  {
    this.a = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.TDCircleProgressView
 * JD-Core Version:    0.7.0.1
 */