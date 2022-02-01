package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class msg_svc$PbPullGroupMsgSeqReq
  extends MessageMicro<PbPullGroupMsgSeqReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "group_info_req" }, new Object[] { null }, PbPullGroupMsgSeqReq.class);
  public final PBRepeatMessageField<msg_svc.PbPullGroupMsgSeqReq.GroupInfoReq> group_info_req = PBField.initRepeatMessage(msg_svc.PbPullGroupMsgSeqReq.GroupInfoReq.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbPullGroupMsgSeqReq
 * JD-Core Version:    0.7.0.1
 */