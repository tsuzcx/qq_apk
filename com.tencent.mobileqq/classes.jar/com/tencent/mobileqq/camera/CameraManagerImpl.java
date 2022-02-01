package com.tencent.mobileqq.camera;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.HandlerThread;
import java.io.IOException;

@TargetApi(9)
public class CameraManagerImpl
  implements CameraManager
{
  HandlerThread a;
  private Camera.Parameters b;
  private boolean c;
  private IOException d;
  private CameraManagerImpl.CameraHandler e = null;
  private Camera f = null;
  private Camera.Parameters g = null;
  
  CameraManagerImpl()
  {
    a();
  }
  
  private void a()
  {
    if (this.e == null)
    {
      this.a = new HandlerThread("CameraThread");
      this.a.start();
      this.e = new CameraManagerImpl.CameraHandler(this, this.a.getLooper());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.CameraManagerImpl
 * JD-Core Version:    0.7.0.1
 */