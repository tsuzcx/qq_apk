package com.tencent.mobileqq.troop.homework.recite.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R.styleable;

public class VolumeVisualizerView
  extends View
{
  private static final int jdField_a_of_type_Int = Color.parseColor("#508DFF");
  private static final int b = Color.parseColor("#37BBFE");
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private boolean jdField_a_of_type_Boolean = true;
  public int[] a;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public VolumeVisualizerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.change_voice_volume);
    a(paramContext);
    paramContext.recycle();
  }
  
  private void a(TypedArray paramTypedArray)
  {
    if (paramTypedArray.getInt(2, 0) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.c = paramTypedArray.getInt(3, 30);
      this.d = ((int)paramTypedArray.getDimension(5, 15.0F));
      this.e = paramTypedArray.getColor(0, -16776961);
      this.jdField_a_of_type_ArrayOfInt = new int[this.c];
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfInt[this.f] = paramInt;
    this.f += 1;
    if (this.f >= this.c) {
      this.f = 0;
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = this.f - 1;
    int j = 0;
    if (j < this.c)
    {
      int k = i;
      if (i < 0) {
        k = this.c - 1;
      }
      float f2 = this.jdField_a_of_type_ArrayOfInt[k];
      float f1 = f2;
      if (f2 < 1.0F) {
        f1 = 1.0F;
      }
      f2 = f1;
      if (f1 > 8.0F) {
        f2 = 8.0F;
      }
      f1 = f2 / 2.0F;
      f2 = this.d * f1;
      if (this.jdField_a_of_type_Boolean) {}
      for (f1 = j * 2.0F * this.d;; f1 = (this.c - 1 - j) * 2.0F * this.d + this.d)
      {
        paramCanvas.drawRoundRect(new RectF(f1, this.g - f2, this.d + f1, f2 + this.g), 6.0F, 6.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
        i = k - 1;
        j += 1;
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = this.c;
    paramInt2 = this.d;
    int i = this.d;
    setMeasuredDimension(paramInt1 * 2 * paramInt2 + getPaddingLeft() + getPaddingRight(), i * 10 + getPaddingTop() + getPaddingBottom());
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.g = (paramInt2 / 2);
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      LinearGradient localLinearGradient = new LinearGradient(0.0F, 0.0F, getWidth(), getHeight(), jdField_a_of_type_Int, b, Shader.TileMode.CLAMP);
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(localLinearGradient);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
    }
    invalidate();
  }
  
  public void setColor(int paramInt)
  {
    this.e = paramInt;
    if (this.jdField_a_of_type_AndroidGraphicsPaint != null) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
    }
  }
  
  public void setCount(int paramInt)
  {
    this.c = paramInt;
    this.jdField_a_of_type_ArrayOfInt = new int[this.c];
    requestLayout();
  }
  
  public void setSquareWidth(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.VolumeVisualizerView
 * JD-Core Version:    0.7.0.1
 */