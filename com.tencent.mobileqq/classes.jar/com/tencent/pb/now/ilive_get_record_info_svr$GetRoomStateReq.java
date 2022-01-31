package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_get_record_info_svr$GetRoomStateReq
  extends MessageMicro<GetRoomStateReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "roomid", "source" }, new Object[] { Integer.valueOf(0), "" }, GetRoomStateReq.class);
  public final PBUInt32Field roomid = PBField.initUInt32(0);
  public final PBStringField source = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.now.ilive_get_record_info_svr.GetRoomStateReq
 * JD-Core Version:    0.7.0.1
 */