package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x346$DownloadInfo
  extends MessageMicro<DownloadInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_download_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<String> rpt_str_downloadip_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField str_cookie = PBField.initString("");
  public final PBStringField str_download_dns = PBField.initString("");
  public final PBStringField str_download_domain = PBField.initString("");
  public final PBStringField str_download_ip = PBField.initString("");
  public final PBStringField str_download_url = PBField.initString("");
  public final PBStringField str_https_download_domain = PBField.initString("");
  public final PBUInt32Field uint32_https_port = PBField.initUInt32(443);
  public final PBUInt32Field uint32_port = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 162, 242, 320, 402, 482, 562, 640, 722, 882 }, new String[] { "bytes_download_key", "str_download_ip", "str_download_domain", "uint32_port", "str_download_url", "rpt_str_downloadip_list", "str_cookie", "uint32_https_port", "str_https_download_domain", "str_download_dns" }, new Object[] { localByteStringMicro, "", "", Integer.valueOf(0), "", "", "", Integer.valueOf(443), "", "" }, DownloadInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */