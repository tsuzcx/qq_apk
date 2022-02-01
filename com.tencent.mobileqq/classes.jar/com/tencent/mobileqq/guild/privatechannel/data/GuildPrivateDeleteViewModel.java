package com.tencent.mobileqq.guild.privatechannel.data;

import android.text.TextUtils;
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
import java.util.ArrayList;
import java.util.List;

public class GuildPrivateDeleteViewModel
  extends ViewModel
{
  public static ViewModelProvider.Factory a = new GuildPrivateDeleteViewModel.1();
  private MutableLiveData<List<IGProUserInfo>> b = new MutableLiveData();
  private MutableLiveData<String> c = new MutableLiveData();
  private AppInterface d;
  private String e;
  private String f;
  private boolean g;
  private boolean h;
  private boolean i = true;
  private boolean j;
  private GPServiceObserver k = new GuildPrivateDeleteViewModel.2(this);
  
  public void a()
  {
    this.h = true;
    this.i = true;
  }
  
  public void a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    this.d = paramAppInterface;
    this.e = paramString1;
    this.f = paramString2;
    a();
    ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).addObserver(this.k);
  }
  
  public void a(String paramString, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).setChannelVisibleMembers(this.e, this.f, null, localArrayList, new GuildPrivateDeleteViewModel.4(this, paramIResultWithSecurityCallback, paramString));
  }
  
  public void b()
  {
    if (this.g) {
      return;
    }
    if (!TextUtils.isEmpty(this.e))
    {
      ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).getVisibleMemberList(this.e, this.f, 50, this.i, new GuildPrivateDeleteViewModel.3(this));
      this.g = true;
      return;
    }
    QQGuildUtil.a(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(2131890505));
    this.b.setValue(null);
  }
  
  public boolean c()
  {
    return this.g;
  }
  
  public MutableLiveData<List<IGProUserInfo>> d()
  {
    return this.b;
  }
  
  public MutableLiveData<String> e()
  {
    return this.c;
  }
  
  public boolean f()
  {
    return this.h;
  }
  
  public void g() {}
  
  protected void onCleared()
  {
    super.onCleared();
    ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).deleteObserver(this.k);
    this.d = null;
    this.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.data.GuildPrivateDeleteViewModel
 * JD-Core Version:    0.7.0.1
 */