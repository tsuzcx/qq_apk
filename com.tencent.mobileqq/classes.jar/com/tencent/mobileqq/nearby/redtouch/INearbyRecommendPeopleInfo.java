package com.tencent.mobileqq.nearby.redtouch;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.List;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface INearbyRecommendPeopleInfo
  extends QRouteApi
{
  public abstract List<Object> getLatestRecommendList();
  
  public abstract String getLatestRecommendMsgid();
  
  public abstract void setLatestRecommendList(String paramString, List<Object> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.INearbyRecommendPeopleInfo
 * JD-Core Version:    0.7.0.1
 */