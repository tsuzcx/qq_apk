package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_feeds_tmem$FeedLikeStatus
  extends MessageMicro<FeedLikeStatus>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "like_status", "last_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, FeedLikeStatus.class);
  public final PBUInt32Field last_time = PBField.initUInt32(0);
  public final PBUInt32Field like_status = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_tmem.FeedLikeStatus
 * JD-Core Version:    0.7.0.1
 */