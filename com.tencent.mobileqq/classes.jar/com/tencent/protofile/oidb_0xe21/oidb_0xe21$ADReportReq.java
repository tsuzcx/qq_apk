package com.tencent.protofile.oidb_0xe21;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xe21$ADReportReq
  extends MessageMicro<ADReportReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_ad" }, new Object[] { null }, ADReportReq.class);
  public final PBRepeatMessageField<oidb_0xe21.ADItem> rpt_ad = PBField.initRepeatMessage(oidb_0xe21.ADItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protofile.oidb_0xe21.oidb_0xe21.ADReportReq
 * JD-Core Version:    0.7.0.1
 */