package com.tencent.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ReportTrace$ExtParam
  extends MessageMicro<ExtParam>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "param_id", "value" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, ExtParam.class);
  public final PBUInt32Field param_id = PBField.initUInt32(0);
  public final PBUInt64Field value = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.ReportTrace.ExtParam
 * JD-Core Version:    0.7.0.1
 */