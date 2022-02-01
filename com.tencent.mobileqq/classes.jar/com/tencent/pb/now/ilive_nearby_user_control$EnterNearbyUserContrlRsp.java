package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_nearby_user_control$EnterNearbyUserContrlRsp
  extends MessageMicro<EnterNearbyUserContrlRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "check_ret", "check_msg" }, new Object[] { Integer.valueOf(0), "" }, EnterNearbyUserContrlRsp.class);
  public final PBStringField check_msg = PBField.initString("");
  public final PBUInt32Field check_ret = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.ilive_nearby_user_control.EnterNearbyUserContrlRsp
 * JD-Core Version:    0.7.0.1
 */