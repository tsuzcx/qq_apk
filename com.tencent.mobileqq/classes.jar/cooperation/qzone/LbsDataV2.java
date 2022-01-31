package cooperation.qzone;

import LBS_V2_PROTOCOL.Cell_V2;
import LBS_V2_PROTOCOL.GPS_V2;
import LBS_V2_PROTOCOL.GeoInfo_V2;
import LBS_V2_PROTOCOL.PoiInfo_V2;
import LBS_V2_PROTOCOL.Wifi_V2;
import NS_MOBILE_OPERATION.LbsInfo;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.LocalImageShootInfo;
import java.util.ArrayList;
import java.util.List;

public class LbsDataV2
{
  public static int GPS_DEFAULT_VALUE = 900000000;
  public static int LBS_REQUEST_APPID = 12103;
  public static int POI_DEFAULT_DISTANCE = 500;
  
  public static LbsDataV2.GpsInfo convertFromSoso(SosoInterface.SosoLocation paramSosoLocation)
  {
    if (paramSosoLocation == null) {
      return null;
    }
    LbsDataV2.GpsInfo localGpsInfo = new LbsDataV2.GpsInfo();
    localGpsInfo.accuracy = ((int)paramSosoLocation.jdField_a_of_type_Float);
    localGpsInfo.alt = ((int)paramSosoLocation.jdField_e_of_type_Double);
    if ((paramSosoLocation.jdField_d_of_type_Double == 0.0D) && (paramSosoLocation.jdField_c_of_type_Double == 0.0D))
    {
      localGpsInfo.gpsType = 1;
      localGpsInfo.lat = ((int)(paramSosoLocation.jdField_a_of_type_Double * 1000000.0D));
      localGpsInfo.lon = ((int)(paramSosoLocation.b * 1000000.0D));
      return localGpsInfo;
    }
    localGpsInfo.gpsType = 0;
    localGpsInfo.lat = ((int)(paramSosoLocation.jdField_c_of_type_Double * 1000000.0D));
    localGpsInfo.lon = ((int)(paramSosoLocation.jdField_d_of_type_Double * 1000000.0D));
    return localGpsInfo;
  }
  
  public static Cell_V2 convertToCell_V2(LbsDataV2.CellInfo paramCellInfo)
  {
    if (paramCellInfo == null) {
      return null;
    }
    Cell_V2 localCell_V2 = new Cell_V2();
    localCell_V2.shMcc = ((short)paramCellInfo.mcc);
    localCell_V2.shMnc = ((short)paramCellInfo.mnc);
    localCell_V2.iLac = paramCellInfo.lac;
    localCell_V2.iCellId = paramCellInfo.cellId;
    localCell_V2.iRssi = paramCellInfo.rssi;
    localCell_V2.dStationLat = paramCellInfo.stationLat;
    localCell_V2.dStationLon = paramCellInfo.stationLon;
    return localCell_V2;
  }
  
  public static GPS_V2 convertToGPS_V2(LbsDataV2.GpsInfo paramGpsInfo)
  {
    GPS_V2 localGPS_V2 = new GPS_V2();
    if (paramGpsInfo != null)
    {
      localGPS_V2.eType = paramGpsInfo.gpsType;
      localGPS_V2.iAlt = paramGpsInfo.alt;
      localGPS_V2.iLat = paramGpsInfo.lat;
      localGPS_V2.iLon = paramGpsInfo.lon;
    }
    return localGPS_V2;
  }
  
  public static LbsDataV2.GeoInfo convertToGeoInfo(GeoInfo_V2 paramGeoInfo_V2)
  {
    LbsDataV2.GeoInfo localGeoInfo = new LbsDataV2.GeoInfo();
    if (paramGeoInfo_V2 != null)
    {
      localGeoInfo.iDistrictCode = paramGeoInfo_V2.iDistrictCode;
      localGeoInfo.iRange = paramGeoInfo_V2.iRange;
      localGeoInfo.strCountry = paramGeoInfo_V2.strCountry;
      localGeoInfo.strProvince = paramGeoInfo_V2.strProvince;
      localGeoInfo.strCity = paramGeoInfo_V2.strCity;
      localGeoInfo.strDistrict = paramGeoInfo_V2.strDistrict;
      localGeoInfo.strTown = paramGeoInfo_V2.strTown;
      localGeoInfo.strVillage = paramGeoInfo_V2.strVillage;
      localGeoInfo.strRoad = paramGeoInfo_V2.strRoad;
      localGeoInfo.strDefaultName = paramGeoInfo_V2.strDefaultName;
    }
    return localGeoInfo;
  }
  
  public static LbsDataV2.GeoInfo convertToGeoInfo(GeoInfo_V2 paramGeoInfo_V2, GPS_V2 paramGPS_V2)
  {
    LbsDataV2.GeoInfo localGeoInfo = new LbsDataV2.GeoInfo();
    if (paramGeoInfo_V2 != null)
    {
      localGeoInfo.iDistrictCode = paramGeoInfo_V2.iDistrictCode;
      localGeoInfo.iRange = paramGeoInfo_V2.iRange;
      localGeoInfo.strCountry = paramGeoInfo_V2.strCountry;
      localGeoInfo.strProvince = paramGeoInfo_V2.strProvince;
      localGeoInfo.strCity = paramGeoInfo_V2.strCity;
      localGeoInfo.strDistrict = paramGeoInfo_V2.strDistrict;
      localGeoInfo.strTown = paramGeoInfo_V2.strTown;
      localGeoInfo.strVillage = paramGeoInfo_V2.strVillage;
      localGeoInfo.strRoad = paramGeoInfo_V2.strRoad;
      localGeoInfo.strDefaultName = paramGeoInfo_V2.strDefaultName;
    }
    localGeoInfo.gpsInfo = convertToGpsInfo(paramGPS_V2);
    return localGeoInfo;
  }
  
  public static GeoInfo_V2 convertToGeoInfo_V2(LbsDataV2.GeoInfo paramGeoInfo)
  {
    GeoInfo_V2 localGeoInfo_V2 = new GeoInfo_V2();
    if (paramGeoInfo != null)
    {
      localGeoInfo_V2.iDistrictCode = paramGeoInfo.iDistrictCode;
      localGeoInfo_V2.iRange = paramGeoInfo.iRange;
      localGeoInfo_V2.strCountry = paramGeoInfo.strCountry;
      localGeoInfo_V2.strProvince = paramGeoInfo.strProvince;
      localGeoInfo_V2.strCity = paramGeoInfo.strCity;
      localGeoInfo_V2.strDistrict = paramGeoInfo.strDistrict;
      localGeoInfo_V2.strTown = paramGeoInfo.strTown;
      localGeoInfo_V2.strVillage = paramGeoInfo.strVillage;
      localGeoInfo_V2.strRoad = paramGeoInfo.strRoad;
      localGeoInfo_V2.strDefaultName = paramGeoInfo.strDefaultName;
    }
    return localGeoInfo_V2;
  }
  
  public static LbsDataV2.GpsInfo convertToGpsInfo(GPS_V2 paramGPS_V2)
  {
    LbsDataV2.GpsInfo localGpsInfo = new LbsDataV2.GpsInfo();
    if (paramGPS_V2 != null)
    {
      localGpsInfo.gpsType = paramGPS_V2.eType;
      localGpsInfo.alt = paramGPS_V2.iAlt;
      localGpsInfo.lat = paramGPS_V2.iLat;
      localGpsInfo.lon = paramGPS_V2.iLon;
    }
    return localGpsInfo;
  }
  
  public static LbsDataV2.PoiInfo convertToPoiInfo(PoiInfo_V2 paramPoiInfo_V2)
  {
    LbsDataV2.PoiInfo localPoiInfo = new LbsDataV2.PoiInfo();
    if (paramPoiInfo_V2 != null)
    {
      localPoiInfo.address = paramPoiInfo_V2.strAddress;
      localPoiInfo.gpsInfo = convertToGpsInfo(paramPoiInfo_V2.stGps);
      localPoiInfo.city = paramPoiInfo_V2.strCity;
      localPoiInfo.country = paramPoiInfo_V2.strCity;
      localPoiInfo.districtCode = paramPoiInfo_V2.iDistrictCode;
      localPoiInfo.district = paramPoiInfo_V2.strDistrict;
      localPoiInfo.province = paramPoiInfo_V2.strProvince;
      localPoiInfo.distance = paramPoiInfo_V2.iDistance;
      localPoiInfo.poiId = paramPoiInfo_V2.strPoiId;
      localPoiInfo.poiName = paramPoiInfo_V2.strName;
      localPoiInfo.poiOrderType = paramPoiInfo_V2.iPoiOrderType;
      localPoiInfo.poiNum = paramPoiInfo_V2.iPoiNum;
      localPoiInfo.hotValue = paramPoiInfo_V2.iHotValue;
      localPoiInfo.phoneNumber = paramPoiInfo_V2.strPhone;
      localPoiInfo.poiDefaultName = paramPoiInfo_V2.strDefaultName;
      localPoiInfo.dianPingId = paramPoiInfo_V2.strDianPingId;
    }
    return localPoiInfo;
  }
  
  public static Wifi_V2 convertToWifi_V2(LbsDataV2.WifiInfo paramWifiInfo)
  {
    if (paramWifiInfo == null) {
      return null;
    }
    Wifi_V2 localWifi_V2 = new Wifi_V2();
    localWifi_V2.strMac = paramWifiInfo.mac;
    localWifi_V2.iRssi = paramWifiInfo.rssi;
    return localWifi_V2;
  }
  
  public static LbsDataV2.CellInfo covertToCellInfo(Cell_V2 paramCell_V2)
  {
    if (paramCell_V2 == null) {
      return null;
    }
    LbsDataV2.CellInfo localCellInfo = new LbsDataV2.CellInfo();
    localCellInfo.mcc = paramCell_V2.shMcc;
    localCellInfo.mnc = paramCell_V2.shMnc;
    localCellInfo.lac = paramCell_V2.iLac;
    localCellInfo.cellId = paramCell_V2.iCellId;
    localCellInfo.rssi = paramCell_V2.iRssi;
    localCellInfo.stationLat = paramCell_V2.dStationLat;
    localCellInfo.stationLon = paramCell_V2.dStationLon;
    return localCellInfo;
  }
  
  public static ArrayList fromSosoLocation(SosoInterface.SosoLocation paramSosoLocation)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramSosoLocation != null) && (paramSosoLocation.jdField_a_of_type_JavaUtilList != null) && (!paramSosoLocation.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      int i = 0;
      while (i < paramSosoLocation.jdField_a_of_type_JavaUtilList.size())
      {
        LbsDataV2.PoiInfo localPoiInfo = fromTencentPoi((TencentPoi)paramSosoLocation.jdField_a_of_type_JavaUtilList.get(i));
        localPoiInfo.country = paramSosoLocation.jdField_c_of_type_JavaLangString;
        localPoiInfo.province = paramSosoLocation.jdField_d_of_type_JavaLangString;
        localPoiInfo.city = paramSosoLocation.jdField_e_of_type_JavaLangString;
        localPoiInfo.district = paramSosoLocation.g;
        localArrayList.add(localPoiInfo);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static LbsDataV2.PoiInfo fromTencentPoi(TencentPoi paramTencentPoi)
  {
    LbsDataV2.PoiInfo localPoiInfo = new LbsDataV2.PoiInfo();
    if (paramTencentPoi != null) {
      localPoiInfo.address = paramTencentPoi.getAddress();
    }
    try
    {
      double d1 = paramTencentPoi.getLatitude();
      double d2 = paramTencentPoi.getLongitude();
      localPoiInfo.gpsInfo = new LbsDataV2.GpsInfo();
      localPoiInfo.gpsInfo.lat = ((int)(d1 * 1000000.0D));
      localPoiInfo.gpsInfo.lon = ((int)(d2 * 1000000.0D));
      localPoiInfo.gpsInfo.accuracy = -1;
      localPoiInfo.poiTypeName = paramTencentPoi.getCatalog();
      localPoiInfo.distance = ((int)paramTencentPoi.getDistance());
      localPoiInfo.poiId = paramTencentPoi.getUid();
      localPoiInfo.poiName = paramTencentPoi.getName();
      localPoiInfo.poiDefaultName = paramTencentPoi.getName();
      return localPoiInfo;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localPoiInfo.gpsInfo = null;
      }
    }
  }
  
  public static LbsInfo parceToLbsInfo(LbsDataV2.PoiInfo paramPoiInfo)
  {
    if (paramPoiInfo == null) {
      return null;
    }
    LbsInfo localLbsInfo = new LbsInfo();
    if (paramPoiInfo.gpsInfo != null)
    {
      localLbsInfo.lbs_x = String.valueOf(paramPoiInfo.gpsInfo.lon / 1000000.0D);
      localLbsInfo.lbs_y = String.valueOf(paramPoiInfo.gpsInfo.lat / 1000000.0D);
    }
    localLbsInfo.lbs_idnm = paramPoiInfo.poiDefaultName;
    if (TextUtils.isEmpty(localLbsInfo.lbs_idnm)) {
      localLbsInfo.lbs_idnm = paramPoiInfo.poiName;
    }
    localLbsInfo.lbs_nm = paramPoiInfo.address;
    localLbsInfo.s_lbs_id = paramPoiInfo.poiId;
    localLbsInfo.i_poi_num = paramPoiInfo.poiNum;
    localLbsInfo.i_poi_order_type = paramPoiInfo.poiOrderType;
    localLbsInfo.i_poi_type = paramPoiInfo.poiType;
    try
    {
      localLbsInfo.lbs_id = Integer.parseInt(paramPoiInfo.poiId);
      return localLbsInfo;
    }
    catch (Exception paramPoiInfo)
    {
      paramPoiInfo.printStackTrace();
    }
    return localLbsInfo;
  }
  
  public static LbsInfo parceToLbsInfo(LocalImageShootInfo paramLocalImageShootInfo)
  {
    Object localObject;
    if (paramLocalImageShootInfo == null) {
      localObject = null;
    }
    LbsInfo localLbsInfo;
    do
    {
      return localObject;
      localLbsInfo = new LbsInfo();
      localObject = localLbsInfo;
    } while (paramLocalImageShootInfo.a == null);
    localLbsInfo.lbs_x = String.valueOf(paramLocalImageShootInfo.a.b);
    localLbsInfo.lbs_y = String.valueOf(paramLocalImageShootInfo.a.jdField_a_of_type_Float);
    return localLbsInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.LbsDataV2
 * JD-Core Version:    0.7.0.1
 */