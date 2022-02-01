package com.tencent.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ReportTrace$reportStat
  extends MessageMicro<reportStat>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field cost = PBField.initInt32(0);
  public final PBInt32Field cpu = PBField.initInt32(0);
  public final PBUInt32Field display = PBField.initUInt32(0);
  public final PBInt32Field java_heap = PBField.initInt32(0);
  public final PBInt32Field memory = PBField.initInt32(0);
  public final PBInt32Field native_heap = PBField.initInt32(0);
  public final PBUInt32Field net_type = PBField.initUInt32(0);
  public final PBInt32Field ret = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64 }, new String[] { "ret", "cost", "memory", "cpu", "net_type", "display", "java_heap", "native_heap" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger }, reportStat.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.ReportTrace.reportStat
 * JD-Core Version:    0.7.0.1
 */