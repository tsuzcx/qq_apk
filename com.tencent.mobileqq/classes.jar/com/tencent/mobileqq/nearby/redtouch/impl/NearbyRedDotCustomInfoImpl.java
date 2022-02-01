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
    return this.mNearbyRedDotCustomInfo.jdField_a_of_type_JavaLangString;
  }
  
  public int getContentType()
  {
    return this.mNearbyRedDotCustomInfo.jdField_b_of_type_Int;
  }
  
  public String getFaceUrl()
  {
    return this.mNearbyRedDotCustomInfo.d;
  }
  
  public boolean getIsOfficialNotify()
  {
    return this.mNearbyRedDotCustomInfo.jdField_b_of_type_Boolean;
  }
  
  public boolean getIsOfficialNum()
  {
    return this.mNearbyRedDotCustomInfo.jdField_a_of_type_Boolean;
  }
  
  public String getRecommendPeopleMsgId()
  {
    return this.mNearbyRedDotCustomInfo.jdField_c_of_type_JavaLangString;
  }
  
  public int getRedDotNum()
  {
    return this.mNearbyRedDotCustomInfo.jdField_a_of_type_Int;
  }
  
  public String getTopicId()
  {
    return this.mNearbyRedDotCustomInfo.jdField_b_of_type_JavaLangString;
  }
  
  public long getUin()
  {
    return this.mNearbyRedDotCustomInfo.jdField_a_of_type_Long;
  }
  
  public int getUserType()
  {
    return this.mNearbyRedDotCustomInfo.jdField_c_of_type_Int;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.impl.NearbyRedDotCustomInfoImpl
 * JD-Core Version:    0.7.0.1
 */