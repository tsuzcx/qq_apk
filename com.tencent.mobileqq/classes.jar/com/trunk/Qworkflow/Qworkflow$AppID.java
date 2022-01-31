package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Qworkflow$AppID
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_type", "uint64_appid" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, AppID.class);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_appid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.trunk.Qworkflow.Qworkflow.AppID
 * JD-Core Version:    0.7.0.1
 */