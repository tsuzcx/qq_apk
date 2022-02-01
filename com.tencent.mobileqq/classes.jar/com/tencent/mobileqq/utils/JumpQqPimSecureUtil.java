package com.tencent.mobileqq.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class JumpQqPimSecureUtil
{
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramContext != null)
    {
      Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage("com.tencent.qqpimsecure");
      if (localIntent != null)
      {
        Bundle localBundle = new Bundle();
        if ((paramString != null) && (paramString.length() > 0)) {
          localBundle.putString("platform_Id", paramString);
        }
        if (paramInt > 0) {
          localBundle.putInt("dest_view", paramInt);
        }
        localIntent.putExtras(localBundle);
        if (paramInt == 9502721) {
          localIntent.putExtra("big_brother_source_key", "biz_src_tmm");
        } else {
          localIntent.putExtra("big_brother_source_key", "biz_src_safe");
        }
        localIntent.setFlags(402653184);
        paramContext.startActivity(localIntent);
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.qqpimsecure", 64).signatures;
      Object localObject = MessageDigest.getInstance("MD5");
      if ((paramContext != null) && (paramContext.length > 0)) {
        ((MessageDigest)localObject).update(paramContext[0].toByteArray());
      }
      paramContext = ((MessageDigest)localObject).digest();
      localObject = new char[16];
      localObject[0] = 48;
      localObject[1] = 49;
      localObject[2] = 50;
      localObject[3] = 51;
      localObject[4] = 52;
      localObject[5] = 53;
      localObject[6] = 54;
      localObject[7] = 55;
      localObject[8] = 56;
      localObject[9] = 57;
      localObject[10] = 65;
      localObject[11] = 66;
      localObject[12] = 67;
      localObject[13] = 68;
      localObject[14] = 69;
      localObject[15] = 70;
      StringBuilder localStringBuilder = new StringBuilder(paramContext.length * 2);
      int i = 0;
      while (i < paramContext.length)
      {
        localStringBuilder.append(localObject[((paramContext[i] & 0xF0) >>> 4)]);
        localStringBuilder.append(localObject[(paramContext[i] & 0xF)]);
        i += 1;
      }
      if (!"00B1208638DE0FCD3E920886D658DAF6".equalsIgnoreCase(localStringBuilder.toString()))
      {
        boolean bool = "7CC749CFC0FB5677E6ABA342EDBDBA5A".equalsIgnoreCase(localStringBuilder.toString());
        if (!bool) {}
      }
      else
      {
        return true;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    Object localObject1;
    if (paramContext != null)
    {
      localObject1 = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          if ("com.tencent.qqpimsecure".equalsIgnoreCase(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next()).processName))
          {
            bool1 = true;
            break label64;
          }
        }
      }
    }
    boolean bool1 = false;
    label64:
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (Build.VERSION.SDK_INT >= 21) {
        try
        {
          localObject1 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[] { "ps" }).getInputStream()));
          do
          {
            do
            {
              localObject2 = ((BufferedReader)localObject1).readLine();
              bool2 = bool1;
              if (localObject2 == null) {
                break;
              }
            } while (((String)localObject2).indexOf("com.tencent.qqpimsecure") == -1);
            Object localObject2 = new StringTokenizer((String)localObject2, " ");
            ((StringTokenizer)localObject2).nextToken();
            ((StringTokenizer)localObject2).nextToken();
            ((StringTokenizer)localObject2).nextToken();
            ((StringTokenizer)localObject2).nextToken();
            ((StringTokenizer)localObject2).nextToken();
            ((StringTokenizer)localObject2).nextToken();
            ((StringTokenizer)localObject2).nextToken();
            ((StringTokenizer)localObject2).nextToken();
            bool2 = TextUtils.equals(((StringTokenizer)localObject2).nextToken().trim(), "com.tencent.qqpimsecure");
          } while (!bool2);
          bool2 = true;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          bool2 = bool1;
        }
      }
    }
    if ((!bool2) && (Build.VERSION.SDK_INT > 23) && (paramContext != null))
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647);
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)paramContext.next();
          if ((localRunningServiceInfo != null) && (localRunningServiceInfo.service != null) && (localRunningServiceInfo.process != null) && (localRunningServiceInfo.process.contains("com.tencent.qqpimsecure"))) {
            return true;
          }
        }
      }
    }
    return bool2;
  }
  
  public static boolean c(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.qqpimsecure", 0);
      if (paramContext != null)
      {
        paramContext = paramContext.versionName;
        if (paramContext != null)
        {
          boolean bool = paramContext.contains("mini");
          if (bool) {
            return true;
          }
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean d(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.qqpimsecure", 0);
      if (paramContext != null)
      {
        paramContext = paramContext.versionName;
        if (paramContext != null)
        {
          boolean bool = paramContext.contains("minipay");
          if (bool) {
            return true;
          }
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean e(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.qqpimsecure", 0);
      if (paramContext != null)
      {
        int i = paramContext.versionCode;
        if (i >= 198) {
          return true;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean f(Context paramContext)
  {
    return ((a(paramContext)) && (e(paramContext)) && (!c(paramContext))) || (d(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpQqPimSecureUtil
 * JD-Core Version:    0.7.0.1
 */