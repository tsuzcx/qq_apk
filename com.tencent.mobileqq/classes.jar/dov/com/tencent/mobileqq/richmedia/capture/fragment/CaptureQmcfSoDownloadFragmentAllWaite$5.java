package dov.com.tencent.mobileqq.richmedia.capture.fragment;

import bbmy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class CaptureQmcfSoDownloadFragmentAllWaite$5
  implements Runnable
{
  CaptureQmcfSoDownloadFragmentAllWaite$5(CaptureQmcfSoDownloadFragmentAllWaite paramCaptureQmcfSoDownloadFragmentAllWaite, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CaptureSoDownloadFragmentAllWaite", 2, "onStatusChanged: " + this.jdField_a_of_type_Boolean + " error:" + this.jdField_a_of_type_Int);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      bbmy.a(BaseApplicationImpl.getContext(), 2131652956, 0).a();
      CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0, -1);
      return;
    }
    CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0, 101);
    CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0, "onStatusChanged");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragmentAllWaite.5
 * JD-Core Version:    0.7.0.1
 */