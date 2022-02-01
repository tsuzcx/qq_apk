package com.tencent.mobileqq.realname;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import eipc.EIPCClient;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class GetAreaCodeWebviewPlugin
  extends VasWebviewJsPlugin
{
  public byte a;
  private String a;
  
  public GetAreaCodeWebviewPlugin()
  {
    this.jdField_a_of_type_Byte = 1;
    this.mPluginNameSpace = "RealName";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest url: ");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append(" pkgName: ");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append(" method: ");
      paramJsBridgeListener.append(paramString3);
      paramJsBridgeListener.append(" args: ");
      paramJsBridgeListener.append(paramVarArgs[0]);
      QLog.i("RealName", 2, paramJsBridgeListener.toString());
    }
    if (!paramString2.equalsIgnoreCase("RealName")) {
      return false;
    }
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length < 1) {
        return false;
      }
      if (paramString3.equalsIgnoreCase("getCountryCode"))
      {
        paramJsBridgeListener = paramVarArgs[0];
        try
        {
          this.jdField_a_of_type_JavaLangString = new JSONObject(paramJsBridgeListener).getString("callbackId");
          paramJsBridgeListener = (QBaseActivity)this.mRuntime.a();
          if (paramJsBridgeListener == null) {
            return false;
          }
          startActivityForResult(new Intent(paramJsBridgeListener, CountryActivity.class), this.jdField_a_of_type_Byte);
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (QLog.isColorLevel()) {
            paramJsBridgeListener.printStackTrace();
          }
          return false;
        }
      }
      if (paramString3.equalsIgnoreCase("onAuthResult"))
      {
        paramJsBridgeListener = paramVarArgs[0];
        try
        {
          paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
          int i = paramJsBridgeListener.getInt("result");
          paramJsBridgeListener = paramJsBridgeListener.optString("from", "");
          paramString1 = new Bundle();
          paramString1.putInt("result", i);
          paramString1.putString("source", paramJsBridgeListener);
          QIPCClientHelper.getInstance().getClient().callServer("REAL_NAME", "ON_WEB_AUTH_RESULT", paramString1);
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (QLog.isColorLevel()) {
            paramJsBridgeListener.printStackTrace();
          }
          return false;
        }
      }
      if (paramString3.equalsIgnoreCase("getDeviceInfo"))
      {
        paramJsBridgeListener = paramVarArgs[0];
        try
        {
          paramJsBridgeListener = new JSONObject(paramJsBridgeListener).getString("callbackId");
          paramString1 = this.mRuntime.a();
          paramString1 = ((TicketManager)paramString1.getManager(2)).getA2(paramString1.getAccount());
          paramString2 = new String(NetConnInfoCenter.GUID);
          paramString3 = new JSONObject();
          try
          {
            paramString3.put("appid", String.valueOf(AppSetting.a()));
            paramString3.put("imei", QQDeviceInfo.getIMEI("ef0716"));
            paramString3.put("guid", paramString2);
            paramString3.put("A2", paramString1);
            callJs(paramJsBridgeListener, new String[] { paramString3.toString() });
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            if (!QLog.isDevelopLevel()) {
              break label446;
            }
          }
          paramJsBridgeListener.printStackTrace();
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (QLog.isColorLevel()) {
            paramJsBridgeListener.printStackTrace();
          }
          return false;
        }
      }
      label446:
      return true;
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    byte b2 = this.jdField_a_of_type_Byte;
    String str2 = "";
    byte b1 = -1;
    if ((paramByte == b2) && (paramInt == -1))
    {
      if (paramIntent != null)
      {
        str1 = paramIntent.getStringExtra("k_name");
        str2 = paramIntent.getStringExtra("k_code");
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("onActivity countryName is: ");
          paramIntent.append(str1);
          paramIntent.append(" countryCode: ");
          paramIntent.append(str2);
          QLog.i("RealName", 2, paramIntent.toString());
        }
        paramByte = 0;
        paramIntent = str1;
        str1 = str2;
        break label141;
      }
      if (QLog.isColorLevel()) {
        QLog.i("RealName", 2, "onActivityResult, intent is null.");
      }
    }
    String str1 = "";
    paramByte = b1;
    paramIntent = str2;
    try
    {
      label141:
      localJSONObject.put("retCode", paramByte);
      localJSONObject.put("country", paramIntent);
      localJSONObject.put("value", str1);
      callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException paramIntent)
    {
      if (QLog.isDevelopLevel()) {
        paramIntent.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.realname.GetAreaCodeWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */