package tencent.av.chatroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class chatroom_sso$RspGetMsg
  extends MessageMicro<RspGetMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "result", "err_msg", "msg_list", "retry", "retry_delay" }, new Object[] { Integer.valueOf(0), "", null, Boolean.valueOf(false), Long.valueOf(0L) }, RspGetMsg.class);
  public final PBStringField err_msg = PBField.initString("");
  public final PBRepeatMessageField<chatroom_sso.Msg> msg_list = PBField.initRepeatMessage(chatroom_sso.Msg.class);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBBoolField retry = PBField.initBool(false);
  public final PBUInt64Field retry_delay = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.av.chatroom.chatroom_sso.RspGetMsg
 * JD-Core Version:    0.7.0.1
 */