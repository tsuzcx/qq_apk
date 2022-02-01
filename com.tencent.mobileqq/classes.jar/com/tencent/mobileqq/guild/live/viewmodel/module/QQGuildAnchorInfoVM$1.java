package com.tencent.mobileqq.guild.live.viewmodel.module;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;

class QQGuildAnchorInfoVM$1
  extends GPServiceObserver
{
  QQGuildAnchorInfoVM$1(QQGuildAnchorInfoVM paramQQGuildAnchorInfoVM) {}
  
  protected void a(IGProGuildInfo paramIGProGuildInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QGL.QQGuildAnchorInfoVM", 1, "onAddGuildWithInfo.");
    }
    QQGuildAnchorInfoVM.c(this.a);
  }
  
  protected void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QGL.QQGuildAnchorInfoVM", 1, "onBeKickFromGuild.");
    }
    QQGuildAnchorInfoVM.c(this.a);
  }
  
  protected void a(String paramString, GuildUserAvatar paramGuildUserAvatar)
  {
    if (TextUtils.equals(QQGuildAnchorInfoVM.a(this.a), paramString)) {
      QQGuildAnchorInfoVM.a(this.a, paramString);
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if ((QQGuildAnchorInfoVM.b(this.a)) && (TextUtils.equals(QQGuildAnchorInfoVM.a(this.a), paramString1))) {
      QQGuildAnchorInfoVM.b(this.a, paramString2);
    }
  }
  
  protected void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QGL.QQGuildAnchorInfoVM", 1, "onRemoveGuild.");
    }
    QQGuildAnchorInfoVM.c(this.a);
  }
  
  protected void g(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QGL.QQGuildAnchorInfoVM", 1, "onAddGuildNotInfo.");
    }
    QQGuildAnchorInfoVM.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.viewmodel.module.QQGuildAnchorInfoVM.1
 * JD-Core Version:    0.7.0.1
 */