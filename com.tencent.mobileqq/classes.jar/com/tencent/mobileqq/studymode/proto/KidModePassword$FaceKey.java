package com.tencent.mobileqq.studymode.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class KidModePassword$FaceKey
  extends MessageMicro<FaceKey>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "nonce", "id_key" }, new Object[] { "", "" }, FaceKey.class);
  public final PBStringField id_key = PBField.initString("");
  public final PBStringField nonce = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.proto.KidModePassword.FaceKey
 * JD-Core Version:    0.7.0.1
 */