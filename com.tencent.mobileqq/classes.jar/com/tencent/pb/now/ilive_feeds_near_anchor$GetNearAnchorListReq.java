package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_feeds_near_anchor$GetNearAnchorListReq
  extends MessageMicro<GetNearAnchorListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field gender = PBField.initUInt32(0);
  public final PBFloatField latitude = PBField.initFloat(0.0F);
  public final PBFloatField longitude = PBField.initFloat(0.0F);
  public final PBUInt32Field num = PBField.initUInt32(0);
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBUInt32Field start = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Float localFloat = Float.valueOf(0.0F);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 24, 32, 40, 48 }, new String[] { "longitude", "latitude", "start", "num", "source", "gender" }, new Object[] { localFloat, localFloat, localInteger, localInteger, localInteger, localInteger }, GetNearAnchorListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_near_anchor.GetNearAnchorListReq
 * JD-Core Version:    0.7.0.1
 */