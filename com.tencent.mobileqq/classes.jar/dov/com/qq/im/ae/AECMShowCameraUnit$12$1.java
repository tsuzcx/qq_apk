package dov.com.qq.im.ae;

import com.tencent.aekit.api.standard.filter.AEFilterManager;
import dov.com.qq.im.ae.sink.CmShowAssetsData;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.HashMap;
import org.light.CameraController.DisplayType;

class AECMShowCameraUnit$12$1
  implements Runnable
{
  AECMShowCameraUnit$12$1(AECMShowCameraUnit.12 param12, CmShowAssetsData paramCmShowAssetsData) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_DovComQqImAeSinkCmShowAssetsData != null) && (this.jdField_a_of_type_DovComQqImAeSinkCmShowAssetsData.a != null)) {
      AEQLog.a(this.jdField_a_of_type_DovComQqImAeAECMShowCameraUnit$12.this$0.b, "[onComplete] kapuModel = " + this.jdField_a_of_type_DovComQqImAeSinkCmShowAssetsData.a.toString());
    }
    this.jdField_a_of_type_DovComQqImAeAECMShowCameraUnit$12.this$0.a.cmShowSetKapuModel(this.jdField_a_of_type_DovComQqImAeSinkCmShowAssetsData.a, this.jdField_a_of_type_DovComQqImAeSinkCmShowAssetsData.b, new AECMShowCameraUnit.12.1.1(this));
    this.jdField_a_of_type_DovComQqImAeAECMShowCameraUnit$12.this$0.a.cmShowSetKapuDisplayType(CameraController.DisplayType.HEAD);
    this.jdField_a_of_type_DovComQqImAeAECMShowCameraUnit$12.this$0.a("triggerState2", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AECMShowCameraUnit.12.1
 * JD-Core Version:    0.7.0.1
 */