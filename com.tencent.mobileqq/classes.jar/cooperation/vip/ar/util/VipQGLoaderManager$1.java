package cooperation.vip.ar.util;

import aonx;
import arof;
import bkac;
import bkax;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;

public class VipQGLoaderManager$1
  implements Runnable
{
  public VipQGLoaderManager$1(bkax parambkax, String paramString1, String paramString2, bkac parambkac, aonx paramaonx) {}
  
  public void run()
  {
    if (arof.a(this.jdField_a_of_type_JavaLangString))
    {
      QZLog.i("VipARQGLoaderManager", 1, "getQGModelData file exist save to map");
      if (bkax.a(this.this$0) != null) {
        bkax.a(this.this$0).put(this.b, this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Bkac != null) {
        this.jdField_a_of_type_Bkac.a(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    QZLog.i("VipARQGLoaderManager", 1, "getQGModelData file not exist start to download");
    this.this$0.b(this.jdField_a_of_type_Aonx, this.jdField_a_of_type_Bkac);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.ar.util.VipQGLoaderManager.1
 * JD-Core Version:    0.7.0.1
 */