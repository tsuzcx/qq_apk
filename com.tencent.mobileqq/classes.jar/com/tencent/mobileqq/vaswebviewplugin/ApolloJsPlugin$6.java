package com.tencent.mobileqq.vaswebviewplugin;

import ancm;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import angn;
import bhod;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.VipUtils;

class ApolloJsPlugin$6
  implements DialogInterface.OnClickListener
{
  ApolloJsPlugin$6(ApolloJsPlugin paramApolloJsPlugin, int paramInt1, int paramInt2, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new angn();
    paramDialogInterface.a = this.val$gameId;
    paramDialogInterface.c = this.val$gameMode;
    ancm.a(paramDialogInterface, this.this$0.mRuntime.a(), 2);
    if ((this.val$activity instanceof BaseActivity)) {
      VipUtils.a(((BaseActivity)this.val$activity).getAppInterface(), "cmshow", "Apollo", "game_alert_join", 3, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */