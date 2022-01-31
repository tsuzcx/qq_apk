package dov.com.qq.im.ptv;

import android.app.Activity;
import android.content.Intent;
import bhxa;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.qphone.base.util.QLog;

class AIOLongCaptureCtrl$4
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOLongCaptureCtrl", 2, "start preload peak process");
    }
    Intent localIntent = new Intent(AIOLongCaptureCtrl.a(this.this$0).a(), PeakService.class);
    try
    {
      AIOLongCaptureCtrl.a(this.this$0).a().startService(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AIOLongCaptureCtrl", 1, "onShow_otherThings startService ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ptv.AIOLongCaptureCtrl.4
 * JD-Core Version:    0.7.0.1
 */