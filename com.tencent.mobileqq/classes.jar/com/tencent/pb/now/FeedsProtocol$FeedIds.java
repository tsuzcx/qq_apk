package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedsProtocol$FeedIds
  extends MessageMicro<FeedIds>
{
  public static final int LIVE_AGGREGATE = 1;
  public static final int SHORT_VIDEO = 3;
  public static final int VIDEO_LIST = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field follow_type = PBField.initUInt32(0);
  public final PBUInt64Field follow_uid = PBField.initUInt64(0L);
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "feed_id", "type", "follow_type", "follow_uid" }, new Object[] { localByteStringMicro, localInteger, localInteger, Long.valueOf(0L) }, FeedIds.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol.FeedIds
 * JD-Core Version:    0.7.0.1
 */