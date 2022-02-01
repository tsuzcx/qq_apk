package com.tencent.mobileqq.nearby.redtouch;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface INearbyRedDotCustomInfo
  extends QRouteApi
{
  public abstract String getContentMsg();
  
  public abstract int getContentType();
  
  public abstract String getFaceUrl();
  
  public abstract boolean getIsOfficialNotify();
  
  public abstract boolean getIsOfficialNum();
  
  public abstract String getRecommendPeopleMsgId();
  
  public abstract int getRedDotNum();
  
  public abstract String getTopicId();
  
  public abstract long getUin();
  
  public abstract int getUserType();
  
  public abstract void parse(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo);
  
  public abstract void parse(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.INearbyRedDotCustomInfo
 * JD-Core Version:    0.7.0.1
 */