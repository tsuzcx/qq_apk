package dov.com.tencent.mobileqq.richmedia.capture.activity;

import android.os.Bundle;
import bnrh;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment;

class CaptureQmcfSoDownloadActivity$1
  implements Runnable
{
  CaptureQmcfSoDownloadActivity$1(CaptureQmcfSoDownloadActivity paramCaptureQmcfSoDownloadActivity) {}
  
  public void run()
  {
    if ((BaseActivity.sTopActivity instanceof CaptureQmcfSoDownloadActivity))
    {
      QLog.d("qqBaseActivity", 4, "is top activity, hasRequest: " + CaptureQmcfSoDownloadActivity.a(this.this$0));
      CaptureQmcfSoDownloadActivity.a(this.this$0).putString("KEY_ISENTER_SO_DOWNLOAD", "true");
      if (CaptureQmcfSoDownloadActivity.a(this.this$0))
      {
        if ((CaptureQmcfSoDownloadActivity.a(this.this$0) instanceof CaptureQmcfSoDownloadFragment)) {
          ((CaptureQmcfSoDownloadFragment)CaptureQmcfSoDownloadActivity.a(this.this$0)).b();
        }
        for (;;)
        {
          QIMCameraCaptureActivity.a(this.this$0, CaptureQmcfSoDownloadActivity.a(this.this$0), CaptureQmcfSoDownloadActivity.a(this.this$0));
          return;
          bnrh.d(CaptureQmcfSoDownloadActivity.a, "[onFinish]soDownloadFragment not instanceof CaptureQmcfSoDownloadFragment");
        }
      }
      bnrh.d(CaptureQmcfSoDownloadActivity.a, "[onFinish]hasRequest false");
      QIMCameraCaptureActivity.a(this.this$0, CaptureQmcfSoDownloadActivity.a(this.this$0));
      this.this$0.finish();
      return;
    }
    bnrh.d(CaptureQmcfSoDownloadActivity.a, "[onFinish]BaseActivity.sTopActivity not instanceof CaptureQmcfSoDownloadActivity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity.1
 * JD-Core Version:    0.7.0.1
 */