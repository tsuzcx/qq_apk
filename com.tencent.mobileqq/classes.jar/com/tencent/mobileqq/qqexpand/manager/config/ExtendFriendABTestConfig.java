package com.tencent.mobileqq.qqexpand.manager.config;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qqexpand.flutter.channel.JsonBean;
import expand.network.ExtendFriendABTestConfig.ExtendFriendParamsInfo;
import expand.network.ExtendFriendABTestConfig.GrayPolicyInfo;
import java.util.ArrayList;
import java.util.List;

public class ExtendFriendABTestConfig
  extends JsonBean
{
  public static final int INTERVAL_TIME_HOUR = 24;
  private String expKey;
  private String grayPolicyId;
  private final List<ExtendFriendABTestConfig.ParamsInfo> paramsInfoList = new ArrayList();
  private String sGroupKey;
  private String sStrategyType;
  
  public ExtendFriendABTestConfig() {}
  
  public ExtendFriendABTestConfig(String paramString1, List<ExtendFriendABTestConfig.ParamsInfo> paramList, String paramString2, String paramString3, String paramString4)
  {
    this.grayPolicyId = paramString1;
    this.sGroupKey = paramString2;
    this.sStrategyType = paramString3;
    this.expKey = paramString4;
    this.paramsInfoList.addAll(paramList);
  }
  
  public static ExtendFriendABTestConfig.ExtendFriendABJson buildConfigJson(List<ExtendFriendABTestConfig> paramList)
  {
    return new ExtendFriendABTestConfig.ExtendFriendABJson(paramList);
  }
  
  public static List<ExtendFriendABTestConfig> buildConfigList(List<ExtendFriendABTestConfig.GrayPolicyInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      int k = paramList.size();
      ArrayList localArrayList1 = new ArrayList();
      int i = 0;
      while (i < k)
      {
        ExtendFriendABTestConfig.GrayPolicyInfo localGrayPolicyInfo = (ExtendFriendABTestConfig.GrayPolicyInfo)paramList.get(i);
        PBRepeatMessageField localPBRepeatMessageField = localGrayPolicyInfo.paramsInfoList;
        int m = localPBRepeatMessageField.size();
        ArrayList localArrayList2 = new ArrayList();
        if (m > 0)
        {
          int j = 0;
          while (j < m)
          {
            localArrayList2.add(new ExtendFriendABTestConfig.ParamsInfo((ExtendFriendABTestConfig.ExtendFriendParamsInfo)localPBRepeatMessageField.get(j)));
            j += 1;
          }
        }
        localArrayList1.add(new ExtendFriendABTestConfig(localGrayPolicyInfo.grayPolicyId.get(), localArrayList2, localGrayPolicyInfo.sGroupKey.get(), localGrayPolicyInfo.sStrategyType.get(), localGrayPolicyInfo.expKey.get()));
        i += 1;
      }
      return localArrayList1;
    }
    return new ArrayList();
  }
  
  public String getExpKey()
  {
    return this.expKey;
  }
  
  public String getGrayPolicyId()
  {
    return this.grayPolicyId;
  }
  
  public List<ExtendFriendABTestConfig.ParamsInfo> getParamsInfoList()
  {
    return this.paramsInfoList;
  }
  
  public String getsGroupKey()
  {
    return this.sGroupKey;
  }
  
  public String getsStrategyType()
  {
    return this.sStrategyType;
  }
  
  public void setExpKey(String paramString)
  {
    this.expKey = paramString;
  }
  
  public void setGrayPolicyId(String paramString)
  {
    this.grayPolicyId = paramString;
  }
  
  public void setParamsInfoList(List<ExtendFriendABTestConfig.ParamsInfo> paramList)
  {
    this.paramsInfoList.clear();
    this.paramsInfoList.addAll(paramList);
  }
  
  public void setsGroupKey(String paramString)
  {
    this.sGroupKey = paramString;
  }
  
  public void setsStrategyType(String paramString)
  {
    this.sStrategyType = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.config.ExtendFriendABTestConfig
 * JD-Core Version:    0.7.0.1
 */