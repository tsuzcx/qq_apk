package com.tencent.tbs.one.impl.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class d
{
  private static String a = "";
  private static String b = "";
  private static String c = "";
  private static String d = "";
  private static String e;
  private static String f;
  private static boolean g = false;
  
  public static String a()
  {
    return a;
  }
  
  public static String a(long paramLong)
  {
    return String.format(Locale.getDefault(), "%d(%s)", new Object[] { Long.valueOf(paramLong), new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(paramLong)) });
  }
  
  public static String a(Context paramContext)
  {
    if ((TextUtils.isEmpty(c)) && (paramContext.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0)) {}
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (Build.VERSION.SDK_INT >= 26) {
        c = paramContext.getImei();
      } else {
        c = paramContext.getDeviceId();
      }
      d = paramContext.getSubscriberId();
    }
    catch (Throwable paramContext)
    {
      label66:
      break label66;
    }
    return c;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
      int j = paramArrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfByte[i] & 0xFF;
        if (k < 16) {
          localStringBuilder.append("0");
        }
        localStringBuilder.append(Long.toString(k, 16));
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static void a(String paramString)
  {
    a = paramString;
  }
  
  public static void a(boolean paramBoolean)
  {
    g = paramBoolean;
  }
  
  public static boolean a(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if ((paramObject instanceof Boolean)) {
      return ((Boolean)paramObject).booleanValue();
    }
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).intValue() != 0;
    }
    if ((paramObject instanceof String)) {
      return Boolean.parseBoolean((String)paramObject);
    }
    return true;
  }
  
  public static String b()
  {
    return b;
  }
  
  public static String b(Context paramContext)
  {
    if (TextUtils.isEmpty(e)) {
      e = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    }
    return e;
  }
  
  public static void b(String paramString)
  {
    b = paramString;
  }
  
  public static String c()
  {
    return Build.CPU_ABI;
  }
  
  public static String c(Context paramContext)
  {
    if (TextUtils.isEmpty(b)) {}
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0).versionName;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label29:
      break label29;
    }
    return "";
    return b;
  }
  
  public static String d()
  {
    if (!TextUtils.isEmpty(f)) {
      return f;
    }
    Locale localLocale = Locale.getDefault();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = Build.VERSION.RELEASE;
    try
    {
      localObject2 = new String(((String)localObject1).getBytes("UTF-8"), "ISO8859-1");
      localObject1 = localObject2;
    }
    catch (Exception localException1)
    {
      Object localObject2;
      label47:
      break label47;
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "1.0";
    }
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("; ");
    localObject1 = localLocale.getLanguage();
    if (localObject1 != null)
    {
      localStringBuilder.append(((String)localObject1).toLowerCase());
      localObject1 = localLocale.getCountry();
      if (localObject1 != null)
      {
        localStringBuilder.append("-");
        localStringBuilder.append(((String)localObject1).toLowerCase());
      }
    }
    else
    {
      localStringBuilder.append("en");
    }
    if ("REL".equals(Build.VERSION.CODENAME)) {
      localObject1 = Build.MODEL;
    }
    try
    {
      localObject2 = new String(((String)localObject1).getBytes("UTF-8"), "ISO8859-1");
      localObject1 = localObject2;
    }
    catch (Exception localException2)
    {
      label158:
      break label158;
    }
    localStringBuilder.append("; ");
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "";
    }
    localStringBuilder.append((String)localObject2);
    if (Build.ID == null) {
      localObject1 = null;
    } else {
      localObject1 = Build.ID.replaceAll("[一-龥]", "");
    }
    localStringBuilder.append(" Build/");
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "00";
    }
    localStringBuilder.append((String)localObject2);
    localObject1 = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", new Object[] { localStringBuilder });
    f = (String)localObject1;
    return localObject1;
  }
  
  public static List<ActivityManager.RunningAppProcessInfo> d(Context paramContext)
  {
    if (g) {
      return null;
    }
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null) {
      return null;
    }
    return paramContext.getRunningAppProcesses();
  }
  
  public static boolean e()
  {
    return g;
  }
  
  public static boolean e(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected()) && (paramContext.getType() == 1)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.d
 * JD-Core Version:    0.7.0.1
 */