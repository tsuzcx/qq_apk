package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_new_anchor_follow_interface$FollowActionReq
  extends MessageMicro<FollowActionReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field action = PBField.initUInt32(0);
  public final PBUInt64Field anchor_nowid = PBField.initUInt64(0L);
  public final PBUInt64Field anchor_uin = PBField.initUInt64(0L);
  public final PBUInt32Field client_type = PBField.initUInt32(0);
  public final PBUInt32Field id_type = PBField.initUInt32(0);
  public final PBUInt64Field root_roomid = PBField.initUInt64(0L);
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBUInt64Field subroom_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64 }, new String[] { "anchor_uin", "client_type", "source", "action", "root_roomid", "subroom_id", "anchor_nowid", "id_type" }, new Object[] { localLong, localInteger, localInteger, localInteger, localLong, localLong, localLong, localInteger }, FollowActionReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_new_anchor_follow_interface.FollowActionReq
 * JD-Core Version:    0.7.0.1
 */