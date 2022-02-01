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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("highway_config_push");
    this.mPushIpContainer = new IpContainer(paramContext, localStringBuilder.toString(), paramAppRuntime);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("highway_config_ssoget");
    this.mGetIpContainer = new IpContainer(paramContext, localStringBuilder.toString(), paramAppRuntime);
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
    Object localObject = this.mPushIpContainer;
    if (localObject != null)
    {
      ArrayList localArrayList = ((IpContainer)localObject).findIpCurNetList(paramContext, paramBoolean);
      if (localArrayList != null)
      {
        localObject = localArrayList;
        if (localArrayList.size() != 0) {}
      }
      else
      {
        IpContainer localIpContainer = this.mGetIpContainer;
        localObject = localArrayList;
        if (localIpContainer != null) {
          return localIpContainer.findIpCurNetList(paramContext, paramBoolean);
        }
      }
    }
    else
    {
      localObject = null;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.config.ServiceIpProvider
 * JD-Core Version:    0.7.0.1
 */