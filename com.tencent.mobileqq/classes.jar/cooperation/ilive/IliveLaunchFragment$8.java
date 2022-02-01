package cooperation.ilive;

import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.ProcessStats;
import com.tencent.qqperf.tools.ProcessStats.Stats;
import java.util.HashMap;

final class IliveLaunchFragment$8
  implements Runnable
{
  IliveLaunchFragment$8(long paramLong) {}
  
  public void run()
  {
    ProcessStats.b(false);
    QLog.i("IliveLaunchActivity", 1, "cpu use = " + ProcessStats.a.a + " cost = " + this.a);
    HashMap localHashMap = new HashMap();
    localHashMap.put("cpu", ProcessStats.a.a + "");
    VasStatisticCollector.a("ilive_preload_monitor", localHashMap, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.IliveLaunchFragment.8
 * JD-Core Version:    0.7.0.1
 */