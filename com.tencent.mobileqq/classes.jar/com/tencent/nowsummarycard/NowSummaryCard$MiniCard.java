package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowSummaryCard$MiniCard
  extends MessageMicro<MiniCard>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "target_id", "nick", "logo" }, new Object[] { Long.valueOf(0L), "", "" }, MiniCard.class);
  public final PBStringField logo = PBField.initString("");
  public final PBStringField nick = PBField.initString("");
  public final PBUInt64Field target_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.nowsummarycard.NowSummaryCard.MiniCard
 * JD-Core Version:    0.7.0.1
 */