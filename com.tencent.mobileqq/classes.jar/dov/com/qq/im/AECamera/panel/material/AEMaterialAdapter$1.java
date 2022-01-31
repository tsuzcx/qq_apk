package dov.com.qq.im.AECamera.panel.material;

import bgzy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;

public class AEMaterialAdapter$1
  implements Runnable
{
  public AEMaterialAdapter$1(bgzy parambgzy) {}
  
  public void run()
  {
    FeatureManager.loadBasicFeatures();
    QLog.d("Q.videostory.capture", 1, "use material failed because of so load failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.panel.material.AEMaterialAdapter.1
 * JD-Core Version:    0.7.0.1
 */