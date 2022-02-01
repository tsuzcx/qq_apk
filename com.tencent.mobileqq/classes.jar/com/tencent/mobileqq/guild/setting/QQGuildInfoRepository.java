package com.tencent.mobileqq.guild.setting;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mvvm.BaseRepository;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;

public class QQGuildInfoRepository
  extends BaseRepository
{
  private AppInterface a;
  
  public AppInterface a()
  {
    return this.a;
  }
  
  public IGProGuildInfo a(String paramString)
  {
    AppInterface localAppInterface = this.a;
    if (localAppInterface == null) {
      return null;
    }
    return ((IGPSService)localAppInterface.getRuntimeService(IGPSService.class, "")).getGuildInfo(paramString);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
  }
  
  public void a(GPServiceObserver paramGPServiceObserver)
  {
    AppInterface localAppInterface = this.a;
    if (localAppInterface != null) {
      ((IGPSService)localAppInterface.getRuntimeService(IGPSService.class, "")).addObserver(paramGPServiceObserver);
    }
  }
  
  public void b(GPServiceObserver paramGPServiceObserver)
  {
    AppInterface localAppInterface = this.a;
    if (localAppInterface != null) {
      ((IGPSService)localAppInterface.getRuntimeService(IGPSService.class, "")).deleteObserver(paramGPServiceObserver);
    }
  }
  
  protected void bN_()
  {
    super.bN_();
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildInfoRepository
 * JD-Core Version:    0.7.0.1
 */