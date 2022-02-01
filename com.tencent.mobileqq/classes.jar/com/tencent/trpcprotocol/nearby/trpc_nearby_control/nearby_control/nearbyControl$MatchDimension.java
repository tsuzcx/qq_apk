package com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearbyControl$MatchDimension
  extends MessageMicro<MatchDimension>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field clientType = PBField.initUInt32(0);
  public final PBStringField deviceType = PBField.initString("");
  public nearbyControl.GeoData geoData = new nearbyControl.GeoData();
  public final PBRepeatMessageField<nearbyControl.RuleKeyMeta> keyMetas = PBField.initRepeatMessage(nearbyControl.RuleKeyMeta.class);
  public final PBStringField strVersion = PBField.initString("");
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50 }, new String[] { "version", "deviceType", "clientType", "strVersion", "keyMetas", "geoData" }, new Object[] { localInteger, "", localInteger, "", null, null }, MatchDimension.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control.nearbyControl.MatchDimension
 * JD-Core Version:    0.7.0.1
 */