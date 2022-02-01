package com.tencent.mobileqq.qqlive.login;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.config.IQQLiveConfigModule;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.mobileqq.qqlive.utils.LoginCacheManager;
import com.tencent.mobileqq.qqlive.utils.ThreadCenter;
import com.tencent.mobileqq.qqlive.utils.ThreadCenter.HandlerKeyable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.ilive.loginSvr.loginSvr.nano.AccountBaseInfo;
import com.tencent.trpcprotocol.ilive.loginSvr.loginSvr.nano.LoginReply;
import com.tencent.trpcprotocol.ilive.loginSvr.loginSvr.nano.TicketInfo;
import com.tencent.trpcprotocol.qlive.login_svr.login_svr.nano.GetOpenInfoReq;
import com.tencent.trpcprotocol.qlive.login_svr.login_svr.nano.GetOpenInfoRsp;
import com.tencent.util.QQDeviceInfo;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class LoginLogic
  extends QQLiveBusinessObserver
  implements IQQLiveModuleLogin, ThreadCenter.HandlerKeyable
{
  private volatile com.tencent.mobileqq.qqlive.data.login.LoginRequest a;
  private volatile LoginInfo b;
  private LiveUserInfo c;
  private LoginCacheManager d;
  private int e = 0;
  private AppRuntime f;
  private IQQLiveSDK g;
  private final LoginLogic.AuthRunnable h = new LoginLogic.AuthRunnable(this);
  private final List<IQQLiveLoginCallback> i = new CopyOnWriteArrayList();
  
  private void a(int paramInt, String paramString)
  {
    this.e = 3;
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((IQQLiveLoginCallback)localIterator.next()).onFailed(paramInt, paramString);
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append(" onLoginCallFail code ");
      paramString.append(paramInt);
      QLog.d("LoginLogic", 2, paramString.toString());
    }
  }
  
  private void a(LoginInfo paramLoginInfo, LiveUserInfo paramLiveUserInfo)
  {
    this.b = paramLoginInfo;
    this.c = paramLiveUserInfo;
  }
  
  private void a(com.tencent.mobileqq.qqlive.data.login.LoginRequest paramLoginRequest)
  {
    if ((paramLoginRequest != null) && (this.f != null))
    {
      this.e = 2;
      this.a = paramLoginRequest;
      if (!TextUtils.isEmpty(this.a.qqA2))
      {
        b(paramLoginRequest.uin, paramLoginRequest.qqA2);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LoginLogic", 2, "the QQ a2 is null");
      }
      this.e = 3;
      a(-1, "the QQ a2 is null");
      return;
    }
    a(-1, "the request is null");
  }
  
  private void a(LoginReply paramLoginReply)
  {
    LoginInfo localLoginInfo = new LoginInfo();
    LiveUserInfo localLiveUserInfo = new LiveUserInfo();
    localLoginInfo.openId = this.a.openId;
    localLoginInfo.accessToken = this.a.accessToken;
    if (paramLoginReply.a != null)
    {
      localLoginInfo.businessUid = paramLoginReply.a.a;
      localLoginInfo.tinyid = paramLoginReply.a.c;
      localLoginInfo.uid = paramLoginReply.a.b;
      localLiveUserInfo.uid = paramLoginReply.a.b;
      localLiveUserInfo.nick = paramLoginReply.a.e;
      localLiveUserInfo.headUrl = paramLoginReply.a.g;
      localLiveUserInfo.sex = paramLoginReply.a.f;
    }
    if (paramLoginReply.b != null)
    {
      localLoginInfo.a2 = paramLoginReply.b.a;
      localLoginInfo.a2ExpireTime = paramLoginReply.b.b;
    }
    localLoginInfo.lastLoginTime = NetConnInfoCenter.getServerTime();
    if (this.g.getConfigModule() != null) {
      localLoginInfo.clientType = this.g.getConfigModule().getConfigData().getLiveClientType();
    }
    if ((a(localLoginInfo)) && (a(localLiveUserInfo)))
    {
      a(localLoginInfo, localLiveUserInfo);
      g();
      d();
      if (QLog.isColorLevel()) {
        QLog.d("LoginLogic", 2, " onLogin call success  ");
      }
      b(this.b, this.c);
      return;
    }
    a(9999, "checkLoginInfo invalid");
  }
  
  private boolean a()
  {
    if ((isLogined()) && (!b(this.b)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginLogic", 2, "initLoginData: is logined or logining ");
      }
      return true;
    }
    return false;
  }
  
  private boolean a(LoginInfo paramLoginInfo)
  {
    if (paramLoginInfo == null)
    {
      QLog.e("LoginLogic", 1, "checkInvalidInfoAndLog, loginInfo is null");
      return false;
    }
    if (paramLoginInfo.uid <= 0L)
    {
      QLog.e("LoginLogic", 1, "checkInvalidInfoAndLog, loginInfo uid invalid");
      return false;
    }
    if (TextUtils.isEmpty(paramLoginInfo.openId))
    {
      QLog.e("LoginLogic", 1, "checkInvalidInfoAndLog, loginInfo openid invalid");
      return false;
    }
    return true;
  }
  
  private boolean a(LiveUserInfo paramLiveUserInfo)
  {
    if (paramLiveUserInfo == null)
    {
      QLog.e("LoginLogic", 1, "checkUserInfo, userInfo is null");
      return false;
    }
    if (paramLiveUserInfo.uid <= 0L)
    {
      QLog.e("LoginLogic", 1, "checkUserInfo, userInfo uid invalid");
      return false;
    }
    return true;
  }
  
  private void b(LoginInfo paramLoginInfo, LiveUserInfo paramLiveUserInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doCacheAction nick ");
      localStringBuilder.append(paramLiveUserInfo.nick);
      localStringBuilder.append(" uid + ");
      localStringBuilder.append(paramLoginInfo.uid);
      QLog.d("LoginLogic", 2, localStringBuilder.toString());
    }
    this.d.a(paramLoginInfo, paramLiveUserInfo);
  }
  
  private void b(String paramString1, String paramString2)
  {
    GetOpenInfoReq localGetOpenInfoReq;
    if ((paramString1 != null) && (!paramString1.isEmpty()) && (c()))
    {
      localGetOpenInfoReq = new GetOpenInfoReq();
      localGetOpenInfoReq.c = 64;
      localGetOpenInfoReq.b = paramString2;
    }
    try
    {
      localGetOpenInfoReq.d = Long.parseLong(this.g.getAppId(), 10);
      localGetOpenInfoReq.a = Long.parseLong(paramString1, 10);
    }
    catch (Exception paramString1)
    {
      label68:
      break label68;
    }
    localGetOpenInfoReq.a = 0L;
    QLog.e("LoginLogic", 1, "[Param error]parse uin fail");
    paramString1 = (IQQLiveSsoModule)this.g.getExtModule("sso_module");
    if (paramString1 != null)
    {
      paramString1.a("trpc.qlive.login_svr.Login", "GetOpenInfo", GetOpenInfoReq.toByteArray(localGetOpenInfoReq), 101, this);
      return;
      a(-1, "[Param error]the uin is null");
    }
  }
  
  private boolean b()
  {
    LoginInfo localLoginInfo = e();
    LiveUserInfo localLiveUserInfo = f();
    if (a(localLoginInfo))
    {
      if (!a(localLiveUserInfo)) {
        return false;
      }
      if (b(localLoginInfo))
      {
        QLog.e("LoginLogic", 1, "sp cache expire");
        return false;
      }
      if (localLoginInfo.uid != localLiveUserInfo.uid)
      {
        QLog.e("LoginLogic", 1, "loginInfo.uid != userInfo.uid");
        return false;
      }
      a(localLoginInfo, localLiveUserInfo);
      return true;
    }
    return false;
  }
  
  private boolean b(LoginInfo paramLoginInfo)
  {
    return (paramLoginInfo == null) || (c(paramLoginInfo)) || (d(paramLoginInfo));
  }
  
  private boolean c()
  {
    if (this.g == null)
    {
      QLog.d("LoginLogic", 4, "the sdk is null or been destroyed");
      return false;
    }
    return true;
  }
  
  private boolean c(LoginInfo paramLoginInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("current access token time gap ");
    localStringBuilder.append(NetConnInfoCenter.getServerTime() - paramLoginInfo.lastLoginTime);
    localStringBuilder.append(" access token expire time ");
    localStringBuilder.append(6000L);
    QLog.d("LoginLogic", 4, localStringBuilder.toString());
    return NetConnInfoCenter.getServerTime() - paramLoginInfo.lastLoginTime >= 6000L;
  }
  
  private void d()
  {
    try
    {
      this.e = 1;
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext()) {
        ((IQQLiveLoginCallback)localIterator.next()).onSuccess(this.b);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("LoginLogic", 1, localThrowable, new Object[0]);
    }
  }
  
  private boolean d(LoginInfo paramLoginInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("current server time period ");
    localStringBuilder.append(NetConnInfoCenter.getServerTime() - paramLoginInfo.lastLoginTime + 259200L);
    localStringBuilder.append(" a2 expire time ");
    localStringBuilder.append(paramLoginInfo.a2ExpireTime);
    QLog.d("LoginLogic", 4, localStringBuilder.toString());
    return NetConnInfoCenter.getServerTime() - paramLoginInfo.lastLoginTime + 259200L >= paramLoginInfo.a2ExpireTime;
  }
  
  private LoginInfo e()
  {
    LoginInfo localLoginInfo = this.d.a();
    if ((localLoginInfo.originUin.equals(this.f.getCurrentUin())) && (localLoginInfo.clientType == this.g.getConfigModule().getConfigData().getLiveClientType()))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getLoginInfoFromSP: uid ");
        localStringBuilder.append(localLoginInfo.uid);
        localStringBuilder.append(" uin ");
        localStringBuilder.append(localLoginInfo.originUin);
        QLog.d("LoginLogic", 2, localStringBuilder.toString());
      }
      return localLoginInfo;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginLogic", 2, "the cache is null or the uin is not the same in current app runtime");
    }
    return null;
  }
  
  private LiveUserInfo f()
  {
    return this.d.b();
  }
  
  private void g()
  {
    ThreadManager.getUIHandler().postDelayed(this.h, 6000000L);
  }
  
  public void a(String paramString1, String paramString2)
  {
    QLog.d("LoginLogic", 4, "do login action");
    if (c())
    {
      com.tencent.trpcprotocol.ilive.loginSvr.loginSvr.nano.LoginRequest localLoginRequest = new com.tencent.trpcprotocol.ilive.loginSvr.loginSvr.nano.LoginRequest();
      localLoginRequest.d = paramString1;
      localLoginRequest.e = paramString2;
      localLoginRequest.c = QQDeviceInfo.getQIMEI();
      localLoginRequest.f = getAppId();
      localLoginRequest.a = this.g.getConfigModule().getConfigData().getLiveClientType();
      paramString1 = (IQQLiveSsoModule)this.g.getExtModule("sso_module");
      if (paramString1 != null) {
        paramString1.a("trpc.qlive.login_svr.Login", "Login", com.tencent.trpcprotocol.ilive.loginSvr.loginSvr.nano.LoginRequest.toByteArray(localLoginRequest), 102, this);
      }
    }
  }
  
  public void destroy()
  {
    this.e = 0;
    this.i.clear();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clear all login callback size: ");
    localStringBuilder.append(this.i.size());
    QLog.d("LoginLogic", 4, localStringBuilder.toString());
    ThreadCenter.b(this, this.h);
  }
  
  public String getAppId()
  {
    return this.g.getAppId();
  }
  
  public LoginInfo getLoginInfo()
  {
    return this.b;
  }
  
  public com.tencent.mobileqq.qqlive.data.login.LoginRequest getLoginRequest()
  {
    return this.a;
  }
  
  public int getLoginStatus()
  {
    return this.e;
  }
  
  public LiveUserInfo getUserInfo()
  {
    return this.c;
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    this.g = paramIQQLiveSDK;
    this.f = paramIQQLiveSDK.getAppRuntime();
    this.d = new LoginCacheManager(this.f, paramIQQLiveSDK.getAppId(), this.f.getCurrentUin());
  }
  
  public boolean isLogined()
  {
    return this.e == 1;
  }
  
  public void logOut() {}
  
  public void login(com.tencent.mobileqq.qqlive.data.login.LoginRequest paramLoginRequest, IQQLiveLoginCallback paramIQQLiveLoginCallback)
  {
    this.a = paramLoginRequest;
    if (!this.i.contains(paramIQQLiveLoginCallback)) {
      this.i.add(paramIQQLiveLoginCallback);
    }
    if (a())
    {
      QLog.i("LoginLogic", 1, "from mem cache");
      d();
      return;
    }
    if (b())
    {
      QLog.i("LoginLogic", 1, "from sp cache");
      d();
      return;
    }
    QLog.i("LoginLogic", 1, "do login");
    a(this.a);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    if (paramBoolean) {
      if ((paramQQLiveRspData != null) && (paramQQLiveRspData.a() != null))
      {
        StringBuilder localStringBuilder;
        if (paramQQLiveRspData.c() != 0)
        {
          paramInt = paramQQLiveRspData.c();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("business error ");
          localStringBuilder.append(paramQQLiveRspData.e());
          a(paramInt, localStringBuilder.toString());
          return;
        }
        if (paramInt == 101) {
          try
          {
            paramQQLiveRspData = GetOpenInfoRsp.a(paramQQLiveRspData.a());
            this.a.accessToken = paramQQLiveRspData.b;
            this.a.openId = paramQQLiveRspData.a;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("openId ");
            localStringBuilder.append(paramQQLiveRspData.a);
            localStringBuilder.append("accessToken  ");
            localStringBuilder.append(paramQQLiveRspData.b);
            QLog.d("LoginLogic", 4, localStringBuilder.toString());
            a(paramQQLiveRspData.a, paramQQLiveRspData.b);
            return;
          }
          catch (Exception paramQQLiveRspData)
          {
            a(-1, "get open info fail");
            QLog.e("LoginLogic", 1, "get Auth request fail", paramQQLiveRspData);
            return;
          }
        }
        if (paramInt != 102) {
          break label240;
        }
      }
    }
    try
    {
      a(LoginReply.a(paramQQLiveRspData.a()));
      return;
    }
    catch (Exception paramQQLiveRspData)
    {
      label214:
      break label214;
    }
    a(-1, "do login action fail");
    QLog.e("LoginLogic", 1, "get Auth request fail");
    return;
    a(-1, "the data is null");
    label240:
  }
  
  public void reLogin()
  {
    a(this.a);
  }
  
  public void registerLoginStateCallback(IQQLiveLoginCallback paramIQQLiveLoginCallback)
  {
    if (!this.i.contains(paramIQQLiveLoginCallback)) {
      this.i.add(paramIQQLiveLoginCallback);
    }
  }
  
  public void reset()
  {
    this.e = 0;
    this.i.clear();
    ThreadCenter.b(this, this.h);
  }
  
  public void unregisterLoginStateCallback(IQQLiveLoginCallback paramIQQLiveLoginCallback)
  {
    this.i.remove(paramIQQLiveLoginCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.login.LoginLogic
 * JD-Core Version:    0.7.0.1
 */