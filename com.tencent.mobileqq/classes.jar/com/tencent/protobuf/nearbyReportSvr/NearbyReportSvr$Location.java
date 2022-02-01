package com.tencent.protobuf.nearbyReportSvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class NearbyReportSvr$Location
  extends MessageMicro<Location>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "latitude", "longitude", "coordinate" }, new Object[] { "", "", Integer.valueOf(0) }, Location.class);
  public final PBInt32Field coordinate = PBField.initInt32(0);
  public final PBStringField latitude = PBField.initString("");
  public final PBStringField longitude = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.nearbyReportSvr.NearbyReportSvr.Location
 * JD-Core Version:    0.7.0.1
 */