package com.tencent.mobileqq.jsp;

import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ConnectApiPlugin
  extends WebViewPlugin
{
  TroopMemberApiClient a;
  
  public ConnectApiPlugin()
  {
    this.mPluginNameSpace = "connect";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("connect".equals(paramString2)) && ("exchangeID".equals(paramString3)) && (paramVarArgs.length > 0)) {
      try
      {
        paramString3 = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener = paramString3.optString("appid");
        paramString1 = paramString3.optString("openid");
        paramString2 = paramString3.optString("troopuin");
        paramString3 = paramString3.optString("callback");
        if (this.a == null)
        {
          this.a = TroopMemberApiClient.a();
          this.a.e();
        }
        this.a.a(paramJsBridgeListener, paramString1, paramString2, new ConnectApiPlugin.1(this, paramString3));
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("handleJsRequest JSONException:");
          paramString1.append(paramJsBridgeListener);
          QLog.e("ConnectApiPlugin", 2, paramString1.toString());
        }
        return false;
      }
    }
    return true;
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
 * Qualified Name:     com.tencent.mobileqq.jsp.ConnectApiPlugin
 * JD-Core Version:    0.7.0.1
 */