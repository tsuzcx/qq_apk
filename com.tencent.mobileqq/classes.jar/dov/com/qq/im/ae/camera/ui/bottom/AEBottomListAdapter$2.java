package dov.com.qq.im.ae.camera.ui.bottom;

import blpm;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;

public class AEBottomListAdapter$2
  implements Runnable
{
  public AEBottomListAdapter$2(blpm paramblpm) {}
  
  public void run()
  {
    FeatureManager.loadBasicFeatures();
    QLog.d("Q.videostory.capture", 1, "use watermark failed because of so load failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.2
 * JD-Core Version:    0.7.0.1
 */