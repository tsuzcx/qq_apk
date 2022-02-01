package tencent.av.chatroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class chatroom_sso$ReqSendMsg
  extends MessageMicro<ReqSendMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "room_key", "msg" }, new Object[] { null, null }, ReqSendMsg.class);
  public chatroom_sso.Msg msg = new chatroom_sso.Msg();
  public chatroom_sso.RoomKey room_key = new chatroom_sso.RoomKey();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.av.chatroom.chatroom_sso.ReqSendMsg
 * JD-Core Version:    0.7.0.1
 */