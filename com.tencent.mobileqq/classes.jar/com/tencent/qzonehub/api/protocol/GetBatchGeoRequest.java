package com.tencent.qzonehub.api.protocol;

import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QZoneCommonRequest;

public class GetBatchGeoRequest
  extends QZoneCommonRequest
{
  private int a;
  public JceStruct a;
  
  public String getCmdString()
  {
    return "QzoneNewService.getBatchGeo";
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
    return "getBatchGeo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qzonehub.api.protocol.GetBatchGeoRequest
 * JD-Core Version:    0.7.0.1
 */