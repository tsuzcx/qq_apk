package com.tencent.mobileqq.guild.live.livemanager;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.live.QQGuildLiveStartParamsCache;
import com.tencent.mobileqq.guild.live.livemanager.anchor.QQGuildLiveAnchorRoomMgr;
import com.tencent.mobileqq.guild.live.livemanager.audience.QQGuildLiveAudienceRoomMgr;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.util.GuildAVPriorityManager;
import com.tencent.mobileqq.guild.util.livedata.LiveDataExtKt;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.data.config.QQLiveSDKConfig;
import com.tencent.mobileqq.qqlive.data.config.QQLiveSDKConfig.Builder;
import com.tencent.mobileqq.qqlive.data.login.LoginRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class QQGuildLiveRoomCommMgr
  implements IQQGuildLiveRoomCommMgr
{
  private static final QQGuildLiveRoomCommMgr a = new QQGuildLiveRoomCommMgr();
  private final MutableLiveData<Boolean> b = new MutableLiveData();
  private volatile boolean c;
  private volatile boolean d = false;
  private IQQLiveSDK e;
  private volatile boolean f = false;
  
  public static QQGuildLiveRoomCommMgr a()
  {
    return a;
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QGL.QQGuildLiveRoomCommMgr", 1, "destroyLiveSDK.");
    }
    if (this.e != null)
    {
      ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).destroySDKImpl("1054");
      this.b.setValue(Boolean.valueOf(false));
      this.c = false;
      this.e = null;
      this.d = false;
    }
  }
  
  public LiveData<Boolean> a(@NonNull AppRuntime paramAppRuntime)
  {
    QLog.d("QGL.QQGuildLiveRoomCommMgr", 4, "initLiveSDK enter");
    if (this.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QGL.QQGuildLiveRoomCommMgr", 1, "initLiveSDK mQQLiveSDKInitLoginSuc == true");
      }
      return this.b;
    }
    if (this.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QGL.QQGuildLiveRoomCommMgr", 1, "initLiveSDK mIsIniting == true");
      }
      return this.b;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QGL.QQGuildLiveRoomCommMgr", 1, "initLiveSDK start");
    }
    this.d = true;
    this.e = ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).getSDKImpl("1054");
    Object localObject = QQLiveSDKConfig.createBuilder().build();
    this.e.init(paramAppRuntime, (QQLiveSDKConfig)localObject);
    localObject = new LoginRequest();
    ((LoginRequest)localObject).uin = paramAppRuntime.getCurrentUin();
    ((LoginRequest)localObject).qqA2 = ((TicketManager)paramAppRuntime.getManager(2)).getA2(((LoginRequest)localObject).uin);
    this.e.getLoginModule().login((LoginRequest)localObject, new QQGuildLiveRoomCommMgr.1(this));
    return this.b;
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public IQQLiveSDK c()
  {
    return this.e;
  }
  
  public LiveData<Boolean> d()
  {
    return this.b;
  }
  
  public void e()
  {
    if (this.f) {
      return;
    }
    QLog.i("QGL.QQGuildLiveRoomCommMgr", 1, "exitLiveRoomAndDestroySDK enter.");
    this.f = true;
    try
    {
      QQGuildLiveEventHelper.a().c();
      if (((Boolean)LiveDataExtKt.a(QQGuildLiveRoomUiData.a().b(), Boolean.valueOf(false))).booleanValue()) {
        QQGuildLiveAnchorRoomMgr.a().a(false);
      } else {
        QQGuildLiveAudienceRoomMgr.a().b();
      }
      f();
      QQGuildLiveStartParamsCache.a(null);
      GuildAVPriorityManager.a("频道直播");
      GuildAVPriorityManager.a("频道观看直播");
      return;
    }
    finally
    {
      this.f = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveRoomCommMgr
 * JD-Core Version:    0.7.0.1
 */