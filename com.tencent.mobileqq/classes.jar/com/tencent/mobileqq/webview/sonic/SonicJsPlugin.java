package com.tencent.mobileqq.webview.sonic;

import ajyf;
import ajyg;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.MultiNameSpacePluginCompact;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sonic.sdk.SonicSession;
import java.util.ArrayList;
import org.json.JSONObject;

public class SonicJsPlugin
  extends WebViewPlugin
  implements MultiNameSpacePluginCompact
{
  public String[] getMultiNameSpace()
  {
    return new String[] { "SwiftHttp", "sonic" };
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SonicSdkImpl_SonicJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((!"SwiftHttp".equals(paramString2)) && (!"sonic".equals(paramString2))) {
      return false;
    }
    paramString2 = WebViewPlugin.getJsonFromJSBridge(paramString1);
    if (paramString2 == null) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SonicSdkImpl_SonicJsPlugin", 2, "handleJsRequest JSON = " + paramString2.toString());
    }
    paramJsBridgeListener = paramString2.optString("callback");
    if (("getSwiftHttpDiffData".equals(paramString3)) || ("getDiffData".equals(paramString3)))
    {
      if (TextUtils.isEmpty(paramJsBridgeListener))
      {
        QLog.e("SonicSdkImpl_SonicJsPlugin", 1, "callback id is null, so return");
        return true;
      }
      paramString1 = this.mRuntime.a();
      if (paramString1 != null)
      {
        paramString2 = paramString1.a();
        if ((paramString2 != null) && (paramString2.a() != null)) {
          paramString2.getDiffData(new ajyf(this, paramString1, paramJsBridgeListener));
        }
      }
      return true;
    }
    if ("preload".equals(paramString3))
    {
      if (TextUtils.isEmpty(paramJsBridgeListener))
      {
        QLog.e("SonicSdkImpl_SonicJsPlugin", 1, "callback id is null, so return");
        return true;
      }
      paramString1 = new JSONObject();
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
          if (QLog.isColorLevel()) {
            QLog.d("SonicSdkImpl_SonicJsPlugin", 2, "handleJsRequest preload session, preload url = " + paramString3);
          }
          paramString2 = new SonicPreloadData(0, IndividuationUrlHelper.a(BaseApplicationImpl.sApplication.getRuntime(), paramString3, ""), bool, 0L, 1);
          paramString3 = new ArrayList();
          paramString3.add(paramString2);
          if (!SonicPreloader.a(paramString3)) {
            break label562;
          }
          i = 1;
          paramString1.put("result", i);
          callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          return true;
        }
        paramString1.put("result", 0);
        callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
      }
      catch (Exception paramString2)
      {
        QLog.e("SonicSdkImpl_SonicJsPlugin", 1, "handleJsRequest preload session, exception, e =  " + paramString2.getMessage());
        try
        {
          paramString1.put("result", 0);
          callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
        }
        catch (Exception paramJsBridgeListener) {}
        continue;
      }
      return true;
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
          paramString2 = paramString1.a();
          if ((paramString2 != null) && (paramString2.a() != null))
          {
            paramString1.a().a().refresh();
            paramString2.getDiffData(new ajyg(this, bool, paramString1, paramJsBridgeListener));
          }
        }
        return true;
      }
      return false;
      label562:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.webview.sonic.SonicJsPlugin
 * JD-Core Version:    0.7.0.1
 */