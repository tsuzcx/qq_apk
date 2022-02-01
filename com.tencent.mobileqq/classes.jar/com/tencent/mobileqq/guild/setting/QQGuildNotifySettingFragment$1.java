package com.tencent.mobileqq.guild.setting;

import android.view.View;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QQGuildNotifySettingFragment$1
  implements ActionSheet.OnButtonClickListener
{
  QQGuildNotifySettingFragment$1(QQGuildNotifySettingFragment paramQQGuildNotifySettingFragment, IGProChannelInfo paramIGProChannelInfo) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        QQGuildNotifySettingFragment.a(this.b, this.a, 3);
        return;
      }
      QQGuildNotifySettingFragment.a(this.b, this.a, 2);
      return;
    }
    QQGuildNotifySettingFragment.a(this.b, this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildNotifySettingFragment.1
 * JD-Core Version:    0.7.0.1
 */