package com.tencent.mobileqq.jsp;

import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class UniteSearchApiPlugin
  extends WebViewPlugin
{
  public static final String a;
  protected TroopMemberApiClient a;
  
  static
  {
    jdField_a_of_type_JavaLangString = UniteSearchApiPlugin.class.getSimpleName();
  }
  
  public UniteSearchApiPlugin()
  {
    this.mPluginNameSpace = "ftssearch";
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    while ("ftssearch".equals(paramString2)) {
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UniteSearchApiPlugin
 * JD-Core Version:    0.7.0.1
 */