package com.tencent.mobileqq.guild.channel.create.fragment;

import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.qqguildsdk.callback.ICreateChannelCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

class QQGuildSubChannelCreateFragment$8
  implements ICreateChannelCallback
{
  QQGuildSubChannelCreateFragment$8(QQGuildSubChannelCreateFragment paramQQGuildSubChannelCreateFragment, String[] paramArrayOfString) {}
  
  public void a(int paramInt, String paramString, IGProChannelInfo paramIGProChannelInfo, IGProSecurityResult paramIGProSecurityResult)
  {
    QQGuildSubChannelCreateFragment localQQGuildSubChannelCreateFragment = this.b;
    QQGuildSubChannelCreateFragment.a(localQQGuildSubChannelCreateFragment, localQQGuildSubChannelCreateFragment.b.c, paramIGProChannelInfo, paramInt, paramString, paramIGProSecurityResult, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.fragment.QQGuildSubChannelCreateFragment.8
 * JD-Core Version:    0.7.0.1
 */