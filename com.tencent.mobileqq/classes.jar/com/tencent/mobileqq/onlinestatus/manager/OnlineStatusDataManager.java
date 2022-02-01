package com.tencent.mobileqq.onlinestatus.manager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineAutoStatusBean;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.IntervalChecker;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusExtInfoServlet;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionServlet;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.auto.location.LocationUtil;
import com.tencent.mobileqq.onlinestatus.auto.location.OnlineStatusWeatherLocationListener.WeatherLocationCallback;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusElement;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusItem;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationUtilKt;
import com.tencent.mobileqq.onlinestatus.location.LocationInfo;
import com.tencent.mobileqq.onlinestatus.location.LocationMapInfo;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;
import com.tencent.mobileqq.onlinestatus.weather.OnlineStatusWeatherServlet;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IProfileCardUtil;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;

public class OnlineStatusDataManager
  implements IGuardInterface, OnlineStatusWeatherLocationListener.WeatherLocationCallback, IOnlineStatusDataManager
{
  StudyModeChangeListener a = new OnlineStatusDataManager.2(this);
  Runnable b = new OnlineStatusDataManager.3(this);
  Runnable c = new OnlineStatusDataManager.4(this);
  private AppInterface d;
  private final BusinessObserver e;
  private long f;
  private Handler g;
  private LocationInfo h;
  private ConcurrentHashMap<String, LocationMapInfo> i = new ConcurrentHashMap(10);
  private IntervalChecker j;
  private boolean k = false;
  
  public OnlineStatusDataManager(AppInterface paramAppInterface)
  {
    this.d = paramAppInterface;
    this.e = new OnlineStatusDataManager.1(this);
    this.d.addObserver(this.e);
    ((IStudyModeManager)QRoute.api(IStudyModeManager.class)).registerStudyModeChangeListener(this.a);
    if (GuardManager.sInstance != null) {
      GuardManager.sInstance.registerCallBack(this);
    }
    this.j = new IntervalChecker();
    this.g = new Handler(ThreadManagerV2.getSubThreadLooper());
  }
  
  public static boolean a(AppRuntime paramAppRuntime, long paramLong)
  {
    paramAppRuntime = ((IFriendDataService)paramAppRuntime.getRuntimeService(IFriendDataService.class, "")).getFriend(paramAppRuntime.getCurrentUin(), true, true, true);
    if (paramAppRuntime == null) {
      return true;
    }
    return paramLong - paramAppRuntime.weatherUpdateTime > 3600L;
  }
  
  private boolean d()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((AppInterface)localObject).isRunning())) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      localObject = this.d;
      if (localObject == null) {
        localObject = "null";
      } else {
        localObject = Boolean.valueOf(((AppInterface)localObject).isRunning());
      }
      QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "checkAppValid app.isRunning=", localObject });
    }
    return false;
  }
  
  private long e(long paramLong)
  {
    if (paramLong == 1000L)
    {
      long l = this.j.b(1000);
      paramLong = l;
      if (l == 0L) {
        return 300L;
      }
    }
    else
    {
      paramLong = 1800L;
    }
    return paramLong;
  }
  
  public void a()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((AppInterface)localObject).isRunning()))
    {
      localObject = (IOnlineStatusService)this.d.getRuntimeService(IOnlineStatusService.class, "");
      AppRuntime.Status localStatus = ((IOnlineStatusService)localObject).getOnlineStatus();
      long l1 = ((IOnlineStatusService)localObject).getExtOnlineStatus();
      if ((localStatus == AppRuntime.Status.online) && ((l1 == 1000L) || (l1 == 1030L) || (l1 == 1040L)))
      {
        this.g.removeCallbacks(this.b);
        long l2 = e(l1);
        this.g.postDelayed(this.b, 1000L * l2);
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "launchTimedMsgTask schedule msgTimer after ", Long.valueOf(l2), " seconds", " extStatus: ", Long.valueOf(l1) });
        }
      }
      else
      {
        b();
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "launchTimedMsgTask cancel status", localStatus, " extStatus:", Long.valueOf(l1) });
        }
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = this.d;
      if (localObject == null) {
        localObject = "null";
      } else {
        localObject = Boolean.valueOf(((AppInterface)localObject).isRunning());
      }
      QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "launchTimedMsgTask app.isRunning=", localObject });
    }
  }
  
  public void a(int paramInt1, double paramDouble1, double paramDouble2, String paramString1, String paramString2, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    if (paramInt1 != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "retCode：", Integer.valueOf(paramInt1) });
      }
      return;
    }
    if (LocationInfo.a(this.h, paramDouble1, paramDouble2, paramString1)) {
      this.h = new LocationInfo(paramDouble1, paramDouble2, paramString2, paramString1);
    } else {
      bool = false;
    }
    paramString1 = this.h;
    if (paramString1 == null) {
      return;
    }
    a(paramInt2, paramString1, paramIntent, bool);
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.j.a(paramInt, paramLong);
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "sendLocationInfo type:", Integer.valueOf(paramInt) });
    }
    if (c(paramInt))
    {
      AppInterface localAppInterface = this.d;
      boolean bool;
      if ((localAppInterface != null) && (!localAppInterface.isBackgroundStop)) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "isAppForeground", Boolean.valueOf(bool) });
      }
      paramIntent.putExtra("isAppForeground", bool);
      LocationUtil.a(paramInt, paramIntent, this);
    }
  }
  
  void a(int paramInt, LocationInfo paramLocationInfo, Intent paramIntent, boolean paramBoolean)
  {
    if ((paramBoolean) || (a(this.d, NetConnInfoCenter.getServerTime())) || (paramInt == 9))
    {
      boolean bool = QLog.isColorLevel();
      int n = 0;
      if (bool) {
        QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "gotoNextStep type：", Integer.valueOf(paramInt), " isLocationChange:", Boolean.valueOf(paramBoolean) });
      }
      ArrayList localArrayList = new ArrayList(2);
      localArrayList.add(Integer.valueOf(1));
      localArrayList.add(Integer.valueOf(10));
      int m;
      try
      {
        m = Integer.valueOf(paramLocationInfo.g).intValue();
      }
      catch (NumberFormatException paramLocationInfo)
      {
        m = n;
        if (QLog.isColorLevel())
        {
          QLog.d("OnlineStatusDataManagerImpl", 4, "handleFetchWeatherInfo numberFormat", paramLocationInfo);
          m = n;
        }
      }
      OnlineStatusWeatherServlet.a(this.d, localArrayList, m, paramInt, paramIntent.getExtras());
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject = (IOnlineStatusManagerService)this.d.getRuntimeService(IOnlineStatusManagerService.class, "");
    AutoStatusManager localAutoStatusManager = (AutoStatusManager)((IOnlineStatusManagerService)localObject).getManager(IAutoStatusManager.class);
    if (paramLong > 40000L)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][autoMgr] handleExtStatusChanged startDetector: ");
        localStringBuilder.append(paramLong);
        QLog.d("OnlineStatusDataManagerImpl", 2, localStringBuilder.toString());
      }
      if (((OnlineStatusPermissionManager)((IOnlineStatusManagerService)localObject).getManager(IOnlineStatusPermissionManager.class)).a()) {
        localAutoStatusManager.a("onlinePush", true);
      } else {
        OnlineStatusPermissionServlet.a(this.d, 40001L, false, true);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[status][autoMgr] handleExtStatusChanged stopDetector: ");
        ((StringBuilder)localObject).append(paramLong);
        QLog.d("OnlineStatusDataManagerImpl", 2, ((StringBuilder)localObject).toString());
      }
      localAutoStatusManager.b("onlinePush");
    }
    a(((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch());
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.j.b((int)paramLong1, paramLong2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.onChange(paramBoolean);
  }
  
  public void a(boolean paramBoolean, AppRuntime.Status paramStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "sendBussinessInfoRegisterPush succ:", Boolean.valueOf(paramBoolean), " mSyncPause:", Boolean.valueOf(this.k) });
    }
    if ((paramBoolean) && (paramStatus == AppRuntime.Status.online))
    {
      IOnlineStatusService localIOnlineStatusService = (IOnlineStatusService)this.d.getRuntimeService(IOnlineStatusService.class, "");
      long l = localIOnlineStatusService.getExtOnlineStatus();
      paramStatus = (OnlineStatusHandler)this.d.getBusinessHandler(OnlineStatusHandler.class.getName());
      if (l == 1000L)
      {
        try
        {
          localIOnlineStatusService.setPowerConnect(OnLineStatusHelper.i());
        }
        catch (Throwable localThrowable)
        {
          QLog.e("OnlineStatusDataManagerImpl", 1, "registerPush t:", localThrowable);
        }
        paramStatus.a(1, OnLineStatusHelper.a().a(this.d, true), null);
      }
      else if ((l == 1030L) && (!this.k))
      {
        b(6);
      }
      else if (l == 1040L)
      {
        paramStatus = this.d;
        paramStatus = ConstellationUtilKt.d(paramStatus, paramStatus.getCurrentAccountUin());
        Object localObject;
        if (TextUtils.isEmpty(paramStatus))
        {
          paramStatus = (IProfileProtocolService)this.d.getRuntimeService(IProfileProtocolService.class, "all");
          if (paramStatus != null) {
            paramStatus.requestProfileCard(this.d.getCurrentAccountUin(), this.d.getCurrentUin(), 0, 0L, (byte)1, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
          }
          paramStatus = (IProfileCardUtil)QRoute.api(IProfileCardUtil.class);
          localObject = this.d;
          this.f = paramStatus.initCard((AppRuntime)localObject, ((AppInterface)localObject).getCurrentAccountUin()).lBirthday;
          if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "sendBussinessInfoRegisterPush: invoked. [constellation] (星座不存在，那么执行一次资料拉取，在资料回调中拉取运势)", " mSelfCurrentBirthday: ", Long.valueOf(this.f) });
          }
        }
        else
        {
          localObject = this.d.getCurrentAccountUin();
          paramBoolean = TextUtils.isEmpty(ConstellationUtilKt.b(this.d, (String)localObject));
          if (paramBoolean) {
            OnlineStatusExtInfoServlet.a(this.d, paramStatus);
          }
          if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "sendBussinessInfoRegisterPush: invoked. (注册上线时，星座资料不空，但运势为空，那么执行一次运势拉取逻辑)", " emptyTrend: ", Boolean.valueOf(paramBoolean) });
          }
        }
      }
      a(l);
      a();
    }
  }
  
  public boolean a(int paramInt)
  {
    return this.j.a(paramInt);
  }
  
  public void b()
  {
    if (this.d == null)
    {
      if (QLog.isColorLevel())
      {
        Object localObject = this.d;
        if (localObject == null) {
          localObject = "null";
        } else {
          localObject = Boolean.valueOf(((AppInterface)localObject).isRunning());
        }
        QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "cancelTimedMsgTask app.isRunning=", localObject });
      }
      return;
    }
    this.g.removeCallbacks(this.b);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusDataManagerImpl", 2, "cancelTimedMsgTask");
    }
  }
  
  public void b(int paramInt)
  {
    a(paramInt, new Intent());
  }
  
  public void b(int paramInt, long paramLong)
  {
    this.j.b(paramInt, paramLong);
  }
  
  public void b(int paramInt, Intent paramIntent)
  {
    OnlineStatusHandler localOnlineStatusHandler = (OnlineStatusHandler)this.d.getBusinessHandler(OnlineStatusHandler.class.getName());
    Object localObject = ((IFriendDataService)this.d.getRuntimeService(IFriendDataService.class, "")).getFriend(this.d.getCurrentUin(), true, true, true);
    Bundle localBundle = OnLineStatusHelper.a().b((Friends)localObject);
    localBundle.putBoolean("from_need_update_delay_time", true);
    if ((7 == paramInt) && (this.j.a(1030)))
    {
      localOnlineStatusHandler.a(3, localBundle);
      return;
    }
    localObject = null;
    if (6 == paramInt)
    {
      localBundle.putBoolean("from_register", true);
      localOnlineStatusHandler.a(3, localBundle, null);
      return;
    }
    if (8 == paramInt)
    {
      if (paramIntent.hasExtra("online_status_permission_item")) {
        localObject = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramIntent.getSerializableExtra("online_status_permission_item");
      }
      localBundle.putBoolean("from_modify", paramIntent.getBooleanExtra("from_modify", false));
      localBundle.putBoolean("from_register", false);
      localOnlineStatusHandler.a(3, localBundle, (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject);
    }
  }
  
  public void b(long paramLong)
  {
    if (paramLong > 40001L)
    {
      OnlineAutoStatusBean localOnlineAutoStatusBean = (OnlineAutoStatusBean)QConfigManager.b().b(652);
      ArrayList localArrayList = new ArrayList();
      if (localOnlineAutoStatusBean.a.a != null)
      {
        Iterator localIterator = localOnlineAutoStatusBean.a.a.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add(Long.valueOf(((AutoStatusItem)localIterator.next()).b));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "resetWhenAutoStatusItemRemoved: invoked.  [status][reset-default]", " configIds: ", localArrayList, " extStatus: ", Long.valueOf(paramLong) });
      }
      if ((!localArrayList.isEmpty()) && (localOnlineAutoStatusBean.a()) && (!localArrayList.contains(Long.valueOf(paramLong))))
      {
        ((IOnlineStatusService)this.d.getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(AppRuntime.Status.online, 0L, true);
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusDataManagerImpl", 2, "resetWhenAutoStatusItemRemoved: invoked. [status][reset-default] finish. ");
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "resetWhenAutoStatusItemRemoved: invoked. [status][reset-default] no need reset", " extStatus: ", Long.valueOf(paramLong) });
    }
  }
  
  public void c()
  {
    b();
    ((IStudyModeManager)QRoute.api(IStudyModeManager.class)).unregisterStudyModeChangeListener(this.a);
    if (GuardManager.sInstance != null) {
      GuardManager.sInstance.unregisterCallback(this);
    }
    this.j.a();
    this.d.removeObserver(this.e);
  }
  
  public void c(long paramLong)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2;
    if ((paramLong > 0L) && (paramLong < 40000L))
    {
      localObject3 = OnLineStatusHelper.a().c();
      if (localObject3 != null)
      {
        localObject2 = new ArrayList();
        localObject3 = ((ArrayList)localObject3).iterator();
        for (;;)
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          ((ArrayList)localObject2).add(Long.valueOf(((OnlineStatusItem)((Iterator)localObject3).next()).b));
        }
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (!localObject1.isEmpty())
        {
          localObject2 = localObject1;
          if (!localObject1.contains(Long.valueOf(paramLong)))
          {
            ((IOnlineStatusService)this.d.getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(AppRuntime.Status.online, 0L, true);
            localObject2 = localObject1;
            if (QLog.isColorLevel())
            {
              QLog.d("OnlineStatusDataManagerImpl", 2, "resetWhenStatusConfigRemoved: invoked. [status][reset-default] finish. ");
              localObject2 = localObject1;
            }
          }
        }
      }
    }
    else
    {
      localObject2 = localObject3;
      if (QLog.isColorLevel())
      {
        QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "resetWhenStatusConfigRemoved: invoked. [status][reset-default] no need reset", " extStatus: ", Long.valueOf(paramLong) });
        localObject2 = localObject3;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "resetWhenStatusConfigRemoved: invoked. [status][reset-default] ", " configIds: ", localObject2, " extStatus: ", Long.valueOf(paramLong) });
    }
  }
  
  public boolean c(int paramInt)
  {
    return (paramInt == 6) || (paramInt == 7) || (paramInt == 8) || (paramInt == 9);
  }
  
  public void d(long paramLong)
  {
    OnlineAutoStatusBean localOnlineAutoStatusBean = (OnlineAutoStatusBean)QConfigManager.b().b(652);
    OnlineStatusItem localOnlineStatusItem = localOnlineAutoStatusBean.a.b;
    if ((localOnlineStatusItem != null) && (localOnlineStatusItem.b == 0L) && (localOnlineAutoStatusBean.a()) && (paramLong > 40000L))
    {
      ((IOnlineStatusService)this.d.getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(AppRuntime.Status.online, 0L, true);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "resetWhenAutoStatusEntranceRemoved: invoked. [status][reset-default] finish. ", " item: ", localOnlineStatusItem });
      }
    }
  }
  
  public void onApplicationBackground()
  {
    if (!d()) {
      return;
    }
    IOnlineStatusService localIOnlineStatusService = (IOnlineStatusService)this.d.getRuntimeService(IOnlineStatusService.class, "");
    AppRuntime.Status localStatus = localIOnlineStatusService.getOnlineStatus();
    long l = localIOnlineStatusService.getExtOnlineStatus();
    if ((localStatus == AppRuntime.Status.online) && (l == 1030L) && (this.d.isBackgroundStop))
    {
      this.g.removeCallbacks(this.c);
      this.g.post(this.c);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusDataManagerImpl", 2, "onRunningBackground");
      }
    }
  }
  
  public void onApplicationForeground()
  {
    if (!d()) {
      return;
    }
    IOnlineStatusService localIOnlineStatusService = (IOnlineStatusService)this.d.getRuntimeService(IOnlineStatusService.class, "");
    AppRuntime.Status localStatus = localIOnlineStatusService.getOnlineStatus();
    long l = localIOnlineStatusService.getExtOnlineStatus();
    if ((localStatus == AppRuntime.Status.online) && (l == 1030L))
    {
      this.g.removeCallbacks(this.c);
      this.k = false;
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusDataManagerImpl", 2, "onRunningForground");
      }
    }
  }
  
  public void onBackgroundTimeTick(long paramLong) {}
  
  public void onBackgroundUnguardTimeTick(long paramLong) {}
  
  public void onLiteTimeTick(long paramLong) {}
  
  public void onScreensStateChanged(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager
 * JD-Core Version:    0.7.0.1
 */