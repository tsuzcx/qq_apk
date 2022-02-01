package com.tencent.mobileqq.intimate;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.util.Locale;
import org.json.JSONObject;

public class IntimatePlugin
  extends WebViewPlugin
{
  public IntimatePlugin()
  {
    this.mPluginNameSpace = "emojiEggSetting";
  }
  
  private void a(int paramInt, String... paramVarArgs)
  {
    try
    {
      Activity localActivity = this.mRuntime.a();
      paramVarArgs = new JSONObject(paramVarArgs[0]).optString("frd_uin");
      if (!TextUtils.isEmpty(paramVarArgs))
      {
        Intent localIntent = AIOUtils.a(new Intent(localActivity, SplashActivity.class), new int[] { 2 });
        localIntent.putExtra("uin", paramVarArgs);
        if (paramInt == 1) {
          localIntent.putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
        }
        for (;;)
        {
          localIntent.putExtra("uintype", 0);
          localActivity.startActivity(localIntent);
          return;
          if (paramInt == 2) {
            localIntent.putExtra("KEY_SHOULD_SHOW_PLUS_PANEL", true);
          }
        }
      }
      return;
    }
    catch (Exception paramVarArgs)
    {
      QLog.e("IntimatePlugin", 1, "gotoC2C exception e = ", paramVarArgs);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = new JSONObject(paramString2).optBoolean("statue", true);
      paramString2 = new Bundle();
      paramString2.putBoolean("key_web_mutual_mark_switch_status", bool);
      QLog.i("IntimatePlugin", 1, "change mutualmark switch, method = " + paramString1 + ", statue = " + bool);
      QIPCClientHelper.getInstance().getClient().callServer("IntimateQIPCModule", "key_web_change_switch_request", paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("IntimatePlugin", 1, "change mutualmark switch exception e = ", paramString1);
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimatePlugin", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", new Object[] { paramString1, paramString2, paramString3, paramVarArgs }));
    }
    if ("emojiEggSetting".equals(paramString2)) {
      if (!"showVC".equals(paramString3)) {}
    }
    for (;;)
    {
      int i;
      try
      {
        i = new JSONObject(paramVarArgs[0]).optInt("entry");
        paramJsBridgeListener = new Bundle();
        paramJsBridgeListener.putInt("key_web_jump_show_reactive_entry_value", i);
        if (QLog.isColorLevel()) {
          QLog.i("IntimatePlugin", 2, "showVC, method = " + paramString3 + ", entry = " + i);
        }
        QIPCClientHelper.getInstance().getClient().callServer("IntimateQIPCModule", "key_web_jump_show_reactive_request", paramJsBridgeListener);
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        QLog.e("IntimatePlugin", 1, "openConfessAIO exception e = ", paramJsBridgeListener);
        return false;
      }
      if (!"changeSwitch".equals(paramString3)) {
        break label345;
      }
      a(paramString3, paramVarArgs[0]);
      return true;
      if ("interactionScore".equals(paramString2))
      {
        if ("gotoChat".equals(paramString3))
        {
          a(1, paramVarArgs);
          return true;
        }
        if ("gotoCall".equals(paramString3))
        {
          a(2, paramVarArgs);
          return true;
        }
        if (!"saveConnectionsSwitch".equals(paramString3)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("IntimatePlugin", 2, "IntimatePlugin: METHOD_SAVE_CONNECTIONS_SWITCH called");
        }
        try
        {
          paramJsBridgeListener = this.mRuntime.a();
          if (paramJsBridgeListener != null)
          {
            i = new JSONObject(paramVarArgs[0]).optInt("flag");
            paramJsBridgeListener.getApp().getSharedPreferences("mayknow_connections_switch", 4).edit().putInt("key_mayknow_connections_switch", i).commit();
            return true;
          }
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.e("IntimatePlugin", 2, "IntimatePlugin: METHOD_SAVE_CONNECTIONS_SWITCH called exception");
          return true;
        }
      }
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
    label345:
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intimate.IntimatePlugin
 * JD-Core Version:    0.7.0.1
 */