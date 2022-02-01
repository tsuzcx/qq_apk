package com.tencent.mobileqq.webview.sonic;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.webview.api.ISonicPreloaderService;
import com.tencent.mobileqq.webview.data.SonicPreloadData;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.MultiNameSpacePluginCompact;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sonic.sdk.SonicSession;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class SonicJsPlugin
  extends WebViewPlugin
  implements MultiNameSpacePluginCompact
{
  public static final String METHOD_GET_DIFF_DATA = "getDiffData";
  public static final String METHOD_GET_SWIFT_HTTP_DIFF_DATA = "getSwiftHttpDiffData";
  public static final String METHOD_PRELOAD = "preload";
  public static final String METHOD_RELOAD = "reloadHttpData";
  public static final String PACKAGE_NAME_SONIC = "sonic";
  public static final String PACKAGE_NAME_SWIFT = "SwiftHttp";
  public static final String TAG = "SonicSdkImpl_SonicJsPlugin";
  
  public String[] getMultiNameSpace()
  {
    return new String[] { "SwiftHttp", "sonic" };
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest, url=");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append(", pkgName=");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append(", methodName=");
      paramJsBridgeListener.append(paramString3);
      QLog.d("SonicSdkImpl_SonicJsPlugin", 2, paramJsBridgeListener.toString());
    }
    if ((!"SwiftHttp".equals(paramString2)) && (!"sonic".equals(paramString2))) {
      return false;
    }
    paramString2 = WebViewPlugin.getJsonFromJSBridge(paramString1);
    if (paramString2 == null) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest JSON = ");
      paramJsBridgeListener.append(paramString2.toString());
      QLog.d("SonicSdkImpl_SonicJsPlugin", 2, paramJsBridgeListener.toString());
    }
    paramJsBridgeListener = paramString2.optString("callback");
    if ((!"getSwiftHttpDiffData".equals(paramString3)) && (!"getDiffData".equals(paramString3))) {
      if ("preload".equals(paramString3))
      {
        if (TextUtils.isEmpty(paramJsBridgeListener))
        {
          QLog.e("SonicSdkImpl_SonicJsPlugin", 1, "callback id is null, so return");
          return true;
        }
        paramString1 = new JSONObject();
      }
    }
    for (;;)
    {
      boolean bool;
      try
      {
        paramString3 = paramString2.optString("url");
        bool = paramString2.optBoolean("isAccountRelated", true);
        if (!TextUtils.isEmpty(paramString3))
        {
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("handleJsRequest preload session, preload url = ");
            paramString2.append(paramString3);
            QLog.d("SonicSdkImpl_SonicJsPlugin", 2, paramString2.toString());
          }
          paramString2 = new SonicPreloadData(0, IndividuationUrlHelper.a(MobileQQ.sMobileQQ.waitAppRuntime(null), paramString3, ""), bool, 0L, 1);
          paramString3 = new ArrayList();
          paramString3.add(paramString2);
          if (!((ISonicPreloaderService)QRoute.api(ISonicPreloaderService.class)).preload(paramString3)) {
            break label616;
          }
          i = 1;
          paramString1.put("result", i);
          callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          return true;
        }
        paramString1.put("result", 0);
        callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
        return true;
      }
      catch (Exception paramString2)
      {
        paramString3 = new StringBuilder();
        paramString3.append("handleJsRequest preload session, exception, e =  ");
        paramString3.append(paramString2.getMessage());
        QLog.e("SonicSdkImpl_SonicJsPlugin", 1, paramString3.toString());
      }
      try
      {
        paramString1.put("result", 0);
        callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        return true;
      }
      if ("reloadHttpData".equalsIgnoreCase(paramString3))
      {
        paramJsBridgeListener = paramString2.optString("callback");
        bool = paramString2.optBoolean("needData");
        if (TextUtils.isEmpty(paramJsBridgeListener))
        {
          QLog.e("SonicSdkImpl_SonicJsPlugin", 1, "ReloadCallbackId id is null, so return");
          return true;
        }
        paramString1 = this.mRuntime.a();
        if (paramString1 != null)
        {
          paramString2 = paramString1.getSonicClient();
          if ((paramString2 != null) && (paramString2.getSession() != null))
          {
            paramString1.getSonicClient().getSession().refresh();
            paramString2.getDiffData(new SonicJsPlugin.2(this, bool, paramString1, paramJsBridgeListener));
          }
        }
        return true;
      }
      return false;
      if (TextUtils.isEmpty(paramJsBridgeListener))
      {
        QLog.e("SonicSdkImpl_SonicJsPlugin", 1, "callback id is null, so return");
        return true;
      }
      paramString1 = this.mRuntime.a();
      if (paramString1 != null)
      {
        paramString2 = paramString1.getSonicClient();
        if ((paramString2 != null) && (paramString2.getSession() != null)) {
          paramString2.getDiffData(new SonicJsPlugin.1(this, paramString1, paramJsBridgeListener));
        }
      }
      return true;
      label616:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.sonic.SonicJsPlugin
 * JD-Core Version:    0.7.0.1
 */