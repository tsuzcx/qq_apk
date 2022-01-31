package tencent.im.oidb.oidb_0x8e7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8e7$ExtParam
  extends MessageMicro<ExtParam>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x8e7.LoginSig msg_login_sig = new oidb_0x8e7.LoginSig();
  public final PBUInt32Field uint32_client = PBField.initUInt32(0);
  public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "msg_login_sig", "bytes_version", "uint32_portal", "uint32_client" }, new Object[] { null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, ExtParam.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.ExtParam
 * JD-Core Version:    0.7.0.1
 */