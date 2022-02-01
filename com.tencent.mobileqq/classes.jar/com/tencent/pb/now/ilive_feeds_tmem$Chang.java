package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_feeds_tmem$Chang
  extends MessageMicro<Chang>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field change_type = PBField.initUInt32(0);
  public final PBUInt32Field create_time = PBField.initUInt32(0);
  public final PBBytesField id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "id", "change_type", "create_time" }, new Object[] { localByteStringMicro, localInteger, localInteger }, Chang.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_tmem.Chang
 * JD-Core Version:    0.7.0.1
 */