package com.tencent.pb.unifiedebug;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class RemoteDebugReportMsg$RemoteLogReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_seq", "str_data" }, new Object[] { "", "" }, RemoteLogReq.class);
  public final PBStringField str_data = PBField.initString("");
  public final PBStringField str_seq = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.unifiedebug.RemoteDebugReportMsg.RemoteLogReq
 * JD-Core Version:    0.7.0.1
 */