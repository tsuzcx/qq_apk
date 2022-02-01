package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbPullDiscussMsgSeqResp$DiscussInfoResp
  extends MessageMicro<DiscussInfoResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "conf_uin", "member_seq", "conf_seq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, DiscussInfoResp.class);
  public final PBUInt64Field conf_seq = PBField.initUInt64(0L);
  public final PBUInt64Field conf_uin = PBField.initUInt64(0L);
  public final PBUInt64Field member_seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbPullDiscussMsgSeqResp.DiscussInfoResp
 * JD-Core Version:    0.7.0.1
 */