package tencent.av.chatroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class chatroom_sso$ReqGetMsg
  extends MessageMicro<ReqGetMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "room_key", "is_terminal_switch", "room_id" }, new Object[] { null, Boolean.valueOf(false), Long.valueOf(0L) }, ReqGetMsg.class);
  public final PBBoolField is_terminal_switch = PBField.initBool(false);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public chatroom_sso.RoomKey room_key = new chatroom_sso.RoomKey();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.av.chatroom.chatroom_sso.ReqGetMsg
 * JD-Core Version:    0.7.0.1
 */