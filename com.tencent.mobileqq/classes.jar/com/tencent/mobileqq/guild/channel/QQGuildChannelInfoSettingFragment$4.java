package com.tencent.mobileqq.guild.channel;

import android.widget.TextView;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IGetVisibleMemberCountCallback;
import com.tencent.qphone.base.util.BaseApplication;

class QQGuildChannelInfoSettingFragment$4
  implements IGetVisibleMemberCountCallback
{
  QQGuildChannelInfoSettingFragment$4(QQGuildChannelInfoSettingFragment paramQQGuildChannelInfoSettingFragment, TextView paramTextView) {}
  
  public void onGetVisibleMemberCount(int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      QQGuildUtil.a(BaseApplication.getContext(), 2, paramString);
      this.a.setText("");
      return;
    }
    if (this.b.getContext() != null)
    {
      paramString = this.b.getString(2131890348, new Object[] { Integer.valueOf(paramInt2) });
      this.a.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelInfoSettingFragment.4
 * JD-Core Version:    0.7.0.1
 */