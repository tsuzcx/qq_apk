package com.tencent.mobileqq.onlinestatus;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.ForeBackgroundSwitch;
import com.tencent.mobileqq.app.ForeBackgroundSwitch.Callback;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineAutoStatusBean;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.auto.AutoStatusManager;
import com.tencent.mobileqq.onlinestatus.auto.location.LocationUtil;
import com.tencent.mobileqq.onlinestatus.auto.location.OnlineStatusWeatherLocationListener.WeatherLocationCallback;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusElement;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusItem;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationUtilKt;
import com.tencent.mobileqq.onlinestatus.location.LocationInfo;
import com.tencent.mobileqq.onlinestatus.location.LocationMapInfo;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;
import com.tencent.mobileqq.onlinestatus.weather.OnlineStatusWeatherServlet;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime.Status;
import mqq.manager.Manager;

public class OnlineStatusManager
  implements Handler.Callback, ForeBackgroundSwitch.Callback, OnlineStatusWeatherLocationListener.WeatherLocationCallback, Manager
{
  private long jdField_a_of_type_Long;
  private final BusinessObserver jdField_a_of_type_ComTencentMobileqqAppBusinessObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IntervalChecker jdField_a_of_type_ComTencentMobileqqOnlinestatusIntervalChecker;
  private AutoStatusManager jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager;
  private LocationInfo jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationInfo;
  StudyModeChangeListener jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener = new OnlineStatusManager.3(this);
  Runnable jdField_a_of_type_JavaLangRunnable = new OnlineStatusManager.2(this);
  private ConcurrentHashMap<String, LocationMapInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
  private boolean jdField_a_of_type_Boolean = false;
  Runnable b = new OnlineStatusManager.4(this);
  
  public OnlineStatusManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager = new AutoStatusManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIntervalChecker = new IntervalChecker();
    ForeBackgroundSwitch.a().a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver = new OnlineStatusManager.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
    StudyModeManager.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener);
  }
  
  private long a(long paramLong)
  {
    long l = 1800L;
    if (paramLong == 1000L)
    {
      paramLong = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIntervalChecker.a(1000);
      l = paramLong;
      if (paramLong == 0L) {
        l = 300L;
      }
    }
    return l;
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning()))
    {
      if (QLog.isColorLevel()) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          break label54;
        }
      }
      label54:
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning()))
      {
        QLog.d("OnlineStatusManager", 2, new Object[] { "checkAppValid app.isRunning=", localObject });
        return false;
      }
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(paramQQAppInterface.getCurrentUin());
    if (paramQQAppInterface == null) {
      return true;
    }
    if (paramLong - paramQQAppInterface.weatherUpdateTime > 3600L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public IntervalChecker a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIntervalChecker;
  }
  
  public AutoStatusManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager;
  }
  
  public void a()
  {
    if (!a()) {
      return;
    }
    AppRuntime.Status localStatus = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatusNonSync();
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus();
    if ((localStatus == AppRuntime.Status.online) && (l == 1030L))
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.b);
      this.jdField_a_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, "onRunningForground");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager.c("ForeBackgroundSwitch");
  }
  
  public void a(int paramInt)
  {
    a(paramInt, new Intent());
  }
  
  public void a(int paramInt1, double paramDouble1, double paramDouble2, String paramString1, String paramString2, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 0) {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, new Object[] { "retCode：", Integer.valueOf(paramInt1) });
      }
    }
    boolean bool;
    do
    {
      return;
      bool = false;
      if (LocationInfo.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationInfo, paramDouble1, paramDouble2, paramString1))
      {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationInfo = new LocationInfo(paramDouble1, paramDouble2, paramString2, paramString1);
        bool = true;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationInfo == null);
    a(paramInt2, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationInfo, paramIntent, bool);
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusManager", 2, new Object[] { "sendLocationInfo type:", Integer.valueOf(paramInt) });
    }
    if (a(paramInt)) {
      LocationUtil.a(paramInt, paramIntent, this);
    }
  }
  
  void a(int paramInt, LocationInfo paramLocationInfo, Intent paramIntent, boolean paramBoolean)
  {
    int j = 0;
    ArrayList localArrayList;
    if ((paramBoolean) || (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, NetConnInfoCenter.getServerTime())) || (paramInt == 9))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, new Object[] { "gotoNextStep type：", Integer.valueOf(paramInt), " isLocationChange:", Boolean.valueOf(paramBoolean) });
      }
      localArrayList = new ArrayList(2);
      localArrayList.add(Integer.valueOf(1));
      localArrayList.add(Integer.valueOf(10));
    }
    try
    {
      i = Integer.valueOf(paramLocationInfo.c).intValue();
      OnlineStatusWeatherServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, i, paramInt, paramIntent.getExtras());
      return;
    }
    catch (NumberFormatException paramLocationInfo)
    {
      for (;;)
      {
        int i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("OnlineStatusManager", 4, "handleFetchWeatherInfo numberFormat", paramLocationInfo);
          i = j;
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (paramLong > 40000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, "[status][autoMgr] handleExtStatusChanged startDetector: " + paramLong);
      }
      if (((OnlineStatusPermissionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_PERMISSION_MANAGER)).a()) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager.a("onlinePush", true);
      }
    }
    for (;;)
    {
      a(StudyModeManager.a());
      return;
      OnlineStatusPermissionServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 40001L, false, true);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, "[status][autoMgr] handleExtStatusChanged stopDetector: " + paramLong);
      }
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager.b("onlinePush");
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIntervalChecker.b((int)paramLong1, paramLong2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, AppRuntime.Status paramStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusManager", 2, new Object[] { "sendBussinessInfoRegisterPush succ:", Boolean.valueOf(paramBoolean), " mSyncPause:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    long l;
    if ((paramBoolean) && (paramStatus == AppRuntime.Status.online))
    {
      l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus();
      paramStatus = (OnlineStatusHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ONLINE_STATUS_HANDLER);
      if (l != 1000L) {
        break label139;
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setPowerConnect(OnLineStatusHelper.c());
        paramStatus.a(1, OnLineStatusHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true), null);
        a(l);
        c();
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("OnlineStatusManager", 1, "registerPush t:", localThrowable);
        continue;
      }
      label139:
      if ((l == 1030L) && (!this.jdField_a_of_type_Boolean))
      {
        a(6);
      }
      else if (l == 1040L)
      {
        paramStatus = ConstellationUtilKt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (TextUtils.isEmpty(paramStatus))
        {
          ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0, 0L, (byte)1, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
          this.jdField_a_of_type_Long = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).lBirthday;
          if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusManager", 2, new Object[] { "sendBussinessInfoRegisterPush: invoked. [constellation] (星座不存在，那么执行一次资料拉取，在资料回调中拉取运势)", " mSelfCurrentBirthday: ", Long.valueOf(this.jdField_a_of_type_Long) });
          }
        }
        else
        {
          String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          paramBoolean = TextUtils.isEmpty(ConstellationUtilKt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str));
          if (paramBoolean) {
            OnlineStatusExtInfoServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramStatus);
          }
          if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusManager", 2, new Object[] { "sendBussinessInfoRegisterPush: invoked. (注册上线时，星座资料不空，但运势为空，那么执行一次运势拉取逻辑)", " emptyTrend: ", Boolean.valueOf(paramBoolean) });
          }
        }
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt == 6) || (paramInt == 7) || (paramInt == 8) || (paramInt == 9);
  }
  
  public void b()
  {
    if (!a()) {
      return;
    }
    AppRuntime.Status localStatus = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatusNonSync();
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus();
    if ((localStatus == AppRuntime.Status.online) && (l == 1030L) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop))
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.b);
      ThreadManager.getSubThreadHandler().post(this.b);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, "onRunningBackground");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager.d("ForeBackgroundSwitch");
  }
  
  public void b(int paramInt, Intent paramIntent)
  {
    OnlineStatusHandler localOnlineStatusHandler = (OnlineStatusHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ONLINE_STATUS_HANDLER);
    Object localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    Bundle localBundle = OnLineStatusHelper.a().a((Friends)localObject);
    localBundle.putBoolean("from_need_update_delay_time", true);
    if ((7 == paramInt) && (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIntervalChecker.a(1030))) {
      localOnlineStatusHandler.a(3, localBundle);
    }
    do
    {
      return;
      if (6 == paramInt)
      {
        localBundle.putBoolean("from_register", true);
        localOnlineStatusHandler.a(3, localBundle, null);
        return;
      }
    } while (8 != paramInt);
    if (paramIntent.hasExtra("online_status_permission_item")) {}
    for (localObject = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramIntent.getSerializableExtra("online_status_permission_item");; localObject = null)
    {
      localBundle.putBoolean("from_modify", paramIntent.getBooleanExtra("from_modify", false));
      localBundle.putBoolean("from_register", false);
      localOnlineStatusHandler.a(3, localBundle, (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject);
      return;
    }
  }
  
  public void b(long paramLong)
  {
    if (paramLong > 40001L)
    {
      localOnlineAutoStatusBean = (OnlineAutoStatusBean)QConfigManager.a().a(652);
      localArrayList = new ArrayList();
      if (localOnlineAutoStatusBean.a.jdField_a_of_type_JavaUtilList != null)
      {
        localIterator = localOnlineAutoStatusBean.a.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add(Long.valueOf(((AutoStatusItem)localIterator.next()).jdField_a_of_type_Long));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, new Object[] { "resetWhenAutoStatusItemRemoved: invoked.  [status][reset-default]", " configIds: ", localArrayList, " extStatus: ", Long.valueOf(paramLong) });
      }
      if ((!localArrayList.isEmpty()) && (localOnlineAutoStatusBean.a()) && (!localArrayList.contains(Long.valueOf(paramLong))))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.updateOnlineStatus(AppRuntime.Status.online, 0L, true);
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusManager", 2, "resetWhenAutoStatusItemRemoved: invoked. [status][reset-default] finish. ");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      OnlineAutoStatusBean localOnlineAutoStatusBean;
      ArrayList localArrayList;
      Iterator localIterator;
      return;
    }
    QLog.d("OnlineStatusManager", 2, new Object[] { "resetWhenAutoStatusItemRemoved: invoked. [status][reset-default] no need reset", " extStatus: ", Long.valueOf(paramLong) });
  }
  
  public void c()
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning())) {
      if (QLog.isColorLevel())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          break label56;
        }
        localObject = "null";
        QLog.d("OnlineStatusManager", 2, new Object[] { "launchTimedMsgTask app.isRunning=", localObject });
      }
    }
    label56:
    long l1;
    label201:
    do
    {
      long l2;
      do
      {
        return;
        localObject = Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning());
        break;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatusNonSync();
        l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus();
        if ((localObject != AppRuntime.Status.online) || ((l1 != 1000L) && (l1 != 1030L) && (l1 != 1040L))) {
          break label201;
        }
        ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        l2 = a(l1);
        ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L * l2);
      } while (!QLog.isColorLevel());
      QLog.d("OnlineStatusManager", 2, new Object[] { "launchTimedMsgTask schedule msgTimer after ", Long.valueOf(l2), " seconds", " extStatus: ", Long.valueOf(l1) });
      return;
      d();
    } while (!QLog.isColorLevel());
    QLog.d("OnlineStatusManager", 2, new Object[] { "launchTimedMsgTask cancel status", localObject, " extStatus:", Long.valueOf(l1) });
  }
  
  public void c(long paramLong)
  {
    OnlineAutoStatusBean localOnlineAutoStatusBean = (OnlineAutoStatusBean)QConfigManager.a().a(652);
    OnlineStatusItem localOnlineStatusItem = localOnlineAutoStatusBean.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem;
    if ((localOnlineStatusItem != null) && (localOnlineStatusItem.jdField_a_of_type_Long == 0L) && (localOnlineAutoStatusBean.a()) && (paramLong > 40000L))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.updateOnlineStatus(AppRuntime.Status.online, 0L, true);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, new Object[] { "resetWhenAutoStatusEntranceRemoved: invoked. [status][reset-default] finish. ", " item: ", localOnlineStatusItem });
      }
    }
  }
  
  public void d()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      if (QLog.isColorLevel())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          break label44;
        }
        localObject = "null";
        QLog.d("OnlineStatusManager", 2, new Object[] { "cancelTimedMsgTask app.isRunning=", localObject });
      }
    }
    label44:
    do
    {
      return;
      localObject = Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning());
      break;
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    } while (!QLog.isColorLevel());
    QLog.d("OnlineStatusManager", 2, "cancelTimedMsgTask");
  }
  
  public void d(long paramLong)
  {
    Object localObject2 = null;
    ArrayList localArrayList = null;
    Object localObject1;
    if ((paramLong > 0L) && (paramLong < 40000L))
    {
      localObject1 = OnLineStatusHelper.a().b();
      if (localObject1 != null)
      {
        localArrayList = new ArrayList();
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localArrayList.add(Long.valueOf(((OnlineStatusItem)((Iterator)localObject1).next()).jdField_a_of_type_Long));
        }
      }
      localObject1 = localArrayList;
      if (localArrayList != null)
      {
        localObject1 = localArrayList;
        if (!localArrayList.isEmpty())
        {
          localObject1 = localArrayList;
          if (!localArrayList.contains(Long.valueOf(paramLong)))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.updateOnlineStatus(AppRuntime.Status.online, 0L, true);
            localObject1 = localArrayList;
            if (QLog.isColorLevel())
            {
              QLog.d("OnlineStatusManager", 2, "resetWhenStatusConfigRemoved: invoked. [status][reset-default] finish. ");
              localObject1 = localArrayList;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, new Object[] { "resetWhenStatusConfigRemoved: invoked. [status][reset-default] ", " configIds: ", localObject1, " extStatus: ", Long.valueOf(paramLong) });
      }
      return;
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("OnlineStatusManager", 2, new Object[] { "resetWhenStatusConfigRemoved: invoked. [status][reset-default] no need reset", " extStatus: ", Long.valueOf(paramLong) });
        localObject1 = localObject2;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onDestroy()
  {
    d();
    ForeBackgroundSwitch.a().b(this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager.a();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIntervalChecker.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
    StudyModeManager.b(this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusManager
 * JD-Core Version:    0.7.0.1
 */