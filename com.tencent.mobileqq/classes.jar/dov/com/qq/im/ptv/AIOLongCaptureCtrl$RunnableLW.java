package dov.com.qq.im.ptv;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

class AIOLongCaptureCtrl$RunnableLW
  implements Runnable
{
  private AIOLongCaptureCtrl$RunnableLW(AIOLongCaptureCtrl paramAIOLongCaptureCtrl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOLongCaptureCtrl", 2, "handleTouch[RunnableLW] hasLongEventDown:" + AIOLongCaptureCtrl.a(this.this$0) + " havePtvUIStarted:" + AIOLongCaptureCtrl.a());
    }
    if (AIOLongCaptureCtrl.a(this.this$0))
    {
      long l1 = SystemClock.uptimeMillis();
      long l2 = AIOLongCaptureCtrl.a(this.this$0);
      if ((AIOLongCaptureCtrl.b(this.this$0)) && (l1 - l2 >= AIOLongCaptureCtrl.b(this.this$0)))
      {
        AIOLongCaptureCtrl.a(this.this$0);
        AIOLongCaptureCtrl.a(this.this$0, false);
      }
    }
    for (;;)
    {
      AIOLongCaptureCtrl.a(this.this$0).postDelayed(AIOLongCaptureCtrl.a(this.this$0), 100L);
      return;
      if (AIOLongCaptureCtrl.a())
      {
        Bundle localBundle = new Bundle();
        AIOLongCaptureCtrl.a(localBundle, AIOLongCaptureCtrl.a(this.this$0), 1);
        AIOLongCaptureCtrl.a(this.this$0, localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ptv.AIOLongCaptureCtrl.RunnableLW
 * JD-Core Version:    0.7.0.1
 */