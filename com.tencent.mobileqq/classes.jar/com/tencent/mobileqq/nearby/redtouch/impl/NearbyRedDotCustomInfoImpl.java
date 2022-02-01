package com.tencent.mobileqq.nearby.redtouch.impl;

import com.tencent.mobileqq.nearby.redtouch.INearbyRedDotCustomInfo;
import com.tencent.mobileqq.nearby.redtouch.NearbyRedDotCustomInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class NearbyRedDotCustomInfoImpl
  implements INearbyRedDotCustomInfo
{
  private final NearbyRedDotCustomInfo mNearbyRedDotCustomInfo = new NearbyRedDotCustomInfo();
  
  public String getContentMsg()
  {
    return this.mNearbyRedDotCustomInfo.f;
  }
  
  public int getContentType()
  {
    return this.mNearbyRedDotCustomInfo.d;
  }
  
  public String getFaceUrl()
  {
    return this.mNearbyRedDotCustomInfo.i;
  }
  
  public boolean getIsOfficialNotify()
  {
    return this.mNearbyRedDotCustomInfo.c;
  }
  
  public boolean getIsOfficialNum()
  {
    return this.mNearbyRedDotCustomInfo.b;
  }
  
  public String getRecommendPeopleMsgId()
  {
    return this.mNearbyRedDotCustomInfo.h;
  }
  
  public int getRedDotNum()
  {
    return this.mNearbyRedDotCustomInfo.a;
  }
  
  public String getTopicId()
  {
    return this.mNearbyRedDotCustomInfo.g;
  }
  
  public long getUin()
  {
    return this.mNearbyRedDotCustomInfo.j;
  }
  
  public int getUserType()
  {
    return this.mNearbyRedDotCustomInfo.e;
  }
  
  public void parse(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    this.mNearbyRedDotCustomInfo.a(paramRedTypeInfo);
  }
  
  public void parse(Object paramObject)
  {
    this.mNearbyRedDotCustomInfo.a((oidb_0x791.RedDotInfo)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.impl.NearbyRedDotCustomInfoImpl
 * JD-Core Version:    0.7.0.1
 */