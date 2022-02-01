package com.tencent.mobileqq.studymode.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class KidModePassword$SetPasswdReq
  extends MessageMicro<SetPasswdReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField account = PBField.initString("");
  public final PBEnumField acct_type = PBField.initEnum(0);
  public KidModePassword.ClientInfo client_info = new KidModePassword.ClientInfo();
  public final PBEnumField hash_method = PBField.initEnum(0);
  public KidModePassword.LoginSig login_sig = new KidModePassword.LoginSig();
  public final PBInt64Field nonce = PBField.initInt64(0L);
  public final PBStringField passwd_hash = PBField.initString("");
  public final PBUInt32Field scene_id = PBField.initUInt32(0);
  public KidModePassword.SHA256Rounds2Params sha256_rounds2_params = new KidModePassword.SHA256Rounds2Params();
  public final PBInt64Field timestamp = PBField.initInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 56, 64, 74, 80 }, new String[] { "acct_type", "account", "scene_id", "passwd_hash", "login_sig", "client_info", "timestamp", "nonce", "sha256_rounds2_params", "hash_method" }, new Object[] { localInteger, "", localInteger, "", null, null, localLong, localLong, null, localInteger }, SetPasswdReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.proto.KidModePassword.SetPasswdReq
 * JD-Core Version:    0.7.0.1
 */