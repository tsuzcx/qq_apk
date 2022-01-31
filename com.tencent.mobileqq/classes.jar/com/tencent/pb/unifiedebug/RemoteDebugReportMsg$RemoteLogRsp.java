package com.tencent.pb.unifiedebug;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class RemoteDebugReportMsg$RemoteLogRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "i32_ret" }, new Object[] { Integer.valueOf(0) }, RemoteLogRsp.class);
  public final PBInt32Field i32_ret = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.unifiedebug.RemoteDebugReportMsg.RemoteLogRsp
 * JD-Core Version:    0.7.0.1
 */