package com.tencent.protofile.sdkauthorize;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SdkAuthorize$GetAuthApiListResponse
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 64, 72, 82 }, new String[] { "ret", "msg", "oauth_host_nick", "oauth_host_uin", "oauth_app_name", "oauth_portrait_url", "authorized_form_list", "key_type", "redirect_time", "auth_response" }, new Object[] { Integer.valueOf(0), "", "", Long.valueOf(0L), "", "", null, Integer.valueOf(0), Integer.valueOf(0), null }, GetAuthApiListResponse.class);
  public SdkAuthorize.AuthorizeResponse auth_response = new SdkAuthorize.AuthorizeResponse();
  public final PBRepeatMessageField authorized_form_list = PBField.initRepeatMessage(SdkAuthorize.AuthItem.class);
  public final PBUInt32Field key_type = PBField.initUInt32(0);
  public final PBStringField msg = PBField.initString("");
  public final PBStringField oauth_app_name = PBField.initString("");
  public final PBStringField oauth_host_nick = PBField.initString("");
  public final PBInt64Field oauth_host_uin = PBField.initInt64(0L);
  public final PBStringField oauth_portrait_url = PBField.initString("");
  public final PBUInt32Field redirect_time = PBField.initUInt32(0);
  public final PBUInt32Field ret = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse
 * JD-Core Version:    0.7.0.1
 */