package com.tencent.mobileqq.studymode.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class KidModePassword$QueryPasswdStateReq
  extends MessageMicro<QueryPasswdStateReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField account = PBField.initString("");
  public final PBEnumField acct_type = PBField.initEnum(0);
  public final PBUInt32Field scene_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "acct_type", "account", "scene_id" }, new Object[] { localInteger, "", localInteger }, QueryPasswdStateReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.proto.KidModePassword.QueryPasswdStateReq
 * JD-Core Version:    0.7.0.1
 */