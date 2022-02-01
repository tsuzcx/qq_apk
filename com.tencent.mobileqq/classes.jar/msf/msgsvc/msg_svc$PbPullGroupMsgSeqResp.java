package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_svc$PbPullGroupMsgSeqResp
  extends MessageMicro<PbPullGroupMsgSeqResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "result", "errmsg", "group_info_resp" }, new Object[] { Integer.valueOf(0), "", null }, PbPullGroupMsgSeqResp.class);
  public final PBStringField errmsg = PBField.initString("");
  public final PBRepeatMessageField<msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp> group_info_resp = PBField.initRepeatMessage(msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp.class);
  public final PBUInt32Field result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbPullGroupMsgSeqResp
 * JD-Core Version:    0.7.0.1
 */