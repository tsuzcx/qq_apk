package com.tencent.mobileqq.guild.privatechannel.data;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class GuildPrivateAddViewModel
  extends ViewModel
{
  public static ViewModelProvider.Factory a = new GuildPrivateAddViewModel.1();
  private MutableLiveData<List<IGProUserInfo>> b = new MutableLiveData();
  private MutableLiveData<String> c = new MutableLiveData();
  private AppInterface d;
  private String e;
  private String f;
  private boolean g;
  private boolean h;
  private boolean i = true;
  private boolean j;
  private MutableLiveData<List<IGProUserInfo>> k = new MutableLiveData();
  private GPServiceObserver l = new GuildPrivateAddViewModel.2(this);
  
  private void g()
  {
    if (this.g) {
      return;
    }
    this.g = true;
    ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).getInvisibleMemberList(this.e, this.f, 50, this.i, new GuildPrivateAddViewModel.3(this));
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.e))
    {
      if (!this.h) {
        return;
      }
      g();
      return;
    }
    QQGuildUtil.a(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(2131890505));
    this.b.setValue(null);
  }
  
  public void a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    this.d = paramAppInterface;
    this.e = paramString1;
    this.f = paramString2;
    this.h = true;
    this.i = true;
    ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).addObserver(this.l);
  }
  
  public void a(String paramString)
  {
    ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).searchVisibleMemberList(this.e, this.f, 0, paramString, 100, new GuildPrivateAddViewModel.5(this));
  }
  
  public void a(List<String> paramList, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).setChannelVisibleMembers(this.e, this.f, paramList, null, new GuildPrivateAddViewModel.4(this, paramIResultWithSecurityCallback));
  }
  
  public LiveData<List<IGProUserInfo>> b()
  {
    return this.k;
  }
  
  public boolean c()
  {
    return this.g;
  }
  
  public MutableLiveData<List<IGProUserInfo>> d()
  {
    return this.b;
  }
  
  public boolean e()
  {
    return this.h;
  }
  
  public void f() {}
  
  protected void onCleared()
  {
    super.onCleared();
    this.j = true;
    ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).deleteObserver(this.l);
    this.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.data.GuildPrivateAddViewModel
 * JD-Core Version:    0.7.0.1
 */