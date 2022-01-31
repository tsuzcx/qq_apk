package tencent.im.oidb.cmd0x6d9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6d9$CopyToRspBody
  extends MessageMicro<CopyToRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 322 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "str_save_file_path", "uint32_bus_id", "str_file_name" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), "" }, CopyToRspBody.class);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBStringField str_client_wording = PBField.initString("");
  public final PBStringField str_file_name = PBField.initString("");
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBStringField str_save_file_path = PBField.initString("");
  public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d9.oidb_0x6d9.CopyToRspBody
 * JD-Core Version:    0.7.0.1
 */