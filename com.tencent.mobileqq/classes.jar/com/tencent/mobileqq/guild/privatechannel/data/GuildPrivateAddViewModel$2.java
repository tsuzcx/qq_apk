package com.tencent.mobileqq.guild.privatechannel.data;

import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import java.util.Iterator;
import java.util.List;

class GuildPrivateAddViewModel$2
  extends GPServiceObserver
{
  GuildPrivateAddViewModel$2(GuildPrivateAddViewModel paramGuildPrivateAddViewModel) {}
  
  protected void a(String paramString1, String paramString2, List<String> paramList)
  {
    if (GuildPrivateAddViewModel.a(this.a)) {
      return;
    }
    if ((paramString1.equals(GuildPrivateAddViewModel.b(this.a))) && (paramString2.equals(GuildPrivateAddViewModel.c(this.a)))) {
      ((IGPSService)GuildPrivateAddViewModel.e(this.a).getRuntimeService(IGPSService.class, "")).fetchUserInfo(paramString1, paramList, false, new GuildPrivateAddViewModel.2.1(this, paramString1));
    }
  }
  
  protected void b(String paramString1, String paramString2, List<String> paramList)
  {
    if (GuildPrivateAddViewModel.a(this.a)) {
      return;
    }
    if ((paramString1.equals(GuildPrivateAddViewModel.b(this.a))) && (paramString2.equals(GuildPrivateAddViewModel.c(this.a))))
    {
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        GuildPrivateAddViewModel.f(this.a).postValue(paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.data.GuildPrivateAddViewModel.2
 * JD-Core Version:    0.7.0.1
 */