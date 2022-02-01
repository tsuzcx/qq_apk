package cooperation.qzone;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

final class QzoneVerticalVideoDownloadActivity$7
  implements Runnable
{
  QzoneVerticalVideoDownloadActivity$7(QQAppInterface paramQQAppInterface, String paramString, HashMap paramHashMap) {}
  
  public void run()
  {
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(this.val$app.getCurrentUin(), this.val$eventId, true, 0L, 0L, this.val$keyvalues, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneVerticalVideoDownloadActivity.7
 * JD-Core Version:    0.7.0.1
 */