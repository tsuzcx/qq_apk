package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class mobileqq_qidian$CompanyShowCaseInfo
  extends MessageMicro<CompanyShowCaseInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "string_show_case_title", "string_show_case_link", "string_show_case_image" }, new Object[] { "", "", "" }, CompanyShowCaseInfo.class);
  public final PBStringField string_show_case_image = PBField.initString("");
  public final PBStringField string_show_case_link = PBField.initString("");
  public final PBStringField string_show_case_title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.CompanyShowCaseInfo
 * JD-Core Version:    0.7.0.1
 */