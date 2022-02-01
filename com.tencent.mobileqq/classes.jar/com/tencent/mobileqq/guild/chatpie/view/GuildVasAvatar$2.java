package com.tencent.mobileqq.guild.chatpie.view;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.qphone.base.util.QLog;

class GuildVasAvatar$2
  extends AvatarObserver
{
  GuildVasAvatar$2(GuildVasAvatar paramGuildVasAvatar) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateCustomHead isSuccess: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", uin: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", tid:");
      localStringBuilder.append(GuildVasAvatar.a(this.a));
      QLog.d("GuildVasAvatar", 2, localStringBuilder.toString());
    }
    if ((GuildVasAvatar.b(this.a) != null) && (paramBoolean) && (TextUtils.equals(paramString, GuildVasAvatar.b(this.a).getCurrentAccountUin())))
    {
      paramString = this.a;
      paramString = GuildVasAvatar.a(paramString, GuildVasAvatar.a(paramString));
      this.a.setImageDrawable(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.view.GuildVasAvatar.2
 * JD-Core Version:    0.7.0.1
 */