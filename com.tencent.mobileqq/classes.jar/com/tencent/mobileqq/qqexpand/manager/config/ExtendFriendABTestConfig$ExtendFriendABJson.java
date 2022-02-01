package com.tencent.mobileqq.qqexpand.manager.config;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.mobileqq.qqexpand.flutter.channel.JsonBean;
import java.util.ArrayList;
import java.util.List;

public class ExtendFriendABTestConfig$ExtendFriendABJson
  extends JsonBean
{
  private final List<ExtendFriendABTestConfig> grayPolicyInfoList = new ArrayList();
  private long reqTimestamp;
  
  public ExtendFriendABTestConfig$ExtendFriendABJson() {}
  
  public ExtendFriendABTestConfig$ExtendFriendABJson(List<ExtendFriendABTestConfig> paramList)
  {
    setGrayPolicyInfoList(paramList);
  }
  
  public static String getEmptyJson()
  {
    return getNoTimeStampGson().toJson(new ExtendFriendABJson());
  }
  
  public static Gson getNoTimeStampGson()
  {
    return new GsonBuilder().setExclusionStrategies(new ExclusionStrategy[] { new ExtendFriendABTestConfig.ExtendFriendABJson.1() }).create();
  }
  
  public List<ExtendFriendABTestConfig> getGrayPolicyInfoList()
  {
    return this.grayPolicyInfoList;
  }
  
  public long getReqTimestamp()
  {
    return this.reqTimestamp;
  }
  
  public void setGrayPolicyInfoList(List<ExtendFriendABTestConfig> paramList)
  {
    this.grayPolicyInfoList.clear();
    this.grayPolicyInfoList.addAll(paramList);
  }
  
  public void setReqTimestamp(long paramLong)
  {
    this.reqTimestamp = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.config.ExtendFriendABTestConfig.ExtendFriendABJson
 * JD-Core Version:    0.7.0.1
 */