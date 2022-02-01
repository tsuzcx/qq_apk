package com.tencent.mobileqq.guild.setting;

import androidx.annotation.MainThread;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;

public class QQGuidInfoViewModel
  extends BaseViewModel<QQGuildInfoRepository>
{
  static ViewModelProvider.Factory a = new QQGuidInfoViewModel.2();
  private final MutableLiveData<IGProGuildInfo> b = new MutableLiveData();
  private String c;
  private final GPServiceObserver d = new QQGuidInfoViewModel.1(this);
  
  public QQGuidInfoViewModel(QQGuildInfoRepository paramQQGuildInfoRepository)
  {
    super(paramQQGuildInfoRepository);
  }
  
  public MutableLiveData<IGProGuildInfo> a()
  {
    return this.b;
  }
  
  @MainThread
  public void a(String paramString, AppInterface paramAppInterface)
  {
    this.c = paramString;
    ((QQGuildInfoRepository)this.z).a(paramAppInterface);
    this.b.setValue(((QQGuildInfoRepository)this.z).a(paramString));
    ((QQGuildInfoRepository)this.z).a(this.d);
  }
  
  protected void onCleared()
  {
    super.onCleared();
    ((QQGuildInfoRepository)this.z).b(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuidInfoViewModel
 * JD-Core Version:    0.7.0.1
 */