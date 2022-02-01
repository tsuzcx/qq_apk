package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_feeds_near_anchor$GetNearPgcAnchorReq
  extends MessageMicro<GetNearPgcAnchorReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBDoubleField distance_range = PBField.initDouble(0.0D);
  public ilive_feeds_near_anchor.PgcAnchorFilter filter = new ilive_feeds_near_anchor.PgcAnchorFilter();
  public final PBUInt32Field gender = PBField.initUInt32(0);
  public final PBFloatField latitude = PBField.initFloat(0.0F);
  public final PBFloatField longitude = PBField.initFloat(0.0F);
  public final PBUInt32Field num = PBField.initUInt32(0);
  public final PBUInt32Field start = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Float localFloat = Float.valueOf(0.0F);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 25, 32, 40, 50, 56 }, new String[] { "longitude", "latitude", "distance_range", "start", "num", "filter", "gender" }, new Object[] { localFloat, localFloat, Double.valueOf(0.0D), localInteger, localInteger, null, localInteger }, GetNearPgcAnchorReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_near_anchor.GetNearPgcAnchorReq
 * JD-Core Version:    0.7.0.1
 */