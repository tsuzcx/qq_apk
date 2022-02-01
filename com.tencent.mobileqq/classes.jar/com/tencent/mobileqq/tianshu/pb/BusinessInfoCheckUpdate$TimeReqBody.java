package com.tencent.mobileqq.tianshu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BusinessInfoCheckUpdate$TimeReqBody
  extends MessageMicro<TimeReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bHebaFlag = PBField.initBool(false);
  public final PBInt32Field iProtocolVer = PBField.initInt32(0);
  public BusinessInfoCheckUpdate.LbsInfo lbs = new BusinessInfoCheckUpdate.LbsInfo();
  public final PBRepeatField<Long> rptIdList = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatMessageField<BusinessInfoCheckUpdate.AppInfo> rptMsgAppInfo = PBField.initRepeatMessage(BusinessInfoCheckUpdate.AppInfo.class);
  public final PBRepeatField<String> rptNoRedPath = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatMessageField<BusinessInfoCheckUpdate.AppSetting> rptSetting = PBField.initRepeatMessage(BusinessInfoCheckUpdate.AppSetting.class);
  public final PBStringField sClientVer = PBField.initString("");
  public final PBStringField sQimei = PBField.initString("");
  public final PBUInt32Field uReqType = PBField.initUInt32(0);
  public final PBUInt32Field uiClientPlatID = PBField.initUInt32(0);
  public final PBUInt32Field uiNetType = PBField.initUInt32(0);
  public final PBUInt64Field uiUin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50, 58, 66, 72, 80, 90, 96, 104 }, new String[] { "iProtocolVer", "uiClientPlatID", "sClientVer", "uiUin", "rptMsgAppInfo", "rptSetting", "rptNoRedPath", "lbs", "uiNetType", "bHebaFlag", "sQimei", "uReqType", "rptIdList" }, new Object[] { localInteger, localInteger, "", Long.valueOf(0L), null, null, "", null, localInteger, Boolean.valueOf(false), "", localInteger, Long.valueOf(0L) }, TimeReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.TimeReqBody
 * JD-Core Version:    0.7.0.1
 */