package com.tencent.qzonehub.api.protocol;

import LBS_V2_PROTOCOL.Cell_V2;
import LBS_V2_PROTOCOL.GPS_V2;
import LBS_V2_PROTOCOL.GeoInfo_V2;
import LBS_V2_PROTOCOL.GetLbsCombinReq_V2;
import LBS_V2_PROTOCOL.ReqCommon_V2;
import LBS_V2_PROTOCOL.Wifi_V2;
import com.qq.taf.jce.JceStruct;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.LbsDataV2.GeoInfo;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.QZoneCommonRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class GetCombinInfoRequest
  extends QZoneCommonRequest
{
  public int a;
  public JceStruct b;
  private LbsDataV2.GpsInfo c;
  private LbsDataV2.GeoInfo d;
  private int e;
  private int f;
  private int g;
  
  public GetCombinInfoRequest(GPS_V2 paramGPS_V2, GeoInfo_V2 paramGeoInfo_V2, ArrayList<Cell_V2> paramArrayList, ArrayList<Wifi_V2> paramArrayList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ArrayList<String> paramArrayList2, int paramInt5)
  {
    this.g = paramInt5;
    this.e = paramInt3;
    this.f = paramInt4;
    this.a = paramInt2;
    GetLbsCombinReq_V2 localGetLbsCombinReq_V2 = new GetLbsCombinReq_V2();
    ReqCommon_V2 localReqCommon_V2 = new ReqCommon_V2();
    localReqCommon_V2.iDeviceType = 1;
    localReqCommon_V2.iAppId = paramInt3;
    localGetLbsCombinReq_V2.stCommon = localReqCommon_V2;
    localGetLbsCombinReq_V2.stGps = paramGPS_V2;
    if (localGetLbsCombinReq_V2.stGps == null) {
      localGetLbsCombinReq_V2.stGps = new GPS_V2();
    }
    localGetLbsCombinReq_V2.vCellData = paramArrayList;
    localGetLbsCombinReq_V2.vWifiData = paramArrayList1;
    localGetLbsCombinReq_V2.iReqNum = 16;
    localGetLbsCombinReq_V2.iAccuracy = 0;
    localGetLbsCombinReq_V2.iMood = paramInt4;
    localGetLbsCombinReq_V2.iUserTime = ((int)(System.currentTimeMillis() / 1000L) + TimeZone.getDefault().getRawOffset());
    localGetLbsCombinReq_V2.iLocateCostTime = paramInt1;
    if (paramGeoInfo_V2 != null)
    {
      localGetLbsCombinReq_V2.stGeoInfo = paramGeoInfo_V2;
      if (localGetLbsCombinReq_V2.stGeoInfo.strCountry == null) {
        localGetLbsCombinReq_V2.stGeoInfo.strCountry = "";
      }
      if (localGetLbsCombinReq_V2.stGeoInfo.strProvince == null) {
        localGetLbsCombinReq_V2.stGeoInfo.strProvince = "";
      }
      if (localGetLbsCombinReq_V2.stGeoInfo.strCity == null) {
        localGetLbsCombinReq_V2.stGeoInfo.strCity = "";
      }
      if (localGetLbsCombinReq_V2.stGeoInfo.strDistrict == null) {
        localGetLbsCombinReq_V2.stGeoInfo.strDistrict = "";
      }
      if (localGetLbsCombinReq_V2.stGeoInfo.strTown == null) {
        localGetLbsCombinReq_V2.stGeoInfo.strTown = "";
      }
      if (localGetLbsCombinReq_V2.stGeoInfo.strVillage == null) {
        localGetLbsCombinReq_V2.stGeoInfo.strVillage = "";
      }
      if (localGetLbsCombinReq_V2.stGeoInfo.strRoad == null) {
        localGetLbsCombinReq_V2.stGeoInfo.strRoad = "";
      }
      if (localGetLbsCombinReq_V2.stGeoInfo.strDefaultName == null) {
        localGetLbsCombinReq_V2.stGeoInfo.strDefaultName = "";
      }
    }
    if ((paramArrayList2 != null) && (paramArrayList2.size() != 0))
    {
      paramGPS_V2 = new StringBuilder();
      paramInt1 = 0;
      while (paramInt1 < paramArrayList2.size())
      {
        if (paramInt1 != paramArrayList2.size() - 1)
        {
          paramGPS_V2.append((String)paramArrayList2.get(paramInt1));
          paramGPS_V2.append(",");
        }
        else
        {
          paramGPS_V2.append((String)paramArrayList2.get(paramInt1));
        }
        paramInt1 += 1;
      }
      QLog.d("GetCombinInfoRequest", 1, new Object[] { "GetCombinInfoRequest... label:", paramGPS_V2.toString() });
      localGetLbsCombinReq_V2.map_ext = new HashMap();
      localGetLbsCombinReq_V2.map_ext.put("recomTags", paramGPS_V2.toString());
    }
    this.b = localGetLbsCombinReq_V2;
  }
  
  public GetCombinInfoRequest(LbsDataV2.GpsInfo paramGpsInfo, LbsDataV2.GeoInfo paramGeoInfo, ArrayList<Cell_V2> paramArrayList, ArrayList<Wifi_V2> paramArrayList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ArrayList<String> paramArrayList2, int paramInt5)
  {
    this(LbsDataV2.convertToGPS_V2(paramGpsInfo), LbsDataV2.convertToGeoInfo_V2(paramGeoInfo), paramArrayList, paramArrayList1, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayList2, paramInt5);
    this.c = paramGpsInfo;
    this.d = paramGeoInfo;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getLbsCombin";
  }
  
  public JceStruct getReq()
  {
    return this.b;
  }
  
  public int getType()
  {
    return this.g;
  }
  
  public String uniKey()
  {
    return "getLbsCombin";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.protocol.GetCombinInfoRequest
 * JD-Core Version:    0.7.0.1
 */