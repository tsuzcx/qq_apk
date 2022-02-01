package com.tencent.qqcamerakit.capture.camerastrategy;

import android.os.Build.VERSION;
import com.tencent.qqcamerakit.capture.camera2.Camera2Control;
import com.tencent.qqcamerakit.common.QLog;

public class CameraAPIStrategy
{
  public static boolean a = false;
  private static boolean b;
  
  private static void a()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (b))
    {
      if (CameraCompatible.b(CameraCompatibleConfig.KEY.f))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Camera2]initIsSupportCamera2 return false, black device model, ");
        localStringBuilder.append(b);
        QLog.c("CameraAPIStrategy", 1, new Object[] { localStringBuilder.toString() });
        a = false;
        return;
      }
      int i = Camera2Control.b();
      boolean bool;
      if ((i != 1) && (i != 3)) {
        bool = false;
      } else {
        bool = true;
      }
      a = bool;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Camera2]initIsSupportCamera2 result:");
      localStringBuilder.append(a);
      QLog.c("CameraAPIStrategy", 1, new Object[] { localStringBuilder.toString() });
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Camera2]initIsSupportCamera2 return false, isCamera2Usable: ");
    localStringBuilder.append(b);
    QLog.c("CameraAPIStrategy", 1, new Object[] { localStringBuilder.toString() });
    a = false;
  }
  
  public static void a(boolean paramBoolean)
  {
    b = paramBoolean;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camerastrategy.CameraAPIStrategy
 * JD-Core Version:    0.7.0.1
 */