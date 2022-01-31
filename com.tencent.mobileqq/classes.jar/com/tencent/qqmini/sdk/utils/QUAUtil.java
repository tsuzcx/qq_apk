package com.tencent.qqmini.sdk.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import bgou;
import bgxl;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;

public class QUAUtil
{
  private static final String TAG = "QUAUtil";
  private static volatile String mWebViewUA = "";
  private static String[] sLoginTypeList = { "anonymous", "wechat", "qq", "phone", "other" };
  private static volatile String ua;
  
  public static String getApplicationName(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = (String)localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0));
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return "";
  }
  
  public static String getLoginType()
  {
    int i = bgxl.a().a();
    return sLoginTypeList[i];
  }
  
  public static String getPlatformQUA()
  {
    String str = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformQUA();
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return getQUA();
  }
  
  public static String getPlatformVersionString()
  {
    String str = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion();
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return "1.3.1";
  }
  
  public static String getQUA()
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    return "V1_AND_MINISDK_1.3.1_0_RELEASE_B";
  }
  
  public static String getSimpleDeviceInfo(Context paramContext)
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    Object localObject = (WindowManager)paramContext.getSystemService("window");
    paramContext = new DisplayMetrics();
    ((WindowManager)localObject).getDefaultDisplay().getMetrics(paramContext);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("m=").append(Build.MODEL).append('&');
    ((StringBuilder)localObject).append("o=").append(Build.VERSION.RELEASE).append('&');
    ((StringBuilder)localObject).append("a=").append(Build.VERSION.SDK_INT).append('&');
    ((StringBuilder)localObject).append("p=").append(paramContext.widthPixels).append('*').append(paramContext.heightPixels).append('&');
    ((StringBuilder)localObject).append("f=").append(Build.MANUFACTURER).append('&');
    ((StringBuilder)localObject).append("mm=").append(bgou.b() / 1048576L).append('&');
    ((StringBuilder)localObject).append("cf=").append(bgou.c()).append('&');
    ((StringBuilder)localObject).append("cc=").append(bgou.b()).append('&');
    ((StringBuilder)localObject).append("qqversion=").append(localMiniAppProxy.getAppVersion());
    return ((StringBuilder)localObject).toString();
  }
  
  public static String getSystemUA()
  {
    int i = 0;
    if (ua != null) {
      return ua;
    }
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        boolean bool = VersionUtil.isKITKAT();
        char c;
        String str2;
        if (bool)
        {
          try
          {
            String str1 = WebSettings.getDefaultUserAgent(AppLoaderFactory.g().getMiniAppEnv().getContext());
            localStringBuilder = new StringBuilder();
            int j = str1.length();
            if (i >= j) {
              break label144;
            }
            c = str1.charAt(i);
            if ((c > '\037') && (c < '')) {
              continue;
            }
            localStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
          }
          catch (Exception localException)
          {
            str2 = System.getProperty("http.agent");
            continue;
          }
        }
        else
        {
          str2 = System.getProperty("http.agent");
          continue;
        }
        localStringBuilder.append(c);
      }
      catch (Throwable localThrowable)
      {
        ua = "AndroidQQ";
      }
      for (;;)
      {
        return ua;
        label144:
        ua = localStringBuilder.toString();
      }
      i += 1;
    }
  }
  
  public static String getWebViewUA()
  {
    if (TextUtils.isEmpty(mWebViewUA)) {
      mWebViewUA = getSystemUA() + " QQ/" + getPlatformVersionString() + " " + getPlatformQUA() + " MiniAppEnable miniProgram miniprogramhtmlwebview";
    }
    QMLog.d("QUAUtil", "getWebViewUA done in " + Thread.currentThread().getName());
    return mWebViewUA;
  }
  
  public static boolean isDemoApp()
  {
    return ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName().equalsIgnoreCase("demo");
  }
  
  public static boolean isQQApp()
  {
    return (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName().equalsIgnoreCase("qq")) || (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName().equalsIgnoreCase("qi")) || (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName().equalsIgnoreCase("ssq"));
  }
  
  public static boolean isQQMainApp()
  {
    return ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName().equalsIgnoreCase("qq");
  }
  
  public static boolean isRdmBuild()
  {
    return getPlatformQUA().toLowerCase().contains("rdm");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.QUAUtil
 * JD-Core Version:    0.7.0.1
 */