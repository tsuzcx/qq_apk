package dov.com.qq.im;

import android.app.Activity;
import android.view.WindowManager.BadTokenException;
import bdjz;
import bkms;
import bmhh;
import com.tencent.qphone.base.util.QLog;

public class QIMCameraCaptureUnit$2
  implements Runnable
{
  public QIMCameraCaptureUnit$2(bkms parambkms, String paramString) {}
  
  public void run()
  {
    Activity localActivity = this.this$0.a.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    try
    {
      this.this$0.z();
      if (!bkms.a(this.this$0).isShowing())
      {
        bkms.a(this.this$0).setCancelable(false);
        bkms.a(this.this$0).show();
      }
      QLog.e("QIMCameraCaptureUnit", 2, "onCameraStarted error = " + this.a);
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QIMCameraCaptureUnit", 2, "", localBadTokenException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.2
 * JD-Core Version:    0.7.0.1
 */