package com.tencent.mobileqq.guild.chatpie.helper;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;

class GuildGuestHelper$3$1
  implements IResultWithSecurityCallback
{
  GuildGuestHelper$3$1(GuildGuestHelper.3 param3) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    paramString = new StringBuilder();
    paramString.append("join guild success. guildId = ");
    paramString.append(GuildGuestHelper.a(this.a.a).O().c);
    QLog.d("GuildGuestHelper", 1, paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildGuestHelper.3.1
 * JD-Core Version:    0.7.0.1
 */