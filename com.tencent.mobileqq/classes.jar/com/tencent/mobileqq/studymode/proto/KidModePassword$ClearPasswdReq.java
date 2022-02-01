package com.tencent.mobileqq.studymode.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class KidModePassword$ClearPasswdReq
  extends MessageMicro<ClearPasswdReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField account = PBField.initString("");
  public final PBEnumField acct_type = PBField.initEnum(0);
  public final PBEnumField auth_method = PBField.initEnum(0);
  public KidModePassword.FaceKey face_key = new KidModePassword.FaceKey();
  public final PBInt64Field nonce = PBField.initInt64(0L);
  public KidModePassword.PrivateSig private_sig = new KidModePassword.PrivateSig();
  public final PBUInt32Field scene_id = PBField.initUInt32(0);
  public final PBInt64Field timestamp = PBField.initInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48, 56, 66 }, new String[] { "acct_type", "account", "scene_id", "auth_method", "face_key", "timestamp", "nonce", "private_sig" }, new Object[] { localInteger, "", localInteger, localInteger, null, localLong, localLong, null }, ClearPasswdReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.proto.KidModePassword.ClearPasswdReq
 * JD-Core Version:    0.7.0.1
 */