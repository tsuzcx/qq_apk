package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class ilive_feeds_read$FollowTabRedPointReq
  extends MessageMicro<FollowTabRedPointReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "op", "time" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, FollowTabRedPointReq.class);
  public final PBInt32Field op = PBField.initInt32(0);
  public final PBInt64Field time = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_read.FollowTabRedPointReq
 * JD-Core Version:    0.7.0.1
 */