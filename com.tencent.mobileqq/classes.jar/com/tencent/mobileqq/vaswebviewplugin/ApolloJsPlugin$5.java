package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel.GameMsgInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;

class ApolloJsPlugin$5
  implements DialogInterface.OnClickListener
{
  ApolloJsPlugin$5(ApolloJsPlugin paramApolloJsPlugin, int paramInt1, int paramInt2, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new ApolloPanel.GameMsgInfo();
    paramDialogInterface.e = this.val$gameId;
    paramDialogInterface.g = this.val$gameMode;
    ApolloGameBasicEventUtil.a(paramDialogInterface, this.this$0.mRuntime.a(), 2);
    if ((this.val$activity instanceof BaseActivity)) {
      VipUtils.a(((BaseActivity)this.val$activity).getAppInterface(), "cmshow", "Apollo", "game_alert_join", 3, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */