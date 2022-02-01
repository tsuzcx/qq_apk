package com.tencent.pb.troop.bindgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GCBindGroup$QQGroupCardDynamic
  extends MessageMicro<QQGroupCardDynamic>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_code", "last_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, QQGroupCardDynamic.class);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt64Field last_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.troop.bindgame.GCBindGroup.QQGroupCardDynamic
 * JD-Core Version:    0.7.0.1
 */