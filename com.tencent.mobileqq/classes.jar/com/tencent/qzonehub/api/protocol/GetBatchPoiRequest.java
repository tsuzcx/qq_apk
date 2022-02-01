package com.tencent.qzonehub.api.protocol;

import LBS_V2_PROTOCOL.GetBatchPoiReq_V2;
import LBS_V2_PROTOCOL.ReqCommon_V2;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.QZoneCommonRequest;
import java.util.ArrayList;
import java.util.Map;

public class GetBatchPoiRequest
  extends QZoneCommonRequest
{
  private int a;
  public JceStruct a;
  
  public GetBatchPoiRequest(ArrayList<LbsDataV2.GpsInfo> paramArrayList, int paramInt1, Map<String, String> paramMap, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt2;
    GetBatchPoiReq_V2 localGetBatchPoiReq_V2 = new GetBatchPoiReq_V2();
    localGetBatchPoiReq_V2.stCommon = new ReqCommon_V2();
    localGetBatchPoiReq_V2.stCommon.iAppId = paramInt1;
    localGetBatchPoiReq_V2.stCommon.iDeviceType = 1;
    localGetBatchPoiReq_V2.vecGpsInfo = new ArrayList();
    if (paramMap != null) {
      localGetBatchPoiReq_V2.map_ext = paramMap;
    }
    paramInt1 = 0;
    while (paramInt1 < paramArrayList.size())
    {
      localGetBatchPoiReq_V2.vecGpsInfo.add(LbsDataV2.convertToGPS_V2((LbsDataV2.GpsInfo)paramArrayList.get(paramInt1)));
      paramInt1 += 1;
    }
    localGetBatchPoiReq_V2.opMask = 1;
    this.jdField_a_of_type_ComQqTafJceJceStruct = localGetBatchPoiReq_V2;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getBatchPoi";
  }
  
  public JceStruct getReq()
  {
    return this.jdField_a_of_type_ComQqTafJceJceStruct;
  }
  
  public int getType()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String uniKey()
  {
    return "getBatchPoi";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.protocol.GetBatchPoiRequest
 * JD-Core Version:    0.7.0.1
 */