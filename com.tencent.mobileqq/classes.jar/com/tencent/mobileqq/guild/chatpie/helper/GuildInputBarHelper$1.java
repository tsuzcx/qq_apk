package com.tencent.mobileqq.guild.chatpie.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;

class GuildInputBarHelper$1
  extends GPServiceObserver
{
  GuildInputBarHelper$1(GuildInputBarHelper paramGuildInputBarHelper) {}
  
  protected void a(IGProGuildInfo paramIGProGuildInfo)
  {
    if ((paramIGProGuildInfo != null) && (!TextUtils.isEmpty(paramIGProGuildInfo.getGuildID())) && (paramIGProGuildInfo.getGuildID().equals(this.a.a.S()))) {
      GuildInputBarHelper.b(this.a);
    }
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    paramString3 = this.a.getTag();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSelfBannedSpeakChange currChannelInfo = ");
    localStringBuilder.append(GuildInputBarHelper.a(this.a));
    localStringBuilder.append("action: ");
    localStringBuilder.append(paramInt);
    QLog.d(paramString3, 4, localStringBuilder.toString());
    if (GuildInputBarHelper.a(this.a) == null) {
      return;
    }
    if ((TextUtils.equals(GuildInputBarHelper.a(this.a).getGuildId(), paramString1)) && (TextUtils.equals(GuildInputBarHelper.a(this.a).getChannelUin(), paramString2)))
    {
      paramString1 = this.a;
      boolean bool = true;
      if (paramInt != 1) {
        bool = false;
      }
      paramString1.a(bool);
    }
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (GuildInputBarHelper.a(this.a) == null) {
      return;
    }
    if (TextUtils.equals(GuildInputBarHelper.a(this.a).getGuildId(), paramString1)) {
      GuildInputBarHelper.b(this.a);
    }
  }
  
  protected void e(String paramString)
  {
    if (GuildInputBarHelper.a(this.a) == null) {
      return;
    }
    if (TextUtils.equals(GuildInputBarHelper.a(this.a).getChannelUin(), paramString)) {
      GuildInputBarHelper.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildInputBarHelper.1
 * JD-Core Version:    0.7.0.1
 */