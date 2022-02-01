package dov.com.qq.im.capture.adapter;

import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;

class QIMPtvTemplateAdapter$3
  implements Runnable
{
  QIMPtvTemplateAdapter$3(QIMPtvTemplateAdapter paramQIMPtvTemplateAdapter) {}
  
  public void run()
  {
    FeatureManager.loadBasicFeatures();
    QLog.d("Q.videostory.capture", QLog._DEFAULT_REPORTLOG_LEVEL, "use material failed because of so load failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.3
 * JD-Core Version:    0.7.0.1
 */