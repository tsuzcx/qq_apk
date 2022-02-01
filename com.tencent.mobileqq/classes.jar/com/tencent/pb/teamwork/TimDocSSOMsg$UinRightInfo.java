package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TimDocSSOMsg$UinRightInfo
  extends MessageMicro<UinRightInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_uin_type", "uint64_uin", "uint32_right" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, UinRightInfo.class);
  public final PBUInt32Field uint32_right = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uin_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo
 * JD-Core Version:    0.7.0.1
 */