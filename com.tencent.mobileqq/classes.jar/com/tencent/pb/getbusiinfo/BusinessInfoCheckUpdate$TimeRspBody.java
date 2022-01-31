package com.tencent.pb.getbusiinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BusinessInfoCheckUpdate$TimeRspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 50, 58, 64 }, new String[] { "iResult", "sErrMsg", "iInterval", "rptMsgAppInfo", "uiUin", "rptSetting", "rptMsgNumRedInfo", "iLbsInterval" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), null, Long.valueOf(0L), null, null, Integer.valueOf(0) }, TimeRspBody.class);
  public final PBInt32Field iInterval = PBField.initInt32(0);
  public final PBInt32Field iLbsInterval = PBField.initInt32(0);
  public final PBInt32Field iResult = PBField.initInt32(0);
  public final PBRepeatMessageField rptMsgAppInfo = PBField.initRepeatMessage(BusinessInfoCheckUpdate.AppInfo.class);
  public final PBRepeatMessageField rptMsgNumRedInfo = PBField.initRepeatMessage(BusinessInfoCheckUpdate.NumRedInfo.class);
  public final PBRepeatMessageField rptSetting = PBField.initRepeatMessage(BusinessInfoCheckUpdate.AppSetting.class);
  public final PBStringField sErrMsg = PBField.initString("");
  public final PBUInt64Field uiUin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody
 * JD-Core Version:    0.7.0.1
 */