package com.tencent.qmsp.sdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.qmsp.sdk.app.QmspSDK;
import com.tencent.qmsp.sdk.c.b;
import com.tencent.qmsp.sdk.f.e;
import java.io.File;
import java.security.MessageDigest;

public class c
{
  public static int a()
  {
    try
    {
      String str = QmspSDK.getContext().getPackageManager().getPackageInfo(QmspSDK.getContext().getPackageName(), 0).packageName;
      ApplicationInfo localApplicationInfo = QmspSDK.getContext().getApplicationInfo();
      if (localApplicationInfo.packageName.equals(str))
      {
        int i = Integer.valueOf((int)new File(localApplicationInfo.publicSourceDir).length()).intValue();
        return i;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public static String a(int paramInt)
  {
    return String.format("%d.%d.%d", new Object[] { Integer.valueOf(paramInt >> 24), Integer.valueOf((0xFF0000 & paramInt) >> 16), Integer.valueOf((paramInt & 0xFF00) >> 8) });
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      paramString = e.a(MessageDigest.getInstance("MD5").digest(paramString.getBytes()));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String b()
  {
    try
    {
      String str = QmspSDK.getContext().getPackageName();
      boolean bool = TextUtils.isEmpty(str);
      if (!bool) {
        return str;
      }
    }
    catch (Exception localException)
    {
      label18:
      break label18;
    }
    return null;
  }
  
  public static String c()
  {
    Object localObject = QmspSDK.getContext().getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(QmspSDK.getContext().getPackageName(), 0);
      if (TextUtils.isEmpty(((PackageInfo)localObject).versionName)) {
        return null;
      }
      localObject = ((PackageInfo)localObject).versionName;
      localObject = ((String)localObject).replaceAll("[^0-9.]", "");
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static String d()
  {
    return a(512);
  }
  
  public static String e()
  {
    try
    {
      String str = b.c;
      return str;
    }
    finally
    {
      label6:
      break label6;
    }
    return "";
  }
  
  public static String f()
  {
    Object localObject1 = QmspSDK.getContext().getPackageManager();
    try
    {
      localObject1 = ((PackageManager)localObject1).getPackageInfo(QmspSDK.getContext().getPackageName(), 64);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
      localObject2 = null;
    }
    Object localObject2 = ((PackageInfo)localObject2).signatures;
    if (localObject2.length <= 0) {
      return "";
    }
    localObject2 = localObject2[0];
    try
    {
      localObject2 = e.a(MessageDigest.getInstance("MD5").digest(((Signature)localObject2).toByteArray()));
      return localObject2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  public static int g()
  {
    Object localObject = c();
    try
    {
      localObject = ((String)localObject).split("\\.");
      int i;
      if (localObject.length == 2) {
        i = Integer.parseInt(localObject[0]) << 16 | 0x0;
      }
      for (localObject = localObject[1];; localObject = localObject[2])
      {
        return Integer.parseInt((String)localObject) << 8 | i;
        if (localObject.length != 3) {
          break;
        }
        i = Integer.parseInt(localObject[0]) << 24 | 0x0 | Integer.parseInt(localObject[1]) << 16;
      }
      return 0;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static boolean h()
  {
    String str = System.getProperty("os.arch");
    return (str != null) && (str.contains("64"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.a.c
 * JD-Core Version:    0.7.0.1
 */