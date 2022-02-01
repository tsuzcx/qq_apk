package com.tencent.mobileqq.extendfriend.utils;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/extendfriend/utils/ExpandForbiddenUtils;", "", "()V", "getRemainingForbiddenTime", "", "forbiddenEndTime", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandForbiddenUtils
{
  public static final ExpandForbiddenUtils a = new ExpandForbiddenUtils();
  
  @JvmStatic
  public static final long a(long paramLong)
  {
    paramLong -= NetConnInfoCenter.getServerTime();
    if (paramLong < 0L) {
      return 0L;
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExpandForbiddenUtils
 * JD-Core Version:    0.7.0.1
 */