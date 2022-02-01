package dov.com.qq.im.ae.camera.ui.panel;

import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;

class AEWaterMarkAdapter$1
  implements Runnable
{
  AEWaterMarkAdapter$1(AEWaterMarkAdapter paramAEWaterMarkAdapter) {}
  
  public void run()
  {
    FeatureManager.loadBasicFeatures();
    QLog.d("Q.videostory.capture", QLog._DEFAULT_REPORTLOG_LEVEL, "use material failed because of so load failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkAdapter.1
 * JD-Core Version:    0.7.0.1
 */