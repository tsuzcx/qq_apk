package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$OrgJobUnion
  extends MessageMicro<OrgJobUnion>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_parentorgid", "str_job" }, new Object[] { Long.valueOf(0L), "" }, OrgJobUnion.class);
  public final PBStringField str_job = PBField.initString("");
  public final PBUInt64Field uint64_parentorgid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.OrgJobUnion
 * JD-Core Version:    0.7.0.1
 */