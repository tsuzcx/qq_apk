package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQGamePaAdInfo$LoginReportReq
  extends MessageMicro<LoginReportReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "deviceInfo", "uin" }, new Object[] { "", Long.valueOf(0L) }, LoginReportReq.class);
  public final PBStringField deviceInfo = PBField.initString("");
  public final PBInt64Field uin = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QQGamePaAdInfo.LoginReportReq
 * JD-Core Version:    0.7.0.1
 */