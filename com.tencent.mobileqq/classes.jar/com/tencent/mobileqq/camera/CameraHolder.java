package com.tencent.mobileqq.camera;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import com.tencent.mobileqq.camera.adapter.CameraWrapper;
import com.tencent.qphone.base.util.QLog;

@TargetApi(9)
public class CameraHolder
{
  private static Camera.CameraInfo[] f;
  private static CameraHolder h;
  private final int a;
  private int b = -1;
  private int c = -1;
  private int d = -1;
  private final Camera.CameraInfo[] e;
  private CameraWrapper g = CameraWrapper.a();
  
  private CameraHolder()
  {
    Object localObject = f;
    int k = 0;
    int j;
    if (localObject != null)
    {
      this.a = localObject.length;
      this.e = ((Camera.CameraInfo[])localObject);
      j = k;
    }
    else
    {
      this.a = c();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[CameraHolder] mNumberOfCameras = ");
        ((StringBuilder)localObject).append(this.a);
        QLog.d("Q.camera.CameraHolder", 1, ((StringBuilder)localObject).toString());
      }
      this.e = new Camera.CameraInfo[this.a];
      int i = 0;
      for (;;)
      {
        j = k;
        if (i >= this.a) {
          break;
        }
        this.e[i] = new Camera.CameraInfo();
        try
        {
          Camera.getCameraInfo(i, this.e[i]);
        }
        catch (Exception localException)
        {
          QLog.e("Q.camera.CameraHolder", 2, localException, new Object[0]);
        }
        i += 1;
      }
    }
    while (j < this.a)
    {
      if ((this.c == -1) && (this.e[j].facing == 0)) {
        this.c = j;
      } else if ((this.d == -1) && (this.e[j].facing == 1)) {
        this.d = j;
      }
      j += 1;
    }
  }
  
  public static CameraHolder a()
  {
    try
    {
      if (h == null) {
        try
        {
          if (h == null) {
            h = new CameraHolder();
          }
        }
        finally {}
      }
      CameraHolder localCameraHolder = h;
      return localCameraHolder;
    }
    finally {}
  }
  
  public CameraWrapper b()
  {
    return CameraWrapper.a();
  }
  
  public int c()
  {
    return CameraWrapper.a().f();
  }
  
  public Camera.CameraInfo[] d()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.CameraHolder
 * JD-Core Version:    0.7.0.1
 */