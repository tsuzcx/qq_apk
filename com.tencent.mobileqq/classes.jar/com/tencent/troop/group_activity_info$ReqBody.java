package com.tencent.troop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_activity_info$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField act_id = PBField.initBool(false);
  public final PBBoolField big_pic = PBField.initBool(false);
  public final PBBoolField end_time = PBField.initBool(false);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBBoolField small_pic = PBField.initBool(false);
  public final PBBoolField start_time = PBField.initBool(false);
  public final PBBoolField summary = PBField.initBool(false);
  public final PBBoolField title = PBField.initBool(false);
  public final PBEnumField type = PBField.initEnum(1);
  public final PBBoolField url = PBField.initBool(false);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80 }, new String[] { "type", "group_code", "act_id", "title", "summary", "url", "small_pic", "big_pic", "start_time", "end_time" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.troop.group_activity_info.ReqBody
 * JD-Core Version:    0.7.0.1
 */