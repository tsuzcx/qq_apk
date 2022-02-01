package com.tencent.mobileqq.screendetect;

import com.tencent.qphone.base.util.QLog;

class ScreenShotFragment$5
  implements Runnable
{
  ScreenShotFragment$5(ScreenShotFragment paramScreenShotFragment) {}
  
  public void run()
  {
    if (ScreenShotFragment.e(this.this$0) != null) {
      try
      {
        ScreenShotFragment.b(this.this$0, ScreenShotFragment.e(this.this$0));
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.w("ScreenShotFragment", 2, localOutOfMemoryError.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotFragment.5
 * JD-Core Version:    0.7.0.1
 */