package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowSummaryCard$MiniCard
  extends MessageMicro<MiniCard>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField is_greet = PBField.initBool(false);
  public final PBBoolField is_match = PBField.initBool(false);
  public final PBBoolField is_online = PBField.initBool(false);
  public final PBStringField logo = PBField.initString("");
  public final PBStringField nick = PBField.initString("");
  public final PBStringField sign = PBField.initString("");
  public final PBUInt64Field target_id = PBField.initUInt64(0L);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 56 }, new String[] { "target_id", "nick", "logo", "sign", "is_online", "is_match", "is_greet" }, new Object[] { Long.valueOf(0L), "", "", "", localBoolean, localBoolean, localBoolean }, MiniCard.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.nowsummarycard.NowSummaryCard.MiniCard
 * JD-Core Version:    0.7.0.1
 */