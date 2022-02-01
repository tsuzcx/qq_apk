package com.tencent.mobileqq.onlinestatus.constellation;

import android.content.Context;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IProfileCardUtil;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TAG", "", "defaultDateFormat", "Ljava/text/SimpleDateFormat;", "getDefaultDateFormat", "()Ljava/text/SimpleDateFormat;", "defaultRequestDateFormat", "getDefaultRequestDateFormat", "bgImageUrlFromEntity", "app", "Lmqq/app/AppRuntime;", "constellationLinkFromEntity", "constellationRequestTsFromSp", "", "constellationTextColorFromSp", "currentDate", "currentRequestDate", "extInfoRequestIntervalSecondFromSp", "getCurrentProfileConstellation", "uin", "getLuckyColor", "getLuckyNumber", "getMsfDate", "Ljava/util/Date;", "iconUrlFromEntity", "isConstellationRequestExpired", "", "isConstellationStatus", "saveConstellationRequestTsSp", "", "ts", "saveConstellationTextColorSp", "color", "saveExtInfoRequestIntervalSecondSp", "second", "", "saveTodayTrendJsonSp", "todayConstellationTrend", "simpleTrend", "suitableTrend", "friends", "Lcom/tencent/mobileqq/data/Friends;", "todayTrendFromEntity", "todayTrendJsonFromSp", "tomorrowRequestDate", "tomorrowTrendFromEntity", "yesterdayRequestDate", "constellationInfo", "qqonlinestatus-impl_release"}, k=2, mv={1, 1, 16})
public final class ConstellationUtilKt
{
  @NotNull
  private static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd");
  @NotNull
  private static final SimpleDateFormat b = new SimpleDateFormat("yyyyMMdd");
  
  public static final long a(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    paramAppRuntime = BaseSharedPreUtil.a((Context)MobileQQ.sMobileQQ, paramAppRuntime.getCurrentAccountUin(), "key_ext_info_request_interval_second", Long.valueOf(0L));
    if (paramAppRuntime != null) {
      return ((Long)paramAppRuntime).longValue();
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
  }
  
  @NotNull
  public static final String a()
  {
    Object localObject = a();
    localObject = a.format((Date)localObject);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "defaultDateFormat.format(date)");
    return localObject;
  }
  
  @NotNull
  public static final String a(@NotNull Friends paramFriends)
  {
    Intrinsics.checkParameterIsNotNull(paramFriends, "$this$constellationInfo");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" uin: ");
    localStringBuilder.append(paramFriends.uin);
    localStringBuilder.append(" constellationTodayTrend: ");
    localStringBuilder.append(paramFriends.constellationTodayTrend);
    localStringBuilder.append(' ');
    localStringBuilder.append("constellationTomorrowTrend: ");
    localStringBuilder.append(paramFriends.constellationTomorrowTrend);
    localStringBuilder.append(' ');
    localStringBuilder.append("constellationDateStr: ");
    localStringBuilder.append(paramFriends.constellationDateStr);
    return localStringBuilder.toString();
  }
  
  @NotNull
  public static final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFriendDataService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "app.getRuntimeService(IF…va, ProcessConstant.MAIN)");
    paramString = ((IFriendDataService)localObject).getFriend(paramString, true, true, true).constellationTodayTrend;
    if (paramString == null) {
      paramString = "";
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("trend: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ConstellationUtil", 2, new Object[] { "todayTrendFromEntity: called. ", ((StringBuilder)localObject).toString() });
    }
    return paramString;
  }
  
  @NotNull
  public static final String a(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    paramAppRuntime = BaseSharedPreUtil.a((Context)MobileQQ.sMobileQQ, paramAppRuntime.getCurrentAccountUin(), "key_today_constellation_trends_json", "");
    if (paramAppRuntime != null) {
      return (String)paramAppRuntime;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
  }
  
  @NotNull
  public static final String a(@NotNull AppRuntime paramAppRuntime, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    paramAppRuntime = paramAppRuntime.getRuntimeService(IFriendDataService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(paramAppRuntime, "app.getRuntimeService(IF…va, ProcessConstant.MAIN)");
    paramAppRuntime = ((IFriendDataService)paramAppRuntime).getFriend(paramString, true, true, true);
    Intrinsics.checkExpressionValueIsNotNull(paramAppRuntime, "friends");
    return b(paramAppRuntime);
  }
  
  @NotNull
  public static final SimpleDateFormat a()
  {
    return a;
  }
  
  private static final Date a()
  {
    return new Date(NetConnInfoCenter.getServerTimeMillis());
  }
  
  public static final void a(@NotNull AppRuntime paramAppRuntime, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    BaseSharedPreUtil.a((Context)MobileQQ.sMobileQQ, paramAppRuntime.getCurrentAccountUin(), true, "key_ext_info_request_interval_second", Integer.valueOf(paramInt));
  }
  
  public static final void a(@NotNull AppRuntime paramAppRuntime, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    BaseSharedPreUtil.a((Context)MobileQQ.sMobileQQ, paramAppRuntime.getCurrentAccountUin(), true, "key_constellation_last_request_second", Long.valueOf(paramLong));
  }
  
  public static final void a(@NotNull AppRuntime paramAppRuntime, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    Context localContext = (Context)MobileQQ.sMobileQQ;
    paramAppRuntime = paramAppRuntime.getCurrentAccountUin();
    if (paramString == null) {
      paramString = "";
    }
    BaseSharedPreUtil.a(localContext, paramAppRuntime, true, "key_today_constellation_trends_json", paramString);
  }
  
  public static final boolean a(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    long l1 = System.currentTimeMillis() / 1000L;
    long l2 = a(paramAppRuntime);
    boolean bool;
    if (l1 - b(paramAppRuntime) >= l2) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("expired: ");
      paramAppRuntime.append(bool);
      QLog.d("ConstellationUtil", 2, new Object[] { "isConstellationRequestExpired: called. ", paramAppRuntime.toString() });
    }
    return bool;
  }
  
  public static final long b(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    paramAppRuntime = BaseSharedPreUtil.a((Context)MobileQQ.sMobileQQ, paramAppRuntime.getCurrentAccountUin(), "key_constellation_last_request_second", Long.valueOf(0L));
    if (paramAppRuntime != null) {
      return ((Long)paramAppRuntime).longValue();
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
  }
  
  @NotNull
  public static final String b()
  {
    Object localObject = a();
    localObject = b.format((Date)localObject);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "defaultRequestDateFormat.format(date)");
    return localObject;
  }
  
  @NotNull
  public static final String b(@NotNull Friends paramFriends)
  {
    Intrinsics.checkParameterIsNotNull(paramFriends, "friends");
    boolean bool = Intrinsics.areEqual(b(), paramFriends.constellationDateStr);
    String str2 = "";
    String str3;
    String str1;
    if (bool)
    {
      str3 = paramFriends.constellationTodayTrend;
      str1 = str2;
      if (str3 == null) {}
    }
    else
    {
      for (str1 = str3;; str1 = str3)
      {
        break;
        str1 = str2;
        if (!Intrinsics.areEqual(d(), paramFriends.constellationDateStr)) {
          break;
        }
        str3 = paramFriends.constellationTomorrowTrend;
        str1 = str2;
        if (str3 == null) {
          break;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConstellationUtil", 2, new Object[] { "suitableTrend: called. ", a(paramFriends) });
    }
    return str1;
  }
  
  @NotNull
  public static final String b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    IRuntimeService localIRuntimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFriendDataService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localIRuntimeService, "app.getRuntimeService(IF…va, ProcessConstant.MAIN)");
    paramString = ((IFriendDataService)localIRuntimeService).getFriend(paramString, true, true, true).constellationTomorrowTrend;
    if (paramString != null) {
      return paramString;
    }
    return "";
  }
  
  @Nullable
  public static final String b(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    IRuntimeService localIRuntimeService = paramAppRuntime.getRuntimeService(IFriendDataService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localIRuntimeService, "app.getRuntimeService(IF…va, ProcessConstant.MAIN)");
    paramAppRuntime = ((IFriendDataService)localIRuntimeService).getFriend(paramAppRuntime.getCurrentUin(), true, true, true).constellationIconUrl;
    if (paramAppRuntime != null) {
      return paramAppRuntime;
    }
    return "";
  }
  
  @NotNull
  public static final String b(@NotNull AppRuntime paramAppRuntime, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    paramAppRuntime = OnlineStatusUtil.b(((IProfileCardUtil)QRoute.api(IProfileCardUtil.class)).initCard(paramAppRuntime, paramString).constellation);
    Intrinsics.checkExpressionValueIsNotNull(paramAppRuntime, "constellationStr");
    return paramAppRuntime;
  }
  
  public static final void b(@NotNull AppRuntime paramAppRuntime, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    Intrinsics.checkParameterIsNotNull(paramString, "color");
    BaseSharedPreUtil.a((Context)MobileQQ.sMobileQQ, paramAppRuntime.getCurrentAccountUin(), true, "key_constellation_text_color", paramString);
  }
  
  public static final boolean b(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    paramAppRuntime = paramAppRuntime.getRuntimeService(IOnlineStatusService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(paramAppRuntime, "app.getRuntimeService(IO…va, ProcessConstant.MAIN)");
    paramAppRuntime = (IOnlineStatusService)paramAppRuntime;
    return (paramAppRuntime.getOnlineStatus() == AppRuntime.Status.online) && (paramAppRuntime.getExtOnlineStatus() == 1040);
  }
  
  @NotNull
  public static final String c()
  {
    Object localObject = Calendar.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "cal");
    ((Calendar)localObject).setTime(a());
    ((Calendar)localObject).add(5, 1);
    localObject = b.format(((Calendar)localObject).getTime());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "defaultRequestDateFormat.format(cal.time)");
    return localObject;
  }
  
  @NotNull
  public static final String c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    IRuntimeService localIRuntimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFriendDataService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localIRuntimeService, "app.getRuntimeService(IF…va, ProcessConstant.MAIN)");
    paramString = ((IFriendDataService)localIRuntimeService).getFriend(paramString, true, true, true).constellationLuckyColor;
    if (paramString != null) {
      return paramString;
    }
    return "";
  }
  
  @Nullable
  public static final String c(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    IRuntimeService localIRuntimeService = paramAppRuntime.getRuntimeService(IFriendDataService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localIRuntimeService, "app.getRuntimeService(IF…va, ProcessConstant.MAIN)");
    paramAppRuntime = ((IFriendDataService)localIRuntimeService).getFriend(paramAppRuntime.getCurrentUin(), true, true, true).constellationBgImageUrl;
    if (paramAppRuntime != null) {
      return paramAppRuntime;
    }
    return "";
  }
  
  @NotNull
  public static final String d()
  {
    Object localObject = Calendar.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "cal");
    ((Calendar)localObject).setTime(a());
    ((Calendar)localObject).add(5, -1);
    localObject = b.format(((Calendar)localObject).getTime());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "defaultRequestDateFormat.format(cal.time)");
    return localObject;
  }
  
  @NotNull
  public static final String d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    IRuntimeService localIRuntimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFriendDataService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localIRuntimeService, "app.getRuntimeService(IF…va, ProcessConstant.MAIN)");
    paramString = ((IFriendDataService)localIRuntimeService).getFriend(paramString, true, true, true).constellationLuckyNumber;
    if (paramString != null) {
      return paramString;
    }
    return "";
  }
  
  @NotNull
  public static final String d(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    paramAppRuntime = BaseSharedPreUtil.a((Context)MobileQQ.sMobileQQ, paramAppRuntime.getCurrentAccountUin(), "key_constellation_text_color", "");
    if (paramAppRuntime != null) {
      return (String)paramAppRuntime;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
  }
  
  @NotNull
  public static final String e(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    IRuntimeService localIRuntimeService = paramAppRuntime.getRuntimeService(IFriendDataService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localIRuntimeService, "app.getRuntimeService(IF…va, ProcessConstant.MAIN)");
    paramAppRuntime = ((IFriendDataService)localIRuntimeService).getFriend(paramAppRuntime.getCurrentUin(), true, true, true).constellationJumpUrl;
    if (paramAppRuntime != null) {
      return paramAppRuntime;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.constellation.ConstellationUtilKt
 * JD-Core Version:    0.7.0.1
 */