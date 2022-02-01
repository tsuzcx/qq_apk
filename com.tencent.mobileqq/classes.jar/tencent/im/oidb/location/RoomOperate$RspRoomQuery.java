package tencent.im.oidb.location;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class RoomOperate$RspRoomQuery
  extends MessageMicro<RspRoomQuery>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public qq_lbs_share.AssemblyPointData assembly_Point = new qq_lbs_share.AssemblyPointData();
  public final PBUInt64Field create_time = PBField.initUInt64(0L);
  public final PBUInt64Field create_uin = PBField.initUInt64(0L);
  public qq_lbs_share.ResultInfo msg_result = new qq_lbs_share.ResultInfo();
  public final PBUInt32Field req_interval = PBField.initUInt32(0);
  public final PBEnumField room_state = PBField.initEnum(1);
  public final PBRepeatMessageField<RoomOperate.UserData> user_list = PBField.initRepeatMessage(RoomOperate.UserData.class);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 56 }, new String[] { "msg_result", "user_list", "create_uin", "create_time", "room_state", "assembly_Point", "req_interval" }, new Object[] { null, null, localLong, localLong, Integer.valueOf(1), null, Integer.valueOf(0) }, RspRoomQuery.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.location.RoomOperate.RspRoomQuery
 * JD-Core Version:    0.7.0.1
 */