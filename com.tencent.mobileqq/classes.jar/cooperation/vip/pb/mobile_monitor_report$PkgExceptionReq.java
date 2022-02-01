package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class mobile_monitor_report$PkgExceptionReq
  extends MessageMicro<PkgExceptionReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "user_comm_report", "exception_report" }, new Object[] { null, null }, PkgExceptionReq.class);
  public final PBRepeatMessageField<mobile_monitor_report.ExceptionReport> exception_report = PBField.initRepeatMessage(mobile_monitor_report.ExceptionReport.class);
  public mobile_monitor_report.UserCommReport user_comm_report = new mobile_monitor_report.UserCommReport();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.pb.mobile_monitor_report.PkgExceptionReq
 * JD-Core Version:    0.7.0.1
 */