package com.tencent.mobileqq.mini.share;

import abtu;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import aqbc;
import bbga;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.launch.CmdCallback.Stub;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.ShareChatModel;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import org.json.JSONObject;

final class MiniProgramShareUtils$1
  extends CmdCallback.Stub
{
  MiniProgramShareUtils$1(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, JSONObject paramJSONObject, boolean paramBoolean, int paramInt1, int paramInt2, Activity paramActivity, int paramInt3, EntryModel paramEntryModel, ShareChatModel paramShareChatModel) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("MiniProgramShareUtils", 2, "onCmdResult() called with: succ = [" + paramBoolean + "], bundle = [" + paramBundle + "]");
    if (paramBoolean)
    {
      String str = this.val$arkContent;
      Object localObject = str;
      if (paramBundle != null)
      {
        localObject = str;
        if (paramBundle.containsKey("arkPath")) {
          localObject = MiniProgramShareUtils.updateImagePathToArkMeta(this.val$arkContent, paramBundle.getString("arkPath"));
        }
      }
      paramBundle = new Bundle();
      paramBundle.putBoolean("is_ark_display_share", true);
      paramBundle.putString("forward_ark_app_name", this.val$arkAppName);
      paramBundle.putString("forward_ark_app_view", this.val$arkViewId);
      paramBundle.putString("forward_ark_app_prompt", this.val$arkPrompt);
      paramBundle.putString("forward_ark_app_meta", (String)localObject);
      paramBundle.putString("forward_ark_app_ver", this.val$arkAppVersion);
      paramBundle.putString("forward_ark_app_config", this.val$finalArkConfigObject.toString());
      paramBundle.putBoolean("needShareCallBack", this.val$needShareCallback);
      if (this.val$shareType == 5) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramBundle.putBoolean("miniAppNeedOnlyPreview", paramBoolean);
        paramBundle.putInt("miniAppShareFrom", this.val$miniAppShareFrom);
        paramBundle.putAll(bbga.a(this.val$arkAppName, this.val$arkViewId, this.val$arkAppVersion, (String)localObject, this.val$activity.getResources().getDisplayMetrics().scaledDensity, null, null));
        paramBundle.putInt("forward_type", 27);
        paramBundle.putBoolean("forwardDirect", true);
        if (this.val$shareTarget != 6) {
          break;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
        ((Intent)localObject).putExtras(paramBundle);
        abtu.a(this.val$activity, (Intent)localObject, PublicTransFragmentActivity.class, MiniShareQuicklySendPanelFragment.class);
        return;
      }
      if (this.val$entryModel != null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_mini_report_event_action_type", "user_click");
        ((Bundle)localObject).putString("key_mini_report_event_sub_action_type", "custom_button");
        ((Bundle)localObject).putString("key_mini_report_event_reserves", "share_QQfast");
        ((Bundle)localObject).putString("key_mini_report_event_reserves2", "success");
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_report_event", (Bundle)localObject, null);
        MiniProgramShareUtils.shareToChatDirectly(this.val$activity, paramBundle, this.val$entryModel.type, String.valueOf(this.val$entryModel.uin), this.val$entryModel.name, -1, true);
        return;
      }
      if (this.val$shareChatModel != null)
      {
        MiniProgramShareUtils.shareToChatDirectly(this.val$activity, paramBundle, this.val$shareChatModel.type, String.valueOf(this.val$shareChatModel.uin), this.val$shareChatModel.name, -1, true);
        return;
      }
      localObject = new Intent(this.val$activity, ForwardRecentActivity.class);
      ((Intent)localObject).putExtras(paramBundle);
      if (this.val$miniAppShareFrom == 12)
      {
        aqbc.a(this.val$activity, (Intent)localObject, 100500, "applet");
        return;
      }
      aqbc.a(this.val$activity, (Intent)localObject);
      return;
    }
    if (this.val$shareType == 5)
    {
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_direct_share_fail", null, null);
      paramBundle = new Bundle();
      paramBundle.putString("key_mini_report_event_action_type", "user_click");
      switch (this.val$miniAppShareFrom)
      {
      }
    }
    for (;;)
    {
      paramBundle.putString("key_mini_report_event_reserves", "share_QQ");
      paramBundle.putString("key_mini_report_event_reserves2", "fail");
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_report_event", paramBundle, null);
      ThreadManagerV2.getUIHandlerV2().post(new MiniProgramShareUtils.1.1(this));
      return;
      if (!this.val$needShareCallback) {
        break;
      }
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_fail", null, null);
      break;
      paramBundle.putString("key_mini_report_event_sub_action_type", "more_about");
      continue;
      paramBundle.putString("key_mini_report_event_sub_action_type", "custom_button");
      continue;
      paramBundle.putString("key_mini_report_event_sub_action_type", "more_button");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniProgramShareUtils.1
 * JD-Core Version:    0.7.0.1
 */