package com.tencent.mobileqq.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;

public class PhoneContactFaceDrawable
  extends Drawable
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(7);
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private String jdField_a_of_type_JavaLangString;
  
  public PhoneContactFaceDrawable(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapManager.b(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130842159);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_a_of_type_Int = Math.min(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    float f1 = localRect.width();
    int i = this.jdField_a_of_type_Int;
    f1 /= i;
    float f2 = i / 2;
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(f2 * f1);
    Paint.FontMetrics localFontMetrics = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    String str = this.jdField_a_of_type_JavaLangString;
    if (str != null)
    {
      if (str == null) {
        i = 0;
      } else {
        i = (int)Layout.getDesiredWidth(str, this.jdField_a_of_type_AndroidTextTextPaint);
      }
      f1 = localFontMetrics.descent;
      f1 = localFontMetrics.ascent;
      int j = localRect.left;
      i = (localRect.width() - i) / 2;
      int k = (int)(localRect.top + localRect.height() / 2.0F - (localFontMetrics.bottom - localFontMetrics.top) / 2.0F - localFontMetrics.top);
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, j + i, k, this.jdField_a_of_type_AndroidTextTextPaint);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.PhoneContactFaceDrawable
 * JD-Core Version:    0.7.0.1
 */