package com.tencent.qqcamerakit.capture.camerastrategy;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.qqcamerakit.common.QLog;
import java.util.Hashtable;

public class CameraCompatible
{
  private static Hashtable<String, String> a = CameraCompatibleConfig.a;
  
  public static boolean a(String paramString)
  {
    if (QLog.a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isFoundProduct key=");
      localStringBuilder.append(paramString);
      QLog.d("CameraCompatible", 2, new Object[] { localStringBuilder.toString() });
    }
    paramString = (String)a.get(paramString);
    return a(Build.MODEL, paramString);
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return false;
    }
    paramString2 = paramString2.split("\\|");
    int j = paramString2.length;
    int i = 0;
    while (i < j)
    {
      if (paramString2[i].equalsIgnoreCase(paramString1))
      {
        bool = true;
        break label49;
      }
      i += 1;
    }
    boolean bool = false;
    label49:
    if (QLog.a())
    {
      paramString2 = new StringBuilder();
      paramString2.append("isFound buildType:");
      paramString2.append(paramString1);
      paramString2.append(", result:");
      paramString2.append(bool);
      QLog.d("CameraCompatible", 2, new Object[] { paramString2.toString() });
    }
    return bool;
  }
  
  public static boolean b(String paramString)
  {
    if (QLog.a())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isFoundProduct2 key=");
      localStringBuilder.append(paramString);
      QLog.d("CameraCompatible", 2, new Object[] { localStringBuilder.toString() });
    }
    paramString = (String)a.get(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append(";");
    localStringBuilder.append(Build.MODEL);
    return a(localStringBuilder.toString(), paramString);
  }
  
  public static boolean c(String paramString)
  {
    if (QLog.a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isFoundProductFeatureRom key=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("CameraCompatible", 2, new Object[] { ((StringBuilder)localObject).toString() });
    }
    Object localObject = a;
    if (localObject == null) {
      return false;
    }
    paramString = (String)((Hashtable)localObject).get(paramString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append(Build.MODEL);
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append(Build.ID);
    return a(((StringBuilder)localObject).toString(), paramString);
  }
  
  public static boolean d(String paramString)
  {
    if (QLog.a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isFoundProductFeatureRom2 key=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("CameraCompatible", 2, new Object[] { ((StringBuilder)localObject).toString() });
    }
    Object localObject = a;
    if (localObject == null) {
      return false;
    }
    paramString = (String)((Hashtable)localObject).get(paramString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append(Build.MODEL);
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
    return a(((StringBuilder)localObject).toString(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camerastrategy.CameraCompatible
 * JD-Core Version:    0.7.0.1
 */