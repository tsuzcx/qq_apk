package com.tencent.pb.gamecenter;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MonitReport$MonitReportReq
  extends MessageMicro<MonitReportReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 26 }, new String[] { "type", "public_acct_req" }, new Object[] { Integer.valueOf(0), null }, MonitReportReq.class);
  public final PBRepeatMessageField<MonitReport.PublicAccountReq> public_acct_req = PBField.initRepeatMessage(MonitReport.PublicAccountReq.class);
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.gamecenter.MonitReport.MonitReportReq
 * JD-Core Version:    0.7.0.1
 */