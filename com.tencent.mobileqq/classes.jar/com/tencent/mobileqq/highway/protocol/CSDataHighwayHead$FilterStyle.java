package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CSDataHighwayHead$FilterStyle
  extends MessageMicro<FilterStyle>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field style_id = PBField.initUInt32(0);
  public final PBBytesField style_name = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "style_id", "style_name" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, FilterStyle.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.FilterStyle
 * JD-Core Version:    0.7.0.1
 */