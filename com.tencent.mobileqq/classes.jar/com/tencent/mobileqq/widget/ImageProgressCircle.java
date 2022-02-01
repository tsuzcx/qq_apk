package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class ImageProgressCircle
  extends View
{
  private int jdField_a_of_type_Int;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  String jdField_a_of_type_JavaLangString = "";
  boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean = true;
  private int d;
  
  public ImageProgressCircle(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ImageProgressCircle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ImageProgressCircle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130847153);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    int i = (int)(paramContext.getResources().getDisplayMetrics().density * 12.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(i);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(Typeface.DEFAULT_BOLD);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131297210);
    i = this.jdField_c_of_type_Int;
    this.jdField_a_of_type_Int = (i / 2);
    this.jdField_b_of_type_Int = (i / 2);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      paramCanvas.save();
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      int i = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2;
      int j = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2;
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_a_of_type_Int - i, this.jdField_b_of_type_Int - j);
        this.jdField_b_of_type_Boolean = true;
      }
      this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(5.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
      if (this.jdField_c_of_type_Boolean)
      {
        String str;
        double d1;
        double d2;
        float f;
        if (this.d >= 10)
        {
          str = this.jdField_a_of_type_JavaLangString;
          d1 = this.jdField_a_of_type_Int;
          d2 = i;
          Double.isNaN(d2);
          Double.isNaN(d1);
          f = (float)(d1 - d2 * 0.66D);
          d1 = this.jdField_b_of_type_Int;
          d2 = j;
          Double.isNaN(d2);
          Double.isNaN(d1);
          paramCanvas.drawText(str, f, (float)(d1 + d2 * 0.25D), this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        else
        {
          str = this.jdField_a_of_type_JavaLangString;
          d1 = this.jdField_a_of_type_Int;
          d2 = i;
          Double.isNaN(d2);
          Double.isNaN(d1);
          f = (float)(d1 - d2 * 0.25D);
          d1 = this.jdField_b_of_type_Int;
          d2 = j;
          Double.isNaN(d2);
          Double.isNaN(d1);
          paramCanvas.drawText(str, f, (float)(d1 + d2 * 0.25D), this.jdField_a_of_type_AndroidGraphicsPaint);
        }
      }
      paramCanvas.restore();
    }
    postInvalidate();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    if (paramInt3 - paramInt1 == 0)
    {
      i = this.jdField_c_of_type_Int;
      layout(paramInt1 - i / 2, paramInt2, paramInt3 + i / 2, paramInt4);
      return;
    }
    if (paramInt4 - paramInt2 == 0)
    {
      i = this.jdField_c_of_type_Int;
      layout(paramInt1, paramInt2 - i / 2, paramInt3, paramInt4 + i / 2);
      return;
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt >= 100) {
      this.jdField_a_of_type_Boolean = false;
    }
    int i = paramInt * 100 / 85;
    paramInt = i;
    if (i > 99) {
      paramInt = 99;
    }
    this.d = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append("%");
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ImageProgressCircle
 * JD-Core Version:    0.7.0.1
 */