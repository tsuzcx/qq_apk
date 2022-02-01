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
    if (this.val$isBack) {}
    for (Integer localInteger = this.this$0.backCameraId;; localInteger = this.this$0.frontCameraId)
    {
      localMiniAppCamera.setupCamera(localInteger.intValue());
      this.this$0.onCameraSurfaceCreate(this.this$0.mPreviewSt);
      this.this$0.setCameraSize(this.this$0.cameraSize);
      this.this$0.camera.startPreview();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.10
 * JD-Core Version:    0.7.0.1
 */