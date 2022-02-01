package com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearbyControl$GetConfigRsp
  extends MessageMicro<GetConfigRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ret_code", "ret_msg", "datas" }, new Object[] { Integer.valueOf(0), "", null }, GetConfigRsp.class);
  public final PBRepeatMessageField<nearbyControl.FlagBuffer> datas = PBField.initRepeatMessage(nearbyControl.FlagBuffer.class);
  public final PBUInt32Field ret_code = PBField.initUInt32(0);
  public final PBStringField ret_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control.nearbyControl.GetConfigRsp
 * JD-Core Version:    0.7.0.1
 */