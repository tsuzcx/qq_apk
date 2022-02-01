package tencent.im.oidb.cmd0x6d9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6d9$CopyFromReqBody
  extends MessageMicro<CopyFromReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_dst_folder_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_src_file_path = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_src_parent_folder = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_file_name = PBField.initString("");
  public final PBStringField str_local_path = PBField.initString("");
  public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_dst_bus_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_bus_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 58, 64, 74, 82, 88, 98 }, new String[] { "uint64_group_code", "uint32_app_id", "uint32_src_bus_id", "bytes_src_parent_folder", "bytes_src_file_path", "uint32_dst_bus_id", "bytes_dst_folder_id", "uint64_file_size", "str_local_path", "str_file_name", "uint64_src_uin", "bytes_md5" }, new Object[] { localLong, localInteger, localInteger, localByteStringMicro1, localByteStringMicro2, localInteger, localByteStringMicro3, localLong, "", "", localLong, localByteStringMicro4 }, CopyFromReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d9.oidb_0x6d9.CopyFromReqBody
 * JD-Core Version:    0.7.0.1
 */