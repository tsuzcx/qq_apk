package com.tencent.mobileqq.kandian.biz.reward.utils;

import com.tencent.common.app.BaseApplicationImpl;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/utils/Utils;", "", "()V", "MILLIS_IN_DAY", "", "isMainProcess", "", "isSameDayOfMillis", "ms1", "ms2", "toDay", "millis", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class Utils
{
  public static final Utils a = new Utils();
  
  private final long a(long paramLong)
  {
    return (paramLong + TimeZone.getDefault().getOffset(paramLong)) / 86400000L;
  }
  
  @JvmStatic
  public static final boolean a()
  {
    return BaseApplicationImpl.sProcessId == 1;
  }
  
  @JvmStatic
  public static final boolean a(long paramLong1, long paramLong2)
  {
    long l = paramLong1 - paramLong2;
    return (l < 86400000L) && (l > -86400000L) && (a.a(paramLong1) == a.a(paramLong2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.utils.Utils
 * JD-Core Version:    0.7.0.1
 */