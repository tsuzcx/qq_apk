package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.emosm.Client.OnRemoteRespObserver;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

class ChatBackgroundUiPlugin$1
  extends Client.OnRemoteRespObserver
{
  ChatBackgroundUiPlugin$1(ChatBackgroundUiPlugin paramChatBackgroundUiPlugin) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("cmd");
      if (QLog.isColorLevel()) {
        QLog.d("MessengerService", 2, new Object[] { "setbgjumpAIO:", "chatBgResp," + paramBundle });
      }
      if ((paramBundle != null) && (paramBundle.equals("chatbackground_setbg")))
      {
        paramBundle = this.this$0.mRuntime.a();
        if (paramBundle != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MessengerService", 2, new Object[] { "setbgjumpAIO:", "bgSetBackAio" });
          }
          Intent localIntent = new Intent();
          localIntent.setClass(BaseApplicationImpl.getApplication(), SplashActivity.class);
          localIntent.putExtra("tab_index", FrameControllerUtil.a);
          localIntent.addFlags(67108864);
          paramBundle.startActivity(localIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundUiPlugin.1
 * JD-Core Version:    0.7.0.1
 */