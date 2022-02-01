package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.c;
import java.io.File;

public class q
{
  private static File a;
  private static String b = "";
  private static String c = "";
  
  public static long a()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getAvailableBlocks();
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!TextUtils.isEmpty(b))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b);
      localStringBuilder.append("&");
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
    }
    b = paramString;
  }
  
  @TargetApi(9)
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (a == null) {
      try
      {
        if (!paramContext.getApplicationInfo().processName.contains("com.tencent.mm")) {
          return false;
        }
        paramContext = QbSdk.getTbsFolderDir(paramContext);
        if (paramContext != null)
        {
          if (!paramContext.isDirectory()) {
            return false;
          }
          paramContext = new File(paramContext, "share");
          if ((!paramContext.isDirectory()) && (!paramContext.mkdir())) {
            return false;
          }
          a = paramContext;
          paramContext.setExecutable(true, false);
          return true;
        }
        return false;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  public static String b()
  {
    return b;
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = paramContext.getSharedPreferences("sai", 0).getBoolean("scfh", false);
      bool1 = bool2;
      localStringBuilder = new StringBuilder();
      bool1 = bool2;
      localStringBuilder.append("isStableCoreForHostEnable is ");
      bool1 = bool2;
      localStringBuilder.append(bool2);
      bool1 = bool2;
      Log.d("TbsUtils", localStringBuilder.toString());
      bool1 = bool2;
      localStringBuilder = new StringBuilder();
      bool1 = bool2;
      localStringBuilder.append("isStableCoreForHostEnable is ");
      bool1 = bool2;
      localStringBuilder.append(bool2);
      bool1 = bool2;
      TbsLog.i("TbsUtils", localStringBuilder.toString());
      bool1 = bool2;
      c.a().a(paramContext, Integer.valueOf(1003), new q.1(paramContext));
      return bool2;
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stack is ");
      localStringBuilder.append(Log.getStackTraceString(paramContext));
      TbsLog.i("TbsUtils", localStringBuilder.toString());
    }
    return bool1;
  }
  
  public static void c()
  {
    b = "";
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool1 = true;
    try
    {
      boolean bool2 = paramContext.getSharedPreferences("sai", 0).getBoolean("ucup", true);
      bool1 = bool2;
      localStringBuilder = new StringBuilder();
      bool1 = bool2;
      localStringBuilder.append("isUploadCoreUpdateEnable is ");
      bool1 = bool2;
      localStringBuilder.append(bool2);
      bool1 = bool2;
      Log.d("TbsUtils", localStringBuilder.toString());
      bool1 = bool2;
      localStringBuilder = new StringBuilder();
      bool1 = bool2;
      localStringBuilder.append("isUploadCoreUpdateEnable is ");
      bool1 = bool2;
      localStringBuilder.append(bool2);
      bool1 = bool2;
      TbsLog.i("TbsUtils", localStringBuilder.toString());
      bool1 = bool2;
      c.a().a(paramContext, Integer.valueOf(1005), new q.2(paramContext));
      return bool2;
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stack is ");
      localStringBuilder.append(Log.getStackTraceString(paramContext));
      TbsLog.i("TbsUtils", localStringBuilder.toString());
    }
    return bool1;
  }
  
  public static String d(Context paramContext)
  {
    if (!TextUtils.isEmpty(c))
    {
      paramContext = new StringBuilder();
      paramContext.append("getBuildModel cache is ");
      paramContext.append(c);
      Log.d("TbsUtils", paramContext.toString());
      return c;
    }
    try
    {
      paramContext = paramContext.getSharedPreferences("sai", 0);
      c = paramContext.getString("bmo", "");
      if (!TextUtils.isEmpty(c))
      {
        paramContext = new StringBuilder();
        paramContext.append("getBuildModel sp is ");
        paramContext.append(c);
        Log.d("TbsUtils", paramContext.toString());
        return c;
      }
      c = Build.MODEL;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBuildModel is ");
      localStringBuilder.append(c);
      Log.d("TbsUtils", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBuildModel is ");
      localStringBuilder.append(c);
      TbsLog.i("TbsUtils", localStringBuilder.toString());
      paramContext = paramContext.edit();
      paramContext.putString("bmo", c);
      paramContext.commit();
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stack is ");
      localStringBuilder.append(Log.getStackTraceString(paramContext));
      TbsLog.i("TbsUtils", localStringBuilder.toString());
    }
    return c;
  }
  
  public static boolean e(Context paramContext)
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = paramContext.getSharedPreferences("sai", 0).getBoolean("rrff", false);
      bool1 = bool2;
      localStringBuilder = new StringBuilder();
      bool1 = bool2;
      localStringBuilder.append("isReadResponseFromFileEnable is ");
      bool1 = bool2;
      localStringBuilder.append(bool2);
      bool1 = bool2;
      Log.d("TbsUtils", localStringBuilder.toString());
      bool1 = bool2;
      localStringBuilder = new StringBuilder();
      bool1 = bool2;
      localStringBuilder.append("isReadResponseFromFileEnable is ");
      bool1 = bool2;
      localStringBuilder.append(bool2);
      bool1 = bool2;
      TbsLog.i("TbsUtils", localStringBuilder.toString());
      bool1 = bool2;
      c.a().a(paramContext, Integer.valueOf(1006), new q.3(paramContext));
      return bool2;
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stack is ");
      localStringBuilder.append(Log.getStackTraceString(paramContext));
      TbsLog.i("TbsUtils", localStringBuilder.toString());
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.utils.q
 * JD-Core Version:    0.7.0.1
 */