package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x68b$PkgInstallInfo
  extends MessageMicro<PkgInstallInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pkg_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_is_installed = PBField.initUInt32(0);
  public final PBUInt32Field uint32_platform_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "bytes_pkg_name", "uint32_is_installed", "uint32_platform_type", "bytes_version" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, PkgInstallInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PkgInstallInfo
 * JD-Core Version:    0.7.0.1
 */