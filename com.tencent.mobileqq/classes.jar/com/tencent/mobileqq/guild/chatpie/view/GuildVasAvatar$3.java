package com.tencent.mobileqq.guild.chatpie.view;

import android.text.TextUtils;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class GuildVasAvatar$3
  extends CardObserver
{
  GuildVasAvatar$3(GuildVasAvatar paramGuildVasAvatar) {}
  
  protected void onUpdateAvatar(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateAvatar: uin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", success :");
      localStringBuilder.append(paramBoolean);
      QLog.d("GuildVasAvatar", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (GuildVasAvatar.b(this.a) != null) && (TextUtils.equals(paramString, GuildVasAvatar.b(this.a).getCurrentAccountUin())))
    {
      paramString = this.a;
      paramString = GuildVasAvatar.a(paramString, GuildVasAvatar.a(paramString));
      this.a.setImageDrawable(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.view.GuildVasAvatar.3
 * JD-Core Version:    0.7.0.1
 */