package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MsgType0x210_SubMsgType0x13c$Fields
  extends MessageMicro<Fields>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 50, 56, 66, 74, 82, 90, 98, 104, 112, 130, 138, 146, 154, 162 }, new String[] { "str_landing_page", "uint64_app_id", "str_app_name", "str_pkg_url", "str_pkg_name", "str_pkg_md5", "str_via", "uint32_dest_type", "uint32_product_type", "str_product_id", "str_landing_page_report_url", "str_customized_invoke_url", "str_effect_url", "str_traceid" }, new Object[] { "", Long.valueOf(0L), "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "" }, Fields.class);
  public final PBStringField str_app_name = PBField.initString("");
  public final PBStringField str_customized_invoke_url = PBField.initString("");
  public final PBStringField str_effect_url = PBField.initString("");
  public final PBStringField str_landing_page = PBField.initString("");
  public final PBStringField str_landing_page_report_url = PBField.initString("");
  public final PBStringField str_pkg_md5 = PBField.initString("");
  public final PBStringField str_pkg_name = PBField.initString("");
  public final PBStringField str_pkg_url = PBField.initString("");
  public final PBStringField str_product_id = PBField.initString("");
  public final PBStringField str_traceid = PBField.initString("");
  public final PBStringField str_via = PBField.initString("");
  public final PBUInt32Field uint32_dest_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_product_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_app_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.gdt.MsgType0x210_SubMsgType0x13c.Fields
 * JD-Core Version:    0.7.0.1
 */