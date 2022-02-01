package com.tencent.mobileqq.tianshu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BusinessInfoCheckUpdate$SettingReqBody
  extends MessageMicro<SettingReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field iProtocolVer = PBField.initInt32(0);
  public final PBRepeatField<Integer> rptAppid = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBStringField sClientVer = PBField.initString("");
  public final PBUInt32Field uiClientPlatID = PBField.initUInt32(0);
  public final PBUInt64Field uiUin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "iProtocolVer", "uiClientPlatID", "sClientVer", "uiUin", "rptAppid" }, new Object[] { localInteger, localInteger, "", Long.valueOf(0L), localInteger }, SettingReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.SettingReqBody
 * JD-Core Version:    0.7.0.1
 */