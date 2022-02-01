package com.tencent.mobileqq.tianshu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BusinessInfoCheckUpdate$SettingRspBody
  extends MessageMicro<SettingRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field iInterval = PBField.initInt32(0);
  public final PBInt32Field iResult = PBField.initInt32(0);
  public final PBRepeatMessageField<BusinessInfoCheckUpdate.AppSetting> rptSetting = PBField.initRepeatMessage(BusinessInfoCheckUpdate.AppSetting.class);
  public final PBStringField sErrMsg = PBField.initString("");
  public final PBUInt64Field uiUin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "iResult", "sErrMsg", "iInterval", "uiUin", "rptSetting" }, new Object[] { localInteger, "", localInteger, Long.valueOf(0L), null }, SettingRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.SettingRspBody
 * JD-Core Version:    0.7.0.1
 */