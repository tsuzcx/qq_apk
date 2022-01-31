package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeiyunPB$QqSdkFileUploadMsgReq
  extends MessageMicro
{
  public static final int AUTO_CREATE_USER_FIELD_NUMBER = 11;
  public static final int EXT_INFO_FIELD_NUMBER = 20;
  public static final int FILENAME_FIELD_NUMBER = 3;
  public static final int FILE_ATTR_FIELD_NUMBER = 8;
  public static final int FILE_ATTR_MTIME_FIELD_NUMBER = 7;
  public static final int FILE_EXIST_OPTION_FIELD_NUMBER = 10;
  public static final int FILE_MD5_FIELD_NUMBER = 5;
  public static final int FILE_SHA_FIELD_NUMBER = 4;
  public static final int FILE_SIZE_FIELD_NUMBER = 6;
  public static final int PDIR_KEY_FIELD_NUMBER = 2;
  public static final int PPDIR_KEY_FIELD_NUMBER = 1;
  public static final int UPLOAD_TYPE_FIELD_NUMBER = 9;
  public static final int USE_MUTIL_CHANNEL_FIELD_NUMBER = 30;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField auto_create_user = PBField.initBool(false);
  public WeiyunPB.FileExtInfo ext_info = new WeiyunPB.FileExtInfo();
  public final PBUInt64Field file_attr = PBField.initUInt64(0L);
  public final PBUInt64Field file_attr_mtime = PBField.initUInt64(0L);
  public final PBUInt32Field file_exist_option = PBField.initUInt32(0);
  public final PBBytesField file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField file_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field file_size = PBField.initUInt64(0L);
  public final PBStringField filename = PBField.initString("");
  public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field upload_type = PBField.initUInt32(0);
  public final PBBoolField use_mutil_channel = PBField.initBool(false);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 64, 72, 80, 88, 162, 240 }, new String[] { "ppdir_key", "pdir_key", "filename", "file_sha", "file_md5", "file_size", "file_attr_mtime", "file_attr", "upload_type", "file_exist_option", "auto_create_user", "ext_info", "use_mutil_channel" }, new Object[] { localByteStringMicro1, localByteStringMicro2, "", localByteStringMicro3, localByteStringMicro4, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), null, Boolean.valueOf(false) }, QqSdkFileUploadMsgReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.QqSdkFileUploadMsgReq
 * JD-Core Version:    0.7.0.1
 */