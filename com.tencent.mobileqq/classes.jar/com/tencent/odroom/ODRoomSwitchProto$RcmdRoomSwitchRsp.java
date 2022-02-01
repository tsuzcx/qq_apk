package com.tencent.odroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ODRoomSwitchProto$RcmdRoomSwitchRsp
  extends MessageMicro<RcmdRoomSwitchRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "ret", "front_list", "after_list", "update_time" }, new Object[] { Integer.valueOf(0), null, null, Integer.valueOf(20) }, RcmdRoomSwitchRsp.class);
  public final PBRepeatMessageField<ODRoomSwitchProto.SwitchRoomInfo> after_list = PBField.initRepeatMessage(ODRoomSwitchProto.SwitchRoomInfo.class);
  public final PBRepeatMessageField<ODRoomSwitchProto.SwitchRoomInfo> front_list = PBField.initRepeatMessage(ODRoomSwitchProto.SwitchRoomInfo.class);
  public final PBUInt32Field ret = PBField.initUInt32(0);
  public final PBUInt32Field update_time = PBField.initUInt32(20);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.odroom.ODRoomSwitchProto.RcmdRoomSwitchRsp
 * JD-Core Version:    0.7.0.1
 */