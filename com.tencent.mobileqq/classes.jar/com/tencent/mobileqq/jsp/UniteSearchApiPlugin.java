package com.tencent.mobileqq.jsp;

import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class UniteSearchApiPlugin
  extends WebViewPlugin
{
  public static final String a = "UniteSearchApiPlugin";
  protected TroopMemberApiClient a = TroopMemberApiClient.a();
  
  public UniteSearchApiPlugin()
  {
    this.mPluginNameSpace = "ftssearch";
    this.a.a();
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (paramVarArgs != null))
    {
      if (paramVarArgs.length == 0) {
        return false;
      }
      if ("ftssearch".equals(paramString2)) {}
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UniteSearchApiPlugin
 * JD-Core Version:    0.7.0.1
 */