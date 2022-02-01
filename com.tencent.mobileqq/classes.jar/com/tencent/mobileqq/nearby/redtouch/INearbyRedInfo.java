package com.tencent.mobileqq.nearby.redtouch;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.List;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface INearbyRedInfo
  extends QRouteApi
{
  public abstract void addFaceUrl(String paramString, boolean paramBoolean);
  
  public abstract void addFaceUrl(List<String> paramList, boolean paramBoolean);
  
  public abstract void addRedNum(int paramInt);
  
  public abstract void addRedNum(String paramString);
  
  public abstract String getCornerInfo();
  
  public abstract int getRedAppIdType();
  
  public abstract int getRedNum();
  
  public abstract int getRedPointReportType();
  
  public abstract int getRedType();
  
  public abstract List<String> getRedUrl();
  
  public abstract String getTipTextInfo();
  
  public abstract void setCornerInfo(String paramString);
  
  public abstract void setRedAppIdType(int paramInt);
  
  public abstract void setRedPointReportType(int paramInt);
  
  public abstract void setRedType(int paramInt);
  
  public abstract void setTipTextInfo(String paramString);
  
  public abstract String toString();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo
 * JD-Core Version:    0.7.0.1
 */