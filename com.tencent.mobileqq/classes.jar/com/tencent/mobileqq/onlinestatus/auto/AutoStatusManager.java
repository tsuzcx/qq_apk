package com.tencent.mobileqq.onlinestatus.auto;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineAutoStatusBean;
import com.tencent.mobileqq.notification.modularize.OnlineModulePushReceiverKt;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusManager;
import com.tencent.mobileqq.onlinestatus.OnlineStatusObserver;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionObserver;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.auto.action.ActionDetector;
import com.tencent.mobileqq.onlinestatus.auto.location.LocationBaseStateDetector;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusElement;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusItem;
import com.tencent.mobileqq.onlinestatus.constellation.ExtensionBizInfoHelper;
import com.tencent.mobileqq.onlinestatus.view.AutoStatusConfirmFragment;
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
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class AutoStatusManager
{
  private volatile long jdField_a_of_type_Long = Constant.c;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getSubThreadLooper());
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private OnlineStatusObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver = new AutoStatusManager.5(this);
  private OnlineStatusPermissionObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionObserver = new AutoStatusManager.6(this);
  private AutoStatus jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus = new AutoStatus(40001);
  private AutoStatusManager.OnAutoStatusChangedListener jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager$OnAutoStatusChangedListener;
  private AutoStatusManager.ScreenBroadcastReceiver jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager$ScreenBroadcastReceiver = new AutoStatusManager.ScreenBroadcastReceiver(null);
  private ActionDetector jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoActionActionDetector;
  private LocationBaseStateDetector jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector;
  Runnable jdField_a_of_type_JavaLangRunnable = new AutoStatusManager.3(this);
  private volatile boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = 0L;
  private Runnable jdField_b_of_type_JavaLangRunnable = new AutoStatusManager.1(this);
  
  public AutoStatusManager(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] AutoStatusManager() called");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    e();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoActionActionDetector = new ActionDetector(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector = new LocationBaseStateDetector(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new AutoStatusManager.2(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver);
    paramQQAppInterface = new IntentFilter();
    paramQQAppInterface.addAction("android.intent.action.SCREEN_OFF");
    BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager$ScreenBroadcastReceiver, paramQQAppInterface);
  }
  
  @NotNull
  public static Intent a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    int i = 1;
    Intent localIntent = new Intent();
    localIntent.putExtra("ext_status", paramLong);
    localIntent.putExtra("public_fragment_window_feature", 1);
    if (OnlineModulePushReceiverKt.a(paramQQAppInterface)) {}
    for (;;)
    {
      localIntent.putExtra("is_background", i);
      localIntent.setClass(paramQQAppInterface.getApp(), PublicTransFragmentActivity.class);
      localIntent.putExtra("public_fragment_class", AutoStatusConfirmFragment.class.getName());
      return localIntent;
      i = 0;
    }
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 != paramInt1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus status changed cur: " + Constant.a(paramInt2) + " last: " + Constant.a(paramInt1));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager$OnAutoStatusChangedListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager$OnAutoStatusChangedListener.a(paramInt2);
      }
      if (paramInt2 == 40001) {
        if (paramLong > 40001L) {
          if (a(true)) {
            this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a(paramInt2);
          }
        }
      }
    }
    do
    {
      AutoStatusItem localAutoStatusItem;
      do
      {
        return;
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        c();
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a(paramInt2);
        return;
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a(paramInt2);
        localAutoStatusItem = Constant.a(paramInt2);
        if (QLog.isColorLevel()) {
          QLog.e("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus getAutoStringById : " + localAutoStatusItem);
        }
      } while (localAutoStatusItem == null);
      a(localAutoStatusItem);
      return;
      if (paramLong != 40001L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AutoStatusManager", 2, new Object[] { "updateAutoStatus: invoked. [status-time] (真实在线状态命中了40001，不允许上报时间信息，如果后续超时自动重置，也不用上报)", " actionStatus: ", Integer.valueOf(paramInt3) });
    return;
    ExtensionBizInfoHelper.a.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ExtensionBizInfoHelper.a.a(), paramInt2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr][banner] hideBanner");
    }
    paramQQAppInterface.getHandler(Conversation.class).sendEmptyMessage(1074);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean, @NonNull String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] submitStatus " + paramString + " status: " + Constant.a((int)paramLong) + " auto: " + paramBoolean);
    }
    a(paramQQAppInterface);
    c();
    if (paramLong != 40001L) {
      ExtensionBizInfoHelper.a.a(paramQQAppInterface, ExtensionBizInfoHelper.a.a(), (int)paramLong);
    }
    paramQQAppInterface.updateOnlineStatus(AppRuntime.Status.online, paramLong, paramBoolean);
    if (Constant.a(paramLong)) {
      ((OnlineStatusManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.ONLINE_STATUS_MANAGER)).a().jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector.a(paramLong);
    }
  }
  
  private void a(AutoStatusItem paramAutoStatusItem)
  {
    int i = (int)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus();
    if (i == paramAutoStatusItem.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] showTips fail status : " + paramAutoStatusItem + " real: " + i);
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      c();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] showTips success status : " + paramAutoStatusItem + " real: " + i);
    }
    if (i > 40001)
    {
      boolean bool = a(i);
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] showTips real statusChanged: " + bool + " real: " + Constant.a(i));
      }
      if (bool) {
        a(false);
      }
    }
    if ((BaseActivity.mAppForground) && (a()))
    {
      b(paramAutoStatusItem);
      c();
      return;
    }
    b(paramAutoStatusItem);
    c(paramAutoStatusItem);
  }
  
  private boolean a()
  {
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject instanceof SplashActivity))
    {
      localObject = (SplashActivity)localObject;
      return (SplashActivity.currentFragment == 1) && (((SplashActivity)localObject).getCurrentTab() == FrameControllerUtil.a);
    }
    return false;
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoActionActionDetector.a()) {}
    for (;;)
    {
      return false;
      if (paramInt != this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector.d())
      {
        if (Constant.b) {}
        for (int i = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector.b(); paramInt != i; i = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector.c()) {
          return true;
        }
      }
    }
  }
  
  private void b(AutoStatusItem paramAutoStatusItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr][banner] showBanner status : " + paramAutoStatusItem);
    }
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    Message localMessage = new Message();
    localMessage.what = 1075;
    localMessage.obj = paramAutoStatusItem;
    localMqqHandler.sendMessage(localMessage);
  }
  
  public static void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] hidePush");
    }
    ThreadManagerV2.getUIHandlerV2().post(new AutoStatusManager.4());
  }
  
  private void c(AutoStatusItem paramAutoStatusItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] showPush status : " + paramAutoStatusItem + " at " + new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(System.currentTimeMillis())));
    }
    Intent localIntent = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramAutoStatusItem.jdField_a_of_type_Long);
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    localBuilder.setContentText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131690337), new Object[] { paramAutoStatusItem.b })).setWhen(System.currentTimeMillis()).setSmallIcon(2130841588).setAutoCancel(true).setContentIntent(PendingIntent.getActivity(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 0, localIntent, 134217728));
    paramAutoStatusItem = localBuilder.build();
    QQNotificationManager.addChannelIfNeed(paramAutoStatusItem, "CHANNEL_ID_OTHER");
    QQNotificationManager.getInstance().notify("AutoStatusManager", 3000530, paramAutoStatusItem);
    if (OnlineModulePushReceiverKt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      ReportHelperKt.a("0X800AFA2", 1);
      return;
    }
    ReportHelperKt.a("0X800AFA1", 1);
  }
  
  private void d()
  {
    int m = 40001;
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus();
    int n = a();
    if (QLog.isColorLevel()) {
      QLog.w("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus last status: " + Constant.a(n) + " real status: " + Constant.a((int)l));
    }
    if (l < 40000L)
    {
      if (QLog.isColorLevel()) {
        QLog.w("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus [user submit no auto status] stopDetector. last status: " + Constant.a(n) + " real status: " + Constant.a((int)l));
      }
      b("updateStatus");
      return;
    }
    int k = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoActionActionDetector.a();
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus actionStatus: " + Constant.a(k) + " enable: " + Constant.a.contains(Integer.valueOf(k)));
    }
    int i;
    if ((k > 40001) && (Constant.a.contains(Integer.valueOf(k))))
    {
      i = k;
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus result: " + Constant.a(i) + " enable: " + Constant.a.contains(Integer.valueOf(i)));
      }
      if ((i <= 40001) || (Constant.a.contains(Integer.valueOf(i)))) {
        break label676;
      }
      j = m;
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus detected disabled cur status: " + Constant.a(i));
      }
    }
    label676:
    for (int j = m;; j = i)
    {
      a(l, n, j, k);
      return;
      if (Constant.b)
      {
        j = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector.b();
        if (QLog.isColorLevel()) {
          QLog.d("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus getNewMovementStatus: " + Constant.a(j) + " enable: " + Constant.a.contains(Integer.valueOf(j)));
        }
        if (j > 40001)
        {
          i = j;
          if (Constant.a.contains(Integer.valueOf(j))) {
            break;
          }
        }
        j = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector.d();
        i = j;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus categoryStatus: " + Constant.a(j) + " enable: " + Constant.a.contains(Integer.valueOf(j)));
        i = j;
        break;
      }
      j = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector.c();
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus movementStatus: " + Constant.a(j) + " enable: " + Constant.a.contains(Integer.valueOf(j)));
      }
      if (j > 40001)
      {
        i = j;
        if (Constant.a.contains(Integer.valueOf(j))) {
          break;
        }
      }
      j = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector.d();
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus categoryStatus: " + Constant.a(j) + " enable: " + Constant.a.contains(Integer.valueOf(j)));
      i = j;
      break;
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] loadConfig");
    }
    if (!OnlineStatusUtil.a())
    {
      if (QLog.isColorLevel()) {
        QLog.e("AutoStatusManager", 2, "[status][autoMgr] loadConfig auto_config not valid stopDetector. detector started: " + this.jdField_a_of_type_Boolean);
      }
      if (this.jdField_a_of_type_Boolean) {
        b("configDrop");
      }
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (OnlineAutoStatusBean)QConfigManager.a().a(652);
        if ((localObject != null) && (((OnlineAutoStatusBean)localObject).a != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      StringBuilder localStringBuilder = new StringBuilder().append("[status][autoMgr] loadConfig fail by bean: ").append(localObject);
      if (localObject == null) {}
      for (localObject = "";; localObject = " bean.autoStatusElement null")
      {
        QLog.e("AutoStatusManager", 2, (String)localObject);
        return;
      }
      localObject = ((OnlineAutoStatusBean)localObject).a.a(false);
      if (!((List)localObject).isEmpty()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("AutoStatusManager", 2, "[status][autoMgr] loadConfig fail by element.autoStatus: element.autoStatus empty");
    return;
    try
    {
      Constant.a((List)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AutoStatusManager", 1, "initWithConfig", localThrowable);
    }
  }
  
  private void f()
  {
    Object localObject = ((OnlineStatusPermissionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_PERMISSION_MANAGER)).a();
    if (localObject != null) {
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] loadEnabledStatus smartSelectedList size: " + ((List)localObject).size());
      }
    }
    for (Constant.a = (List)localObject;; Constant.a = new ArrayList())
    {
      localObject = Constant.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("AutoStatusManager", 2, "[status][autoMgr] loadEnabledStatus status: " + Constant.a(localInteger.intValue()));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("AutoStatusManager", 2, "[status][autoMgr] loadEnabledStatus smartSelectedList is null");
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a;
  }
  
  String a(Integer paramInteger)
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
    if (paramInteger.d == null) {
      return "";
    }
    return paramInteger.d;
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("AutoStatusManager", 2, "[status][autoMgr] destroy");
      }
      if (this.jdField_a_of_type_Boolean) {
        b("destroy");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver);
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager$ScreenBroadcastReceiver);
      return;
    }
    finally {}
  }
  
  void a(AutoStatusManager.OnAutoStatusChangedListener paramOnAutoStatusChangedListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] startDetector listener: " + paramOnAutoStatusChangedListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager$OnAutoStatusChangedListener = paramOnAutoStatusChangedListener;
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
        if (!OnlineStatusItem.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AutoStatusManager", 2, "[status][autoMgr] startDetector from: " + paramString + " fail and stopDetector status: " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus() + " extStatus: " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus() + " started: " + this.jdField_a_of_type_Boolean);
          }
          if (this.jdField_a_of_type_Boolean) {
            b("startFail-" + paramString);
          }
          return;
        }
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a((int)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus());
        }
        if (!ProcessUtil.a(BaseApplicationImpl.getApplication()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AutoStatusManager", 2, "[status][autoMgr] startDetector from: " + paramString + " fail onAppBackground status: " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus() + " extStatus: " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus() + " started: " + this.jdField_a_of_type_Boolean);
          }
          d("startDetector");
          continue;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label301;
        }
      }
      finally {}
      if (QLog.isColorLevel())
      {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] startDetector from: " + paramString + " already started");
        continue;
        label301:
        if (OnlineStatusUtil.a()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("AutoStatusManager", 2, "[status][autoMgr] startDetector from: " + paramString + " fail by auto_config not valid.");
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("AutoStatusManager", 2, "[status][autoMgr] startDetector from: " + paramString + " success");
    }
    this.jdField_a_of_type_Boolean = true;
    e();
    f();
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus();
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a != l2) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatus.a("autoMgr");
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    long l1 = 30000L;
    if ((l2 != 41031L) && (l2 != 41014L)) {}
    for (;;)
    {
      if (l2 == 41042L) {
        l1 = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector.a();
      }
      String str = SharePreferenceUtils.a(BaseApplication.getContext(), "KEY_LAST_AUTO_RESET_TIME_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      if (!TextUtils.isEmpty(str)) {
        this.jdField_b_of_type_Long = Long.parseLong(str);
      }
      long l3 = System.currentTimeMillis() - this.jdField_b_of_type_Long;
      if (l3 < this.jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AutoStatusManager", 2, "[status][autoMgr] startDetector from: " + paramString + " realStatus: " + l2 + " firstDelay: " + l1 + " lastAutoInternal: " + l3 + " delay max: " + Math.max(l1, l3));
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, Math.max(l1, l3));
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AutoStatusManager", 2, "[status][autoMgr] startDetector from: " + paramString + " realStatus: " + l2 + " firstDelay: " + l1 + " lastAutoInternal: " + l3 + " delay first");
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, l1);
      break;
      l1 = 390000L;
    }
  }
  
  boolean a(boolean paramBoolean)
  {
    long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
    if (l > this.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AutoStatusManager", 2, "[status][autoMgr] resetStatusAuto success. internal: " + l + " limit: " + this.jdField_b_of_type_Long);
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 40001L, true, "auto_reset");
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AutoStatusManager", 2, "[status][autoMgr] resetStatusAuto fail by Frequency. internal: " + l + " limit: " + this.jdField_b_of_type_Long);
    }
    if (paramBoolean)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      c();
    }
    return false;
  }
  
  public void b()
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus();
    if ((l == 40001L) || (l == 41042L))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void b(@NonNull String paramString)
  {
    b(paramString, false);
  }
  
  public void b(@NonNull String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AutoStatusManager", 2, "[status][autoMgr] stopDetector from: " + paramString + " already stopped");
          }
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.e("AutoStatusManager", 2, "[status][autoMgr] stopDetector from: " + paramString + " success");
        }
        if (paramBoolean)
        {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 600000L);
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationLocationBaseStateDetector.a(paramBoolean);
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          SharePreferenceUtils.a(BaseApplication.getContext(), "KEY_LAST_AUTO_RESET_TIME_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), String.valueOf(this.jdField_b_of_type_Long));
          continue;
        }
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      finally {}
      c();
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoStatusManager", 2, "[status][autoMgr] onAppForeground from: " + paramString);
    }
    a("Foreground");
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoStatusManager", 2, "[status][autoMgr] onAppBackground from: " + paramString);
    }
    paramString = (OnlineStatusManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.ONLINE_STATUS_MANAGER);
    if (paramString != null) {
      paramString.a().b("Background", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.AutoStatusManager
 * JD-Core Version:    0.7.0.1
 */