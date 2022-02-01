package com.tencent.qidian.plugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
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
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramBundle);
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append(paramString3);
      paramJsBridgeListener.append(paramVarArgs[0]);
      QLog.d("QidianWpaWebviewPlugin", 2, paramJsBridgeListener.toString());
    }
    if ((paramString2.equals("qidian")) && (paramString3.equals("videochat"))) {
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
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QidianWpaWebviewPlugin", 2, "handleJsRequest ", paramJsBridgeListener);
        }
      }
    }
    return false;
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    return paramString1.contains("lbs.qidian.qq.com/authorize/voiceShow");
  }
  
  protected void onCreate()
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity != null)
    {
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.qidian.openactionsheet");
      localActivity.registerReceiver(this.a, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
    }
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Activity localActivity = this.mRuntime.a();
    if (localActivity != null) {
      localActivity.unregisterReceiver(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.plugin.QidianWpaWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */