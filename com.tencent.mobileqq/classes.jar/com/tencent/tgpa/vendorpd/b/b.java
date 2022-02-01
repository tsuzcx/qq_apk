package com.tencent.tgpa.vendorpd.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class b
{
  public static int a(Context paramContext, String paramString)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label15:
      break label15;
    }
    f.a("can not find app: %s , get version code failed.", new Object[] { paramString });
    return 0;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(paramString, 0).versionName;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label18:
      break label18;
    }
    f.a("can not find app: %s , get version name failed.", new Object[] { paramString });
    paramContext = null;
    paramString = paramContext;
    if (paramContext == null) {
      paramString = "0";
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.b.b
 * JD-Core Version:    0.7.0.1
 */