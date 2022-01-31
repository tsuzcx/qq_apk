package dov.com.qq.im.ptv;

import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;

class LightVideoSoDownloadFragment$3
  implements Runnable
{
  LightVideoSoDownloadFragment$3(LightVideoSoDownloadFragment paramLightVideoSoDownloadFragment, String paramString) {}
  
  public void run()
  {
    this.this$0.a.setProgress(LightVideoSoDownloadFragment.a(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoSoDownloadFragment", 2, "" + this.a + " setProgress=" + LightVideoSoDownloadFragment.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightVideoSoDownloadFragment.3
 * JD-Core Version:    0.7.0.1
 */