package com.tencent.mobileqq.guild.channel;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QQGuildChannelInfoSettingFragment$10
  implements ActionSheet.OnButtonClickListener
{
  QQGuildChannelInfoSettingFragment$10(QQGuildChannelInfoSettingFragment paramQQGuildChannelInfoSettingFragment, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (QQGuildChannelInfoSettingFragment.f(this.b)) {
      QQGuildChannelInfoSettingFragment.g(this.b);
    } else {
      QQGuildChannelInfoSettingFragment.h(this.b);
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelInfoSettingFragment.10
 * JD-Core Version:    0.7.0.1
 */