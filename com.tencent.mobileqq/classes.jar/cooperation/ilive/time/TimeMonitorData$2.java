package cooperation.ilive.time;

import com.tencent.mobileqq.vas.VasStatisticCollector;
import cooperation.ilive.lite.IliveLiteMonitorUtil;
import java.util.HashMap;

class TimeMonitorData$2
  implements Runnable
{
  TimeMonitorData$2(TimeMonitorData paramTimeMonitorData, HashMap paramHashMap, String paramString, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap1 = IliveLiteMonitorUtil.a();
    HashMap localHashMap2 = this.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap2 != null) {
      localHashMap1.putAll(localHashMap2);
    }
    VasStatisticCollector.a(this.jdField_a_of_type_JavaLangString, localHashMap1, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.time.TimeMonitorData.2
 * JD-Core Version:    0.7.0.1
 */