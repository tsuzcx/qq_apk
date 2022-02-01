package com.tencent.mobileqq.nearby.redtouch.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.redtouch.INearbyOfficalReportHelper;
import com.tencent.mobileqq.nearby.redtouch.NearbyOfficalReportHelper;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class NearbyOfficalReportHelperImpl
  implements INearbyOfficalReportHelper
{
  public void reportLebaRedDotEvent(Object paramObject, String paramString1, String paramString2)
  {
    NearbyOfficalReportHelper.a().a((QQAppInterface)paramObject, paramString1, paramString2);
  }
  
  public void reportNearByRedDotEvent(Object paramObject, String paramString1, String paramString2)
  {
    NearbyOfficalReportHelper.a().a((INearbyAppInterface)paramObject, paramString1, paramString2);
  }
  
  public void reportRedDotReceive(Object paramObject1, Object paramObject2)
  {
    NearbyOfficalReportHelper.a().a((QQAppInterface)paramObject1, (oidb_0x791.RedDotInfo)paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.impl.NearbyOfficalReportHelperImpl
 * JD-Core Version:    0.7.0.1
 */