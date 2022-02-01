package com.tencent.mobileqq.nearby.api;

import NearbyGroup.LBSInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

@QAPI(process={"all"})
public abstract interface ILbsUtils
  extends QRouteApi
{
  public abstract LBSInfo createLbsInfo(boolean paramBoolean, SosoLbsInfo paramSosoLbsInfo);
  
  public abstract Object getLbsInfo(String paramString);
  
  public abstract LBSInfo getRawLbsInfo();
  
  public abstract String lbsInfoToString(SosoLbsInfo paramSosoLbsInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.ILbsUtils
 * JD-Core Version:    0.7.0.1
 */