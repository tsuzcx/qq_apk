package com.tencent.mobileqq.dpc.api.impl;

import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.DeviceProfileManager;
import com.tencent.mobileqq.dpc.DeviceProfileManager.SimpleStringParser;
import com.tencent.mobileqq.dpc.DeviceProfileManager.StringToIntParser;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import mqq.app.AppRuntime;

public class DPCApiImpl
  implements IDPCApi
{
  public void addObserver(DPCObserver paramDPCObserver)
  {
    DeviceProfileManager.addObserver(paramDPCObserver);
  }
  
  public ConfigurationService.ReqGetConfig buidldReqConfig(AppRuntime paramAppRuntime)
  {
    return DeviceProfileManager.buidldReqConfig(paramAppRuntime);
  }
  
  public int getAbRamdom()
  {
    return DeviceProfileManager.getInstance().mAbRamdom;
  }
  
  public String getFeatureValue(String paramString)
  {
    return DeviceProfileManager.getInstance().getFeatureValue(paramString);
  }
  
  public String getFeatureValue(String paramString1, String paramString2)
  {
    return DeviceProfileManager.getInstance().getFeatureValue(paramString1, paramString2);
  }
  
  public String getFeatureValueWithoutAccountManager(String paramString)
  {
    return DeviceProfileManager.getInstanceWithoutAccountManager().getFeatureValue(paramString);
  }
  
  public String getFeatureValueWithoutAccountManager(String paramString1, String paramString2)
  {
    return DeviceProfileManager.getInstanceWithoutAccountManager().getFeatureValue(paramString1, paramString2);
  }
  
  public int getMaxAbRamdom()
  {
    return 10000;
  }
  
  public int getServerDataCurrentState()
  {
    return DeviceProfileManager.getInstance().getServerDataCurrentState();
  }
  
  public int getServerDataCurrentStateWithoutAccountManager()
  {
    return DeviceProfileManager.getInstanceWithoutAccountManager().getServerDataCurrentState();
  }
  
  public boolean isFeatureSupported(String paramString)
  {
    return DeviceProfileManager.getInstance().isFeatureSupported(paramString);
  }
  
  public boolean isFeatureSupported(String paramString, long paramLong)
  {
    return DeviceProfileManager.getInstance().isFeatureSupported(paramString, paramLong);
  }
  
  public boolean isInited()
  {
    return DeviceProfileManager.isInited;
  }
  
  public void nextServerDataState(int paramInt)
  {
    DeviceProfileManager.getInstance().nextServerDataState(paramInt);
  }
  
  public boolean onDPCResponse(ConfigurationService.RespGetConfig paramRespGetConfig, String paramString)
  {
    return DeviceProfileManager.getInstance().onDPCResponse(paramRespGetConfig, paramString);
  }
  
  public int parseComplexParamsBySimpleStringParser(String paramString, String[] paramArrayOfString)
  {
    return DeviceProfileManager.parseComplexParams(paramString, paramArrayOfString, new DeviceProfileManager.SimpleStringParser());
  }
  
  public int parseComplexParamsByStringToIntParser(String paramString, Integer[] paramArrayOfInteger)
  {
    return DeviceProfileManager.parseComplexParams(paramString, paramArrayOfInteger, new DeviceProfileManager.StringToIntParser());
  }
  
  public void registerBroadCast(AppRuntime paramAppRuntime)
  {
    DeviceProfileManager.getInstance(paramAppRuntime).registerBroadCast(paramAppRuntime);
  }
  
  public void removeObserver(DPCObserver paramDPCObserver)
  {
    DeviceProfileManager.removeObserver(paramDPCObserver);
  }
  
  public void unRegisterBroadCast(AppRuntime paramAppRuntime)
  {
    DeviceProfileManager.getInstance(paramAppRuntime).unRegisterBroadCast(paramAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dpc.api.impl.DPCApiImpl
 * JD-Core Version:    0.7.0.1
 */