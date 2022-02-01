package cooperation.qqcircle.lbs.protocol;

import LBS_V2_PROTOCOL.Cell_V2;
import LBS_V2_PROTOCOL.GPS_V2;
import LBS_V2_PROTOCOL.GeoInfo_V2;
import LBS_V2_PROTOCOL.GetLbsCombinReq_V2;
import LBS_V2_PROTOCOL.ReqCommon_V2;
import LBS_V2_PROTOCOL.Wifi_V2;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.LbsDataV2.GeoInfo;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.QZoneCommonRequest;
import cooperation.qzone.model.LocalImageShootInfo;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class GetCombinInfoRequest
  extends QZoneCommonRequest
{
  private static final String CMD = "getLbsCombin";
  private int appId;
  public int eventId;
  private LbsDataV2.GeoInfo geo;
  private LbsDataV2.GpsInfo gps;
  public LocalImageShootInfo gpsImageInfo;
  private int mode;
  public JceStruct req;
  private int type;
  
  public GetCombinInfoRequest(GPS_V2 paramGPS_V2, GeoInfo_V2 paramGeoInfo_V2, ArrayList<Cell_V2> paramArrayList, ArrayList<Wifi_V2> paramArrayList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ArrayList<String> paramArrayList2, int paramInt5)
  {
    this.type = paramInt5;
    this.appId = paramInt3;
    this.mode = paramInt4;
    this.eventId = paramInt2;
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
      if (paramInt1 < paramArrayList2.size())
      {
        if (paramInt1 != paramArrayList2.size() - 1) {
          paramGPS_V2.append((String)paramArrayList2.get(paramInt1)).append(",");
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          paramGPS_V2.append((String)paramArrayList2.get(paramInt1));
        }
      }
      QZLog.d("GetCombinInfoRequest", 1, new Object[] { "GetCombinInfoRequest... label:", paramGPS_V2.toString() });
      localGetLbsCombinReq_V2.map_ext = new HashMap();
      localGetLbsCombinReq_V2.map_ext.put("recomTags", paramGPS_V2.toString());
    }
    this.req = localGetLbsCombinReq_V2;
  }
  
  public GetCombinInfoRequest(LbsDataV2.GpsInfo paramGpsInfo, LbsDataV2.GeoInfo paramGeoInfo, long paramLong, int paramInt1, int paramInt2, int paramInt3, ArrayList<String> paramArrayList, int paramInt4)
  {
    this.type = paramInt4;
    this.gps = paramGpsInfo;
    this.geo = paramGeoInfo;
    this.appId = paramInt2;
    this.mode = paramInt3;
    this.eventId = paramInt1;
    GetLbsCombinReq_V2 localGetLbsCombinReq_V2 = new GetLbsCombinReq_V2();
    ReqCommon_V2 localReqCommon_V2 = new ReqCommon_V2();
    localReqCommon_V2.iDeviceType = 1;
    localReqCommon_V2.iAppId = paramInt2;
    localGetLbsCombinReq_V2.stCommon = localReqCommon_V2;
    localGetLbsCombinReq_V2.stGps = LbsDataV2.convertToGPS_V2(paramGpsInfo);
    if (localGetLbsCombinReq_V2.stGps == null) {
      localGetLbsCombinReq_V2.stGps = new GPS_V2();
    }
    localGetLbsCombinReq_V2.iReqNum = 16;
    localGetLbsCombinReq_V2.iMood = paramInt3;
    localGetLbsCombinReq_V2.iUserTime = ((int)(System.currentTimeMillis() / 1000L) + TimeZone.getDefault().getRawOffset());
    if (paramGeoInfo != null)
    {
      localGetLbsCombinReq_V2.stGeoInfo = LbsDataV2.convertToGeoInfo_V2(paramGeoInfo);
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
    if (paramLong != 0L)
    {
      paramGpsInfo = new java.sql.Date(paramLong);
      paramGeoInfo = Calendar.getInstance();
      paramGeoInfo.setTime(paramGpsInfo);
      localGetLbsCombinReq_V2.stUserDate = new LBS_V2_PROTOCOL.Date();
      localGetLbsCombinReq_V2.stUserDate._year = ((short)paramGeoInfo.get(1));
      localGetLbsCombinReq_V2.stUserDate._mon = ((short)(paramGeoInfo.get(2) + 1));
      localGetLbsCombinReq_V2.stUserDate._day = ((short)paramGeoInfo.get(5));
    }
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      paramGpsInfo = new StringBuilder();
      paramInt1 = 0;
      if (paramInt1 < paramArrayList.size())
      {
        if (paramInt1 != paramArrayList.size() - 1) {
          paramGpsInfo.append((String)paramArrayList.get(paramInt1)).append(",");
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          paramGpsInfo.append((String)paramArrayList.get(paramInt1));
        }
      }
      QZLog.d("GetCombinInfoRequest", 1, new Object[] { "GetCombinInfoRequest... label:", paramGpsInfo.toString() });
      localGetLbsCombinReq_V2.map_ext = new HashMap();
      localGetLbsCombinReq_V2.map_ext.put("recomTags", paramGpsInfo.toString());
    }
    this.req = localGetLbsCombinReq_V2;
  }
  
  public GetCombinInfoRequest(LbsDataV2.GpsInfo paramGpsInfo, LbsDataV2.GeoInfo paramGeoInfo, ArrayList<Cell_V2> paramArrayList, ArrayList<Wifi_V2> paramArrayList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ArrayList<String> paramArrayList2, int paramInt5)
  {
    this(LbsDataV2.convertToGPS_V2(paramGpsInfo), LbsDataV2.convertToGeoInfo_V2(paramGeoInfo), paramArrayList, paramArrayList1, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayList2, paramInt5);
    this.gps = paramGpsInfo;
    this.geo = paramGeoInfo;
  }
  
  public int getAppId()
  {
    return this.appId;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getLbsCombin";
  }
  
  public LbsDataV2.GeoInfo getGeoBody()
  {
    return this.geo;
  }
  
  public LbsDataV2.GpsInfo getGps()
  {
    return this.gps;
  }
  
  public int getMode()
  {
    return this.mode;
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setGepsImageInfo(LocalImageShootInfo paramLocalImageShootInfo)
  {
    this.gpsImageInfo = paramLocalImageShootInfo;
  }
  
  public String uniKey()
  {
    return "getLbsCombin";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.lbs.protocol.GetCombinInfoRequest
 * JD-Core Version:    0.7.0.1
 */