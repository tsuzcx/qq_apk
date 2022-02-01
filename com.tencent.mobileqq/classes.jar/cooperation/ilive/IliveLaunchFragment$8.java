package cooperation.ilive;

import aoaj;
import aoal;
import bhpu;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class IliveLaunchFragment$8
  implements Runnable
{
  IliveLaunchFragment$8(long paramLong) {}
  
  public void run()
  {
    aoaj.b(false);
    QLog.i("IliveLaunchActivity", 1, "cpu use = " + aoaj.a.a + " cost = " + this.a);
    HashMap localHashMap = new HashMap();
    localHashMap.put("cpu", aoaj.a.a + "");
    bhpu.a("ilive_preload_monitor", localHashMap, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.IliveLaunchFragment.8
 * JD-Core Version:    0.7.0.1
 */