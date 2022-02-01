package com.tencent.mobileqq.guild.client;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.setting.QQGuildInfoRepository;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;

public class GuildClientSelectRoleViewModel
  extends BaseViewModel<QQGuildInfoRepository>
{
  public static ViewModelProvider.Factory b = new GuildClientSelectRoleViewModel.2();
  public final SingleLiveEvent<ShowToastModel> a = new SingleLiveEvent();
  private final MutableLiveData<GuildClientManageViewModel.RoleInfo> c = new MutableLiveData();
  private AppInterface d;
  private String e;
  private String f;
  private String g;
  private int h;
  private Handler i = new Handler(Looper.getMainLooper());
  
  public GuildClientSelectRoleViewModel(QQGuildInfoRepository paramQQGuildInfoRepository)
  {
    super(paramQQGuildInfoRepository);
  }
  
  public SingleLiveEvent<ShowToastModel> a()
  {
    return this.a;
  }
  
  public void a(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt)
  {
    this.d = paramAppInterface;
    this.e = paramString1;
    this.f = paramString2;
    this.g = ((IGPSService)paramAppInterface.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
    this.h = paramInt;
  }
  
  public void a(GuildClientRoleInfo.RoleInfo paramRoleInfo)
  {
    ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).bindAppRole(this.e, paramRoleInfo.a(), 1, new GuildClientSelectRoleViewModel.1(this, paramRoleInfo));
  }
  
  public LiveData<GuildClientManageViewModel.RoleInfo> b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.h;
  }
  
  public String d()
  {
    return this.f;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public void f()
  {
    ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).refreshGuildUserProfileInfo(this.f, this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientSelectRoleViewModel
 * JD-Core Version:    0.7.0.1
 */