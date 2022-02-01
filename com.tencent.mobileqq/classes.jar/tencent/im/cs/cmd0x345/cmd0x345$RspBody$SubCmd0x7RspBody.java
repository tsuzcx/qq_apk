package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x345$RspBody$SubCmd0x7RspBody
  extends MessageMicro<SubCmd0x7RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_thri_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_dns = PBField.initString("");
  public final PBStringField str_https_domain = PBField.initString("");
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBStringField str_server_ip = PBField.initString("");
  public final PBStringField str_url = PBField.initString("");
  public final PBUInt32Field uint32_https_port = PBField.initUInt32(443);
  public final PBFixed32Field uint32_server_port = PBField.initFixed32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 21, 26, 34, 42, 50, 58, 66, 74, 80, 90 }, new String[] { "str_server_ip", "uint32_server_port", "str_dns", "str_url", "bytes_sha", "bytes_thri_sha", "bytes_md5", "bytes_cookie", "str_ret_msg", "uint32_https_port", "str_https_domain" }, new Object[] { "", Integer.valueOf(0), "", "", localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, "", Integer.valueOf(443), "" }, SubCmd0x7RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x7RspBody
 * JD-Core Version:    0.7.0.1
 */