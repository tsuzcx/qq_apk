package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_feeds_near_anchor$NearAnchorInfo
  extends MessageMicro<NearAnchorInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field anchor_type = PBField.initUInt32(0);
  public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field create_time = PBField.initUInt32(0);
  public final PBDoubleField distance = PBField.initDouble(0.0D);
  public final PBUInt32Field jump_type = PBField.initUInt32(0);
  public final PBBytesField lable_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField medal_face = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field pic_time = PBField.initUInt32(0);
  public final PBBytesField room_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field root_roomid = PBField.initUInt32(0);
  public final PBUInt32Field start_time = PBField.initUInt32(0);
  public final PBUInt32Field sub_roomid = PBField.initUInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 33, 42, 50, 56, 66, 72, 82, 88, 96, 106, 112 }, new String[] { "uid", "root_roomid", "sub_roomid", "distance", "room_name", "cover_url", "create_time", "city", "start_time", "medal_face", "pic_time", "anchor_type", "lable_url", "jump_type" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, Double.valueOf(0.0D), localByteStringMicro1, localByteStringMicro2, localInteger, localByteStringMicro3, localInteger, localByteStringMicro4, localInteger, localInteger, localByteStringMicro5, localInteger }, NearAnchorInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo
 * JD-Core Version:    0.7.0.1
 */