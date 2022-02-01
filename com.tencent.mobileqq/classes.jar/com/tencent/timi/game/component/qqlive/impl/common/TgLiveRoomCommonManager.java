package com.tencent.timi.game.component.qqlive.impl.common;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.data.config.QQLiveSDKConfig;
import com.tencent.mobileqq.qqlive.data.config.QQLiveSDKConfig.Builder;
import com.tencent.mobileqq.qqlive.data.login.LoginRequest;
import com.tencent.mobileqq.qqlive.data.room.realtime.LiveRealTimeInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.timi.game.component.qqlive.impl.anchor.TgLiveAnchorRoomManager;
import com.tencent.timi.game.component.qqlive.impl.audience.TgLiveAudienceRoomManager;
import com.tencent.timi.game.component.qqlive.impl.util.TgLiveUtils;
import com.tencent.timi.game.initer.impl.GiftSdkInitManager;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class TgLiveRoomCommonManager
  implements ITgLiveRoomCommonManager
{
  private static volatile TgLiveRoomCommonManager a;
  private final MutableLiveData<Boolean> b = new MutableLiveData();
  private volatile boolean c;
  private volatile boolean d = false;
  private IQQLiveSDK e;
  private volatile boolean f = false;
  
  public static TgLiveRoomCommonManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new TgLiveRoomCommonManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public static void a(@NonNull ILiveRoom paramILiveRoom, IResultListener<LiveRealTimeInfo> paramIResultListener)
  {
    Logger.a("TgLiveTag_TgLiveRoomCommonManager", "getRealTimeInfoForEndLiveUI.");
    paramILiveRoom.getRoomRealTimeInfo(new TgLiveRoomCommonManager.2(paramIResultListener));
  }
  
  private void d()
  {
    Logger.a("TgLiveTag_TgLiveRoomCommonManager", 1, "destroyLiveSDK");
    GiftSdkInitManager.a.b(10001);
    if (this.e != null)
    {
      ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).destroySDKImpl("1054");
      this.b.setValue(Boolean.valueOf(false));
      this.c = false;
      this.e = null;
      this.d = false;
    }
    TgLiveAudienceRoomManager.a().c();
  }
  
  public LiveData<Boolean> a(@NonNull AppRuntime paramAppRuntime, IResultListener<Boolean> paramIResultListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initLiveSDK enter - mQQLiveSDKInitLoginSuc = ");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(", mIsIniting = ");
    ((StringBuilder)localObject).append(this.d);
    Logger.a("TgLiveTag_TgLiveRoomCommonManager", 1, ((StringBuilder)localObject).toString());
    if (this.c)
    {
      if (paramIResultListener != null) {
        paramIResultListener.a(Boolean.valueOf(this.c));
      }
      return this.b;
    }
    if (this.d) {
      return this.b;
    }
    this.d = true;
    this.e = ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).getSDKImpl("1037");
    localObject = QQLiveSDKConfig.createBuilder().build();
    this.e.init(paramAppRuntime, (QQLiveSDKConfig)localObject);
    GiftSdkInitManager.a.a(10001);
    localObject = new LoginRequest();
    ((LoginRequest)localObject).uin = paramAppRuntime.getCurrentUin();
    ((LoginRequest)localObject).qqA2 = ((TicketManager)paramAppRuntime.getManager(2)).getA2(((LoginRequest)localObject).uin);
    this.e.getLoginModule().login((LoginRequest)localObject, new TgLiveRoomCommonManager.1(this, paramIResultListener));
    return this.b;
  }
  
  public void a(IResultListener<LiveRealTimeInfo> paramIResultListener)
  {
    if (this.f) {
      return;
    }
    this.f = true;
    try
    {
      if (TgLiveAudienceRoomManager.a().b() != null) {
        TgLiveAudienceRoomManager.a().a(0L, paramIResultListener);
      } else {
        TgLiveAnchorRoomManager.a().a(paramIResultListener);
      }
      d();
      TgLiveUtils.b(true);
      TgLiveUtils.b(false);
      return;
    }
    finally
    {
      this.f = false;
    }
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public IQQLiveSDK c()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.common.TgLiveRoomCommonManager
 * JD-Core Version:    0.7.0.1
 */