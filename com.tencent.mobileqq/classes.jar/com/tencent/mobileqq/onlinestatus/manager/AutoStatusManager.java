package com.tencent.mobileqq.onlinestatus.manager;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineAutoStatusBean;
import com.tencent.mobileqq.onlinestatus.IOnlineStatusInjector;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusInjectorImpl;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusObserver;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionObserver;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.auto.AutoStatus;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.mobileqq.onlinestatus.auto.action.ActionDetector;
import com.tencent.mobileqq.onlinestatus.auto.location.LocationBaseStateDetector;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusElement;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusItem;
import com.tencent.mobileqq.onlinestatus.constellation.ExtensionBizInfoHelper;
import com.tencent.mobileqq.onlinestatus.observer.OnAutoStatusBannerObserver;
import com.tencent.mobileqq.onlinestatus.view.AutoStatusConfirmFragment;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.ProcessUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

public class AutoStatusManager
  implements IGuardInterface, IAutoStatusManager
{
  @ConfigInject(configPath="/Business/qqonlinestatus-impl/src/main/resources/Inject_onlinestatus_business.yml", version=1)
  public static ArrayList<Class<? extends IOnlineStatusInjector>> a;
  private volatile long jdField_a_of_type_Long = Constant.c;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getSubThreadLooper());
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private IOnlineStatusInjector jdField_a_of_type_ComTencentMobileqqOnlinestatusIOnlineStatusInjector;
  private OnlineStatusObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver = new AutoStatusManager.5(this);
  private OnlineStatusPermissionObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionObserver = new AutoStatusManager.6(this);
  private AutoStatus jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus = new AutoStatus(40001);
  ActionDetector jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoActionActionDetector;
  LocationBaseStateDetector jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector;
  private AutoStatusManager.OnAutoStatusChangedListener jdField_a_of_type_ComTencentMobileqqOnlinestatusManagerAutoStatusManager$OnAutoStatusChangedListener;
  private AutoStatusManager.ScreenBroadcastReceiver jdField_a_of_type_ComTencentMobileqqOnlinestatusManagerAutoStatusManager$ScreenBroadcastReceiver = new AutoStatusManager.ScreenBroadcastReceiver(null);
  Runnable jdField_a_of_type_JavaLangRunnable = new AutoStatusManager.3(this);
  private volatile boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = 0L;
  private Runnable jdField_b_of_type_JavaLangRunnable = new AutoStatusManager.1(this);
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(OnlineStatusInjectorImpl.class);
  }
  
  public AutoStatusManager(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] AutoStatusManager() called");
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    f();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoActionActionDetector = new ActionDetector(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector = new LocationBaseStateDetector(this.jdField_a_of_type_ComTencentCommonAppAppInterface, new AutoStatusManager.2(this));
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver);
    paramAppInterface = new IntentFilter();
    paramAppInterface.addAction("android.intent.action.SCREEN_OFF");
    MobileQQ.sMobileQQ.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusManagerAutoStatusManager$ScreenBroadcastReceiver, paramAppInterface);
    if (GuardManager.a != null) {
      GuardManager.a.a(this);
    }
    h();
  }
  
  @NonNull
  public static Intent a(AppInterface paramAppInterface, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ext_status", paramLong);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("is_background", true ^ GuardManager.a.a());
    localIntent.setClass(paramAppInterface.getApp(), QPublicTransFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", AutoStatusConfirmFragment.class.getName());
    return localIntent;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 != paramInt1)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[status][autoMgr] updateAutoStatus status changed cur: ");
        ((StringBuilder)localObject).append(Constant.a(paramInt2));
        ((StringBuilder)localObject).append(" last: ");
        ((StringBuilder)localObject).append(Constant.a(paramInt1));
        QLog.e("AutoStatusManager", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusManagerAutoStatusManager$OnAutoStatusChangedListener;
      if (localObject != null) {
        ((AutoStatusManager.OnAutoStatusChangedListener)localObject).a(paramInt2);
      }
      if (paramInt2 == 40001)
      {
        if (paramLong > 40001L)
        {
          if (a(true)) {
            this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a(paramInt2);
          }
        }
        else
        {
          a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          d();
          this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a(paramInt2);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a(paramInt2);
        localObject = Constant.a(paramInt2);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[status][autoMgr] updateAutoStatus getAutoStringById : ");
          localStringBuilder.append(localObject);
          QLog.e("AutoStatusManager", 2, localStringBuilder.toString());
        }
        if (localObject != null) {
          a((AutoStatusItem)localObject);
        }
      }
    }
    else if (paramLong == 40001L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, new Object[] { "updateAutoStatus: invoked. [status-time] (真实在线状态命中了40001，不允许上报时间信息，如果后续超时自动重置，也不用上报)", " actionStatus: ", Integer.valueOf(paramInt3) });
      }
    }
    else
    {
      ExtensionBizInfoHelper.a.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ExtensionBizInfoHelper.a.a(), paramInt2);
    }
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr][banner] hideBanner");
    }
    paramAppInterface.notifyObservers(OnAutoStatusBannerObserver.class, 26373, true, new Bundle());
  }
  
  public static void a(AppInterface paramAppInterface, long paramLong, boolean paramBoolean, @NonNull String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[status][autoMgr] submitStatus ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" status: ");
      ((StringBuilder)localObject).append(Constant.a((int)paramLong));
      ((StringBuilder)localObject).append(" auto: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("AutoStatusManager", 2, ((StringBuilder)localObject).toString());
    }
    paramString = (IOnlineStatusService)paramAppInterface.getRuntimeService(IOnlineStatusService.class, "");
    Object localObject = (AutoStatusManager)((IOnlineStatusManagerService)paramAppInterface.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IAutoStatusManager.class);
    a(((AutoStatusManager)localObject).jdField_a_of_type_ComTencentCommonAppAppInterface);
    ((AutoStatusManager)localObject).d();
    if (paramLong != 40001L) {
      ExtensionBizInfoHelper.a.a(paramAppInterface, ExtensionBizInfoHelper.a.a(), (int)paramLong);
    }
    paramString.updateOnlineStatus(AppRuntime.Status.online, paramLong, paramBoolean);
    if (Constant.a(paramLong)) {
      ((AutoStatusManager)localObject).jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector.a(paramLong);
    }
  }
  
  private void a(AutoStatusItem paramAutoStatusItem)
  {
    int i = (int)((IOnlineStatusService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusService.class, "")).getExtOnlineStatus();
    StringBuilder localStringBuilder;
    if (i == paramAutoStatusItem.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][autoMgr] showTips fail status : ");
        localStringBuilder.append(paramAutoStatusItem);
        localStringBuilder.append(" real: ");
        localStringBuilder.append(i);
        QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
      }
      a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      d();
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][autoMgr] showTips success status : ");
      localStringBuilder.append(paramAutoStatusItem);
      localStringBuilder.append(" real: ");
      localStringBuilder.append(i);
      QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
    }
    if (i > 40001)
    {
      boolean bool = a(i);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][autoMgr] showTips real statusChanged: ");
        localStringBuilder.append(bool);
        localStringBuilder.append(" real: ");
        localStringBuilder.append(Constant.a(i));
        QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
      }
      if (bool) {
        a(false);
      }
    }
    if ((QBaseActivity.mAppForground) && (a()))
    {
      b(paramAutoStatusItem);
      d();
      return;
    }
    b(paramAutoStatusItem);
    c(paramAutoStatusItem);
  }
  
  private boolean a()
  {
    IOnlineStatusInjector localIOnlineStatusInjector = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIOnlineStatusInjector;
    if (localIOnlineStatusInjector != null) {
      return localIOnlineStatusInjector.a();
    }
    QLog.w("AutoStatusManager", 1, "isConversationTabTop injector not init");
    return false;
  }
  
  private boolean a(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoActionActionDetector.a();
    boolean bool = false;
    if (paramInt == i) {
      return false;
    }
    if (paramInt == this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector.d()) {
      return false;
    }
    if (Constant.b) {
      i = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector.b();
    } else {
      i = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector.c();
    }
    if (paramInt != i) {
      bool = true;
    }
    return bool;
  }
  
  private void b(AutoStatusItem paramAutoStatusItem)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[status][autoMgr][banner] showBanner status : ");
      ((StringBuilder)localObject).append(paramAutoStatusItem);
      QLog.d("AutoStatusManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("StatusId", (int)paramAutoStatusItem.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.notifyObservers(OnAutoStatusBannerObserver.class, 26372, true, (Bundle)localObject);
  }
  
  private void c(AutoStatusItem paramAutoStatusItem)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[status][autoMgr] showPush status : ");
      ((StringBuilder)localObject).append(paramAutoStatusItem);
      ((StringBuilder)localObject).append(" at ");
      ((StringBuilder)localObject).append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(System.currentTimeMillis())));
      QLog.d("AutoStatusManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramAutoStatusItem.jdField_a_of_type_Long);
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp());
    localBuilder.setContentText(String.format(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131690258), new Object[] { paramAutoStatusItem.b })).setWhen(System.currentTimeMillis()).setSmallIcon(2130841471).setAutoCancel(true).setContentIntent(PendingIntent.getActivity(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), 0, (Intent)localObject, 134217728));
    paramAutoStatusItem = localBuilder.build();
    QQNotificationManager.addChannelIfNeed(paramAutoStatusItem, "CHANNEL_ID_OTHER");
    QQNotificationManager.getInstance().notify("AutoStatusManager", 3000530, paramAutoStatusItem);
    if (!GuardManager.a.a())
    {
      ReportHelperKt.a("0X800AFA2", 1);
      return;
    }
    ReportHelperKt.a("0X800AFA1", 1);
  }
  
  private void e()
  {
    long l = ((IOnlineStatusService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusService.class, "")).getExtOnlineStatus();
    int m = a();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][autoMgr] updateAutoStatus last status: ");
      localStringBuilder.append(Constant.a(m));
      localStringBuilder.append(" real status: ");
      localStringBuilder.append(Constant.a((int)l));
      QLog.w("AutoStatusManager", 2, localStringBuilder.toString());
    }
    if (l < 40000L)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][autoMgr] updateAutoStatus [user submit no auto status] stopDetector. last status: ");
        localStringBuilder.append(Constant.a(m));
        localStringBuilder.append(" real status: ");
        localStringBuilder.append(Constant.a((int)l));
        QLog.w("AutoStatusManager", 2, localStringBuilder.toString());
      }
      b("updateStatus");
      return;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoActionActionDetector.a();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][autoMgr] updateAutoStatus actionStatus: ");
      localStringBuilder.append(Constant.a(j));
      localStringBuilder.append(" enable: ");
      localStringBuilder.append(Constant.a.contains(Integer.valueOf(j)));
      QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
    }
    int i;
    if ((j > 40001) && (Constant.a.contains(Integer.valueOf(j))))
    {
      i = j;
    }
    else
    {
      int k;
      if (Constant.b)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector.b();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[status][autoMgr] updateAutoStatus getNewMovementStatus: ");
          localStringBuilder.append(Constant.a(i));
          localStringBuilder.append(" enable: ");
          localStringBuilder.append(Constant.a.contains(Integer.valueOf(i)));
          QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
        }
        if ((i <= 40001) || (!Constant.a.contains(Integer.valueOf(i))))
        {
          k = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector.d();
          i = k;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[status][autoMgr] updateAutoStatus categoryStatus: ");
            localStringBuilder.append(Constant.a(k));
            localStringBuilder.append(" enable: ");
            localStringBuilder.append(Constant.a.contains(Integer.valueOf(k)));
            QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
            i = k;
          }
        }
      }
      else
      {
        i = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector.c();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[status][autoMgr] updateAutoStatus movementStatus: ");
          localStringBuilder.append(Constant.a(i));
          localStringBuilder.append(" enable: ");
          localStringBuilder.append(Constant.a.contains(Integer.valueOf(i)));
          QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
        }
        if ((i <= 40001) || (!Constant.a.contains(Integer.valueOf(i))))
        {
          k = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector.d();
          i = k;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[status][autoMgr] updateAutoStatus categoryStatus: ");
            localStringBuilder.append(Constant.a(k));
            localStringBuilder.append(" enable: ");
            localStringBuilder.append(Constant.a.contains(Integer.valueOf(k)));
            QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
            i = k;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][autoMgr] updateAutoStatus result: ");
      localStringBuilder.append(Constant.a(i));
      localStringBuilder.append(" enable: ");
      localStringBuilder.append(Constant.a.contains(Integer.valueOf(i)));
      QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
    }
    if ((i > 40001) && (!Constant.a.contains(Integer.valueOf(i))))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][autoMgr] updateAutoStatus detected disabled cur status: ");
        localStringBuilder.append(Constant.a(i));
        QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
      }
      i = 40001;
    }
    a(l, m, i, j);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] loadConfig");
    }
    if (!OnlineStatusUtil.a())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[status][autoMgr] loadConfig auto_config not valid stopDetector. detector started: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
        QLog.e("AutoStatusManager", 2, ((StringBuilder)localObject).toString());
      }
      if (this.jdField_a_of_type_Boolean) {
        b("configDrop");
      }
      return;
    }
    Object localObject = (OnlineAutoStatusBean)QConfigManager.a().a(652);
    if ((localObject != null) && (((OnlineAutoStatusBean)localObject).a != null))
    {
      localObject = ((OnlineAutoStatusBean)localObject).a.a(false);
      if (((List)localObject).isEmpty())
      {
        if (QLog.isColorLevel()) {
          QLog.e("AutoStatusManager", 2, "[status][autoMgr] loadConfig fail by element.autoStatus: element.autoStatus empty");
        }
        return;
      }
      try
      {
        Constant.a((List)localObject);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("AutoStatusManager", 1, "initWithConfig", localThrowable);
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][autoMgr] loadConfig fail by bean: ");
      localStringBuilder.append(localThrowable);
      String str;
      if (localThrowable == null) {
        str = "";
      } else {
        str = " bean.autoStatusElement null";
      }
      localStringBuilder.append(str);
      QLog.e("AutoStatusManager", 2, localStringBuilder.toString());
    }
  }
  
  private void g()
  {
    Object localObject1 = ((OnlineStatusPermissionManager)((IOnlineStatusManagerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusPermissionManager.class)).a();
    Object localObject2;
    if (localObject1 != null)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[status][autoMgr] loadEnabledStatus smartSelectedList size: ");
        ((StringBuilder)localObject2).append(((List)localObject1).size());
        QLog.d("AutoStatusManager", 2, ((StringBuilder)localObject2).toString());
      }
      Constant.a = (List)localObject1;
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("AutoStatusManager", 2, "[status][autoMgr] loadEnabledStatus smartSelectedList is null");
      }
      Constant.a = new ArrayList();
    }
    localObject1 = Constant.a.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][autoMgr] loadEnabledStatus status: ");
        localStringBuilder.append(Constant.a(((Integer)localObject2).intValue()));
        QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void h()
  {
    try
    {
      if (jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIOnlineStatusInjector = ((IOnlineStatusInjector)((Class)localIterator.next()).newInstance());
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AutoStatusManager", 1, "initInjector Fail,", localThrowable);
    }
  }
  
  public void G_()
  {
    c("ForeBackgroundSwitch");
  }
  
  public void H_()
  {
    d("ForeBackgroundSwitch");
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a;
  }
  
  public String a(Integer paramInteger)
  {
    Integer localInteger = paramInteger;
    if (paramInteger == null) {
      localInteger = Integer.valueOf(a());
    }
    paramInteger = Constant.a(localInteger.intValue());
    if (paramInteger != null) {
      return paramInteger.b;
    }
    paramInteger = OnLineStatusHelper.a().a(AppRuntime.Status.online, 40001L);
    if (paramInteger.e == null) {
      return "";
    }
    return paramInteger.e;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("AutoStatusManager", 2, "[status][autoMgr] destroy");
    }
    if (this.jdField_a_of_type_Boolean) {
      b("destroy");
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver);
    MobileQQ.sMobileQQ.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusManagerAutoStatusManager$ScreenBroadcastReceiver);
    if (GuardManager.a != null) {
      GuardManager.a.b(this);
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(AutoStatusManager.OnAutoStatusChangedListener paramOnAutoStatusChangedListener)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][autoMgr] startDetector listener: ");
      localStringBuilder.append(paramOnAutoStatusChangedListener);
      QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusManagerAutoStatusManager$OnAutoStatusChangedListener = paramOnAutoStatusChangedListener;
  }
  
  public void a(@NonNull String paramString)
  {
    a(paramString, false);
  }
  
  public void a(@NonNull String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Object localObject = (IOnlineStatusService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusService.class, "");
        StringBuilder localStringBuilder;
        if (!OnlineStatusItem.a(((IOnlineStatusService)localObject).getOnlineStatus(), ((IOnlineStatusService)localObject).getExtOnlineStatus()))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[status][autoMgr] startDetector from: ");
            localStringBuilder.append(paramString);
            localStringBuilder.append(" fail and stopDetector status: ");
            localStringBuilder.append(((IOnlineStatusService)localObject).getOnlineStatus());
            localStringBuilder.append(" extStatus: ");
            localStringBuilder.append(((IOnlineStatusService)localObject).getExtOnlineStatus());
            localStringBuilder.append(" started: ");
            localStringBuilder.append(this.jdField_a_of_type_Boolean);
            QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("startFail-");
            ((StringBuilder)localObject).append(paramString);
            b(((StringBuilder)localObject).toString());
          }
          return;
        }
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a((int)((IOnlineStatusService)localObject).getExtOnlineStatus());
        }
        if (!ProcessUtil.a(MobileQQ.sMobileQQ))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[status][autoMgr] startDetector from: ");
            localStringBuilder.append(paramString);
            localStringBuilder.append(" fail onAppBackground status: ");
            localStringBuilder.append(((IOnlineStatusService)localObject).getOnlineStatus());
            localStringBuilder.append(" extStatus: ");
            localStringBuilder.append(((IOnlineStatusService)localObject).getExtOnlineStatus());
            localStringBuilder.append(" started: ");
            localStringBuilder.append(this.jdField_a_of_type_Boolean);
            QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
          }
          d("startDetector");
          return;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[status][autoMgr] startDetector from: ");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(" already started");
            QLog.d("AutoStatusManager", 2, ((StringBuilder)localObject).toString());
          }
          return;
        }
        if (!OnlineStatusUtil.a())
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[status][autoMgr] startDetector from: ");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(" fail by auto_config not valid.");
            QLog.e("AutoStatusManager", 2, ((StringBuilder)localObject).toString());
          }
          return;
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[status][autoMgr] startDetector from: ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" success");
          QLog.e("AutoStatusManager", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_Boolean = true;
        f();
        g();
        long l2 = ((IOnlineStatusService)localObject).getExtOnlineStatus();
        if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a != l2) {
          this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a("autoMgr");
        }
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp());
        l1 = 30000L;
        if ((l2 != 41031L) && (l2 != 41014L))
        {
          if (l2 == 41042L) {
            l1 = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector.a();
          }
          localObject = BaseApplication.getContext();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("KEY_LAST_AUTO_RESET_TIME_");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin());
          localObject = SharePreferenceUtils.a((Context)localObject, localStringBuilder.toString());
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            this.jdField_b_of_type_Long = Long.parseLong((String)localObject);
          }
          long l3 = System.currentTimeMillis() - this.jdField_b_of_type_Long;
          if (l3 < this.jdField_a_of_type_Long)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("[status][autoMgr] startDetector from: ");
              ((StringBuilder)localObject).append(paramString);
              ((StringBuilder)localObject).append(" realStatus: ");
              ((StringBuilder)localObject).append(l2);
              ((StringBuilder)localObject).append(" firstDelay: ");
              ((StringBuilder)localObject).append(l1);
              ((StringBuilder)localObject).append(" lastAutoInternal: ");
              ((StringBuilder)localObject).append(l3);
              ((StringBuilder)localObject).append(" delay max: ");
              ((StringBuilder)localObject).append(Math.max(l1, l3));
              QLog.i("AutoStatusManager", 2, ((StringBuilder)localObject).toString());
            }
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, Math.max(l1, l3));
          }
          else
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("[status][autoMgr] startDetector from: ");
              ((StringBuilder)localObject).append(paramString);
              ((StringBuilder)localObject).append(" realStatus: ");
              ((StringBuilder)localObject).append(l2);
              ((StringBuilder)localObject).append(" firstDelay: ");
              ((StringBuilder)localObject).append(l1);
              ((StringBuilder)localObject).append(" lastAutoInternal: ");
              ((StringBuilder)localObject).append(l3);
              ((StringBuilder)localObject).append(" delay first");
              QLog.i("AutoStatusManager", 2, ((StringBuilder)localObject).toString());
            }
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, l1);
          }
          return;
        }
      }
      finally {}
      long l1 = 390000L;
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(boolean paramBoolean)
  {
    long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
    StringBuilder localStringBuilder;
    if (l > this.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][autoMgr] resetStatusAuto success. internal: ");
        localStringBuilder.append(l);
        localStringBuilder.append(" limit: ");
        localStringBuilder.append(this.jdField_b_of_type_Long);
        QLog.e("AutoStatusManager", 2, localStringBuilder.toString());
      }
      a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 40001L, true, "auto_reset");
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      return true;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][autoMgr] resetStatusAuto fail by Frequency. internal: ");
      localStringBuilder.append(l);
      localStringBuilder.append(" limit: ");
      localStringBuilder.append(this.jdField_b_of_type_Long);
      QLog.e("AutoStatusManager", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      d();
    }
    return false;
  }
  
  public void b(long paramLong) {}
  
  public void b(@NonNull String paramString)
  {
    b(paramString, false);
  }
  
  public void b(@NonNull String paramString, boolean paramBoolean)
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[status][autoMgr] stopDetector from: ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" already stopped");
          QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][autoMgr] stopDetector from: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" success");
        QLog.e("AutoStatusManager", 2, localStringBuilder.toString());
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 600000L);
      }
      else
      {
        a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        d();
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector.a(paramBoolean);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      paramString = BaseApplication.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("KEY_LAST_AUTO_RESET_TIME_");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin());
      SharePreferenceUtils.a(paramString, localStringBuilder.toString(), String.valueOf(this.jdField_b_of_type_Long));
      return;
    }
    finally {}
  }
  
  public void c()
  {
    long l = ((IOnlineStatusService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusService.class, "")).getExtOnlineStatus();
    if ((l == 40001L) || (l == 41042L))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void c(long paramLong) {}
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][autoMgr] onAppForeground from: ");
      localStringBuilder.append(paramString);
      QLog.i("AutoStatusManager", 2, localStringBuilder.toString());
    }
    a("Foreground");
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] hidePush");
    }
    ThreadManagerV2.getUIHandlerV2().post(new AutoStatusManager.4(this));
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][autoMgr] onAppBackground from: ");
      localStringBuilder.append(paramString);
      QLog.i("AutoStatusManager", 2, localStringBuilder.toString());
    }
    paramString = (AutoStatusManager)((IOnlineStatusManagerService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IAutoStatusManager.class);
    if (paramString != null) {
      paramString.b("Background", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.AutoStatusManager
 * JD-Core Version:    0.7.0.1
 */