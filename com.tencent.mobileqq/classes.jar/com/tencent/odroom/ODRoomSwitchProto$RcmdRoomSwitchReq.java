package com.tencent.odroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ODRoomSwitchProto$RcmdRoomSwitchReq
  extends MessageMicro<RcmdRoomSwitchReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 29, 37, 40 }, new String[] { "curr_roomid", "gender", "longitude", "latitude", "source" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(0.0F), Float.valueOf(0.0F), Integer.valueOf(0) }, RcmdRoomSwitchReq.class);
  public final PBUInt32Field curr_roomid = PBField.initUInt32(0);
  public final PBUInt32Field gender = PBField.initUInt32(0);
  public final PBFloatField latitude = PBField.initFloat(0.0F);
  public final PBFloatField longitude = PBField.initFloat(0.0F);
  public final PBUInt32Field source = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.odroom.ODRoomSwitchProto.RcmdRoomSwitchReq
 * JD-Core Version:    0.7.0.1
 */