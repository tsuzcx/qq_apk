package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_feeds_tmem$PicInfo
  extends MessageMicro<PicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField file_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field hight = PBField.initUInt32(0);
  public final PBBytesField lat = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField lng = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field width = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 58, 66 }, new String[] { "url", "hight", "width", "file_id", "pic_md5", "lng", "lat", "city" }, new Object[] { localByteStringMicro1, localInteger, localInteger, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6 }, PicInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_tmem.PicInfo
 * JD-Core Version:    0.7.0.1
 */