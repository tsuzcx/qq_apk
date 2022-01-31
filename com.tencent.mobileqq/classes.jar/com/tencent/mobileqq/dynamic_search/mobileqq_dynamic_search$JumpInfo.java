package com.tencent.mobileqq.dynamic_search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class mobileqq_dynamic_search$JumpInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field flag = PBField.initInt32(0);
  public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "url", "title", "flag" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, JumpInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.JumpInfo
 * JD-Core Version:    0.7.0.1
 */