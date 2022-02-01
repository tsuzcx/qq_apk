package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineAutoStatusBean;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusElement;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationUtilKt;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.relation.api.IFriendsUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.onlinestatus.api.ICustomOnlineStatusManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.onlinestatus.OnlineStatusExtInfo.AutoStateBizInfo;
import tencent.im.onlinestatus.OnlineStatusExtInfo.WeatherBizInfo;
import tencent.im.onlinestatus.OnlineStatusExtInfo.ZodiacBizInfo;

public class OnlineStatusUtil
{
  public static final String[] a = { "", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };
  
  public static String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return "";
            }
            return " - 5G";
          }
          return " - 4G";
        }
        return " - 3G";
      }
      return " - 2G";
    }
    return " - WiFi";
  }
  
  public static String a(long paramLong1, long paramLong2)
  {
    paramLong1 -= paramLong2;
    if (paramLong1 <= 600L) {
      return "";
    }
    StringBuilder localStringBuilder;
    if (paramLong1 < 3600L)
    {
      paramLong1 /= 60L;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("分钟前");
      return localStringBuilder.toString();
    }
    if (paramLong1 < 86400L)
    {
      paramLong1 /= 3600L;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("小时前");
      return localStringBuilder.toString();
    }
    if (paramLong1 < 2592000L)
    {
      paramLong1 /= 86400L;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("天前");
      return localStringBuilder.toString();
    }
    if (paramLong1 < 31104000L)
    {
      paramLong1 /= 2592000L;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("月前");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static final String a(Paint paramPaint, String paramString, int paramInt)
  {
    float f1 = paramPaint.measureText(paramString);
    float f2 = paramPaint.measureText("…");
    if (f2 > f1) {
      return paramString;
    }
    float f3 = paramInt;
    if (f2 > f3) {
      return "…";
    }
    if (f1 > f3)
    {
      float[] arrayOfFloat = new float[paramString.length()];
      paramPaint.getTextWidths(paramString, arrayOfFloat);
      paramInt = 0;
      f1 = 0.0F;
      while (paramInt < arrayOfFloat.length)
      {
        f1 += arrayOfFloat[paramInt];
        if (f1 > f3 - f2)
        {
          paramPaint = new StringBuilder();
          paramPaint.append(paramString.substring(0, paramInt));
          paramPaint.append("…");
          return paramPaint.toString();
        }
        paramInt += 1;
      }
    }
    return paramString;
  }
  
  public static final String a(Friends paramFriends)
  {
    if (paramFriends.weatherUpdateTime > 0L)
    {
      String str = a(NetConnInfoCenter.getServerTime(), paramFriends.weatherUpdateTime);
      paramFriends = str;
      if (QLog.isColorLevel())
      {
        QLog.d("OnlineStatusUtil", 2, new Object[] { "getWeatherDisplayInfo passTimeTip=", str });
        return str;
      }
    }
    else
    {
      paramFriends = "";
    }
    return paramFriends;
  }
  
  public static String a(AppRuntime paramAppRuntime, TextView paramTextView, @NonNull Friends paramFriends, int paramInt)
  {
    if (!b(paramFriends)) {
      return "";
    }
    int i;
    if ((paramAppRuntime != null) && (paramFriends.uin != null) && (paramFriends.uin.equals(paramAppRuntime.getAccount()))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        i = paramTextView.getContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION");
      } else {
        i = 0;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getWeatherDisplayInfo isSelfUin granted=");
      localStringBuilder.append(i);
      QLog.i("OnlineStatusUtil", 1, localStringBuilder.toString());
      if (i != 0) {
        return paramTextView.getContext().getString(2131896450);
      }
    }
    paramFriends = a(paramAppRuntime, paramFriends, false);
    paramAppRuntime = paramFriends;
    if (paramInt == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusUtil", 2, "getWeatherDisplayInfo fromContacts");
      }
      paramAppRuntime = a(paramTextView.getPaint(), paramFriends, ViewUtils.dip2px(200.0F));
    }
    paramTextView = new StringBuilder();
    paramTextView.append(paramAppRuntime);
    paramTextView.append("");
    return paramTextView.toString();
  }
  
  public static String a(AppRuntime paramAppRuntime, @NonNull Friends paramFriends, boolean paramBoolean)
  {
    boolean bool = b(paramFriends);
    Object localObject1 = "";
    if (!bool) {
      return "";
    }
    Object localObject2 = new StringBuilder();
    if (TextUtils.isEmpty(paramFriends.city)) {
      paramAppRuntime = "";
    } else {
      paramAppRuntime = paramFriends.city;
    }
    ((StringBuilder)localObject2).append(paramAppRuntime);
    if (TextUtils.isEmpty(paramFriends.area)) {
      paramAppRuntime = "";
    } else {
      paramAppRuntime = paramFriends.area;
    }
    ((StringBuilder)localObject2).append(paramAppRuntime);
    localObject2 = ((StringBuilder)localObject2).toString();
    if (TextUtils.isEmpty(paramFriends.weatherType)) {
      paramAppRuntime = "";
    } else {
      paramAppRuntime = paramFriends.weatherType;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAppRuntime);
    if (TextUtils.isEmpty(paramFriends.temper))
    {
      paramAppRuntime = "";
    }
    else
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append(paramFriends.temper);
      paramAppRuntime.append("°");
      paramAppRuntime = paramAppRuntime.toString();
    }
    localStringBuilder.append(paramAppRuntime);
    paramAppRuntime = localStringBuilder.toString();
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramAppRuntime = (AppRuntime)localObject1;
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" | ");
      ((StringBuilder)localObject1).append(paramAppRuntime);
      paramAppRuntime = ((StringBuilder)localObject1).toString();
    }
    if (paramBoolean)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramAppRuntime);
      ((StringBuilder)localObject1).append(a(paramFriends));
      return ((StringBuilder)localObject1).toString();
    }
    return paramAppRuntime;
  }
  
  private static void a(Friends paramFriends1, byte[] paramArrayOfByte, @Nullable Friends paramFriends2)
  {
    if (paramFriends1.uExtOnlineStatus == 1040L)
    {
      try
      {
        paramFriends2 = new OnlineStatusExtInfo.ZodiacBizInfo();
        paramFriends2.mergeFrom(paramArrayOfByte);
        paramFriends1.constellationTodayTrend = paramFriends2.string_today_trend.get();
        paramFriends1.constellationTomorrowTrend = paramFriends2.string_tomorrow_trend.get();
        paramFriends1.constellationDateStr = paramFriends2.string_today_date.get();
        paramFriends1.constellationJumpUrl = paramFriends2.string_miniapp.get();
        if (paramFriends2.string_lucky_color.has()) {
          paramFriends1.constellationLuckyNumber = String.valueOf(paramFriends2.string_lucky_number.get());
        }
        if (paramFriends2.string_lucky_number.has()) {
          paramFriends1.constellationLuckyColor = String.valueOf(paramFriends2.string_lucky_color.get());
        }
        if (!QLog.isColorLevel()) {
          break label655;
        }
        QLog.d("OnlineStatusUtil", 2, new Object[] { "parseExtOnlineBusinessInfo: invoked. ", ConstellationUtilKt.a(paramFriends1) });
        return;
      }
      catch (Exception paramFriends1)
      {
        QLog.e("OnlineStatusUtil", 1, "parseExtOnlineBusinessInfo fail", paramFriends1);
        return;
      }
    }
    else if (paramFriends1.uExtOnlineStatus == 1030L)
    {
      try
      {
        OnlineStatusExtInfo.WeatherBizInfo localWeatherBizInfo = new OnlineStatusExtInfo.WeatherBizInfo();
        localWeatherBizInfo.mergeFrom(paramArrayOfByte);
        long l2 = localWeatherBizInfo.uint64_update_time.get();
        if (QLog.isColorLevel())
        {
          long l1;
          if (paramFriends2 == null) {
            l1 = paramFriends1.weatherUpdateTime;
          } else {
            l1 = paramFriends2.weatherUpdateTime;
          }
          QLog.d("OnlineStatusUtil", 2, new Object[] { "parseExtOnlineBusinessInfo: invoked. server time", Long.valueOf(l2), " local time: ", Long.valueOf(l1) });
        }
        if ((paramFriends2 != null) && (paramFriends2.weatherUpdateTime > l2))
        {
          paramFriends1.weatherTypeId = paramFriends2.weatherTypeId;
          paramFriends1.weatherType = paramFriends2.weatherType;
          paramFriends1.temper = paramFriends2.temper;
          paramFriends1.city = paramFriends2.city;
          paramFriends1.area = paramFriends2.area;
          paramFriends1.adCode = paramFriends2.adCode;
          paramFriends1.weatherFlag = paramFriends2.weatherFlag;
          paramFriends1.weatherUpdateTime = paramFriends2.weatherUpdateTime;
          if (!localWeatherBizInfo.string_weather_desc.has()) {
            return;
          }
          paramFriends1.weatherDecs = localWeatherBizInfo.string_weather_desc.get();
          return;
        }
        if (l2 > paramFriends1.weatherUpdateTime)
        {
          paramFriends1.weatherTypeId = localWeatherBizInfo.string_weather_type_id.get();
          paramFriends1.weatherType = localWeatherBizInfo.string_weather_type.get();
          paramFriends1.temper = localWeatherBizInfo.string_temper.get();
          paramFriends1.city = localWeatherBizInfo.string_city.get();
          paramFriends1.area = localWeatherBizInfo.string_area.get();
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append(localWeatherBizInfo.uint32_adcode.get());
          paramArrayOfByte.append("");
          paramFriends1.adCode = paramArrayOfByte.toString();
          paramFriends1.weatherFlag = localWeatherBizInfo.uint32_flag.get();
          paramFriends1.weatherUpdateTime = l2;
          if (localWeatherBizInfo.string_weather_desc.has()) {
            paramFriends1.weatherDecs = localWeatherBizInfo.string_weather_desc.get();
          }
        }
        if (!QLog.isColorLevel()) {
          break label655;
        }
        QLog.d("OnlineStatusUtil", 2, new Object[] { "parseExtOnlineBusinessInfo: invoked. ", " friend.weatherFlag: ", Integer.valueOf(paramFriends1.weatherFlag) });
        return;
      }
      catch (Exception paramFriends1)
      {
        QLog.e("OnlineStatusUtil", 1, "parseExtOnlineBusinessInfo fail", paramFriends1);
        return;
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
    label655:
    return;
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
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      a(paramFriends1, paramArrayOfByte, paramFriends2);
    }
  }
  
  public static boolean a()
  {
    OnlineAutoStatusBean localOnlineAutoStatusBean = (OnlineAutoStatusBean)QConfigManager.b().b(652);
    return (localOnlineAutoStatusBean != null) && (localOnlineAutoStatusBean.a != null) && (a(localOnlineAutoStatusBean.a.b));
  }
  
  public static boolean a(OnlineStatusItem paramOnlineStatusItem)
  {
    boolean bool2 = false;
    if (paramOnlineStatusItem == null) {
      return false;
    }
    if (paramOnlineStatusItem.b != 40001L) {
      return false;
    }
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramOnlineStatusItem.c))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramOnlineStatusItem.d)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int b()
  {
    int i;
    if (c()) {
      i = 3;
    } else {
      i = 1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("HPush_Huawei Push pushType : ");
      localStringBuilder.append(i);
      QLog.d("", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public static final String b(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 12)) {
      return a[paramInt];
    }
    return "";
  }
  
  public static boolean b(Friends paramFriends)
  {
    return (d(paramFriends)) && (paramFriends.weatherFlag == 0);
  }
  
  public static boolean b(OnlineStatusItem paramOnlineStatusItem)
  {
    boolean bool2 = false;
    if (paramOnlineStatusItem == null) {
      return false;
    }
    if (paramOnlineStatusItem.b != 40001L) {
      return false;
    }
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramOnlineStatusItem.c))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramOnlineStatusItem.d))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramOnlineStatusItem.i)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean c()
  {
    return ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT >= 21);
  }
  
  public static boolean c(Friends paramFriends)
  {
    String str = ConstellationUtilKt.b(paramFriends);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusUtil", 2, new Object[] { "isConstellationInfoValid: invoked. ", " suitableTrend: ", str });
    }
    return (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramFriends.constellationJumpUrl));
  }
  
  public static boolean d(Friends paramFriends)
  {
    if (paramFriends == null) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramFriends.weatherType)) && (!TextUtils.isEmpty(paramFriends.temper)))
    {
      if (TextUtils.isEmpty(paramFriends.weatherTypeId)) {
        return false;
      }
      return TextUtils.isEmpty(paramFriends.adCode) ^ true;
    }
    return false;
  }
  
  public static String e(Friends paramFriends)
  {
    int i = OnlineStatusUtils.a(paramFriends.detalStatusFlag, paramFriends.iTermType);
    if (i == 4)
    {
      localObject1 = MobileQQ.sMobileQQ.peekAppRuntime();
      if (paramFriends.uin.equals(((AppRuntime)localObject1).getAccount()))
      {
        if (((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).isSelfNetworkStatusVisible(paramFriends))
        {
          str1 = OnlineStatusUtils.a();
          break label121;
        }
      }
      else if (!OnlineStatusUtils.b(paramFriends))
      {
        int j = ((IFriendsUtils)QRoute.api(IFriendsUtils.class)).getNetworkType(paramFriends.eNetwork, paramFriends.iTermType, paramFriends.netTypeIconId);
        str1 = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getStatusNamePlusNetWorkType(j);
        break label121;
      }
    }
    String str1 = null;
    label121:
    String str2 = ((ICustomOnlineStatusManager)QRoute.api(ICustomOnlineStatusManager.class)).getOwnerOnlineStatus();
    Object localObject1 = str2;
    Object localObject2 = str2;
    try
    {
      if (TextUtils.isEmpty(str2))
      {
        localObject1 = str2;
        if (i == 4)
        {
          localObject2 = str2;
          localObject1 = paramFriends.strTermDesc;
        }
      }
      localObject2 = localObject1;
      paramFriends = (Friends)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        paramFriends = MobileQQ.sMobileQQ.getString(2131916782);
      }
    }
    catch (Throwable paramFriends)
    {
      QLog.e("OnlineStatusUtil", 1, "statusDescForAccountPanel t:", paramFriends);
      paramFriends = (Friends)localObject2;
    }
    if ((str1 != null) && (!TextUtils.isEmpty(paramFriends)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramFriends);
      ((StringBuilder)localObject1).append(str1);
      return ((StringBuilder)localObject1).toString();
    }
    return paramFriends;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusUtil
 * JD-Core Version:    0.7.0.1
 */