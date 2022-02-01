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
  protected AtomicBoolean b = new AtomicBoolean(false);
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("GroupAppPanel".equals(paramString2))
    {
      if (("launchGroupApp".equals(paramString3)) && (paramVarArgs.length > 0) && (this.a != null)) {
        try
        {
          paramString3 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString3.getString("groupCode");
          paramString1 = paramString3.getString("appID");
          paramString2 = paramString3.getString("url");
          paramString3 = paramString3.getString("source");
          this.a.a(paramJsBridgeListener, paramString1, paramString2, paramString3);
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
    if (this.b.compareAndSet(false, true))
    {
      this.a = TroopMemberApiClient.a();
      this.a.e();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.b.get()) {
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jsp.TroopAppPanelJsPlugin
 * JD-Core Version:    0.7.0.1
 */