package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class TianShuReport$UserActionMultiReportReq
  extends MessageMicro<UserActionMultiReportReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "user_comm_report", "report_infos" }, new Object[] { null, null }, UserActionMultiReportReq.class);
  public final PBRepeatMessageField<TianShuReport.UserActionReport> report_infos = PBField.initRepeatMessage(TianShuReport.UserActionReport.class);
  public TianShuReport.UserCommReport user_comm_report = new TianShuReport.UserCommReport();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.pb.TianShuReport.UserActionMultiReportReq
 * JD-Core Version:    0.7.0.1
 */