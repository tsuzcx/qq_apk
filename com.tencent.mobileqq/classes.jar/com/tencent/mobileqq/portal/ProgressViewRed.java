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
  private int[] jdField_a_of_type_ArrayOfInt = { 2130845511, 2130845512, 2130845513, 2130845514, 2130845515, 2130845516, 2130845517, 2130845518, 2130845519, 2130845520, 2130845521, 2130845522, 2130845523, 2130845524, 2130845525, 2130845526, 2130845527, 2130845528, 2130845529, 2130845530 };
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
    int n = (int)(k * this.jdField_b_of_type_Long / this.jdField_a_of_type_Long);
    if (this.jdField_b_of_type_Long > 0L)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, n, m);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
    int j;
    int i;
    int i1;
    Bitmap localBitmap;
    if (this.jdField_b_of_type_Long < this.jdField_a_of_type_Long)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(n, 0, k, m);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      j = this.jdField_b_of_type_Int;
      i = j;
      if (j >= this.jdField_a_of_type_ArrayOfInt.length) {
        i = j % this.jdField_a_of_type_ArrayOfInt.length;
      }
      i1 = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i].getWidth();
      j = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i].getHeight();
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, i1, j);
      if (i1 > k - n) {
        break label228;
      }
      localBitmap = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i];
      this.jdField_a_of_type_AndroidGraphicsRectF.set(n, 0.0F, i1 + n, m);
    }
    for (;;)
    {
      if (localBitmap != null) {
        paramCanvas.drawBitmap(localBitmap, null, this.jdField_a_of_type_AndroidGraphicsRectF, null);
      }
      this.jdField_b_of_type_Int += 1;
      super.draw(paramCanvas);
      return;
      label228:
      i1 = k - n;
      if (i1 > 0)
      {
        localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i], 0, 0, i1, j, null, false);
        this.jdField_a_of_type_AndroidGraphicsRectF.set(n, 0.0F, k, m);
      }
      else
      {
        localBitmap = null;
      }
    }
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setAlpha(paramInt);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(paramInt);
    setTextColor(Color.argb(paramInt, 255, 255, 255));
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ProgressViewRed
 * JD-Core Version:    0.7.0.1
 */