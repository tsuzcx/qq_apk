package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_get_record_info_svr$GetRoomStateRsp
  extends MessageMicro<GetRoomStateRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50 }, new String[] { "result", "is_on_live", "vid", "recorded_share_url", "another_live_room_id", "another_live_mqq" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Long.valueOf(0L), "" }, GetRoomStateRsp.class);
  public final PBStringField another_live_mqq = PBField.initString("");
  public final PBUInt64Field another_live_room_id = PBField.initUInt64(0L);
  public final PBUInt32Field is_on_live = PBField.initUInt32(0);
  public final PBStringField recorded_share_url = PBField.initString("");
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBStringField vid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_get_record_info_svr.GetRoomStateRsp
 * JD-Core Version:    0.7.0.1
 */