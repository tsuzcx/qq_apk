package com.tencent.mobileqq.guild.privatechannel.data;

import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import java.util.Iterator;
import java.util.List;

class GuildPrivateDeleteViewModel$2
  extends GPServiceObserver
{
  GuildPrivateDeleteViewModel$2(GuildPrivateDeleteViewModel paramGuildPrivateDeleteViewModel) {}
  
  protected void a(String paramString1, String paramString2, List<String> paramList)
  {
    if (GuildPrivateDeleteViewModel.a(this.a)) {
      return;
    }
    if ((paramString1.equals(GuildPrivateDeleteViewModel.b(this.a))) && (paramString2.equals(GuildPrivateDeleteViewModel.c(this.a)))) {
      ((IGPSService)GuildPrivateDeleteViewModel.e(this.a).getRuntimeService(IGPSService.class, "")).fetchUserInfo(paramString1, paramList, false, new GuildPrivateDeleteViewModel.2.1(this, paramString1));
    }
  }
  
  protected void b(String paramString1, String paramString2, List<String> paramList)
  {
    if (GuildPrivateDeleteViewModel.a(this.a)) {
      return;
    }
    if ((paramString1.equals(GuildPrivateDeleteViewModel.b(this.a))) && (paramString2.equals(GuildPrivateDeleteViewModel.c(this.a))))
    {
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        GuildPrivateDeleteViewModel.f(this.a).postValue(paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.data.GuildPrivateDeleteViewModel.2
 * JD-Core Version:    0.7.0.1
 */