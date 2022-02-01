package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class HippyJsPlugin
  extends VasWebviewJsPlugin
{
  private static final String METHOD_OPEN_HIPPY = "openHippy";
  private static final String METHOD_UPDATE_JS_BUNDLE = "updateHippyBundle";
  private static final String NAME_SPACE = "hippy";
  private static final String TAG = "HippyJsPlugin";
  
  public HippyJsPlugin()
  {
    this.mPluginNameSpace = "hippy";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest pkgName=");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append(" method=");
      paramJsBridgeListener.append(paramString3);
      QLog.d("HippyJsPlugin", 2, paramJsBridgeListener.toString());
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return false;
      }
      if (!"hippy".equals(paramString2))
      {
        if (QLog.isColorLevel())
        {
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append("can not handle objectname:");
          paramJsBridgeListener.append(paramString2);
          QLog.i("HippyJsPlugin", 2, paramJsBridgeListener.toString());
        }
        return false;
      }
      paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("handleJsRequest JSON = ");
        paramString1.append(paramJsBridgeListener.toString());
        QLog.i("HippyJsPlugin", 2, paramString1.toString());
      }
      paramString1 = paramJsBridgeListener.optString("callback");
      if (TextUtils.isEmpty(paramString1)) {
        QLog.e("HippyJsPlugin", 1, "callback id is null");
      }
      if ("updateHippyBundle".equals(paramString3))
      {
        updateHippyBundle(paramJsBridgeListener, paramString1);
        return true;
      }
      if ("openHippy".equals(paramString3)) {
        openHippy(paramJsBridgeListener, paramString1);
      }
      return true;
    }
    return false;
  }
  
  protected void onJsUpdateCompleted(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("retCode", paramInt);
      if (paramInt == 1) {
        localJSONObject.put("newVersion", ((IHippySetting)QRoute.api(IHippySetting.class)).getModuleVersion(paramString1));
      } else if (paramInt == -1) {
        localJSONObject.put("errMsg", paramString2);
      }
      callJs(paramString3, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Throwable paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("onJsUpdateCompleted error:");
      paramString2.append(paramString1);
      QLog.e("HippyJsPlugin", 1, paramString2.toString());
    }
  }
  
  protected void openHippy(JSONObject paramJSONObject, String paramString)
  {
    for (;;)
    {
      try
      {
        boolean bool = new OpenHippyInfo(paramJSONObject).openHippy(this.mRuntime.d());
        if (TextUtils.isEmpty(paramString)) {
          return;
        }
        paramJSONObject = new JSONObject();
        if (bool)
        {
          i = 0;
          paramJSONObject.put("retCode", i);
          callJs(paramString, new String[] { paramJSONObject.toString() });
          return;
        }
      }
      catch (Throwable paramJSONObject)
      {
        paramString = new StringBuilder();
        paramString.append("openHippy error:");
        paramString.append(paramJSONObject);
        QLog.e("HippyJsPlugin", 1, paramString.toString());
        return;
      }
      int i = -1;
    }
  }
  
  protected void updateHippyBundle(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {
      return;
    }
    paramJSONObject = paramJSONObject.optString("bundleName");
    if (TextUtils.isEmpty(paramJSONObject)) {
      return;
    }
    ((IHippyUpdate)QRoute.api(IHippyUpdate.class)).commonUpdateJsBundle(paramJSONObject, "updateApiH5", new HippyJsPlugin.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.HippyJsPlugin
 * JD-Core Version:    0.7.0.1
 */