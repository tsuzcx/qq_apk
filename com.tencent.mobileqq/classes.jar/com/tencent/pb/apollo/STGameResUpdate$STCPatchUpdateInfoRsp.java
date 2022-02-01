package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class STGameResUpdate$STCPatchUpdateInfoRsp
  extends MessageMicro<STCPatchUpdateInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "list" }, new Object[] { null }, STCPatchUpdateInfoRsp.class);
  public final PBRepeatMessageField<STGameResUpdate.STSvrCVerInfo> list = PBField.initRepeatMessage(STGameResUpdate.STSvrCVerInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.apollo.STGameResUpdate.STCPatchUpdateInfoRsp
 * JD-Core Version:    0.7.0.1
 */