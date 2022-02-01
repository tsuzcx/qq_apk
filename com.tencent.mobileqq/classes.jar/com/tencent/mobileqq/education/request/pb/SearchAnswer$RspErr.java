package com.tencent.mobileqq.education.request.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SearchAnswer$RspErr
  extends MessageMicro<RspErr>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "errCode", "errMsg" }, new Object[] { Long.valueOf(0L), "" }, RspErr.class);
  public final PBUInt64Field errCode = PBField.initUInt64(0L);
  public final PBStringField errMsg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.request.pb.SearchAnswer.RspErr
 * JD-Core Version:    0.7.0.1
 */