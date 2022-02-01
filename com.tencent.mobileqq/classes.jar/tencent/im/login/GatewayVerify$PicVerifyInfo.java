package tencent.im.login;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GatewayVerify$PicVerifyInfo
  extends MessageMicro<PicVerifyInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_rand_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_verify_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_appid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_appid", "bytes_verify_sig", "bytes_rand_key" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, PicVerifyInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.PicVerifyInfo
 * JD-Core Version:    0.7.0.1
 */