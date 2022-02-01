package dov.com.qq.im.ae;

import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.cmshow.AECMShowResourceManager.CMJoyEssentialDownloadCallback;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.HashMap;

class AECMShowCameraUnit$2$1
  implements AECMShowResourceManager.CMJoyEssentialDownloadCallback
{
  AECMShowCameraUnit$2$1(AECMShowCameraUnit.2 param2) {}
  
  public void a(boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (paramBoolean)
    {
      AECMShowCameraUnit.a(this.a.this$0, (String)paramHashMap.get("video_limishow_base"));
      if (AECMShowCameraUnit.a(this.a.this$0))
      {
        this.a.this$0.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.queueEvent(new AECMShowCameraUnit.2.1.1(this));
        this.a.this$0.jdField_a_of_type_Boolean = true;
        AEQLog.a(this.a.this$0.b, "[fetchMaterialPath] onComplete: 完成设置素材");
      }
      return;
    }
    AEQLog.d(this.a.this$0.b, "[fetchMaterialPath] onComplete: 请求base资源失败");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AECMShowCameraUnit.2.1
 * JD-Core Version:    0.7.0.1
 */