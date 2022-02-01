package com.tencent.pb.qqvalue;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qqvalue$UserQQValueInfo
  extends MessageMicro<UserQQValueInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58, 64, 74 }, new String[] { "score", "level", "trend", "xy_id", "url", "on_off", "material_id", "uin", "ext_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "", Long.valueOf(0L), null }, UserQQValueInfo.class);
  public final PBRepeatMessageField<qqvalue.UserQQValueInfo.ExtInfo> ext_info = PBField.initRepeatMessage(qqvalue.UserQQValueInfo.ExtInfo.class);
  public final PBInt32Field level = PBField.initInt32(0);
  public final PBStringField material_id = PBField.initString("");
  public final PBInt32Field on_off = PBField.initInt32(0);
  public final PBInt32Field score = PBField.initInt32(0);
  public final PBInt32Field trend = PBField.initInt32(0);
  public final PBInt64Field uin = PBField.initInt64(0L);
  public final PBStringField url = PBField.initString("");
  public final PBInt32Field xy_id = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.qqvalue.qqvalue.UserQQValueInfo
 * JD-Core Version:    0.7.0.1
 */