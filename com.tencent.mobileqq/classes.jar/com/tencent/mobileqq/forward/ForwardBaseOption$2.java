package com.tencent.mobileqq.forward;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.av.share.api.IShareChatApi;
import com.tencent.mobileqq.adapter.QQGuildForwardSelectionGuildListAdapter;
import com.tencent.mobileqq.app.avgameshare.AVGameShareUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.util.Iterator;
import java.util.List;

class ForwardBaseOption$2
  implements DialogInterface.OnClickListener
{
  ForwardBaseOption$2(ForwardBaseOption paramForwardBaseOption) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QQGuildForwardSelectionGuildListAdapter.b();
    paramDialogInterface = this.a.T.iterator();
    while (paramDialogInterface.hasNext()) {
      ((ForwardBaseOption.EventListener)paramDialogInterface.next()).b(this.a);
    }
    boolean bool1 = this.a.t.getBoolean("needShareCallBack");
    paramInt = this.a.t.getInt("miniAppShareFrom");
    boolean bool2 = this.a.t.getBoolean("miniAppNeedOnlyPreview", false);
    if (bool2) {
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_direct_share_suc", null, null);
    } else if (bool1) {
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
    }
    ForwardBaseOption.a(this.a, paramInt);
    paramDialogInterface = this.a.t.getString("miniAppShareAppid");
    paramInt = this.a.t.getInt("miniAppShareAppType");
    int i = this.a.t.getInt("miniAppShareScene");
    int j = this.a.t.getInt("miniAppShareType");
    int k = this.a.t.getInt("uintype");
    String str = this.a.t.getString("uin");
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportShare(paramDialogInterface, paramInt, i, j, k, str);
    if (bool2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "deal OnClickListener return by needOnlyPreview");
      }
      return;
    }
    if (this.a.t.getBoolean("avgame_share_callback_key", false)) {
      AVGameShareUtil.a().a(this.a.s, true);
    }
    if (("com.tencent.qqavchat".equalsIgnoreCase(this.a.t.getString("forward_ark_app_name"))) && (!this.a.K()) && (((IShareChatApi)QRoute.api(IShareChatApi.class)).shareGAVArkMsg(this.a.q, this.a.t.getString("forward_ark_app_meta"), str, k)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "deal OnClickListener return by ark message");
      }
      return;
    }
    if (this.a.K())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "deal OnClickListener doing isMultiTarget2Send");
      }
      if (!this.a.O()) {
        ForwardBaseOption.b(this.a);
      } else if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "deal OnClickListener doing nothing from isMultiTarget2Send");
      }
    }
    else if (!ForwardBaseOption.a(this.a, paramDialogInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "sendToSingleTarget return false");
      }
      return;
    }
    if ((this.a.t != null) && (this.a.t.getBoolean("k_forward_show_direct_share_tips", false))) {
      ReportController.b(this.a.q, "dc00898", "", "", "0X800A4A2", "0X800A4A2", 0, 0, "0", "", "", "");
    }
    ForwardBaseOption.c(this.a);
    if ("caller_aecamera".equals(this.a.Q)) {
      ForwardBaseOption.d(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption.2
 * JD-Core Version:    0.7.0.1
 */