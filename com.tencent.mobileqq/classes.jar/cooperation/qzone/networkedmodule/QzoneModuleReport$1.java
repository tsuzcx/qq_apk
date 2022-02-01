package cooperation.qzone.networkedmodule;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

final class QzoneModuleReport$1
  implements Runnable
{
  QzoneModuleReport$1(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap paramHashMap, String paramString3) {}
  
  public void run()
  {
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.val$uin, this.val$tagName, this.val$success, this.val$duration, this.val$size, this.val$params, this.val$reserved);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleReport.1
 * JD-Core Version:    0.7.0.1
 */