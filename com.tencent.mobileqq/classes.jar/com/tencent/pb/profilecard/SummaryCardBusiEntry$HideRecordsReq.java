package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SummaryCardBusiEntry$HideRecordsReq
  extends MessageMicro<HideRecordsReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "huin", "fuin", "records" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, HideRecordsReq.class);
  public final PBUInt32Field fuin = PBField.initUInt32(0);
  public final PBUInt32Field huin = PBField.initUInt32(0);
  public final PBRepeatMessageField<SummaryCardBusiEntry.DetailRecord> records = PBField.initRepeatMessage(SummaryCardBusiEntry.DetailRecord.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.profilecard.SummaryCardBusiEntry.HideRecordsReq
 * JD-Core Version:    0.7.0.1
 */