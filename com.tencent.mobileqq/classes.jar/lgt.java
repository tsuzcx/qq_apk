import android.app.Activity;
import android.content.Context;
import android.view.WindowManager.BadTokenException;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class lgt
  implements Runnable
{
  public lgt(ReadInJoyCameraCaptureActivity paramReadInJoyCameraCaptureActivity) {}
  
  public void run()
  {
    Object localObject = this.a;
    String str = ((Activity)localObject).getString(2131428347);
    localObject = DialogUtil.a((Context)localObject, 230).setMessage(str).setPositiveButton(((Activity)localObject).getString(2131428346), new lgu(this));
    try
    {
      ((QQCustomDialog)localObject).setCancelable(false);
      ((QQCustomDialog)localObject).show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "", localBadTokenException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lgt
 * JD-Core Version:    0.7.0.1
 */