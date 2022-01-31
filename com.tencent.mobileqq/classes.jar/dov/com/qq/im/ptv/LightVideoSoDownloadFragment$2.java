package dov.com.qq.im.ptv;

import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class LightVideoSoDownloadFragment$2
  implements Runnable
{
  LightVideoSoDownloadFragment$2(LightVideoSoDownloadFragment paramLightVideoSoDownloadFragment, String paramString) {}
  
  public void run()
  {
    LightVideoSoDownloadFragment.a(this.this$0).setText(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoSoDownloadFragment", 2, "setTipsTextData: textData=" + this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightVideoSoDownloadFragment.2
 * JD-Core Version:    0.7.0.1
 */