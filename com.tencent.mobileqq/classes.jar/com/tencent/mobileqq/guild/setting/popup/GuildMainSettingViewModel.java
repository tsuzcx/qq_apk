package com.tencent.mobileqq.guild.setting.popup;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.setting.QQGuildInfoRepository;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class GuildMainSettingViewModel
  extends BaseViewModel<QQGuildInfoRepository>
{
  public static ViewModelProvider.Factory a = new GuildMainSettingViewModel.1();
  private GPServiceObserver b = new GuildMainSettingViewModel.2(this);
  private String c;
  private AppRuntime d;
  private IGProGuildInfo e;
  private MutableLiveData<String> f = new MutableLiveData();
  private SingleLiveEvent<Boolean> g = new SingleLiveEvent();
  private SingleLiveEvent<ShowToastModel> h = new SingleLiveEvent();
  
  public GuildMainSettingViewModel(QQGuildInfoRepository paramQQGuildInfoRepository)
  {
    super(paramQQGuildInfoRepository);
  }
  
  private void f()
  {
    AppRuntime localAppRuntime = this.d;
    if (localAppRuntime == null) {
      return;
    }
    ((IGPSService)localAppRuntime.getRuntimeService(IGPSService.class, "")).deleteObserver(this.b);
  }
  
  public void a()
  {
    ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).destroyGuild(this.e.getGuildID(), new GuildMainSettingViewModel.3(this));
  }
  
  public void a(AppRuntime paramAppRuntime, IGProGuildInfo paramIGProGuildInfo)
  {
    if (paramAppRuntime == null)
    {
      QLog.w("GuildMainSettingViewModel", 2, "app is null!");
      return;
    }
    if (paramIGProGuildInfo == null)
    {
      QLog.w("GuildMainSettingViewModel", 2, "guildInfo is null!");
      return;
    }
    this.d = paramAppRuntime;
    this.e = paramIGProGuildInfo;
    ((QQGuildInfoRepository)this.z).a((AppInterface)paramAppRuntime);
    paramAppRuntime = (IGPSService)this.d.getRuntimeService(IGPSService.class, "");
    this.c = paramAppRuntime.getSelfTinyId();
    paramAppRuntime.addObserver(this.b);
  }
  
  public void b()
  {
    ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).removeGuild(this.e.getGuildID(), new GuildMainSettingViewModel.4(this));
  }
  
  public MutableLiveData<String> c()
  {
    return this.f;
  }
  
  public SingleLiveEvent<Boolean> d()
  {
    return this.g;
  }
  
  public SingleLiveEvent<ShowToastModel> e()
  {
    return this.h;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.popup.GuildMainSettingViewModel
 * JD-Core Version:    0.7.0.1
 */