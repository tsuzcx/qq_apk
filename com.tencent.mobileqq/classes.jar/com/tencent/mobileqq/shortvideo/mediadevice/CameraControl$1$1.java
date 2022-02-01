package com.tencent.mobileqq.shortvideo.mediadevice;

import android.hardware.Camera.Size;

class CameraControl$1$1
  implements Runnable
{
  CameraControl$1$1(CameraControl.1 param1, byte[] paramArrayOfByte, Camera.Size paramSize) {}
  
  public void run()
  {
    CameraControl.TakePictureData localTakePictureData = new CameraControl.TakePictureData(this.c.i, null);
    localTakePictureData.a = this.a;
    localTakePictureData.b = this.c.d;
    localTakePictureData.c = this.c.e;
    localTakePictureData.d = this.c.f;
    localTakePictureData.e = this.c.b;
    localTakePictureData.f = this.c.i.g;
    localTakePictureData.h = 100;
    localTakePictureData.g = this.c.g;
    localTakePictureData.i = this.c.h;
    localTakePictureData.j = this.b;
    new CameraControl.TakePictureTask(this.c.i, localTakePictureData).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.1.1
 * JD-Core Version:    0.7.0.1
 */