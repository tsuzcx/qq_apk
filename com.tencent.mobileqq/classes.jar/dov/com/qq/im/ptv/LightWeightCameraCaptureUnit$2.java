package dov.com.qq.im.ptv;

import android.app.Activity;
import android.view.WindowManager.BadTokenException;
import bdjz;
import bmfm;
import bmhh;
import com.tencent.qphone.base.util.QLog;

public class LightWeightCameraCaptureUnit$2
  implements Runnable
{
  public LightWeightCameraCaptureUnit$2(bmfm parambmfm, String paramString) {}
  
  public void run()
  {
    Activity localActivity = this.this$0.a.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    try
    {
      bmfm.a(this.this$0);
      if (!bmfm.a(this.this$0).isShowing())
      {
        bmfm.a(this.this$0).setCancelable(false);
        bmfm.a(this.this$0).show();
      }
      QLog.e("LightWeightCameraCaptureUnit", 2, "onCameraStarted error = " + this.a);
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("LightWeightCameraCaptureUnit", 2, "", localBadTokenException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.2
 * JD-Core Version:    0.7.0.1
 */