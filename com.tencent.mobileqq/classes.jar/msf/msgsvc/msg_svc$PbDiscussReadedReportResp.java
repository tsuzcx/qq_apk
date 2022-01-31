package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbDiscussReadedReportResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "result", "errmsg", "conf_uin", "member_seq", "conf_seq" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, PbDiscussReadedReportResp.class);
  public final PBUInt64Field conf_seq = PBField.initUInt64(0L);
  public final PBUInt64Field conf_uin = PBField.initUInt64(0L);
  public final PBStringField errmsg = PBField.initString("");
  public final PBUInt64Field member_seq = PBField.initUInt64(0L);
  public final PBUInt32Field result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbDiscussReadedReportResp
 * JD-Core Version:    0.7.0.1
 */