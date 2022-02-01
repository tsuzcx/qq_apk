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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tryToSetBlurBackground() called with: root = [");
      localStringBuilder.append(ScreenShotFragment.a(this.this$0));
      localStringBuilder.append("], blurBitmap = [");
      localStringBuilder.append(this.a);
      localStringBuilder.append("]");
      QLog.d("ScreenShotFragment", 2, localStringBuilder.toString());
    }
    ScreenShotFragment.a(this.this$0).setBackgroundDrawable(localBitmapDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotFragment.7
 * JD-Core Version:    0.7.0.1
 */