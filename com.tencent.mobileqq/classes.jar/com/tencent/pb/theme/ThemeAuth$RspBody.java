package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ThemeAuth$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_sub_cmd", "msg_subcmd0x1_rsp_auth", "msg_subcmd0x2_rsp_check", "msg_subcmd0x3_rsp_set" }, new Object[] { Integer.valueOf(0), null, null, null }, RspBody.class);
  public ThemeAuth.SubCmd0x1RspAuth msg_subcmd0x1_rsp_auth = new ThemeAuth.SubCmd0x1RspAuth();
  public ThemeAuth.SubCmd0x2RspCheck msg_subcmd0x2_rsp_check = new ThemeAuth.SubCmd0x2RspCheck();
  public ThemeAuth.SubCmd0x3RspSet msg_subcmd0x3_rsp_set = new ThemeAuth.SubCmd0x3RspSet();
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.theme.ThemeAuth.RspBody
 * JD-Core Version:    0.7.0.1
 */