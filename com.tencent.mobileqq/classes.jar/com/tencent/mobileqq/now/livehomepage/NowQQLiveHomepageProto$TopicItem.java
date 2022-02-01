package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NowQQLiveHomepageProto$TopicItem
  extends MessageMicro<TopicItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "string_topic", "uint32_member_count", "string_bg_url", "string_url" }, new Object[] { "", Integer.valueOf(0), "", "" }, TopicItem.class);
  public final PBStringField string_bg_url = PBField.initString("");
  public final PBStringField string_topic = PBField.initString("");
  public final PBStringField string_url = PBField.initString("");
  public final PBUInt32Field uint32_member_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.TopicItem
 * JD-Core Version:    0.7.0.1
 */