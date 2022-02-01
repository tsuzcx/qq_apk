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
import java.util.List;
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
  
  private boolean preload(JSONObject paramJSONObject, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("SonicSdkImpl_SonicJsPlugin", 1, "callback id is null, so return");
      return true;
    }
    localJSONObject = new JSONObject();
    try
    {
      localObject = paramJSONObject.optString("url");
      boolean bool = paramJSONObject.optBoolean("isAccountRelated", true);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label183;
      }
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("handleJsRequest preload session, preload url = ");
        paramJSONObject.append((String)localObject);
        QLog.d("SonicSdkImpl_SonicJsPlugin", 2, paramJSONObject.toString());
      }
      paramJSONObject = new SonicPreloadData(0, IndividuationUrlHelper.a(MobileQQ.sMobileQQ.waitAppRuntime(null), (String)localObject, ""), bool, 0L, 1);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramJSONObject);
      if (!((ISonicPreloaderService)QRoute.api(ISonicPreloaderService.class)).preload((List)localObject)) {
        break label281;
      }
      i = 1;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleJsRequest preload session, exception, e =  ");
        ((StringBuilder)localObject).append(paramJSONObject.getMessage());
        QLog.e("SonicSdkImpl_SonicJsPlugin", 1, ((StringBuilder)localObject).toString());
        try
        {
          localJSONObject.put("result", 0);
          callJs(paramString, new String[] { localJSONObject.toString() });
          return true;
        }
        catch (Exception paramJSONObject)
        {
          return true;
        }
        int i = 0;
      }
    }
    localJSONObject.put("result", i);
    callJs(paramString, new String[] { localJSONObject.toString() });
    return true;
    label183:
    localJSONObject.put("result", 0);
    callJs(paramString, new String[] { localJSONObject.toString() });
    return true;
  }
  
  private boolean reload(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("callback");
    boolean bool = paramJSONObject.optBoolean("needData");
    if (TextUtils.isEmpty(str))
    {
      QLog.e("SonicSdkImpl_SonicJsPlugin", 1, "ReloadCallbackId id is null, so return");
      return true;
    }
    paramJSONObject = this.mRuntime.a();
    if (paramJSONObject != null)
    {
      SonicClientImpl localSonicClientImpl = paramJSONObject.getSonicClient();
      if ((localSonicClientImpl != null) && (localSonicClientImpl.getSession() != null))
      {
        paramJSONObject.getSonicClient().getSession().refresh();
        localSonicClientImpl.getDiffData(new SonicJsPlugin.2(this, bool, paramJSONObject, str));
      }
    }
    return true;
  }
  
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
    paramString1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
    if (paramString1 == null) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest JSON = ");
      paramJsBridgeListener.append(paramString1.toString());
      QLog.d("SonicSdkImpl_SonicJsPlugin", 2, paramJsBridgeListener.toString());
    }
    paramJsBridgeListener = paramString1.optString("callback");
    if ((!"getSwiftHttpDiffData".equals(paramString3)) && (!"getDiffData".equals(paramString3)))
    {
      if ("preload".equals(paramString3)) {
        return preload(paramString1, paramJsBridgeListener);
      }
      if ("reloadHttpData".equalsIgnoreCase(paramString3)) {
        return reload(paramString1);
      }
      return false;
    }
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.sonic.SonicJsPlugin
 * JD-Core Version:    0.7.0.1
 */