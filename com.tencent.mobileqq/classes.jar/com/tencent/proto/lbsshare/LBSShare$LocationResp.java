package com.tencent.proto.lbsshare;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LBSShare$LocationResp
  extends MessageMicro<LocationResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 56 }, new String[] { "ec", "poilist", "mylbs", "next", "is_foreign", "search_id", "is_ark" }, new Object[] { Integer.valueOf(0), null, null, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, LocationResp.class);
  public final PBUInt32Field ec = PBField.initUInt32(0);
  public final PBUInt32Field is_ark = PBField.initUInt32(0);
  public final PBUInt32Field is_foreign = PBField.initUInt32(0);
  public LBSShare.POI mylbs = new LBSShare.POI();
  public final PBUInt32Field next = PBField.initUInt32(0);
  public final PBRepeatMessageField<LBSShare.POI> poilist = PBField.initRepeatMessage(LBSShare.POI.class);
  public final PBStringField search_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.proto.lbsshare.LBSShare.LocationResp
 * JD-Core Version:    0.7.0.1
 */