package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_nearby_user_control$EnterNearbyUserContrlReq
  extends MessageMicro<EnterNearbyUserContrlReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "user_id", "user_type", "source" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "" }, EnterNearbyUserContrlReq.class);
  public final PBStringField source = PBField.initString("");
  public final PBUInt64Field user_id = PBField.initUInt64(0L);
  public final PBUInt32Field user_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.now.ilive_nearby_user_control.EnterNearbyUserContrlReq
 * JD-Core Version:    0.7.0.1
 */