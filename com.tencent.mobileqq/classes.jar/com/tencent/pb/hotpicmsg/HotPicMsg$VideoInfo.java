package com.tencent.pb.hotpicmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class HotPicMsg$VideoInfo
  extends MessageMicro<VideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_certificated_icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_preview_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_preview_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_source = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_preview_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_preview_width = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_width = PBField.initUInt32(0);
  public final PBUInt64Field uint64_preview_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_video_length = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_video_size = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 48, 58, 66, 74, 82, 88, 96, 104, 114, 122, 130, 136 }, new String[] { "bytes_preview_md5", "uint64_preview_size", "uint32_preview_width", "uint32_preview_height", "bytes_preview_uuid", "uint32_video_index", "bytes_jump_icon", "bytes_jump_url", "bytes_video_name", "bytes_video_source", "uint64_video_length", "uint32_video_width", "uint32_video_height", "bytes_video_uuid", "bytes_video_md5", "bytes_certificated_icon", "uint64_video_size" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, Long.valueOf(0L) }, VideoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.hotpicmsg.HotPicMsg.VideoInfo
 * JD-Core Version:    0.7.0.1
 */