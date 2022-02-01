package dov.com.tencent.mobileqq.richmedia.capture.fragment;

import com.tencent.qphone.base.util.QLog;

class CaptureQmcfSoDownloadFragmentAllWaite$6
  implements Runnable
{
  CaptureQmcfSoDownloadFragmentAllWaite$6(CaptureQmcfSoDownloadFragmentAllWaite paramCaptureQmcfSoDownloadFragmentAllWaite, int paramInt) {}
  
  public void run()
  {
    CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0, this.a);
    if (QLog.isColorLevel()) {
      QLog.d("CaptureSoDownloadFragmentAllWaite", 2, "onDownloadProgress mGestureState=" + CaptureQmcfSoDownloadFragmentAllWaite.b(this.this$0) + " mVideoState=" + CaptureQmcfSoDownloadFragmentAllWaite.c(this.this$0) + ",mFilterSoState=" + CaptureQmcfSoDownloadFragmentAllWaite.d(this.this$0) + ",mQmcfState=" + CaptureQmcfSoDownloadFragmentAllWaite.e(this.this$0));
    }
    CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0, "GestureDownloadProgress");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragmentAllWaite.6
 * JD-Core Version:    0.7.0.1
 */