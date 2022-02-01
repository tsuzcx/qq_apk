package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LbsShare$LocationResp
  extends MessageMicro<LocationResp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field ec = PBField.initUInt32(0);
  public final PBUInt32Field is_foreign = PBField.initUInt32(0);
  public LbsShare.POI mylbs = new LbsShare.POI();
  public final PBUInt32Field next = PBField.initUInt32(0);
  public final PBRepeatMessageField<LbsShare.POI> poilist = PBField.initRepeatMessage(LbsShare.POI.class);
  public final PBStringField search_id = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50 }, new String[] { "ec", "poilist", "mylbs", "next", "is_foreign", "search_id" }, new Object[] { localInteger, null, null, localInteger, localInteger, "" }, LocationResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.LbsShare.LocationResp
 * JD-Core Version:    0.7.0.1
 */