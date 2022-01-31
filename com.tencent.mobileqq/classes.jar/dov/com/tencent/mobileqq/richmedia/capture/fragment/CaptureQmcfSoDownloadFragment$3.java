package dov.com.tencent.mobileqq.richmedia.capture.fragment;

import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class CaptureQmcfSoDownloadFragment$3
  implements Runnable
{
  CaptureQmcfSoDownloadFragment$3(CaptureQmcfSoDownloadFragment paramCaptureQmcfSoDownloadFragment, String paramString) {}
  
  public void run()
  {
    CaptureQmcfSoDownloadFragment.a(this.this$0).setText(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("CaptureQmcfSoDownloadFragment", 2, "setTipsTextData: textData=" + this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment.3
 * JD-Core Version:    0.7.0.1
 */