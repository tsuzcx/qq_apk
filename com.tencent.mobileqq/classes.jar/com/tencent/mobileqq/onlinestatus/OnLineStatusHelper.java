package com.tencent.mobileqq.onlinestatus;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineAutoStatusBean;
import com.tencent.mobileqq.config.business.OnlineStatusBean;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusElement;
import com.tencent.mobileqq.onlinestatus.config.WeatherUrl;
import com.tencent.mobileqq.onlinestatus.config.olympic.OlympicConfBean;
import com.tencent.mobileqq.onlinestatus.config.olympic.OlympicConfBean.OlympicConfig;
import com.tencent.mobileqq.onlinestatus.config.olympic.OlympicConfProcessor;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationLauncher;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationUtilKt;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineMusicStatusManager;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusOlympicManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineMusicStatusManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusOlympicManager;
import com.tencent.mobileqq.onlinestatus.olympic.model.OlympicMedalEventInfo;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusSPUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.mobileqq.vas.onlinestatus.api.ICustomOnlineStatusManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.OnlineBatteryProducer;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import tencent.im.onlinestatus.OnlineStatusExtInfo.WeatherBizInfo;

public class OnLineStatusHelper
{
  private int a = 0;
  private OnlineBatteryProducer b = new OnlineBatteryProducer();
  private OlympicMedalEventInfo c;
  
  private int a(int paramInt)
  {
    int j = 12;
    int i = j;
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          i = j;
        } else {
          i = 32;
        }
      }
      else {
        i = 24;
      }
    }
    return Utils.a(i, MobileQQ.sMobileQQ.getResources());
  }
  
  public static OnLineStatusHelper a()
  {
    return OnLineStatusHelper.OnLineStatusHelperHolder.a();
  }
  
  private String a(AppRuntime paramAppRuntime, Friends paramFriends, IOnlineStatusService paramIOnlineStatusService)
  {
    if (paramAppRuntime.getCurrentAccountUin().equals(paramFriends.uin))
    {
      if (paramIOnlineStatusService.getPowerConnect() == 1)
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append(paramIOnlineStatusService.getBatteryCapacity());
        paramAppRuntime.append("% ");
        paramAppRuntime.append(c(paramFriends));
        paramAppRuntime.append("充电中");
        return paramAppRuntime.toString();
      }
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append(paramIOnlineStatusService.getBatteryCapacity());
      paramAppRuntime.append("% ");
      paramAppRuntime.append(c(paramFriends));
      paramAppRuntime.append("电量");
      return paramAppRuntime.toString();
    }
    if (a(paramFriends) > 0)
    {
      if (paramFriends.isBatteryCharging())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append(a(paramFriends));
        paramAppRuntime.append("% ");
        paramAppRuntime.append(c(paramFriends));
        paramAppRuntime.append("充电中");
        return paramAppRuntime.toString();
      }
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append(a(paramFriends));
      paramAppRuntime.append("% ");
      paramAppRuntime.append(c(paramFriends));
      paramAppRuntime.append("电量");
      return paramAppRuntime.toString();
    }
    return ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getStatusName(paramFriends);
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt2 == 1) {
      i = paramInt1 | 0x80;
    } else {
      i = paramInt1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnLineStatusHelper", 2, new Object[] { "OnlineStatusHelper ret:", Integer.valueOf(i), " batteryCapacity:", Integer.valueOf(paramInt1), " powerConectStatus:", Integer.valueOf(paramInt2) });
    }
    return i;
  }
  
  private String c(Friends paramFriends)
  {
    if ((paramFriends != null) && (a(paramFriends.uin))) {
      paramFriends = ((ICustomOnlineStatusManager)QRoute.api(ICustomOnlineStatusManager.class)).getOwnerOnlineStatus();
    } else if ((paramFriends != null) && (!TextUtils.isEmpty(paramFriends.strTermDesc))) {
      paramFriends = paramFriends.strTermDesc;
    } else {
      paramFriends = null;
    }
    if ((!TextUtils.isEmpty(paramFriends)) && (paramFriends.contains("在线")))
    {
      paramFriends = paramFriends.substring(0, paramFriends.length() - 2);
      if (!TextUtils.isEmpty(paramFriends)) {
        return paramFriends;
      }
    }
    return "手机";
  }
  
  public static boolean c(AppRuntime.Status paramStatus, long paramLong)
  {
    OnlineStatusBean localOnlineStatusBean = (OnlineStatusBean)QConfigManager.b().b(578);
    if (localOnlineStatusBean == null) {
      return false;
    }
    return localOnlineStatusBean.c(paramStatus, paramLong);
  }
  
  public static int g()
  {
    int i;
    if (Build.VERSION.SDK_INT >= 21)
    {
      j = ((BatteryManager)BaseApplication.getContext().getSystemService("batterymanager")).getIntProperty(4);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("OnLineStatusHelper", 2, new Object[] { "BatterManager ", Integer.valueOf(j) });
        i = j;
      }
    }
    else
    {
      i = 0;
    }
    int j = i;
    if (i <= 0) {
      j = OnlineStatusSPUtil.a(MobileQQ.sMobileQQ);
    }
    return j;
  }
  
  public static int h()
  {
    int j = OnlineStatusSPUtil.b(MobileQQ.sMobileQQ);
    int i = j;
    if (j == -1)
    {
      i = j;
      if (Build.VERSION.SDK_INT >= 21)
      {
        BatteryManager localBatteryManager = (BatteryManager)BaseApplication.getContext().getSystemService("batterymanager");
        boolean bool;
        if (Build.VERSION.SDK_INT >= 23) {
          bool = localBatteryManager.isCharging();
        } else {
          bool = false;
        }
        j = localBatteryManager.getIntProperty(6);
        if ((j != 2) && (j != 5) && (!bool)) {
          i = 0;
        } else {
          i = 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("OnLineStatusHelper", 2, new Object[] { "BatterManager isCharging:", Boolean.valueOf(bool), " chargeStatus:", Integer.valueOf(j) });
        }
      }
    }
    return i;
  }
  
  public static int i()
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 21)
        {
          BatteryManager localBatteryManager = (BatteryManager)BaseApplication.getContext().getSystemService("batterymanager");
          if (Build.VERSION.SDK_INT < 23) {
            break label137;
          }
          bool = localBatteryManager.isCharging();
          int k = localBatteryManager.getIntProperty(6);
          if ((k != 2) && (k != 5) && (!bool)) {
            i = 0;
          } else {
            i = 1;
          }
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("OnLineStatusHelper", 2, new Object[] { "getLocalPowerConnectStatus isCharging:", Boolean.valueOf(bool), " chargeStatus:", Integer.valueOf(k) });
            }
            return i;
          }
          catch (Throwable localThrowable1) {}
          QLog.e("OnLineStatusHelper", 1, "getLocalPower t:", localThrowable2);
        }
      }
      catch (Throwable localThrowable2)
      {
        i = j;
      }
      return i;
      label137:
      boolean bool = false;
    }
  }
  
  public int a(Friends paramFriends)
  {
    if ((paramFriends != null) && (!a(paramFriends.uin))) {
      return Math.max(0, Math.min(paramFriends.getBatteryCapacity(), 100));
    }
    return g();
  }
  
  public long a(AppRuntime paramAppRuntime)
  {
    IOnlineStatusService localIOnlineStatusService = (IOnlineStatusService)paramAppRuntime.getRuntimeService(IOnlineStatusService.class, "");
    long l2 = localIOnlineStatusService.getExtOnlineStatus();
    long l1 = l2;
    if (l2 == -1L)
    {
      MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("acc_info");
      localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
      l2 = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getLong("getOnlineStatusExt", -1L);
      l1 = l2;
      if (l2 != -1L)
      {
        localIOnlineStatusService.setExtOnlineStatus(l2);
        l1 = l2;
      }
    }
    return l1;
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(paramInt2);
    String str = ((StringBuilder)localObject).toString();
    Bitmap localBitmap = CommonImageCacheHelper.a(str);
    localObject = localBitmap;
    if (localBitmap == null)
    {
      Drawable localDrawable = this.b.a(paramInt1, paramInt2);
      localObject = localBitmap;
      if ((localDrawable instanceof BitmapDrawable))
      {
        localObject = ((BitmapDrawable)localDrawable).getBitmap();
        CommonImageCacheHelper.a(str, (Bitmap)localObject);
      }
    }
    return localObject;
  }
  
  public Drawable a(long paramLong, AppRuntime.Status paramStatus, int paramInt, Friends paramFriends)
  {
    return a(paramLong, paramStatus, paramInt, paramFriends, 3);
  }
  
  public Drawable a(long paramLong, AppRuntime.Status paramStatus, int paramInt1, Friends paramFriends, int paramInt2)
  {
    if (paramStatus == AppRuntime.Status.online)
    {
      OnlineStatusItem localOnlineStatusItem = a(AppRuntime.Status.online, paramLong);
      if (localOnlineStatusItem != null) {
        return a(localOnlineStatusItem, paramFriends, paramInt1, paramInt2);
      }
    }
    return OnlineStatusConstants.a(paramStatus, a(paramInt1));
  }
  
  Drawable a(OnlineStatusItem paramOnlineStatusItem, int paramInt)
  {
    if (paramInt == 5) {
      return URLDrawable.getDrawable(paramOnlineStatusItem.e, URLDrawable.URLDrawableOptions.obtain());
    }
    return URLDrawable.getDrawable(paramOnlineStatusItem.d, URLDrawable.URLDrawableOptions.obtain());
  }
  
  public Drawable a(OnlineStatusItem paramOnlineStatusItem, int paramInt1, int paramInt2)
  {
    if (d()) {
      return a(paramOnlineStatusItem.m, paramInt1);
    }
    if (paramInt2 == 6)
    {
      OlympicConfBean.OlympicConfig localOlympicConfig = OlympicConfProcessor.b().b();
      if (TextUtils.isEmpty(localOlympicConfig.d)) {
        return a(paramOnlineStatusItem, paramInt2);
      }
      return a(localOlympicConfig.d, paramInt1);
    }
    return a(paramOnlineStatusItem, paramInt2);
  }
  
  public Drawable a(OnlineStatusItem paramOnlineStatusItem, Friends paramFriends, int paramInt)
  {
    if ((paramInt != 5) && (paramInt != 6)) {
      return b(paramOnlineStatusItem, paramFriends);
    }
    return a(paramOnlineStatusItem, paramFriends, 2, paramInt);
  }
  
  Drawable a(OnlineStatusItem paramOnlineStatusItem, @Nullable Friends paramFriends, int paramInt1, int paramInt2)
  {
    int i = a(paramInt1);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramOnlineStatusItem != null)
    {
      if (paramOnlineStatusItem.f == 2)
      {
        paramOnlineStatusItem = paramOnlineStatusItem.g;
        paramInt1 = i;
        if (paramInt2 == 1) {
          paramInt1 = 0;
        }
        return OnlineStatusConstants.a(paramOnlineStatusItem, paramInt1);
      }
      if (a(paramOnlineStatusItem))
      {
        if (a(paramFriends) > 0) {
          return this.b.a(a(paramFriends), paramInt1);
        }
        if (paramFriends != null)
        {
          localObject1 = localObject2;
          if (!a(paramFriends.uin)) {}
        }
        else
        {
          paramOnlineStatusItem = a(paramOnlineStatusItem, paramInt2);
          paramOnlineStatusItem.setBounds(0, 0, i, i);
          return paramOnlineStatusItem;
        }
      }
      else
      {
        if (paramOnlineStatusItem.b == 1030L)
        {
          localObject1 = (OnlineAutoStatusBean)QConfigManager.b().b(652);
          if ((localObject1 != null) && (paramFriends != null)) {
            paramFriends = a(paramFriends, BaseApplication.getContext(), paramInt2, (OnlineAutoStatusBean)localObject1);
          } else {
            paramFriends = "";
          }
          if (QLog.isColorLevel()) {
            QLog.d("OnLineStatusHelper", 4, new Object[] { "URL=", paramFriends });
          }
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
          if (!TextUtils.isEmpty(paramFriends))
          {
            paramOnlineStatusItem = URLDrawable.getDrawable(paramFriends, (URLDrawable.URLDrawableOptions)localObject1);
            paramOnlineStatusItem.setBounds(0, 0, i, i);
          }
          else
          {
            paramOnlineStatusItem = a(paramOnlineStatusItem, paramInt2);
            paramOnlineStatusItem.setBounds(0, 0, i, i);
          }
          return paramOnlineStatusItem;
        }
        if (paramOnlineStatusItem.b == 1080L)
        {
          paramOnlineStatusItem = a(paramOnlineStatusItem, i, paramInt2);
          localObject1 = paramOnlineStatusItem;
          if (paramOnlineStatusItem != null)
          {
            paramOnlineStatusItem.setBounds(0, 0, i, i);
            return paramOnlineStatusItem;
          }
        }
        else
        {
          localObject1 = a(paramOnlineStatusItem, paramInt2);
          ((Drawable)localObject1).setBounds(0, 0, i, i);
        }
      }
    }
    return localObject1;
  }
  
  public Bundle a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    paramAppRuntime = (IOnlineStatusService)paramAppRuntime.getRuntimeService(IOnlineStatusService.class, "");
    int i = paramAppRuntime.getBatteryCapacity();
    int j = paramAppRuntime.getPowerConnect();
    int k = b(i, j);
    localBundle.putInt("BatteryInfo", k);
    localBundle.putBoolean("from_register", paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("OnLineStatusHelper", 2, new Object[] { "buildSetBatteryData batteryCapacity:", Integer.valueOf(i), " powerConnect:", Integer.valueOf(j), " sendBattery:", Integer.valueOf(k), " fromRegister:", Boolean.valueOf(paramBoolean) });
    }
    return localBundle;
  }
  
  URLDrawable a(String paramString, int paramInt)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramInt;
    localURLDrawableOptions.mRequestHeight = paramInt;
    localURLDrawableOptions.mUseApngImage = true;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  public OnlineStatusItem a(AppRuntime.Status paramStatus, long paramLong)
  {
    return a(paramStatus, paramLong, false);
  }
  
  public OnlineStatusItem a(AppRuntime.Status paramStatus, long paramLong, boolean paramBoolean)
  {
    if (paramStatus == null) {
      localObject = Integer.valueOf(-1);
    } else {
      localObject = paramStatus;
    }
    QLog.d("OnLineStatusHelper", 1, new Object[] { "getOnlineStatusItem status=", localObject, " onlineStatusIDValue=", Long.valueOf(paramLong) });
    if ((paramStatus == AppRuntime.Status.online) && (paramLong > 40000L))
    {
      localObject = (OnlineAutoStatusBean)QConfigManager.b().b(652);
      if (localObject != null)
      {
        if (paramBoolean) {
          paramStatus = ((OnlineAutoStatusBean)localObject).b(paramStatus, paramLong);
        } else {
          paramStatus = ((OnlineAutoStatusBean)localObject).a(paramStatus, paramLong);
        }
        localObject = paramStatus;
        if (paramStatus == null) {
          localObject = new OnlineStatusItem(AppRuntime.Status.online);
        }
        return localObject;
      }
    }
    Object localObject = (OnlineStatusBean)QConfigManager.b().b(578);
    if ((localObject != null) && (paramStatus == AppRuntime.Status.online)) {
      return ((OnlineStatusBean)localObject).b(paramStatus, paramLong);
    }
    if (localObject != null) {
      return ((OnlineStatusBean)localObject).b(paramStatus, 0L);
    }
    return new OnlineStatusItem(AppRuntime.Status.online);
  }
  
  public String a(long paramLong, AppRuntime.Status paramStatus)
  {
    if (paramStatus == AppRuntime.Status.online)
    {
      if (paramLong == 1000L) {
        return "我的电量";
      }
      OnlineStatusItem localOnlineStatusItem = a(AppRuntime.Status.online, paramLong);
      if ((localOnlineStatusItem != null) && (!TextUtils.isEmpty(localOnlineStatusItem.c))) {
        return localOnlineStatusItem.c;
      }
    }
    return OnlineStatusConstants.a(paramStatus);
  }
  
  protected String a(Friends paramFriends, Context paramContext, int paramInt, OnlineAutoStatusBean paramOnlineAutoStatusBean)
  {
    boolean bool = a(paramFriends.uin);
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      i = paramContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION");
    } else {
      i = 0;
    }
    if ((i != 0) && (bool)) {
      paramContext = paramOnlineAutoStatusBean.b("202");
    } else {
      paramContext = paramOnlineAutoStatusBean.b(paramFriends.weatherTypeId);
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnLineStatusHelper", 2, new Object[] { "weatherTypeId=", paramFriends.weatherTypeId, ",isSelfUin=", Boolean.valueOf(bool) });
    }
    if (paramContext != null)
    {
      paramFriends = paramContext.d;
      if (paramInt == 5) {
        return paramContext.e;
      }
    }
    else
    {
      paramFriends = "";
    }
    return paramFriends;
  }
  
  public String a(AppRuntime paramAppRuntime, Friends paramFriends, TextView paramTextView, int paramInt, OnlineStatusItem paramOnlineStatusItem, Boolean paramBoolean)
  {
    AppRuntime.Status localStatus = a().b(paramOnlineStatusItem);
    if (!Boolean.valueOf(a(paramOnlineStatusItem, paramFriends, paramBoolean.booleanValue())).booleanValue())
    {
      if ((paramInt != 5) && (paramInt != 1)) {
        paramAppRuntime = OnlineStatusUtil.e(paramFriends);
      } else {
        paramAppRuntime = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getStatusName(paramFriends);
      }
      paramFriends = paramAppRuntime;
      if (TextUtils.isEmpty(paramAppRuntime)) {
        paramFriends = MobileQQ.sMobileQQ.getResources().getString(2131916782);
      }
      return paramFriends;
    }
    return a().b(paramAppRuntime, paramOnlineStatusItem, localStatus, paramFriends, paramTextView, paramInt);
  }
  
  public String a(AppRuntime paramAppRuntime, OnlineStatusItem paramOnlineStatusItem, AppRuntime.Status paramStatus, Friends paramFriends, TextView paramTextView, int paramInt)
  {
    if (paramStatus == AppRuntime.Status.online)
    {
      boolean bool;
      if (paramOnlineStatusItem.b > 0L) {
        bool = true;
      } else {
        bool = false;
      }
      return a(paramAppRuntime, paramFriends, paramTextView, 4, paramOnlineStatusItem, Boolean.valueOf(bool));
    }
    return b(paramAppRuntime, paramOnlineStatusItem, paramStatus, paramFriends, paramTextView, paramInt);
  }
  
  public void a(Friends paramFriends, TextView paramTextView, boolean paramBoolean, OnlineStatusItem paramOnlineStatusItem, int paramInt)
  {
    Drawable[] arrayOfDrawable = paramTextView.getCompoundDrawables();
    if (paramBoolean)
    {
      paramTextView.setCompoundDrawablePadding(0);
      paramTextView.setCompoundDrawables(null, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return;
    }
    int i;
    if ((OnlineStatusUtils.a(paramFriends.detalStatusFlag, paramFriends.iTermType) == 4) && (paramFriends.uExtOnlineStatus > 0L) && (paramOnlineStatusItem != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) && (paramInt != 5) && (paramInt != 6))
    {
      paramTextView.setCompoundDrawablePadding(0);
      paramTextView.setCompoundDrawables(null, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return;
    }
    paramFriends = a().a(paramOnlineStatusItem, paramFriends, paramInt);
    if (paramFriends != null)
    {
      paramTextView.setCompoundDrawablePadding(Utils.a(4.0F, MobileQQ.sMobileQQ.getResources()));
      paramTextView.setCompoundDrawables(paramFriends, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
    }
  }
  
  public void a(OlympicMedalEventInfo paramOlympicMedalEventInfo)
  {
    this.c = paramOlympicMedalEventInfo;
  }
  
  public void a(AppRuntime paramAppRuntime, Friends paramFriends, TextView paramTextView, boolean paramBoolean)
  {
    Drawable[] arrayOfDrawable = paramTextView.getCompoundDrawables();
    if (paramFriends == null)
    {
      paramTextView.setCompoundDrawablePadding(0);
      paramTextView.setCompoundDrawables(null, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return;
    }
    int i = OnlineStatusUtils.a(paramFriends.detalStatusFlag, paramFriends.iTermType);
    boolean bool = paramAppRuntime.getCurrentUin().equals(paramFriends.uin);
    paramAppRuntime = a(AppRuntime.Status.online, paramFriends.uExtOnlineStatus, bool ^ true);
    if ((paramBoolean) && (i == 4) && (paramFriends.uExtOnlineStatus > 0L) && (paramAppRuntime != null))
    {
      if (a(paramAppRuntime))
      {
        if (a(paramFriends) > 0) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
      }
      else if (paramFriends.uExtOnlineStatus == 40001L) {
        paramBoolean = OnlineStatusUtil.b(paramAppRuntime);
      } else if (paramFriends.uExtOnlineStatus == 1040L) {
        paramBoolean = OnlineStatusUtil.c(paramFriends);
      } else {
        paramBoolean = a(paramAppRuntime, paramFriends) ^ true;
      }
      if (paramBoolean)
      {
        paramFriends = b(paramAppRuntime, paramFriends);
        paramAppRuntime = paramFriends;
        if (paramFriends != null)
        {
          paramBoolean = true;
          paramAppRuntime = paramFriends;
          break label213;
        }
      }
      else
      {
        paramAppRuntime = null;
        break label213;
      }
    }
    else
    {
      paramAppRuntime = null;
    }
    paramBoolean = false;
    label213:
    if (paramBoolean)
    {
      paramTextView.setCompoundDrawablePadding(Utils.a(4.0F, MobileQQ.sMobileQQ.getResources()));
      paramTextView.setCompoundDrawables(paramAppRuntime, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return;
    }
    paramTextView.setCompoundDrawablePadding(0);
    paramTextView.setCompoundDrawables(null, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
  }
  
  public boolean a(OnlineStatusItem paramOnlineStatusItem)
  {
    return (paramOnlineStatusItem != null) && (paramOnlineStatusItem.b == 1000L);
  }
  
  boolean a(OnlineStatusItem paramOnlineStatusItem, Friends paramFriends)
  {
    return (paramOnlineStatusItem.b == 1030L) && (!OnlineStatusUtil.b(paramFriends));
  }
  
  public boolean a(OnlineStatusItem paramOnlineStatusItem, Friends paramFriends, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramBoolean)
    {
      bool = paramBoolean;
      if (OnlineStatusItem.a(paramOnlineStatusItem.b)) {
        if (a().a(paramFriends) > 0) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
    paramBoolean = bool;
    if (paramOnlineStatusItem.b == 1030L)
    {
      paramBoolean = bool;
      if (!OnlineStatusUtil.b(paramFriends)) {
        paramBoolean = false;
      }
    }
    bool = paramBoolean;
    if (paramOnlineStatusItem.b == 1040L)
    {
      bool = paramBoolean;
      if (!OnlineStatusUtil.c(paramFriends)) {
        bool = false;
      }
    }
    paramBoolean = bool;
    if (paramOnlineStatusItem.b == 40001L)
    {
      paramBoolean = bool;
      if (!OnlineStatusUtil.b(paramOnlineStatusItem)) {
        paramBoolean = false;
      }
    }
    return paramBoolean;
  }
  
  protected boolean a(String paramString)
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    if (MobileQQ.sProcessId != 1) {
      return false;
    }
    return MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin().equals(paramString);
  }
  
  public boolean a(AppRuntime paramAppRuntime, Activity paramActivity, String paramString, View paramView)
  {
    if (a(paramAppRuntime, paramString))
    {
      paramView = ((IFriendDataService)paramAppRuntime.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString);
      boolean bool = paramAppRuntime.getCurrentUin().equals(paramString);
      paramString = a(AppRuntime.Status.online, paramView.uExtOnlineStatus, bool ^ true);
      if (paramString.b == 1028L)
      {
        if (!TextUtils.isEmpty(paramView.songId))
        {
          ((OnlineMusicStatusManager)((IOnlineStatusManagerService)paramAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineMusicStatusManager.class)).a(paramActivity, paramView.songId);
          return true;
        }
      }
      else if (paramString.b == 1030L)
      {
        paramAppRuntime = (OnlineAutoStatusBean)QConfigManager.b().b(652);
        if ((paramAppRuntime != null) && (paramAppRuntime.a != null) && (!TextUtils.isEmpty(paramAppRuntime.a.c)))
        {
          paramString = new StringBuilder();
          paramString.append(paramAppRuntime.a.c);
          paramString.append(paramView.adCode);
          paramAppRuntime = paramString.toString();
          ConstellationLauncher.c.a(paramActivity, paramAppRuntime, 4014);
          ReportHelperKt.a("0X800AF4C", 2);
          return true;
        }
      }
      else
      {
        if (paramString.b == 1040L)
        {
          ConstellationLauncher.c.a(paramActivity, paramView.constellationJumpUrl, 4014);
          ReportHelperKt.a("0X800AF4C", 1);
          return true;
        }
        if (paramString.b == 1080L)
        {
          if (!TextUtils.isEmpty(paramString.n))
          {
            paramAppRuntime = (OnlineStatusOlympicManager)((IOnlineStatusManagerService)paramAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusOlympicManager.class);
            paramView = new StringBuilder();
            paramView.append(paramString.n);
            paramView.append("&from=");
            paramView.append(2);
            paramAppRuntime.a(paramActivity, paramView.toString());
          }
          ReportHelperKt.a("0X800BD1E", 0);
        }
      }
      return true;
    }
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime, String paramString)
  {
    Friends localFriends = ((IFriendDataService)paramAppRuntime.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString);
    boolean bool = paramAppRuntime.getCurrentUin().equals(paramString);
    if (localFriends != null)
    {
      paramAppRuntime = a(AppRuntime.Status.online, localFriends.uExtOnlineStatus, bool ^ true);
      if (paramAppRuntime.b == 1028L) {
        return true;
      }
      if (paramAppRuntime.b == 1030L) {
        return OnlineStatusUtil.b(localFriends);
      }
      if (paramAppRuntime.b == 1040L) {
        return OnlineStatusUtil.c(localFriends);
      }
      if (paramAppRuntime.b == 1080L) {
        return true;
      }
    }
    return false;
  }
  
  public Drawable b(OnlineStatusItem paramOnlineStatusItem, Friends paramFriends)
  {
    return a(paramOnlineStatusItem, paramFriends, 0, 1);
  }
  
  public Bundle b(Friends paramFriends)
  {
    Bundle localBundle = new Bundle();
    OnlineStatusExtInfo.WeatherBizInfo localWeatherBizInfo = new OnlineStatusExtInfo.WeatherBizInfo();
    if (!TextUtils.isEmpty(paramFriends.city)) {
      localWeatherBizInfo.string_city.set(paramFriends.city);
    }
    if (!TextUtils.isEmpty(paramFriends.area)) {
      localWeatherBizInfo.string_area.set(paramFriends.area);
    }
    if (!TextUtils.isEmpty(paramFriends.temper)) {
      localWeatherBizInfo.string_temper.set(paramFriends.temper);
    }
    if (!TextUtils.isEmpty(paramFriends.weatherType)) {
      localWeatherBizInfo.string_weather_type.set(paramFriends.weatherType);
    }
    if (!TextUtils.isEmpty(paramFriends.weatherTypeId)) {
      localWeatherBizInfo.string_weather_type_id.set(paramFriends.weatherTypeId);
    }
    if (!TextUtils.isEmpty(paramFriends.weatherDecs)) {
      localWeatherBizInfo.string_weather_desc.set(paramFriends.weatherDecs);
    }
    int i;
    try
    {
      i = Integer.valueOf(paramFriends.adCode).intValue();
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusHelper", 4, "number error", localNumberFormatException);
      }
      i = 0;
    }
    localWeatherBizInfo.uint32_adcode.set(i);
    localWeatherBizInfo.uint64_update_time.set(paramFriends.weatherUpdateTime);
    localWeatherBizInfo.uint32_flag.set(paramFriends.weatherFlag);
    localBundle.putByteArray("ExtInfo", localWeatherBizInfo.toByteArray());
    localBundle.putInt("StatusId", 1030);
    if (QLog.isColorLevel()) {
      QLog.d("OnLineStatusHelper", 2, "buildWeatherData ");
    }
    return localBundle;
  }
  
  public Bundle b(AppRuntime paramAppRuntime)
  {
    Bundle localBundle = new Bundle();
    paramAppRuntime = (IOnlineStatusService)paramAppRuntime.getRuntimeService(IOnlineStatusService.class, "");
    int i = paramAppRuntime.getBatteryCapacity();
    int j = paramAppRuntime.getPowerConnect();
    int k = b(i, j);
    localBundle.putInt("BatteryInfo", k);
    if (QLog.isColorLevel()) {
      QLog.d("OnLineStatusHelper", 2, new Object[] { "OnlineStatusHelper batteryCapacity:", Integer.valueOf(i), " powerConnect:", Integer.valueOf(j), " sendBattery:", Integer.valueOf(k) });
    }
    return localBundle;
  }
  
  public String b(long paramLong, AppRuntime.Status paramStatus)
  {
    OnlineStatusItem localOnlineStatusItem = a(AppRuntime.Status.online, paramLong);
    if (OnlineStatusUtil.b(localOnlineStatusItem)) {
      return localOnlineStatusItem.i;
    }
    return a(paramLong, paramStatus);
  }
  
  public String b(AppRuntime paramAppRuntime, OnlineStatusItem paramOnlineStatusItem, AppRuntime.Status paramStatus, Friends paramFriends, TextView paramTextView, int paramInt)
  {
    IOnlineStatusService localIOnlineStatusService = (IOnlineStatusService)paramAppRuntime.getRuntimeService(IOnlineStatusService.class, "");
    if ((paramStatus == AppRuntime.Status.online) && (paramOnlineStatusItem != null))
    {
      if ((paramOnlineStatusItem.b == 1000L) && (paramFriends != null)) {
        return a(paramAppRuntime, paramFriends, localIOnlineStatusService);
      }
      if ((paramOnlineStatusItem.b == 1028L) && (paramFriends != null)) {
        return OnlineMusicStatusManager.a(paramAppRuntime, paramFriends, paramTextView);
      }
      if ((paramOnlineStatusItem.b == 1030L) && (paramFriends != null)) {
        return OnlineStatusUtil.a(paramAppRuntime, paramTextView, paramFriends, paramInt);
      }
      if ((paramOnlineStatusItem.b == 1040L) && (paramFriends != null))
      {
        paramAppRuntime = ConstellationUtilKt.b(paramFriends);
        if (QLog.isColorLevel()) {
          QLog.d("OnLineStatusHelper", 2, new Object[] { "getAIOStatusName: invoked. ", " suitableTrend: ", paramAppRuntime });
        }
        if (OnlineStatusUtil.c(paramFriends)) {
          return paramAppRuntime;
        }
        return "";
      }
      if (paramOnlineStatusItem.b == 1080L) {
        return paramOnlineStatusItem.c;
      }
      if (paramOnlineStatusItem.b > 40001L)
      {
        if (!TextUtils.isEmpty(paramOnlineStatusItem.c))
        {
          long l = paramFriends.autoStatusUpdateSecond;
          paramStatus = OnlineStatusUtil.a(NetConnInfoCenter.getServerTime(), l);
          QLog.d("OnLineStatusHelper", 1, new Object[] { "getAIOStatusName: invoked. [status-time] ", " passTimeStr: ", paramStatus, " autoStatusUpdateSecond: ", Long.valueOf(l), " extOnlineStatus.title: ", paramOnlineStatusItem.c, " friend.uin: ", paramFriends.uin, " during second: ", Long.valueOf(NetConnInfoCenter.getServerTime() - l) });
          if ((!TextUtils.isEmpty(paramStatus)) && (!paramAppRuntime.getCurrentAccountUin().equals(paramFriends.uin)))
          {
            paramAppRuntime = new StringBuilder();
            paramAppRuntime.append(paramOnlineStatusItem.c);
            paramAppRuntime.append(String.format("(%s)", new Object[] { paramStatus }));
            return paramAppRuntime.toString();
          }
          return paramOnlineStatusItem.c;
        }
        return "";
      }
      if (paramOnlineStatusItem.b == 40001L)
      {
        if (paramOnlineStatusItem.i == null) {
          return "";
        }
        return paramOnlineStatusItem.i;
      }
      if ((c(paramStatus, paramOnlineStatusItem.b)) && (!TextUtils.isEmpty(paramOnlineStatusItem.c)) && (paramTextView != null) && (paramOnlineStatusItem.b != 1055L))
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append(paramTextView.getResources().getString(2131916780));
        paramAppRuntime.append(paramOnlineStatusItem.c);
        return paramAppRuntime.toString();
      }
      if (!TextUtils.isEmpty(paramOnlineStatusItem.c)) {
        return paramOnlineStatusItem.c;
      }
    }
    return OnlineStatusConstants.a(paramStatus);
  }
  
  ArrayList<OnlineStatusItem> b()
  {
    OnlineStatusBean localOnlineStatusBean = (OnlineStatusBean)QConfigManager.b().b(578);
    if (localOnlineStatusBean != null) {
      return localOnlineStatusBean.b();
    }
    return null;
  }
  
  public ArrayList<OnlineStatusItem> b(AppRuntime.Status paramStatus, long paramLong)
  {
    OnlineStatusBean localOnlineStatusBean = (OnlineStatusBean)QConfigManager.b().b(578);
    if (localOnlineStatusBean != null) {
      return localOnlineStatusBean.a(paramStatus, paramLong);
    }
    return null;
  }
  
  public AppRuntime.Status b(OnlineStatusItem paramOnlineStatusItem)
  {
    if (paramOnlineStatusItem != null) {
      return paramOnlineStatusItem.g;
    }
    return null;
  }
  
  public int c(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = (IOnlineStatusService)paramAppRuntime.getRuntimeService(IOnlineStatusService.class, "");
    AppRuntime.Status localStatus = paramAppRuntime.getOnlineStatus();
    long l = paramAppRuntime.getExtOnlineStatus();
    if ((localStatus == AppRuntime.Status.online) && (l == 1000L)) {
      return 1;
    }
    if ((localStatus == AppRuntime.Status.online) && (l == 1030L)) {
      return 4;
    }
    if ((localStatus == AppRuntime.Status.online) && (l == 1040L)) {
      return 3;
    }
    return 0;
  }
  
  public ArrayList<OnlineStatusItem> c()
  {
    OnlineStatusBean localOnlineStatusBean = (OnlineStatusBean)QConfigManager.b().b(578);
    if (localOnlineStatusBean != null) {
      return localOnlineStatusBean.a();
    }
    return null;
  }
  
  public boolean d()
  {
    OlympicMedalEventInfo localOlympicMedalEventInfo = this.c;
    return (localOlympicMedalEventInfo != null) && (localOlympicMedalEventInfo.d() > System.currentTimeMillis() / 1000L);
  }
  
  public String e()
  {
    OlympicMedalEventInfo localOlympicMedalEventInfo = this.c;
    if (localOlympicMedalEventInfo == null) {
      return "";
    }
    return localOlympicMedalEventInfo.f();
  }
  
  public OnlineStatusItem f()
  {
    Iterator localIterator = c().iterator();
    while (localIterator.hasNext())
    {
      OnlineStatusItem localOnlineStatusItem = (OnlineStatusItem)localIterator.next();
      if (localOnlineStatusItem.b == 1080L) {
        return localOnlineStatusItem;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnLineStatusHelper
 * JD-Core Version:    0.7.0.1
 */