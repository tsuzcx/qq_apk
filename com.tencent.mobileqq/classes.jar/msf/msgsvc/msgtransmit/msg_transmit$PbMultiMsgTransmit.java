package msf.msgsvc.msgtransmit;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import msf.msgcomm.msg_comm.Msg;

public final class msg_transmit$PbMultiMsgTransmit
  extends MessageMicro<PbMultiMsgTransmit>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg", "pbItemList" }, new Object[] { null, null }, PbMultiMsgTransmit.class);
  public final PBRepeatMessageField<msg_comm.Msg> msg = PBField.initRepeatMessage(msg_comm.Msg.class);
  public final PBRepeatMessageField<msg_transmit.PbMultiMsgItem> pbItemList = PBField.initRepeatMessage(msg_transmit.PbMultiMsgItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     msf.msgsvc.msgtransmit.msg_transmit.PbMultiMsgTransmit
 * JD-Core Version:    0.7.0.1
 */