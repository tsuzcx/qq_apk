package cooperation.vip.manager;

import bgqd;
import bgqg;
import cooperation.qzone.util.QZLog;

public class GdtGeneralManager$2
  implements Runnable
{
  public GdtGeneralManager$2(bgqd parambgqd, long paramLong, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("GdtGeneralManager", "getGdtInfoRequest uin= " + this.jdField_a_of_type_Long + "adv_type = " + this.jdField_a_of_type_Int + "busineestype =" + this.b);
    }
    bgqd.a(this.this$0, this.this$0.a());
    bgqg.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, bgqd.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.manager.GdtGeneralManager.2
 * JD-Core Version:    0.7.0.1
 */