package tencent.im.cs.group_file_common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_file_common$FileInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sha3 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_file_id = PBField.initString("");
  public final PBStringField str_file_name = PBField.initString("");
  public final PBStringField str_local_path = PBField.initString("");
  public final PBStringField str_parent_folder_id = PBField.initString("");
  public final PBStringField str_uploader_name = PBField.initString("");
  public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_dead_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_download_times = PBField.initUInt32(0);
  public final PBUInt32Field uint32_modify_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uploaded_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uploader_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64, 72, 82, 90, 98, 106, 114, 120, 130 }, new String[] { "str_file_id", "str_file_name", "uint64_file_size", "uint32_bus_id", "uint64_uploaded_size", "uint32_upload_time", "uint32_dead_time", "uint32_modify_time", "uint32_download_times", "bytes_sha", "bytes_sha3", "bytes_md5", "str_local_path", "str_uploader_name", "uint64_uploader_uin", "str_parent_folder_id" }, new Object[] { "", "", Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, "", "", Long.valueOf(0L), "" }, FileInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.group_file_common.group_file_common.FileInfo
 * JD-Core Version:    0.7.0.1
 */