package com.tencent.mobileqq.now.loginmerge;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class LoginMergedProto$LoginRsp
  extends MessageMicro<LoginRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "result", "errMsg", "account_base_info", "tickets" }, new Object[] { Integer.valueOf(0), "", null, null }, LoginRsp.class);
  public LoginMergedProto.AccountBaseInfo account_base_info = new LoginMergedProto.AccountBaseInfo();
  public final PBStringField errMsg = PBField.initString("");
  public final PBInt32Field result = PBField.initInt32(0);
  public LoginMergedProto.TicketInfo tickets = new LoginMergedProto.TicketInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.loginmerge.LoginMergedProto.LoginRsp
 * JD-Core Version:    0.7.0.1
 */