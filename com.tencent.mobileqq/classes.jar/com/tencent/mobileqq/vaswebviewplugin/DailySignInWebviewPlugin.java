package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import org.json.JSONException;
import org.json.JSONObject;

public class DailySignInWebviewPlugin
  extends VasWebviewJsPlugin
{
  public static final String ACTION_SIGN_IN = "action.userSignInForSettingMe";
  private static final String PLUGIN_METHOD_NAME = "signedCallback";
  public static final String PLUGIN_NAMESPACE = "signIn";
  public static final String TAG = "DailySignIn";
  
  public DailySignInWebviewPlugin()
  {
    this.mPluginNameSpace = "signIn";
  }
  
  public void callPJs(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("method:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", json:");
      localStringBuilder.append(paramString2);
      QLog.i("DailySignIn", 2, localStringBuilder.toString());
    }
    callJs(paramString1, new String[] { paramString2 });
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (paramString2 != null)
    {
      if (!paramString2.equalsIgnoreCase("signIn")) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append("handleJsRequest url=");
        paramJsBridgeListener.append(paramString1);
        paramJsBridgeListener.append(" pkg=");
        paramJsBridgeListener.append(paramString2);
        paramJsBridgeListener.append(" method=");
        paramJsBridgeListener.append(paramString3);
        QLog.i("DailySignIn", 2, paramJsBridgeListener.toString());
      }
      if ((paramString2.equals("signIn")) && (paramString3.equals("signedCallback")))
      {
        if (paramVarArgs.length >= 1) {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
            int i = paramJsBridgeListener.optInt("type");
            int j = paramJsBridgeListener.optInt("result");
            int k = paramJsBridgeListener.optInt("day");
            paramJsBridgeListener = new Bundle();
            paramJsBridgeListener.putInt("type", i);
            paramJsBridgeListener.putInt("result", j);
            paramJsBridgeListener.putInt("day", k);
            if (QLog.isColorLevel())
            {
              paramString1 = new StringBuilder();
              paramString1.append("handleJsRequest type=");
              paramString1.append(i);
              paramString1.append(" result=");
              paramString1.append(j);
              paramString1.append(" day=");
              paramString1.append(k);
              QLog.i("DailySignIn", 2, paramString1.toString());
            }
            QIPCClientHelper.getInstance().getClient().callServer("SignInModule", "action.userSignInForSettingMe", paramJsBridgeListener);
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            return true;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "get bad result from web");
        }
      }
      return true;
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DailySignInWebviewPlugin onActivityResult,requestCode = ");
      localStringBuilder.append(paramByte);
      localStringBuilder.append(", resultCode = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", data = ");
      localStringBuilder.append(paramIntent);
      QLog.d("DailySignIn", 2, localStringBuilder.toString());
    }
    if (paramInt != -1) {}
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    super.onResponse(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.DailySignInWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */