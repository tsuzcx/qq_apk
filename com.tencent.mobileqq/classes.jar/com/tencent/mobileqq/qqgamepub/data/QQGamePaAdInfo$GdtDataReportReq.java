package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQGamePaAdInfo$GdtDataReportReq
  extends MessageMicro<GdtDataReportReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field aciotnId = PBField.initUInt32(0);
  public final PBUInt32Field adType = PBField.initUInt32(0);
  public final PBUInt32Field adid = PBField.initUInt32(0);
  public final PBUInt32Field redCnt = PBField.initUInt32(0);
  public QQGamePaAdInfo.ReportUrl reportUrl = new QQGamePaAdInfo.ReportUrl();
  public final PBInt64Field uin = PBField.initInt64(0L);
  public final PBStringField viewId = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 56 }, new String[] { "uin", "adid", "redCnt", "aciotnId", "viewId", "reportUrl", "adType" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger, "", null, localInteger }, GdtDataReportReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QQGamePaAdInfo.GdtDataReportReq
 * JD-Core Version:    0.7.0.1
 */