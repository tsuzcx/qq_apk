package tencent.im.oidb.cmd0x8f7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x8f7$ApplyDownAbsRsp
  extends MessageMicro<ApplyDownAbsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_download_dns = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_download_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_download_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_download_port = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50 }, new String[] { "uint32_download_ip", "bytes_download_dns", "uint32_download_port", "bytes_file_sha", "bytes_download_key", "bytes_cookie" }, new Object[] { localInteger, localByteStringMicro1, localInteger, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, ApplyDownAbsRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f7.oidb_cmd0x8f7.ApplyDownAbsRsp
 * JD-Core Version:    0.7.0.1
 */