package localpb.richMsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class RichMsg$VideoFile
  extends MessageMicro<VideoFile>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_is_mediacodec_encode = PBField.initBool(false);
  public final PBBoolField bool_story_video_send_to_recent = PBField.initBool(false);
  public final PBBoolField bool_support_progressive = PBField.initBool(false);
  public final PBBytesField bytes_camera_video_templateid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_hotvideo_icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_hotvideo_icon_sub = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_hotvideo_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_hotvideo_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_local_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_shortVideoId = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_source = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_thumb_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_file_source_dir = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field file_lastmodified = PBField.initUInt64(0L);
  public final PBUInt32Field red_envelope_pay_stat = PBField.initUInt32(0);
  public final PBUInt32Field uin32_from_chat_type = PBField.initUInt32(0);
  public final PBUInt32Field uin32_to_chat_type = PBField.initUInt32(0);
  public final PBUInt32Field uin32_uiOperatorFlag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_busi_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_format = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_progress = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_width = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_local_video = PBField.initUInt32(0);
  public final PBUInt32Field uint32_long_video_kandian_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_tail_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_red_envelope_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_special_video_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_busi_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_file_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_width = PBField.initUInt32(0);
  public final PBUInt32Field uint32_transfered_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_attr = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_binary_set = PBField.initUInt32(0);
  
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
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro12 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro13 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 64, 72, 80, 88, 98, 106, 112, 120, 128, 136, 144, 152, 162, 168, 176, 184, 194, 200, 208, 216, 224, 232, 240, 250, 258, 266, 274, 280, 288, 296, 306, 312, 320, 328, 338 }, new String[] { "bytes_file_uuid", "bytes_file_md5", "bytes_file_name", "uint32_file_format", "uint32_file_time", "uint32_file_size", "uint32_thumb_width", "uint32_thumb_height", "uint32_file_status", "uint32_file_progress", "uint32_file_type", "bytes_thumb_file_md5", "bytes_source", "file_lastmodified", "uint32_thumb_file_size", "uint32_busi_type", "uin32_from_chat_type", "uin32_to_chat_type", "uin32_uiOperatorFlag", "bytes_video_file_source_dir", "bool_support_progressive", "uint32_file_width", "uint32_file_height", "bytes_local_file_md5", "uint32_is_local_video", "uint32_transfered_size", "uint32_sub_busi_type", "uint32_video_attr", "uint32_video_binary_set", "bool_is_mediacodec_encode", "bytes_hotvideo_icon", "bytes_hotvideo_title", "bytes_hotvideo_url", "bytes_hotvideo_icon_sub", "uint32_special_video_type", "uint32_msg_tail_type", "uint32_red_envelope_type", "bytes_shortVideoId", "red_envelope_pay_stat", "uint32_long_video_kandian_type", "bool_story_video_send_to_recent", "bytes_camera_video_templateid" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, localByteStringMicro11, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro12, Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), localByteStringMicro13 }, VideoFile.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     localpb.richMsg.RichMsg.VideoFile
 * JD-Core Version:    0.7.0.1
 */