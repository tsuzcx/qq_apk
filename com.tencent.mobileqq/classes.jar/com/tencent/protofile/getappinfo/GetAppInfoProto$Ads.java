package com.tencent.protofile.getappinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetAppInfoProto$Ads
  extends MessageMicro<Ads>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "imgURL", "txt", "beginTime", "endTime", "serverTime" }, new Object[] { "", "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, Ads.class);
  public final PBInt64Field beginTime = PBField.initInt64(0L);
  public final PBInt64Field endTime = PBField.initInt64(0L);
  public final PBStringField imgURL = PBField.initString("");
  public final PBInt64Field serverTime = PBField.initInt64(0L);
  public final PBStringField txt = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protofile.getappinfo.GetAppInfoProto.Ads
 * JD-Core Version:    0.7.0.1
 */