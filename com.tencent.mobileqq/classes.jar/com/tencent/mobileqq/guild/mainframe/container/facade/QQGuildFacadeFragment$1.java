package com.tencent.mobileqq.guild.mainframe.container.facade;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.message.GuildGuestObserver;

class QQGuildFacadeFragment$1
  extends GuildGuestObserver
{
  QQGuildFacadeFragment$1(QQGuildFacadeFragment paramQQGuildFacadeFragment) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((QQGuildFacadeFragment.a(this.a) != null) && (!TextUtils.isEmpty(QQGuildFacadeFragment.a(this.a).b)))
    {
      if (!QQGuildFacadeFragment.a(this.a).b.equals(paramString)) {
        return;
      }
      if (paramBoolean)
      {
        QQGuildFacadeFragment.b(this.a);
        return;
      }
      QQGuildFacadeFragment.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.facade.QQGuildFacadeFragment.1
 * JD-Core Version:    0.7.0.1
 */