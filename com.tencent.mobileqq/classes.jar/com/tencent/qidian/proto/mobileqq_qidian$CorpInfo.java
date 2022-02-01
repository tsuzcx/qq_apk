package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$CorpInfo
  extends MessageMicro<CorpInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 74 }, new String[] { "str_corp_short_name", "str_corp_intro", "str_homepage", "str_address", "str_corp_call", "str_postcode", "str_logo", "uint64_master_uin", "str_corp_full_name" }, new Object[] { "", "", "", "", "", "", "", Long.valueOf(0L), "" }, CorpInfo.class);
  public final PBStringField str_address = PBField.initString("");
  public final PBStringField str_corp_call = PBField.initString("");
  public final PBStringField str_corp_full_name = PBField.initString("");
  public final PBStringField str_corp_intro = PBField.initString("");
  public final PBStringField str_corp_short_name = PBField.initString("");
  public final PBStringField str_homepage = PBField.initString("");
  public final PBStringField str_logo = PBField.initString("");
  public final PBStringField str_postcode = PBField.initString("");
  public final PBUInt64Field uint64_master_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.CorpInfo
 * JD-Core Version:    0.7.0.1
 */