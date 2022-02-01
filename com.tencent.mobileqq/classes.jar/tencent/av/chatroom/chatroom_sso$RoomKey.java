package tencent.av.chatroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class chatroom_sso$RoomKey
  extends MessageMicro<RoomKey>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field create_ts = PBField.initUInt32(0);
  public final PBUInt64Field id = PBField.initUInt64(0L);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "type", "id", "room_id", "create_ts" }, new Object[] { localInteger, localLong, localLong, localInteger }, RoomKey.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.av.chatroom.chatroom_sso.RoomKey
 * JD-Core Version:    0.7.0.1
 */