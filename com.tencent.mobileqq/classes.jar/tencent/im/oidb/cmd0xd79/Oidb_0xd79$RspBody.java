package tencent.im.oidb.cmd0xd79;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0xd79$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_raw_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_compress_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ret = PBField.initUInt32(0);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint32_ret", "uint64_seq", "uint64_uin", "uint32_compress_flag", "bytes_raw_content" }, new Object[] { localInteger, localLong, localLong, localInteger, localByteStringMicro }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd79.Oidb_0xd79.RspBody
 * JD-Core Version:    0.7.0.1
 */