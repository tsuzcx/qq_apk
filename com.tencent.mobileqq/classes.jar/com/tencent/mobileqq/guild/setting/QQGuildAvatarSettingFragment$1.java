package com.tencent.mobileqq.guild.setting;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;

class QQGuildAvatarSettingFragment$1
  extends GPServiceObserver
{
  QQGuildAvatarSettingFragment$1(QQGuildAvatarSettingFragment paramQQGuildAvatarSettingFragment) {}
  
  protected void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(QQGuildAvatarSettingFragment.a(this.a))))
    {
      if (!TextUtils.equals(QQGuildAvatarSettingFragment.a(this.a), paramString)) {
        return;
      }
      super.a(paramString);
      if (this.a.a() != null)
      {
        QQGuildAvatarSettingFragment localQQGuildAvatarSettingFragment = this.a;
        QQGuildAvatarSettingFragment.a(localQQGuildAvatarSettingFragment, ((IGPSService)localQQGuildAvatarSettingFragment.a().getRuntimeService(IGPSService.class, "")).getGuildInfo(paramString));
        paramString = this.a;
        QQGuildAvatarSettingFragment.b(paramString, QQGuildAvatarSettingFragment.b(paramString));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildAvatarSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */