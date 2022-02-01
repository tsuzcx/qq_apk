package com.tencent.mobileqq.hiboom;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

class HiBoomTextView$BitmapLocker
{
  private Bitmap b;
  
  private HiBoomTextView$BitmapLocker(HiBoomTextView paramHiBoomTextView) {}
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 1) && (paramInt2 >= 1)) {}
    try
    {
      if ((this.b != null) && ((this.b.getWidth() < paramInt1) || (this.b.getHeight() < paramInt2)))
      {
        this.b.recycle();
        this.b = null;
      }
      if (this.b == null) {
        this.b = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      }
      this.b.eraseColor(0);
      return;
    }
    finally {}
  }
  
  Bitmap a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomTextView.BitmapLocker
 * JD-Core Version:    0.7.0.1
 */