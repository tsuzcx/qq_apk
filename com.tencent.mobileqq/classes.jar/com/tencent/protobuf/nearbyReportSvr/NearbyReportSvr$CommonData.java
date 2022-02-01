package com.tencent.protobuf.nearbyReportSvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class NearbyReportSvr$CommonData
  extends MessageMicro<CommonData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "client_ip", "platform", "version" }, new Object[] { "", "", "" }, CommonData.class);
  public final PBStringField client_ip = PBField.initString("");
  public final PBStringField platform = PBField.initString("");
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.nearbyReportSvr.NearbyReportSvr.CommonData
 * JD-Core Version:    0.7.0.1
 */