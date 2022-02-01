package com.tencent.mobileqq.hotchat.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.widget.ImageView;

public class HeartView
  extends ImageView
{
  private static Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private static Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private static Paint jdField_a_of_type_AndroidGraphicsPaint;
  private static Bitmap b;
  protected final int a;
  private boolean jdField_a_of_type_Boolean = true;
  protected final int b;
  
  public HeartView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 2130845466;
    this.jdField_b_of_type_Int = 2130845465;
  }
  
  public HeartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 2130845466;
    this.jdField_b_of_type_Int = 2130845465;
  }
  
  public HeartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 2130845466;
    this.jdField_b_of_type_Int = 2130845465;
  }
  
  public static Bitmap a(int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    return null;
  }
  
  public Bitmap a(int paramInt)
  {
    if (jdField_a_of_type_AndroidGraphicsBitmap == null) {}
    try
    {
      jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), 2130845466);
      if (jdField_b_of_type_AndroidGraphicsBitmap == null) {}
      Bitmap localBitmap1;
      Bitmap localBitmap2;
      Bitmap localBitmap3;
      Canvas localCanvas;
      Paint localPaint;
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      try
      {
        jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), 2130845465);
        if (jdField_a_of_type_AndroidGraphicsPaint == null) {
          jdField_a_of_type_AndroidGraphicsPaint = new Paint(3);
        }
        if (jdField_a_of_type_AndroidGraphicsCanvas == null) {
          jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
        }
        localBitmap1 = jdField_a_of_type_AndroidGraphicsBitmap;
        localBitmap2 = jdField_b_of_type_AndroidGraphicsBitmap;
        localBitmap3 = a(localBitmap2.getWidth(), localBitmap2.getHeight());
        if (localBitmap3 == null) {
          return null;
        }
        localCanvas = jdField_a_of_type_AndroidGraphicsCanvas;
        localCanvas.setBitmap(localBitmap3);
        localPaint = jdField_a_of_type_AndroidGraphicsPaint;
        if (this.jdField_a_of_type_Boolean)
        {
          localCanvas.drawBitmap(localBitmap2, 0.0F, 0.0F, localPaint);
          localPaint.setColorFilter(new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP));
          localCanvas.drawBitmap(localBitmap1, (localBitmap2.getWidth() - localBitmap1.getWidth()) / 2.0F, (localBitmap2.getHeight() - localBitmap1.getHeight()) / 2.0F, localPaint);
        }
        else
        {
          localPaint.setColorFilter(new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP));
          localCanvas.drawBitmap(localBitmap2, 0.0F, 0.0F, localPaint);
        }
        localPaint.setColorFilter(null);
        localCanvas.setBitmap(null);
        return localBitmap3;
      }
      catch (OutOfMemoryError localOutOfMemoryError2) {}
      localOutOfMemoryError1 = localOutOfMemoryError1;
      return null;
    }
  }
  
  public void setColor(int paramInt)
  {
    Bitmap localBitmap = a(paramInt);
    if (localBitmap != null)
    {
      super.setImageBitmap(localBitmap);
      return;
    }
    super.setImageResource(2130845466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.ui.HeartView
 * JD-Core Version:    0.7.0.1
 */