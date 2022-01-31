package com.tencent.protofile.avredpacket;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AVRedPacketGameSyncInfo$FocusInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "id" }, new Object[] { Integer.valueOf(0) }, FocusInfo.class);
  public final PBUInt32Field id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.protofile.avredpacket.AVRedPacketGameSyncInfo.FocusInfo
 * JD-Core Version:    0.7.0.1
 */