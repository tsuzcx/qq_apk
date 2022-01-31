package msf.msgsvc.msgtransmit;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import msf.msgcomm.msg_comm.Msg;

public final class msg_transmit$PbMultiMsgTransmit
  extends MessageMicro
{
  public static final int MSG_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg" }, new Object[] { null }, PbMultiMsgTransmit.class);
  public final PBRepeatMessageField msg = PBField.initRepeatMessage(msg_comm.Msg.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     msf.msgsvc.msgtransmit.msg_transmit.PbMultiMsgTransmit
 * JD-Core Version:    0.7.0.1
 */