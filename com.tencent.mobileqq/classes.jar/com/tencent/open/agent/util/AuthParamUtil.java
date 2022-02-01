package com.tencent.open.agent.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class AuthParamUtil
{
  public static Bundle a(Activity paramActivity, String paramString)
  {
    if (paramActivity == null)
    {
      paramActivity = new StringBuilder();
      paramActivity.append("getBundleExtra activity is null, key=");
      paramActivity.append(paramString);
      SSOLog.b("AuthParamUtil", paramActivity.toString());
      return null;
    }
    return a(paramActivity.getIntent(), paramString);
  }
  
  public static Bundle a(Intent paramIntent, String paramString)
  {
    return a(paramIntent, paramString, null);
  }
  
  public static Bundle a(Intent paramIntent, String paramString, Bundle paramBundle)
  {
    if (paramIntent == null)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("getBundleExtra intent is null, key=");
      paramIntent.append(paramString);
      SSOLog.b("AuthParamUtil", new Object[] { paramIntent.toString() });
      return paramBundle;
    }
    try
    {
      paramString = paramIntent.getBundleExtra(paramString);
      paramIntent = paramString;
      if (paramString == null) {
        paramIntent = paramBundle;
      }
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      SSOLog.c("AuthParamUtil", "Exception", paramIntent);
    }
    return paramBundle;
  }
  
  public static String a(Activity paramActivity)
  {
    return a(a(paramActivity, "key_params"), "packagename");
  }
  
  public static String a(Activity paramActivity, String paramString)
  {
    if (paramActivity == null)
    {
      paramActivity = new StringBuilder();
      paramActivity.append("getStringExtra activity is null, key=");
      paramActivity.append(paramString);
      SSOLog.b("AuthParamUtil", paramActivity.toString());
      return null;
    }
    return a(paramActivity.getIntent(), paramString);
  }
  
  public static String a(Intent paramIntent, String paramString)
  {
    if (paramIntent == null)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("getStringExtra intent is null, key=");
      paramIntent.append(paramString);
      SSOLog.b("AuthParamUtil", new Object[] { paramIntent.toString() });
      return null;
    }
    try
    {
      paramIntent = paramIntent.getStringExtra(paramString);
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      SSOLog.c("AuthParamUtil", "Exception", paramIntent);
    }
    return null;
  }
  
  public static String a(Bundle paramBundle)
  {
    return a(paramBundle, "packagename");
  }
  
  public static String a(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("getString bundle is null, key=");
      paramBundle.append(paramString);
      SSOLog.b("AuthParamUtil", paramBundle.toString());
      return null;
    }
    try
    {
      paramBundle = paramBundle.getString(paramString);
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      SSOLog.c("AuthParamUtil", "Exception", paramBundle);
    }
    return null;
  }
  
  public static String a(Bundle paramBundle, String paramString1, String paramString2)
  {
    paramString1 = a(paramBundle, paramString1);
    paramBundle = paramString1;
    if (paramString1 == null) {
      paramBundle = paramString2;
    }
    return paramBundle;
  }
  
  public static boolean a(Intent paramIntent)
  {
    return a(paramIntent, "authority_start_qq_login", false);
  }
  
  public static boolean a(Intent paramIntent, String paramString, boolean paramBoolean)
  {
    if (paramIntent == null)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("getBooleanExtra intent is null, key=");
      paramIntent.append(paramString);
      SSOLog.b("AuthParamUtil", new Object[] { paramIntent.toString() });
      return paramBoolean;
    }
    try
    {
      boolean bool = paramIntent.getBooleanExtra(paramString, paramBoolean);
      return bool;
    }
    catch (Exception paramIntent)
    {
      SSOLog.c("AuthParamUtil", "Exception", paramIntent);
    }
    return paramBoolean;
  }
  
  public static boolean a(Bundle paramBundle)
  {
    return a(paramBundle, "authority_start_qq_login", false);
  }
  
  public static boolean a(Bundle paramBundle, String paramString, boolean paramBoolean)
  {
    if (paramBundle == null)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("getBoolean bundle is null, key=");
      paramBundle.append(paramString);
      SSOLog.b("AuthParamUtil", paramBundle.toString());
      return paramBoolean;
    }
    return paramBundle.getBoolean(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.util.AuthParamUtil
 * JD-Core Version:    0.7.0.1
 */