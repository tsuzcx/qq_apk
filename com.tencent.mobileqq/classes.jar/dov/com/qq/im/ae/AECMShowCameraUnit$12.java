package dov.com.qq.im.ae;

import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.cmshow.AECMShowRequestController.CmShowDataWrapper;
import dov.com.qq.im.ae.sink.CmShowAssetsData;
import java.util.HashMap;

class AECMShowCameraUnit$12
  implements Runnable
{
  AECMShowCameraUnit$12(AECMShowCameraUnit paramAECMShowCameraUnit, AECMShowRequestController.CmShowDataWrapper paramCmShowDataWrapper) {}
  
  public void run()
  {
    CmShowAssetsData localCmShowAssetsData = new CmShowAssetsData();
    localCmShowAssetsData.jdField_a_of_type_JavaUtilHashMap.putAll(this.a.namePathMap);
    localCmShowAssetsData.jdField_a_of_type_JavaLangString = this.a.rolePath;
    localCmShowAssetsData.b = this.a.cmJsonString;
    localCmShowAssetsData.jdField_a_of_type_JavaUtilHashMap.put("role", localCmShowAssetsData.jdField_a_of_type_JavaLangString);
    this.this$0.a.queueEvent(new AECMShowCameraUnit.12.1(this, localCmShowAssetsData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AECMShowCameraUnit.12
 * JD-Core Version:    0.7.0.1
 */