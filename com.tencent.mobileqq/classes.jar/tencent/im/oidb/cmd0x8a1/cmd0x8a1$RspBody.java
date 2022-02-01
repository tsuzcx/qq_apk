package tencent.im.oidb.cmd0x8a1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x8a1$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_security_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_sign = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_create_option = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_code = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_uin = PBField.initUInt32(0);
  public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58 }, new String[] { "uint32_create_option", "uint32_group_code", "uint32_group_uin", "uint64_owner_uin", "uint32_group_size", "string_sign", "bytes_security_buffer" }, new Object[] { localInteger, localInteger, localInteger, Long.valueOf(0L), localInteger, localByteStringMicro1, localByteStringMicro2 }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8a1.cmd0x8a1.RspBody
 * JD-Core Version:    0.7.0.1
 */