package com.tencent.mobileqq.guild.live.fragment.audience.module.subvideobar;

import android.content.Intent;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyFragment;
import com.tencent.mobileqq.guild.util.GuildLiveToast;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;

class QQGuildSubVideoBarLiveFragment$4$1
  implements Observer<QQLiveAnchorDataPrepare>
{
  QQGuildSubVideoBarLiveFragment$4$1(QQGuildSubVideoBarLiveFragment.4 param4) {}
  
  public void a(QQLiveAnchorDataPrepare paramQQLiveAnchorDataPrepare)
  {
    if (paramQQLiveAnchorDataPrepare != null)
    {
      if (paramQQLiveAnchorDataPrepare.isSuccess)
      {
        paramQQLiveAnchorDataPrepare = new Intent();
        QPublicFragmentActivity.Launcher.a(this.a.a.getContext(), paramQQLiveAnchorDataPrepare, QPublicFragmentActivity.class, LiveReadyFragment.class);
        QQGuildSubVideoBarLiveFragment.c(this.a.a, true);
        return;
      }
      if (paramQQLiveAnchorDataPrepare.errorMsg.originErrCode == 1010)
      {
        GuildLiveToast.a(2131890436);
        return;
      }
      GuildLiveToast.a(2131890435);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.subvideobar.QQGuildSubVideoBarLiveFragment.4.1
 * JD-Core Version:    0.7.0.1
 */