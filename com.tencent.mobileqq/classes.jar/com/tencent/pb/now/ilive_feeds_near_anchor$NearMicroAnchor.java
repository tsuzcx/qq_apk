package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_feeds_near_anchor$NearMicroAnchor
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 24, 32 }, new String[] { "longitude", "latitude", "uid", "roomid" }, new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Long.valueOf(0L), Integer.valueOf(0) }, NearMicroAnchor.class);
  public final PBFloatField latitude = PBField.initFloat(0.0F);
  public final PBFloatField longitude = PBField.initFloat(0.0F);
  public final PBUInt32Field roomid = PBField.initUInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_near_anchor.NearMicroAnchor
 * JD-Core Version:    0.7.0.1
 */