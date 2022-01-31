package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ConfigurationService$ReqGetConfig
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field adcode = PBField.initUInt64(0L);
  public final PBStringField bind_phone_no = PBField.initString("");
  public final PBInt32Field carrier = PBField.initInt32(0);
  public final PBRepeatField carriers = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  public final PBStringField city = PBField.initString("");
  public final PBBytesField cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public ConfigurationService.DeviceInfo device_info = new ConfigurationService.DeviceInfo();
  public final PBInt32Field int32_lat = PBField.initInt32(900000000);
  public final PBInt32Field int32_lon = PBField.initInt32(900000000);
  public final PBInt32Field is_page_req = PBField.initInt32(0);
  public final PBRepeatField phone_nos = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField province = PBField.initString("");
  public final PBInt32Field req_debug_msg = PBField.initInt32(0);
  public final PBRepeatMessageField seq_list = PBField.initRepeatMessage(ConfigurationService.ConfigSeq.class);
  public final PBStringField str_info = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 64, 72, 82, 90, 96, 104, 808, 818 }, new String[] { "seq_list", "device_info", "str_info", "province", "city", "adcode", "int32_lat", "int32_lon", "carrier", "phone_nos", "bind_phone_no", "carriers", "req_debug_msg", "is_page_req", "cookies" }, new Object[] { null, null, "", "", "", Long.valueOf(0L), Integer.valueOf(900000000), Integer.valueOf(900000000), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, ReqGetConfig.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig
 * JD-Core Version:    0.7.0.1
 */