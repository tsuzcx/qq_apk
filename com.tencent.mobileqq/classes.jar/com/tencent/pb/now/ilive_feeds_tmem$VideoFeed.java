package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_feeds_tmem$VideoFeed
  extends MessageMicro<VideoFeed>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field anchor_uin = PBField.initUInt64(0L);
  public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField doodle_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field end_time = PBField.initUInt32(0);
  public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField file_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field has_face = PBField.initUInt32(0);
  public final PBBytesField lat = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField lng = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field start_time = PBField.initUInt32(0);
  public final PBRepeatField<ByteStringMicro> topic = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_hight = PBField.initUInt32(0);
  public final PBBytesField video_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_time = PBField.initUInt32(0);
  public final PBBytesField video_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_width = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro12 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 56, 64, 72, 82, 90, 96, 104, 114, 122, 130, 138, 146, 152 }, new String[] { "pic_url", "video_url", "anchor_uin", "topic", "desc", "file_id", "video_width", "video_hight", "video_time", "video_md5", "vid", "start_time", "end_time", "doodle_pic_url", "lng", "lat", "city", "feed_id", "has_face" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localInteger, localInteger, localInteger, localByteStringMicro6, localByteStringMicro7, localInteger, localInteger, localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, localByteStringMicro11, localByteStringMicro12, localInteger }, VideoFeed.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_tmem.VideoFeed
 * JD-Core Version:    0.7.0.1
 */