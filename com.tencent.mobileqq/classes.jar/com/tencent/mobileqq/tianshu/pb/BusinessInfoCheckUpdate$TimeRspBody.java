package com.tencent.mobileqq.tianshu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BusinessInfoCheckUpdate$TimeRspBody
  extends MessageMicro<TimeRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field iInterval = PBField.initInt32(0);
  public final PBInt32Field iLbsInterval = PBField.initInt32(0);
  public final PBInt32Field iResult = PBField.initInt32(0);
  public final PBInt32Field iStatInterval = PBField.initInt32(0);
  public final PBRepeatMessageField<BusinessInfoCheckUpdate.AppInfo> rptMsgAppInfo = PBField.initRepeatMessage(BusinessInfoCheckUpdate.AppInfo.class);
  public final PBRepeatMessageField<BusinessInfoCheckUpdate.NumRedInfo> rptMsgNumRedInfo = PBField.initRepeatMessage(BusinessInfoCheckUpdate.NumRedInfo.class);
  public final PBRepeatMessageField<BusinessInfoCheckUpdate.AppSetting> rptSetting = PBField.initRepeatMessage(BusinessInfoCheckUpdate.AppSetting.class);
  public final PBStringField sErrMsg = PBField.initString("");
  public final PBUInt64Field uiUin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 50, 58, 64, 72 }, new String[] { "iResult", "sErrMsg", "iInterval", "rptMsgAppInfo", "uiUin", "rptSetting", "rptMsgNumRedInfo", "iLbsInterval", "iStatInterval" }, new Object[] { localInteger, "", localInteger, null, Long.valueOf(0L), null, null, localInteger, localInteger }, TimeRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.TimeRspBody
 * JD-Core Version:    0.7.0.1
 */