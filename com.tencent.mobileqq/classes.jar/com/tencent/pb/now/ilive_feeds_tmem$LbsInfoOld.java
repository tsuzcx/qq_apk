package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class ilive_feeds_tmem$LbsInfoOld
  extends MessageMicro<LbsInfoOld>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField lat = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField lng = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField location = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "lng", "lat", "location" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, LbsInfoOld.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_tmem.LbsInfoOld
 * JD-Core Version:    0.7.0.1
 */