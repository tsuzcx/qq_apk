package com.tencent.qphone.base.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import java.io.File;

public class StringUtils
{
  public static final String MSF_LIB_BOOTV2 = "msfbootV2";
  public static final String MSF_LIB_CODEC_V2 = "codecwrapperV2";
  public static final String MSF_LIB_QUIC = "quic";
  private static final String TAG_LOAD_MSF = "LoadMSFSo";
  
  public static String getIpAddrFromInt(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    localStringBuffer.append(String.valueOf(paramInt >>> 24));
    localStringBuffer.append(".");
    localStringBuffer.append(String.valueOf((0xFFFFFF & paramInt) >>> 16));
    localStringBuffer.append(".");
    localStringBuffer.append(String.valueOf((0xFFFF & paramInt) >>> 8));
    localStringBuffer.append(".");
    localStringBuffer.append(String.valueOf(paramInt & 0xFF));
    return localStringBuffer.toString();
  }
  
  public static boolean getLoadResult(int paramInt)
  {
    if ((paramInt & 0x2) == 2) {}
    while ((paramInt & 0x40000) == 262144) {
      return true;
    }
    return false;
  }
  
  public static String getPlatformString()
  {
    String str = Build.CPU_ABI;
    if ((str != null) && (str.contains("x86"))) {
      return "x86";
    }
    if ((str != null) && (str.contains("mip"))) {
      return "mips";
    }
    return "armeabi";
  }
  
  public static String getTxLib(Context paramContext)
  {
    return paramContext.getFilesDir().getParent() + "/txlib/";
  }
  
  public static boolean loadLibrary(String paramString1, Context paramContext, String paramString2, String paramString3)
  {
    boolean bool2 = true;
    if (paramContext == null) {
      return false;
    }
    paramContext = new File(paramString2);
    if (paramContext.exists()) {}
    boolean bool1;
    label125:
    for (;;)
    {
      try
      {
        System.load(paramContext.getAbsolutePath());
        bool1 = true;
        if ((bool1) || (TextUtils.isEmpty(paramString3))) {
          break label125;
        }
      }
      catch (Throwable paramString2)
      {
        QLog.e(paramString1, 1, "cannot load library " + paramContext.getAbsolutePath(), paramString2);
      }
      try
      {
        System.loadLibrary(paramString3);
        bool1 = bool2;
      }
      catch (Throwable paramContext)
      {
        QLog.e(paramString1, 1, "cannot load system library " + paramString3, paramContext);
        bool1 = false;
        continue;
      }
      return bool1;
      bool1 = false;
    }
  }
  
  public static boolean loadLibrary(String paramString1, String paramString2, Context paramContext)
  {
    boolean bool2;
    if (paramContext == null)
    {
      bool2 = false;
      return bool2;
    }
    File localFile2 = new File(getTxLib(paramContext) + "lib" + paramString2 + ".so");
    File localFile1 = localFile2;
    if (!localFile2.exists()) {
      localFile1 = new File(paramContext.getFilesDir().getParent() + "/lib/lib" + paramString2 + ".so");
    }
    if (localFile1.exists()) {}
    for (;;)
    {
      try
      {
        System.load(localFile1.getAbsolutePath());
        boolean bool1 = true;
        bool2 = bool1;
        if (bool1) {
          break;
        }
        bool1 = false;
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        try
        {
          System.loadLibrary(paramString2);
          return true;
        }
        catch (UnsatisfiedLinkError paramContext)
        {
          if (!QLog.isColorLevel()) {
            break label207;
          }
          QLog.d(paramString1, 2, "cannot load library " + paramString2);
        }
        paramContext = paramContext;
        if (QLog.isColorLevel()) {
          QLog.d(paramString1, 2, "cannot load library " + localFile1.getAbsolutePath());
        }
      }
    }
    label207:
    return false;
  }
  
  public static int msfLoadSo(String paramString1, String paramString2)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        System.loadLibrary(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("LoadMSFSo", 2, "System.loadLibrary, libname = " + paramString2 + " suc");
        }
        i = 262144;
      }
      catch (Throwable localThrowable1)
      {
        QLog.e("LoadMSFSo", 1, localThrowable1, new Object[0]);
        if (!"armeabi".equalsIgnoreCase(getPlatformString())) {
          break label155;
        }
        if ((BaseApplication.processName != null) && ((BaseApplication.processName == null) || (!BaseApplication.processName.endsWith(":MSF")))) {
          continue;
        }
        SoLoadUtilNew.setReport(null);
        i = SoLoadCore.loadSo(BaseApplication.getContext(), paramString2);
        QLog.e(paramString1, 1, "loadso arm " + paramString2 + " resultCode=" + i);
        continue;
      }
      finally {}
      return i;
      try
      {
        label155:
        bool = loadLibrary(paramString1, paramString2, BaseApplication.getContext());
        QLog.d(paramString1, 1, "loadso x86 " + paramString2 + " " + bool);
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          localThrowable2.printStackTrace();
          boolean bool = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.StringUtils
 * JD-Core Version:    0.7.0.1
 */