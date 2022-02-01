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
  WebPushClient.WebPushCallback jdField_a_of_type_ComTencentBizApiproxyWebPushClient$WebPushCallback = new PushApiPlugin.1(this);
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  String jdField_a_of_type_JavaLangString;
  
  public PushApiPlugin()
  {
    this.mPluginNameSpace = "push";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"push".equals(paramString2)) || (("addListener".equals(paramString3)) && (paramVarArgs.length > 0))) {}
    for (;;)
    {
      int i;
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        i = paramJsBridgeListener.optInt("appid");
        this.jdField_a_of_type_JavaLangString = paramJsBridgeListener.optString("callback");
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().a(i, this.jdField_a_of_type_ComTencentBizApiproxyWebPushClient$WebPushCallback);
        if (QLog.isColorLevel()) {
          QLog.d("PushApiPlugin", 2, new Object[] { paramString2, ".", paramString3, " args:", paramJsBridgeListener.toString() });
        }
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PushApiPlugin", 2, new Object[] { "handleJsRequest pkgName:", paramString2, " method:", paramString3, " JSONException:", paramJsBridgeListener });
        }
        return false;
      }
      if (("removeListener".equals(paramString3)) && (paramVarArgs.length > 0)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          i = paramJsBridgeListener.optInt("appid");
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().a(i);
          if (QLog.isColorLevel()) {
            QLog.d("PushApiPlugin", 2, new Object[] { paramString2, ".", paramString3, " args:", paramJsBridgeListener.toString() });
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PushApiPlugin", 2, new Object[] { "handleJsRequest pkgName:", paramString2, " method:", paramString3, " JSONException:", paramJsBridgeListener });
          }
        }
      }
    }
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.PushApiPlugin
 * JD-Core Version:    0.7.0.1
 */