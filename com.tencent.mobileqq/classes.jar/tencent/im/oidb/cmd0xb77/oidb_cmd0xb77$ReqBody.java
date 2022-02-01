package tencent.im.oidb.cmd0xb77;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb77$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 80, 88, 98, 106, 114, 122, 130, 138, 146 }, new String[] { "appid", "app_type", "msg_style", "sender_uin", "client_info", "text_msg", "ext_info", "send_type", "recv_uin", "rich_msg_body", "ark_msg_body", "recv_openid", "arkv1_msg_body", "ark_json_body", "xml_msg_body", "mini_app_msg_body" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, "", null, Integer.valueOf(0), Long.valueOf(0L), null, null, "", null, null, null, null }, ReqBody.class);
  public final PBUInt32Field app_type = PBField.initUInt32(0);
  public final PBUInt64Field appid = PBField.initUInt64(0L);
  public oidb_cmd0xb77.ArkJsonBody ark_json_body = new oidb_cmd0xb77.ArkJsonBody();
  public oidb_cmd0xb77.ArkMsgBody ark_msg_body = new oidb_cmd0xb77.ArkMsgBody();
  public oidb_cmd0xb77.ArkV1MsgBody arkv1_msg_body = new oidb_cmd0xb77.ArkV1MsgBody();
  public oidb_cmd0xb77.ClientInfo client_info = new oidb_cmd0xb77.ClientInfo();
  public oidb_cmd0xb77.ExtInfo ext_info = new oidb_cmd0xb77.ExtInfo();
  public oidb_cmd0xb77.MiniAppMsgBody mini_app_msg_body = new oidb_cmd0xb77.MiniAppMsgBody();
  public final PBUInt32Field msg_style = PBField.initUInt32(0);
  public final PBStringField recv_openid = PBField.initString("");
  public final PBUInt64Field recv_uin = PBField.initUInt64(0L);
  public oidb_cmd0xb77.RichMsgBody rich_msg_body = new oidb_cmd0xb77.RichMsgBody();
  public final PBUInt32Field send_type = PBField.initUInt32(0);
  public final PBUInt64Field sender_uin = PBField.initUInt64(0L);
  public final PBStringField text_msg = PBField.initString("");
  public oidb_cmd0xb77.XmlMsgBody xml_msg_body = new oidb_cmd0xb77.XmlMsgBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ReqBody
 * JD-Core Version:    0.7.0.1
 */