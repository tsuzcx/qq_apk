package msf.msgsvc.msgtransmit;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import msf.msgcomm.msg_comm.Msg;

public final class msg_transmit$PbMultiMsgNew
  extends MessageMicro<PbMultiMsgNew>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg" }, new Object[] { null }, PbMultiMsgNew.class);
  public final PBRepeatMessageField<msg_comm.Msg> msg = PBField.initRepeatMessage(msg_comm.Msg.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     msf.msgsvc.msgtransmit.msg_transmit.PbMultiMsgNew
 * JD-Core Version:    0.7.0.1
 */