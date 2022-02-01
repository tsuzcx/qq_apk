package com.tencent.mobileqq.guild.mainframe;

import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;

class GuildMainFrame$1
  extends GPServiceObserver
{
  GuildMainFrame$1(GuildMainFrame paramGuildMainFrame, String paramString) {}
  
  protected void a(String paramString1, String paramString2)
  {
    if ((this.a.equals(paramString1)) && (paramString2 != null))
    {
      paramString1 = ((IQQGuildAvatarApi)this.b.aF.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(this.b.aF, this.a);
      ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).setSelectMember(this.a, paramString2, paramString1);
      ((IGPSService)this.b.aF.getRuntimeService(IGPSService.class, "")).deleteObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.GuildMainFrame.1
 * JD-Core Version:    0.7.0.1
 */