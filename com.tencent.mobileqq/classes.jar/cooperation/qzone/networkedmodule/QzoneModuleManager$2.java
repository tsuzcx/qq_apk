package cooperation.qzone.networkedmodule;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;

class QzoneModuleManager$2
  implements Runnable
{
  QzoneModuleManager$2(QzoneModuleManager paramQzoneModuleManager) {}
  
  public void run()
  {
    int i = StatisticCollector.getQzonePatchTag();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("current versionNum is:");
    localStringBuilder.append(i);
    QLog.i("QzoneModuleManager", 1, localStringBuilder.toString());
    StatisticCollector.setQzonePatchTag(i + 6000);
    QzoneModuleManager.access$102(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleManager.2
 * JD-Core Version:    0.7.0.1
 */