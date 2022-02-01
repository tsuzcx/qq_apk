package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FudaiActiveReport$PkgReq
  extends MessageMicro<PkgReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "user_comm_report", "fd_config", "resource_download", "exception_handle", "active_report" }, new Object[] { null, null, null, null, null }, PkgReq.class);
  public final PBRepeatMessageField<FudaiActiveReport.ActiveReportReq> active_report = PBField.initRepeatMessage(FudaiActiveReport.ActiveReportReq.class);
  public final PBRepeatMessageField<FudaiActiveReport.ExceptionHandle> exception_handle = PBField.initRepeatMessage(FudaiActiveReport.ExceptionHandle.class);
  public final PBRepeatMessageField<FudaiActiveReport.FdConfig> fd_config = PBField.initRepeatMessage(FudaiActiveReport.FdConfig.class);
  public final PBRepeatMessageField<FudaiActiveReport.ResourceDownload> resource_download = PBField.initRepeatMessage(FudaiActiveReport.ResourceDownload.class);
  public FudaiActiveReport.UserCommReport user_comm_report = new FudaiActiveReport.UserCommReport();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     fudai.FudaiActiveReport.PkgReq
 * JD-Core Version:    0.7.0.1
 */