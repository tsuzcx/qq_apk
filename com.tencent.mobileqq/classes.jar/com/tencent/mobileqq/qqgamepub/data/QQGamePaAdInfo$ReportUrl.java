package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQGamePaAdInfo$ReportUrl
  extends MessageMicro<ReportUrl>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "clickUrl", "exposureUrl", "originalExposureUrl" }, new Object[] { "", "", "" }, ReportUrl.class);
  public final PBStringField clickUrl = PBField.initString("");
  public final PBStringField exposureUrl = PBField.initString("");
  public final PBStringField originalExposureUrl = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QQGamePaAdInfo.ReportUrl
 * JD-Core Version:    0.7.0.1
 */