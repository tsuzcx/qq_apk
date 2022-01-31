package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class STGameResUpdate$STGameUpdateInfoRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "gvInfoList" }, new Object[] { null }, STGameUpdateInfoRsp.class);
  public final PBRepeatMessageField gvInfoList = PBField.initRepeatMessage(STGameResUpdate.STGameVerInfoOut.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.apollo.STGameResUpdate.STGameUpdateInfoRsp
 * JD-Core Version:    0.7.0.1
 */