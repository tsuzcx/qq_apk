package com.tencent.odroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ODRoomSwitchProto$RoomInfo
  extends MessageMicro<RoomInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField anchor_nick = PBField.initString("");
  public final PBStringField anchor_pic = PBField.initString("");
  public final PBUInt64Field anchor_uin = PBField.initUInt64(0L);
  public final PBUInt32Field online_num = PBField.initUInt32(0);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public final PBStringField room_logo_url = PBField.initString("");
  public final PBStringField room_name = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 56 }, new String[] { "room_id", "room_name", "room_logo_url", "anchor_uin", "anchor_nick", "anchor_pic", "online_num" }, new Object[] { localLong, "", "", localLong, "", "", Integer.valueOf(0) }, RoomInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.odroom.ODRoomSwitchProto.RoomInfo
 * JD-Core Version:    0.7.0.1
 */