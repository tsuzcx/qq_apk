package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x345$RspBody$SubCmd0x1RspBody
  extends MessageMicro<SubCmd0x1RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 58, 64, 72, 82, 90 }, new String[] { "str_file_id", "str_check_sum", "str_host", "uint32_port", "str_file_key", "str_file_name", "str_warn", "uint32_costom_id", "uint32_https_port", "str_https_domain", "str_dns" }, new Object[] { "", "", "", Integer.valueOf(80), "", "", "", Integer.valueOf(0), Integer.valueOf(443), "", "" }, SubCmd0x1RspBody.class);
  public final PBStringField str_check_sum = PBField.initString("");
  public final PBStringField str_dns = PBField.initString("");
  public final PBStringField str_file_id = PBField.initString("");
  public final PBStringField str_file_key = PBField.initString("");
  public final PBStringField str_file_name = PBField.initString("");
  public final PBStringField str_host = PBField.initString("");
  public final PBStringField str_https_domain = PBField.initString("");
  public final PBStringField str_warn = PBField.initString("");
  public final PBUInt32Field uint32_costom_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_https_port = PBField.initUInt32(443);
  public final PBUInt32Field uint32_port = PBField.initUInt32(80);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x1RspBody
 * JD-Core Version:    0.7.0.1
 */