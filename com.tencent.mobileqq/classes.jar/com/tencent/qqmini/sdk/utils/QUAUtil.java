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
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DeviceUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.VersionUtil;
import com.tencent.qqmini.sdk.manager.LoginManager;
import java.net.URLEncoder;

@MiniKeep
public class QUAUtil
{
  private static final String TAG = "QUAUtil";
  private static volatile String mWebViewUA = "";
  private static volatile String requestUA;
  private static String[] sLoginTypeList = { "anonymous", "wechat", "qq", "qqwtlogin", "other" };
  private static volatile String systemUA;
  
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
    int i = LoginManager.getInstance().getLoginType();
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
    return "1.7.0";
  }
  
  public static String getQUA()
  {
    return "V1_AND_MINISDK_1.7.0_0_RELEASE_B";
  }
  
  public static String getRequestUA()
  {
    if (requestUA == null) {
      requestUA = getSystemUA() + " QQ/" + getPlatformVersionString() + " " + getPlatformQUA() + " QQ/MiniApp";
    }
    return requestUA;
  }
  
  public static String getSimpleDeviceInfo(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
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
    ((StringBuilder)localObject).append("mm=").append(DeviceUtil.getSystemTotalMemory() / 1048576L).append('&');
    ((StringBuilder)localObject).append("cf=").append(DeviceUtil.getCpuFrequency()).append('&');
    ((StringBuilder)localObject).append("cc=").append(DeviceUtil.getCpuNumber()).append('&');
    ((StringBuilder)localObject).append("qqversion=").append(localMiniAppProxy.getAppVersion());
    return ((StringBuilder)localObject).toString();
  }
  
  public static String getSystemUA()
  {
    if (systemUA != null) {
      return systemUA;
    }
    for (;;)
    {
      try
      {
        boolean bool = VersionUtil.isKITKAT();
        if (!bool) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        String str1;
        String str2;
        systemUA = "AndroidQQ";
        continue;
      }
      try
      {
        str1 = WebSettings.getDefaultUserAgent(AppLoaderFactory.g().getContext());
        systemUA = URLEncoder.encode(str1, "UTF-8");
        return systemUA;
      }
      catch (Exception localException)
      {
        str2 = System.getProperty("http.agent");
        continue;
      }
      str2 = System.getProperty("http.agent");
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
  
  public static boolean isAlienApp()
  {
    return ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformId().startsWith("2");
  }
  
  public static boolean isDemoApp()
  {
    return "demo".equals(((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName());
  }
  
  public static boolean isMicroApp()
  {
    return "ma".equals(((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName());
  }
  
  public static boolean isQQApp()
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    return ("qq".equals(localMiniAppProxy.getAppName())) || ("qi".equals(localMiniAppProxy.getAppName())) || ("ssq".equals(localMiniAppProxy.getAppName())) || ("tim".equals(localMiniAppProxy.getAppName()));
  }
  
  public static boolean isQQBrowseApp()
  {
    return "qb".equals(((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName());
  }
  
  public static boolean isQQMainApp()
  {
    return "qq".equals(((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName());
  }
  
  public static boolean isQQSpeedApp()
  {
    return "ssq".equals(((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName());
  }
  
  public static boolean isRdmBuild()
  {
    return getPlatformQUA().toLowerCase().contains("rdm");
  }
  
  public static boolean isTimApp()
  {
    return "tim".equals(((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.QUAUtil
 * JD-Core Version:    0.7.0.1
 */