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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

public class AutoStatusManager
  implements IGuardInterface, IAutoStatusManager
{
  @ConfigInject(configPath="/Business/qqonlinestatus-impl/src/main/resources/Inject_onlinestatus_business.yml", version=1)
  public static ArrayList<Class<? extends IOnlineStatusInjector>> c = new ArrayList();
  ActionDetector a;
  LocationBaseStateDetector b;
  Runnable d = new AutoStatusManager.3(this);
  private AppInterface e;
  private Handler f = new Handler(ThreadManagerV2.getSubThreadLooper());
  private volatile long g = Constant.c;
  private volatile boolean h = false;
  private AutoStatus i = new AutoStatus(40001);
  private long j = 0L;
  private AutoStatusManager.OnAutoStatusChangedListener k;
  private AutoStatusManager.ScreenBroadcastReceiver l = new AutoStatusManager.ScreenBroadcastReceiver(null);
  private Runnable m = new AutoStatusManager.1(this);
  private IOnlineStatusInjector n;
  private OnlineStatusObserver o = new AutoStatusManager.5(this);
  private OnlineStatusPermissionObserver p = new AutoStatusManager.6(this);
  
  static
  {
    c.add(OnlineStatusInjectorImpl.class);
  }
  
  public AutoStatusManager(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] AutoStatusManager() called");
    }
    this.e = paramAppInterface;
    g();
    this.a = new ActionDetector(this.e);
    this.b = new LocationBaseStateDetector(this.e, new AutoStatusManager.2(this));
    this.e.registObserver(this.p);
    this.e.addObserver(this.o);
    paramAppInterface = new IntentFilter();
    paramAppInterface.addAction("android.intent.action.SCREEN_OFF");
    MobileQQ.sMobileQQ.registerReceiver(this.l, paramAppInterface);
    if (GuardManager.sInstance != null) {
      GuardManager.sInstance.registerCallBack(this);
    }
    i();
  }
  
  @NonNull
  public static Intent a(AppInterface paramAppInterface, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ext_status", paramLong);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("is_background", true ^ GuardManager.sInstance.isApplicationForeground());
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
        ((StringBuilder)localObject).append(Constant.c(paramInt2));
        ((StringBuilder)localObject).append(" last: ");
        ((StringBuilder)localObject).append(Constant.c(paramInt1));
        QLog.e("AutoStatusManager", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.k;
      if (localObject != null) {
        ((AutoStatusManager.OnAutoStatusChangedListener)localObject).a(paramInt2);
      }
      if (paramInt2 == 40001)
      {
        if (paramLong > 40001L)
        {
          if (a(true)) {
            this.i.a(paramInt2);
          }
        }
        else
        {
          a(this.e);
          d();
          this.i.a(paramInt2);
        }
      }
      else
      {
        this.i.a(paramInt2);
        localObject = Constant.b(paramInt2);
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
      ExtensionBizInfoHelper.a.b(this.e, ExtensionBizInfoHelper.a.a(), paramInt2);
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
      ((StringBuilder)localObject).append(Constant.c((int)paramLong));
      ((StringBuilder)localObject).append(" auto: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("AutoStatusManager", 2, ((StringBuilder)localObject).toString());
    }
    paramString = (IOnlineStatusService)paramAppInterface.getRuntimeService(IOnlineStatusService.class, "");
    Object localObject = (AutoStatusManager)((IOnlineStatusManagerService)paramAppInterface.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IAutoStatusManager.class);
    a(((AutoStatusManager)localObject).e);
    ((AutoStatusManager)localObject).d();
    if (paramLong != 40001L) {
      ExtensionBizInfoHelper.a.a(paramAppInterface, ExtensionBizInfoHelper.a.a(), (int)paramLong);
    }
    paramString.updateOnlineStatus(AppRuntime.Status.online, paramLong, paramBoolean);
    if (Constant.a(paramLong)) {
      ((AutoStatusManager)localObject).b.a(paramLong);
    }
  }
  
  private void a(AutoStatusItem paramAutoStatusItem)
  {
    int i1 = (int)((IOnlineStatusService)this.e.getRuntimeService(IOnlineStatusService.class, "")).getExtOnlineStatus();
    StringBuilder localStringBuilder;
    if (i1 == paramAutoStatusItem.b)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][autoMgr] showTips fail status : ");
        localStringBuilder.append(paramAutoStatusItem);
        localStringBuilder.append(" real: ");
        localStringBuilder.append(i1);
        QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
      }
      a(this.e);
      d();
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][autoMgr] showTips success status : ");
      localStringBuilder.append(paramAutoStatusItem);
      localStringBuilder.append(" real: ");
      localStringBuilder.append(i1);
      QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
    }
    if (i1 > 40001)
    {
      boolean bool = a(i1);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][autoMgr] showTips real statusChanged: ");
        localStringBuilder.append(bool);
        localStringBuilder.append(" real: ");
        localStringBuilder.append(Constant.c(i1));
        QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
      }
      if (bool) {
        a(false);
      }
    }
    if ((QBaseActivity.mAppForground) && (f()))
    {
      b(paramAutoStatusItem);
      d();
      return;
    }
    b(paramAutoStatusItem);
    c(paramAutoStatusItem);
  }
  
  private boolean a(int paramInt)
  {
    int i1 = this.a.a();
    boolean bool = false;
    if (paramInt == i1) {
      return false;
    }
    if (paramInt == this.b.f()) {
      return false;
    }
    if (Constant.P) {
      i1 = this.b.d();
    } else {
      i1 = this.b.e();
    }
    if (paramInt != i1) {
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
    ((Bundle)localObject).putInt("StatusId", (int)paramAutoStatusItem.b);
    this.e.notifyObservers(OnAutoStatusBannerObserver.class, 26372, true, (Bundle)localObject);
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
    Object localObject = a(this.e, paramAutoStatusItem.b);
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(this.e.getApp());
    localBuilder.setContentText(String.format(this.e.getApp().getString(2131887169), new Object[] { paramAutoStatusItem.c })).setWhen(System.currentTimeMillis()).setSmallIcon(2130842313).setAutoCancel(true).setContentIntent(PendingIntent.getActivity(this.e.getApp(), 0, (Intent)localObject, 134217728));
    paramAutoStatusItem = localBuilder.build();
    QQNotificationManager.addChannelIfNeed(paramAutoStatusItem, "CHANNEL_ID_OTHER");
    QQNotificationManager.getInstance().notify("AutoStatusManager", 3000530, paramAutoStatusItem);
    if (!GuardManager.sInstance.isApplicationForeground())
    {
      ReportHelperKt.a("0X800AFA2", 1);
      return;
    }
    ReportHelperKt.a("0X800AFA1", 1);
  }
  
  private void e()
  {
    long l1 = ((IOnlineStatusService)this.e.getRuntimeService(IOnlineStatusService.class, "")).getExtOnlineStatus();
    int i4 = a();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][autoMgr] updateAutoStatus last status: ");
      localStringBuilder.append(Constant.c(i4));
      localStringBuilder.append(" real status: ");
      localStringBuilder.append(Constant.c((int)l1));
      QLog.w("AutoStatusManager", 2, localStringBuilder.toString());
    }
    if (l1 < 40000L)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][autoMgr] updateAutoStatus [user submit no auto status] stopDetector. last status: ");
        localStringBuilder.append(Constant.c(i4));
        localStringBuilder.append(" real status: ");
        localStringBuilder.append(Constant.c((int)l1));
        QLog.w("AutoStatusManager", 2, localStringBuilder.toString());
      }
      b("updateStatus");
      return;
    }
    int i2 = this.a.a();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][autoMgr] updateAutoStatus actionStatus: ");
      localStringBuilder.append(Constant.c(i2));
      localStringBuilder.append(" enable: ");
      localStringBuilder.append(Constant.S.contains(Integer.valueOf(i2)));
      QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
    }
    int i1;
    if ((i2 > 40001) && (Constant.S.contains(Integer.valueOf(i2))))
    {
      i1 = i2;
    }
    else
    {
      int i3;
      if (Constant.P)
      {
        i1 = this.b.d();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[status][autoMgr] updateAutoStatus getNewMovementStatus: ");
          localStringBuilder.append(Constant.c(i1));
          localStringBuilder.append(" enable: ");
          localStringBuilder.append(Constant.S.contains(Integer.valueOf(i1)));
          QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
        }
        if ((i1 <= 40001) || (!Constant.S.contains(Integer.valueOf(i1))))
        {
          i3 = this.b.f();
          i1 = i3;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[status][autoMgr] updateAutoStatus categoryStatus: ");
            localStringBuilder.append(Constant.c(i3));
            localStringBuilder.append(" enable: ");
            localStringBuilder.append(Constant.S.contains(Integer.valueOf(i3)));
            QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
            i1 = i3;
          }
        }
      }
      else
      {
        i1 = this.b.e();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[status][autoMgr] updateAutoStatus movementStatus: ");
          localStringBuilder.append(Constant.c(i1));
          localStringBuilder.append(" enable: ");
          localStringBuilder.append(Constant.S.contains(Integer.valueOf(i1)));
          QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
        }
        if ((i1 <= 40001) || (!Constant.S.contains(Integer.valueOf(i1))))
        {
          i3 = this.b.f();
          i1 = i3;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[status][autoMgr] updateAutoStatus categoryStatus: ");
            localStringBuilder.append(Constant.c(i3));
            localStringBuilder.append(" enable: ");
            localStringBuilder.append(Constant.S.contains(Integer.valueOf(i3)));
            QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
            i1 = i3;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][autoMgr] updateAutoStatus result: ");
      localStringBuilder.append(Constant.c(i1));
      localStringBuilder.append(" enable: ");
      localStringBuilder.append(Constant.S.contains(Integer.valueOf(i1)));
      QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
    }
    if ((i1 > 40001) && (!Constant.S.contains(Integer.valueOf(i1))))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][autoMgr] updateAutoStatus detected disabled cur status: ");
        localStringBuilder.append(Constant.c(i1));
        QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
      }
      i1 = 40001;
    }
    a(l1, i4, i1, i2);
  }
  
  private boolean f()
  {
    IOnlineStatusInjector localIOnlineStatusInjector = this.n;
    if (localIOnlineStatusInjector != null) {
      return localIOnlineStatusInjector.a();
    }
    QLog.w("AutoStatusManager", 1, "isConversationTabTop injector not init");
    return false;
  }
  
  private void g()
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
        ((StringBuilder)localObject).append(this.h);
        QLog.e("AutoStatusManager", 2, ((StringBuilder)localObject).toString());
      }
      if (this.h) {
        b("configDrop");
      }
      return;
    }
    Object localObject = (OnlineAutoStatusBean)QConfigManager.b().b(652);
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
  
  private void h()
  {
    Object localObject1 = ((OnlineStatusPermissionManager)((IOnlineStatusManagerService)this.e.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusPermissionManager.class)).b();
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
      Constant.S = (List)localObject1;
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("AutoStatusManager", 2, "[status][autoMgr] loadEnabledStatus smartSelectedList is null");
      }
      Constant.S = new ArrayList();
    }
    localObject1 = Constant.S.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][autoMgr] loadEnabledStatus status: ");
        localStringBuilder.append(Constant.c(((Integer)localObject2).intValue()));
        QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void i()
  {
    try
    {
      if (c != null)
      {
        Iterator localIterator = c.iterator();
        while (localIterator.hasNext()) {
          this.n = ((IOnlineStatusInjector)((Class)localIterator.next()).newInstance());
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AutoStatusManager", 1, "initInjector Fail,", localThrowable);
    }
  }
  
  public int a()
  {
    return this.i.a;
  }
  
  public String a(Integer paramInteger)
  {
    Integer localInteger = paramInteger;
    if (paramInteger == null) {
      localInteger = Integer.valueOf(a());
    }
    paramInteger = Constant.b(localInteger.intValue());
    if (paramInteger != null) {
      return paramInteger.c;
    }
    paramInteger = OnLineStatusHelper.a().a(AppRuntime.Status.online, 40001L);
    if (paramInteger.i == null) {
      return "";
    }
    return paramInteger.i;
  }
  
  public void a(AutoStatusManager.OnAutoStatusChangedListener paramOnAutoStatusChangedListener)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][autoMgr] startDetector listener: ");
      localStringBuilder.append(paramOnAutoStatusChangedListener);
      QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
    }
    this.k = paramOnAutoStatusChangedListener;
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
        Object localObject = (IOnlineStatusService)this.e.getRuntimeService(IOnlineStatusService.class, "");
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
            localStringBuilder.append(this.h);
            QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
          }
          if (this.h)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("startFail-");
            ((StringBuilder)localObject).append(paramString);
            b(((StringBuilder)localObject).toString());
          }
          return;
        }
        if (paramBoolean) {
          this.i.a((int)((IOnlineStatusService)localObject).getExtOnlineStatus());
        }
        if ((GuardManager.sInstance != null) && (GuardManager.sInstance.isApplicationForeground()))
        {
          i1 = 1;
          if (i1 == 0)
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
              localStringBuilder.append(this.h);
              QLog.d("AutoStatusManager", 2, localStringBuilder.toString());
            }
            d("startDetector");
            return;
          }
          if (this.h)
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
          this.h = true;
          g();
          h();
          long l2 = ((IOnlineStatusService)localObject).getExtOnlineStatus();
          if (this.i.a != l2) {
            this.i.a("autoMgr");
          }
          this.b.a(this.e.getApp());
          l1 = 30000L;
          if ((l2 == 41031L) || (l2 == 41014L)) {
            break label976;
          }
          if (l2 == 41042L) {
            l1 = this.b.c();
          }
          localObject = BaseApplication.getContext();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("KEY_LAST_AUTO_RESET_TIME_");
          localStringBuilder.append(this.e.getCurrentUin());
          localObject = SharePreferenceUtils.a((Context)localObject, localStringBuilder.toString());
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            this.j = Long.parseLong((String)localObject);
          }
          long l3 = System.currentTimeMillis() - this.j;
          if (l3 < this.g)
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
            this.f.postDelayed(this.d, Math.max(l1, l3));
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
            this.f.postDelayed(this.d, l1);
          }
          return;
        }
      }
      finally {}
      int i1 = 0;
      continue;
      label976:
      long l1 = 390000L;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis() - this.j;
    StringBuilder localStringBuilder;
    if (l1 > this.g)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][autoMgr] resetStatusAuto success. internal: ");
        localStringBuilder.append(l1);
        localStringBuilder.append(" limit: ");
        localStringBuilder.append(this.j);
        QLog.e("AutoStatusManager", 2, localStringBuilder.toString());
      }
      a(this.e, 40001L, true, "auto_reset");
      this.j = System.currentTimeMillis();
      return true;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][autoMgr] resetStatusAuto fail by Frequency. internal: ");
      localStringBuilder.append(l1);
      localStringBuilder.append(" limit: ");
      localStringBuilder.append(this.j);
      QLog.e("AutoStatusManager", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      a(this.e);
      d();
    }
    return false;
  }
  
  public void b()
  {
    long l1 = ((IOnlineStatusService)this.e.getRuntimeService(IOnlineStatusService.class, "")).getExtOnlineStatus();
    if ((l1 == 40001L) || (l1 == 41042L))
    {
      this.f.removeCallbacks(this.d);
      this.f.post(this.d);
    }
  }
  
  public void b(@NonNull String paramString)
  {
    b(paramString, false);
  }
  
  public void b(@NonNull String paramString, boolean paramBoolean)
  {
    try
    {
      if (!this.h)
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
        this.f.postDelayed(this.m, 600000L);
      }
      else
      {
        a(this.e);
        d();
      }
      this.h = false;
      this.b.a(paramBoolean);
      this.f.removeCallbacks(this.d);
      paramString = BaseApplication.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("KEY_LAST_AUTO_RESET_TIME_");
      localStringBuilder.append(this.e.getCurrentUin());
      SharePreferenceUtils.a(paramString, localStringBuilder.toString(), String.valueOf(this.j));
      return;
    }
    finally {}
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("AutoStatusManager", 2, "[status][autoMgr] destroy");
    }
    if (this.h) {
      b("destroy");
    }
    this.e.unRegistObserver(this.p);
    this.e.removeObserver(this.o);
    MobileQQ.sMobileQQ.unregisterReceiver(this.l);
    if (GuardManager.sInstance != null) {
      GuardManager.sInstance.unregisterCallback(this);
    }
  }
  
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
    this.f.removeCallbacks(this.m);
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
    b("Background", true);
  }
  
  public void onApplicationBackground()
  {
    d("ForeBackgroundSwitch");
  }
  
  public void onApplicationForeground()
  {
    c("ForeBackgroundSwitch");
  }
  
  public void onBackgroundTimeTick(long paramLong) {}
  
  public void onBackgroundUnguardTimeTick(long paramLong) {}
  
  public void onLiteTimeTick(long paramLong) {}
  
  public void onScreensStateChanged(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.AutoStatusManager
 * JD-Core Version:    0.7.0.1
 */