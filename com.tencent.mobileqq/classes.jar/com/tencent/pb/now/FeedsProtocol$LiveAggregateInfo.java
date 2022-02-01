package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedsProtocol$LiveAggregateInfo
  extends MessageMicro<LiveAggregateInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "video", "short_video", "total_short_size", "id" }, new Object[] { null, null, Integer.valueOf(0), "" }, LiveAggregateInfo.class);
  public final PBStringField id = PBField.initString("");
  public final PBRepeatMessageField<FeedsProtocol.ShortVideoInfo> short_video = PBField.initRepeatMessage(FeedsProtocol.ShortVideoInfo.class);
  public final PBUInt32Field total_short_size = PBField.initUInt32(0);
  public FeedsProtocol.VideoItem video = new FeedsProtocol.VideoItem();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol.LiveAggregateInfo
 * JD-Core Version:    0.7.0.1
 */