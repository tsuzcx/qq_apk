package com.tencent.pb.troop.bindgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GCBindGroup$QQGroupBind
  extends MessageMicro<QQGroupBind>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "group_code", "appid", "group_name", "group_pic" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "" }, QQGroupBind.class);
  public final PBInt32Field appid = PBField.initInt32(0);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBStringField group_name = PBField.initString("");
  public final PBStringField group_pic = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.troop.bindgame.GCBindGroup.QQGroupBind
 * JD-Core Version:    0.7.0.1
 */