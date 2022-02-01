package cooperation.ilive.time;

import com.tencent.mobileqq.vas.VasStatisticCollector;
import cooperation.ilive.lite.IliveLiteMonitorUtil;
import java.util.HashMap;

class TimeMonitorData$1
  implements Runnable
{
  TimeMonitorData$1(TimeMonitorData paramTimeMonitorData, HashMap paramHashMap) {}
  
  public void run()
  {
    HashMap localHashMap1 = IliveLiteMonitorUtil.a();
    if (TimeMonitorData.a(this.this$0) != null) {
      localHashMap1.putAll(TimeMonitorData.a(this.this$0));
    }
    HashMap localHashMap2 = this.a;
    if (localHashMap2 != null) {
      localHashMap1.putAll(localHashMap2);
    }
    VasStatisticCollector.a(TimeMonitorData.a(this.this$0), localHashMap1, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.time.TimeMonitorData.1
 * JD-Core Version:    0.7.0.1
 */