package com.trunk.feeds_inner_define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class feeds_inner_define$ConcernUinRecordSet
  extends MessageMicro<ConcernUinRecordSet>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_concern_uin_record" }, new Object[] { null }, ConcernUinRecordSet.class);
  public final PBRepeatMessageField<feeds_inner_define.ConcernUinRecord> rpt_concern_uin_record = PBField.initRepeatMessage(feeds_inner_define.ConcernUinRecord.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.trunk.feeds_inner_define.feeds_inner_define.ConcernUinRecordSet
 * JD-Core Version:    0.7.0.1
 */