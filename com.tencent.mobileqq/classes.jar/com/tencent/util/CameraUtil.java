package com.tencent.util;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;

public class CameraUtil
{
  public static Camera a()
  {
    return a(-1, 5);
  }
  
  public static Camera a(int paramInt)
  {
    return a(paramInt, 5);
  }
  
  @TargetApi(9)
  public static Camera a(int paramInt1, int paramInt2)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      paramInt2 = 1;
    }
    int i = 0;
    Camera localCamera1 = null;
    Object localObject3;
    for (;;)
    {
      localObject3 = localCamera1;
      if (i < paramInt2)
      {
        Camera localCamera2 = localCamera1;
        try
        {
          if ((Build.VERSION.SDK_INT >= 9) && (paramInt1 != -1))
          {
            localCamera2 = localCamera1;
            localCamera1 = Camera.open(paramInt1);
          }
          else
          {
            localCamera2 = localCamera1;
            localCamera1 = Camera.open();
          }
          localCamera2 = localCamera1;
          localObject3 = localCamera1;
          if (QLog.isColorLevel())
          {
            localCamera2 = localCamera1;
            localObject3 = new StringBuilder();
            localCamera2 = localCamera1;
            ((StringBuilder)localObject3).append("openCameraWithRetry successfully.  retry times = ");
            localCamera2 = localCamera1;
            ((StringBuilder)localObject3).append(i);
            localCamera2 = localCamera1;
            ((StringBuilder)localObject3).append(", max retry times = ");
            localCamera2 = localCamera1;
            ((StringBuilder)localObject3).append(paramInt2);
            localCamera2 = localCamera1;
            QLog.d("CameraUtil", 2, ((StringBuilder)localObject3).toString());
            return localCamera1;
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("openCameraWithRetry. Fail to open camera. error msg: ");
            ((StringBuilder)localObject3).append(localException.getMessage());
            ((StringBuilder)localObject3).append(", retry times = ");
            ((StringBuilder)localObject3).append(i);
            ((StringBuilder)localObject3).append(", max retry times = ");
            ((StringBuilder)localObject3).append(paramInt2);
            QLog.d("CameraUtil", 2, ((StringBuilder)localObject3).toString());
          }
          i += 1;
          Object localObject2;
          if (i < paramInt2) {
            try
            {
              Thread.currentThread();
              Thread.sleep(500);
              Object localObject1 = localCamera2;
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
              localObject2 = localCamera2;
            }
          } else {
            throw new RuntimeException(localObject2);
          }
        }
      }
    }
    return localObject3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.CameraUtil
 * JD-Core Version:    0.7.0.1
 */