package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class CircleCountdownView
  extends View
  implements ICircleCountDownView
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private int jdField_c_of_type_Int;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private int d;
  private int e;
  
  public CircleCountdownView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public CircleCountdownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleCountdownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Int = ((int)(getResources().getDisplayMetrics().density * 1.5F + 0.5F));
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.d = 5000;
    int i = Color.parseColor("#80FFFFFF");
    int j = Color.parseColor("#FFFFFFFF");
    int k = (int)(getResources().getDisplayMetrics().density * 12.0F + 0.5F);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFlags(1);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(j);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setFlags(1);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(j);
    this.jdField_c_of_type_AndroidGraphicsPaint.setTextSize(k);
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    setBackgroundColor(0);
  }
  
  public void a()
  {
    this.e = 0;
    invalidate();
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt > 0)
    {
      int j = this.e;
      int i = this.d;
      if (j + paramInt > i) {
        paramInt = i;
      } else {
        paramInt = j + paramInt;
      }
      this.e = paramInt;
      invalidate();
      bool1 = bool2;
      if (this.e == this.d) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    float f = this.e * 360.0F / this.d;
    paramCanvas.save();
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, f, false, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, f - 90.0F, 360.0F - f, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    double d1 = this.d - this.e;
    Double.isNaN(d1);
    String str = String.valueOf((int)Math.ceil(d1 / 1000.0D));
    paramCanvas.drawText(str, (this.jdField_b_of_type_Int - this.jdField_c_of_type_AndroidGraphicsPaint.measureText(str)) / 2.0F, this.jdField_c_of_type_Int / 2 - (this.jdField_c_of_type_AndroidGraphicsPaint.descent() + this.jdField_c_of_type_AndroidGraphicsPaint.ascent()) / 2.0F, this.jdField_c_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    paramInt1 = this.jdField_a_of_type_Int;
    localRectF.set(paramInt1 / 2, paramInt1 / 2, this.jdField_b_of_type_Int - paramInt1 / 2, this.jdField_c_of_type_Int - paramInt1 / 2);
  }
  
  public void setDuration(int paramInt)
  {
    if (paramInt > 0) {
      this.d = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.CircleCountdownView
 * JD-Core Version:    0.7.0.1
 */