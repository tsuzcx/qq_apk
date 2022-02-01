package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQGamePaAdInfo$ReportUrl
  extends MessageMicro<ReportUrl>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "click_url", "exposure_url", "original_exposure_url" }, new Object[] { "", "", "" }, ReportUrl.class);
  public final PBStringField click_url = PBField.initString("");
  public final PBStringField exposure_url = PBField.initString("");
  public final PBStringField original_exposure_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QQGamePaAdInfo.ReportUrl
 * JD-Core Version:    0.7.0.1
 */