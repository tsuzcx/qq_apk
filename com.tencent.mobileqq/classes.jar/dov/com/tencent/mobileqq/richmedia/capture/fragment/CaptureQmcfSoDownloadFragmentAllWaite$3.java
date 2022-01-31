package dov.com.tencent.mobileqq.richmedia.capture.fragment;

import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class CaptureQmcfSoDownloadFragmentAllWaite$3
  implements Runnable
{
  CaptureQmcfSoDownloadFragmentAllWaite$3(CaptureQmcfSoDownloadFragmentAllWaite paramCaptureQmcfSoDownloadFragmentAllWaite, String paramString) {}
  
  public void run()
  {
    CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0).setText(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("CaptureSoDownloadFragmentAllWaite", 2, "setTipsTextData: textData=" + this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragmentAllWaite.3
 * JD-Core Version:    0.7.0.1
 */