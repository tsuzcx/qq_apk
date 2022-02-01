package com.tencent.qidian.plugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QidianWpaWebviewPlugin
  extends WebViewPlugin
  implements IPreCreatePluginChecker
{
  private BroadcastReceiver a = new QidianWpaWebviewPlugin.1(this);
  
  private void a(Bundle paramBundle)
  {
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      paramBundle = DataFactory.a("ipc_qidian_video_chat", "", 0, paramBundle);
      WebIPCOperator.a().a(paramBundle);
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("QidianWpaWebviewPlugin", 2, paramString2 + paramString3 + paramVarArgs[0]);
    }
    boolean bool1 = bool2;
    if (paramString2.equals("qidian"))
    {
      bool1 = bool2;
      if (!paramString3.equals("videochat")) {}
    }
    try
    {
      paramString3 = new JSONObject(paramVarArgs[0]);
      paramJsBridgeListener = paramString3.optString("request_type");
      paramString1 = paramString3.optString("uin");
      paramString2 = paramString3.optString("sigt");
      paramString3 = paramString3.optString("nickname");
      paramVarArgs = new Bundle();
      paramVarArgs.putString("request_type", paramJsBridgeListener);
      paramVarArgs.putString("uin", paramString1);
      paramVarArgs.putString("sigt", paramString2);
      paramVarArgs.putString("nickname", paramString3);
      a(paramVarArgs);
      bool1 = true;
    }
    catch (Exception paramJsBridgeListener)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("QidianWpaWebviewPlugin", 2, "handleJsRequest ", paramJsBridgeListener);
    }
    return bool1;
    return false;
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    return paramString1.contains("lbs.qidian.qq.com/authorize/voiceShow");
  }
  
  public void onCreate()
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity != null)
    {
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.qidian.openactionsheet");
      localActivity.registerReceiver(this.a, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
    }
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Activity localActivity = this.mRuntime.a();
    if (localActivity != null) {
      localActivity.unregisterReceiver(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.plugin.QidianWpaWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */