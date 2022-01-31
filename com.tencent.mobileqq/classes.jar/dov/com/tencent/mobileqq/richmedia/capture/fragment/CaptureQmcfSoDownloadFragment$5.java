package dov.com.tencent.mobileqq.richmedia.capture.fragment;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class CaptureQmcfSoDownloadFragment$5
  implements Runnable
{
  CaptureQmcfSoDownloadFragment$5(CaptureQmcfSoDownloadFragment paramCaptureQmcfSoDownloadFragment, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CaptureQmcfSoDownloadFragment", 2, "onStatusChanged: " + this.jdField_a_of_type_Boolean + " error:" + this.jdField_a_of_type_Int);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2131719278, 0).a();
      CaptureQmcfSoDownloadFragment.a(this.this$0, -1);
      return;
    }
    CaptureQmcfSoDownloadFragment.a(this.this$0, 101);
    CaptureQmcfSoDownloadFragment.a(this.this$0, "onStatusChanged");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment.5
 * JD-Core Version:    0.7.0.1
 */