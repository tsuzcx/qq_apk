package com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearbyControl$GetMasterControlReq
  extends MessageMicro<GetMasterControlReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "source", "req_flag" }, new Object[] { "", Integer.valueOf(0) }, GetMasterControlReq.class);
  public final PBRepeatField<Integer> req_flag = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBStringField source = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control.nearbyControl.GetMasterControlReq
 * JD-Core Version:    0.7.0.1
 */