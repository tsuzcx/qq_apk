package com.tencent.qzonehub.api.impl;

import com.tencent.qzonehub.api.IQZoneJustLocationApi;
import com.tencent.qzonehub.api.lbs.QZoneJustLocationProxy;
import cooperation.qzone.LbsDataV2.GpsInfo;

public class QZoneJustLocationApiImpl
  implements IQZoneJustLocationApi
{
  public LbsDataV2.GpsInfo getCurrGps(String paramString)
  {
    return QZoneJustLocationProxy.a(paramString).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QZoneJustLocationApiImpl
 * JD-Core Version:    0.7.0.1
 */