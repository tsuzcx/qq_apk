package com.tencent.mobileqq.guild.chatpie.view;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;

class GuildVasAvatar$1
  extends GPServiceObserver
{
  GuildVasAvatar$1(GuildVasAvatar paramGuildVasAvatar) {}
  
  protected void a(String paramString, GuildUserAvatar paramGuildUserAvatar)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetUserAvatarUrl： ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", avatarUrl: ");
      String str;
      if (paramGuildUserAvatar != null) {
        str = paramGuildUserAvatar.c();
      } else {
        str = "";
      }
      localStringBuilder.append(str);
      QLog.d("GuildVasAvatar", 2, localStringBuilder.toString());
    }
    if (paramString.equals(GuildVasAvatar.a(this.a)))
    {
      paramString = ((IQQGuildAvatarApi)GuildVasAvatar.b(this.a).getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(GuildVasAvatar.b(this.a), paramGuildUserAvatar, 0);
      this.a.setImageDrawable(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.view.GuildVasAvatar.1
 * JD-Core Version:    0.7.0.1
 */