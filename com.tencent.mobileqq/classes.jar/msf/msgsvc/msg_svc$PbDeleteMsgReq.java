package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class msg_svc$PbDeleteMsgReq
  extends MessageMicro<PbDeleteMsgReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msgItems" }, new Object[] { null }, PbDeleteMsgReq.class);
  public final PBRepeatMessageField<msg_svc.PbDeleteMsgReq.MsgItem> msgItems = PBField.initRepeatMessage(msg_svc.PbDeleteMsgReq.MsgItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbDeleteMsgReq
 * JD-Core Version:    0.7.0.1
 */