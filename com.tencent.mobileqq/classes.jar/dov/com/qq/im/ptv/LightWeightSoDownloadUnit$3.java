package dov.com.qq.im.ptv;

import bmcg;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;

public class LightWeightSoDownloadUnit$3
  implements Runnable
{
  public LightWeightSoDownloadUnit$3(bmcg parambmcg, String paramString) {}
  
  public void run()
  {
    this.this$0.a.setProgress(bmcg.a(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.d("LightWeightSoDownloadUnit", 2, "" + this.a + " setProgress=" + bmcg.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightSoDownloadUnit.3
 * JD-Core Version:    0.7.0.1
 */