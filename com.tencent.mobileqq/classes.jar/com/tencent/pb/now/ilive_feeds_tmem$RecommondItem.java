package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_feeds_tmem$RecommondItem
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "id", "start_time", "end_time", "recom_pos", "uin_lists_key" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, RecommondItem.class);
  public final PBUInt32Field end_time = PBField.initUInt32(0);
  public final PBStringField id = PBField.initString("");
  public final PBUInt32Field recom_pos = PBField.initUInt32(0);
  public final PBUInt32Field start_time = PBField.initUInt32(0);
  public final PBStringField uin_lists_key = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_tmem.RecommondItem
 * JD-Core Version:    0.7.0.1
 */