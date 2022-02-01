package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MqqNearbyGdt$ExposeRequest
  extends MessageMicro<ExposeRequest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field ad_source = PBField.initInt32(0);
  public final PBStringField apurl = PBField.initString("");
  public final PBInt32Field platform_type = PBField.initInt32(0);
  public final PBStringField qua = PBField.initString("");
  public final PBStringField resolution = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "resolution", "apurl", "qua", "platform_type", "ad_source" }, new Object[] { "", "", "", localInteger, localInteger }, ExposeRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mp.MqqNearbyGdt.ExposeRequest
 * JD-Core Version:    0.7.0.1
 */