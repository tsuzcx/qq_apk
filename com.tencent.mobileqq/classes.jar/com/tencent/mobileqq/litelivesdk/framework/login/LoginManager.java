package com.tencent.mobileqq.litelivesdk.framework.login;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginRequest;
import com.tencent.falco.base.libapi.login.LoginType;
import com.tencent.ilive.LiveSDK;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.api.login.BizLoginRequest;
import com.tencent.mobileqq.litelivesdk.api.login.ILiveLoginTicketListener;
import com.tencent.mobileqq.litelivesdk.api.login.LoginResult;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.utils.HexUtil;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LoginManager
{
  public static LoginManager c = new LoginManager();
  int a = 0;
  Map<String, List<ILiveLoginTicketListener>> b = new HashMap();
  private LoginResult d;
  private LoginRequest e;
  private LoginStatus f = LoginStatus.NoLogin;
  
  public static LoginRequest a(BizLoginRequest paramBizLoginRequest)
  {
    LoginRequest localLoginRequest = new LoginRequest();
    Object localObject1 = paramBizLoginRequest.i;
    Object localObject2 = paramBizLoginRequest.h;
    localLoginRequest.id = ((String)localObject1);
    localLoginRequest.token = ((String)localObject2);
    localLoginRequest.appid = String.valueOf(paramBizLoginRequest.c);
    int i = paramBizLoginRequest.b;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 8)
          {
            localObject1 = LogFactory.a();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("do NowLive login, type is unknow:");
            ((StringBuilder)localObject2).append(paramBizLoginRequest.b);
            ((LogInterface)localObject1).b("LoginManager", ((StringBuilder)localObject2).toString());
          }
          else
          {
            LogFactory.a().b("LoginManager", "do NowLive login, type is qq_connect");
            localLoginRequest.loginType = LoginType.QQ;
            localLoginRequest.customExtData = "18";
          }
        }
        else
        {
          localLoginRequest.loginType = LoginType.GUEST;
          localLoginRequest.customExtData = "2";
        }
      }
      else
      {
        LogFactory.a().b("LoginManager", "do NowLive login, type is wx");
        localLoginRequest.loginType = LoginType.WX;
        localLoginRequest.customExtData = "9";
      }
    }
    else
    {
      LogFactory.a().b("LoginManager", "do NowLive login, type is wt");
      localLoginRequest.loginType = LoginType.QQ;
      localLoginRequest.id = paramBizLoginRequest.d;
      localLoginRequest.token = paramBizLoginRequest.e;
      localLoginRequest.customExtData = "0";
    }
    localLoginRequest.initOpenSDK = false;
    return localLoginRequest;
  }
  
  private LoginResult a(LoginInfo paramLoginInfo)
  {
    LoginResult localLoginResult = new LoginResult();
    localLoginResult.c = BusinessManager.a.b().a;
    localLoginResult.d = Integer.toString(BusinessManager.a.b().f);
    localLoginResult.f = HexUtil.a(paramLoginInfo.a2);
    localLoginResult.g = Long.toString(paramLoginInfo.tinyid);
    localLoginResult.e = paramLoginInfo.uid;
    localLoginResult.i = paramLoginInfo.loginType.ordinal();
    localLoginResult.a = paramLoginInfo.openId;
    localLoginResult.b = paramLoginInfo.access_token;
    return localLoginResult;
  }
  
  private void a(LoginResult paramLoginResult)
  {
    Object localObject = (List)this.b.get(BusinessManager.a.b().a);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ILiveLoginTicketListener)((Iterator)localObject).next()).a(paramLoginResult);
      }
    }
    if (f())
    {
      localObject = new Bundle();
      ((Bundle)localObject).putParcelable("Key_BizLoginRequest", paramLoginResult);
      QIPCClientHelper.getInstance().getClient().callServer("LiteSDKServerModuleName", "Action_Server_OnLoginSuccess", (Bundle)localObject);
    }
  }
  
  private boolean f()
  {
    return BaseApplicationImpl.getApplication().getQQProcessName().equals("com.tencent.mobileqq:tool");
  }
  
  public void a()
  {
    LogFactory.a().e("LoginManager", "notifyHostRefreshTicket----will refresh Login Token!");
    this.f = LoginStatus.NoLogin;
    Object localObject = (List)this.b.get(BusinessManager.a.b().a);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ILiveLoginTicketListener localILiveLoginTicketListener = (ILiveLoginTicketListener)((Iterator)localObject).next();
        localILiveLoginTicketListener.a(2, new LoginManager.1(this, localILiveLoginTicketListener));
      }
    }
    if (f()) {
      QIPCClientHelper.getInstance().getClient().callServer("LiteSDKServerModuleName", "Action_Server_OnRefreshToken", null);
    }
  }
  
  public void a(LoginRequest paramLoginRequest)
  {
    if ((this.f != LoginStatus.Logined) && (this.f != LoginStatus.Logining))
    {
      LogFactory.a().e("LoginManager", "loginToLiveSDK-----Start Login");
      this.e = paramLoginRequest;
      this.f = LoginStatus.Logining;
      LiveSDK.login(paramLoginRequest, new LoginManager.2(this, paramLoginRequest));
      return;
    }
    LogFactory.a().e("LoginManager", "loginToLiveSDK-----already logined or Logining, will Return");
    a(this.d);
  }
  
  public void a(String paramString, ILiveLoginTicketListener paramILiveLoginTicketListener)
  {
    List localList = (List)this.b.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.b.put(paramString, localObject);
    }
    ((List)localObject).clear();
    ((List)localObject).add(paramILiveLoginTicketListener);
  }
  
  public void b()
  {
    LogFactory.a().e("LoginManager", "clear-----will clear LoginInfo");
    this.d = null;
    this.e = null;
    this.b.clear();
    this.f = LoginStatus.NoLogin;
  }
  
  public LoginResult c()
  {
    return this.d;
  }
  
  public LoginRequest d()
  {
    return this.e;
  }
  
  public void e()
  {
    LogFactory.a().e("LoginManager", "logout-----will logout");
    this.a = 0;
    this.d = null;
    this.e = null;
    this.f = LoginStatus.NoLogin;
    this.b.remove(BusinessManager.a.b().a);
    LiveSDK.logout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.framework.login.LoginManager
 * JD-Core Version:    0.7.0.1
 */