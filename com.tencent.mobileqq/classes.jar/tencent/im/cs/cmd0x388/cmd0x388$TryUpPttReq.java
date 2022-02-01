package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x388$TryUpPttReq
  extends MessageMicro<TryUpPttReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_new_up_chan = PBField.initBool(false);
  public final PBBytesField bytes_build_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_bu_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bu_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_codec = PBField.initUInt32(0);
  public final PBUInt32Field uint32_inner_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_platform_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
  public final PBUInt32Field uint32_voice_length = PBField.initUInt32(0);
  public final PBUInt32Field uint32_voice_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_id = PBField.initUInt64(0L);
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 56, 64, 72, 82, 88, 96, 104, 112, 120, 128 }, new String[] { "uint64_group_code", "uint64_src_uin", "uint64_file_id", "bytes_file_md5", "uint64_file_size", "bytes_file_name", "uint32_src_term", "uint32_platform_type", "uint32_bu_type", "bytes_build_ver", "uint32_inner_ip", "uint32_voice_length", "bool_new_up_chan", "uint32_codec", "uint32_voice_type", "uint32_bu_id" }, new Object[] { localLong, localLong, localLong, localByteStringMicro1, localLong, localByteStringMicro2, localInteger, localInteger, localInteger, localByteStringMicro3, localInteger, localInteger, Boolean.valueOf(false), localInteger, localInteger, localInteger }, TryUpPttReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0x388.cmd0x388.TryUpPttReq
 * JD-Core Version:    0.7.0.1
 */