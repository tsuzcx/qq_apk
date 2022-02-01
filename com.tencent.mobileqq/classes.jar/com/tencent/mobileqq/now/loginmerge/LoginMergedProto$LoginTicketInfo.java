package com.tencent.mobileqq.now.loginmerge;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LoginMergedProto$LoginTicketInfo
  extends MessageMicro<LoginTicketInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "client_version", "login_type", "client_type", "account_id", "ticket_info", "auth_appid" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", null, "" }, LoginTicketInfo.class);
  public final PBStringField account_id = PBField.initString("");
  public final PBStringField auth_appid = PBField.initString("");
  public final PBUInt32Field client_type = PBField.initUInt32(0);
  public final PBUInt32Field client_version = PBField.initUInt32(0);
  public final PBUInt32Field login_type = PBField.initUInt32(0);
  public LoginMergedProto.TicketInfo ticket_info = new LoginMergedProto.TicketInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.loginmerge.LoginMergedProto.LoginTicketInfo
 * JD-Core Version:    0.7.0.1
 */