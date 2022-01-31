package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class msg_svc$PbMsgWithDrawResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "c2c_with_draw", "group_with_draw" }, new Object[] { null, null }, PbMsgWithDrawResp.class);
  public final PBRepeatMessageField c2c_with_draw = PBField.initRepeatMessage(msg_svc.PbC2CMsgWithDrawResp.class);
  public final PBRepeatMessageField group_with_draw = PBField.initRepeatMessage(msg_svc.PbGroupMsgWithDrawResp.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbMsgWithDrawResp
 * JD-Core Version:    0.7.0.1
 */