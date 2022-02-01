package com.tencent.mobileqq.guild.client;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.setting.QQGuildInfoRepository;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProPopupConfigInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;

public class GuildClientManageViewModel
  extends BaseViewModel<QQGuildInfoRepository>
{
  static ViewModelProvider.Factory a = new GuildClientManageViewModel.9();
  private final MutableLiveData<Boolean> b = new MutableLiveData();
  private final MutableLiveData<Boolean> c = new MutableLiveData();
  private final MutableLiveData<GuildClientManageViewModel.RoleInfo> d = new MutableLiveData();
  private final MutableLiveData<GuildClientManageViewModel.ClientInfo> e = new MutableLiveData();
  private final SingleLiveEvent<IGProPopupConfigInfo> f = new SingleLiveEvent();
  private final SingleLiveEvent<GuildClientRoleInfo> g = new SingleLiveEvent();
  private final SingleLiveEvent<ShowToastModel> h = new SingleLiveEvent();
  private AppInterface i;
  private String j;
  private String k;
  private final GPServiceObserver l = new GuildClientManageViewModel.1(this);
  
  public GuildClientManageViewModel(QQGuildInfoRepository paramQQGuildInfoRepository)
  {
    super(paramQQGuildInfoRepository);
    this.e.setValue(new GuildClientManageViewModel.ClientInfo());
  }
  
  private void o()
  {
    this.d.setValue(new GuildClientManageViewModel.RoleInfo());
  }
  
  public MutableLiveData<Boolean> a()
  {
    return this.b;
  }
  
  @MainThread
  public void a(AppInterface paramAppInterface, String paramString)
  {
    this.i = paramAppInterface;
    ((IGPSService)this.i.getRuntimeService(IGPSService.class, "")).addObserver(this.l);
    this.j = paramString;
    this.k = ((IGPSService)paramAppInterface.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
    j();
    k();
  }
  
  public void a(GuildClientManageViewModel.RoleInfo paramRoleInfo)
  {
    ((IGPSService)this.i.getRuntimeService(IGPSService.class, "")).bindAppRole(((GuildClientManageViewModel.ClientInfo)this.e.getValue()).a, paramRoleInfo.c, 2, new GuildClientManageViewModel.6(this));
  }
  
  public void a(@NonNull IGProRoleInfo paramIGProRoleInfo)
  {
    ((IGPSService)this.i.getRuntimeService(IGPSService.class, "")).bindAppRole(((GuildClientManageViewModel.ClientInfo)this.e.getValue()).a, paramIGProRoleInfo.getRoleId(), 1, new GuildClientManageViewModel.4(this, paramIGProRoleInfo));
  }
  
  public void a(boolean paramBoolean)
  {
    ((IGPSService)this.i.getRuntimeService(IGPSService.class, "")).setShowPresence(((GuildClientManageViewModel.ClientInfo)this.e.getValue()).a, paramBoolean, new GuildClientManageViewModel.7(this, paramBoolean));
  }
  
  public MutableLiveData<Boolean> b()
  {
    return this.c;
  }
  
  public void b(boolean paramBoolean)
  {
    ((IGPSService)this.i.getRuntimeService(IGPSService.class, "")).setShowArchive(((GuildClientManageViewModel.ClientInfo)this.e.getValue()).a, paramBoolean, new GuildClientManageViewModel.8(this, paramBoolean));
  }
  
  public MutableLiveData<GuildClientManageViewModel.RoleInfo> c()
  {
    return this.d;
  }
  
  public SingleLiveEvent<IGProPopupConfigInfo> d()
  {
    return this.f;
  }
  
  public SingleLiveEvent<GuildClientRoleInfo> e()
  {
    return this.g;
  }
  
  public SingleLiveEvent<ShowToastModel> f()
  {
    return this.h;
  }
  
  public MutableLiveData<GuildClientManageViewModel.ClientInfo> g()
  {
    return this.e;
  }
  
  public String h()
  {
    return this.j;
  }
  
  public String i()
  {
    return ((GuildClientManageViewModel.ClientInfo)this.e.getValue()).a;
  }
  
  public void j()
  {
    ((IGPSService)this.i.getRuntimeService(IGPSService.class, "")).getClientInfoList(1, new GuildClientManageViewModel.2(this));
  }
  
  public void k()
  {
    ((IGPSService)this.i.getRuntimeService(IGPSService.class, "")).refreshGuildUserProfileInfo(this.j, this.k);
  }
  
  public void l()
  {
    ((IGPSService)this.i.getRuntimeService(IGPSService.class, "")).getAppAuthorizationInfo(((GuildClientManageViewModel.ClientInfo)this.e.getValue()).a, 1, new GuildClientManageViewModel.3(this));
  }
  
  public void m()
  {
    ((IGPSService)this.i.getRuntimeService(IGPSService.class, "")).getAppRoleList(((GuildClientManageViewModel.ClientInfo)this.e.getValue()).a, new GuildClientManageViewModel.5(this));
  }
  
  public void n()
  {
    AppInterface localAppInterface = this.i;
    if (localAppInterface == null) {
      return;
    }
    ((IGPSService)localAppInterface.getRuntimeService(IGPSService.class, "")).refreshGuildUserProfileInfo(this.j, this.k);
  }
  
  protected void onCleared()
  {
    super.onCleared();
    ((IGPSService)this.i.getRuntimeService(IGPSService.class, "")).deleteObserver(this.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientManageViewModel
 * JD-Core Version:    0.7.0.1
 */