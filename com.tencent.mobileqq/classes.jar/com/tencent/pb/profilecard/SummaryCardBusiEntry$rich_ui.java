package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SummaryCardBusiEntry$rich_ui
  extends MessageMicro<rich_ui>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "strName", "strServiceUrl", "rptUiList" }, new Object[] { "", "", null }, rich_ui.class);
  public final PBRepeatMessageField<SummaryCardBusiEntry.ui_info> rptUiList = PBField.initRepeatMessage(SummaryCardBusiEntry.ui_info.class);
  public final PBStringField strName = PBField.initString("");
  public final PBStringField strServiceUrl = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.profilecard.SummaryCardBusiEntry.rich_ui
 * JD-Core Version:    0.7.0.1
 */