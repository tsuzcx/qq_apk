package com.tencent.timi.game.scheme.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.bigbrother.TeleScreen;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.ThreadPool;
import java.net.URLDecoder;
import java.util.List;

public class SchemeUtil
{
  public static String a = "SchemeUtil";
  public static String b = "biz_src_wzgamelive_open";
  
  private static void a(Context paramContext, Intent paramIntent, String paramString, SchemeUtil.LaunchSchemeCallback paramLaunchSchemeCallback)
  {
    if ((paramIntent == null) && ((TextUtils.isEmpty(paramString)) || (!b(paramContext, paramString))))
    {
      Toast.makeText(paramContext, "应用程序未安装", 0).show();
      return;
    }
    if (!"oppo".equalsIgnoreCase(Build.MANUFACTURER))
    {
      if (paramIntent != null) {}
      try
      {
        paramContext.startActivity(paramIntent);
        return;
      }
      catch (Exception paramContext)
      {
        if (paramLaunchSchemeCallback == null) {
          return;
        }
      }
      a(paramContext, paramString);
      return;
      paramLaunchSchemeCallback.a(paramContext);
    }
    else
    {
      ThreadPool.a(new SchemeUtil.3(paramIntent, paramContext, paramString, paramLaunchSchemeCallback), 500L);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchApp pkgName:");
    localStringBuilder.append(paramString);
    Logger.a(str, localStringBuilder.toString());
    if ((paramContext != null) && (paramString != null))
    {
      paramContext = paramContext.getApplicationContext();
      paramString = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
      if (paramString != null)
      {
        paramString.setPackage(paramContext.getPackageName());
        paramString.setFlags(268435456);
        paramContext.startActivity(paramString);
        return;
      }
      Logger.c(a, "launchApp err intent == null");
      return;
    }
    Logger.c(a, "launchApp context = null || pkgName = null");
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("launchCommonScheme ");
    ((StringBuilder)localObject2).append(paramContext);
    ((StringBuilder)localObject2).append(", fromSchemeActivity - ");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append(", qqSrcBizId - ");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append("\n");
    ((StringBuilder)localObject2).append(paramString1);
    Logger.a((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      localObject1 = b;
    }
    localObject2 = null;
    try
    {
      paramString2 = Uri.parse(paramString1);
    }
    catch (Exception paramString2)
    {
      Logger.a(a, "launchCommonScheme parseUri exception ", paramString2);
      paramString2 = null;
    }
    if (paramString2 != null) {
      localObject2 = paramString2.getScheme();
    }
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      Toast.makeText(paramContext, "启动参数错误", 0).show();
      Logger.c(a, "launchCommonScheme schemeName is null");
      return false;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW", paramString2);
    List localList = paramContext.getPackageManager().queryIntentActivities(localIntent, 131072);
    if ((localList != null) && (localList.size() > 0))
    {
      paramString2 = paramString2.getQuery();
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = b(paramString2);
        if (paramString2 != null) {
          localIntent.putExtras(paramString2);
        }
        localObject2 = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("launchCommonScheme  extraBundles - ");
        localStringBuilder.append(paramString2);
        Logger.a((String)localObject2, localStringBuilder.toString());
      }
      paramString2 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("launchCommonScheme activityList.size = ");
      ((StringBuilder)localObject2).append(localList.size());
      ((StringBuilder)localObject2).append(", activityInfo1 = ");
      ((StringBuilder)localObject2).append(((ResolveInfo)localList.get(0)).activityInfo);
      Logger.a(paramString2, ((StringBuilder)localObject2).toString());
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramString1 = new SchemeUtil.1(paramBoolean, paramString1, (String)localObject1, paramContext);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localIntent.putExtra("big_brother_source_key", (String)localObject1);
      }
      int i = TeleScreen.a().a(new SchemeUtil.2());
      paramString2 = a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("launchCommonScheme callbackId= ");
      ((StringBuilder)localObject1).append(i);
      Logger.a(paramString2, ((StringBuilder)localObject1).toString());
      localIntent.putExtra("key_callback_id", i);
      a(paramContext, localIntent, "", paramString1);
      return true;
    }
    paramString1 = a;
    paramString2 = new StringBuilder();
    paramString2.append("launchCommonScheme IntentActivity not found - ");
    paramString2.append((String)localObject2);
    Logger.c(paramString1, paramString2.toString());
    Toast.makeText(paramContext, "启动应用程序失败", 0).show();
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        localObject = Env.a().getPackageManager().queryIntentActivities((Intent)localObject, 131072);
        if (localObject != null)
        {
          int i = ((List)localObject).size();
          if (i > 0) {
            return true;
          }
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isAppInstalledByScheme error ");
        localStringBuilder.append(paramString);
        Logger.a("SchemeUtil", localStringBuilder.toString(), localException);
      }
    }
    return false;
  }
  
  private static Bundle b(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramString != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (!paramString.isEmpty())
        {
          paramString = paramString.split("[&]");
          int j = paramString.length;
          i = 0;
          if (i < j)
          {
            String[] arrayOfString = paramString[i].split("[=]");
            if (arrayOfString.length > 1)
            {
              localBundle.putString(URLDecoder.decode(arrayOfString[0], "UTF-8"), arrayOfString[1]);
              break label116;
            }
            localBundle.putString(arrayOfString[0], "");
            break label116;
          }
        }
        else
        {
          Logger.c(a, "url has no params");
          return localBundle;
        }
      }
      catch (Exception paramString)
      {
        Logger.c(a, paramString.toString());
      }
      return localBundle;
      label116:
      i += 1;
    }
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramContext.getPackageManager().getPackageInfo(paramString, 1024);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Logger.a(a, "isAppIntalled exception", paramContext);
    }
    return false;
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("http://");
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = paramString;
      }
      Object localObject = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject));
      if (!(paramContext instanceof Activity)) {
        ((Intent)localObject).addFlags(268435456);
      }
      ((Intent)localObject).putExtra("big_brother_source_key", b);
      try
      {
        paramContext.startActivity((Intent)localObject);
        return true;
      }
      catch (Exception paramContext)
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("gotoSysBrowser error");
        localStringBuilder.append(paramString);
        Logger.a((String)localObject, localStringBuilder.toString(), paramContext);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.scheme.tools.SchemeUtil
 * JD-Core Version:    0.7.0.1
 */