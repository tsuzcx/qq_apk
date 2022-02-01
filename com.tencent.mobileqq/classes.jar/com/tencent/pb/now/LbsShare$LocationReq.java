package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LbsShare$LocationReq
  extends MessageMicro<LocationReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField category = PBField.initString("");
  public final PBStringField city = PBField.initString("");
  public final PBUInt32Field coordinate = PBField.initUInt32(0);
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBStringField imei = PBField.initString("");
  public final PBStringField keyword = PBField.initString("");
  public final PBInt32Field lat = PBField.initInt32(0);
  public final PBInt32Field lng = PBField.initInt32(0);
  public final PBUInt32Field page = PBField.initUInt32(0);
  public final PBUInt32Field requireMyLbs = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56, 64, 74, 82 }, new String[] { "lat", "lng", "coordinate", "keyword", "category", "page", "count", "requireMyLbs", "imei", "city" }, new Object[] { localInteger, localInteger, localInteger, "", "", localInteger, localInteger, localInteger, "", "" }, LocationReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.LbsShare.LocationReq
 * JD-Core Version:    0.7.0.1
 */