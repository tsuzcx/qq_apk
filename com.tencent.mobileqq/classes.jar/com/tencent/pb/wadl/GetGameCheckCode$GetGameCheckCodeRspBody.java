package com.tencent.pb.wadl;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetGameCheckCode$GetGameCheckCodeRspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "check_code", "ret" }, new Object[] { "", Integer.valueOf(0) }, GetGameCheckCodeRspBody.class);
  public final PBStringField check_code = PBField.initString("");
  public final PBInt32Field ret = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.wadl.GetGameCheckCode.GetGameCheckCodeRspBody
 * JD-Core Version:    0.7.0.1
 */