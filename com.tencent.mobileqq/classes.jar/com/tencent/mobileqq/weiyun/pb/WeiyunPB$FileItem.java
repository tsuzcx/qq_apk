package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeiyunPB$FileItem
  extends MessageMicro<FileItem>
{
  public static final int APPID_FIELD_NUMBER = 12;
  public static final int APP_DATA_FIELD_NUMBER = 30;
  public static final int APP_NAME_FIELD_NUMBER = 13;
  public static final int BATCH_ID_FIELD_NUMBER = 102;
  public static final int DIFF_VERSION_FIELD_NUMBER = 18;
  public static final int EXT_INFO_FIELD_NUMBER = 21;
  public static final int FILENAME_FIELD_NUMBER = 2;
  public static final int FILE_ATTR_FIELD_NUMBER = 9;
  public static final int FILE_ATTR_MTIME_FIELD_NUMBER = 11;
  public static final int FILE_CTIME_FIELD_NUMBER = 7;
  public static final int FILE_CURSIZE_FIELD_NUMBER = 4;
  public static final int FILE_ID_FIELD_NUMBER = 1;
  public static final int FILE_MD5_FIELD_NUMBER = 6;
  public static final int FILE_MTIME_FIELD_NUMBER = 8;
  public static final int FILE_SHA_FIELD_NUMBER = 5;
  public static final int FILE_SIZE_FIELD_NUMBER = 3;
  public static final int FILE_STATUS_FIELD_NUMBER = 14;
  public static final int FILE_VERSION_FIELD_NUMBER = 10;
  public static final int HAS_BEEN_DELETED_FIELD_NUMBER = 20;
  public static final int LIB_ID_FIELD_NUMBER = 22;
  public static final int OP_RETCODE_FIELD_NUMBER = 101;
  public static final int PDIR_KEY_FIELD_NUMBER = 16;
  public static final int PDIR_NAME_FIELD_NUMBER = 50;
  public static final int PPDIR_KEY_FIELD_NUMBER = 15;
  public static final int STAR_FLAG_FIELD_NUMBER = 17;
  public static final int STAR_TIME_FIELD_NUMBER = 19;
  public static final int VIDEO_TRANSCODE_STATE_FIELD_NUMBER = 23;
  static final MessageMicro.FieldMap __fieldMap__;
  public static final int file_lib_id_CloudAlbum = 24;
  public static final int file_lib_id_Document = 1;
  public static final int file_lib_id_Music = 3;
  public static final int file_lib_id_Other = 5;
  public static final int file_lib_id_Photo = 2;
  public static final int file_lib_id_Video = 4;
  public final PBBytesField app_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField app_name = PBField.initString("");
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBStringField batch_id = PBField.initString("");
  public final PBInt64Field diff_version = PBField.initInt64(0L);
  public WeiyunPB.FileExtInfo ext_info = new WeiyunPB.FileExtInfo();
  public final PBUInt64Field file_attr = PBField.initUInt64(0L);
  public final PBUInt64Field file_attr_mtime = PBField.initUInt64(0L);
  public final PBInt64Field file_ctime = PBField.initInt64(0L);
  public final PBInt64Field file_cursize = PBField.initInt64(0L);
  public final PBStringField file_id = PBField.initString("");
  public final PBBytesField file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt64Field file_mtime = PBField.initInt64(0L);
  public final PBBytesField file_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt64Field file_size = PBField.initInt64(0L);
  public final PBUInt32Field file_status = PBField.initUInt32(0);
  public final PBUInt32Field file_version = PBField.initUInt32(0);
  public final PBStringField filename = PBField.initString("");
  public final PBBoolField has_been_deleted = PBField.initBool(false);
  public final PBInt32Field lib_id = PBField.initInt32(0);
  public final PBInt32Field op_retcode = PBField.initInt32(0);
  public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField pdir_name = PBField.initString("");
  public final PBBytesField ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field star_flag = PBField.initInt32(0);
  public final PBInt64Field star_time = PBField.initInt64(0L);
  public final PBUInt32Field video_transcode_state = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50, 56, 64, 72, 80, 88, 96, 106, 112, 122, 130, 136, 144, 152, 160, 170, 176, 184, 242, 402, 808, 818 }, new String[] { "file_id", "filename", "file_size", "file_cursize", "file_sha", "file_md5", "file_ctime", "file_mtime", "file_attr", "file_version", "file_attr_mtime", "appid", "app_name", "file_status", "ppdir_key", "pdir_key", "star_flag", "diff_version", "star_time", "has_been_deleted", "ext_info", "lib_id", "video_transcode_state", "app_data", "pdir_name", "op_retcode", "batch_id" }, new Object[] { "", "", localLong, localLong, localByteStringMicro1, localByteStringMicro2, localLong, localLong, localLong, localInteger, localLong, localInteger, "", localInteger, localByteStringMicro3, localByteStringMicro4, localInteger, localLong, localLong, Boolean.valueOf(false), null, localInteger, localInteger, localByteStringMicro5, "", localInteger, "" }, FileItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.pb.WeiyunPB.FileItem
 * JD-Core Version:    0.7.0.1
 */