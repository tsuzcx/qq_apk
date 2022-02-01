package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SummaryCardBusiEntry$CommonReq
  extends MessageMicro<CommonReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "serviceCmd", "vcReq", "hrReq" }, new Object[] { "", null, null }, CommonReq.class);
  public SummaryCardBusiEntry.HideRecordsReq hrReq = new SummaryCardBusiEntry.HideRecordsReq();
  public final PBStringField serviceCmd = PBField.initString("");
  public SummaryCardBusiEntry.VisitorCountReq vcReq = new SummaryCardBusiEntry.VisitorCountReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.pb.profilecard.SummaryCardBusiEntry.CommonReq
 * JD-Core Version:    0.7.0.1
 */