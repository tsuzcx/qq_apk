package com.tencent.mobileqq.nearby.redtouch.impl;

import com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo;
import com.tencent.mobileqq.nearby.redtouch.NearbyRedInfo;
import java.util.List;

public class NearbyRedInfoImpl
  implements INearbyRedInfo
{
  private final NearbyRedInfo mNearbyRedInfo = new NearbyRedInfo();
  
  public void addFaceUrl(String paramString, boolean paramBoolean)
  {
    this.mNearbyRedInfo.a(paramString, paramBoolean);
  }
  
  public void addFaceUrl(List<String> paramList, boolean paramBoolean)
  {
    this.mNearbyRedInfo.a(paramList, paramBoolean);
  }
  
  public void addRedNum(int paramInt)
  {
    this.mNearbyRedInfo.b(paramInt);
  }
  
  public void addRedNum(String paramString)
  {
    this.mNearbyRedInfo.a(paramString);
  }
  
  public String getCornerInfo()
  {
    return this.mNearbyRedInfo.jdField_b_of_type_JavaLangString;
  }
  
  public int getRedAppIdType()
  {
    return this.mNearbyRedInfo.d;
  }
  
  public int getRedNum()
  {
    return this.mNearbyRedInfo.jdField_b_of_type_Int;
  }
  
  public int getRedPointReportType()
  {
    return this.mNearbyRedInfo.jdField_c_of_type_Int;
  }
  
  public int getRedType()
  {
    return this.mNearbyRedInfo.jdField_a_of_type_Int;
  }
  
  public List<String> getRedUrl()
  {
    return this.mNearbyRedInfo.jdField_a_of_type_JavaUtilList;
  }
  
  public String getTipTextInfo()
  {
    return this.mNearbyRedInfo.jdField_c_of_type_JavaLangString;
  }
  
  public void setCornerInfo(String paramString)
  {
    this.mNearbyRedInfo.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setRedAppIdType(int paramInt)
  {
    this.mNearbyRedInfo.d = paramInt;
  }
  
  public void setRedPointReportType(int paramInt)
  {
    this.mNearbyRedInfo.jdField_c_of_type_Int = paramInt;
  }
  
  public void setRedType(int paramInt)
  {
    this.mNearbyRedInfo.a(paramInt);
  }
  
  public void setTipTextInfo(String paramString)
  {
    this.mNearbyRedInfo.jdField_c_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.impl.NearbyRedInfoImpl
 * JD-Core Version:    0.7.0.1
 */