package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$CorpReportInfo
  extends MessageMicro<CorpReportInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_kfuin", "uint64_kfaccount" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, CorpReportInfo.class);
  public final PBUInt64Field uint64_kfaccount = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_kfuin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.CorpReportInfo
 * JD-Core Version:    0.7.0.1
 */