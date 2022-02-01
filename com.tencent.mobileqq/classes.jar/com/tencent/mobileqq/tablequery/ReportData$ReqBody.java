package com.tencent.mobileqq.tablequery;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ReportData$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "reportId", "type", "params" }, new Object[] { "", Integer.valueOf(0), null }, ReqBody.class);
  public final PBRepeatMessageField<ReportData.ReqMqqParam> params = PBField.initRepeatMessage(ReportData.ReqMqqParam.class);
  public final PBRepeatField<String> reportId = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.ReportData.ReqBody
 * JD-Core Version:    0.7.0.1
 */