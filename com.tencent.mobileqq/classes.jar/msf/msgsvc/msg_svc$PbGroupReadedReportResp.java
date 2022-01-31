package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbGroupReadedReportResp
  extends MessageMicro<PbGroupReadedReportResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "result", "errmsg", "group_code", "member_seq", "group_msg_seq" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, PbGroupReadedReportResp.class);
  public final PBStringField errmsg = PBField.initString("");
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt64Field group_msg_seq = PBField.initUInt64(0L);
  public final PBUInt64Field member_seq = PBField.initUInt64(0L);
  public final PBUInt32Field result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbGroupReadedReportResp
 * JD-Core Version:    0.7.0.1
 */