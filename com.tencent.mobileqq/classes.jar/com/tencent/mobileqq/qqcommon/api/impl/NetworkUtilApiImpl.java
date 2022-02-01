package com.tencent.mobileqq.qqcommon.api.impl;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qqcommon.api.INetworkUtilApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.app.MobileQQ;

public class NetworkUtilApiImpl
  implements INetworkUtilApi
{
  public int getConnRetryTimes(int paramInt)
  {
    return NetworkUtil.a(paramInt);
  }
  
  public boolean is4G()
  {
    return AppNetConnInfo.getMobileInfo() == 3;
  }
  
  public boolean is5G()
  {
    return AppNetConnInfo.getMobileInfo() == 4;
  }
  
  public boolean isNetworkAvailable()
  {
    return NetworkUtil.a();
  }
  
  public boolean isWifi()
  {
    return NetworkUtil.h(MobileQQ.sMobileQQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqcommon.api.impl.NetworkUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */