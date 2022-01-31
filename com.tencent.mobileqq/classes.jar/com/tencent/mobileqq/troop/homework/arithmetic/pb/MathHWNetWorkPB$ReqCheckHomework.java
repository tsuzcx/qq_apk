package com.tencent.mobileqq.troop.homework.arithmetic.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MathHWNetWorkPB$ReqCheckHomework
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "group_id", "hw_id", "uin", "pics" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null }, ReqCheckHomework.class);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBUInt64Field hw_id = PBField.initUInt64(0L);
  public final PBRepeatMessageField pics = PBField.initRepeatMessage(MathHWNetWorkPB.YoutuPicInfo.class);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.pb.MathHWNetWorkPB.ReqCheckHomework
 * JD-Core Version:    0.7.0.1
 */