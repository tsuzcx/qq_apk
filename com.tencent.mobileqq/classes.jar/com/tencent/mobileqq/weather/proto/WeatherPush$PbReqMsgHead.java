package com.tencent.mobileqq.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WeatherPush$PbReqMsgHead
  extends MessageMicro<PbReqMsgHead>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_ext_mask = PBField.initUInt32(0);
  public final PBUInt32Field uint32_platform_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_version = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_platform_type", "uint32_version", "uint32_ext_mask" }, new Object[] { localInteger, localInteger, localInteger }, PbReqMsgHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weather.proto.WeatherPush.PbReqMsgHead
 * JD-Core Version:    0.7.0.1
 */