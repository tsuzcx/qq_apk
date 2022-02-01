package com.tencent.mobileqq.guild.profilecard.manage;

import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.setting.QQGuildInfoRepository;
import com.tencent.mobileqq.guild.setting.QQGuildMemberFragment.OperateMemberResult;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import java.util.ArrayList;
import java.util.List;

public class GuildProfileManageViewModel
  extends BaseViewModel<QQGuildInfoRepository>
{
  public static ViewModelProvider.Factory a = new GuildProfileManageViewModel.1();
  private GuildBaseProfileData b;
  private SingleLiveEvent<ShowToastModel> c = new SingleLiveEvent();
  private SingleLiveEvent<Boolean> d = new SingleLiveEvent();
  private SingleLiveEvent<Boolean> e = new SingleLiveEvent();
  private SingleLiveEvent<QQGuildMemberFragment.OperateMemberResult> f = new SingleLiveEvent();
  private GPServiceObserver g;
  
  public GuildProfileManageViewModel(QQGuildInfoRepository paramQQGuildInfoRepository)
  {
    super(paramQQGuildInfoRepository);
  }
  
  public void a()
  {
    ((QQGuildInfoRepository)this.z).b(this.g);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    ((QQGuildInfoRepository)this.z).a(paramAppInterface);
    this.g = new GuildProfileManageViewModel.2(this);
    ((QQGuildInfoRepository)this.z).a(this.g);
  }
  
  public void a(GuildBaseProfileData paramGuildBaseProfileData)
  {
    this.b = paramGuildBaseProfileData;
  }
  
  public void a(boolean paramBoolean)
  {
    IGPSService localIGPSService = (IGPSService)((QQGuildInfoRepository)this.z).a().getRuntimeService(IGPSService.class, "");
    String str = this.b.c();
    localIGPSService.setGuildAdmin(this.b.a(), str, paramBoolean, new GuildProfileManageViewModel.3(this, paramBoolean, str));
  }
  
  public SingleLiveEvent<ShowToastModel> b()
  {
    return this.c;
  }
  
  public void b(boolean paramBoolean)
  {
    IGPSService localIGPSService = (IGPSService)((QQGuildInfoRepository)this.z).a().getRuntimeService(IGPSService.class, "");
    String str = this.b.c();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(str);
    localIGPSService.kickGuildUsers(this.b.a(), localArrayList, paramBoolean, new GuildProfileManageViewModel.4(this, str));
  }
  
  public SingleLiveEvent<Boolean> c()
  {
    return this.d;
  }
  
  public SingleLiveEvent<Boolean> d()
  {
    return this.e;
  }
  
  public SingleLiveEvent<QQGuildMemberFragment.OperateMemberResult> e()
  {
    return this.f;
  }
  
  public GuildBaseProfileData f()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.manage.GuildProfileManageViewModel
 * JD-Core Version:    0.7.0.1
 */