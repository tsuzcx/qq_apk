package tencent.im.oidb.cmd0x98b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x98b$ClickPackageRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_failed_notice = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_boom_rate = PBField.initUInt32(0);
  public final PBUInt32Field uint32_interval = PBField.initUInt32(1);
  public final PBUInt32Field uint32_is_boom = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_is_boom", "uint32_interval", "uint32_boom_rate", "bytes_failed_notice" }, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), localByteStringMicro }, ClickPackageRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x98b.oidb_0x98b.ClickPackageRsp
 * JD-Core Version:    0.7.0.1
 */