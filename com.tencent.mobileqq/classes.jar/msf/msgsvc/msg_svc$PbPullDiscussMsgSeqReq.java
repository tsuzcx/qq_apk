package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class msg_svc$PbPullDiscussMsgSeqReq
  extends MessageMicro<PbPullDiscussMsgSeqReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "discuss_info_req" }, new Object[] { null }, PbPullDiscussMsgSeqReq.class);
  public final PBRepeatMessageField<msg_svc.PbPullDiscussMsgSeqReq.DiscussInfoReq> discuss_info_req = PBField.initRepeatMessage(msg_svc.PbPullDiscussMsgSeqReq.DiscussInfoReq.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbPullDiscussMsgSeqReq
 * JD-Core Version:    0.7.0.1
 */