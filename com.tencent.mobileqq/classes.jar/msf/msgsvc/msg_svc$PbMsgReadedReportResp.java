package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class msg_svc$PbMsgReadedReportResp
  extends MessageMicro<PbMsgReadedReportResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "grp_read_report", "dis_read_report", "c2c_read_report", "bind_uin_read_report" }, new Object[] { null, null, null, null }, PbMsgReadedReportResp.class);
  public msg_svc.PbBindUinMsgReadedConfirmResp bind_uin_read_report = new msg_svc.PbBindUinMsgReadedConfirmResp();
  public msg_svc.PbC2CReadedReportResp c2c_read_report = new msg_svc.PbC2CReadedReportResp();
  public final PBRepeatMessageField<msg_svc.PbDiscussReadedReportResp> dis_read_report = PBField.initRepeatMessage(msg_svc.PbDiscussReadedReportResp.class);
  public final PBRepeatMessageField<msg_svc.PbGroupReadedReportResp> grp_read_report = PBField.initRepeatMessage(msg_svc.PbGroupReadedReportResp.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbMsgReadedReportResp
 * JD-Core Version:    0.7.0.1
 */