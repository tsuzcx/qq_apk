package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x346$ApplyCopyFromReq
  extends MessageMicro<ApplyCopyFromReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_src_parentfolder = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_src_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_file_name = PBField.initString("");
  public final PBUInt32Field uint32_danger_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_svcid = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_src_group = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 240, 322, 402, 482, 560, 640, 722, 800, 880 }, new String[] { "uint64_src_uin", "uint64_src_group", "uint32_src_svcid", "bytes_src_parentfolder", "bytes_src_uuid", "bytes_file_md5", "uint64_dst_uin", "uint64_file_size", "str_file_name", "uint32_danger_level", "uint64_total_space" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L) }, ApplyCopyFromReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyFromReq
 * JD-Core Version:    0.7.0.1
 */