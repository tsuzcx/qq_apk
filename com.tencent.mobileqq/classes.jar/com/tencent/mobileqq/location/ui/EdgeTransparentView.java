package com.tencent.mobileqq.location.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R.styleable;

public class EdgeTransparentView
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 0.5F, 1.0F };
  private int[] jdField_a_of_type_ArrayOfInt = { -1, -1, 16777215 };
  private int b = 1;
  private int c = this.b << 1;
  private int d = this.b << 2;
  private int e = this.b << 3;
  private int f;
  private int g;
  
  public EdgeTransparentView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EdgeTransparentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EdgeTransparentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(new LinearGradient(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_Float, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP));
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.EdgeTransparentView);
    this.jdField_a_of_type_Int = paramContext.getInt(0, 0);
    this.jdField_a_of_type_Float = paramContext.getDimension(1, 40.0F);
    paramContext.recycle();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    if ((this.jdField_a_of_type_Int == 0) || ((this.jdField_a_of_type_Int & this.b) != 0)) {
      paramCanvas.drawRect(0.0F, 0.0F, this.f, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    int j;
    if ((this.jdField_a_of_type_Int == 0) || ((this.jdField_a_of_type_Int & this.c) != 0))
    {
      j = paramCanvas.save();
      paramCanvas.rotate(180.0F, this.f / 2.0F, this.g / 2.0F);
      paramCanvas.drawRect(0.0F, 0.0F, this.f, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.restoreToCount(j);
    }
    float f1 = (this.g - this.f) / 2.0F;
    if ((this.jdField_a_of_type_Int == 0) || ((this.jdField_a_of_type_Int & this.d) != 0))
    {
      j = paramCanvas.save();
      paramCanvas.rotate(270.0F, this.f / 2.0F, this.g / 2.0F);
      paramCanvas.translate(0.0F, f1);
      paramCanvas.drawRect(0.0F - f1, 0.0F, this.f + f1, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.restoreToCount(j);
    }
    if ((this.jdField_a_of_type_Int == 0) || ((this.jdField_a_of_type_Int & this.e) != 0))
    {
      j = paramCanvas.save();
      paramCanvas.rotate(90.0F, this.f / 2.0F, this.g / 2.0F);
      paramCanvas.translate(0.0F, f1);
      paramCanvas.drawRect(0.0F - f1, 0.0F, this.f + f1, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.restoreToCount(j);
    }
    paramCanvas.restoreToCount(i);
    return bool;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
    this.f = getWidth();
    this.g = getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.EdgeTransparentView
 * JD-Core Version:    0.7.0.1
 */