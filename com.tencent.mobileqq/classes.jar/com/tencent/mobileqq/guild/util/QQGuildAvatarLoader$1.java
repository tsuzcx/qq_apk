package com.tencent.mobileqq.guild.util;

import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class QQGuildAvatarLoader$1
  extends GPServiceObserver
{
  QQGuildAvatarLoader$1(QQGuildAvatarLoader paramQQGuildAvatarLoader) {}
  
  protected void a(String paramString, GuildUserAvatar paramGuildUserAvatar)
  {
    super.a(paramString, paramGuildUserAvatar);
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildAvatarLoader", 2, new Object[] { "onGetUserAvatarUrl: ", paramString, " avatarUrl:", paramGuildUserAvatar.c() });
    }
    synchronized (this.a)
    {
      QQGuildAvatarLoader.a(this.a).put(paramString, paramGuildUserAvatar);
      Iterator localIterator = QQGuildAvatarLoader.b(this.a).iterator();
      while (localIterator.hasNext()) {
        ((QQGuildAvatarLoader.OnAvatarLoadListener)localIterator.next()).a(paramString, paramGuildUserAvatar);
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQGuildAvatarLoader.1
 * JD-Core Version:    0.7.0.1
 */