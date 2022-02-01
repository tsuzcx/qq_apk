package com.tencent.mobileqq.troop.browser;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emosm.Client.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class VipTroopUpgradePlugin
  extends VasWebviewJsPlugin
{
  public static String a;
  protected Context a;
  protected AppInterface a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "TroopUpgradePlugin";
  }
  
  public VipTroopUpgradePlugin()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    this.mPluginNameSpace = "Troop";
  }
  
  public long getPluginBusiness()
  {
    return 2147614720L;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ("Troop".equals(paramString2)) {}
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
      if (paramJsBridgeListener == null) {
        return false;
      }
    }
    catch (JSONException paramJsBridgeListener)
    {
      for (;;)
      {
        paramJsBridgeListener.printStackTrace();
        paramJsBridgeListener = null;
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      int i;
      do
      {
        for (;;)
        {
          paramJsBridgeListener.printStackTrace();
          paramJsBridgeListener = null;
        }
        if (!"updateMaxMemberNum".equals(paramString3)) {
          break;
        }
        paramString1 = paramJsBridgeListener.optString("groupId", "");
        i = paramJsBridgeListener.optInt("type", 0);
      } while ((TextUtils.isEmpty(paramString1)) || (i == 0));
      paramJsBridgeListener = new Bundle();
      paramJsBridgeListener.putString("groupId", paramString1);
      paramJsBridgeListener.putInt("type", i);
      sendRemoteReq(DataFactory.a("notifyTroopUpgradeSuccess", "", this.mOnRemoteResp.key, paramJsBridgeListener), true, false);
    }
    return true;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidContentContext = this.mRuntime.a();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.mRuntime.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.browser.VipTroopUpgradePlugin
 * JD-Core Version:    0.7.0.1
 */