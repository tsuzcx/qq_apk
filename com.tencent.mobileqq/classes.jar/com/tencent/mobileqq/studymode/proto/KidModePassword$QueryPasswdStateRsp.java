package com.tencent.mobileqq.studymode.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class KidModePassword$QueryPasswdStateRsp
  extends MessageMicro<QueryPasswdStateRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field err_code = PBField.initUInt32(0);
  public final PBStringField err_msg = PBField.initString("");
  public final PBEnumField hash_method = PBField.initEnum(0);
  public KidModePassword.SHA256Rounds2Params sha256_rounds2_params = new KidModePassword.SHA256Rounds2Params();
  public final PBEnumField state = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "err_code", "err_msg", "state", "hash_method", "sha256_rounds2_params" }, new Object[] { localInteger, "", localInteger, localInteger, null }, QueryPasswdStateRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.proto.KidModePassword.QueryPasswdStateRsp
 * JD-Core Version:    0.7.0.1
 */