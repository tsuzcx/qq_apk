package com.tencent.mobileqq.guild.channel;

import android.content.res.Resources;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelTalkPermissionCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;

class QQGuildChannelInfoSettingFragment$7
  implements ISetChannelTalkPermissionCallback
{
  QQGuildChannelInfoSettingFragment$7(QQGuildChannelInfoSettingFragment paramQQGuildChannelInfoSettingFragment) {}
  
  public void a(int paramInt, IGProChannelInfo paramIGProChannelInfo, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if ((QQGuildUtil.a(paramIGProSecurityResult)) && (paramInt == 0))
    {
      paramString = this.a;
      paramString.o = paramIGProChannelInfo;
      QQGuildChannelInfoSettingFragment.b(paramString, paramIGProChannelInfo.getTalkPermission());
      paramIGProChannelInfo = this.a.getString(2131890336);
      if (this.a.getContext() != null) {
        QQToast.makeText(this.a.getContext(), 2, paramIGProChannelInfo, 0).show();
      }
    }
    else
    {
      QQGuildUtil.a(this.a.getContext(), 0, this.a.getResources().getString(2131890335), paramIGProSecurityResult);
    }
    QQGuildChannelInfoSettingFragment.d(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelInfoSettingFragment.7
 * JD-Core Version:    0.7.0.1
 */