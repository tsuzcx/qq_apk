package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQGamePaAdInfo$LoginReportRsp
  extends MessageMicro<LoginReportRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "cacheTime" }, new Object[] { Integer.valueOf(0) }, LoginReportRsp.class);
  public final PBUInt32Field cacheTime = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QQGamePaAdInfo.LoginReportRsp
 * JD-Core Version:    0.7.0.1
 */