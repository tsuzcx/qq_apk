package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class STCommon$STCPatchUpdateInfoReq
  extends MessageMicro<STCPatchUpdateInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 402 }, new String[] { "list", "from" }, new Object[] { null, "" }, STCPatchUpdateInfoReq.class);
  public final PBStringField from = PBField.initString("");
  public final PBRepeatMessageField<STCommon.STLocalCVerInfo> list = PBField.initRepeatMessage(STCommon.STLocalCVerInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.apollo.STCommon.STCPatchUpdateInfoReq
 * JD-Core Version:    0.7.0.1
 */