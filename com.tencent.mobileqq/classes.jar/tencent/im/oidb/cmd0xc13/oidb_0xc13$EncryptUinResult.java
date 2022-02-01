package tencent.im.oidb.cmd0xc13;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xc13$EncryptUinResult
  extends MessageMicro<EncryptUinResult>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_encrypt_uin = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBUInt64Field uint64_original_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_original_uin", "int32_result", "bytes_encrypt_uin" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, EncryptUinResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc13.oidb_0xc13.EncryptUinResult
 * JD-Core Version:    0.7.0.1
 */