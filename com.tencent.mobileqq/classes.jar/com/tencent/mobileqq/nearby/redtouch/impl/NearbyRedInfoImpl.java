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
    return this.mNearbyRedInfo.i;
  }
  
  public int getRedAppIdType()
  {
    return this.mNearbyRedInfo.h;
  }
  
  public int getRedNum()
  {
    return this.mNearbyRedInfo.c;
  }
  
  public int getRedPointReportType()
  {
    return this.mNearbyRedInfo.g;
  }
  
  public int getRedType()
  {
    return this.mNearbyRedInfo.b;
  }
  
  public List<String> getRedUrl()
  {
    return this.mNearbyRedInfo.e;
  }
  
  public String getTipTextInfo()
  {
    return this.mNearbyRedInfo.j;
  }
  
  public void setCornerInfo(String paramString)
  {
    this.mNearbyRedInfo.i = paramString;
  }
  
  public void setRedAppIdType(int paramInt)
  {
    this.mNearbyRedInfo.h = paramInt;
  }
  
  public void setRedPointReportType(int paramInt)
  {
    this.mNearbyRedInfo.g = paramInt;
  }
  
  public void setRedType(int paramInt)
  {
    this.mNearbyRedInfo.a(paramInt);
  }
  
  public void setTipTextInfo(String paramString)
  {
    this.mNearbyRedInfo.j = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.impl.NearbyRedInfoImpl
 * JD-Core Version:    0.7.0.1
 */