package com.tencent.mobileqq.guild.channel;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.HashMap;
import java.util.Map;

class QQGuildChannelInfoSettingFragment$6
  implements ActionSheet.OnButtonClickListener
{
  QQGuildChannelInfoSettingFragment$6(QQGuildChannelInfoSettingFragment paramQQGuildChannelInfoSettingFragment) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        QQGuildChannelInfoSettingFragment.a(this.a, 2);
      }
    }
    else {
      QQGuildChannelInfoSettingFragment.a(this.a, 1);
    }
    if ((paramInt >= 0) && (paramInt <= 1))
    {
      paramView = new HashMap();
      paramView.put("sgrp_channel_set_op_result", Integer.valueOf(paramInt + 1));
      QQGuildChannelInfoSettingFragment localQQGuildChannelInfoSettingFragment = this.a;
      QQGuildChannelInfoSettingFragment.a(localQQGuildChannelInfoSettingFragment, QQGuildChannelInfoSettingFragment.d(localQQGuildChannelInfoSettingFragment).getRootView(), "em_sgrp_channel_set_speak", paramView);
    }
    QQGuildChannelInfoSettingFragment.d(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelInfoSettingFragment.6
 * JD-Core Version:    0.7.0.1
 */