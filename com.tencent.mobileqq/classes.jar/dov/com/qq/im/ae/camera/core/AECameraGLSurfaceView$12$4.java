package dov.com.qq.im.ae.camera.core;

import bojl;
import bpam;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class AECameraGLSurfaceView$12$4
  implements Runnable
{
  AECameraGLSurfaceView$12$4(AECameraGLSurfaceView.12 param12, VideoMaterial paramVideoMaterial, bojl parambojl) {}
  
  public void run()
  {
    bpam.d("AECameraGLSurfaceView", "[setVideoMaterial] update material" + this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.getId());
    this.jdField_a_of_type_Bojl.a(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.12.4
 * JD-Core Version:    0.7.0.1
 */