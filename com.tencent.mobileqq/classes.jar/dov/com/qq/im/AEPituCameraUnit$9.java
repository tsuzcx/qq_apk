package dov.com.qq.im;

import android.app.Activity;
import android.view.WindowManager.BadTokenException;
import bafb;
import bhcw;
import bhzc;
import com.tencent.qphone.base.util.QLog;

public class AEPituCameraUnit$9
  implements Runnable
{
  public AEPituCameraUnit$9(bhcw parambhcw, String paramString) {}
  
  public void run()
  {
    Activity localActivity = bhcw.a(this.this$0).a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    try
    {
      this.this$0.k();
      if (!bhcw.a(this.this$0).isShowing())
      {
        bhcw.a(this.this$0).setCancelable(false);
        bhcw.a(this.this$0).show();
      }
      QLog.e(bhcw.a(), 2, "onCameraStarted error = " + this.a);
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(bhcw.a(), 2, "", localBadTokenException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AEPituCameraUnit.9
 * JD-Core Version:    0.7.0.1
 */