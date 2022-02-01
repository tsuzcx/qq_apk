package dov.com.qq.im.ae.camera.ui.bottom;

import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;

class AEBottomListAdapter$2
  implements Runnable
{
  AEBottomListAdapter$2(AEBottomListAdapter paramAEBottomListAdapter) {}
  
  public void run()
  {
    FeatureManager.loadBasicFeatures();
    QLog.d("Q.videostory.capture", QLog._DEFAULT_REPORTLOG_LEVEL, "use watermark failed because of so load failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.2
 * JD-Core Version:    0.7.0.1
 */