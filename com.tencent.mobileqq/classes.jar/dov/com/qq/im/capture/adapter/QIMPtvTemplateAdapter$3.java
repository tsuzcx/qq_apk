package dov.com.qq.im.capture.adapter;

import blra;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;

public class QIMPtvTemplateAdapter$3
  implements Runnable
{
  public QIMPtvTemplateAdapter$3(blra paramblra) {}
  
  public void run()
  {
    FeatureManager.loadBasicFeatures();
    QLog.d("Q.videostory.capture", 1, "use material failed because of so load failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.3
 * JD-Core Version:    0.7.0.1
 */