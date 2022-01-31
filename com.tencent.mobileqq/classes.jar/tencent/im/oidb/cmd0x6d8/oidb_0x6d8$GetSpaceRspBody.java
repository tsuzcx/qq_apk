package tencent.im.oidb.cmd0x6d8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6d8$GetSpaceRspBody
  extends MessageMicro<GetSpaceRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "uint64_total_space", "uint64_used_space", "bool_all_upload" }, new Object[] { Integer.valueOf(0), "", "", Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false) }, GetSpaceRspBody.class);
  public final PBBoolField bool_all_upload = PBField.initBool(false);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBStringField str_client_wording = PBField.initString("");
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_used_space = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetSpaceRspBody
 * JD-Core Version:    0.7.0.1
 */