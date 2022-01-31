package com.tencent.widget;

import amaw;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class CountDownProgressBar
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Handler jdField_a_of_type_AndroidOsHandler = new amaw(this);
  private CountDownProgressBar.OnCountDownLinstener jdField_a_of_type_ComTencentWidgetCountDownProgressBar$OnCountDownLinstener;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 1000L;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private final int m = 0;
  private final int n = 1;
  private final int o = 2;
  
  public CountDownProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CountDownProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = paramContext.getResources().getColor(2131493263);
    this.jdField_b_of_type_Int = paramContext.getResources().getColor(2131493264);
    this.c = paramContext.getResources().getColor(2131493262);
    this.e = paramContext.getResources().getColor(2131492894);
    this.l = paramContext.getResources().getColor(2131493266);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.f = ((int)(21.0F * f1 + 0.5F));
    this.d = ((int)(2.0F * f1 + 0.5F));
    this.g = ((int)(18.0F * f1 + 0.5F));
    this.i = 0;
    this.k = Math.max(1, (int)(f1 * 0.5D + 0.5D));
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.i = 0;
    this.j = 0;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_b_of_type_Long = 1000L;
    if (this.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_Float = 0.0F;
      this.j = 100;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (getWidth() > getHeight()) {}
    for (int i1 = getHeight();; i1 = getWidth())
    {
      if (this.g > i1) {
        this.g = i1;
      }
      int i2 = this.g - this.k / 2;
      int i3 = i2 - this.d / 2;
      float f1 = i1 / 2;
      float f2 = i1 / 2;
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
      paramCanvas.drawCircle(f1, f2, this.g, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.k);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.l);
      paramCanvas.drawCircle(f1, f2, i2, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.d);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
      paramCanvas.drawCircle(f1, f2, i3, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.f);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
      float f3 = (this.jdField_a_of_type_AndroidGraphicsPaint.descent() + this.jdField_a_of_type_AndroidGraphicsPaint.ascent()) / 2.0F;
      paramCanvas.drawText(Integer.toString(this.h), f1, f2 - f3, this.jdField_a_of_type_AndroidGraphicsPaint);
      RectF localRectF = new RectF();
      f2 = i3;
      f3 = i3;
      localRectF.set(f1 - f2, f1 - i3, f3 + f1, i3 + f1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.c);
      paramCanvas.drawArc(localRectF, 270.0F, this.i, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
  }
  
  public void setOnCountDownLinstener(CountDownProgressBar.OnCountDownLinstener paramOnCountDownLinstener)
  {
    this.jdField_a_of_type_ComTencentWidgetCountDownProgressBar$OnCountDownLinstener = paramOnCountDownLinstener;
  }
  
  public void setTotalMills(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Long = 1000L;
    this.h = ((int)(this.jdField_a_of_type_Long / 1000L));
  }
  
  public void setTotalMills(long paramLong, int paramInt)
  {
    int i1 = paramInt;
    if (paramInt == 0) {
      i1 = 1;
    }
    this.jdField_a_of_type_Long = paramLong;
    this.h = i1;
    this.jdField_b_of_type_Long = (paramLong / i1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.widget.CountDownProgressBar
 * JD-Core Version:    0.7.0.1
 */