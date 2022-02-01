package com.tencent.mobileqq.widget;

import android.graphics.Bitmap;

class BitmapCache
  implements ImageViewTouchBase.Recycler
{
  private final BitmapCache.Entry[] a;
  
  public void a(Bitmap paramBitmap)
  {
    try
    {
      BitmapCache.Entry[] arrayOfEntry = this.a;
      int j = arrayOfEntry.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfEntry[i];
        if (((BitmapCache.Entry)localObject).jdField_a_of_type_Int != -1)
        {
          localObject = ((BitmapCache.Entry)localObject).jdField_a_of_type_AndroidGraphicsBitmap;
          if (localObject == paramBitmap) {
            return;
          }
        }
        i += 1;
      }
      paramBitmap.recycle();
      return;
    }
    finally {}
    for (;;)
    {
      throw paramBitmap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BitmapCache
 * JD-Core Version:    0.7.0.1
 */