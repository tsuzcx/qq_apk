package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PicSearchSvr$ImgInfo
  extends MessageMicro<ImgInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_img_down_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_img_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_img_other = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pack_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_resource_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_src_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_thumb_down_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_thumb_img_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_web_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public PicSearchSvr.EmotionInfo msg_emotion_info = new PicSearchSvr.EmotionInfo();
  public final PBUInt32Field uint32_img_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_img_width = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pack_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_img_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_img_width = PBField.initUInt32(0);
  public final PBUInt64Field uint64_img_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_thumb_size = PBField.initUInt64(0L);
  
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 58, 64, 72, 82, 88, 98, 104, 114, 122, 130, 138, 144, 154 }, new String[] { "bytes_resource_id", "bytes_img_md5", "uint32_img_width", "uint32_img_height", "bytes_img_down_url", "uint64_img_size", "bytes_thumb_img_md5", "uint32_thumb_img_width", "uint32_thumb_img_height", "bytes_thumb_down_url", "uint64_thumb_size", "bytes_img_other", "uint32_src_type", "bytes_src_desc", "bytes_web_url", "bytes_icon_url", "bytes_pack_name", "uint32_pack_id", "msg_emotion_info" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localInteger, localInteger, localByteStringMicro3, Long.valueOf(0L), localByteStringMicro4, localInteger, localInteger, localByteStringMicro5, Long.valueOf(0L), localByteStringMicro6, localInteger, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, localInteger, null }, ImgInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.emosm.PicSearchSvr.ImgInfo
 * JD-Core Version:    0.7.0.1
 */