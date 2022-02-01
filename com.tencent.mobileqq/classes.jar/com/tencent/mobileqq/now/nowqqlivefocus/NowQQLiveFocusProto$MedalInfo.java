package com.tencent.mobileqq.now.nowqqlivefocus;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowQQLiveFocusProto$MedalInfo
  extends MessageMicro<MedalInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field create_time = PBField.initUInt64(0L);
  public final PBStringField logo_full_url = PBField.initString("");
  public final PBUInt32Field medal_bg = PBField.initUInt32(0);
  public final PBBytesField medal_bg_img = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField medal_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field medal_end_time = PBField.initUInt64(0L);
  public final PBBytesField medal_face_bigger = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField medal_face_small = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field medal_frame = PBField.initUInt32(0);
  public final PBUInt32Field medal_id = PBField.initUInt32(0);
  public final PBUInt32Field medal_index = PBField.initUInt32(0);
  public final PBUInt32Field medal_level = PBField.initUInt32(0);
  public final PBBytesField medal_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field medal_point = PBField.initUInt32(0);
  public final PBUInt32Field medal_priority_level = PBField.initUInt32(0);
  public final PBUInt64Field medal_start_time = PBField.initUInt64(0L);
  public final PBUInt32Field medal_type = PBField.initUInt32(0);
  public final PBUInt64Field medal_uid = PBField.initUInt64(0L);
  public final PBBytesField medal_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field medal_version = PBField.initUInt32(0);
  public final PBUInt64Field update_time = PBField.initUInt64(0L);
  public final PBStringField user_nick = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 66, 74, 82, 88, 96, 104, 112, 120, 128, 136, 144, 154, 160, 170, 178 }, new String[] { "medal_id", "medal_name", "medal_face_small", "medal_type", "medal_start_time", "medal_end_time", "medal_priority_level", "medal_desc", "medal_url", "medal_face_bigger", "medal_version", "medal_index", "medal_level", "medal_point", "create_time", "update_time", "medal_bg", "medal_frame", "medal_bg_img", "medal_uid", "user_nick", "logo_full_url" }, new Object[] { localInteger, localByteStringMicro1, localByteStringMicro2, localInteger, localLong, localLong, localInteger, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localInteger, localInteger, localInteger, localInteger, localLong, localLong, localInteger, localInteger, localByteStringMicro6, localLong, "", "" }, MedalInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.nowqqlivefocus.NowQQLiveFocusProto.MedalInfo
 * JD-Core Version:    0.7.0.1
 */