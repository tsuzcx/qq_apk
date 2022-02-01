package com.tencent.mobileqq.kandian.base.utils.api.impl;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/api/impl/ReadInJoyTimeUtilsImpl;", "Lcom/tencent/mobileqq/kandian/base/utils/api/IReadInJoyTimeUtils;", "()V", "BEFORE", "", "kotlin.jvm.PlatformType", "BEFOREY_YESTERDAY", "DAY", "DAYS_AGO", "DIAN", "HOUR", "HOURS_AGO", "getHOURS_AGO", "()Ljava/lang/String;", "JUST_MINS", "getJUST_MINS", "MIN", "MINS_AGO", "getMINS_AGO", "MONTH", "MONTH_AGO", "TODAY", "YEAR", "YEAR_AGO", "YESTERDAY", "getDateTimeString", "secondTime", "", "getFullTimeString", "calendar", "Ljava/util/Calendar;", "getMMDDTimeString", "ms", "getRelativeDisplayForTime", "timeSecond", "compareToServerTime", "", "getRelativeDisplayTimeString", "getServerTime", "getTimeStringWithMinAndSecond", "getTimeStringWithoutYear", "isOnTheSameDay", "time1", "time2", "isOnTheSameYear", "isYesterday", "timeToCompare", "nowTime", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyTimeUtilsImpl
  implements IReadInJoyTimeUtils
{
  private static final String COLON = ":";
  public static final ReadInJoyTimeUtilsImpl.Companion Companion = new ReadInJoyTimeUtilsImpl.Companion(null);
  private static final long DAY_MILLIS_SECOND = 86400000L;
  private static final int DAY_SECOND = 86400;
  private static final String TAG = "ReadInJoyTimeUtilsImpl";
  private static final int TIME_ZONE_SPACE = 28800;
  private static final long TWO_DAY_MILLIS_SECOND = 172800000L;
  private static final int TWO_DAY_SECOND = 172800;
  private final String BEFORE = HardCodeUtil.a(2131712709);
  private final String BEFOREY_YESTERDAY = HardCodeUtil.a(2131712925);
  private final String DAY = HardCodeUtil.a(2131712728);
  private final String DAYS_AGO = HardCodeUtil.a(2131712774);
  private final String DIAN = HardCodeUtil.a(2131712873);
  private final String HOUR = HardCodeUtil.a(2131713000);
  private final String HOURS_AGO = HardCodeUtil.a(2131712910);
  private final String JUST_MINS = HardCodeUtil.a(2131712679);
  private final String MIN = HardCodeUtil.a(2131712734);
  private final String MINS_AGO = HardCodeUtil.a(2131712878);
  private final String MONTH = HardCodeUtil.a(2131712712);
  private final String MONTH_AGO = HardCodeUtil.a(2131712699);
  private final String TODAY = HardCodeUtil.a(2131712663);
  private final String YEAR = HardCodeUtil.a(2131712916);
  private final String YEAR_AGO = HardCodeUtil.a(2131712693);
  private final String YESTERDAY = HardCodeUtil.a(2131713022);
  
  private final String getRelativeDisplayTimeString(long paramLong, boolean paramBoolean)
  {
    long l1 = 1000;
    long l2 = paramLong * l1;
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    if (paramBoolean)
    {
      paramLong = getServerTime() * l1;
    }
    else
    {
      Intrinsics.checkExpressionValueIsNotNull(localCalendar1, "nowCalendar");
      paramLong = localCalendar1.getTimeInMillis();
    }
    Intrinsics.checkExpressionValueIsNotNull(localCalendar1, "nowCalendar");
    if (paramLong != localCalendar1.getTimeInMillis()) {
      localCalendar1.setTimeInMillis(paramLong);
    }
    Intrinsics.checkExpressionValueIsNotNull(localCalendar2, "publishCalendar");
    localCalendar2.setTimeInMillis(l2);
    l1 = (paramLong - l2) / l1;
    Object localObject = getFullTimeString(localCalendar2);
    if (l1 >= 0L) {
      if (isOnTheSameDay(l2, paramLong))
      {
        paramLong = 60;
        if (l1 < paramLong)
        {
          localObject = this.JUST_MINS;
          Intrinsics.checkExpressionValueIsNotNull(localObject, "JUST_MINS");
        }
        else
        {
          l2 = 3600;
          if (l1 < l2)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(l1 / paramLong);
            ((StringBuilder)localObject).append(this.MINS_AGO);
            localObject = ((StringBuilder)localObject).toString();
          }
          else if (l1 < 86400)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(l1 / l2);
            ((StringBuilder)localObject).append(this.HOURS_AGO);
            localObject = ((StringBuilder)localObject).toString();
          }
        }
      }
      else if (isYesterday(l2, paramLong))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.YESTERDAY);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(getTimeStringWithMinAndSecond(localCalendar2));
        localObject = ((StringBuilder)localObject).toString();
      }
      else if (isOnTheSameYear(l2, paramLong))
      {
        localObject = getTimeStringWithoutYear(localCalendar2);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyTimeUtilsImpl", 2, new Object[] { "getRelativeDisplayTimeString = ", localObject, ", now = ", getFullTimeString(localCalendar1), ", publish = ", getFullTimeString(localCalendar2) });
    }
    return localObject;
  }
  
  private final long getServerTime()
  {
    return NetConnInfoCenter.getServerTime();
  }
  
  private final String getTimeStringWithMinAndSecond(Calendar paramCalendar)
  {
    paramCalendar = ((DateFormat)new SimpleDateFormat("HH:mm")).format(paramCalendar.getTime());
    Intrinsics.checkExpressionValueIsNotNull(paramCalendar, "dateFormat.format(calendar.time)");
    return paramCalendar;
  }
  
  private final String getTimeStringWithoutYear(Calendar paramCalendar)
  {
    paramCalendar = ((DateFormat)new SimpleDateFormat("MM-dd HH:mm")).format(paramCalendar.getTime());
    Intrinsics.checkExpressionValueIsNotNull(paramCalendar, "dateFormat.format(calendar.time)");
    return paramCalendar;
  }
  
  private final boolean isOnTheSameYear(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localCalendar1, "calendar1");
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localCalendar2, "calendar2");
    localCalendar2.setTimeInMillis(paramLong2);
    return localCalendar1.get(1) == localCalendar2.get(1);
  }
  
  private final boolean isYesterday(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localCalendar1, "calendar1");
    localCalendar1.setTimeInMillis(paramLong2);
    localCalendar1.add(6, -1);
    Calendar localCalendar2 = Calendar.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localCalendar2, "calendar2");
    localCalendar2.setTimeInMillis(paramLong1);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6));
  }
  
  @NotNull
  public String getDateTimeString(long paramLong)
  {
    Object localObject = new Date(paramLong * 1000);
    localObject = new SimpleDateFormat("yyyy-MM-dd").format((Date)localObject);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "SimpleDateFormat(\"yyyy-MM-dd\").format(date)");
    return localObject;
  }
  
  @NotNull
  public String getFullTimeString(@NotNull Calendar paramCalendar)
  {
    Intrinsics.checkParameterIsNotNull(paramCalendar, "calendar");
    paramCalendar = ((DateFormat)new SimpleDateFormat("yy-MM-dd HH:mm")).format(paramCalendar.getTime());
    Intrinsics.checkExpressionValueIsNotNull(paramCalendar, "dateFormat.format(calendar.time)");
    return paramCalendar;
  }
  
  public final String getHOURS_AGO()
  {
    return this.HOURS_AGO;
  }
  
  public final String getJUST_MINS()
  {
    return this.JUST_MINS;
  }
  
  public final String getMINS_AGO()
  {
    return this.MINS_AGO;
  }
  
  @NotNull
  public String getMMDDTimeString(long paramLong)
  {
    String str = new SimpleDateFormat("MM月dd日").format(Long.valueOf(paramLong * 1000));
    Intrinsics.checkExpressionValueIsNotNull(str, "SimpleDateFormat(\"MM月dd日\").format(ms * 1000)");
    return str;
  }
  
  @NotNull
  public String getRelativeDisplayForTime(long paramLong, boolean paramBoolean)
  {
    return getRelativeDisplayTimeString(paramLong, paramBoolean);
  }
  
  public boolean isOnTheSameDay(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localCalendar1, "calendar1");
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localCalendar2, "calendar2");
    localCalendar2.setTimeInMillis(paramLong2);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.api.impl.ReadInJoyTimeUtilsImpl
 * JD-Core Version:    0.7.0.1
 */