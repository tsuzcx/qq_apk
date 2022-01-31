package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import anql;
import anqp;
import bcdb;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class IndividualRedPacketJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "individualRedPacket";
  private static final String TAG = "IndividualRedPacketJsPlugin";
  private BrowserAppInterface browserApp;
  private Bundle mReqBundle;
  
  public IndividualRedPacketJsPlugin()
  {
    this.mPluginNameSpace = "individualRedPacket";
  }
  
  protected long getPluginBusiness()
  {
    return 2281701376L;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IndividualRedPacketJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"individualRedPacket".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    paramVarArgs = WebViewPlugin.getJsonFromJSBridge(paramString1);
    if (paramVarArgs == null) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IndividualRedPacketJsPlugin", 2, "handleJsRequest JSON = " + paramVarArgs.toString());
    }
    paramString2 = paramVarArgs.optString("callback");
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.e("IndividualRedPacketJsPlugin", 1, "callback id is null, so return");
      return true;
    }
    paramJsBridgeListener = "";
    if ("getBitmap".equals(paramString3))
    {
      paramString1 = "rpWebGetBitmap";
      this.mReqBundle.clear();
    }
    do
    {
      for (;;)
      {
        try
        {
          this.mReqBundle.putString("templateId", paramVarArgs.getString("templateId"));
          this.mReqBundle.putString("content", paramVarArgs.getString("content"));
          paramJsBridgeListener = paramString1;
        }
        catch (JSONException paramString3)
        {
          paramJsBridgeListener = paramString1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("IndividualRedPacketJsPlugin", 2, "Failed to getBitmap:" + paramString3.getMessage());
          paramJsBridgeListener = paramString1;
          continue;
        }
        super.sendRemoteReq(anqp.a(paramJsBridgeListener, paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        return true;
        if ("setFlag".equals(paramString3))
        {
          paramString1 = "rpWebSetFlags";
          this.mReqBundle.clear();
          try
          {
            if (paramVarArgs.has("switchFlag")) {
              this.mReqBundle.putInt("iRedDisable", paramVarArgs.getInt("switchFlag"));
            }
            if (paramVarArgs.has("vipRedpacketFlag")) {
              this.mReqBundle.putInt("iCanUseRed", paramVarArgs.getInt("vipRedpacketFlag"));
            }
            paramJsBridgeListener = new JSONObject();
            paramJsBridgeListener.put("result", 0);
            super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
            paramJsBridgeListener = paramString1;
          }
          catch (JSONException paramString3)
          {
            paramJsBridgeListener = paramString1;
          }
          if (QLog.isColorLevel())
          {
            QLog.e("IndividualRedPacketJsPlugin", 2, "Failed to setFlag:" + paramString3.getMessage());
            paramJsBridgeListener = paramString1;
          }
        }
        else
        {
          if (!"setRedPacketInfo".equals(paramString3)) {
            break;
          }
          paramJsBridgeListener = "rpWebSetRedpacketInfo";
          this.mReqBundle.clear();
          try
          {
            int i = paramVarArgs.optInt("redPacketId", -1);
            paramString1 = paramVarArgs.optString("redPacketText", null);
            this.mReqBundle.putInt("iRedPacketId", i);
            this.mReqBundle.putString("sRedPackRemard", paramString1);
            if (QLog.isColorLevel()) {
              QLog.d("IndividualRedPacketJsPlugin", 2, "setRedPacketInfo iRedPacketId = " + i + ";sRedPackRemard = " + paramString1);
            }
            paramString1 = new JSONObject();
            paramString1.put("result", 0);
            super.callJs(paramString2, new String[] { paramString1.toString() });
          }
          catch (Exception paramString1)
          {
            QLog.e("IndividualRedPacketJsPlugin", 2, "Failed to setRedPacketInfo:" + paramString1.getMessage());
          }
        }
      }
    } while (!"initTemplate".equals(paramString3));
    paramString1 = "rpWebInitTemplate";
    this.mReqBundle.clear();
    for (;;)
    {
      try
      {
        paramString3 = this.mReqBundle;
        if (!paramVarArgs.has("templateId")) {
          break label690;
        }
        paramJsBridgeListener = paramVarArgs.getString("templateId");
        paramString3.putString("templateId", paramJsBridgeListener);
        paramJsBridgeListener = paramString1;
      }
      catch (Exception paramString3)
      {
        paramJsBridgeListener = paramString1;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("IndividualRedPacketJsPlugin", 2, "Failed to initTemplate:" + paramString3.getMessage());
      paramJsBridgeListener = paramString1;
      break;
      label690:
      paramJsBridgeListener = "";
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mReqBundle = new Bundle();
    AppInterface localAppInterface = this.mRuntime.a();
    if ((localAppInterface instanceof BrowserAppInterface)) {
      this.browserApp = ((BrowserAppInterface)localAppInterface);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("IndividualRedPacketJsPlugin", 2, "ERROR!!! IndividualRedPacket market is not running in web process!");
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str1;
    String str2;
    JSONObject localJSONObject1;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key);
        str1 = paramBundle.getString("cmd");
        try
        {
          str2 = paramBundle.getString("callbackid");
          paramBundle = paramBundle.getBundle("response");
          localJSONObject1 = new JSONObject();
          if (!"rpWebGetBitmap".equals(str1)) {
            break;
          }
          localJSONObject1.put("code", paramBundle.getInt("result"));
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("templateId", paramBundle.getString("templateId"));
          localJSONObject2.put("content", paramBundle.getString("content"));
          localJSONObject2.put("bitmap", paramBundle.getString("bitmap"));
          localJSONObject1.put("data", localJSONObject2);
          super.callJs(str2, new String[] { localJSONObject1.toString() });
          return;
        }
        catch (Exception paramBundle) {}
      } while (!QLog.isColorLevel());
      QLog.e("IndividualRedPacketJsPlugin", 2, "Failed to handle cmd " + str1 + ", exception: " + paramBundle.getMessage());
      return;
    } while (!"rpWebInitTemplate".equals(str1));
    localJSONObject1.put("code", paramBundle.getInt("result"));
    super.callJs(str2, new String[] { localJSONObject1.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.IndividualRedPacketJsPlugin
 * JD-Core Version:    0.7.0.1
 */