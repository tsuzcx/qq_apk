package com.tencent.odroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ODRoomSwitchProto$GetRoomListByGameIdRsp
  extends MessageMicro<GetRoomListByGameIdRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field index_end = PBField.initUInt32(0);
  public final PBUInt32Field ret = PBField.initUInt32(0);
  public final PBRepeatMessageField<ODRoomSwitchProto.RoomInfo> room_list = PBField.initRepeatMessage(ODRoomSwitchProto.RoomInfo.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "ret", "room_list", "index_end" }, new Object[] { localInteger, null, localInteger }, GetRoomListByGameIdRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.odroom.ODRoomSwitchProto.GetRoomListByGameIdRsp
 * JD-Core Version:    0.7.0.1
 */