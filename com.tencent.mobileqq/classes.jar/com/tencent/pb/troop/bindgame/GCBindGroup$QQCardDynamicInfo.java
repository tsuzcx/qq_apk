package com.tencent.pb.troop.bindgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GCBindGroup$QQCardDynamicInfo
  extends MessageMicro<QQCardDynamicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "dynamic_info", "dynamic_cnt", "newest_time" }, new Object[] { "", Integer.valueOf(0), Long.valueOf(0L) }, QQCardDynamicInfo.class);
  public final PBInt32Field dynamic_cnt = PBField.initInt32(0);
  public final PBStringField dynamic_info = PBField.initString("");
  public final PBUInt64Field newest_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.troop.bindgame.GCBindGroup.QQCardDynamicInfo
 * JD-Core Version:    0.7.0.1
 */