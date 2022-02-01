package cooperation.qzone;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

final class QzoneVerticalVideoDownloadActivity$7
  implements Runnable
{
  QzoneVerticalVideoDownloadActivity$7(String paramString1, String paramString2, QQAppInterface paramQQAppInterface, String paramString3, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(this.val$subKey, this.val$value);
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(this.val$app.getCurrentUin(), this.val$eventKey, true, this.val$time, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.QzoneVerticalVideoDownloadActivity.7
 * JD-Core Version:    0.7.0.1
 */