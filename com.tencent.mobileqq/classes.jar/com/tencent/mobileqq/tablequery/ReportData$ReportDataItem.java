package com.tencent.mobileqq.tablequery;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ReportData$ReportDataItem
  extends MessageMicro<ReportDataItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField description = PBField.initString("");
  public final PBStringField param = PBField.initString("");
  public final PBUInt64Field pv = PBField.initUInt64(0L);
  public final PBStringField pv_day_earlier = PBField.initString("");
  public final PBStringField pv_month_earlier = PBField.initString("");
  public final PBStringField reportId = PBField.initString("");
  public final PBStringField reqReportId = PBField.initString("");
  public final PBStringField time = PBField.initString("");
  public final PBUInt64Field uv = PBField.initUInt64(0L);
  public final PBStringField uv_day_earlier = PBField.initString("");
  public final PBStringField uv_month_earlier = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48, 58, 66, 74, 82, 90 }, new String[] { "reqReportId", "reportId", "pv", "pv_day_earlier", "pv_month_earlier", "uv", "uv_day_earlier", "uv_month_earlier", "time", "param", "description" }, new Object[] { "", "", localLong, "", "", localLong, "", "", "", "", "" }, ReportDataItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.ReportData.ReportDataItem
 * JD-Core Version:    0.7.0.1
 */