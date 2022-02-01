package com.tencent.mobileqq.guild.chatpie.helper;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;

class GuildTitleBarHelper$1
  extends GPServiceObserver
{
  GuildTitleBarHelper$1(GuildTitleBarHelper paramGuildTitleBarHelper) {}
  
  protected void a(String paramString)
  {
    if (GuildTitleBarHelper.a(this.a).S() != null)
    {
      if (!GuildTitleBarHelper.a(this.a).S().equals(paramString)) {
        return;
      }
      super.a(paramString);
    }
  }
  
  protected void e(String paramString)
  {
    if ((GuildTitleBarHelper.a(this.a).O() != null) && (!TextUtils.isEmpty(GuildTitleBarHelper.a(this.a).O().b)))
    {
      if (!GuildTitleBarHelper.a(this.a).O().b.equals(paramString)) {
        return;
      }
      super.e(paramString);
      paramString = ((IGPSService)GuildTitleBarHelper.b(this.a).getRuntimeService(IGPSService.class, "")).getChannelInfo(paramString);
      if ((GuildTitleBarHelper.c(this.a) != null) && (paramString != null) && (!TextUtils.isEmpty(paramString.getChannelName()))) {
        GuildTitleBarHelper.c(this.a).setText(paramString.getChannelName());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildTitleBarHelper.1
 * JD-Core Version:    0.7.0.1
 */