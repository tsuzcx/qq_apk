package com.tencent.mobileqq.onlinestatus;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.friend.FriendsUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.comment.DanmuUtil;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineAutoStatusBean;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusElement;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationUtilKt;
import com.tencent.mobileqq.onlinestatus.view.AutoStatusSelectView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.im.onlinestatus.OnlineStatusExtInfo.AutoStateBizInfo;
import tencent.im.onlinestatus.OnlineStatusExtInfo.WeatherBizInfo;
import tencent.im.onlinestatus.OnlineStatusExtInfo.ZodiacBizInfo;

public class OnlineStatusUtil
{
  public static String a(long paramLong1, long paramLong2)
  {
    paramLong1 -= paramLong2;
    if (paramLong1 <= 600L) {
      return "";
    }
    if (paramLong1 < 3600L)
    {
      paramLong1 /= 60L;
      return paramLong1 + "分钟前";
    }
    if (paramLong1 < 86400L)
    {
      paramLong1 /= 3600L;
      return paramLong1 + "小时前";
    }
    if (paramLong1 < 2592000L)
    {
      paramLong1 /= 86400L;
      return paramLong1 + "天前";
    }
    if (paramLong1 < 31104000L)
    {
      paramLong1 /= 2592000L;
      return paramLong1 + "月前";
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, TextView paramTextView, @NonNull Friends paramFriends, int paramInt)
  {
    if (!a(paramFriends)) {
      return "";
    }
    paramFriends = a(paramQQAppInterface, paramFriends, false);
    paramQQAppInterface = paramFriends;
    if (paramInt == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusUtil", 2, "getWeatherDisplayInfo fromContacts");
      }
      paramQQAppInterface = DanmuUtil.a(paramTextView.getPaint(), paramFriends, ViewUtils.a(200.0F));
    }
    return paramQQAppInterface + "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, @NonNull Friends paramFriends, boolean paramBoolean)
  {
    Object localObject = "";
    if (!a(paramFriends)) {
      return localObject;
    }
    localObject = new StringBuilder();
    if (TextUtils.isEmpty(paramFriends.city))
    {
      paramQQAppInterface = "";
      label33:
      localObject = ((StringBuilder)localObject).append(paramQQAppInterface);
      if (!TextUtils.isEmpty(paramFriends.area)) {
        break label156;
      }
      paramQQAppInterface = "";
      label52:
      localObject = paramQQAppInterface;
      if (!TextUtils.isEmpty(paramFriends.weatherType)) {
        break label164;
      }
      paramQQAppInterface = "";
      label74:
      StringBuilder localStringBuilder = new StringBuilder().append(paramQQAppInterface);
      if (!TextUtils.isEmpty(paramFriends.temper)) {
        break label172;
      }
      paramQQAppInterface = "";
      label100:
      paramQQAppInterface = paramQQAppInterface;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label198;
      }
    }
    label156:
    label164:
    label172:
    label198:
    for (paramQQAppInterface = "";; paramQQAppInterface = (String)localObject + " | " + paramQQAppInterface)
    {
      localObject = paramQQAppInterface;
      if (!paramBoolean) {
        break;
      }
      return paramQQAppInterface + a(paramFriends);
      paramQQAppInterface = paramFriends.city;
      break label33;
      paramQQAppInterface = paramFriends.area;
      break label52;
      paramQQAppInterface = paramFriends.weatherType;
      break label74;
      paramQQAppInterface = paramFriends.temper + "°";
      break label100;
    }
  }
  
  public static final String a(Friends paramFriends)
  {
    Object localObject = "";
    if (paramFriends.weatherUpdateTime > 0L)
    {
      paramFriends = a(NetConnInfoCenter.getServerTime(), paramFriends.weatherUpdateTime);
      localObject = paramFriends;
      if (QLog.isColorLevel())
      {
        QLog.d("OnlineStatusUtil", 2, new Object[] { "getWeatherDisplayInfo passTimeTip=", paramFriends });
        localObject = paramFriends;
      }
    }
    return localObject;
  }
  
  private static void a(Friends paramFriends)
  {
    if (paramFriends.uExtOnlineStatus == 1030L)
    {
      paramFriends.weatherFlag = 1;
      paramFriends.weatherUpdateTime = 0L;
      paramFriends.adCode = null;
      paramFriends.weatherTip = null;
      paramFriends.area = null;
      paramFriends.city = null;
      paramFriends.temper = null;
      paramFriends.weatherType = null;
      paramFriends.weatherTypeId = null;
    }
    do
    {
      do
      {
        return;
        if (paramFriends.uExtOnlineStatus != 1040L) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("OnlineStatusUtil", 2, new Object[] { "resetExtOnlineBusinessInfo: invoked. [constellation] 切换帐号场景，后台会清空ext info，需要在上线时拉取并上报 reset all trend info ", " friend: ", paramFriends.uin });
      return;
    } while ((paramFriends.uExtOnlineStatus <= 40000L) || (!QLog.isColorLevel()));
    QLog.d("OnlineStatusUtil", 2, new Object[] { "resetExtOnlineBusinessInfo: invoked. [status-time] no need reset update time(不需要重置，上报新的id会上报正确的操作时间). ", " friend: ", paramFriends.uin });
  }
  
  private static void a(Friends paramFriends1, byte[] paramArrayOfByte, @Nullable Friends paramFriends2)
  {
    if (paramFriends1.uExtOnlineStatus == 1040L) {}
    for (;;)
    {
      try
      {
        paramFriends2 = new OnlineStatusExtInfo.ZodiacBizInfo();
        paramFriends2.mergeFrom(paramArrayOfByte);
        paramFriends1.constellationTodayTrend = paramFriends2.string_today_trend.get();
        paramFriends1.constellationTomorrowTrend = paramFriends2.string_tomorrow_trend.get();
        paramFriends1.constellationDateStr = paramFriends2.string_today_date.get();
        paramFriends1.constellationJumpUrl = paramFriends2.string_miniapp.get();
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusUtil", 2, new Object[] { "parseExtOnlineBusinessInfo: invoked. ", ConstellationUtilKt.a(paramFriends1) });
        }
        return;
      }
      catch (Exception paramFriends1)
      {
        QLog.e("OnlineStatusUtil", 1, "parseExtOnlineBusinessInfo fail", paramFriends1);
        return;
      }
      if (paramFriends1.uExtOnlineStatus == 1030L)
      {
        OnlineStatusExtInfo.WeatherBizInfo localWeatherBizInfo;
        long l2;
        for (;;)
        {
          try
          {
            localWeatherBizInfo = new OnlineStatusExtInfo.WeatherBizInfo();
            localWeatherBizInfo.mergeFrom(paramArrayOfByte);
            l2 = localWeatherBizInfo.uint64_update_time.get();
            if (QLog.isColorLevel())
            {
              if (paramFriends2 == null)
              {
                l1 = paramFriends1.weatherUpdateTime;
                QLog.d("OnlineStatusUtil", 2, new Object[] { "parseExtOnlineBusinessInfo: invoked. server time", Long.valueOf(l2), " local time: ", Long.valueOf(l1) });
              }
            }
            else
            {
              if ((paramFriends2 == null) || (paramFriends2.weatherUpdateTime <= l2)) {
                break;
              }
              paramFriends1.weatherTypeId = paramFriends2.weatherTypeId;
              paramFriends1.weatherType = paramFriends2.weatherType;
              paramFriends1.temper = paramFriends2.temper;
              paramFriends1.city = paramFriends2.city;
              paramFriends1.area = paramFriends2.area;
              paramFriends1.adCode = paramFriends2.adCode;
              paramFriends1.weatherFlag = paramFriends2.weatherFlag;
              paramFriends1.weatherUpdateTime = paramFriends2.weatherUpdateTime;
              return;
            }
          }
          catch (Exception paramFriends1)
          {
            QLog.e("OnlineStatusUtil", 1, "parseExtOnlineBusinessInfo fail", paramFriends1);
            return;
          }
          long l1 = paramFriends2.weatherUpdateTime;
        }
        if (l2 > paramFriends1.weatherUpdateTime)
        {
          paramFriends1.weatherTypeId = localWeatherBizInfo.string_weather_type_id.get();
          paramFriends1.weatherType = localWeatherBizInfo.string_weather_type.get();
          paramFriends1.temper = localWeatherBizInfo.string_temper.get();
          paramFriends1.city = localWeatherBizInfo.string_city.get();
          paramFriends1.area = localWeatherBizInfo.string_area.get();
          paramFriends1.adCode = (localWeatherBizInfo.uint32_adcode.get() + "");
          paramFriends1.weatherFlag = localWeatherBizInfo.uint32_flag.get();
          paramFriends1.weatherUpdateTime = l2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusUtil", 2, new Object[] { "parseExtOnlineBusinessInfo: invoked. ", " friend.weatherFlag: ", Integer.valueOf(paramFriends1.weatherFlag) });
        }
      }
      else if (paramFriends1.uExtOnlineStatus > 40000L)
      {
        paramFriends2 = new OnlineStatusExtInfo.AutoStateBizInfo();
        try
        {
          paramFriends2.mergeFrom(paramArrayOfByte);
          paramFriends1.autoStatusUpdateSecond = paramFriends2.uint64_update_time.get();
          if (QLog.isColorLevel())
          {
            QLog.d("OnlineStatusUtil", 2, new Object[] { "parseExtOnlineBusinessInfo: invoked. [status-time]", " friend.autoStatusUpdateSecond: ", Long.valueOf(paramFriends1.autoStatusUpdateSecond), " friend: ", paramFriends1.uin });
            return;
          }
        }
        catch (Exception paramFriends1)
        {
          QLog.e("OnlineStatusUtil", 1, "parseExtOnlineBusinessInfo: failed. ", paramFriends1);
        }
      }
    }
  }
  
  public static void a(Friends paramFriends, byte[] paramArrayOfByte, String paramString)
  {
    a(paramFriends, paramArrayOfByte, paramString, null);
  }
  
  public static void a(Friends paramFriends1, byte[] paramArrayOfByte, String paramString, @Nullable Friends paramFriends2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusUtil", 2, new Object[] { "parseExtOnlineBusinessInfo from ", paramString, ", uin:", paramFriends1.uin, " type:", Long.valueOf(paramFriends1.uExtOnlineStatus) });
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      a(paramFriends1, paramArrayOfByte, paramFriends2);
      return;
    }
    a(paramFriends1);
  }
  
  public static void a(AutoStatusSelectView paramAutoStatusSelectView, View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof Integer))
    {
      int i = ((Integer)paramView).intValue();
      if (i == 2)
      {
        paramAutoStatusSelectView = paramAutoStatusSelectView.a().iterator();
        while (paramAutoStatusSelectView.hasNext()) {
          ReportHelperKt.a("0X800AF40", ((Integer)paramAutoStatusSelectView.next()).intValue(), "2");
        }
      }
      if (i == 1)
      {
        paramAutoStatusSelectView = paramAutoStatusSelectView.a().iterator();
        while (paramAutoStatusSelectView.hasNext()) {
          ReportHelperKt.a("0X800B00F", ((Integer)paramAutoStatusSelectView.next()).intValue(), "2");
        }
      }
    }
  }
  
  public static boolean a()
  {
    OnlineAutoStatusBean localOnlineAutoStatusBean = (OnlineAutoStatusBean)QConfigManager.a().a(652);
    return (localOnlineAutoStatusBean != null) && (localOnlineAutoStatusBean.a != null) && (a(localOnlineAutoStatusBean.a.a));
  }
  
  public static boolean a(int paramInt, Resources paramResources)
  {
    boolean bool2;
    if ((paramResources == null) || (paramInt == 0))
    {
      bool2 = false;
      return bool2;
    }
    int i;
    if (paramInt < 7)
    {
      i = 1;
      label22:
      int j = paramResources.getDisplayMetrics().widthPixels;
      if (i == 0) {
        break label109;
      }
      i = 2;
      label36:
      i = AIOUtils.a(i * 64 + 62, paramResources);
      if (AIOUtils.a(64.0F, paramResources) * paramInt <= j - i) {
        break label114;
      }
    }
    label109:
    label114:
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("OnlineStatusUtil", 2, new Object[] { "showShadowWhenAllAccountNotDisplay: showShadow:", Boolean.valueOf(bool1) });
      return bool1;
      i = 0;
      break label22;
      i = 1;
      break label36;
    }
  }
  
  public static boolean a(Friends paramFriends)
  {
    return (c(paramFriends)) && (paramFriends.weatherFlag == 0);
  }
  
  public static boolean a(OnlineStatusItem paramOnlineStatusItem)
  {
    if (paramOnlineStatusItem == null) {}
    while ((paramOnlineStatusItem.a != 40001L) || (TextUtils.isEmpty(paramOnlineStatusItem.b)) || (TextUtils.isEmpty(paramOnlineStatusItem.c))) {
      return false;
    }
    return true;
  }
  
  public static float[] a(View paramView)
  {
    float[] arrayOfFloat = new float[2];
    if (paramView == null)
    {
      arrayOfFloat[0] = 0.5F;
      arrayOfFloat[1] = 0.5F;
      return arrayOfFloat;
    }
    int i = paramView.getResources().getDisplayMetrics().widthPixels;
    int j = paramView.getResources().getDisplayMetrics().heightPixels;
    int k = paramView.getWidth();
    int m = paramView.getHeight();
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    arrayOfFloat[0] = ((k / 2.0F + arrayOfInt[0]) / i);
    arrayOfFloat[1] = ((m / 2.0F + arrayOfInt[1]) / j);
    return arrayOfFloat;
  }
  
  public static String b(Friends paramFriends)
  {
    int i = ContactUtils.a(paramFriends.detalStatusFlag, paramFriends.iTermType);
    Object localObject1;
    if (i == 4)
    {
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramFriends.uin.equals(((QQAppInterface)localObject1).getAccount()))
      {
        if (!((QQAppInterface)localObject1).isSelfNetworkStatusVisible(paramFriends)) {
          break label188;
        }
        localObject1 = ContactUtils.a();
      }
    }
    for (;;)
    {
      Object localObject2 = CustomOnlineStatusManager.a().a();
      for (;;)
      {
        try
        {
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (i != 4)) {
            break label183;
          }
          paramFriends = paramFriends.strTermDesc;
          localObject2 = paramFriends;
        }
        catch (Throwable localThrowable2)
        {
          paramFriends = (Friends)localObject2;
          localObject2 = localThrowable2;
          QLog.e("OnlineStatusUtil", 1, "statusDescForAccountPanel t:", (Throwable)localObject2);
          localObject2 = paramFriends;
          continue;
        }
        try
        {
          if (TextUtils.isEmpty(paramFriends)) {
            localObject2 = BaseApplicationImpl.getContext().getString(2131719512);
          }
          if ((localObject1 == null) || (TextUtils.isEmpty((CharSequence)localObject2))) {
            break label177;
          }
          return (String)localObject2 + (String)localObject1;
        }
        catch (Throwable localThrowable1)
        {
          continue;
        }
        if (ContactUtils.a(paramFriends)) {
          break label188;
        }
        localObject1 = ContactUtils.c(FriendsUtils.a(paramFriends.eNetwork, paramFriends.iTermType, paramFriends.netTypeIconId));
        break;
        label177:
        return localObject2;
        label183:
        paramFriends = localThrowable1;
      }
      label188:
      localObject1 = null;
    }
  }
  
  public static boolean b(Friends paramFriends)
  {
    String str = ConstellationUtilKt.b(paramFriends);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusUtil", 2, new Object[] { "isConstellationInfoValid: invoked. ", " suitableTrend: ", str });
    }
    return (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramFriends.constellationJumpUrl));
  }
  
  public static boolean b(OnlineStatusItem paramOnlineStatusItem)
  {
    if (paramOnlineStatusItem == null) {}
    while ((paramOnlineStatusItem.a != 40001L) || (TextUtils.isEmpty(paramOnlineStatusItem.b)) || (TextUtils.isEmpty(paramOnlineStatusItem.c)) || (TextUtils.isEmpty(paramOnlineStatusItem.d))) {
      return false;
    }
    return true;
  }
  
  public static boolean c(Friends paramFriends)
  {
    if (paramFriends == null) {}
    while ((TextUtils.isEmpty(paramFriends.weatherType)) || (TextUtils.isEmpty(paramFriends.temper)) || (TextUtils.isEmpty(paramFriends.weatherTypeId)) || (TextUtils.isEmpty(paramFriends.adCode))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusUtil
 * JD-Core Version:    0.7.0.1
 */