package com.tencent.qqcamerakit.capture.camera;

import com.tencent.qqcamerakit.capture.cameraextend.TakePictureTask;

class CameraControl$1$1
  implements Runnable
{
  CameraControl$1$1(CameraControl.1 param1, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    this.b.b.f = this.a;
    this.b.b.g = 100;
    new TakePictureTask(this.b.b).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camera.CameraControl.1.1
 * JD-Core Version:    0.7.0.1
 */