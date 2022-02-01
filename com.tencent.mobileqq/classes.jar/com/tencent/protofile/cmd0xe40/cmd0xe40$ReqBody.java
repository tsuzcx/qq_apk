package com.tencent.protofile.cmd0xe40;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xe40$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "rowkey", "id", "source" }, new Object[] { "", "", Integer.valueOf(0) }, ReqBody.class);
  public final PBStringField id = PBField.initString("");
  public final PBStringField rowkey = PBField.initString("");
  public final PBUInt32Field source = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protofile.cmd0xe40.cmd0xe40.ReqBody
 * JD-Core Version:    0.7.0.1
 */