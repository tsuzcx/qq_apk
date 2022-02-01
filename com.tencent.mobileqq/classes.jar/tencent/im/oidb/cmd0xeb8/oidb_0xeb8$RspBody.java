package tencent.im.oidb.cmd0xeb8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xeb8$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 72 }, new String[] { "uint32_check_result", "rpt_phone_info", "str_mibao_set_url", "str_mibao_change_url", "str_mibao_verify_url", "str_verify_premibao_url", "str_hori_bar_tips", "str_red_dot_tips", "bool_is_IOT" }, new Object[] { Integer.valueOf(0), null, "", "", "", "", "", "", Boolean.valueOf(false) }, RspBody.class);
  public final PBBoolField bool_is_IOT = PBField.initBool(false);
  public final PBRepeatMessageField<oidb_0xeb8.PhoneInfo> rpt_phone_info = PBField.initRepeatMessage(oidb_0xeb8.PhoneInfo.class);
  public final PBStringField str_hori_bar_tips = PBField.initString("");
  public final PBStringField str_mibao_change_url = PBField.initString("");
  public final PBStringField str_mibao_set_url = PBField.initString("");
  public final PBStringField str_mibao_verify_url = PBField.initString("");
  public final PBStringField str_red_dot_tips = PBField.initString("");
  public final PBStringField str_verify_premibao_url = PBField.initString("");
  public final PBUInt32Field uint32_check_result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeb8.oidb_0xeb8.RspBody
 * JD-Core Version:    0.7.0.1
 */