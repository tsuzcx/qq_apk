package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;

final class ScreenShotUtil$1
  implements Runnable
{
  ScreenShotUtil$1(ScreenShotUtil.ScreenshotCallback paramScreenshotCallback, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScreenShotUtil", 2, "ScreenShot Finish Callback");
    }
    this.a.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.ScreenShotUtil.1
 * JD-Core Version:    0.7.0.1
 */