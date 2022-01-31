package com.tencent.protofile.cmd0xe40;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xe40$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "status", "tips" }, new Object[] { Integer.valueOf(0), "" }, RspBody.class);
  public final PBUInt32Field status = PBField.initUInt32(0);
  public final PBStringField tips = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.protofile.cmd0xe40.cmd0xe40.RspBody
 * JD-Core Version:    0.7.0.1
 */