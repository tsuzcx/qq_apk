package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x388$GetPttUrlReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_build_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_bu_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bu_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_codec = PBField.initUInt32(0);
  public final PBUInt32Field uint32_inner_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_auto = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_platform_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_term = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_transfer_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_file_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_fileid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 56, 64, 74, 80, 90, 96, 104, 112, 120 }, new String[] { "uint64_group_code", "uint64_dst_uin", "uint64_fileid", "bytes_file_md5", "uint32_req_term", "uint32_req_platform_type", "uint32_inner_ip", "uint32_bu_type", "bytes_build_ver", "uint64_file_id", "bytes_file_key", "uint32_codec", "uint32_bu_id", "uint32_req_transfer_type", "uint32_is_auto" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetPttUrlReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x388.cmd0x388.GetPttUrlReq
 * JD-Core Version:    0.7.0.1
 */