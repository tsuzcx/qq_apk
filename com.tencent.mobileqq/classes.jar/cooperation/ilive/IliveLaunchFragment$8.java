package cooperation.ilive;

import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.ProcessStats;
import com.tencent.qqperf.tools.ProcessStats.Stats;
import java.util.HashMap;
import java.util.Map;

final class IliveLaunchFragment$8
  implements Runnable
{
  IliveLaunchFragment$8(long paramLong) {}
  
  public void run()
  {
    ProcessStats.b(false);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cpu use = ");
    ((StringBuilder)localObject).append(ProcessStats.c.f);
    ((StringBuilder)localObject).append(" cost = ");
    ((StringBuilder)localObject).append(this.a);
    QLog.i("IliveLaunchActivity", 1, ((StringBuilder)localObject).toString());
    localObject = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ProcessStats.c.f);
    localStringBuilder.append("");
    ((HashMap)localObject).put("cpu", localStringBuilder.toString());
    VasStatisticCollector.a("ilive_preload_monitor", (Map)localObject, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.IliveLaunchFragment.8
 * JD-Core Version:    0.7.0.1
 */