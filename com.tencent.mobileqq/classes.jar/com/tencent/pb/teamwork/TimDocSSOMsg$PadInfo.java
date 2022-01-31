package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TimDocSSOMsg$PadInfo
  extends MessageMicro<PadInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_delete_flag = PBField.initBool(false);
  public final PBBoolField bool_pinned_flag = PBField.initBool(false);
  public final PBBytesField bytes_creator_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_hostuser_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_last_editor_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_last_viewer_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_localpadid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pad_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_thumb_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_domainid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_policy = PBField.initUInt32(0);
  public final PBUInt32Field uint32_right_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_create_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_creator_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_current_user_browse_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_hostuser_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_auth_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_delete_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_edit_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_editor_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_pinned_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_unpinned_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_view_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_viewer_uin = PBField.initUInt64(0L);
  
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50, 56, 66, 72, 80, 88, 98, 104, 112, 120, 128, 138, 144, 152, 160, 168, 178, 184, 192, 200, 210 }, new String[] { "bytes_pad_url", "uint32_type", "bytes_title", "uint64_create_time", "uint64_creator_uin", "bytes_creator_nick", "uint64_last_editor_uin", "bytes_last_editor_nick", "uint64_last_edit_time", "bool_pinned_flag", "uint64_last_viewer_uin", "bytes_last_viewer_nick", "uint64_last_view_time", "uint64_last_pinned_time", "uint64_current_user_browse_time", "uint64_hostuser_uin", "bytes_hostuser_nick", "uint64_last_auth_time", "uint32_policy", "uint32_right_flag", "uint32_domainid", "bytes_localpadid", "uint64_last_unpinned_time", "bool_delete_flag", "uint64_last_delete_time", "bytes_thumb_url" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro3, Long.valueOf(0L), localByteStringMicro4, Long.valueOf(0L), Boolean.valueOf(false), Long.valueOf(0L), localByteStringMicro5, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro6, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, Long.valueOf(0L), Boolean.valueOf(false), Long.valueOf(0L), localByteStringMicro8 }, PadInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.teamwork.TimDocSSOMsg.PadInfo
 * JD-Core Version:    0.7.0.1
 */