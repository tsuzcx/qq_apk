package com.tencent.mobileqq.tianshu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class BusinessInfoCheckUpdate$BatchSetSettingRspBody
  extends MessageMicro<BatchSetSettingRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "iResult", "sErrMsg" }, new Object[] { Integer.valueOf(0), "" }, BatchSetSettingRspBody.class);
  public final PBInt32Field iResult = PBField.initInt32(0);
  public final PBStringField sErrMsg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.BatchSetSettingRspBody
 * JD-Core Version:    0.7.0.1
 */