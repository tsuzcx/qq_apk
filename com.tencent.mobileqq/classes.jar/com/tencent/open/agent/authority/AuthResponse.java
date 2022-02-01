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
  public PBInt64Field a;
  public PBRepeatMessageField<appType.PassData> a;
  public PBStringField a;
  public PBUInt32Field a;
  public auth.ProxyAuthResponse a;
  public PBStringField b;
  public PBUInt32Field b;
  public PBStringField c = PBField.initString("");
  public PBStringField d = PBField.initString("");
  public PBStringField e = PBField.initString("");
  public PBStringField f = PBField.initString("");
  public PBStringField g = PBField.initString("");
  public PBStringField h = PBField.initString("");
  public PBStringField i = PBField.initString("");
  public PBStringField j = PBField.initString("");
  public PBStringField k = PBField.initString("");
  public PBStringField l = PBField.initString("");
  public PBStringField m = PBField.initString("");
  public PBStringField n = PBField.initString("");
  
  public AuthResponse()
  {
    this.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field = PBField.initUInt32(0);
    this.jdField_a_of_type_ComTencentMobileqqPbPBStringField = PBField.initString("");
    this.jdField_b_of_type_ComTencentMobileqqPbPBStringField = PBField.initString("");
    this.jdField_a_of_type_ComTencentMobileqqPbPBInt64Field = PBField.initInt64(0L);
    this.jdField_b_of_type_ComTencentMobileqqPbPBUInt32Field = PBField.initUInt32(0);
    this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField = PBField.initRepeatMessage(appType.PassData.class);
    this.jdField_a_of_type_ComTencentQconnProtofileAuth$ProxyAuthResponse = new auth.ProxyAuthResponse();
  }
  
  public static AuthResponse a(SdkAuthorize.AuthorizeResponse paramAuthorizeResponse)
  {
    AuthResponse localAuthResponse = new AuthResponse();
    localAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field = paramAuthorizeResponse.ret;
    localAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBStringField = paramAuthorizeResponse.msg;
    localAuthResponse.jdField_b_of_type_ComTencentMobileqqPbPBStringField = paramAuthorizeResponse.access_token;
    localAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBInt64Field = paramAuthorizeResponse.expires_in;
    localAuthResponse.c = paramAuthorizeResponse.openid;
    localAuthResponse.d = paramAuthorizeResponse.pay_token;
    localAuthResponse.e = paramAuthorizeResponse.encrytoken;
    localAuthResponse.f = paramAuthorizeResponse.pf;
    localAuthResponse.g = paramAuthorizeResponse.pfkey;
    localAuthResponse.h = paramAuthorizeResponse.encrykey;
    localAuthResponse.i = paramAuthorizeResponse.md5key;
    localAuthResponse.jdField_b_of_type_ComTencentMobileqqPbPBUInt32Field = paramAuthorizeResponse.sendinstall;
    localAuthResponse.j = paramAuthorizeResponse.installwording;
    localAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField = paramAuthorizeResponse.passDataResp;
    localAuthResponse.k = paramAuthorizeResponse.signQQkey;
    localAuthResponse.l = paramAuthorizeResponse.md5QQkey;
    localAuthResponse.m = paramAuthorizeResponse.callbackURL;
    return localAuthResponse;
  }
  
  public static AuthResponse a(auth.AuthResponse paramAuthResponse)
  {
    AuthResponse localAuthResponse = new AuthResponse();
    localAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field = paramAuthResponse.ret;
    localAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBStringField = paramAuthResponse.msg;
    localAuthResponse.jdField_b_of_type_ComTencentMobileqqPbPBStringField = paramAuthResponse.access_token;
    localAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBInt64Field = paramAuthResponse.expires_in;
    localAuthResponse.c = paramAuthResponse.openid;
    localAuthResponse.d = paramAuthResponse.pay_token;
    localAuthResponse.e = paramAuthResponse.encrytoken;
    localAuthResponse.f = paramAuthResponse.pf;
    localAuthResponse.g = paramAuthResponse.pfkey;
    localAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField = paramAuthResponse.pass_data_resp;
    localAuthResponse.m = paramAuthResponse.callback_url;
    localAuthResponse.jdField_a_of_type_ComTencentQconnProtofileAuth$ProxyAuthResponse = paramAuthResponse.proxy_auth_resp;
    localAuthResponse.n = paramAuthResponse.code;
    return localAuthResponse;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.authority.AuthResponse
 * JD-Core Version:    0.7.0.1
 */