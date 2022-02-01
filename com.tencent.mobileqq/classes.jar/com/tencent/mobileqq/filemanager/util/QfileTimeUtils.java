package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.filemanager.api.IQfileTimeUtils;
import com.tencent.mobileqq.qroute.QRoute;

public class QfileTimeUtils
{
  public static IQfileTimeUtils a()
  {
    return (IQfileTimeUtils)QRoute.api(IQfileTimeUtils.class);
  }
  
  public static String a(long paramLong)
  {
    return a().getHistoryGroupByTime(paramLong);
  }
  
  public static String b(long paramLong)
  {
    return a().formatNewRefreshTime(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QfileTimeUtils
 * JD-Core Version:    0.7.0.1
 */