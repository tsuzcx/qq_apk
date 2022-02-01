package com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearbyControl$ControlFlag
  extends MessageMicro<ControlFlag>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field flag_id = PBField.initUInt32(0);
  public final PBUInt32Field value = PBField.initUInt32(0);
  public final PBStringField wording = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "flag_id", "value", "wording" }, new Object[] { localInteger, localInteger, "" }, ControlFlag.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control.nearbyControl.ControlFlag
 * JD-Core Version:    0.7.0.1
 */