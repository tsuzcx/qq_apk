package dov.com.qq.im.ptv;

import android.widget.TextView;
import bjqw;
import com.tencent.qphone.base.util.QLog;

public class LightWeightSoDownloadUnit$2
  implements Runnable
{
  public LightWeightSoDownloadUnit$2(bjqw parambjqw, String paramString) {}
  
  public void run()
  {
    bjqw.a(this.this$0).setText(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("LightWeightSoDownloadUnit", 2, "setTipsTextData: textData=" + this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightSoDownloadUnit.2
 * JD-Core Version:    0.7.0.1
 */