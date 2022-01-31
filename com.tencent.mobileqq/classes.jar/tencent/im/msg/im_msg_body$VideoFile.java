package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$VideoFile
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_support_progressive = PBField.initBool(false);
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_source = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_thumb_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField rpt_bytes_thumb_file_urls = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField rpt_bytes_video_file_urls = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt32Field uint32_busi_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_format = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_width = PBField.initUInt32(0);
  public final PBUInt32Field uint32_from_chat_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_busi_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_download_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_file_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_width = PBField.initUInt32(0);
  public final PBUInt32Field uint32_to_chat_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_attr = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_download_flag = PBField.initUInt32(0);
  
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 64, 74, 82, 88, 96, 104, 112, 120, 128, 136, 144, 152, 162, 170, 176, 184, 194 }, new String[] { "bytes_file_uuid", "bytes_file_md5", "bytes_file_name", "uint32_file_format", "uint32_file_time", "uint32_file_size", "uint32_thumb_width", "uint32_thumb_height", "bytes_thumb_file_md5", "bytes_source", "uint32_thumb_file_size", "uint32_busi_type", "uint32_from_chat_type", "uint32_to_chat_type", "bool_support_progressive", "uint32_file_width", "uint32_file_height", "uint32_sub_busi_type", "uint32_video_attr", "rpt_bytes_thumb_file_urls", "rpt_bytes_video_file_urls", "uint32_thumb_download_flag", "uint32_video_download_flag", "bytes_pb_reserve" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro8 }, VideoFile.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.VideoFile
 * JD-Core Version:    0.7.0.1
 */