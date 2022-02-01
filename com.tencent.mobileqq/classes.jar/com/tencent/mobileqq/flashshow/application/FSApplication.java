package com.tencent.mobileqq.flashshow.application;

import android.app.Application;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.richframework.AutoShadowPluginRuntime;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.flashshow.helper.FSGlobalBroadcastHelper;
import com.tencent.mobileqq.flashshow.inject.FSToast;

public class FSApplication
  extends Application
{
  public static Application APP;
  
  static
  {
    Application localApplication;
    if ((RFApplication.getApplication() instanceof Application)) {
      localApplication = (Application)RFApplication.getApplication();
    } else {
      localApplication = null;
    }
    APP = localApplication;
    if ((RFApplication.getApplication() instanceof Application)) {
      FSGlobalBroadcastHelper.a().b();
    }
  }
  
  public static boolean isRDMVersion()
  {
    return (!TextUtils.isEmpty(HostDataTransUtils.getQUA3())) && (HostDataTransUtils.getQUA3().endsWith("RDM_B")) && (!HostAppSettingUtil.isPublicVersion()) && (!HostAppSettingUtil.isGrayVersion());
  }
  
  public String getAccount()
  {
    return HostDataTransUtils.getAccount();
  }
  
  public long getLongAccountUin()
  {
    return HostDataTransUtils.getLongAccountUin();
  }
  
  public String getNickName()
  {
    return HostDataTransUtils.getAccountNickName(getAccount());
  }
  
  public void init(Application paramApplication)
  {
    AutoShadowPluginRuntime.a().a(paramApplication);
    FSToast.a(ASInject.g().getToastDelegate());
    FSGlobalBroadcastHelper.a().b();
  }
  
  public void onCreate()
  {
    APP = this;
    super.onCreate();
    init(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.application.FSApplication
 * JD-Core Version:    0.7.0.1
 */