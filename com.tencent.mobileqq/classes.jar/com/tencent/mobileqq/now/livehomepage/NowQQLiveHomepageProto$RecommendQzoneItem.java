package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowQQLiveHomepageProto$RecommendQzoneItem
  extends MessageMicro<RecommendQzoneItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uid", "tiny_id", "enter_room_id", "start_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", Long.valueOf(0L) }, RecommendQzoneItem.class);
  public final PBStringField enter_room_id = PBField.initString("");
  public final PBUInt64Field start_time = PBField.initUInt64(0L);
  public final PBUInt64Field tiny_id = PBField.initUInt64(0L);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RecommendQzoneItem
 * JD-Core Version:    0.7.0.1
 */