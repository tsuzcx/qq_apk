package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowNearbyVideoCommentProto$AddCommentReq
  extends MessageMicro<AddCommentReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field anchor_uid = PBField.initUInt64(0L);
  public NowNearbyVideoCommentProto.CommentMsgBody content = new NowNearbyVideoCommentProto.CommentMsgBody();
  public final PBStringField feed_id = PBField.initString("");
  public final PBUInt64Field feed_owner = PBField.initUInt64(0L);
  public final PBUInt64Field feed_type = PBField.initUInt64(0L);
  public final PBUInt32Field is_aggregate_short_video = PBField.initUInt32(0);
  public final PBUInt64Field record_uid = PBField.initUInt64(0L);
  public final PBUInt64Field reply_uid = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 56, 64 }, new String[] { "feed_type", "feed_id", "record_uid", "reply_uid", "feed_owner", "content", "is_aggregate_short_video", "anchor_uid" }, new Object[] { localLong, "", localLong, localLong, localLong, null, Integer.valueOf(0), localLong }, AddCommentReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.NowNearbyVideoCommentProto.AddCommentReq
 * JD-Core Version:    0.7.0.1
 */