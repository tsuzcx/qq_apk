package dov.com.qq.im;

import android.app.Activity;
import android.view.WindowManager.BadTokenException;
import bmul;
import borh;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class QIMCameraCaptureUnit$3
  implements Runnable
{
  public QIMCameraCaptureUnit$3(bmul parambmul, String paramString) {}
  
  public void run()
  {
    Activity localActivity = this.this$0.a.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    try
    {
      this.this$0.q();
      if (!bmul.a(this.this$0).isShowing())
      {
        bmul.a(this.this$0).setCancelable(false);
        bmul.a(this.this$0).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.3
 * JD-Core Version:    0.7.0.1
 */