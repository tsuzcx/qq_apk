package com.tencent.mobileqq.guild.setting;

import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.base.BaseGuildViewModel.ToastEvent;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.AddGuildOption;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class JoinGuildSettingViewModel
  extends BaseViewModel<QQGuildInfoRepository>
{
  public static ViewModelProvider.Factory a = new JoinGuildSettingViewModel.3();
  private MutableLiveData<AddGuildOption> b = new MutableLiveData();
  private MutableLiveData<Integer> c = new MutableLiveData();
  private MutableLiveData<Boolean> d = new MutableLiveData();
  private SingleLiveEvent<BaseGuildViewModel.ToastEvent> e = new SingleLiveEvent();
  private SingleLiveEvent<Boolean> f = new SingleLiveEvent();
  private String g = "";
  
  public JoinGuildSettingViewModel(QQGuildInfoRepository paramQQGuildInfoRepository)
  {
    super(paramQQGuildInfoRepository);
  }
  
  public LiveData<Boolean> a()
  {
    return this.d;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    IGPSService localIGPSService = (IGPSService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGPSService.class, "");
    AddGuildOption localAddGuildOption = new AddGuildOption();
    localAddGuildOption.a = paramInt;
    localAddGuildOption.b = paramString1;
    localAddGuildOption.c = paramString2;
    paramString1 = new StringBuilder();
    paramString1.append("setAddGuildOption ");
    paramString1.append(localAddGuildOption.toString());
    QLog.d("JoinGuildSettingViewModel", 1, paramString1.toString());
    localIGPSService.setAddGuildOption(this.g, localAddGuildOption, new JoinGuildSettingViewModel.2(this));
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.c.setValue(Integer.valueOf(paramInt));
    boolean bool = true;
    if (paramInt == 5)
    {
      this.d.setValue(Boolean.valueOf(TextUtils.isEmpty(paramString1) ^ true));
      return;
    }
    if (paramInt == 4)
    {
      paramString1 = this.d;
      if ((TextUtils.isEmpty(paramString2.trim())) || (TextUtils.isEmpty(paramString3.trim()))) {
        bool = false;
      }
      paramString1.setValue(Boolean.valueOf(bool));
      return;
    }
    this.d.setValue(Boolean.valueOf(true));
  }
  
  @MainThread
  public void a(AppInterface paramAppInterface, String paramString)
  {
    this.g = paramString;
    ((QQGuildInfoRepository)this.z).a(paramAppInterface);
    ((IGPSService)paramAppInterface.getRuntimeService(IGPSService.class, "")).getAddGuildOption(paramString, new JoinGuildSettingViewModel.1(this));
  }
  
  public void a(String paramString)
  {
    if (b().getValue() == null) {
      return;
    }
    if (((Integer)b().getValue()).intValue() != 5) {
      return;
    }
    if (!TextUtils.isEmpty(paramString.trim()))
    {
      this.d.setValue(Boolean.valueOf(true));
      return;
    }
    this.d.setValue(Boolean.valueOf(false));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (b().getValue() == null) {
      return;
    }
    if (((Integer)b().getValue()).intValue() != 4) {
      return;
    }
    if ((!TextUtils.isEmpty(paramString1.trim())) && (!TextUtils.isEmpty(paramString2.trim())))
    {
      this.d.setValue(Boolean.valueOf(true));
      return;
    }
    this.d.setValue(Boolean.valueOf(false));
  }
  
  public LiveData<Integer> b()
  {
    return this.c;
  }
  
  public LiveData<Boolean> c()
  {
    return this.f;
  }
  
  public LiveData<AddGuildOption> d()
  {
    return this.b;
  }
  
  public LiveData<BaseGuildViewModel.ToastEvent> e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.JoinGuildSettingViewModel
 * JD-Core Version:    0.7.0.1
 */