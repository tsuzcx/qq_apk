package tencent.av.chatroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class chatroom_sso$PushMsg
  extends MessageMicro<PushMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "room_key", "msg" }, new Object[] { null, null }, PushMsg.class);
  public chatroom_sso.Msg msg = new chatroom_sso.Msg();
  public chatroom_sso.RoomKey room_key = new chatroom_sso.RoomKey();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.av.chatroom.chatroom_sso.PushMsg
 * JD-Core Version:    0.7.0.1
 */