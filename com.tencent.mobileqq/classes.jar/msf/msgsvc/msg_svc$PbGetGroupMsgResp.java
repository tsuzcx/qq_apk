package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgcomm.msg_comm.Msg;

public final class msg_svc$PbGetGroupMsgResp
  extends MessageMicro<PbGetGroupMsgResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50 }, new String[] { "result", "errmsg", "group_code", "return_begin_seq", "return_end_seq", "msg" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null }, PbGetGroupMsgResp.class);
  public final PBStringField errmsg = PBField.initString("");
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBRepeatMessageField<msg_comm.Msg> msg = PBField.initRepeatMessage(msg_comm.Msg.class);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt64Field return_begin_seq = PBField.initUInt64(0L);
  public final PBUInt64Field return_end_seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbGetGroupMsgResp
 * JD-Core Version:    0.7.0.1
 */