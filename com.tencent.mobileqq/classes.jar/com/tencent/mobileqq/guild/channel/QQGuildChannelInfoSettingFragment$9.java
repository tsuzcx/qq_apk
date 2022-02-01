package com.tencent.mobileqq.guild.channel;

import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;

class QQGuildChannelInfoSettingFragment$9
  implements IResultWithSecurityCallback
{
  QQGuildChannelInfoSettingFragment$9(QQGuildChannelInfoSettingFragment paramQQGuildChannelInfoSettingFragment) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setChannelVisible: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramIGProSecurityResult);
    QLog.i("QQGuildChannelInfoSettingFragment", 4, localStringBuilder.toString());
    this.a.a(paramInt, paramString, paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelInfoSettingFragment.9
 * JD-Core Version:    0.7.0.1
 */