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
      Activity localActivity = this.mRuntime.d();
      paramVarArgs = new JSONObject(paramVarArgs[0]).optString("frd_uin");
      if (!TextUtils.isEmpty(paramVarArgs))
      {
        Intent localIntent = AIOUtils.a(new Intent(localActivity, SplashActivity.class), new int[] { 2 });
        localIntent.putExtra("uin", paramVarArgs);
        if (paramInt == 1) {
          localIntent.putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
        } else if (paramInt == 2) {
          localIntent.putExtra("KEY_SHOULD_SHOW_PLUS_PANEL", true);
        }
        localIntent.putExtra("uintype", 0);
        localActivity.startActivity(localIntent);
        return;
      }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("change mutualmark switch, method = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", statue = ");
      localStringBuilder.append(bool);
      QLog.i("IntimatePlugin", 1, localStringBuilder.toString());
      QIPCClientHelper.getInstance().getClient().callServer("IntimateQIPCModule", "key_web_change_switch_request", paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("IntimatePlugin", 1, "change mutualmark switch exception e = ", paramString1);
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = true;
    if (bool1) {
      QLog.d("IntimatePlugin", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", new Object[] { paramString1, paramString2, paramString3, paramVarArgs }));
    }
    int i;
    if ("emojiEggSetting".equals(paramString2))
    {
      if ("showVC".equals(paramString3))
      {
        try
        {
          i = new JSONObject(paramVarArgs[0]).optInt("entry");
          paramJsBridgeListener = new Bundle();
          paramJsBridgeListener.putInt("key_web_jump_show_reactive_entry_value", i);
          if (QLog.isColorLevel())
          {
            paramString1 = new StringBuilder();
            paramString1.append("showVC, method = ");
            paramString1.append(paramString3);
            paramString1.append(", entry = ");
            paramString1.append(i);
            QLog.i("IntimatePlugin", 2, paramString1.toString());
          }
          QIPCClientHelper.getInstance().getClient().callServer("IntimateQIPCModule", "key_web_jump_show_reactive_request", paramJsBridgeListener);
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.e("IntimatePlugin", 1, "openConfessAIO exception e = ", paramJsBridgeListener);
        }
      }
      else if ("changeSwitch".equals(paramString3))
      {
        a(paramString3, paramVarArgs[0]);
        return true;
      }
      return false;
    }
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
      bool1 = bool2;
      if (!"saveConnectionsSwitch".equals(paramString3)) {
        break label373;
      }
      if (QLog.isColorLevel()) {
        QLog.d("IntimatePlugin", 2, "IntimatePlugin: METHOD_SAVE_CONNECTIONS_SWITCH called");
      }
    }
    try
    {
      paramJsBridgeListener = this.mRuntime.b();
      bool1 = bool2;
      if (paramJsBridgeListener == null) {
        break label373;
      }
      i = new JSONObject(paramVarArgs[0]).optInt("flag");
      paramJsBridgeListener.getApp().getSharedPreferences("mayknow_connections_switch", 4).edit().putInt("key_mayknow_connections_switch", i).commit();
      return true;
    }
    catch (Exception paramJsBridgeListener)
    {
      label349:
      break label349;
    }
    QLog.e("IntimatePlugin", 2, "IntimatePlugin: METHOD_SAVE_CONNECTIONS_SWITCH called exception");
    return true;
    bool1 = super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
    label373:
    return bool1;
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intimate.IntimatePlugin
 * JD-Core Version:    0.7.0.1
 */