package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_mp$ReportRecentListPAInfoRequest
  extends MessageMicro<ReportRecentListPAInfoRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "versionInfo", "max_rows_of_screen", "pa_info_in_list" }, new Object[] { "", Integer.valueOf(0), null }, ReportRecentListPAInfoRequest.class);
  public final PBUInt32Field max_rows_of_screen = PBField.initUInt32(0);
  public final PBRepeatMessageField<mobileqq_mp.PAInfoElem> pa_info_in_list = PBField.initRepeatMessage(mobileqq_mp.PAInfoElem.class);
  public final PBStringField versionInfo = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.ReportRecentListPAInfoRequest
 * JD-Core Version:    0.7.0.1
 */