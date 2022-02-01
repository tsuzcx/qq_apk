package dov.com.tencent.mobileqq.richmedia.capture.fragment;

import com.tencent.qphone.base.util.QLog;

class CaptureQmcfSoDownloadFragment$6
  implements Runnable
{
  CaptureQmcfSoDownloadFragment$6(CaptureQmcfSoDownloadFragment paramCaptureQmcfSoDownloadFragment, int paramInt) {}
  
  public void run()
  {
    CaptureQmcfSoDownloadFragment.a(this.this$0, this.a);
    if (QLog.isColorLevel()) {
      QLog.d("CaptureQmcfSoDownloadFragment", 2, "onDownloadProgress mGestureState=" + CaptureQmcfSoDownloadFragment.b(this.this$0) + " mVideoState=" + CaptureQmcfSoDownloadFragment.c(this.this$0));
    }
    CaptureQmcfSoDownloadFragment.a(this.this$0, "GestureDownloadProgress");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment.6
 * JD-Core Version:    0.7.0.1
 */