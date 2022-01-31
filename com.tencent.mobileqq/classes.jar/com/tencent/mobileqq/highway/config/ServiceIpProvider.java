package com.tencent.mobileqq.highway.config;

import android.content.Context;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class ServiceIpProvider
{
  private IpContainer mGetIpContainer;
  private IpContainer mPushIpContainer;
  
  public ServiceIpProvider(Context paramContext, AppRuntime paramAppRuntime, int paramInt)
  {
    this.mPushIpContainer = new IpContainer(paramContext, paramInt + "highway_config_push", paramAppRuntime);
    this.mGetIpContainer = new IpContainer(paramContext, paramInt + "highway_config_ssoget", paramAppRuntime);
  }
  
  void addPushIp(HwConfig paramHwConfig, AppRuntime paramAppRuntime)
  {
    this.mPushIpContainer.addNew(BaseApplication.getContext(), paramHwConfig, paramAppRuntime, null);
  }
  
  void addSSOGetIp(HwConfig paramHwConfig, AppRuntime paramAppRuntime)
  {
    this.mGetIpContainer.addNew(BaseApplication.getContext(), paramHwConfig, paramAppRuntime, null);
  }
  
  List<EndPoint> getIpList(Context paramContext, boolean paramBoolean)
  {
    Object localObject = null;
    if (this.mPushIpContainer != null)
    {
      ArrayList localArrayList = this.mPushIpContainer.findIpCurNetList(paramContext, paramBoolean);
      if (localArrayList != null)
      {
        localObject = localArrayList;
        if (localArrayList.size() != 0) {}
      }
      else
      {
        localObject = localArrayList;
        if (this.mGetIpContainer != null) {
          localObject = this.mGetIpContainer.findIpCurNetList(paramContext, paramBoolean);
        }
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.config.ServiceIpProvider
 * JD-Core Version:    0.7.0.1
 */