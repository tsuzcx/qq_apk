package tencent.im.oidb.cmd0xfc2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xfc2$DownloadInfo
  extends MessageMicro<DownloadInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_download_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_0xfc2.Addr> msg_inner_addr = PBField.initRepeatMessage(oidb_0xfc2.Addr.class);
  public final PBRepeatMessageField<oidb_0xfc2.Addr> msg_out_addr = PBField.initRepeatMessage(oidb_0xfc2.Addr.class);
  public final PBRepeatMessageField<oidb_0xfc2.Addr> msg_out_addr_ipv6 = PBField.initRepeatMessage(oidb_0xfc2.Addr.class);
  public final PBStringField str_cookie = PBField.initString("");
  public final PBStringField str_download_domain = PBField.initString("");
  public final PBStringField str_download_url = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "bytes_download_key", "msg_out_addr", "msg_inner_addr", "msg_out_addr_ipv6", "str_download_domain", "str_download_url", "str_cookie" }, new Object[] { localByteStringMicro, null, null, null, "", "", "" }, DownloadInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xfc2.oidb_0xfc2.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */