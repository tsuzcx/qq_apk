package com.tencent.mobileqq.studymode.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class KidModePassword$SetPasswdRsp
  extends MessageMicro<SetPasswdRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "err_code", "err_msg", "signature" }, new Object[] { Integer.valueOf(0), "", "" }, SetPasswdRsp.class);
  public final PBUInt32Field err_code = PBField.initUInt32(0);
  public final PBStringField err_msg = PBField.initString("");
  public final PBStringField signature = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.proto.KidModePassword.SetPasswdRsp
 * JD-Core Version:    0.7.0.1
 */