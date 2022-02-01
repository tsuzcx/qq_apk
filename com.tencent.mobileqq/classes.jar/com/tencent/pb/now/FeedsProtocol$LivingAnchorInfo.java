package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedsProtocol$LivingAnchorInfo
  extends MessageMicro<LivingAnchorInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field anchor_id = PBField.initUInt64(0L);
  public final PBUInt32Field logo_key = PBField.initUInt32(0);
  public final PBUInt32Field room_id = PBField.initUInt32(0);
  public final PBUInt64Field start_time = PBField.initUInt64(0L);
  public final PBUInt32Field subroom_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "anchor_id", "room_id", "subroom_id", "start_time", "logo_key" }, new Object[] { localLong, localInteger, localInteger, localLong, localInteger }, LivingAnchorInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol.LivingAnchorInfo
 * JD-Core Version:    0.7.0.1
 */