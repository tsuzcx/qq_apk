package com.tencent.mobileqq.qqlive.verified;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Log;
import android.webkit.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebSettings.RenderPriority;
import com.tencent.smtt.sdk.WebView;
import java.io.File;

public class WBH5FaceVerifySDK
{
  private static WBH5FaceVerifySDK c;
  private ValueCallback<Uri> a;
  private ValueCallback<Uri[]> b;
  
  public static WBH5FaceVerifySDK a()
  {
    try
    {
      if (c == null) {
        c = new WBH5FaceVerifySDK();
      }
      WBH5FaceVerifySDK localWBH5FaceVerifySDK = c;
      return localWBH5FaceVerifySDK;
    }
    finally {}
  }
  
  private static String a(Context paramContext)
  {
    Object localObject1 = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject1 == null) {
      return "NETWORK_NONE";
    }
    paramContext = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
    if (paramContext != null)
    {
      if (!paramContext.isAvailable()) {
        return "NETWORK_NONE";
      }
      Object localObject2 = ((ConnectivityManager)localObject1).getNetworkInfo(1);
      if (localObject2 != null)
      {
        localObject2 = ((NetworkInfo)localObject2).getState();
        if ((localObject2 != null) && ((localObject2 == NetworkInfo.State.CONNECTED) || (localObject2 == NetworkInfo.State.CONNECTING))) {
          return "NETWORK_WIFI";
        }
      }
      localObject1 = ((ConnectivityManager)localObject1).getNetworkInfo(0);
      if (localObject1 == null) {
        return "NETWORK_NONE";
      }
      return a(paramContext, ((NetworkInfo)localObject1).getState(), ((NetworkInfo)localObject1).getSubtypeName());
    }
    return "NETWORK_NONE";
  }
  
  private static String a(NetworkInfo paramNetworkInfo, NetworkInfo.State paramState, String paramString)
  {
    if (paramState == null) {
      return "NETWORK_NONE";
    }
    if (!a(paramState)) {
      return "NETWORK_NONE";
    }
    if (a(paramNetworkInfo)) {
      return "NETWORK_2G";
    }
    if (b(paramNetworkInfo)) {
      return "NETWORK_3G";
    }
    if (c(paramNetworkInfo)) {
      return "NETWORK_4G";
    }
    if ((!paramString.equalsIgnoreCase("TD-SCDMA")) && (!paramString.equalsIgnoreCase("WCDMA")))
    {
      if (paramString.equalsIgnoreCase("CDMA2000")) {
        return "NETWORK_3G";
      }
      return "NETWORK_MOBILE";
    }
    return "NETWORK_3G";
  }
  
  private void a(Activity paramActivity)
  {
    try
    {
      Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
      localIntent.putExtra("android.intent.extra.videoQuality", 1);
      localIntent.addFlags(1);
      localIntent.putExtra("big_brother_source_key", "biz_src_jc_qqlive");
      localIntent.putExtra("android.intent.extras.CAMERA_FACING", 1);
      localIntent.putExtra("android.intent.extras.LENS_FACING_FRONT", 1);
      localIntent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
      paramActivity.startActivityForResult(localIntent, 17);
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  private void a(ValueCallback<Uri> paramValueCallback)
  {
    this.a = paramValueCallback;
  }
  
  private static boolean a(NetworkInfo.State paramState)
  {
    return (paramState == NetworkInfo.State.CONNECTED) || (paramState == NetworkInfo.State.CONNECTING);
  }
  
  private static boolean a(NetworkInfo paramNetworkInfo)
  {
    int i = paramNetworkInfo.getSubtype();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != 1)
    {
      bool1 = bool2;
      if (paramNetworkInfo.getSubtype() != 4)
      {
        bool1 = bool2;
        if (paramNetworkInfo.getSubtype() != 2)
        {
          bool1 = bool2;
          if (paramNetworkInfo.getSubtype() != 7)
          {
            if (paramNetworkInfo.getSubtype() == 11) {
              return true;
            }
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  private void b(ValueCallback<Uri[]> paramValueCallback)
  {
    this.b = paramValueCallback;
  }
  
  private static boolean b(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo.getSubtype() == 6) || (paramNetworkInfo.getSubtype() == 3) || (paramNetworkInfo.getSubtype() == 5) || (paramNetworkInfo.getSubtype() == 8) || (paramNetworkInfo.getSubtype() == 9) || (paramNetworkInfo.getSubtype() == 10) || (paramNetworkInfo.getSubtype() == 12) || (paramNetworkInfo.getSubtype() == 14) || (paramNetworkInfo.getSubtype() == 15);
  }
  
  private static boolean c(NetworkInfo paramNetworkInfo)
  {
    return paramNetworkInfo.getSubtype() == 13;
  }
  
  public void a(WebView paramWebView, Context paramContext)
  {
    if (paramWebView == null) {
      return;
    }
    WebSettings localWebSettings = paramWebView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setTextZoom(100);
    localWebSettings.setAllowFileAccess(true);
    localWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
    localWebSettings.setSupportZoom(true);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setSupportMultipleWindows(false);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setAppCacheEnabled(true);
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setGeolocationEnabled(true);
    localWebSettings.setAppCacheMaxSize(9223372036854775807L);
    localWebSettings.setAppCachePath(paramContext.getDir("appcache", 0).getPath());
    localWebSettings.setDatabasePath(paramContext.getDir("databases", 0).getPath());
    localWebSettings.setGeolocationDatabasePath(paramContext.getDir("geolocation", 0).getPath());
    localWebSettings.setPluginState(WebSettings.PluginState.ON_DEMAND);
    localWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
    if (Build.VERSION.SDK_INT >= 16) {
      localWebSettings.setAllowUniversalAccessFromFileURLs(true);
    }
    if (Build.VERSION.SDK_INT >= 11) {
      paramWebView.removeJavascriptInterface("searchBoxJavaBridge_");
    }
    paramWebView = localWebSettings.getUserAgentString();
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramWebView);
      localStringBuilder.append(";webank/h5face;webank/1.0;netType:");
      localStringBuilder.append(a(paramContext));
      localStringBuilder.append(";appVersion:");
      localStringBuilder.append(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode);
      localStringBuilder.append(";packageName:");
      localStringBuilder.append(paramContext.getPackageName());
      localWebSettings.setUserAgentString(localStringBuilder.toString());
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramWebView);
      localStringBuilder.append(";webank/h5face;webank/1.0");
      localWebSettings.setUserAgentString(localStringBuilder.toString());
      paramContext.printStackTrace();
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 17)
    {
      if ((this.a == null) && (this.b == null)) {
        return true;
      }
      if ((paramIntent != null) && (paramInt2 == -1)) {
        paramIntent = paramIntent.getData();
      } else {
        paramIntent = null;
      }
      Uri[] arrayOfUri;
      if (paramIntent == null)
      {
        arrayOfUri = null;
      }
      else
      {
        arrayOfUri = new Uri[1];
        arrayOfUri[0] = paramIntent;
      }
      ValueCallback localValueCallback = this.b;
      if (localValueCallback != null)
      {
        localValueCallback.onReceiveValue(arrayOfUri);
        b(null);
        return true;
      }
      this.a.onReceiveValue(paramIntent);
      a(null);
      return true;
    }
    return false;
  }
  
  public boolean a(ValueCallback<Uri> paramValueCallback, String paramString, Activity paramActivity)
  {
    if ("video/webank".equals(paramString))
    {
      a(paramValueCallback);
      a(paramActivity);
      return true;
    }
    return false;
  }
  
  @TargetApi(21)
  public boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, Activity paramActivity, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("accept is ");
    localStringBuilder.append(paramFileChooserParams.getAcceptTypes()[0]);
    localStringBuilder.append("---url---");
    localStringBuilder.append(paramWebView.getUrl());
    Log.d("faceVerify", localStringBuilder.toString());
    if ((!"video/webank".equals(paramFileChooserParams.getAcceptTypes()[0])) && (!paramWebView.getUrl().startsWith("https://ida.webank.com/"))) {
      return false;
    }
    b(paramValueCallback);
    a(paramActivity);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.verified.WBH5FaceVerifySDK
 * JD-Core Version:    0.7.0.1
 */