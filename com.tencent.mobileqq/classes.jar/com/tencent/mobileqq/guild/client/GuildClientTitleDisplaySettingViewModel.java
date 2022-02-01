package com.tencent.mobileqq.guild.client;

import androidx.annotation.MainThread;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.setting.QQGuildInfoRepository;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IClientInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.util.Iterator;
import java.util.List;

public class GuildClientTitleDisplaySettingViewModel
  extends BaseViewModel<QQGuildInfoRepository>
{
  static ViewModelProvider.Factory a = new GuildClientTitleDisplaySettingViewModel.3();
  private final MutableLiveData<List<IClientInfo>> b = new MutableLiveData();
  private final MutableLiveData<IClientInfo> c = new MutableLiveData();
  private final SingleLiveEvent<ShowToastModel> d = new SingleLiveEvent();
  private AppInterface e;
  private String f;
  private String g;
  
  public GuildClientTitleDisplaySettingViewModel(QQGuildInfoRepository paramQQGuildInfoRepository)
  {
    super(paramQQGuildInfoRepository);
  }
  
  private IClientInfo b(String paramString)
  {
    Object localObject = (List)this.b.getValue();
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return null;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        IClientInfo localIClientInfo = (IClientInfo)((Iterator)localObject).next();
        if (localIClientInfo.a().equals(paramString)) {
          return localIClientInfo;
        }
      }
    }
    return null;
  }
  
  public String a()
  {
    return this.f;
  }
  
  @MainThread
  public void a(AppInterface paramAppInterface, String paramString)
  {
    this.e = paramAppInterface;
    this.f = paramString;
    this.g = ((IGPSService)this.e.getRuntimeService(IGPSService.class, "")).getGuildInfo(paramString).getClientId();
    e();
  }
  
  public void a(String paramString)
  {
    ((IGPSService)this.e.getRuntimeService(IGPSService.class, "")).setGuildClientId(this.f, paramString, new GuildClientTitleDisplaySettingViewModel.2(this));
  }
  
  public MutableLiveData<IClientInfo> b()
  {
    return this.c;
  }
  
  public MutableLiveData<List<IClientInfo>> c()
  {
    return this.b;
  }
  
  public SingleLiveEvent<ShowToastModel> d()
  {
    return this.d;
  }
  
  public void e()
  {
    ((IGPSService)this.e.getRuntimeService(IGPSService.class, "")).getClientInfoList(2, new GuildClientTitleDisplaySettingViewModel.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientTitleDisplaySettingViewModel
 * JD-Core Version:    0.7.0.1
 */