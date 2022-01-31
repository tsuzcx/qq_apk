package dov.com.tencent.mobileqq.richmedia.capture.fragment;

import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;

class CaptureQmcfSoDownloadFragmentAllWaite$2
  implements Runnable
{
  CaptureQmcfSoDownloadFragmentAllWaite$2(CaptureQmcfSoDownloadFragmentAllWaite paramCaptureQmcfSoDownloadFragmentAllWaite, String paramString) {}
  
  public void run()
  {
    if (CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0))
    {
      CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0).setProgress((CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0) + CaptureQmcfSoDownloadFragmentAllWaite.b(this.this$0)) / 2);
      if (QLog.isColorLevel()) {
        QLog.d("CaptureSoDownloadFragmentAllWaite", 2, "" + this.a + " setProgress=" + (CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0) + CaptureQmcfSoDownloadFragmentAllWaite.b(this.this$0)) / 2);
      }
      CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0);
    }
    do
    {
      return;
      CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0).setProgress(CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0));
    } while (!QLog.isColorLevel());
    QLog.d("CaptureSoDownloadFragmentAllWaite", 2, "" + this.a + " setProgress=" + CaptureQmcfSoDownloadFragmentAllWaite.c(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragmentAllWaite.2
 * JD-Core Version:    0.7.0.1
 */