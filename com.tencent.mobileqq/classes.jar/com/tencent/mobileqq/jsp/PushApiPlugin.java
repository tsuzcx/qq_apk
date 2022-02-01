package com.tencent.mobileqq.jsp;

import com.tencent.biz.apiproxy.WebPushClient;
import com.tencent.biz.apiproxy.WebPushClient.WebPushCallback;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class PushApiPlugin
  extends WebViewPlugin
{
  TroopMemberApiClient a;
  String b;
  WebPushClient.WebPushCallback c = new PushApiPlugin.1(this);
  
  public PushApiPlugin()
  {
    this.mPluginNameSpace = "push";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("push".equals(paramString2))
    {
      int i;
      if (("addListener".equals(paramString3)) && (paramVarArgs.length > 0)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          i = paramJsBridgeListener.optInt("appid");
          this.b = paramJsBridgeListener.optString("callback");
          this.a.c().a(i, this.c);
          if (!QLog.isColorLevel()) {
            break label303;
          }
          QLog.d("PushApiPlugin", 2, new Object[] { paramString2, ".", paramString3, " args:", paramJsBridgeListener.toString() });
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PushApiPlugin", 2, new Object[] { "handleJsRequest pkgName:", paramString2, " method:", paramString3, " JSONException:", paramJsBridgeListener });
          }
          return false;
        }
      } else if (("removeListener".equals(paramString3)) && (paramVarArgs.length > 0)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          i = paramJsBridgeListener.optInt("appid");
          this.a.c().a(i);
          if (QLog.isColorLevel())
          {
            QLog.d("PushApiPlugin", 2, new Object[] { paramString2, ".", paramString3, " args:", paramJsBridgeListener.toString() });
            return true;
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PushApiPlugin", 2, new Object[] { "handleJsRequest pkgName:", paramString2, " method:", paramString3, " JSONException:", paramJsBridgeListener });
          }
          return false;
        }
      }
    }
    label303:
    return true;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if (this.a == null)
    {
      this.a = TroopMemberApiClient.a();
      this.a.e();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    TroopMemberApiClient localTroopMemberApiClient = this.a;
    if (localTroopMemberApiClient != null) {
      localTroopMemberApiClient.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.PushApiPlugin
 * JD-Core Version:    0.7.0.1
 */