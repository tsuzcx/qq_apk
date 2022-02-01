package com.tencent.mobileqq.qqgift.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftModule;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.countdown.IQQGiftCountDownModule;
import com.tencent.mobileqq.qqgift.api.impl.countdown.QQGiftCountDownModuleImpl;
import com.tencent.mobileqq.qqgift.api.impl.service.QQGiftRechargeModuleImpl;
import com.tencent.mobileqq.qqgift.api.impl.service.QQGiftResDownloadModuleImpl;
import com.tencent.mobileqq.qqgift.api.impl.service.QQGiftServiceModuleImpl;
import com.tencent.mobileqq.qqgift.api.impl.service.QQGiftWalletIdentifyModuleImpl;
import com.tencent.mobileqq.qqgift.api.impl.view.QQGiftViewModuleImpl;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftResDownloadModule;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftServiceModule;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftWalletIdentifyModule;
import com.tencent.mobileqq.qqgift.api.view.IQQGiftViewModule;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.QQLiveGiftAnimationEngineImpl;
import com.tencent.mobileqq.qqgift.mvvm.business.banner.BannerResManager;
import com.tencent.mobileqq.qqgift.sdk.config.QQGiftSDKConfig;
import com.tencent.mobileqq.qqgift.sso.IQQGiftSsoModule;
import com.tencent.mobileqq.qqgift.sso.QQGiftSsoModuleImpl;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class QQGiftSDKImpl
  implements IQQGiftSDK
{
  private AppRuntime a;
  private QQGiftSDKConfig b;
  private ConcurrentHashMap<String, IQQGiftModule> c = new ConcurrentHashMap();
  private boolean d = false;
  private boolean e = false;
  private IQQGiftSsoModule f = new QQGiftSsoModuleImpl();
  private IQQGiftServiceModule g = new QQGiftServiceModuleImpl();
  private IQQGiftViewModule h = new QQGiftViewModuleImpl();
  private IQQGiftResDownloadModule i = new QQGiftResDownloadModuleImpl();
  private IQQGiftRechargeModule j = new QQGiftRechargeModuleImpl();
  private IQQGiftWalletIdentifyModule k = new QQGiftWalletIdentifyModuleImpl();
  private QQGiftCountDownModuleImpl l = new QQGiftCountDownModuleImpl();
  
  public IQQGiftModule a(String paramString)
  {
    return (IQQGiftModule)this.c.get(paramString);
  }
  
  public void a(String paramString, IQQGiftModule paramIQQGiftModule, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramIQQGiftModule == null) {
        return;
      }
      this.c.put(paramString, paramIQQGiftModule);
      if (paramBoolean) {
        paramIQQGiftModule.a(this);
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime, QQGiftSDKConfig paramQQGiftSDKConfig)
  {
    this.e = true;
    this.a = paramAppRuntime;
    this.b = paramQQGiftSDKConfig;
    a("sso_module", this.f, true);
    this.g.a(this);
    this.h.a(this);
    this.i.a(this);
    this.j.a(this);
    this.k.a(this);
    this.l.a(this);
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public AppRuntime b()
  {
    return this.a;
  }
  
  public QQGiftSDKConfig c()
  {
    return this.b;
  }
  
  public IQQGiftServiceModule d()
  {
    return this.g;
  }
  
  public IQQGiftViewModule e()
  {
    return this.h;
  }
  
  public IQQGiftRechargeModule f()
  {
    return this.j;
  }
  
  public IQQGiftResDownloadModule g()
  {
    return this.i;
  }
  
  public IQQGiftWalletIdentifyModule h()
  {
    return this.k;
  }
  
  public IQQGiftCountDownModule i()
  {
    return this.l;
  }
  
  public void j()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    Object localObject = this.b;
    int m;
    if (localObject == null) {
      m = -1;
    } else {
      m = ((QQGiftSDKConfig)localObject).a;
    }
    localObject = this.c;
    if ((localObject != null) && (!((ConcurrentHashMap)localObject).isEmpty()))
    {
      localObject = this.c.entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IQQGiftModule)((Map.Entry)((Iterator)localObject).next()).getValue()).b();
      }
    }
    this.c.clear();
    this.i.b();
    this.k.b();
    this.l.b();
    this.a = null;
    this.b = null;
    if (m != -1) {
      ((IQQGiftManager)QRoute.api(IQQGiftManager.class)).removeSDKImpl(m);
    }
    localObject = BannerResManager.b();
    if (localObject != null) {
      ((BannerResManager)localObject).a();
    }
    QQLiveGiftAnimationEngineImpl.h.clear();
  }
  
  public boolean k()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.impl.QQGiftSDKImpl
 * JD-Core Version:    0.7.0.1
 */