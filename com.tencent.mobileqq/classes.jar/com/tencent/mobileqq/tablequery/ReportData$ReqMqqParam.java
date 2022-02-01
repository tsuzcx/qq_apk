package com.tencent.mobileqq.tablequery;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ReportData$ReqMqqParam
  extends MessageMicro<ReqMqqParam>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "department", "opername", "action" }, new Object[] { "", "", "" }, ReqMqqParam.class);
  public final PBStringField action = PBField.initString("");
  public final PBStringField department = PBField.initString("");
  public final PBStringField opername = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.ReportData.ReqMqqParam
 * JD-Core Version:    0.7.0.1
 */