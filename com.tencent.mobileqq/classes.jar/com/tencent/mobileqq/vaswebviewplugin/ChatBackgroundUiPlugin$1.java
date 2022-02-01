package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import ascz;
import bifw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.qphone.base.util.QLog;

class ChatBackgroundUiPlugin$1
  extends ascz
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
          localIntent.putExtra("tab_index", MainFragment.b);
          localIntent.addFlags(67108864);
          paramBundle.startActivity(localIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundUiPlugin.1
 * JD-Core Version:    0.7.0.1
 */