package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
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
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest, url=");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append(", pkgName=");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append(", methodName=");
      paramJsBridgeListener.append(paramString3);
      QLog.d("IndividualRedPacketJsPlugin", 2, paramJsBridgeListener.toString());
    }
    if ((paramString1 != null) && ("individualRedPacket".equals(paramString2)))
    {
      if (paramString3 == null) {
        return false;
      }
      paramVarArgs = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (paramVarArgs == null) {
        return true;
      }
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append("handleJsRequest JSON = ");
        paramJsBridgeListener.append(paramVarArgs.toString());
        QLog.d("IndividualRedPacketJsPlugin", 2, paramJsBridgeListener.toString());
      }
      paramString2 = paramVarArgs.optString("callback");
      if (TextUtils.isEmpty(paramString2))
      {
        QLog.e("IndividualRedPacketJsPlugin", 1, "callback id is null, so return");
        return true;
      }
      boolean bool = "getBitmap".equals(paramString3);
      paramString1 = "";
      if (bool)
      {
        this.mReqBundle.clear();
        try
        {
          this.mReqBundle.putString("templateId", paramVarArgs.getString("templateId"));
          this.mReqBundle.putString("content", paramVarArgs.getString("content"));
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (QLog.isColorLevel())
          {
            paramString1 = new StringBuilder();
            paramString1.append("Failed to getBitmap:");
            paramString1.append(paramJsBridgeListener.getMessage());
            QLog.e("IndividualRedPacketJsPlugin", 2, paramString1.toString());
          }
        }
        paramJsBridgeListener = "rpWebGetBitmap";
      }
      else if ("setFlag".equals(paramString3))
      {
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
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (QLog.isColorLevel())
          {
            paramString1 = new StringBuilder();
            paramString1.append("Failed to setFlag:");
            paramString1.append(paramJsBridgeListener.getMessage());
            QLog.e("IndividualRedPacketJsPlugin", 2, paramString1.toString());
          }
        }
        paramJsBridgeListener = "rpWebSetFlags";
      }
      else if ("setRedPacketInfo".equals(paramString3))
      {
        this.mReqBundle.clear();
        try
        {
          int i = paramVarArgs.optInt("redPacketId", -1);
          paramJsBridgeListener = paramVarArgs.optString("redPacketText", null);
          this.mReqBundle.putInt("iRedPacketId", i);
          this.mReqBundle.putString("sRedPackRemard", paramJsBridgeListener);
          if (QLog.isColorLevel())
          {
            paramString1 = new StringBuilder();
            paramString1.append("setRedPacketInfo iRedPacketId = ");
            paramString1.append(i);
            paramString1.append(";sRedPackRemard = ");
            paramString1.append(paramJsBridgeListener);
            QLog.d("IndividualRedPacketJsPlugin", 2, paramString1.toString());
          }
          paramJsBridgeListener = new JSONObject();
          paramJsBridgeListener.put("result", 0);
          super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
        }
        catch (Exception paramJsBridgeListener)
        {
          paramString1 = new StringBuilder();
          paramString1.append("Failed to setRedPacketInfo:");
          paramString1.append(paramJsBridgeListener.getMessage());
          QLog.e("IndividualRedPacketJsPlugin", 2, paramString1.toString());
        }
        paramJsBridgeListener = "rpWebSetRedpacketInfo";
      }
      else
      {
        paramJsBridgeListener = paramString1;
        if ("initTemplate".equals(paramString3))
        {
          this.mReqBundle.clear();
          try
          {
            paramJsBridgeListener = this.mReqBundle;
            if (paramVarArgs.has("templateId")) {
              paramString1 = paramVarArgs.getString("templateId");
            }
            paramJsBridgeListener.putString("templateId", paramString1);
          }
          catch (Exception paramJsBridgeListener)
          {
            if (QLog.isColorLevel())
            {
              paramString1 = new StringBuilder();
              paramString1.append("Failed to initTemplate:");
              paramString1.append(paramJsBridgeListener.getMessage());
              QLog.e("IndividualRedPacketJsPlugin", 2, paramString1.toString());
            }
          }
          paramJsBridgeListener = "rpWebInitTemplate";
        }
      }
      super.sendRemoteReq(DataFactory.a(paramJsBridgeListener, paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return true;
    }
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.mReqBundle = new Bundle();
    AppInterface localAppInterface = this.mRuntime.b();
    if ((localAppInterface instanceof BrowserAppInterface))
    {
      this.browserApp = ((BrowserAppInterface)localAppInterface);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("IndividualRedPacketJsPlugin", 2, "ERROR!!! IndividualRedPacket market is not running in web process!");
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key)
    {
      String str = paramBundle.getString("cmd");
      try
      {
        localObject = paramBundle.getString("callbackid");
        paramBundle = paramBundle.getBundle("response");
        JSONObject localJSONObject1 = new JSONObject();
        boolean bool = "rpWebGetBitmap".equals(str);
        if (bool)
        {
          localJSONObject1.put("code", paramBundle.getInt("result"));
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("templateId", paramBundle.getString("templateId"));
          localJSONObject2.put("content", paramBundle.getString("content"));
          localJSONObject2.put("bitmap", paramBundle.getString("bitmap"));
          localJSONObject1.put("data", localJSONObject2);
          super.callJs((String)localObject, new String[] { localJSONObject1.toString() });
          return;
        }
        if ("rpWebInitTemplate".equals(str))
        {
          localJSONObject1.put("code", paramBundle.getInt("result"));
          super.callJs((String)localObject, new String[] { localJSONObject1.toString() });
          return;
        }
      }
      catch (Exception paramBundle)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Failed to handle cmd ");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(", exception: ");
          ((StringBuilder)localObject).append(paramBundle.getMessage());
          QLog.e("IndividualRedPacketJsPlugin", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.IndividualRedPacketJsPlugin
 * JD-Core Version:    0.7.0.1
 */