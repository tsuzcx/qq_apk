package cooperation.vip.manager;

import bkbp;
import bkbs;
import cooperation.qzone.util.QZLog;

public class GdtGeneralManager$2
  implements Runnable
{
  public GdtGeneralManager$2(bkbp parambkbp, long paramLong, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("GdtGeneralManager", "getGdtInfoRequest uin= " + this.jdField_a_of_type_Long + "adv_type = " + this.jdField_a_of_type_Int + "busineestype =" + this.b);
    }
    bkbp.a(this.this$0, this.this$0.a());
    bkbs.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, bkbp.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.manager.GdtGeneralManager.2
 * JD-Core Version:    0.7.0.1
 */