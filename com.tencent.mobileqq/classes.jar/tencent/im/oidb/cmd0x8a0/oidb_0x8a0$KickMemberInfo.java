package tencent.im.oidb.cmd0x8a0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8a0$KickMemberInfo
  extends MessageMicro<KickMemberInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField opt_bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field opt_uint32_flag = PBField.initUInt32(0);
  public final PBUInt32Field opt_uint32_operate = PBField.initUInt32(0);
  public final PBUInt64Field opt_uint64_member_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "opt_uint32_operate", "opt_uint64_member_uin", "opt_uint32_flag", "opt_bytes_msg" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, KickMemberInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8a0.oidb_0x8a0.KickMemberInfo
 * JD-Core Version:    0.7.0.1
 */