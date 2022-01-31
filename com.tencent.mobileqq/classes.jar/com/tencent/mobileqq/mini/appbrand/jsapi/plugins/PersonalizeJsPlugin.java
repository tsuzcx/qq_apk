package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public class PersonalizeJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "PersonalizeJsPlugin";
  Set<String> eventMap = new HashSet();
  
  public PersonalizeJsPlugin()
  {
    this.eventMap.add("Personalize");
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("PersonalizeJsPlugin", 4, "[handleNativeRequest] event=" + paramString1 + ", jsonParams=" + paramString2 + ", callbackId=" + paramInt);
    if ("Personalize".equals(paramString1)) {}
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramString2);
        if (!paramString2.has("api_name")) {
          continue;
        }
        localObject = paramString2.optJSONObject("data");
        if (localObject == null)
        {
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "params error.", paramInt);
          return "";
        }
      }
      catch (Exception paramString2)
      {
        Object localObject;
        int i;
        String str;
        QLog.e("PersonalizeJsPlugin", 1, paramString1 + " error.", paramString2);
        continue;
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "params error.", paramInt);
        continue;
      }
      try
      {
        paramString2 = ((JSONObject)localObject).optString("uin");
        i = ((JSONObject)localObject).optInt("set_type");
        str = ((JSONObject)localObject).optString("item_id");
        localObject = ((JSONObject)localObject).optString("busi_info");
        MiniAppCmdUtil.getInstance().setPersonalizeInfo(this.jsPluginEngine.appBrandRuntime.appId, paramString2, i, str, (String)localObject, new PersonalizeJsPlugin.1(this, paramJsRuntime, paramString1, paramInt));
        return "";
      }
      catch (Exception paramString2)
      {
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "params error.", paramInt);
      }
    }
  }
  
  public Set<String> supportedEvents()
  {
    return this.eventMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.PersonalizeJsPlugin
 * JD-Core Version:    0.7.0.1
 */