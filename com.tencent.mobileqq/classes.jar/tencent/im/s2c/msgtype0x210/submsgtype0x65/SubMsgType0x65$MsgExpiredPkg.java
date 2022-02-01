package tencent.im.s2c.msgtype0x210.submsgtype0x65;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x65$MsgExpiredPkg
  extends MessageMicro<MsgExpiredPkg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_expire_pkg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_predown_pkg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_platform", "bytes_expire_pkg", "bytes_predown_pkg" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, MsgExpiredPkg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x65.SubMsgType0x65.MsgExpiredPkg
 * JD-Core Version:    0.7.0.1
 */