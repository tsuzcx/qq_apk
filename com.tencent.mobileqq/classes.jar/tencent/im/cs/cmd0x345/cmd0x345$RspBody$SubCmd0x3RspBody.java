package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x345$RspBody$SubCmd0x3RspBody
  extends MessageMicro<SubCmd0x3RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBStringField str_check_sum = PBField.initString("");
  public final PBStringField str_cookie = PBField.initString("");
  public final PBStringField str_dns = PBField.initString("");
  public final PBStringField str_host = PBField.initString("");
  public final PBStringField str_https_domain = PBField.initString("");
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBStringField str_suggest_file_name = PBField.initString("");
  public final PBUInt32Field uint32_costom_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_https_port = PBField.initUInt32(443);
  public final PBUInt32Field uint32_port = PBField.initUInt32(80);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 50, 56, 66, 74, 80, 90, 98 }, new String[] { "str_host", "uint32_port", "str_check_sum", "str_cookie", "uint32_costom_id", "str_ret_msg", "int32_ret_code", "str_suggest_file_name", "bytes_sha", "uint32_https_port", "str_https_domain", "str_dns" }, new Object[] { "", Integer.valueOf(80), "", "", Integer.valueOf(0), "", Integer.valueOf(0), "", localByteStringMicro, Integer.valueOf(443), "", "" }, SubCmd0x3RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x3RspBody
 * JD-Core Version:    0.7.0.1
 */