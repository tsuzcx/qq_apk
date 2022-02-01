package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class msg_svc$PbUnReadMsgSeqResp
  extends MessageMicro<PbUnReadMsgSeqResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "c2c_unread_info", "binduin_unread_info", "group_unread_info", "discuss_unread_info", "thirdqq_unread_info" }, new Object[] { null, null, null, null, null }, PbUnReadMsgSeqResp.class);
  public final PBRepeatMessageField<msg_svc.PbBindUinUnReadMsgNumResp> binduin_unread_info = PBField.initRepeatMessage(msg_svc.PbBindUinUnReadMsgNumResp.class);
  public msg_svc.PbC2CUnReadMsgNumResp c2c_unread_info = new msg_svc.PbC2CUnReadMsgNumResp();
  public msg_svc.PbPullDiscussMsgSeqResp discuss_unread_info = new msg_svc.PbPullDiscussMsgSeqResp();
  public msg_svc.PbPullGroupMsgSeqResp group_unread_info = new msg_svc.PbPullGroupMsgSeqResp();
  public msg_svc.PbThirdQQUnReadMsgNumResp thirdqq_unread_info = new msg_svc.PbThirdQQUnReadMsgNumResp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbUnReadMsgSeqResp
 * JD-Core Version:    0.7.0.1
 */