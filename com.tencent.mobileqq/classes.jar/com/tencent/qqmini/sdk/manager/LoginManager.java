package com.tencent.qqmini.sdk.manager;

import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;

@MiniKeep
public class LoginManager
{
  private static volatile LoginManager sInstance;
  private MiniAppProxy miniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
  
  public static LoginManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new LoginManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  public String getAccount()
  {
    if ((this.miniAppProxy.getAccount() == null) && (AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null)) {
      return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getAccount();
    }
    return this.miniAppProxy.getAccount();
  }
  
  public String getAppId()
  {
    if ((this.miniAppProxy.getAppId() == null) && (AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null)) {
      return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getAppId();
    }
    return this.miniAppProxy.getAppId();
  }
  
  public byte[] getLoginSig()
  {
    if ((this.miniAppProxy.getLoginSig() == null) && (AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null)) {
      return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getLoginSig();
    }
    return this.miniAppProxy.getLoginSig();
  }
  
  public int getLoginType()
  {
    if ((this.miniAppProxy.getLoginType() == -1) && (AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null)) {
      return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getLoginType();
    }
    return this.miniAppProxy.getLoginType();
  }
  
  public String getNickName()
  {
    if ((this.miniAppProxy.getNickName() == null) && (AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null)) {
      return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getNickName();
    }
    return this.miniAppProxy.getNickName();
  }
  
  public String getPayAccessToken()
  {
    if ((this.miniAppProxy.getPayAccessToken() == null) && (AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null)) {
      return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getPayAccessToken();
    }
    return this.miniAppProxy.getPayAccessToken();
  }
  
  public String getPayOpenId()
  {
    if ((this.miniAppProxy.getPayOpenId() == null) && (AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null)) {
      return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getPayOpenId();
    }
    return this.miniAppProxy.getPayOpenId();
  }
  
  public String getPayOpenKey()
  {
    if ((this.miniAppProxy.getPayOpenKey() == null) && (AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null)) {
      return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getPayOpenKey();
    }
    return this.miniAppProxy.getPayOpenKey();
  }
  
  public String getPlatformId()
  {
    if ((this.miniAppProxy.getPlatformId() == null) && (AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null)) {
      return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getPlatformId();
    }
    return this.miniAppProxy.getPlatformId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.LoginManager
 * JD-Core Version:    0.7.0.1
 */