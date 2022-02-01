package com.tencent.open.agent.authority;

import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qconn.protofile.appType.PassData;
import com.tencent.qconn.protofile.auth.AuthResponse;
import com.tencent.qconn.protofile.auth.ProxyAuthResponse;

public class AuthResponse
{
  public PBUInt32Field a = PBField.initUInt32(0);
  public PBStringField b = PBField.initString("");
  public PBStringField c = PBField.initString("");
  public PBInt64Field d = PBField.initInt64(0L);
  public PBStringField e = PBField.initString("");
  public PBStringField f = PBField.initString("");
  public PBStringField g = PBField.initString("");
  public PBStringField h = PBField.initString("");
  public PBStringField i = PBField.initString("");
  public PBStringField j = PBField.initString("");
  public PBStringField k = PBField.initString("");
  public PBUInt32Field l = PBField.initUInt32(0);
  public PBStringField m = PBField.initString("");
  public PBRepeatMessageField<appType.PassData> n = PBField.initRepeatMessage(appType.PassData.class);
  public PBStringField o = PBField.initString("");
  public PBStringField p = PBField.initString("");
  public PBStringField q = PBField.initString("");
  public auth.ProxyAuthResponse r = new auth.ProxyAuthResponse();
  public PBStringField s = PBField.initString("");
  
  public static AuthResponse a(SdkAuthorize.AuthorizeResponse paramAuthorizeResponse)
  {
    AuthResponse localAuthResponse = new AuthResponse();
    localAuthResponse.a = paramAuthorizeResponse.ret;
    localAuthResponse.b = paramAuthorizeResponse.msg;
    localAuthResponse.c = paramAuthorizeResponse.access_token;
    localAuthResponse.d = paramAuthorizeResponse.expires_in;
    localAuthResponse.e = paramAuthorizeResponse.openid;
    localAuthResponse.f = paramAuthorizeResponse.pay_token;
    localAuthResponse.g = paramAuthorizeResponse.encrytoken;
    localAuthResponse.h = paramAuthorizeResponse.pf;
    localAuthResponse.i = paramAuthorizeResponse.pfkey;
    localAuthResponse.j = paramAuthorizeResponse.encrykey;
    localAuthResponse.k = paramAuthorizeResponse.md5key;
    localAuthResponse.l = paramAuthorizeResponse.sendinstall;
    localAuthResponse.m = paramAuthorizeResponse.installwording;
    localAuthResponse.n = paramAuthorizeResponse.passDataResp;
    localAuthResponse.o = paramAuthorizeResponse.signQQkey;
    localAuthResponse.p = paramAuthorizeResponse.md5QQkey;
    localAuthResponse.q = paramAuthorizeResponse.callbackURL;
    return localAuthResponse;
  }
  
  public static AuthResponse a(auth.AuthResponse paramAuthResponse)
  {
    AuthResponse localAuthResponse = new AuthResponse();
    localAuthResponse.a = paramAuthResponse.ret;
    localAuthResponse.b = paramAuthResponse.msg;
    localAuthResponse.c = paramAuthResponse.access_token;
    localAuthResponse.d = paramAuthResponse.expires_in;
    localAuthResponse.e = paramAuthResponse.openid;
    localAuthResponse.f = paramAuthResponse.pay_token;
    localAuthResponse.g = paramAuthResponse.encrytoken;
    localAuthResponse.h = paramAuthResponse.pf;
    localAuthResponse.i = paramAuthResponse.pfkey;
    localAuthResponse.n = paramAuthResponse.pass_data_resp;
    localAuthResponse.q = paramAuthResponse.callback_url;
    localAuthResponse.r = paramAuthResponse.proxy_auth_resp;
    localAuthResponse.s = paramAuthResponse.code;
    return localAuthResponse;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.authority.AuthResponse
 * JD-Core Version:    0.7.0.1
 */