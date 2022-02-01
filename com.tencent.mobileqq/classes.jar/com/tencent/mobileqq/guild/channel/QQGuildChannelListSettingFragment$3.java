package com.tencent.mobileqq.guild.channel;

import android.content.res.Resources;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IGetChannelCategoryCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class QQGuildChannelListSettingFragment$3
  implements IGetChannelCategoryCallback
{
  QQGuildChannelListSettingFragment$3(QQGuildChannelListSettingFragment paramQQGuildChannelListSettingFragment) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult)))
    {
      this.a.j();
      return;
    }
    String str = this.a.getResources().getString(2131890335);
    QQGuildUtil.a(BaseApplication.getContext(), paramInt, str, paramIGProSecurityResult);
    paramIGProSecurityResult = new StringBuilder();
    paramIGProSecurityResult.append("setChannelCategoryInfo failed. code=");
    paramIGProSecurityResult.append(paramInt);
    paramIGProSecurityResult.append(" msg=");
    paramIGProSecurityResult.append(paramString);
    QLog.w("QQGuildChannelListSettingFragment", 1, paramIGProSecurityResult.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelListSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */