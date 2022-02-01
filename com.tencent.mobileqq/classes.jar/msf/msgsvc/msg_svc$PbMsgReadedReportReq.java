package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class msg_svc$PbMsgReadedReportReq
  extends MessageMicro<PbMsgReadedReportReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "grp_read_report", "dis_read_report", "c2c_read_report", "bind_uin_read_report" }, new Object[] { null, null, null, null }, PbMsgReadedReportReq.class);
  public msg_svc.PbBindUinMsgReadedConfirmReq bind_uin_read_report = new msg_svc.PbBindUinMsgReadedConfirmReq();
  public msg_svc.PbC2CReadedReportReq c2c_read_report = new msg_svc.PbC2CReadedReportReq();
  public final PBRepeatMessageField<msg_svc.PbDiscussReadedReportReq> dis_read_report = PBField.initRepeatMessage(msg_svc.PbDiscussReadedReportReq.class);
  public final PBRepeatMessageField<msg_svc.PbGroupReadedReportReq> grp_read_report = PBField.initRepeatMessage(msg_svc.PbGroupReadedReportReq.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbMsgReadedReportReq
 * JD-Core Version:    0.7.0.1
 */