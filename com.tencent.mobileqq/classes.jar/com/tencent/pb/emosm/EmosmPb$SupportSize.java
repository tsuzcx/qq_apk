package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class EmosmPb$SupportSize
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "u32_Width", "u32_height" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, SupportSize.class);
  public final PBUInt32Field u32_Width = PBField.initUInt32(0);
  public final PBUInt32Field u32_height = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SupportSize
 * JD-Core Version:    0.7.0.1
 */