package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x383$ApplyCopyFromReqBody
  extends MessageMicro<ApplyCopyFromReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_src_file_path = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_src_parent_folder = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_file_name = PBField.initString("");
  public final PBStringField str_local_path = PBField.initString("");
  public final PBUInt32Field uint32_dst_bus_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_bus_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 58, 64, 82 }, new String[] { "uint32_src_bus_id", "bytes_src_parent_folder", "bytes_src_file_path", "uint32_dst_bus_id", "uint64_file_size", "str_local_path", "str_file_name", "uint64_src_uin", "bytes_md5" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), "", "", Long.valueOf(0L), localByteStringMicro3 }, ApplyCopyFromReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyCopyFromReqBody
 * JD-Core Version:    0.7.0.1
 */