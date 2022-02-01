package com.tencent.mobileqq.kandian.base.utils.api.impl;

import com.tencent.mobileqq.kandian.base.utils.ReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/api/impl/ReadInJoyTimeUtilsImpl;", "Lcom/tencent/mobileqq/kandian/base/utils/api/IReadInJoyTimeUtils;", "()V", "getDateTimeString", "", "secondTime", "", "getFullTimeString", "calendar", "Ljava/util/Calendar;", "getMMDDTimeString", "ms", "getRelativeDisplayForTime", "timeSecond", "compareToServerTime", "", "isOnTheSameDay", "time1", "time2", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyTimeUtilsImpl
  implements IReadInJoyTimeUtils
{
  @NotNull
  public String getDateTimeString(long paramLong)
  {
    return this.$$delegate_0.getDateTimeString(paramLong);
  }
  
  @NotNull
  public String getFullTimeString(@NotNull Calendar paramCalendar)
  {
    Intrinsics.checkParameterIsNotNull(paramCalendar, "calendar");
    return this.$$delegate_0.getFullTimeString(paramCalendar);
  }
  
  @NotNull
  public String getMMDDTimeString(long paramLong)
  {
    return this.$$delegate_0.getMMDDTimeString(paramLong);
  }
  
  @NotNull
  public String getRelativeDisplayForTime(long paramLong, boolean paramBoolean)
  {
    return this.$$delegate_0.getRelativeDisplayForTime(paramLong, paramBoolean);
  }
  
  public boolean isOnTheSameDay(long paramLong1, long paramLong2)
  {
    return this.$$delegate_0.isOnTheSameDay(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.api.impl.ReadInJoyTimeUtilsImpl
 * JD-Core Version:    0.7.0.1
 */