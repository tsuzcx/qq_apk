package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ilive_feeds_tmem$PicFeed
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField feed_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField infos = PBField.initRepeatMessage(ilive_feeds_tmem.PicInfo.class);
  public final PBRepeatField topic = PBField.initRepeat(PBBytesField.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "topic", "desc", "infos", "feed_md5" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, localByteStringMicro3 }, PicFeed.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_tmem.PicFeed
 * JD-Core Version:    0.7.0.1
 */