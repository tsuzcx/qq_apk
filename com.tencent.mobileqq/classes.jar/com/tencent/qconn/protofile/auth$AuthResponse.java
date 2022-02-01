package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class auth$AuthResponse
  extends MessageMicro<AuthResponse>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58, 66, 74, 82, 114, 162, 322, 402, 482 }, new String[] { "ret", "msg", "access_token", "code", "expires_in", "openid", "pay_token", "encrytoken", "pf", "pfkey", "pass_data_resp", "callback_url", "universal_link", "proxy_auth_resp", "state" }, new Object[] { Integer.valueOf(0), "", "", "", Long.valueOf(0L), "", "", "", "", "", null, "", "", null, "" }, AuthResponse.class);
  public final PBStringField access_token = PBField.initString("");
  public final PBStringField callback_url = PBField.initString("");
  public final PBStringField code = PBField.initString("");
  public final PBStringField encrytoken = PBField.initString("");
  public final PBInt64Field expires_in = PBField.initInt64(0L);
  public final PBStringField msg = PBField.initString("");
  public final PBStringField openid = PBField.initString("");
  public final PBRepeatMessageField<appType.PassData> pass_data_resp = PBField.initRepeatMessage(appType.PassData.class);
  public final PBStringField pay_token = PBField.initString("");
  public final PBStringField pf = PBField.initString("");
  public final PBStringField pfkey = PBField.initString("");
  public auth.ProxyAuthResponse proxy_auth_resp = new auth.ProxyAuthResponse();
  public final PBUInt32Field ret = PBField.initUInt32(0);
  public final PBStringField state = PBField.initString("");
  public final PBStringField universal_link = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qconn.protofile.auth.AuthResponse
 * JD-Core Version:    0.7.0.1
 */