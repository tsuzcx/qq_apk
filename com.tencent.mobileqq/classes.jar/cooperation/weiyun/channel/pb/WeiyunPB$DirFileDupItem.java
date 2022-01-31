package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeiyunPB$DirFileDupItem
  extends MessageMicro
{
  public static final int CONFLICT_TYPE_FIELD_NUMBER = 1;
  public static final int DUP_DIR_KEY_FIELD_NUMBER = 21;
  public static final int FILENAME_FIELD_NUMBER = 10;
  public static final int FILE_ATTR_FIELD_NUMBER = 9;
  public static final int FILE_ATTR_MTIME_FIELD_NUMBER = 23;
  public static final int FILE_CTIME_FIELD_NUMBER = 4;
  public static final int FILE_CURSIZE_FIELD_NUMBER = 6;
  public static final int FILE_ID_FIELD_NUMBER = 3;
  public static final int FILE_MD5_FIELD_NUMBER = 8;
  public static final int FILE_MTIME_FIELD_NUMBER = 22;
  public static final int FILE_SHA_FIELD_NUMBER = 7;
  public static final int FILE_SIZE_FIELD_NUMBER = 5;
  public static final int FILE_VERSION_FIELD_NUMBER = 12;
  public static final int PDIR_KEY_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public static final int dup_dir = 2;
  public static final int dup_file = 1;
  public final PBInt32Field conflict_type = PBField.initInt32(0);
  public final PBBytesField dup_dir_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field file_attr = PBField.initUInt32(0);
  public final PBUInt64Field file_attr_mtime = PBField.initUInt64(0L);
  public final PBInt64Field file_ctime = PBField.initInt64(0L);
  public final PBInt64Field file_cursize = PBField.initInt64(0L);
  public final PBStringField file_id = PBField.initString("");
  public final PBBytesField file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field file_mtime = PBField.initUInt64(0L);
  public final PBBytesField file_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt64Field file_size = PBField.initInt64(0L);
  public final PBUInt32Field file_version = PBField.initUInt32(0);
  public final PBStringField filename = PBField.initString("");
  public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 58, 66, 72, 82, 96, 170, 176, 184 }, new String[] { "conflict_type", "pdir_key", "file_id", "file_ctime", "file_size", "file_cursize", "file_sha", "file_md5", "file_attr", "filename", "file_version", "dup_dir_key", "file_mtime", "file_attr_mtime" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), "", Integer.valueOf(0), localByteStringMicro4, Long.valueOf(0L), Long.valueOf(0L) }, DirFileDupItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.DirFileDupItem
 * JD-Core Version:    0.7.0.1
 */