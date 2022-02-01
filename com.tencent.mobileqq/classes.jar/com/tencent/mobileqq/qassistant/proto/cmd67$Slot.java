package com.tencent.mobileqq.qassistant.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd67$Slot
  extends MessageMicro<Slot>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_end = PBField.initInt32(0);
  public final PBInt32Field int32_start = PBField.initInt32(0);
  public final PBStringField str_confirm_status = PBField.initString("");
  public final PBStringField str_entity_type = PBField.initString("");
  public final PBStringField str_name = PBField.initString("");
  public final PBStringField str_norm = PBField.initString("");
  public final PBStringField str_norm_detail = PBField.initString("");
  public final PBStringField str_value = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50, 58, 66 }, new String[] { "str_name", "str_value", "int32_start", "int32_end", "str_confirm_status", "str_norm", "str_entity_type", "str_norm_detail" }, new Object[] { "", "", localInteger, localInteger, "", "", "", "" }, Slot.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.proto.cmd67.Slot
 * JD-Core Version:    0.7.0.1
 */