package tencent.av.chatroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class chatroom_sso$RspSendMsg
  extends MessageMicro<RspSendMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "result", "err_msg", "msg_id" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, RspSendMsg.class);
  public final PBStringField err_msg = PBField.initString("");
  public final PBUInt32Field msg_id = PBField.initUInt32(0);
  public final PBUInt32Field result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.av.chatroom.chatroom_sso.RspSendMsg
 * JD-Core Version:    0.7.0.1
 */