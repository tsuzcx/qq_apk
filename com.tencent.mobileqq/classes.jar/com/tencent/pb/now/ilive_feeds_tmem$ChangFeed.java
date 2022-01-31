package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_feeds_tmem$ChangFeed
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField chang = PBField.initRepeatMessage(ilive_feeds_tmem.Chang.class);
  public final PBBytesField desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field hight = PBField.initUInt32(0);
  public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public ilive_feeds_tmem.Chang replay = new ilive_feeds_tmem.Chang();
  public final PBUInt32Field roomid = PBField.initUInt32(0);
  public final PBUInt32Field short_video_num = PBField.initUInt32(0);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field view_num = PBField.initUInt32(0);
  public final PBUInt32Field width = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50, 58, 64, 72, 80 }, new String[] { "chang", "pic_url", "vid", "width", "hight", "replay", "desc", "short_video_num", "roomid", "view_num" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ChangFeed.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_tmem.ChangFeed
 * JD-Core Version:    0.7.0.1
 */