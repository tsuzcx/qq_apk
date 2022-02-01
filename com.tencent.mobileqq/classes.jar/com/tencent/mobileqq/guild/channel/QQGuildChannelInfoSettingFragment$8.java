package com.tencent.mobileqq.guild.channel;

import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.guild.privatechannel.GuildPrivateSelectMemberFragment;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.HashMap;
import java.util.Map;

class QQGuildChannelInfoSettingFragment$8
  implements ActionSheet.OnButtonClickListener
{
  QQGuildChannelInfoSettingFragment$8(QQGuildChannelInfoSettingFragment paramQQGuildChannelInfoSettingFragment) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if ((paramInt == 2) && (this.a.o.getVisibleType() != 2)) {
          GuildPrivateSelectMemberFragment.a(this.a.getActivity(), this.a.l(), this.a.o.getGuildId(), String.format(this.a.getResources().getString(2131890533), new Object[] { this.a.o.getChannelName().toString() }), 0, null, null, true, 1);
        }
      }
      else {
        QQGuildChannelInfoSettingFragment.c(this.a, 1);
      }
    }
    else {
      QQGuildChannelInfoSettingFragment.c(this.a, 0);
    }
    if ((paramInt >= 0) && (paramInt <= 2))
    {
      paramView = new HashMap();
      paramView.put("sgrp_channel_set_op_result", Integer.valueOf(paramInt + 1));
      QQGuildChannelInfoSettingFragment localQQGuildChannelInfoSettingFragment = this.a;
      QQGuildChannelInfoSettingFragment.a(localQQGuildChannelInfoSettingFragment, QQGuildChannelInfoSettingFragment.e(localQQGuildChannelInfoSettingFragment).getRootView(), "em_sgrp_channel_set_access", paramView);
    }
    QQGuildChannelInfoSettingFragment.e(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelInfoSettingFragment.8
 * JD-Core Version:    0.7.0.1
 */