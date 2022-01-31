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

public final class WeiyunPB$DiskPicBackupReq
  extends MessageMicro<DiskPicBackupReq>
{
  public static final int AUTO_CREATE_USER_FIELD_NUMBER = 9;
  public static final int AUTO_FLAG_FIELD_NUMBER = 11;
  public static final int BACKUP_DIR_NAME_FIELD_NUMBER = 10;
  public static final int BACKUP_TYPE_FIELD_NUMBER = 31;
  public static final int EDIT_FIELD_NUMBER = 41;
  public static final int EXT_INFO_FIELD_NUMBER = 21;
  public static final int FILENAME_FIELD_NUMBER = 1;
  public static final int FILE_EXIST_OPTION_FIELD_NUMBER = 7;
  public static final int FILE_MD5_FIELD_NUMBER = 3;
  public static final int FILE_SHA_FIELD_NUMBER = 2;
  public static final int FILE_SIZE_FIELD_NUMBER = 4;
  public static final int FIRST_256K_CRC_FIELD_NUMBER = 13;
  public static final int UPLOAD_TYPE_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField auto_create_user = PBField.initBool(false);
  public final PBBoolField auto_flag = PBField.initBool(false);
  public final PBStringField backup_dir_name = PBField.initString("");
  public final PBUInt32Field backup_type = PBField.initUInt32(0);
  public final PBBoolField edit = PBField.initBool(false);
  public WeiyunPB.FileExtInfo ext_info = new WeiyunPB.FileExtInfo();
  public final PBUInt32Field file_exist_option = PBField.initUInt32(0);
  public final PBBytesField file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField file_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field file_size = PBField.initUInt64(0L);
  public final PBStringField filename = PBField.initString("");
  public final PBUInt32Field first_256k_crc = PBField.initUInt32(0);
  public final PBUInt32Field upload_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 56, 72, 82, 88, 104, 170, 248, 328 }, new String[] { "filename", "file_sha", "file_md5", "file_size", "upload_type", "file_exist_option", "auto_create_user", "backup_dir_name", "auto_flag", "first_256k_crc", "ext_info", "backup_type", "edit" }, new Object[] { "", localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), "", Boolean.valueOf(false), Integer.valueOf(0), null, Integer.valueOf(0), Boolean.valueOf(false) }, DiskPicBackupReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.DiskPicBackupReq
 * JD-Core Version:    0.7.0.1
 */