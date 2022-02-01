package com.tencent.mobileqq.winkreport.utils;

import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;

public class WinkReportUtils
{
  public static String getAccountUin()
  {
    return ((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount();
  }
  
  public static long getLongAccountUin()
  {
    return Long.parseLong(getAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkreport.utils.WinkReportUtils
 * JD-Core Version:    0.7.0.1
 */