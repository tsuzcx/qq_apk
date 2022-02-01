package com.tencent.mobileqq.troop.browser;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class VipTroopUpgradePlugin
  extends VasWebviewJsPlugin
{
  public static String a = "TroopUpgradePlugin";
  protected Context a;
  protected AppInterface a;
  
  public VipTroopUpgradePlugin()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    this.mPluginNameSpace = "Troop";
  }
  
  protected long getPluginBusiness()
  {
    return 2147614720L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleJsRequest, url=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", pkgName=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", methodName=");
      localStringBuilder.append(paramString3);
      QLog.d(paramJsBridgeListener, 2, localStringBuilder.toString());
    }
    if ("Troop".equals(paramString2))
    {
      paramJsBridgeListener = null;
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener = paramString1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
      if (paramJsBridgeListener == null) {
        return false;
      }
      if ("updateMaxMemberNum".equals(paramString3))
      {
        paramString1 = paramJsBridgeListener.optString("groupId", "");
        int i = paramJsBridgeListener.optInt("type", 0);
        if (!TextUtils.isEmpty(paramString1))
        {
          if (i == 0) {
            return false;
          }
          paramJsBridgeListener = new Bundle();
          paramJsBridgeListener.putString("groupId", paramString1);
          paramJsBridgeListener.putInt("type", i);
          sendRemoteReq(DataFactory.a("notifyTroopUpgradeSuccess", "", this.mOnRemoteResp.key, paramJsBridgeListener), true, false);
          return true;
        }
        return false;
      }
      return true;
    }
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidContentContext = this.mRuntime.a();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.mRuntime.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.browser.VipTroopUpgradePlugin
 * JD-Core Version:    0.7.0.1
 */