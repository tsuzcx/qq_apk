package dov.com.qq.im.ae.camera.core;

import bmbx;

class AECameraManager$4
  implements Runnable
{
  AECameraManager$4(AECameraManager paramAECameraManager, int paramInt, AECameraManager.CameraOpenCallback paramCameraOpenCallback) {}
  
  public void run()
  {
    bmbx.b("AECameraManager", "[cameraManagerHandler] changeCamera " + this.val$whichCamera);
    if ((this.val$whichCamera != 2) && (this.val$whichCamera != 1))
    {
      bmbx.d("AECameraManager", "[cameraManagerHandler] changeCamera invalid camera: " + this.val$whichCamera);
      this.val$cameraOpenCallback.onOpenResult(AECameraManager.access$200(this.this$0), AECameraManager.access$500(this.this$0));
      return;
    }
    if ((AECameraManager.access$200(this.this$0) != this.val$whichCamera) && (AECameraManager.access$500(this.this$0)))
    {
      bmbx.b("AECameraManager", "[cameraManagerHandler] changeCamera, firstly close last camera: " + AECameraManager.access$200(this.this$0));
      AECameraManager.access$100(this.this$0, false);
    }
    AECameraManager.access$202(this.this$0, this.val$whichCamera);
    AECameraManager.access$000(this.this$0, this.val$cameraOpenCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.4
 * JD-Core Version:    0.7.0.1
 */