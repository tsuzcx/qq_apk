package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SummaryCardUpdate$SUpdateReqBatch
  extends MessageMicro<SUpdateReqBatch>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "reqs" }, new Object[] { null }, SUpdateReqBatch.class);
  public final PBRepeatMessageField<SummaryCardUpdate.SUpdateReq> reqs = PBField.initRepeatMessage(SummaryCardUpdate.SUpdateReq.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateReqBatch
 * JD-Core Version:    0.7.0.1
 */