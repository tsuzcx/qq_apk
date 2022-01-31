package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class richtext$Attach
  extends MessageMicro<Attach>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "name", "url", "size", "busid" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0) }, Attach.class);
  public final PBUInt32Field busid = PBField.initUInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field size = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.protofile.group_homework.richtext.Attach
 * JD-Core Version:    0.7.0.1
 */