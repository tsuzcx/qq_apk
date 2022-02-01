package cooperation.qzone.report;

import android.text.TextUtils;
import common.config.service.QzoneConfig;

class QzoneReportManager$2
  implements Runnable
{
  QzoneReportManager$2(QzoneReportManager paramQzoneReportManager, int paramInt) {}
  
  public void run()
  {
    if (!QzoneReportManager.isConfigInitialize())
    {
      QzoneReportManager.config = QzoneConfig.getInstance().getConfig("ClientReport", "report_plog", "");
      QzoneReportManager.isConfigInitialize = true;
    }
    if (TextUtils.isEmpty(QzoneReportManager.config)) {}
    while ((QzoneReportManager.isNeedPLog(this.val$type)) && (!QzoneReportManager.isNeedSaveData(this.val$type))) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.QzoneReportManager.2
 * JD-Core Version:    0.7.0.1
 */