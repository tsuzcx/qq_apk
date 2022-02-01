package com.tencent.mobileqq.nearby.verify;

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
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebSettings.RenderPriority;
import com.tencent.smtt.sdk.WebView;
import java.io.File;

public class WBH5FaceVerifySDK
{
  private static WBH5FaceVerifySDK jdField_a_of_type_ComTencentMobileqqNearbyVerifyWBH5FaceVerifySDK;
  private ValueCallback<Uri> jdField_a_of_type_AndroidWebkitValueCallback;
  private ValueCallback<Uri[]> b;
  
  public static WBH5FaceVerifySDK a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqNearbyVerifyWBH5FaceVerifySDK == null) {
        jdField_a_of_type_ComTencentMobileqqNearbyVerifyWBH5FaceVerifySDK = new WBH5FaceVerifySDK();
      }
      WBH5FaceVerifySDK localWBH5FaceVerifySDK = jdField_a_of_type_ComTencentMobileqqNearbyVerifyWBH5FaceVerifySDK;
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
      localObject2 = ((ConnectivityManager)localObject1).getNetworkInfo(0);
      if (localObject2 != null)
      {
        localObject1 = ((NetworkInfo)localObject2).getState();
        localObject2 = ((NetworkInfo)localObject2).getSubtypeName();
        if ((localObject1 != null) && ((localObject1 == NetworkInfo.State.CONNECTED) || (localObject1 == NetworkInfo.State.CONNECTING)))
        {
          switch (paramContext.getSubtype())
          {
          default: 
            if ((((String)localObject2).equalsIgnoreCase("TD-SCDMA")) || (((String)localObject2).equalsIgnoreCase("WCDMA"))) {
              break label230;
            }
            if (((String)localObject2).equalsIgnoreCase("CDMA2000")) {
              return "NETWORK_3G";
            }
            break;
          case 13: 
            return "NETWORK_4G";
          case 3: 
          case 5: 
          case 6: 
          case 8: 
          case 9: 
          case 10: 
          case 12: 
          case 14: 
          case 15: 
            return "NETWORK_3G";
          case 1: 
          case 2: 
          case 4: 
          case 7: 
          case 11: 
            return "NETWORK_2G";
          }
          return "NETWORK_MOBILE";
          label230:
          return "NETWORK_3G";
        }
      }
    }
    return "NETWORK_NONE";
  }
  
  private void a(Activity paramActivity)
  {
    try
    {
      Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
      localIntent.putExtra("android.intent.extra.videoQuality", 1);
      localIntent.addFlags(1);
      localIntent.putExtra("big_brother_source_key", "biz_src_hdsp_nearby");
      localIntent.putExtra("android.intent.extras.CAMERA_FACING", 1);
      localIntent.putExtra("android.intent.extras.LENS_FACING_FRONT", 1);
      localIntent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
      paramActivity.startActivityForResult(localIntent, 17);
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("WBH5FaceVerifySDK", 2, paramActivity, new Object[0]);
    }
  }
  
  private void a(ValueCallback<Uri> paramValueCallback)
  {
    this.jdField_a_of_type_AndroidWebkitValueCallback = paramValueCallback;
  }
  
  private void b(ValueCallback<Uri[]> paramValueCallback)
  {
    this.b = paramValueCallback;
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
      if ((this.jdField_a_of_type_AndroidWebkitValueCallback == null) && (this.b == null)) {
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
      this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(paramIntent);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.verify.WBH5FaceVerifySDK
 * JD-Core Version:    0.7.0.1
 */