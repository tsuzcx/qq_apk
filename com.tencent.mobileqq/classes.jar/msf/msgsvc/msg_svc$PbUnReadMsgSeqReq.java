package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class msg_svc$PbUnReadMsgSeqReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "c2c_unread_info", "binduin_unread_info", "group_unread_info", "discuss_unread_info", "thirdqq_unread_info" }, new Object[] { null, null, null, null, null }, PbUnReadMsgSeqReq.class);
  public final PBRepeatMessageField binduin_unread_info = PBField.initRepeatMessage(msg_svc.PbBindUinUnReadMsgNumReq.class);
  public msg_svc.PbC2CUnReadMsgNumReq c2c_unread_info = new msg_svc.PbC2CUnReadMsgNumReq();
  public msg_svc.PbPullDiscussMsgSeqReq discuss_unread_info = new msg_svc.PbPullDiscussMsgSeqReq();
  public msg_svc.PbPullGroupMsgSeqReq group_unread_info = new msg_svc.PbPullGroupMsgSeqReq();
  public msg_svc.PbThirdQQUnReadMsgNumReq thirdqq_unread_info = new msg_svc.PbThirdQQUnReadMsgNumReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbUnReadMsgSeqReq
 * JD-Core Version:    0.7.0.1
 */