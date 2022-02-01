package com.tencent.qzonehub.api.protocol;

import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QZoneCommonRequest;

public class GetBatchGeoRequest
  extends QZoneCommonRequest
{
  public JceStruct a;
  private int b;
  
  public String getCmdString()
  {
    return "QzoneNewService.getBatchGeo";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public int getType()
  {
    return this.b;
  }
  
  public String uniKey()
  {
    return "getBatchGeo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.protocol.GetBatchGeoRequest
 * JD-Core Version:    0.7.0.1
 */