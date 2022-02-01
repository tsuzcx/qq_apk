package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.smtt.sdk.WebView;

public class k
{
  private static String a;
  private static String b = "GA";
  private static String c = "GE";
  private static String d = "9422";
  private static String e = "0";
  private static String f = "";
  private static boolean g = false;
  private static boolean h = false;
  private static boolean i = false;
  
  public static String a(Context paramContext)
  {
    if (!TextUtils.isEmpty(a)) {
      return a;
    }
    a = a(paramContext, String.valueOf(WebView.getTbsSDKVersion(paramContext)), "0", b, c, d, e, f, g);
    return a;
  }
  
  private static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(b(paramContext));
    ((StringBuilder)localObject).append("*");
    ((StringBuilder)localObject).append(c(paramContext));
    String str2 = ((StringBuilder)localObject).toString();
    try
    {
      localObject = paramContext.getApplicationContext().getApplicationInfo();
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(((ApplicationInfo)localObject).packageName, 0);
      localObject = ((ApplicationInfo)localObject).packageName;
      try
      {
        if (!TextUtils.isEmpty(paramString7)) {
          break label137;
        }
        paramString7 = localPackageInfo.versionName;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        paramString7 = (String)localObject;
      }
      localNameNotFoundException2.printStackTrace();
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException2)
    {
      paramString7 = "";
    }
    String str1 = "";
    localObject = paramString7;
    paramString7 = str1;
    label137:
    String str3 = a((String)localObject);
    boolean bool = "QB".equals(str3);
    str1 = "PAD";
    if (bool ? !paramBoolean : !e(paramContext)) {
      str1 = "PHONE";
    }
    localStringBuilder.append("QV");
    localStringBuilder.append("=");
    localStringBuilder.append("3");
    a(localStringBuilder, "PL", "ADR");
    a(localStringBuilder, "PR", str3);
    a(localStringBuilder, "PP", (String)localObject);
    a(localStringBuilder, "PPVN", paramString7);
    if (!TextUtils.isEmpty(paramString1)) {
      a(localStringBuilder, "TBSVC", paramString1);
    }
    a(localStringBuilder, "CO", "SYS");
    if (!TextUtils.isEmpty(paramString2)) {
      a(localStringBuilder, "COVC", paramString2);
    }
    a(localStringBuilder, "PB", paramString4);
    a(localStringBuilder, "VE", paramString3);
    a(localStringBuilder, "DE", str1);
    if (TextUtils.isEmpty(paramString6)) {
      paramString6 = "0";
    }
    a(localStringBuilder, "CHID", paramString6);
    a(localStringBuilder, "LCID", paramString5);
    paramContext = d(paramContext);
    label411:
    try
    {
      paramString1 = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = paramString1;
    }
    catch (Exception paramString1)
    {
      label365:
      break label365;
    }
    if (!TextUtils.isEmpty(paramContext)) {
      a(localStringBuilder, "MO", paramContext);
    }
    a(localStringBuilder, "RL", str2);
    paramContext = Build.VERSION.RELEASE;
    try
    {
      paramString1 = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = paramString1;
    }
    catch (Exception paramString1)
    {
      break label411;
    }
    if (!TextUtils.isEmpty(paramContext)) {
      a(localStringBuilder, "OS", paramContext);
    }
    paramContext = new StringBuilder();
    paramContext.append(Build.VERSION.SDK_INT);
    paramContext.append("");
    a(localStringBuilder, "API", paramContext.toString());
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString)
  {
    if ("com.tencent.mm".equals(paramString)) {
      return "WX";
    }
    if ("com.tencent.mobileqq".equals(paramString)) {
      return "QQ";
    }
    if ("com.qzone".equals(paramString)) {
      return "QZ";
    }
    if ("com.tencent.mtt".equals(paramString)) {
      return "QB";
    }
    return "TRD";
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append("&");
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append("=");
    paramStringBuilder.append(paramString2);
  }
  
  private static int b(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null) {
      return paramContext.getWidth();
    }
    return -1;
  }
  
  private static int c(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null) {
      return paramContext.getHeight();
    }
    return -1;
  }
  
  private static String d(Context paramContext)
  {
    paramContext = q.d(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ");
    localStringBuilder.append(paramContext.replaceAll("[ |\\/|\\_|\\&|\\|]", ""));
    localStringBuilder.append(" ");
    return localStringBuilder.toString();
  }
  
  private static boolean e(Context paramContext)
  {
    if (h) {
      return i;
    }
    for (;;)
    {
      try
      {
        if (Math.min(b(paramContext), c(paramContext)) * 160 / f(paramContext) >= 700)
        {
          bool = true;
          i = bool;
          h = true;
          return i;
        }
      }
      catch (Throwable paramContext)
      {
        return false;
      }
      boolean bool = false;
    }
  }
  
  private static int f(Context paramContext)
  {
    Object localObject = (WindowManager)paramContext.getSystemService("window");
    paramContext = new DisplayMetrics();
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    if (localObject != null)
    {
      ((Display)localObject).getMetrics(paramContext);
      return paramContext.densityDpi;
    }
    return 160;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.utils.k
 * JD-Core Version:    0.7.0.1
 */