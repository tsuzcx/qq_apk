package com.tencent.mobileqq.guild.chatpie.helper;

import com.tencent.mobileqq.qqguildsdk.callback.ICheckUserBannedSpeakInChannelCallback;
import com.tencent.qphone.base.util.QLog;

class GuildInputBarHelper$5
  implements ICheckUserBannedSpeakInChannelCallback
{
  GuildInputBarHelper$5(GuildInputBarHelper paramGuildInputBarHelper) {}
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    String str = this.a.getTag();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkUserBannedSpeakInChannel onCheckCallback  result = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", errMsg = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", bannedSpeak = ");
    localStringBuilder.append(paramInt2);
    QLog.d(str, 4, localStringBuilder.toString());
    paramString = this.a;
    boolean bool;
    if (paramInt2 == 2) {
      bool = true;
    } else {
      bool = false;
    }
    paramString.a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildInputBarHelper.5
 * JD-Core Version:    0.7.0.1
 */