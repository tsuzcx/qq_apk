package tencent.im.oidb.cmd0x5e0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x5e0$ProfileTvInfo
  extends MessageMicro<ProfileTvInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_field_str_value = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_field_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_field_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_field_int_value = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_field_id", "uint32_field_type", "uint64_field_int_value", "bytes_field_str_value" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, ProfileTvInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ProfileTvInfo
 * JD-Core Version:    0.7.0.1
 */