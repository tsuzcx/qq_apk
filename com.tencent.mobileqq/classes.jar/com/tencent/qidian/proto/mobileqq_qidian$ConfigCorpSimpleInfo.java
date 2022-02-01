package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class mobileqq_qidian$ConfigCorpSimpleInfo
  extends MessageMicro<ConfigCorpSimpleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "str_corp_name", "str_short_name", "str_detail_desc", "str_click_url" }, new Object[] { "", "", "", "" }, ConfigCorpSimpleInfo.class);
  public final PBStringField str_click_url = PBField.initString("");
  public final PBStringField str_corp_name = PBField.initString("");
  public final PBStringField str_detail_desc = PBField.initString("");
  public final PBStringField str_short_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.ConfigCorpSimpleInfo
 * JD-Core Version:    0.7.0.1
 */