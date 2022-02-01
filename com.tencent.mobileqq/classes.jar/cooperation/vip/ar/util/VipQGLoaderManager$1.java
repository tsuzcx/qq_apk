package cooperation.vip.ar.util;

import arjx;
import auog;
import bnub;
import bnuw;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;

public class VipQGLoaderManager$1
  implements Runnable
{
  public VipQGLoaderManager$1(bnuw parambnuw, String paramString1, String paramString2, bnub parambnub, arjx paramarjx) {}
  
  public void run()
  {
    if (auog.a(this.jdField_a_of_type_JavaLangString))
    {
      QZLog.i("VipARQGLoaderManager", 1, "getQGModelData file exist save to map");
      if (bnuw.a(this.this$0) != null) {
        bnuw.a(this.this$0).put(this.b, this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Bnub != null) {
        this.jdField_a_of_type_Bnub.a(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    QZLog.i("VipARQGLoaderManager", 1, "getQGModelData file not exist start to download");
    this.this$0.b(this.jdField_a_of_type_Arjx, this.jdField_a_of_type_Bnub);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ar.util.VipQGLoaderManager.1
 * JD-Core Version:    0.7.0.1
 */