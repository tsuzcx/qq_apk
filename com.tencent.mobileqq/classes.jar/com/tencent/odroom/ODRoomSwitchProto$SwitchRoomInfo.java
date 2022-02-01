package com.tencent.odroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ODRoomSwitchProto$SwitchRoomInfo
  extends MessageMicro<SwitchRoomInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "roomid" }, new Object[] { Integer.valueOf(0) }, SwitchRoomInfo.class);
  public final PBUInt32Field roomid = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.odroom.ODRoomSwitchProto.SwitchRoomInfo
 * JD-Core Version:    0.7.0.1
 */