package cooperation.qqcircle.lbs.protocol;

import LBS_V2_PROTOCOL.GetBatchGeoReq_V2;
import LBS_V2_PROTOCOL.ReqCommon_V2;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.QZoneCommonRequest;
import java.util.ArrayList;

public class GetBatchGeoRequest
  extends QZoneCommonRequest
{
  private static final String CMD = "getBatchGeo";
  public JceStruct req;
  private int type;
  
  public GetBatchGeoRequest(ArrayList<LbsDataV2.GpsInfo> paramArrayList, int paramInt)
  {
    this.type = paramInt;
    GetBatchGeoReq_V2 localGetBatchGeoReq_V2 = new GetBatchGeoReq_V2();
    localGetBatchGeoReq_V2.stCommon = new ReqCommon_V2();
    localGetBatchGeoReq_V2.stCommon.iAppId = 4;
    localGetBatchGeoReq_V2.stCommon.iDeviceType = 1;
    localGetBatchGeoReq_V2.vecGpsInfo = new ArrayList();
    paramInt = 0;
    while (paramInt < paramArrayList.size())
    {
      localGetBatchGeoReq_V2.vecGpsInfo.add(LbsDataV2.convertToGPS_V2((LbsDataV2.GpsInfo)paramArrayList.get(paramInt)));
      paramInt += 1;
    }
    this.req = localGetBatchGeoReq_V2;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getBatchGeo";
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
    return "getBatchGeo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.lbs.protocol.GetBatchGeoRequest
 * JD-Core Version:    0.7.0.1
 */