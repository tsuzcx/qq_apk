package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class mobile_monitor_report$PkgTraceReq
  extends MessageMicro<PkgTraceReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "user_busi_type", "user_comm_report", "trace_report" }, new Object[] { Integer.valueOf(1), null, null }, PkgTraceReq.class);
  public final PBRepeatMessageField<mobile_monitor_report.TraceReport> trace_report = PBField.initRepeatMessage(mobile_monitor_report.TraceReport.class);
  public final PBEnumField user_busi_type = PBField.initEnum(1);
  public mobile_monitor_report.UserCommReport user_comm_report = new mobile_monitor_report.UserCommReport();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.pb.mobile_monitor_report.PkgTraceReq
 * JD-Core Version:    0.7.0.1
 */