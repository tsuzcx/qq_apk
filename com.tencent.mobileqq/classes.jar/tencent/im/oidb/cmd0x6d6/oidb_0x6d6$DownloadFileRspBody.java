package tencent.im.oidb.cmd0x6d6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6d6$DownloadFileRspBody
  extends MessageMicro<DownloadFileRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie_val = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_download_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sha3 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBStringField str_client_wording = PBField.initString("");
  public final PBBytesField str_download_dns = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_download_dns_https = PBField.initString("");
  public final PBStringField str_download_ip = PBField.initString("");
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBStringField str_save_file_name = PBField.initString("");
  public final PBUInt32Field uint32_preview_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_preview_port_https = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 106, 112 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "str_download_ip", "str_download_dns", "bytes_download_url", "bytes_sha", "bytes_sha3", "bytes_md5", "bytes_cookie_val", "str_save_file_name", "uint32_preview_port", "str_download_dns_https", "uint32_preview_port_https" }, new Object[] { localInteger, "", "", "", localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, "", localInteger, "", localInteger }, DownloadFileRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody
 * JD-Core Version:    0.7.0.1
 */