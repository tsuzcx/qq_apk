package com.tencent.mobileqq.troop.jsp;

import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class TroopAppPanelJsPlugin
  extends WebViewPlugin
{
  protected TroopMemberApiClient a;
  protected AtomicBoolean a;
  
  public TroopAppPanelJsPlugin()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("GroupAppPanel".equals(paramString2))
    {
      if (("launchGroupApp".equals(paramString3)) && (paramVarArgs.length > 0) && (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null)) {
        try
        {
          paramString3 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString3.getString("groupCode");
          paramString1 = paramString3.getString("appID");
          paramString2 = paramString3.getString("url");
          paramString3 = paramString3.getString("source");
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramJsBridgeListener, paramString1, paramString2, paramString3);
        }
        catch (Exception paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          QLog.e("TroopAppPanelJsPlugin", 2, "launchGroupApp: args error");
        }
      }
      return true;
    }
    return false;
  }
  
  protected void onCreate()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jsp.TroopAppPanelJsPlugin
 * JD-Core Version:    0.7.0.1
 */