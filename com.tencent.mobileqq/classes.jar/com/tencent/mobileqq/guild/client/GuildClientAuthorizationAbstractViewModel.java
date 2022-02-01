package com.tencent.mobileqq.guild.client;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.setting.QQGuildInfoRepository;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleInfo;

public class GuildClientAuthorizationAbstractViewModel
  extends BaseViewModel<QQGuildInfoRepository>
{
  public static ViewModelProvider.Factory a = new GuildClientAuthorizationAbstractViewModel.4();
  private final SingleLiveEvent<GuildClientRoleInfo> b = new SingleLiveEvent();
  private final SingleLiveEvent<ShowToastModel> c = new SingleLiveEvent();
  private final MutableLiveData<GuildClientManageViewModel.RoleInfo> d = new MutableLiveData();
  private AppInterface e;
  private String f;
  private String g;
  private String h;
  private int i;
  private final Handler j = new Handler(Looper.getMainLooper());
  
  public GuildClientAuthorizationAbstractViewModel(QQGuildInfoRepository paramQQGuildInfoRepository)
  {
    super(paramQQGuildInfoRepository);
  }
  
  private void i()
  {
    ((IGPSService)this.e.getRuntimeService(IGPSService.class, "")).getAppRoleList(this.f, new GuildClientAuthorizationAbstractViewModel.2(this));
  }
  
  public String a()
  {
    return this.f;
  }
  
  @MainThread
  public void a(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt)
  {
    this.e = paramAppInterface;
    this.f = paramString1;
    this.g = paramString2;
    this.i = paramInt;
    this.h = ((IGPSService)paramAppInterface.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
  }
  
  public void a(IGProRoleInfo paramIGProRoleInfo)
  {
    ((IGPSService)this.e.getRuntimeService(IGPSService.class, "")).bindAppRole(this.f, paramIGProRoleInfo.getRoleId(), 1, new GuildClientAuthorizationAbstractViewModel.3(this, paramIGProRoleInfo));
  }
  
  public String b()
  {
    return this.g;
  }
  
  public int c()
  {
    return this.i;
  }
  
  public SingleLiveEvent<ShowToastModel> d()
  {
    return this.c;
  }
  
  public SingleLiveEvent<GuildClientRoleInfo> e()
  {
    return this.b;
  }
  
  public LiveData<GuildClientManageViewModel.RoleInfo> f()
  {
    return this.d;
  }
  
  public void g()
  {
    ((IGPSService)this.e.getRuntimeService(IGPSService.class, "")).appAuthorization(this.f, new GuildClientAuthorizationAbstractViewModel.1(this));
  }
  
  public void h()
  {
    ((IGPSService)this.e.getRuntimeService(IGPSService.class, "")).refreshGuildUserProfileInfo(this.g, this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientAuthorizationAbstractViewModel
 * JD-Core Version:    0.7.0.1
 */