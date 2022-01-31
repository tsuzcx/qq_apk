package com.tencent.mobileqq.mini.appbrand.utils;

import aciy;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;

final class ShareUtils$1
  implements MiniAppController.ActivityResultListener
{
  ShareUtils$1(Activity paramActivity) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1010) && (paramInt2 == -1) && (this.val$activity != null) && (!this.val$activity.isFinishing()))
    {
      Intent localIntent = aciy.a(new Intent(this.val$activity, SplashActivity.class), null);
      Bundle localBundle = new Bundle();
      localBundle.putString("key_mini_report_event_action_type", "user_click");
      localBundle.putString("key_mini_report_event_sub_action_type", "custom_button");
      localBundle.putString("key_mini_report_event_reserves", "share_QQ");
      localBundle.putString("key_mini_report_event_reserves2", "success");
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_report_event", localBundle, null);
      if (paramIntent != null)
      {
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        this.val$activity.startActivity(localIntent);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.1
 * JD-Core Version:    0.7.0.1
 */