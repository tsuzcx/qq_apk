package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import bfsd;
import com.tencent.qphone.base.util.QLog;

public final class ScreenShotUtil$1
  implements Runnable
{
  public ScreenShotUtil$1(bfsd parambfsd, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScreenShotUtil", 2, "ScreenShot Finish Callback");
    }
    this.jdField_a_of_type_Bfsd.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.ScreenShotUtil.1
 * JD-Core Version:    0.7.0.1
 */