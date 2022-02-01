package com.tencent.mobileqq.splashad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.Set;

public class SplashADUtil
{
  public static long a;
  private static long b;
  private static boolean c;
  
  public static long a(Context paramContext)
  {
    if (b == 0L) {
      b = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("splash_ad_uin_long", 0L);
    }
    return b;
  }
  
  private static void a() {}
  
  public static void a(Context paramContext, long paramLong)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("splash_ad_uin_long", paramLong).apply();
    b = paramLong;
  }
  
  public static boolean a(Activity paramActivity)
  {
    Object localObject = paramActivity.getIntent();
    paramActivity = ((Intent)localObject).getCategories();
    localObject = ((Intent)localObject).getAction();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("categories ");
    localStringBuilder.append(paramActivity);
    localStringBuilder.append(" action ");
    localStringBuilder.append((String)localObject);
    QLog.i("SplashAD", 1, localStringBuilder.toString());
    boolean bool1;
    if ((paramActivity != null) && (paramActivity.contains("android.intent.category.LAUNCHER")) && (localObject != null) && (((String)localObject).equals("android.intent.action.MAIN"))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (paramActivity == null)
      {
        bool2 = bool1;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          bool2 = true;
        }
      }
    }
    paramActivity = new StringBuilder();
    paramActivity.append("fromLaucher ");
    paramActivity.append(bool2);
    QLog.e("SplashAD", 1, paramActivity.toString());
    return bool2;
  }
  
  public static void b(Context paramContext)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().remove("splash_ad_uin_long").apply();
    b = 0L;
  }
  
  public static int c(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return paramContext.getDefaultDisplay().getWidth();
  }
  
  public static void d(Context paramContext)
  {
    if (!c)
    {
      TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      a();
      c = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.splashad.SplashADUtil
 * JD-Core Version:    0.7.0.1
 */