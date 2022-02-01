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
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ConfigurationService$RespGetConfig
  extends MessageMicro<RespGetConfig>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<ConfigurationService.Config> config_list = PBField.initRepeatMessage(ConfigurationService.Config.class);
  public final PBBytesField cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField cookies_new = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<String> debug_msg_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field min_req_interval_for_reconnect = PBField.initUInt32(0);
  public final PBRepeatField<Integer> next_req_types = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  public final PBInt32Field result = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 802, 808, 818 }, new String[] { "result", "config_list", "debug_msg_list", "next_req_types", "cookies", "min_req_interval_for_reconnect", "cookies_new" }, new Object[] { Integer.valueOf(0), null, "", Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, RespGetConfig.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig
 * JD-Core Version:    0.7.0.1
 */