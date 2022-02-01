package cooperation.qzone.report;

import android.text.TextUtils;
import common.config.service.QzoneConfig;

class QzoneReportManager$2
  implements Runnable
{
  public void run()
  {
    if (!QzoneReportManager.a())
    {
      QzoneReportManager.jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("ClientReport", "report_plog", "");
      QzoneReportManager.jdField_a_of_type_Boolean = true;
    }
    if (TextUtils.isEmpty(QzoneReportManager.jdField_a_of_type_JavaLangString)) {}
    while ((QzoneReportManager.a(this.a)) && (!QzoneReportManager.b(this.a))) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.QzoneReportManager.2
 * JD-Core Version:    0.7.0.1
 */