package com.tencent.mobileqq.comment.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xdea$PassThrough
  extends MessageMicro<PassThrough>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "entrance", "uint32_client_type" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0) }, PassThrough.class);
  public final PBEnumField entrance = PBField.initEnum(1);
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.oidb.oidb_0xdea.PassThrough
 * JD-Core Version:    0.7.0.1
 */