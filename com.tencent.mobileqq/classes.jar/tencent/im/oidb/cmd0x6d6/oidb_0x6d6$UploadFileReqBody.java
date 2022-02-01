package tencent.im.oidb.cmd0x6d6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6d6$UploadFileReqBody
  extends MessageMicro<UploadFileReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_support_multi_upload = PBField.initBool(false);
  public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sha3 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_file_name = PBField.initString("");
  public final PBStringField str_local_path = PBField.initString("");
  public final PBStringField str_parent_folder_id = PBField.initString("");
  public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_entrance = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 64, 74, 82, 90, 120 }, new String[] { "uint64_group_code", "uint32_app_id", "uint32_bus_id", "uint32_entrance", "str_parent_folder_id", "str_file_name", "str_local_path", "uint64_file_size", "bytes_sha", "bytes_sha3", "bytes_md5", "bool_support_multi_upload" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Boolean.valueOf(false) }, UploadFileReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileReqBody
 * JD-Core Version:    0.7.0.1
 */