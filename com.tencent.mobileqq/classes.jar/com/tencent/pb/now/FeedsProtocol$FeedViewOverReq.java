package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedsProtocol$FeedViewOverReq
  extends MessageMicro<FeedViewOverReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "anchor_uid", "update_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, FeedViewOverReq.class);
  public final PBUInt64Field anchor_uid = PBField.initUInt64(0L);
  public final PBUInt64Field update_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol.FeedViewOverReq
 * JD-Core Version:    0.7.0.1
 */