package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedsProtocol$FeedDetailByIdsReq
  extends MessageMicro<FeedDetailByIdsReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "feed_ids" }, new Object[] { null }, FeedDetailByIdsReq.class);
  public final PBRepeatMessageField<FeedsProtocol.FeedIds> feed_ids = PBField.initRepeatMessage(FeedsProtocol.FeedIds.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol.FeedDetailByIdsReq
 * JD-Core Version:    0.7.0.1
 */