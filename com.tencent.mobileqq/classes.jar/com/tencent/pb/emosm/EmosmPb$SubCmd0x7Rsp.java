package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class EmosmPb$SubCmd0x7Rsp
  extends MessageMicro<SubCmd0x7Rsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_auth_detail", "str_auth_msg" }, new Object[] { Integer.valueOf(0), "" }, SubCmd0x7Rsp.class);
  public final PBInt32Field int32_auth_detail = PBField.initInt32(0);
  public final PBStringField str_auth_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x7Rsp
 * JD-Core Version:    0.7.0.1
 */