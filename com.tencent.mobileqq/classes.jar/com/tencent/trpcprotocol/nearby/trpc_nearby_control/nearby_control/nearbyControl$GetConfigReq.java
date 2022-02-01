package com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class nearbyControl$GetConfigReq
  extends MessageMicro<GetConfigReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "keys", "dimensions" }, new Object[] { null, null }, GetConfigReq.class);
  public nearbyControl.MatchDimension dimensions = new nearbyControl.MatchDimension();
  public final PBRepeatMessageField<nearbyControl.FlagBuffer> keys = PBField.initRepeatMessage(nearbyControl.FlagBuffer.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control.nearbyControl.GetConfigReq
 * JD-Core Version:    0.7.0.1
 */