package tencent.av.chatroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class chatroom_sso$Msg
  extends MessageMicro<Msg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uin", "msg", "msg_id", "msg_time" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L) }, Msg.class);
  public final PBStringField msg = PBField.initString("");
  public final PBUInt32Field msg_id = PBField.initUInt32(0);
  public final PBUInt64Field msg_time = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.av.chatroom.chatroom_sso.Msg
 * JD-Core Version:    0.7.0.1
 */