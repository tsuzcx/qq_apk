package com.tencent.mobileqq.now.loginmerge;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class LoginMergedProto$TicketInfo
  extends MessageMicro<TicketInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "auth_key", "access_token", "st", "stkey", "skey", "stweb" }, new Object[] { "", "", "", "", "", "" }, TicketInfo.class);
  public final PBStringField access_token = PBField.initString("");
  public final PBStringField auth_key = PBField.initString("");
  public final PBStringField skey = PBField.initString("");
  public final PBStringField st = PBField.initString("");
  public final PBStringField stkey = PBField.initString("");
  public final PBStringField stweb = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.loginmerge.LoginMergedProto.TicketInfo
 * JD-Core Version:    0.7.0.1
 */