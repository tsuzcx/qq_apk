package com.tencent.mobileqq.kandian.base.utils.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Calendar;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/api/IReadInJoyTimeUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getDateTimeString", "", "secondTime", "", "getFullTimeString", "calendar", "Ljava/util/Calendar;", "getMMDDTimeString", "ms", "getRelativeDisplayForTime", "timeSecond", "compareToServerTime", "", "isOnTheSameDay", "time1", "time2", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyTimeUtils
  extends QRouteApi
{
  @NotNull
  public abstract String getDateTimeString(long paramLong);
  
  @NotNull
  public abstract String getFullTimeString(@NotNull Calendar paramCalendar);
  
  @NotNull
  public abstract String getMMDDTimeString(long paramLong);
  
  @NotNull
  public abstract String getRelativeDisplayForTime(long paramLong, boolean paramBoolean);
  
  public abstract boolean isOnTheSameDay(long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils
 * JD-Core Version:    0.7.0.1
 */