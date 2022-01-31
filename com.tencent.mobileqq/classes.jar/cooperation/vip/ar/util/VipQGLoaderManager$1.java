package cooperation.vip.ar.util;

import amwq;
import apvd;
import bhyg;
import bhzb;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;

public class VipQGLoaderManager$1
  implements Runnable
{
  public VipQGLoaderManager$1(bhzb parambhzb, String paramString1, String paramString2, bhyg parambhyg, amwq paramamwq) {}
  
  public void run()
  {
    if (apvd.a(this.jdField_a_of_type_JavaLangString))
    {
      QZLog.i("VipARQGLoaderManager", 1, "getQGModelData file exist save to map");
      if (bhzb.a(this.this$0) != null) {
        bhzb.a(this.this$0).put(this.b, this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Bhyg != null) {
        this.jdField_a_of_type_Bhyg.a(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    QZLog.i("VipARQGLoaderManager", 1, "getQGModelData file not exist start to download");
    this.this$0.b(this.jdField_a_of_type_Amwq, this.jdField_a_of_type_Bhyg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.ar.util.VipQGLoaderManager.1
 * JD-Core Version:    0.7.0.1
 */