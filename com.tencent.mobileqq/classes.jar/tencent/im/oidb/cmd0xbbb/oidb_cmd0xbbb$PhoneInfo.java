package tencent.im.oidb.cmd0xbbb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbbb$PhoneInfo
  extends MessageMicro<PhoneInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_appid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_client_ip = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_muid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_os_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_qq_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_carrier = PBField.initUInt32(0);
  public final PBUInt32Field uint32_conn = PBField.initUInt32(0);
  public final PBUInt32Field uint32_muid_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_os_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58, 66, 72 }, new String[] { "bytes_muid", "uint32_conn", "uint32_carrier", "uint32_muid_type", "bytes_os_ver", "bytes_qq_ver", "bytes_client_ip", "bytes_appid", "uint32_os_type" }, new Object[] { localByteStringMicro1, localInteger, localInteger, localInteger, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localInteger }, PhoneInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbbb.oidb_cmd0xbbb.PhoneInfo
 * JD-Core Version:    0.7.0.1
 */