package com.tencent.mobileqq.tablequery;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ReportData$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<ReportData.ReportDataItem> reportArray = PBField.initRepeatMessage(ReportData.ReportDataItem.class);
  public final PBInt64Field ret = PBField.initInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ret", "msg", "reportArray" }, new Object[] { Long.valueOf(0L), localByteStringMicro, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.ReportData.RspBody
 * JD-Core Version:    0.7.0.1
 */