package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class Qworkflow$Text
  extends MessageMicro
{
  public static final int CONTENT_SUMMARY = 3;
  public static final int CONTENT_TYPE_LINK = 1;
  public static final int CONTENT_TYPE_NUMBER = 2;
  public static final int CONTENT_TYPE_TEXT = 0;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_type = PBField.initEnum(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "enum_type", "bytes_content", "bytes_userdef" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, Text.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.trunk.Qworkflow.Qworkflow.Text
 * JD-Core Version:    0.7.0.1
 */