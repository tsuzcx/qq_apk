package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GatewayVerify$RspPhoneSmsExtendLogin
  extends MessageMicro<RspPhoneSmsExtendLogin>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 88, 98, 106 }, new String[] { "rpt_bind_uin_info", "int32_phone_bind_result", "str_phone_bind_msg_title", "str_phone_bind_msg_content" }, new Object[] { null, Integer.valueOf(0), "", "" }, RspPhoneSmsExtendLogin.class);
  public final PBInt32Field int32_phone_bind_result = PBField.initInt32(0);
  public final PBRepeatMessageField<GatewayVerify.UinInfo> rpt_bind_uin_info = PBField.initRepeatMessage(GatewayVerify.UinInfo.class);
  public final PBStringField str_phone_bind_msg_content = PBField.initString("");
  public final PBStringField str_phone_bind_msg_title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.RspPhoneSmsExtendLogin
 * JD-Core Version:    0.7.0.1
 */