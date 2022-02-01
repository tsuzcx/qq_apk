package cooperation.qqcircle.lbs.protocol;

import LBS_V2_PROTOCOL.Cell_V2;
import LBS_V2_PROTOCOL.GPS_V2;
import LBS_V2_PROTOCOL.GetPoiInfoReq_V2;
import LBS_V2_PROTOCOL.ReqCommon_V2;
import LBS_V2_PROTOCOL.Wifi_V2;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.QZoneCommonRequest;
import java.util.ArrayList;

public class GetPoiListRequset
  extends QZoneCommonRequest
{
  private static final String CMD = "getPoiList";
  public JceStruct req;
  private int type;
  
  public GetPoiListRequset(GPS_V2 paramGPS_V2, ArrayList<Cell_V2> paramArrayList, ArrayList<Wifi_V2> paramArrayList1, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.type = paramInt2;
    GetPoiInfoReq_V2 localGetPoiInfoReq_V2 = new GetPoiInfoReq_V2();
    ReqCommon_V2 localReqCommon_V2 = new ReqCommon_V2();
    localReqCommon_V2.iDeviceType = 1;
    localReqCommon_V2.iAppId = paramInt1;
    localGetPoiInfoReq_V2.stCommon = localReqCommon_V2;
    localGetPoiInfoReq_V2.stGps = paramGPS_V2;
    if (localGetPoiInfoReq_V2.stGps == null) {
      localGetPoiInfoReq_V2.stGps = new GPS_V2();
    }
    localGetPoiInfoReq_V2.vCellData = paramArrayList;
    localGetPoiInfoReq_V2.vWifiData = paramArrayList1;
    paramGPS_V2 = paramString1;
    if (paramString1 == null) {
      paramGPS_V2 = "";
    }
    localGetPoiInfoReq_V2.strKeyWord = paramGPS_V2;
    localGetPoiInfoReq_V2.iDistance = 500;
    localGetPoiInfoReq_V2.iAccuracy = 0;
    localGetPoiInfoReq_V2.strAttachInfo = paramString2;
    this.req = localGetPoiInfoReq_V2;
  }
  
  public GetPoiListRequset(LbsDataV2.GpsInfo paramGpsInfo, ArrayList<Cell_V2> paramArrayList, ArrayList<Wifi_V2> paramArrayList1, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.type = paramInt2;
    GetPoiInfoReq_V2 localGetPoiInfoReq_V2 = new GetPoiInfoReq_V2();
    ReqCommon_V2 localReqCommon_V2 = new ReqCommon_V2();
    localReqCommon_V2.iDeviceType = 1;
    localReqCommon_V2.iAppId = paramInt1;
    localGetPoiInfoReq_V2.stCommon = localReqCommon_V2;
    localGetPoiInfoReq_V2.stGps = LbsDataV2.convertToGPS_V2(paramGpsInfo);
    if (localGetPoiInfoReq_V2.stGps == null) {
      localGetPoiInfoReq_V2.stGps = new GPS_V2();
    }
    localGetPoiInfoReq_V2.vCellData = paramArrayList;
    localGetPoiInfoReq_V2.vWifiData = paramArrayList1;
    paramGpsInfo = paramString1;
    if (paramString1 == null) {
      paramGpsInfo = "";
    }
    localGetPoiInfoReq_V2.strKeyWord = paramGpsInfo;
    localGetPoiInfoReq_V2.iDistance = 500;
    localGetPoiInfoReq_V2.iAccuracy = 0;
    localGetPoiInfoReq_V2.strAttachInfo = paramString2;
    this.req = localGetPoiInfoReq_V2;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getPoiList";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public String uniKey()
  {
    return "getPoiList";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.lbs.protocol.GetPoiListRequset
 * JD-Core Version:    0.7.0.1
 */