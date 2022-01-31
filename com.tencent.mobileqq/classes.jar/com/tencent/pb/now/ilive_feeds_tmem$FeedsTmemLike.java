package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_feeds_tmem$FeedsTmemLike
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "like_number", "like_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, FeedsTmemLike.class);
  public final PBRepeatField like_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field like_number = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_tmem.FeedsTmemLike
 * JD-Core Version:    0.7.0.1
 */