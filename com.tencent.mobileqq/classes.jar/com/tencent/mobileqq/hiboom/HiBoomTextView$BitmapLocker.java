package com.tencent.mobileqq.hiboom;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

class HiBoomTextView$BitmapLocker
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  
  private HiBoomTextView$BitmapLocker(HiBoomTextView paramHiBoomTextView) {}
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 1) && (paramInt2 >= 1)) {}
    try
    {
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && ((this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() < paramInt1) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() < paramInt2)))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap.eraseColor(0);
      return;
    }
    finally {}
  }
  
  Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomTextView.BitmapLocker
 * JD-Core Version:    0.7.0.1
 */