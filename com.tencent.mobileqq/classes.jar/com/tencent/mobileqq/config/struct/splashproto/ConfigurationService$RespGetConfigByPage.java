package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ConfigurationService$RespGetConfigByPage
  extends MessageMicro<RespGetConfigByPage>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<Integer> delay_time = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public ConfigurationService.PageRespInfo page_info = new ConfigurationService.PageRespInfo();
  public final PBInt32Field result = PBField.initInt32(0);
  public final PBRepeatField<Integer> seed_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field show_strategy = PBField.initUInt32(0);
  public final PBUInt32Field show_time = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt32Field wording_no = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 808, 816, 824, 832, 840 }, new String[] { "result", "type", "content", "page_info", "delay_time", "wording_no", "seed_ids", "show_time", "show_strategy" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RespGetConfigByPage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfigByPage
 * JD-Core Version:    0.7.0.1
 */