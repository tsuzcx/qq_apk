package com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class nearbyControl$GetTabConfigRsp
  extends MessageMicro<GetTabConfigRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "tab_config" }, new Object[] { null }, GetTabConfigRsp.class);
  public final PBRepeatMessageField<nearbyControl.TabConfig> tab_config = PBField.initRepeatMessage(nearbyControl.TabConfig.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control.nearbyControl.GetTabConfigRsp
 * JD-Core Version:    0.7.0.1
 */