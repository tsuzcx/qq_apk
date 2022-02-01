package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$InternalInfo
  extends MessageMicro<InternalInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<mobileqq_qidian.OrgJobUnion> rpt_msg_org_job_union = PBField.initRepeatMessage(mobileqq_qidian.OrgJobUnion.class);
  public final PBStringField str_internal_corp_mail = PBField.initString("");
  public final PBStringField str_internal_icon = PBField.initString("");
  public final PBStringField str_internal_job = PBField.initString("");
  public final PBStringField str_internal_mobile = PBField.initString("");
  public final PBStringField str_internal_regular_mail = PBField.initString("");
  public final PBStringField str_internal_sign = PBField.initString("");
  public final PBStringField str_internal_tel = PBField.initString("");
  public final PBStringField str_name = PBField.initString("");
  public final PBStringField str_strID = PBField.initString("");
  public final PBUInt32Field uint32_internal_gender = PBField.initUInt32(0);
  public final PBUInt64Field uint64_internal_city = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_internal_country = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_internal_district = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_internal_province = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 56, 64, 72, 80, 90, 98, 106, 114, 122, 130 }, new String[] { "uint64_uin", "str_internal_icon", "str_strID", "str_name", "str_internal_sign", "uint32_internal_gender", "uint64_internal_country", "uint64_internal_province", "uint64_internal_city", "uint64_internal_district", "rpt_msg_org_job_union", "str_internal_tel", "str_internal_mobile", "str_internal_corp_mail", "str_internal_regular_mail", "str_internal_job" }, new Object[] { localLong, "", "", "", "", Integer.valueOf(0), localLong, localLong, localLong, localLong, null, "", "", "", "", "" }, InternalInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.InternalInfo
 * JD-Core Version:    0.7.0.1
 */