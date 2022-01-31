package com.tencent.mobileqq.intervideo.huiyin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class HuiyinProto$LoginCheckRsp
  extends MessageMicro<LoginCheckRsp>
{
  public static final int A2_KEY_FIELD_NUMBER = 6;
  public static final int IS_NEW_USER_FIELD_NUMBER = 9;
  public static final int RESULT_FIELD_NUMBER = 1;
  public static final int SERVER_TIME_FIELD_NUMBER = 8;
  public static final int SIG_EXPIRE_FIELD_NUMBER = 7;
  public static final int UID_FIELD_NUMBER = 5;
  public static final int UIN_FIELD_NUMBER = 3;
  public static final int USER_NAME_FIELD_NUMBER = 2;
  public static final int USER_SIG_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 50, 56, 64, 72 }, new String[] { "result", "user_name", "uin", "user_sig", "uid", "a2_key", "sig_expire", "server_time", "is_new_user" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), "", Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), Boolean.valueOf(false) }, LoginCheckRsp.class);
  public final PBStringField a2_key = PBField.initString("");
  public final PBBoolField is_new_user = PBField.initBool(false);
  public final PBInt32Field result = PBField.initInt32(0);
  public final PBUInt64Field server_time = PBField.initUInt64(0L);
  public final PBUInt32Field sig_expire = PBField.initUInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public final PBInt64Field uin = PBField.initInt64(0L);
  public final PBStringField user_name = PBField.initString("");
  public final PBStringField user_sig = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huiyin.HuiyinProto.LoginCheckRsp
 * JD-Core Version:    0.7.0.1
 */