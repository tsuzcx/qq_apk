package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class msg_svc$PbMsgWithDrawReq
  extends MessageMicro<PbMsgWithDrawReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "c2c_with_draw", "group_with_draw" }, new Object[] { null, null }, PbMsgWithDrawReq.class);
  public final PBRepeatMessageField<msg_svc.PbC2CMsgWithDrawReq> c2c_with_draw = PBField.initRepeatMessage(msg_svc.PbC2CMsgWithDrawReq.class);
  public final PBRepeatMessageField<msg_svc.PbGroupMsgWithDrawReq> group_with_draw = PBField.initRepeatMessage(msg_svc.PbGroupMsgWithDrawReq.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbMsgWithDrawReq
 * JD-Core Version:    0.7.0.1
 */