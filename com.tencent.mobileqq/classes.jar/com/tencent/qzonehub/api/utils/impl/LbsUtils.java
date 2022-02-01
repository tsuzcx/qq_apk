package com.tencent.qzonehub.api.utils.impl;

import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.model.GpsInfo4LocalImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LbsUtils
{
  public static LbsDataV2.GpsInfo a(GpsInfo4LocalImage paramGpsInfo4LocalImage)
  {
    if (paramGpsInfo4LocalImage == null) {
      return null;
    }
    LbsDataV2.GpsInfo localGpsInfo = new LbsDataV2.GpsInfo();
    localGpsInfo.gpsType = 0;
    localGpsInfo.alt = 0;
    localGpsInfo.lat = ((int)(paramGpsInfo4LocalImage.latitude * 1000000.0F));
    localGpsInfo.lon = ((int)(paramGpsInfo4LocalImage.longtitude * 1000000.0F));
    return localGpsInfo;
  }
  
  public static ArrayList<LbsDataV2.GpsInfo> a(List<GpsInfo4LocalImage> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((GpsInfo4LocalImage)paramList.next()));
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qzonehub.api.utils.impl.LbsUtils
 * JD-Core Version:    0.7.0.1
 */