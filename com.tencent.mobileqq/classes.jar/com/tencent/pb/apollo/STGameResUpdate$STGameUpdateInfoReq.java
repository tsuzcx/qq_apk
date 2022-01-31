package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class STGameResUpdate$STGameUpdateInfoReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 402 }, new String[] { "gvInfoList", "from" }, new Object[] { null, "" }, STGameUpdateInfoReq.class);
  public final PBStringField from = PBField.initString("");
  public final PBRepeatMessageField gvInfoList = PBField.initRepeatMessage(STGameResUpdate.STGameVerInfoIn.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.apollo.STGameResUpdate.STGameUpdateInfoReq
 * JD-Core Version:    0.7.0.1
 */