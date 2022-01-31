package com.tencent.qqsharpP;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.SharpPDec;
import java.io.File;

public final class QQSharpPUtil
{
  public static boolean a;
  private static boolean b;
  
  public static File a(File paramFile)
  {
    File localFile = new File(paramFile.getAbsolutePath() + ".shp");
    if (paramFile.exists()) {
      paramFile.renameTo(localFile);
    }
    return localFile;
  }
  
  public static String a(File paramFile)
  {
    return paramFile.getAbsolutePath() + ".shp";
  }
  
  public static boolean a()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.vip_individuation.name());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject != null) && (localObject.length >= 2) && (!"0".equals(localObject[1]))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    if ((!a) && (a())) {
      b(paramContext);
    }
    return (a) && (a());
  }
  
  public static boolean b()
  {
    String str = Build.CPU_ABI + Build.CPU_ABI2;
    if (Build.VERSION.SDK_INT < 14) {}
    while ((!str.contains("armeabi-v7a")) && (!str.contains("armeabi"))) {
      return false;
    }
    return true;
  }
  
  public static boolean b(Context paramContext)
  {
    if (!b) {
      b = UpdateAvSo.a(paramContext, "TcHevcDec");
    }
    if ((b) && (!a)) {
      a = c(paramContext);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSharpPUtil", 2, "isSharpPSoAvaliable: " + b);
    }
    return b;
  }
  
  private static boolean c(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if ((!b()) || (!a())) {
      return false;
    }
    try
    {
      if (SharpPDec.a(paramContext) == 1) {
        bool1 = true;
      }
      bool2 = bool1;
      QLog.i("-------cooperation.SharpPDec", 4, "load from qq original");
      return bool1;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      paramContext.printStackTrace();
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.qqsharpP.QQSharpPUtil
 * JD-Core Version:    0.7.0.1
 */