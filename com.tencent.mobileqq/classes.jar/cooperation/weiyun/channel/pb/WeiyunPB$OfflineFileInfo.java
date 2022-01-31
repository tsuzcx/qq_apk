package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeiyunPB$OfflineFileInfo
  extends MessageMicro<OfflineFileInfo>
{
  public static final int BYTES_10M_MD5_FIELD_NUMBER = 100;
  public static final int BYTES_UUID_FIELD_NUMBER = 6;
  public static final int STR_FILE_NAME_FIELD_NUMBER = 7;
  public static final int UINT32_ABS_FILE_TYPE_FIELD_NUMBER = 90;
  public static final int UINT32_DANGER_EVEL_FIELD_NUMBER = 2;
  public static final int UINT32_LIFE_TIME_FIELD_NUMBER = 4;
  public static final int UINT32_UPLOAD_TIME_FIELD_NUMBER = 5;
  public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 3;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_10m_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_file_name = PBField.initString("");
  public final PBUInt32Field uint32_abs_file_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_danger_evel = PBField.initUInt32(0);
  public final PBUInt32Field uint32_life_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 720, 802 }, new String[] { "uint64_uin", "uint32_danger_evel", "uint64_file_size", "uint32_life_time", "uint32_upload_time", "bytes_uuid", "str_file_name", "uint32_abs_file_type", "bytes_10m_md5" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, "", Integer.valueOf(0), localByteStringMicro2 }, OfflineFileInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.OfflineFileInfo
 * JD-Core Version:    0.7.0.1
 */