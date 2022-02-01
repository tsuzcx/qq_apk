package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class EmosmPb$SupportSize
  extends MessageMicro<SupportSize>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field u32_Width = PBField.initUInt32(0);
  public final PBUInt32Field u32_height = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "u32_Width", "u32_height" }, new Object[] { localInteger, localInteger }, SupportSize.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SupportSize
 * JD-Core Version:    0.7.0.1
 */