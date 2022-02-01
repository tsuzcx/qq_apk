package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_feeds_near_anchor$GetNearListByRoomIDReq
  extends MessageMicro<GetNearListByRoomIDReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 24, 32, 40, 48, 56 }, new String[] { "longitude", "latitude", "roomid", "num", "source", "gender", "gender_filter" }, new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetNearListByRoomIDReq.class);
  public final PBUInt32Field gender = PBField.initUInt32(0);
  public final PBEnumField gender_filter = PBField.initEnum(0);
  public final PBFloatField latitude = PBField.initFloat(0.0F);
  public final PBFloatField longitude = PBField.initFloat(0.0F);
  public final PBUInt32Field num = PBField.initUInt32(0);
  public final PBUInt32Field roomid = PBField.initUInt32(0);
  public final PBUInt32Field source = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_near_anchor.GetNearListByRoomIDReq
 * JD-Core Version:    0.7.0.1
 */