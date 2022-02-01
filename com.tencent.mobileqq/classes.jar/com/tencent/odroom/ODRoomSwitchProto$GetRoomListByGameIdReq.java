package com.tencent.odroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ODRoomSwitchProto$GetRoomListByGameIdReq
  extends MessageMicro<GetRoomListByGameIdReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field game_id = PBField.initUInt32(0);
  public final PBUInt32Field index = PBField.initUInt32(1);
  public final PBUInt32Field source = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "game_id", "index", "source" }, new Object[] { localInteger, Integer.valueOf(1), localInteger }, GetRoomListByGameIdReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.odroom.ODRoomSwitchProto.GetRoomListByGameIdReq
 * JD-Core Version:    0.7.0.1
 */