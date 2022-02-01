package com.tencent.mobileqq.guild.chatpie.helper;

import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;

class GuildInputBarHelper$2
  implements IResultWithSecurityCallback
{
  GuildInputBarHelper$2(GuildInputBarHelper paramGuildInputBarHelper) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    paramString = new StringBuilder();
    paramString.append("join guild success. guildId = ");
    paramString.append(this.a.a.S());
    QLog.d("GuildInputBarHelper", 1, paramString.toString());
    GuildInputBarHelper.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildInputBarHelper.2
 * JD-Core Version:    0.7.0.1
 */