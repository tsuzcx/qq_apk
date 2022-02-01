package com.tencent.mobileqq.studymode.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class KidModePassword$VerifySignatureReq
  extends MessageMicro<VerifySignatureReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField account = PBField.initString("");
  public final PBEnumField acct_type = PBField.initEnum(0);
  public KidModePassword.LoginSig login_sig = new KidModePassword.LoginSig();
  public final PBUInt32Field scene_id = PBField.initUInt32(0);
  public final PBStringField signature = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "acct_type", "account", "scene_id", "signature", "login_sig" }, new Object[] { localInteger, "", localInteger, "", null }, VerifySignatureReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.proto.KidModePassword.VerifySignatureReq
 * JD-Core Version:    0.7.0.1
 */