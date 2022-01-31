package dov.com.tencent.mobileqq.richmedia.capture.fragment;

import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;

class CaptureQmcfSoDownloadFragment$2
  implements Runnable
{
  CaptureQmcfSoDownloadFragment$2(CaptureQmcfSoDownloadFragment paramCaptureQmcfSoDownloadFragment, String paramString) {}
  
  public void run()
  {
    if (CaptureQmcfSoDownloadFragment.a(this.this$0))
    {
      CaptureQmcfSoDownloadFragment.a(this.this$0).setProgress((CaptureQmcfSoDownloadFragment.a(this.this$0) + CaptureQmcfSoDownloadFragment.b(this.this$0)) / 2);
      if (QLog.isColorLevel()) {
        QLog.d("CaptureQmcfSoDownloadFragment", 2, "" + this.a + " setProgress=" + (CaptureQmcfSoDownloadFragment.a(this.this$0) + CaptureQmcfSoDownloadFragment.b(this.this$0)) / 2);
      }
      CaptureQmcfSoDownloadFragment.a(this.this$0);
    }
    do
    {
      return;
      CaptureQmcfSoDownloadFragment.a(this.this$0).setProgress(CaptureQmcfSoDownloadFragment.a(this.this$0));
    } while (!QLog.isColorLevel());
    QLog.d("CaptureQmcfSoDownloadFragment", 2, "" + this.a + " setProgress=" + CaptureQmcfSoDownloadFragment.c(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment.2
 * JD-Core Version:    0.7.0.1
 */