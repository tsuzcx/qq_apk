package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SummaryCardBusiEntry$ui_info
  extends MessageMicro<ui_info>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64 }, new String[] { "strTitle", "strCoverUrl", "strJmpUrl", "strSubInfo", "strDesc", "strTitleIconUrl", "rptGroupTagList", "uint64_group_code" }, new Object[] { "", "", "", "", "", "", null, Long.valueOf(0L) }, ui_info.class);
  public final PBRepeatMessageField<SummaryCardBusiEntry.Label> rptGroupTagList = PBField.initRepeatMessage(SummaryCardBusiEntry.Label.class);
  public final PBStringField strCoverUrl = PBField.initString("");
  public final PBStringField strDesc = PBField.initString("");
  public final PBStringField strJmpUrl = PBField.initString("");
  public final PBStringField strSubInfo = PBField.initString("");
  public final PBStringField strTitle = PBField.initString("");
  public final PBStringField strTitleIconUrl = PBField.initString("");
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.profilecard.SummaryCardBusiEntry.ui_info
 * JD-Core Version:    0.7.0.1
 */