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
    if (QLog.isColorLevel()) {
      QLog.i("DailySignIn", 2, "method:" + paramString1 + ", json:" + paramString2);
    }
    callJs(paramString1, new String[] { paramString2 });
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("signIn"))) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          if (QLog.isColorLevel()) {
            QLog.i("DailySignIn", 2, "handleJsRequest url=" + paramString1 + " pkg=" + paramString2 + " method=" + paramString3);
          }
          bool1 = bool2;
        } while (!paramString2.equals("signIn"));
        bool1 = bool2;
      } while (!paramString3.equals("signedCallback"));
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
          if (QLog.isColorLevel()) {
            QLog.i("DailySignIn", 2, "handleJsRequest type=" + i + " result=" + j + " day=" + k);
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
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.i("DailySignIn", 2, "get bad result from web");
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DailySignIn", 2, "DailySignInWebviewPlugin onActivityResult,requestCode = " + paramByte + ", resultCode = " + paramInt + ", data = " + paramIntent);
    }
    if (paramInt != -1) {}
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    super.onResponse(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.DailySignInWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */