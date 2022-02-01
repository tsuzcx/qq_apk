package cooperation.ilive;

import aodu;
import aodw;
import biaq;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class IliveLaunchFragment$8
  implements Runnable
{
  IliveLaunchFragment$8(IliveLaunchFragment paramIliveLaunchFragment, long paramLong) {}
  
  public void run()
  {
    aodu.b(false);
    QLog.i("IliveLaunchActivity", 1, "cpu use = " + aodu.a.a + " cost = " + this.a);
    HashMap localHashMap = new HashMap();
    localHashMap.put("cpu", aodu.a.a + "");
    biaq.a("ilive_preload_monitor", localHashMap, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.IliveLaunchFragment.8
 * JD-Core Version:    0.7.0.1
 */