package com.tencent.mobileqq.portal;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class HongbaoCaidanRainView$2
  implements Runnable
{
  HongbaoCaidanRainView$2(HongbaoCaidanRainView paramHongbaoCaidanRainView, Bitmap[] paramArrayOfBitmap) {}
  
  public void run()
  {
    HongbaoCaidanRainView.a(this.this$0).clear();
    Bitmap[] arrayOfBitmap = this.a;
    int j = arrayOfBitmap.length;
    int i = 0;
    while (i < j)
    {
      Bitmap localBitmap = arrayOfBitmap[i];
      if (QLog.isColorLevel()) {
        QLog.d("HongbaoCaidanRainView", 2, "start(), bitmap =" + localBitmap);
      }
      HongbaoCaidanRainView.a(this.this$0).add(localBitmap);
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HongbaoCaidanRainView", 2, "start(), mBitmapList.size() =" + HongbaoCaidanRainView.a(this.this$0).size());
    }
    if (HongbaoCaidanRainView.a(this.this$0).size() > 0)
    {
      HongbaoCaidanRainView.a(this.this$0, System.currentTimeMillis());
      HongbaoCaidanRainView.b(this.this$0, HongbaoCaidanRainView.a(this.this$0));
      HongbaoCaidanRainView.a(this.this$0, true);
      HongbaoCaidanRainView.b(this.this$0, false);
      this.this$0.postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.HongbaoCaidanRainView.2
 * JD-Core Version:    0.7.0.1
 */