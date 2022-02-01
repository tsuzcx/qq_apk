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
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private final BusinessObserver jdField_a_of_type_ComTencentMobileqqAppBusinessObserver;
  private IntervalChecker jdField_a_of_type_ComTencentMobileqqOnlinestatusIntervalChecker;
  private LocationInfo jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationInfo;
  StudyModeChangeListener jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener = new OnlineStatusDataManager.2(this);
  Runnable jdField_a_of_type_JavaLangRunnable = new OnlineStatusDataManager.3(this);
  private ConcurrentHashMap<String, LocationMapInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
  private boolean jdField_a_of_type_Boolean = false;
  Runnable b = new OnlineStatusDataManager.4(this);
  
  public OnlineStatusDataManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver = new OnlineStatusDataManager.1(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
    ((IStudyModeManager)QRoute.api(IStudyModeManager.class)).registerStudyModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener);
    if (GuardManager.a != null) {
      GuardManager.a.a(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIntervalChecker = new IntervalChecker();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getSubThreadLooper());
  }
  
  private long a(long paramLong)
  {
    if (paramLong == 1000L)
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIntervalChecker.a(1000);
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
  
  private boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if ((localObject != null) && (((AppInterface)localObject).isRunning())) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      if (localObject == null) {
        localObject = "null";
      } else {
        localObject = Boolean.valueOf(((AppInterface)localObject).isRunning());
      }
      QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "checkAppValid app.isRunning=", localObject });
    }
    return false;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, long paramLong)
  {
    paramAppRuntime = ((IFriendDataService)paramAppRuntime.getRuntimeService(IFriendDataService.class, "")).getFriend(paramAppRuntime.getCurrentUin(), true, true, true);
    if (paramAppRuntime == null) {
      return true;
    }
    return paramLong - paramAppRuntime.weatherUpdateTime > 3600L;
  }
  
  public void G_()
  {
    if (!a()) {
      return;
    }
    IOnlineStatusService localIOnlineStatusService = (IOnlineStatusService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusService.class, "");
    AppRuntime.Status localStatus = localIOnlineStatusService.getOnlineStatus();
    long l = localIOnlineStatusService.getExtOnlineStatus();
    if ((localStatus == AppRuntime.Status.online) && (l == 1030L))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.b);
      this.jdField_a_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusDataManagerImpl", 2, "onRunningForground");
      }
    }
  }
  
  public void H_()
  {
    if (!a()) {
      return;
    }
    IOnlineStatusService localIOnlineStatusService = (IOnlineStatusService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusService.class, "");
    AppRuntime.Status localStatus = localIOnlineStatusService.getOnlineStatus();
    long l = localIOnlineStatusService.getExtOnlineStatus();
    if ((localStatus == AppRuntime.Status.online) && (l == 1030L) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface.isBackgroundStop))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.b);
      this.jdField_a_of_type_AndroidOsHandler.post(this.b);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusDataManagerImpl", 2, "onRunningBackground");
      }
    }
  }
  
  public void a()
  {
    d();
    ((IStudyModeManager)QRoute.api(IStudyModeManager.class)).unregisterStudyModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener);
    if (GuardManager.a != null) {
      GuardManager.a.b(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIntervalChecker.a();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
  }
  
  public void a(int paramInt)
  {
    a(paramInt, new Intent());
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
    if (LocationInfo.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationInfo, paramDouble1, paramDouble2, paramString1)) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationInfo = new LocationInfo(paramDouble1, paramDouble2, paramString2, paramString1);
    } else {
      bool = false;
    }
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationInfo;
    if (paramString1 == null) {
      return;
    }
    a(paramInt2, paramString1, paramIntent, bool);
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIntervalChecker.a(paramInt, paramLong);
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "sendLocationInfo type:", Integer.valueOf(paramInt) });
    }
    if (b(paramInt)) {
      LocationUtil.a(paramInt, paramIntent, this);
    }
  }
  
  void a(int paramInt, LocationInfo paramLocationInfo, Intent paramIntent, boolean paramBoolean)
  {
    if ((paramBoolean) || (a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, NetConnInfoCenter.getServerTime())) || (paramInt == 9))
    {
      boolean bool = QLog.isColorLevel();
      int j = 0;
      if (bool) {
        QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "gotoNextStep type：", Integer.valueOf(paramInt), " isLocationChange:", Boolean.valueOf(paramBoolean) });
      }
      ArrayList localArrayList = new ArrayList(2);
      localArrayList.add(Integer.valueOf(1));
      localArrayList.add(Integer.valueOf(10));
      int i;
      try
      {
        i = Integer.valueOf(paramLocationInfo.c).intValue();
      }
      catch (NumberFormatException paramLocationInfo)
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("OnlineStatusDataManagerImpl", 4, "handleFetchWeatherInfo numberFormat", paramLocationInfo);
          i = j;
        }
      }
      OnlineStatusWeatherServlet.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localArrayList, i, paramInt, paramIntent.getExtras());
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIntervalChecker.b((int)paramLong1, paramLong2);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, AppRuntime.Status paramStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "sendBussinessInfoRegisterPush succ:", Boolean.valueOf(paramBoolean), " mSyncPause:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    if ((paramBoolean) && (paramStatus == AppRuntime.Status.online))
    {
      IOnlineStatusService localIOnlineStatusService = (IOnlineStatusService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusService.class, "");
      long l = localIOnlineStatusService.getExtOnlineStatus();
      paramStatus = (OnlineStatusHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(OnlineStatusHandler.class.getName());
      if (l == 1000L)
      {
        try
        {
          localIOnlineStatusService.setPowerConnect(OnLineStatusHelper.c());
        }
        catch (Throwable localThrowable)
        {
          QLog.e("OnlineStatusDataManagerImpl", 1, "registerPush t:", localThrowable);
        }
        paramStatus.a(1, OnLineStatusHelper.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true), null);
      }
      else if ((l == 1030L) && (!this.jdField_a_of_type_Boolean))
      {
        a(6);
      }
      else if (l == 1040L)
      {
        paramStatus = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
        paramStatus = ConstellationUtilKt.b(paramStatus, paramStatus.getCurrentAccountUin());
        Object localObject;
        if (TextUtils.isEmpty(paramStatus))
        {
          paramStatus = (IProfileProtocolService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IProfileProtocolService.class, "all");
          if (paramStatus != null) {
            paramStatus.requestProfileCard(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin(), 0, 0L, (byte)1, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
          }
          paramStatus = (IProfileCardUtil)QRoute.api(IProfileCardUtil.class);
          localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
          this.jdField_a_of_type_Long = paramStatus.initCard((AppRuntime)localObject, ((AppInterface)localObject).getCurrentAccountUin()).lBirthday;
          if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "sendBussinessInfoRegisterPush: invoked. [constellation] (星座不存在，那么执行一次资料拉取，在资料回调中拉取运势)", " mSelfCurrentBirthday: ", Long.valueOf(this.jdField_a_of_type_Long) });
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
          paramBoolean = TextUtils.isEmpty(ConstellationUtilKt.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject));
          if (paramBoolean) {
            OnlineStatusExtInfoServlet.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramStatus);
          }
          if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "sendBussinessInfoRegisterPush: invoked. (注册上线时，星座资料不空，但运势为空，那么执行一次运势拉取逻辑)", " emptyTrend: ", Boolean.valueOf(paramBoolean) });
          }
        }
      }
      d(l);
      c();
    }
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIntervalChecker.a(paramInt);
  }
  
  public void b(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIntervalChecker.b(paramInt, paramLong);
  }
  
  public void b(int paramInt, Intent paramIntent)
  {
    OnlineStatusHandler localOnlineStatusHandler = (OnlineStatusHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(OnlineStatusHandler.class.getName());
    Object localObject = ((IFriendDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFriendDataService.class, "")).getFriend(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin(), true, true, true);
    Bundle localBundle = OnLineStatusHelper.a().a((Friends)localObject);
    localBundle.putBoolean("from_need_update_delay_time", true);
    if ((7 == paramInt) && (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIntervalChecker.a(1030)))
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
  
  public void b(long paramLong) {}
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener.onChange(paramBoolean);
  }
  
  public boolean b(int paramInt)
  {
    return (paramInt == 6) || (paramInt == 7) || (paramInt == 8) || (paramInt == 9);
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if ((localObject != null) && (((AppInterface)localObject).isRunning()))
    {
      localObject = (IOnlineStatusService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusService.class, "");
      AppRuntime.Status localStatus = ((IOnlineStatusService)localObject).getOnlineStatus();
      long l1 = ((IOnlineStatusService)localObject).getExtOnlineStatus();
      if ((localStatus == AppRuntime.Status.online) && ((l1 == 1000L) || (l1 == 1030L) || (l1 == 1040L)))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        long l2 = a(l1);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L * l2);
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "launchTimedMsgTask schedule msgTimer after ", Long.valueOf(l2), " seconds", " extStatus: ", Long.valueOf(l1) });
        }
      }
      else
      {
        d();
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "launchTimedMsgTask cancel status", localStatus, " extStatus:", Long.valueOf(l1) });
        }
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      if (localObject == null) {
        localObject = "null";
      } else {
        localObject = Boolean.valueOf(((AppInterface)localObject).isRunning());
      }
      QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "launchTimedMsgTask app.isRunning=", localObject });
    }
  }
  
  public void c(long paramLong) {}
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null)
    {
      if (QLog.isColorLevel())
      {
        Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
        if (localObject == null) {
          localObject = "null";
        } else {
          localObject = Boolean.valueOf(((AppInterface)localObject).isRunning());
        }
        QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "cancelTimedMsgTask app.isRunning=", localObject });
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusDataManagerImpl", 2, "cancelTimedMsgTask");
    }
  }
  
  public void d(long paramLong)
  {
    Object localObject = (IOnlineStatusManagerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusManagerService.class, "");
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
        OnlineStatusPermissionServlet.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 40001L, false, true);
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
    b(((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch());
  }
  
  public void e(long paramLong)
  {
    if (paramLong > 40001L)
    {
      OnlineAutoStatusBean localOnlineAutoStatusBean = (OnlineAutoStatusBean)QConfigManager.a().a(652);
      ArrayList localArrayList = new ArrayList();
      if (localOnlineAutoStatusBean.a.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = localOnlineAutoStatusBean.a.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add(Long.valueOf(((AutoStatusItem)localIterator.next()).jdField_a_of_type_Long));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "resetWhenAutoStatusItemRemoved: invoked.  [status][reset-default]", " configIds: ", localArrayList, " extStatus: ", Long.valueOf(paramLong) });
      }
      if ((!localArrayList.isEmpty()) && (localOnlineAutoStatusBean.a()) && (!localArrayList.contains(Long.valueOf(paramLong))))
      {
        ((IOnlineStatusService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(AppRuntime.Status.online, 0L, true);
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
  
  public void f(long paramLong)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2;
    if ((paramLong > 0L) && (paramLong < 40000L))
    {
      localObject3 = OnLineStatusHelper.a().b();
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
          ((ArrayList)localObject2).add(Long.valueOf(((OnlineStatusItem)((Iterator)localObject3).next()).jdField_a_of_type_Long));
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
            ((IOnlineStatusService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(AppRuntime.Status.online, 0L, true);
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
  
  public void g(long paramLong)
  {
    OnlineAutoStatusBean localOnlineAutoStatusBean = (OnlineAutoStatusBean)QConfigManager.a().a(652);
    OnlineStatusItem localOnlineStatusItem = localOnlineAutoStatusBean.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem;
    if ((localOnlineStatusItem != null) && (localOnlineStatusItem.jdField_a_of_type_Long == 0L) && (localOnlineAutoStatusBean.a()) && (paramLong > 40000L))
    {
      ((IOnlineStatusService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(AppRuntime.Status.online, 0L, true);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "resetWhenAutoStatusEntranceRemoved: invoked. [status][reset-default] finish. ", " item: ", localOnlineStatusItem });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager
 * JD-Core Version:    0.7.0.1
 */