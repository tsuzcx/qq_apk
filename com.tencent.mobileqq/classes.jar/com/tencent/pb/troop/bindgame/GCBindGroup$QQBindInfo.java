package com.tencent.pb.troop.bindgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GCBindGroup$QQBindInfo
  extends MessageMicro<QQBindInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "appid", "group_code", "app_name" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "" }, QQBindInfo.class);
  public final PBStringField app_name = PBField.initString("");
  public final PBInt32Field appid = PBField.initInt32(0);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.troop.bindgame.GCBindGroup.QQBindInfo
 * JD-Core Version:    0.7.0.1
 */