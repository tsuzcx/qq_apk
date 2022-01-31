package com.tencent.mobileqq.intervideo.huiyin.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FalcoLoginProto$LoginCheckRsp
  extends MessageMicro<LoginCheckRsp>
{
  public static final int A2_KEY_FIELD_NUMBER = 6;
  public static final int EX_FIELD_NUMBER = 11;
  public static final int IS_FIRST_LOGIN_FIELD_NUMBER = 10;
  public static final int IS_NOT_REGISTERED_FIELD_NUMBER = 9;
  public static final int RESULT_FIELD_NUMBER = 1;
  public static final int SERVER_TIME_FIELD_NUMBER = 8;
  public static final int SIG_EXPIRE_FIELD_NUMBER = 7;
  public static final int TINYID_FIELD_NUMBER = 5;
  public static final int UIN_FIELD_NUMBER = 3;
  public static final int USER_NAME_FIELD_NUMBER = 2;
  public static final int USER_SIG_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField a2_key = PBField.initString("");
  public final PBBytesField ex = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBoolField is_first_login = PBField.initBool(false);
  public final PBBoolField is_not_registered = PBField.initBool(true);
  public FalcoLoginProto.RetInfo result = new FalcoLoginProto.RetInfo();
  public final PBUInt64Field server_time = PBField.initUInt64(0L);
  public final PBUInt32Field sig_expire = PBField.initUInt32(0);
  public final PBUInt64Field tinyid = PBField.initUInt64(0L);
  public final PBInt64Field uin = PBField.initInt64(0L);
  public final PBStringField user_name = PBField.initString("");
  public final PBStringField user_sig = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 50, 56, 64, 72, 80, 90 }, new String[] { "result", "user_name", "uin", "user_sig", "tinyid", "a2_key", "sig_expire", "server_time", "is_not_registered", "is_first_login", "ex" }, new Object[] { null, "", Long.valueOf(0L), "", Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), Boolean.valueOf(true), Boolean.valueOf(false), localByteStringMicro }, LoginCheckRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huiyin.proto.FalcoLoginProto.LoginCheckRsp
 * JD-Core Version:    0.7.0.1
 */