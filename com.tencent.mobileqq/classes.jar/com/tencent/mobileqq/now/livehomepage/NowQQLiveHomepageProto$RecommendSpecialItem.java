package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowQQLiveHomepageProto$RecommendSpecialItem
  extends MessageMicro<RecommendSpecialItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field hall_room_id = PBField.initUInt32(0);
  public final PBStringField string_room_img_url = PBField.initString("");
  public final PBUInt64Field tiny_id = PBField.initUInt64(0L);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uid", "tiny_id", "string_room_img_url", "hall_room_id" }, new Object[] { localLong, localLong, "", Integer.valueOf(0) }, RecommendSpecialItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RecommendSpecialItem
 * JD-Core Version:    0.7.0.1
 */