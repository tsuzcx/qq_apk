package com.tencent.mobileqq.nearby.redtouch.impl;

import com.tencent.mobileqq.nearby.redtouch.INearbyRecommendPeopleInfo;
import com.tencent.mobileqq.nearby.redtouch.NearbyRecommendPeopleInfo;
import java.util.List;

public class NearbyRecommendPeopleInfoImpl
  implements INearbyRecommendPeopleInfo
{
  public List<Object> getLatestRecommendList()
  {
    return NearbyRecommendPeopleInfo.a();
  }
  
  public String getLatestRecommendMsgid()
  {
    return NearbyRecommendPeopleInfo.b();
  }
  
  public void setLatestRecommendList(String paramString, List<Object> paramList)
  {
    NearbyRecommendPeopleInfo.a(paramString, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.impl.NearbyRecommendPeopleInfoImpl
 * JD-Core Version:    0.7.0.1
 */