package com.tencent.mobileqq.onlinestatus;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineAutoStatusBean;
import com.tencent.mobileqq.config.business.OnlineStatusBean;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusElement;
import com.tencent.mobileqq.onlinestatus.config.WeatherUrl;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationLauncher;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationUtilKt;
import com.tencent.mobileqq.onlinestatus.music.OnlineMusicStatusManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.OnlineBatteryProducer;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import tencent.im.onlinestatus.OnlineStatusExtInfo.WeatherBizInfo;

public class OnLineStatusHelper
{
  private int jdField_a_of_type_Int = 0;
  private OnlineBatteryProducer jdField_a_of_type_ComTencentWidgetOnlineBatteryProducer = new OnlineBatteryProducer();
  
  public static int a()
  {
    int j;
    if (Build.VERSION.SDK_INT >= 21)
    {
      j = ((BatteryManager)BaseApplication.getContext().getSystemService("batterymanager")).getIntProperty(4);
      i = j;
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusHelper", 2, new Object[] { "BatterManager ", Integer.valueOf(j) });
      }
    }
    for (int i = j;; i = 0)
    {
      j = i;
      if (i <= 0) {
        j = SharedPreUtils.H(BaseApplicationImpl.sApplication.getApplicationContext());
      }
      return j;
    }
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 0) {}
    for (paramInt = 12;; paramInt = 24) {
      return AIOUtils.a(paramInt, BaseApplicationImpl.getContext().getResources());
    }
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1) {}
    for (int i = paramInt1 | 0x80;; i = paramInt1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusHelper", 2, new Object[] { "OnlineStatusHelper ret:", Integer.valueOf(i), " batteryCapacity:", Integer.valueOf(paramInt1), " powerConectStatus:", Integer.valueOf(paramInt2) });
      }
      return i;
    }
  }
  
  private Drawable a(OnlineStatusItem paramOnlineStatusItem, @Nullable Friends paramFriends, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    int i = a(paramInt1);
    Object localObject1 = localObject2;
    if (paramOnlineStatusItem != null)
    {
      if (paramOnlineStatusItem.jdField_a_of_type_Int != 2) {
        break label55;
      }
      paramOnlineStatusItem = paramOnlineStatusItem.jdField_a_of_type_MqqAppAppRuntime$Status;
      if (paramInt2 != 1) {
        break label49;
      }
      paramInt1 = 0;
      localObject1 = OnlineStatusConstants.a(paramOnlineStatusItem, paramInt1);
    }
    label49:
    label55:
    do
    {
      return localObject1;
      paramInt1 = i;
      break;
      if (!a(paramOnlineStatusItem)) {
        break label127;
      }
      if (a(paramFriends) > 0) {
        return this.jdField_a_of_type_ComTencentWidgetOnlineBatteryProducer.a(a(paramFriends), paramInt1);
      }
      if (paramFriends == null) {
        break label104;
      }
      localObject1 = localObject2;
    } while (!a(paramFriends.uin));
    label104:
    paramOnlineStatusItem = URLDrawable.getDrawable(paramOnlineStatusItem.c, URLDrawable.URLDrawableOptions.obtain());
    paramOnlineStatusItem.setBounds(0, 0, i, i);
    return paramOnlineStatusItem;
    label127:
    if (paramOnlineStatusItem.jdField_a_of_type_Long == 1030L)
    {
      localObject1 = (OnlineAutoStatusBean)QConfigManager.a().a(652);
      if ((localObject1 == null) || (paramFriends == null)) {
        break label326;
      }
      localObject1 = ((OnlineAutoStatusBean)localObject1).a(paramFriends.weatherTypeId);
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusHelper", 4, new Object[] { "weatherTypeId=", paramFriends.weatherTypeId });
      }
      if (localObject1 == null) {
        break label326;
      }
    }
    label326:
    for (paramFriends = ((WeatherUrl)localObject1).d;; paramFriends = "")
    {
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
        return paramOnlineStatusItem;
      }
      paramOnlineStatusItem = URLDrawable.getDrawable(paramOnlineStatusItem.c, (URLDrawable.URLDrawableOptions)localObject1);
      paramOnlineStatusItem.setBounds(0, 0, i, i);
      return paramOnlineStatusItem;
      paramOnlineStatusItem = URLDrawable.getDrawable(paramOnlineStatusItem.c, URLDrawable.URLDrawableOptions.obtain());
      paramOnlineStatusItem.setBounds(0, 0, i, i);
      return paramOnlineStatusItem;
    }
  }
  
  public static OnLineStatusHelper a()
  {
    return OnLineStatusHelper.OnLineStatusHelperHolder.a();
  }
  
  private String a(Friends paramFriends)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramFriends != null) && (a(paramFriends.uin))) {
      localObject1 = CustomOnlineStatusManager.a().a();
    }
    while ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains("在线")))
    {
      paramFriends = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);
      if (TextUtils.isEmpty(paramFriends)) {
        break;
      }
      return paramFriends;
      localObject1 = localObject2;
      if (paramFriends != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramFriends.strTermDesc)) {
          localObject1 = paramFriends.strTermDesc;
        }
      }
    }
    return "手机";
  }
  
  public static boolean a(AppRuntime.Status paramStatus, long paramLong)
  {
    OnlineStatusBean localOnlineStatusBean = (OnlineStatusBean)QConfigManager.a().a(578);
    if (localOnlineStatusBean == null) {
      return false;
    }
    return localOnlineStatusBean.a(paramStatus, paramLong);
  }
  
  public static int b()
  {
    int i = SharedPreUtils.I(BaseApplicationImpl.sApplication.getApplicationContext());
    int j = i;
    BatteryManager localBatteryManager;
    if (i == -1)
    {
      j = i;
      if (Build.VERSION.SDK_INT >= 21)
      {
        localBatteryManager = (BatteryManager)BaseApplication.getContext().getSystemService("batterymanager");
        if (Build.VERSION.SDK_INT < 23) {
          break label129;
        }
      }
    }
    label129:
    for (boolean bool = localBatteryManager.isCharging();; bool = false)
    {
      int k = localBatteryManager.getIntProperty(6);
      if ((k == 2) || (k == 5) || (bool)) {}
      for (i = 1;; i = 0)
      {
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.d("OnLineStatusHelper", 2, new Object[] { "BatterManager isCharging:", Boolean.valueOf(bool), " chargeStatus:", Integer.valueOf(k) });
          j = i;
        }
        return j;
      }
    }
  }
  
  /* Error */
  public static int c()
  {
    // Byte code:
    //   0: getstatic 27	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 21
    //   5: if_icmplt +121 -> 126
    //   8: invokestatic 33	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: ldc 35
    //   13: invokevirtual 39	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   16: checkcast 41	android/os/BatteryManager
    //   19: astore_3
    //   20: getstatic 27	android/os/Build$VERSION:SDK_INT	I
    //   23: bipush 23
    //   25: if_icmplt +96 -> 121
    //   28: aload_3
    //   29: invokevirtual 240	android/os/BatteryManager:isCharging	()Z
    //   32: istore_2
    //   33: aload_3
    //   34: bipush 6
    //   36: invokevirtual 45	android/os/BatteryManager:getIntProperty	(I)I
    //   39: istore_1
    //   40: iload_1
    //   41: iconst_2
    //   42: if_icmpeq +12 -> 54
    //   45: iload_1
    //   46: iconst_5
    //   47: if_icmpeq +7 -> 54
    //   50: iload_2
    //   51: ifeq +47 -> 98
    //   54: iconst_1
    //   55: istore_0
    //   56: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +37 -> 96
    //   62: ldc 53
    //   64: iconst_2
    //   65: iconst_4
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: ldc 253
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: iload_2
    //   77: invokestatic 247	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   80: aastore
    //   81: dup
    //   82: iconst_2
    //   83: ldc 249
    //   85: aastore
    //   86: dup
    //   87: iconst_3
    //   88: iload_1
    //   89: invokestatic 61	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   92: aastore
    //   93: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   96: iload_0
    //   97: ireturn
    //   98: iconst_0
    //   99: istore_0
    //   100: goto -44 -> 56
    //   103: astore_3
    //   104: iconst_0
    //   105: istore_0
    //   106: ldc 53
    //   108: iconst_1
    //   109: ldc 255
    //   111: aload_3
    //   112: invokestatic 259	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   115: iload_0
    //   116: ireturn
    //   117: astore_3
    //   118: goto -12 -> 106
    //   121: iconst_0
    //   122: istore_2
    //   123: goto -90 -> 33
    //   126: iconst_0
    //   127: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   55	61	0	i	int
    //   39	50	1	j	int
    //   32	91	2	bool	boolean
    //   19	15	3	localBatteryManager	BatteryManager
    //   103	9	3	localThrowable1	java.lang.Throwable
    //   117	1	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	33	103	java/lang/Throwable
    //   33	40	103	java/lang/Throwable
    //   56	96	117	java/lang/Throwable
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    AppRuntime.Status localStatus = paramQQAppInterface.getOnlineStatus();
    long l = paramQQAppInterface.getExtOnlineStatus();
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
  
  public int a(Friends paramFriends)
  {
    if ((paramFriends == null) || (a(paramFriends.uin))) {
      return a();
    }
    return Math.max(0, Math.min(paramFriends.getBatteryCapacity(), 100));
  }
  
  public long a(QQAppInterface paramQQAppInterface)
  {
    long l2 = paramQQAppInterface.getExtOnlineStatus();
    long l1 = l2;
    if (l2 == -1L)
    {
      l2 = BaseApplicationImpl.getContext().getSharedPreferences("acc_info" + paramQQAppInterface.getCurrentAccountUin(), 0).getLong("getOnlineStatusExt", -1L);
      l1 = l2;
      if (l2 != -1L)
      {
        paramQQAppInterface.setExtOnlineStatus(l2);
        l1 = l2;
      }
    }
    return l1;
  }
  
  public Drawable a(long paramLong, AppRuntime.Status paramStatus, int paramInt, Friends paramFriends)
  {
    if (paramStatus == AppRuntime.Status.online)
    {
      OnlineStatusItem localOnlineStatusItem = a(AppRuntime.Status.online, paramLong);
      if (localOnlineStatusItem != null) {
        return a(localOnlineStatusItem, paramFriends, paramInt, 3);
      }
    }
    return OnlineStatusConstants.a(paramStatus, a(paramInt));
  }
  
  public Drawable a(OnlineStatusItem paramOnlineStatusItem, Friends paramFriends)
  {
    return a(paramOnlineStatusItem, paramFriends, 0, 1);
  }
  
  public Bundle a(QQAppInterface paramQQAppInterface)
  {
    Bundle localBundle = new Bundle();
    int i = paramQQAppInterface.getBatteryCapacity();
    int j = paramQQAppInterface.getPowerConnect();
    int k = a(i, j);
    localBundle.putInt("BatteryInfo", k);
    if (QLog.isColorLevel()) {
      QLog.d("OnLineStatusHelper", 2, new Object[] { "OnlineStatusHelper batteryCapacity:", Integer.valueOf(i), " powerConnect:", Integer.valueOf(j), " sendBattery:", Integer.valueOf(k) });
    }
    return localBundle;
  }
  
  public Bundle a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    int i = paramQQAppInterface.getBatteryCapacity();
    int j = paramQQAppInterface.getPowerConnect();
    int k = a(i, j);
    localBundle.putInt("BatteryInfo", k);
    localBundle.putBoolean("from_register", paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("OnLineStatusHelper", 2, new Object[] { "buildSetBatteryData batteryCapacity:", Integer.valueOf(i), " powerConnect:", Integer.valueOf(j), " sendBattery:", Integer.valueOf(k), " fromRegister:", Boolean.valueOf(paramBoolean) });
    }
    return localBundle;
  }
  
  public Bundle a(Friends paramFriends)
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
    try
    {
      i = Integer.valueOf(paramFriends.adCode).intValue();
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
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OnLineStatusHelper", 4, "number error", localNumberFormatException);
        }
        int i = 0;
      }
    }
  }
  
  public OnlineStatusItem a(AppRuntime.Status paramStatus, long paramLong)
  {
    return a(paramStatus, paramLong, false);
  }
  
  public OnlineStatusItem a(AppRuntime.Status paramStatus, long paramLong, boolean paramBoolean)
  {
    if (paramStatus == null)
    {
      localObject = Integer.valueOf(-1);
      QLog.d("OnLineStatusHelper", 1, new Object[] { "getOnlineStatusItem status=", localObject, " onlineStatusIDValue=", Long.valueOf(paramLong) });
      if ((paramStatus != AppRuntime.Status.online) || (paramLong <= 40000L)) {
        break label130;
      }
      localObject = (OnlineAutoStatusBean)QConfigManager.a().a(652);
      if (localObject == null) {
        break label130;
      }
      if (!paramBoolean) {
        break label119;
      }
    }
    label119:
    for (paramStatus = ((OnlineAutoStatusBean)localObject).b(paramStatus, paramLong);; paramStatus = ((OnlineAutoStatusBean)localObject).a(paramStatus, paramLong))
    {
      localObject = paramStatus;
      if (paramStatus == null) {
        localObject = new OnlineStatusItem(AppRuntime.Status.online);
      }
      return localObject;
      localObject = paramStatus;
      break;
    }
    label130:
    Object localObject = (OnlineStatusBean)QConfigManager.a().a(578);
    if ((localObject != null) && (paramStatus == AppRuntime.Status.online)) {
      return ((OnlineStatusBean)localObject).a(paramStatus, paramLong);
    }
    if (localObject != null) {
      return ((OnlineStatusBean)localObject).a(paramStatus, 0L);
    }
    return new OnlineStatusItem(AppRuntime.Status.online);
  }
  
  public OnlineMusicStatusManager a()
  {
    return OnlineMusicStatusManager.a();
  }
  
  public String a(long paramLong, AppRuntime.Status paramStatus)
  {
    if (paramStatus == AppRuntime.Status.online)
    {
      if (paramLong == 1000L) {
        return "我的电量";
      }
      OnlineStatusItem localOnlineStatusItem = a(AppRuntime.Status.online, paramLong);
      if ((localOnlineStatusItem != null) && (!TextUtils.isEmpty(localOnlineStatusItem.b))) {
        return localOnlineStatusItem.b;
      }
    }
    return OnlineStatusConstants.a(paramStatus);
  }
  
  public String a(QQAppInterface paramQQAppInterface, Friends paramFriends, TextView paramTextView, int paramInt, OnlineStatusItem paramOnlineStatusItem, Boolean paramBoolean)
  {
    AppRuntime.Status localStatus = a().a(paramOnlineStatusItem);
    if (!Boolean.valueOf(a(paramOnlineStatusItem, paramFriends, paramBoolean.booleanValue())).booleanValue())
    {
      if (paramInt == 1) {}
      for (paramQQAppInterface = ContactUtils.b(paramFriends);; paramQQAppInterface = OnlineStatusUtil.b(paramFriends))
      {
        paramFriends = paramQQAppInterface;
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          paramFriends = BaseApplicationImpl.getContext().getResources().getString(2131719512);
        }
        return paramFriends;
      }
    }
    return a().b(paramQQAppInterface, paramOnlineStatusItem, localStatus, paramFriends, paramTextView, paramInt);
  }
  
  public String a(QQAppInterface paramQQAppInterface, OnlineStatusItem paramOnlineStatusItem, AppRuntime.Status paramStatus, Friends paramFriends, TextView paramTextView, int paramInt)
  {
    if (paramStatus == AppRuntime.Status.online)
    {
      if (paramOnlineStatusItem.jdField_a_of_type_Long > 0L) {}
      for (boolean bool = true;; bool = false) {
        return a(paramQQAppInterface, paramFriends, paramTextView, 4, paramOnlineStatusItem, Boolean.valueOf(bool));
      }
    }
    return b(paramQQAppInterface, paramOnlineStatusItem, paramStatus, paramFriends, paramTextView, paramInt);
  }
  
  ArrayList<OnlineStatusItem> a()
  {
    OnlineStatusBean localOnlineStatusBean = (OnlineStatusBean)QConfigManager.a().a(578);
    if (localOnlineStatusBean != null) {
      return localOnlineStatusBean.b();
    }
    return null;
  }
  
  ArrayList<OnlineStatusItem> a(AppRuntime.Status paramStatus, long paramLong)
  {
    OnlineStatusBean localOnlineStatusBean = (OnlineStatusBean)QConfigManager.a().a(578);
    if (localOnlineStatusBean != null) {
      return localOnlineStatusBean.a(paramStatus, paramLong);
    }
    return null;
  }
  
  public AppRuntime.Status a(OnlineStatusItem paramOnlineStatusItem)
  {
    if (paramOnlineStatusItem != null) {
      return paramOnlineStatusItem.jdField_a_of_type_MqqAppAppRuntime$Status;
    }
    return null;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Friends paramFriends, TextView paramTextView, boolean paramBoolean)
  {
    Drawable[] arrayOfDrawable = paramTextView.getCompoundDrawables();
    if (paramFriends == null)
    {
      paramTextView.setCompoundDrawablePadding(0);
      paramTextView.setCompoundDrawables(null, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return;
    }
    int i = ContactUtils.a(paramFriends.detalStatusFlag, paramFriends.iTermType);
    boolean bool1;
    if (!paramQQAppInterface.getCurrentUin().equals(paramFriends.uin))
    {
      bool1 = true;
      paramQQAppInterface = a(AppRuntime.Status.online, paramFriends.uExtOnlineStatus, bool1);
      boolean bool2 = false;
      bool1 = bool2;
      if (!paramBoolean) {
        break label303;
      }
      bool1 = bool2;
      if (i != 4) {
        break label303;
      }
      bool1 = bool2;
      if (paramFriends.uExtOnlineStatus <= 0L) {
        break label303;
      }
      bool1 = bool2;
      if (paramQQAppInterface == null) {
        break label303;
      }
      if (!a(paramQQAppInterface)) {
        break label213;
      }
      if (a(paramFriends) <= 0) {
        break label207;
      }
      paramBoolean = true;
      label139:
      bool1 = paramBoolean;
      if (!paramBoolean) {
        break label303;
      }
      paramQQAppInterface = a(paramQQAppInterface, paramFriends);
      if (paramQQAppInterface == null) {
        break label274;
      }
      paramBoolean = true;
    }
    for (;;)
    {
      if (paramBoolean)
      {
        paramTextView.setCompoundDrawablePadding(AIOUtils.a(4.0F, BaseApplicationImpl.getContext().getResources()));
        paramTextView.setCompoundDrawables(paramQQAppInterface, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
        return;
        bool1 = false;
        break;
        label207:
        paramBoolean = false;
        break label139;
        label213:
        if (paramFriends.uExtOnlineStatus == 40001L)
        {
          paramBoolean = OnlineStatusUtil.b(paramQQAppInterface);
          break label139;
        }
        if (paramFriends.uExtOnlineStatus == 1040L)
        {
          paramBoolean = OnlineStatusUtil.b(paramFriends);
          break label139;
        }
        if (!a(paramQQAppInterface, paramFriends))
        {
          paramBoolean = true;
          break label139;
        }
        paramBoolean = false;
        break label139;
        label274:
        paramBoolean = false;
        continue;
      }
      paramTextView.setCompoundDrawablePadding(0);
      paramTextView.setCompoundDrawables(null, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return;
      label303:
      paramBoolean = bool1;
      paramQQAppInterface = null;
    }
  }
  
  public void a(Friends paramFriends, TextView paramTextView, boolean paramBoolean, OnlineStatusItem paramOnlineStatusItem)
  {
    Drawable[] arrayOfDrawable = paramTextView.getCompoundDrawables();
    if (paramBoolean)
    {
      paramTextView.setCompoundDrawablePadding(0);
      paramTextView.setCompoundDrawables(null, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return;
    }
    if ((ContactUtils.a(paramFriends.detalStatusFlag, paramFriends.iTermType) == 4) && (paramFriends.uExtOnlineStatus > 0L) && (paramOnlineStatusItem != null)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label124;
      }
      paramFriends = a().a(paramOnlineStatusItem, paramFriends);
      if (paramFriends == null) {
        break;
      }
      paramTextView.setCompoundDrawablePadding(AIOUtils.a(4.0F, BaseApplicationImpl.getContext().getResources()));
      paramTextView.setCompoundDrawables(paramFriends, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return;
    }
    label124:
    paramTextView.setCompoundDrawablePadding(0);
    paramTextView.setCompoundDrawables(null, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, View paramView)
  {
    if (a(paramQQAppInterface, paramSessionInfo.a))
    {
      paramView = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramSessionInfo.a);
      boolean bool;
      if (!paramQQAppInterface.getCurrentUin().equals(paramSessionInfo.a))
      {
        bool = true;
        paramQQAppInterface = a(AppRuntime.Status.online, paramView.uExtOnlineStatus, bool);
        if (paramQQAppInterface.jdField_a_of_type_Long != 1028L) {
          break label111;
        }
        if ((paramView != null) && (!TextUtils.isEmpty(paramView.songId))) {
          a().a(paramActivity, paramView.songId);
        }
      }
      label111:
      do
      {
        do
        {
          return true;
          bool = false;
          break;
          if (paramQQAppInterface.jdField_a_of_type_Long != 1030L) {
            break label208;
          }
          paramQQAppInterface = (OnlineAutoStatusBean)QConfigManager.a().a(652);
        } while ((paramQQAppInterface == null) || (paramQQAppInterface.a == null) || (TextUtils.isEmpty(paramQQAppInterface.a.a)));
        paramQQAppInterface = paramQQAppInterface.a.a + paramView.adCode;
        ConstellationLauncher.a.a(paramActivity, paramQQAppInterface, 4014);
        ReportHelperKt.a("0X800AF4C", 2);
        return true;
      } while (paramQQAppInterface.jdField_a_of_type_Long != 1040L);
      label208:
      ConstellationLauncher.a.a(paramActivity, paramView.constellationJumpUrl, 4014);
      ReportHelperKt.a("0X800AF4C", 1);
      return true;
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Friends localFriends = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
    boolean bool;
    if (!paramQQAppInterface.getCurrentUin().equals(paramString)) {
      bool = true;
    }
    while (localFriends != null)
    {
      paramQQAppInterface = a(AppRuntime.Status.online, localFriends.uExtOnlineStatus, bool);
      if (paramQQAppInterface.jdField_a_of_type_Long == 1028L)
      {
        return true;
        bool = false;
      }
      else
      {
        if (paramQQAppInterface.jdField_a_of_type_Long == 1030L) {
          return OnlineStatusUtil.a(localFriends);
        }
        if (paramQQAppInterface.jdField_a_of_type_Long == 1040L) {
          return OnlineStatusUtil.b(localFriends);
        }
      }
    }
    return false;
  }
  
  boolean a(OnlineStatusItem paramOnlineStatusItem)
  {
    return (paramOnlineStatusItem != null) && (paramOnlineStatusItem.jdField_a_of_type_Long == 1000L);
  }
  
  boolean a(OnlineStatusItem paramOnlineStatusItem, Friends paramFriends)
  {
    return (paramOnlineStatusItem.jdField_a_of_type_Long == 1030L) && (!OnlineStatusUtil.a(paramFriends));
  }
  
  public boolean a(OnlineStatusItem paramOnlineStatusItem, Friends paramFriends, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramBoolean)
    {
      bool = paramBoolean;
      if (OnlineStatusItem.a(paramOnlineStatusItem.jdField_a_of_type_Long)) {
        if (a().a(paramFriends) <= 0) {
          break label116;
        }
      }
    }
    label116:
    for (paramBoolean = true;; paramBoolean = false)
    {
      bool = paramBoolean;
      paramBoolean = bool;
      if (paramOnlineStatusItem.jdField_a_of_type_Long == 1030L)
      {
        paramBoolean = bool;
        if (!OnlineStatusUtil.a(paramFriends)) {
          paramBoolean = false;
        }
      }
      bool = paramBoolean;
      if (paramOnlineStatusItem.jdField_a_of_type_Long == 1040L)
      {
        bool = paramBoolean;
        if (!OnlineStatusUtil.b(paramFriends)) {
          bool = false;
        }
      }
      paramBoolean = bool;
      if (paramOnlineStatusItem.jdField_a_of_type_Long == 40001L)
      {
        paramBoolean = bool;
        if (!OnlineStatusUtil.b(paramOnlineStatusItem)) {
          paramBoolean = false;
        }
      }
      return paramBoolean;
    }
  }
  
  protected boolean a(String paramString)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface)) {
      return false;
    }
    return ((QQAppInterface)localAppRuntime).getCurrentUin().equals(paramString);
  }
  
  public String b(long paramLong, AppRuntime.Status paramStatus)
  {
    OnlineStatusItem localOnlineStatusItem = a(AppRuntime.Status.online, paramLong);
    if (OnlineStatusUtil.b(localOnlineStatusItem)) {
      return localOnlineStatusItem.d;
    }
    return a(paramLong, paramStatus);
  }
  
  public String b(QQAppInterface paramQQAppInterface, OnlineStatusItem paramOnlineStatusItem, AppRuntime.Status paramStatus, Friends paramFriends, TextView paramTextView, int paramInt)
  {
    if ((paramStatus == AppRuntime.Status.online) && (paramOnlineStatusItem != null))
    {
      if ((paramOnlineStatusItem.jdField_a_of_type_Long == 1000L) && (paramFriends != null)) {
        if (paramQQAppInterface.getCurrentAccountUin().equals(paramFriends.uin)) {
          if (paramQQAppInterface.getPowerConnect() == 1) {
            paramQQAppInterface = paramQQAppInterface.getBatteryCapacity() + "% " + a(paramFriends) + "充电中";
          }
        }
      }
      do
      {
        return paramQQAppInterface;
        return paramQQAppInterface.getBatteryCapacity() + "% " + a(paramFriends) + "电量";
        if (a(paramFriends) > 0)
        {
          if (paramFriends.isBatteryCharging()) {
            return a(paramFriends) + "% " + a(paramFriends) + "充电中";
          }
          return a(paramFriends) + "% " + a(paramFriends) + "电量";
        }
        return ContactUtils.b(paramFriends);
        if ((paramOnlineStatusItem.jdField_a_of_type_Long == 1028L) && (paramFriends != null)) {
          return OnlineMusicStatusManager.a(paramQQAppInterface, paramFriends, paramTextView);
        }
        if ((paramOnlineStatusItem.jdField_a_of_type_Long == 1030L) && (paramFriends != null)) {
          return OnlineStatusUtil.a(paramQQAppInterface, paramTextView, paramFriends, paramInt);
        }
        if ((paramOnlineStatusItem.jdField_a_of_type_Long != 1040L) || (paramFriends == null)) {
          break;
        }
        paramQQAppInterface = ConstellationUtilKt.b(paramFriends);
        if (QLog.isColorLevel()) {
          QLog.d("OnLineStatusHelper", 2, new Object[] { "getAIOStatusName: invoked. ", " suitableTrend: ", paramQQAppInterface });
        }
      } while (OnlineStatusUtil.b(paramFriends));
      return "";
      if (paramOnlineStatusItem.jdField_a_of_type_Long > 40001L)
      {
        if (!TextUtils.isEmpty(paramOnlineStatusItem.b))
        {
          long l = paramFriends.autoStatusUpdateSecond;
          paramStatus = OnlineStatusUtil.a(NetConnInfoCenter.getServerTime(), l);
          QLog.d("OnLineStatusHelper", 1, new Object[] { "getAIOStatusName: invoked. [status-time] ", " passTimeStr: ", paramStatus, " autoStatusUpdateSecond: ", Long.valueOf(l), " extOnlineStatus.title: ", paramOnlineStatusItem.b, " friend.uin: ", paramFriends.uin, " during second: ", Long.valueOf(NetConnInfoCenter.getServerTime() - l) });
          if ((TextUtils.isEmpty(paramStatus)) || (paramQQAppInterface.getCurrentAccountUin().equals(paramFriends.uin))) {
            return paramOnlineStatusItem.b;
          }
          return paramOnlineStatusItem.b + String.format("(%s)", new Object[] { paramStatus });
        }
        return "";
      }
      if (paramOnlineStatusItem.jdField_a_of_type_Long == 40001L)
      {
        if (paramOnlineStatusItem.d == null) {
          return "";
        }
        return paramOnlineStatusItem.d;
      }
      if ((a(paramStatus, paramOnlineStatusItem.jdField_a_of_type_Long)) && (!TextUtils.isEmpty(paramOnlineStatusItem.b)) && (paramTextView != null) && (paramOnlineStatusItem.jdField_a_of_type_Long != 1055L)) {
        return paramTextView.getResources().getString(2131719510) + paramOnlineStatusItem.b;
      }
      if (!TextUtils.isEmpty(paramOnlineStatusItem.b)) {
        return paramOnlineStatusItem.b;
      }
    }
    return OnlineStatusConstants.a(paramStatus);
  }
  
  ArrayList<OnlineStatusItem> b()
  {
    OnlineStatusBean localOnlineStatusBean = (OnlineStatusBean)QConfigManager.a().a(578);
    if (localOnlineStatusBean != null) {
      return localOnlineStatusBean.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnLineStatusHelper
 * JD-Core Version:    0.7.0.1
 */