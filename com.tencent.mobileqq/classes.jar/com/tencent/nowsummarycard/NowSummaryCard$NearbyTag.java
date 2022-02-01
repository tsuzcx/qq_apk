package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class NowSummaryCard$NearbyTag
  extends MessageMicro<NearbyTag>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "data" }, new Object[] { null }, NearbyTag.class);
  public final PBRepeatMessageField<NowSummaryCard.NearbyTag.Data> data = PBField.initRepeatMessage(NowSummaryCard.NearbyTag.Data.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.nowsummarycard.NowSummaryCard.NearbyTag
 * JD-Core Version:    0.7.0.1
 */