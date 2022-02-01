package com.tencent.qqmini.miniapp.widget.camera;

import android.hardware.Camera;

class MiniAppCamera$10
  implements Runnable
{
  MiniAppCamera$10(MiniAppCamera paramMiniAppCamera, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.stopPreview(true);
    MiniAppCamera localMiniAppCamera = this.this$0;
    if (this.val$isBack) {
      localObject = localMiniAppCamera.backCameraId;
    } else {
      localObject = localMiniAppCamera.frontCameraId;
    }
    localMiniAppCamera.setupCamera(((Integer)localObject).intValue());
    Object localObject = this.this$0;
    ((MiniAppCamera)localObject).onCameraSurfaceCreate(((MiniAppCamera)localObject).mPreviewSt);
    localObject = this.this$0;
    ((MiniAppCamera)localObject).setCameraSize(((MiniAppCamera)localObject).cameraSize);
    this.this$0.camera.startPreview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.10
 * JD-Core Version:    0.7.0.1
 */