package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class servtype$LiveRoomStatusChangeMsg
  extends MessageMicro<LiveRoomStatusChangeMsg>
{
  public static final int CLOSE = 2;
  public static final int INVALID = 0;
  public static final int OPEN = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField action = PBField.initEnum(0);
  public final PBUInt64Field anchor_tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field channel_id = PBField.initUInt64(0L);
  public final PBUInt64Field guild_id = PBField.initUInt64(0L);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "guild_id", "channel_id", "room_id", "anchor_tinyid", "action" }, new Object[] { localLong, localLong, localLong, localLong, Integer.valueOf(0) }, LiveRoomStatusChangeMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.servtype.LiveRoomStatusChangeMsg
 * JD-Core Version:    0.7.0.1
 */