package com.tencent.mobileqq.intervideo.huiyin.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FalcoLoginProto$UpdateWxTokenRsp
  extends MessageMicro<UpdateWxTokenRsp>
{
  public static final int ACCESS_TOKEN_FIELD_NUMBER = 1;
  public static final int ERRCODE_FIELD_NUMBER = 6;
  public static final int ERRMSG_FIELD_NUMBER = 7;
  public static final int EXPIRES_IN_FIELD_NUMBER = 2;
  public static final int OPENID_FIELD_NUMBER = 4;
  public static final int REFRESH_TOKEN_FIELD_NUMBER = 3;
  public static final int SCOPE_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 48, 58 }, new String[] { "access_token", "expires_in", "refresh_token", "openid", "scope", "errcode", "errmsg" }, new Object[] { "", Integer.valueOf(0), "", "", "", Integer.valueOf(0), "" }, UpdateWxTokenRsp.class);
  public final PBStringField access_token = PBField.initString("");
  public final PBUInt32Field errcode = PBField.initUInt32(0);
  public final PBStringField errmsg = PBField.initString("");
  public final PBUInt32Field expires_in = PBField.initUInt32(0);
  public final PBStringField openid = PBField.initString("");
  public final PBStringField refresh_token = PBField.initString("");
  public final PBStringField scope = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huiyin.proto.FalcoLoginProto.UpdateWxTokenRsp
 * JD-Core Version:    0.7.0.1
 */