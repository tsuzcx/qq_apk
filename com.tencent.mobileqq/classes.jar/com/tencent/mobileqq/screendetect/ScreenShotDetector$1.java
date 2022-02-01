package com.tencent.mobileqq.screendetect;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ScreenShotDetector$1
  implements Runnable
{
  ScreenShotDetector$1(ScreenShotDetector paramScreenShotDetector, String paramString) {}
  
  public void run()
  {
    boolean bool = ScreenShotDetector.b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start screenshots, ");
      localStringBuilder.append(bool);
      QLog.d("ScreenShotDetector", 2, localStringBuilder.toString());
    }
    if (bool) {
      ScreenShotHelper.a((Context)ScreenShotDetector.a(this.this$0).get(), this.a, ScreenShotDetector.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotDetector.1
 * JD-Core Version:    0.7.0.1
 */