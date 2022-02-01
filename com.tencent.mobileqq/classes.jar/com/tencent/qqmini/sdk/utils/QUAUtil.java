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
  private static volatile String sSimpleDeviceInfo;
  private static volatile String systemUA;
  
  public static String getApplicationName(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = (String)localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0));
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label24:
      break label24;
    }
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
    return "1.15.0";
  }
  
  public static String getQUA()
  {
    return "V1_AND_MINISDK_1.15.0_0_RELEASE_B";
  }
  
  public static String getRequestUA()
  {
    if (requestUA == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getSystemUA());
      localStringBuilder.append(" QQ/");
      localStringBuilder.append(getPlatformVersionString());
      localStringBuilder.append(" ");
      localStringBuilder.append(getPlatformQUA());
      localStringBuilder.append(" QQ/MiniApp");
      requestUA = localStringBuilder.toString();
    }
    return requestUA;
  }
  
  public static String getSimpleDeviceInfo(Context paramContext)
  {
    if (!TextUtils.isEmpty(sSimpleDeviceInfo)) {
      return sSimpleDeviceInfo;
    }
    if (paramContext == null) {
      return "";
    }
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    Object localObject = (WindowManager)paramContext.getSystemService("window");
    paramContext = new DisplayMetrics();
    ((WindowManager)localObject).getDefaultDisplay().getMetrics(paramContext);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("m=");
    ((StringBuilder)localObject).append(Build.MODEL);
    ((StringBuilder)localObject).append('&');
    ((StringBuilder)localObject).append("o=");
    ((StringBuilder)localObject).append(Build.VERSION.RELEASE);
    ((StringBuilder)localObject).append('&');
    ((StringBuilder)localObject).append("a=");
    ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
    ((StringBuilder)localObject).append('&');
    ((StringBuilder)localObject).append("p=");
    ((StringBuilder)localObject).append(paramContext.widthPixels);
    ((StringBuilder)localObject).append('*');
    ((StringBuilder)localObject).append(paramContext.heightPixels);
    ((StringBuilder)localObject).append('&');
    ((StringBuilder)localObject).append("f=");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append('&');
    ((StringBuilder)localObject).append("mm=");
    ((StringBuilder)localObject).append(DeviceUtil.getSystemTotalMemory() / 1048576L);
    ((StringBuilder)localObject).append('&');
    ((StringBuilder)localObject).append("cf=");
    ((StringBuilder)localObject).append(DeviceUtil.getCpuFrequency());
    ((StringBuilder)localObject).append('&');
    ((StringBuilder)localObject).append("cc=");
    ((StringBuilder)localObject).append(DeviceUtil.getCpuNumber());
    ((StringBuilder)localObject).append('&');
    ((StringBuilder)localObject).append("qqversion=");
    ((StringBuilder)localObject).append(localMiniAppProxy.getAppVersion());
    sSimpleDeviceInfo = ((StringBuilder)localObject).toString();
    return sSimpleDeviceInfo;
  }
  
  public static String getSystemUA()
  {
    if (systemUA != null) {
      return systemUA;
    }
    try
    {
      boolean bool = VersionUtil.isKITKAT();
      if (!bool) {}
    }
    catch (Throwable localThrowable)
    {
      String str;
      label31:
      break label58;
    }
    try
    {
      str = WebSettings.getDefaultUserAgent(AppLoaderFactory.g().getContext());
    }
    catch (Exception localException)
    {
      break label31;
    }
    str = System.getProperty("http.agent");
    break label46;
    str = System.getProperty("http.agent");
    label46:
    systemUA = URLEncoder.encode(str, "UTF-8");
    break label64;
    label58:
    systemUA = "AndroidQQ";
    label64:
    return systemUA;
  }
  
  public static String getWebViewUA()
  {
    if (TextUtils.isEmpty(mWebViewUA))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getSystemUA());
      localStringBuilder.append(" QQ/");
      localStringBuilder.append(getPlatformVersionString());
      localStringBuilder.append(" ");
      localStringBuilder.append(getPlatformQUA());
      localStringBuilder.append(" MiniAppEnable miniProgram miniprogramhtmlwebview");
      mWebViewUA = localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getWebViewUA done in ");
    localStringBuilder.append(Thread.currentThread().getName());
    QMLog.d("QUAUtil", localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.QUAUtil
 * JD-Core Version:    0.7.0.1
 */