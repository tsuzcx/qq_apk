package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_feeds_tmem$TimeLineItem
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "create_time", "id", "feed_type" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(1) }, TimeLineItem.class);
  public final PBUInt64Field create_time = PBField.initUInt64(0L);
  public final PBEnumField feed_type = PBField.initEnum(1);
  public final PBStringField id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_tmem.TimeLineItem
 * JD-Core Version:    0.7.0.1
 */