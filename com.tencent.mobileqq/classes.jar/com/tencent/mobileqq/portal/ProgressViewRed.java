package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;

public class ProgressViewRed
  extends TimeDownTextView
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 10000L;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private int[] jdField_a_of_type_ArrayOfInt = { 2130845384, 2130845385, 2130845386, 2130845387, 2130845388, 2130845389, 2130845390, 2130845391, 2130845392, 2130845393, 2130845394, 2130845395, 2130845396, 2130845397, 2130845398, 2130845399, 2130845400, 2130845401, 2130845402, 2130845403 };
  private Bitmap[] jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = null;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  
  public ProgressViewRed(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ProgressViewRed(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#FF9F89"));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#F34112"));
    try
    {
      this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = new Bitmap[this.jdField_a_of_type_ArrayOfInt.length];
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i] = BitmapFactory.decodeResource(getResources(), this.jdField_a_of_type_ArrayOfInt[i]);
        i += 1;
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(long paramLong1, long paramLong2, CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_Long = paramLong2;
    this.jdField_b_of_type_Long = (paramLong2 - paramLong1);
    setText(paramCharSequence);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int == 0) {
      return;
    }
    int k = getWidth();
    int m = getHeight();
    long l1 = k;
    long l2 = this.jdField_b_of_type_Long;
    int n = (int)(l1 * l2 / this.jdField_a_of_type_Long);
    if (l2 > 0L)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, n, m);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
    if (this.jdField_b_of_type_Long < this.jdField_a_of_type_Long)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(n, 0, k, m);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      int j = this.jdField_b_of_type_Int;
      Object localObject = this.jdField_a_of_type_ArrayOfInt;
      int i = j;
      if (j >= localObject.length) {
        i = j % localObject.length;
      }
      j = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i].getWidth();
      int i1 = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i].getHeight();
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, j, i1);
      int i2 = k - n;
      if (j <= i2)
      {
        localObject = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i];
        this.jdField_a_of_type_AndroidGraphicsRectF.set(n, 0.0F, n + j, m);
      }
      else if (i2 > 0)
      {
        localObject = Bitmap.createBitmap(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i], 0, 0, i2, i1, null, false);
        this.jdField_a_of_type_AndroidGraphicsRectF.set(n, 0.0F, k, m);
      }
      else
      {
        localObject = null;
      }
      if (localObject != null) {
        paramCanvas.drawBitmap((Bitmap)localObject, null, this.jdField_a_of_type_AndroidGraphicsRectF, null);
      }
      this.jdField_b_of_type_Int += 1;
    }
    super.draw(paramCanvas);
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setAlpha(paramInt);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(paramInt);
    setTextColor(Color.argb(paramInt, 255, 255, 255));
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ProgressViewRed
 * JD-Core Version:    0.7.0.1
 */