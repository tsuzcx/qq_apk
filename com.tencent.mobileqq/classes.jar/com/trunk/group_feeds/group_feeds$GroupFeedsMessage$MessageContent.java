package com.trunk.group_feeds;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_feeds$GroupFeedsMessage$MessageContent
  extends MessageMicro<MessageContent>
{
  public static final int CONTENT_TYPE_CONTROL = 14;
  public static final int CONTENT_TYPE_C_VOTE = 9;
  public static final int CONTENT_TYPE_FACE = 2;
  public static final int CONTENT_TYPE_FILE = 5;
  public static final int CONTENT_TYPE_GBK_FACE = 8;
  public static final int CONTENT_TYPE_LINK = 1;
  public static final int CONTENT_TYPE_MUSIC = 4;
  public static final int CONTENT_TYPE_NC_TAG = 15;
  public static final int CONTENT_TYPE_OBJ_IN_XML = 13;
  public static final int CONTENT_TYPE_PIC = 3;
  public static final int CONTENT_TYPE_PTT = 16;
  public static final int CONTENT_TYPE_TEXT = 0;
  public static final int CONTENT_TYPE_TITLE = 10;
  public static final int CONTENT_TYPE_VIDEO = 6;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_content_value = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_content_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_ori = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_triple_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_music_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_music_url_for_accept = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_music_url_for_refuse = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_music_user_rank = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_object_message_brief = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pic_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pic_path = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pic_size = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_introduction = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_original_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_source = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_swf_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_content_type = PBField.initEnum(0);
  public final PBInt32Field int32_face_idx = PBField.initInt32(0);
  public final PBUInt32Field uint32_file_attr = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_msg_seq = PBField.initUInt32(0);
  public final PBFixed32Field uint32_music_id = PBField.initFixed32(0);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  
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
    ByteStringMicro localByteStringMicro13 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro14 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro15 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro16 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro17 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro18 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro19 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro20 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro21 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro22 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro23 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 69, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 200, 210, 216, 226, 234, 242, 248, 314, 320, 330 }, new String[] { "enum_content_type", "bytes_content_value", "bytes_pic_size", "bytes_pic_path", "bytes_pic_id", "bytes_pic_url", "bytes_music_user_rank", "uint32_music_id", "bytes_music_name", "bytes_music_url_for_accept", "bytes_music_url_for_refuse", "bytes_file_name", "bytes_file_url", "bytes_file_ori", "bytes_pic_md5", "bytes_video_swf_url", "bytes_video_original_url", "bytes_video_id", "bytes_video_introduction", "int32_face_idx", "bytes_video_source", "uint64_file_size", "bytes_file_content_sha", "bytes_file_triple_sha", "bytes_file_md5", "uint32_file_attr", "bytes_object_message_brief", "uint32_group_msg_seq", "bytes_file_uuid" }, new Object[] { localInteger, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localInteger, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, localByteStringMicro11, localByteStringMicro12, localByteStringMicro13, localByteStringMicro14, localByteStringMicro15, localByteStringMicro16, localByteStringMicro17, localInteger, localByteStringMicro18, Long.valueOf(0L), localByteStringMicro19, localByteStringMicro20, localByteStringMicro21, localInteger, localByteStringMicro22, localInteger, localByteStringMicro23 }, MessageContent.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.trunk.group_feeds.group_feeds.GroupFeedsMessage.MessageContent
 * JD-Core Version:    0.7.0.1
 */