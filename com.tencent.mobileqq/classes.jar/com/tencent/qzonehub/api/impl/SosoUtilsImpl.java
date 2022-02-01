package com.tencent.qzonehub.api.impl;

import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qzonehub.api.ISosoUtils;
import cooperation.qzone.LbsDataV2.GpsInfo;

public class SosoUtilsImpl
  implements ISosoUtils
{
  public LbsDataV2.GpsInfo convertFromSoso(SosoLocation paramSosoLocation)
  {
    if (paramSosoLocation == null) {
      return null;
    }
    LbsDataV2.GpsInfo localGpsInfo = new LbsDataV2.GpsInfo();
    localGpsInfo.accuracy = ((int)paramSosoLocation.accuracy);
    localGpsInfo.alt = ((int)paramSosoLocation.altitude);
    if ((paramSosoLocation.mLon84 == 0.0D) && (paramSosoLocation.mLat84 == 0.0D))
    {
      localGpsInfo.gpsType = 1;
      localGpsInfo.lat = ((int)(paramSosoLocation.mLat02 * 1000000.0D));
      localGpsInfo.lon = ((int)(paramSosoLocation.mLon02 * 1000000.0D));
      return localGpsInfo;
    }
    localGpsInfo.gpsType = 0;
    localGpsInfo.lat = ((int)(paramSosoLocation.mLat84 * 1000000.0D));
    localGpsInfo.lon = ((int)(paramSosoLocation.mLon84 * 1000000.0D));
    return localGpsInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.SosoUtilsImpl
 * JD-Core Version:    0.7.0.1
 */