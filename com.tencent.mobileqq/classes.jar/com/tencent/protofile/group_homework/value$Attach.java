package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class value$Attach
  extends MessageMicro<Attach>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field bus_id = PBField.initUInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field size = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "name", "url", "size", "bus_id" }, new Object[] { "", "", localInteger, localInteger }, Attach.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protofile.group_homework.value.Attach
 * JD-Core Version:    0.7.0.1
 */