package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class EmosmPb$SubCmd0x19Rsp
  extends MessageMicro<SubCmd0x19Rsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 61 }, new String[] { "uint32_package_id", "str_ip_url", "str_ip_name", "str_ip_detail", "str_op_name", "str_jump_url", "fixed32_time" }, new Object[] { Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0) }, SubCmd0x19Rsp.class);
  public final PBFixed32Field fixed32_time = PBField.initFixed32(0);
  public final PBStringField str_ip_detail = PBField.initString("");
  public final PBStringField str_ip_name = PBField.initString("");
  public final PBStringField str_ip_url = PBField.initString("");
  public final PBStringField str_jump_url = PBField.initString("");
  public final PBStringField str_op_name = PBField.initString("");
  public final PBUInt32Field uint32_package_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x19Rsp
 * JD-Core Version:    0.7.0.1
 */