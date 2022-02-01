package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.image.URLImageView;

public class EmoticonImageView
  extends URLImageView
{
  private static Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private static Rect jdField_a_of_type_AndroidGraphicsRect;
  private static Rect jdField_b_of_type_AndroidGraphicsRect;
  private static boolean jdField_b_of_type_Boolean;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private boolean jdField_a_of_type_Boolean;
  
  public EmoticonImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmoticonImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EmoticonImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public static boolean b()
  {
    return jdField_b_of_type_Boolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Boolean)) {}
    for (;;)
    {
      return;
      if (jdField_a_of_type_AndroidGraphicsBitmap == null) {}
      try
      {
        jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(super.getResources(), 2130838477);
        label37:
        if (jdField_a_of_type_AndroidGraphicsBitmap == null) {
          continue;
        }
        if (jdField_a_of_type_AndroidGraphicsRect == null)
        {
          int i = jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
          int j = jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
          int m = super.getWidth();
          int k = super.getHeight();
          jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, i, j);
          m = (m - i) / 2;
          k = (int)(k - super.getResources().getDisplayMetrics().density * 13.0F);
          jdField_b_of_type_AndroidGraphicsRect = new Rect(m, k, i + m, j + k);
        }
        if (this.jdField_a_of_type_AndroidGraphicsPaint == null) {
          this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        }
        paramCanvas.drawBitmap(jdField_a_of_type_AndroidGraphicsBitmap, jdField_a_of_type_AndroidGraphicsRect, jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
      }
      catch (Exception localException)
      {
        break label37;
      }
    }
  }
  
  public void setNewIconVisible(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonImageView
 * JD-Core Version:    0.7.0.1
 */