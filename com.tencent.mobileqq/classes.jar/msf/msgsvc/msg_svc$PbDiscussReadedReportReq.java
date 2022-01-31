package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbDiscussReadedReportReq
  extends MessageMicro<PbDiscussReadedReportReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "conf_uin", "last_read_seq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, PbDiscussReadedReportReq.class);
  public final PBUInt64Field conf_uin = PBField.initUInt64(0L);
  public final PBUInt64Field last_read_seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbDiscussReadedReportReq
 * JD-Core Version:    0.7.0.1
 */