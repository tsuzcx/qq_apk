package cooperation.vip.ar.util;

import amwr;
import apvb;
import bhxp;
import bhyk;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;

public class VipQGLoaderManager$1
  implements Runnable
{
  public VipQGLoaderManager$1(bhyk parambhyk, String paramString1, String paramString2, bhxp parambhxp, amwr paramamwr) {}
  
  public void run()
  {
    if (apvb.a(this.jdField_a_of_type_JavaLangString))
    {
      QZLog.i("VipARQGLoaderManager", 1, "getQGModelData file exist save to map");
      if (bhyk.a(this.this$0) != null) {
        bhyk.a(this.this$0).put(this.b, this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Bhxp != null) {
        this.jdField_a_of_type_Bhxp.a(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    QZLog.i("VipARQGLoaderManager", 1, "getQGModelData file not exist start to download");
    this.this$0.b(this.jdField_a_of_type_Amwr, this.jdField_a_of_type_Bhxp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.ar.util.VipQGLoaderManager.1
 * JD-Core Version:    0.7.0.1
 */