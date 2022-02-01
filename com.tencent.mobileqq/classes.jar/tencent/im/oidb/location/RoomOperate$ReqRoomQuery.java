package tencent.im.oidb.location;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class RoomOperate$ReqRoomQuery
  extends MessageMicro<ReqRoomQuery>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "room_key", "no_limit", "client_type" }, new Object[] { null, Boolean.valueOf(false), Integer.valueOf(1) }, ReqRoomQuery.class);
  public final PBEnumField client_type = PBField.initEnum(1);
  public final PBBoolField no_limit = PBField.initBool(false);
  public qq_lbs_share.RoomKey room_key = new qq_lbs_share.RoomKey();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.location.RoomOperate.ReqRoomQuery
 * JD-Core Version:    0.7.0.1
 */