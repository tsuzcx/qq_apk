package cooperation.vip.ar.util;

import amgn;
import apdh;
import bgos;
import bgpn;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;

public class VipQGLoaderManager$1
  implements Runnable
{
  public VipQGLoaderManager$1(bgpn parambgpn, String paramString1, String paramString2, bgos parambgos, amgn paramamgn) {}
  
  public void run()
  {
    if (apdh.a(this.jdField_a_of_type_JavaLangString))
    {
      QZLog.i("VipARQGLoaderManager", 1, "getQGModelData file exist save to map");
      if (bgpn.a(this.this$0) != null) {
        bgpn.a(this.this$0).put(this.b, this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Bgos != null) {
        this.jdField_a_of_type_Bgos.a(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    QZLog.i("VipARQGLoaderManager", 1, "getQGModelData file not exist start to download");
    this.this$0.b(this.jdField_a_of_type_Amgn, this.jdField_a_of_type_Bgos);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.ar.util.VipQGLoaderManager.1
 * JD-Core Version:    0.7.0.1
 */