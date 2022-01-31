package com.tencent.mobileqq.intervideo.huiyin.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FalcoLoginProto$ForbidInfo
  extends MessageMicro<ForbidInfo>
{
  public static final int ALERT_TIPS_FIELD_NUMBER = 6;
  public static final int EFFECT_TIME_FIELD_NUMBER = 3;
  public static final int END_TIME_FIELD_NUMBER = 4;
  public static final int FORBID_FOREVER_FIELD_NUMBER = 5;
  public static final int PUNISH_TYPE_FIELD_NUMBER = 2;
  public static final int TINY_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "tiny_id", "punish_type", "effect_time", "end_time", "forbid_forever", "alert_tips" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), "" }, ForbidInfo.class);
  public final PBStringField alert_tips = PBField.initString("");
  public final PBUInt64Field effect_time = PBField.initUInt64(0L);
  public final PBUInt64Field end_time = PBField.initUInt64(0L);
  public final PBBoolField forbid_forever = PBField.initBool(false);
  public final PBUInt32Field punish_type = PBField.initUInt32(0);
  public final PBUInt64Field tiny_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huiyin.proto.FalcoLoginProto.ForbidInfo
 * JD-Core Version:    0.7.0.1
 */