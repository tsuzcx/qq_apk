package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleReport$StDataReportReq
  extends MessageMicro<StDataReportReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "dcdata" }, new Object[] { null }, StDataReportReq.class);
  public final PBRepeatMessageField<QQCircleReport.SingleDcData> dcdata = PBField.initRepeatMessage(QQCircleReport.SingleDcData.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleReport.StDataReportReq
 * JD-Core Version:    0.7.0.1
 */