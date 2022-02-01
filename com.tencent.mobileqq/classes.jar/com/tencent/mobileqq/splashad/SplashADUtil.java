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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.Set;

public class SplashADUtil
{
  public static long a;
  private static boolean a;
  private static long b = 0L;
  
  static
  {
    jdField_a_of_type_Long = 0L;
  }
  
  public static int a(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return paramContext.getDefaultDisplay().getWidth();
  }
  
  public static long a(Context paramContext)
  {
    if (b == 0L) {
      b = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("splash_ad_uin_long", 0L);
    }
    return b;
  }
  
  private static void a() {}
  
  public static void a(int paramInt, String paramString)
  {
    ThreadManager.excute(new SplashADUtil.1(paramInt, paramString), 128, null, false);
  }
  
  public static void a(Context paramContext)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().remove("splash_ad_uin_long").apply();
    b = 0L;
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("splash_ad_uin_long", paramLong).apply();
    b = paramLong;
  }
  
  public static boolean a(Activity paramActivity)
  {
    boolean bool2 = false;
    Object localObject = paramActivity.getIntent();
    paramActivity = ((Intent)localObject).getCategories();
    localObject = ((Intent)localObject).getAction();
    QLog.i("SplashAD", 1, "categories " + paramActivity + " action " + (String)localObject);
    boolean bool1 = bool2;
    if (paramActivity != null)
    {
      bool1 = bool2;
      if (paramActivity.contains("android.intent.category.LAUNCHER"))
      {
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (((String)localObject).equals("android.intent.action.MAIN")) {
            bool1 = true;
          }
        }
      }
    }
    bool2 = bool1;
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
    QLog.e("SplashAD", 1, "fromLaucher " + bool2);
    return bool2;
  }
  
  public static void b(Context paramContext)
  {
    if (!jdField_a_of_type_Boolean)
    {
      TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      a();
      jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.splashad.SplashADUtil
 * JD-Core Version:    0.7.0.1
 */