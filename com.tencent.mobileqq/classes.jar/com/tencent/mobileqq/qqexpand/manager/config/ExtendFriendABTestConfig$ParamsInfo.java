package com.tencent.mobileqq.qqexpand.manager.config;

import com.tencent.mobileqq.pb.PBStringField;
import expand.network.ExtendFriendABTestConfig.ExtendFriendParamsInfo;

public class ExtendFriendABTestConfig$ParamsInfo
{
  private String a;
  private String b;
  
  public ExtendFriendABTestConfig$ParamsInfo() {}
  
  public ExtendFriendABTestConfig$ParamsInfo(ExtendFriendABTestConfig.ExtendFriendParamsInfo paramExtendFriendParamsInfo)
  {
    this.a = paramExtendFriendParamsInfo.key.get();
    this.b = paramExtendFriendParamsInfo.value.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.config.ExtendFriendABTestConfig.ParamsInfo
 * JD-Core Version:    0.7.0.1
 */