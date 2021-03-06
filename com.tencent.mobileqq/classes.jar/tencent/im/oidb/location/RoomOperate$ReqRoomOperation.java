package tencent.im.oidb.location;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class RoomOperate$ReqRoomOperation
  extends MessageMicro<ReqRoomOperation>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField client_type = PBField.initEnum(1);
  public final PBDoubleField lat = PBField.initDouble(0.0D);
  public final PBDoubleField lon = PBField.initDouble(0.0D);
  public qq_lbs_share.RoomKey room_key = new qq_lbs_share.RoomKey();
  public final PBEnumField room_operation = PBField.initEnum(1);
  
  static
  {
    Integer localInteger = Integer.valueOf(1);
    Double localDouble = Double.valueOf(0.0D);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 33, 41 }, new String[] { "room_key", "room_operation", "client_type", "lon", "lat" }, new Object[] { null, localInteger, localInteger, localDouble, localDouble }, ReqRoomOperation.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.location.RoomOperate.ReqRoomOperation
 * JD-Core Version:    0.7.0.1
 */