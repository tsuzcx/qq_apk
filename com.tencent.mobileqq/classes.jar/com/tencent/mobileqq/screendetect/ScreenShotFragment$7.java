package com.tencent.mobileqq.screendetect;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class ScreenShotFragment$7
  implements Runnable
{
  ScreenShotFragment$7(ScreenShotFragment paramScreenShotFragment, Bitmap paramBitmap) {}
  
  public void run()
  {
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(this.a);
    if (ScreenShotFragment.a(this.this$0) == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "tryToSetBlurBackground() called with: root = [" + ScreenShotFragment.a(this.this$0) + "], blurBitmap = [" + this.a + "]");
    }
    ScreenShotFragment.a(this.this$0).setBackgroundDrawable(localBitmapDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotFragment.7
 * JD-Core Version:    0.7.0.1
 */