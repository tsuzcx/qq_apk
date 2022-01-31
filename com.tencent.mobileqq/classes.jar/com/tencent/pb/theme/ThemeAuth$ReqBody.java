package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ThemeAuth$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50, 58 }, new String[] { "uint32_sub_cmd", "int32_plat_id", "str_qq_version", "uint32_qq_version", "msg_subcmd0x1_req_auth", "msg_subcmd0x2_req_check", "msg_subcmd0x3_req_set" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), null, null, null }, ReqBody.class);
  public final PBInt32Field int32_plat_id = PBField.initInt32(0);
  public ThemeAuth.SubCmd0x1ReqAuth msg_subcmd0x1_req_auth = new ThemeAuth.SubCmd0x1ReqAuth();
  public ThemeAuth.SubCmd0x2ReqCheck msg_subcmd0x2_req_check = new ThemeAuth.SubCmd0x2ReqCheck();
  public ThemeAuth.SubCmd0x3ReqSet msg_subcmd0x3_req_set = new ThemeAuth.SubCmd0x3ReqSet();
  public final PBStringField str_qq_version = PBField.initString("");
  public final PBUInt32Field uint32_qq_version = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.theme.ThemeAuth.ReqBody
 * JD-Core Version:    0.7.0.1
 */