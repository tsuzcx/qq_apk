package com.tencent.mobileqq.guild.mainframe.container.facade;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.setting.popup.GuildMainSettingDialogFragment;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;

class GuildFacadeTopFrameController$2
  extends GPServiceObserver
{
  GuildFacadeTopFrameController$2(GuildFacadeTopFrameController paramGuildFacadeTopFrameController) {}
  
  protected void a(String paramString)
  {
    super.a(paramString);
    if (TextUtils.equals(paramString, this.a.b.b))
    {
      GuildFacadeTopFrameController.b(this.a);
      if (GuildFacadeTopFrameController.c(this.a) != null)
      {
        GuildFacadeTopFrameController.c(this.a).dismiss();
        GuildFacadeTopFrameController.a(this.a, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.facade.GuildFacadeTopFrameController.2
 * JD-Core Version:    0.7.0.1
 */