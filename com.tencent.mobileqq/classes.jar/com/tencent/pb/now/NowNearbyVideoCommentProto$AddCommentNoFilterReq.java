package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowNearbyVideoCommentProto$AddCommentNoFilterReq
  extends MessageMicro<AddCommentNoFilterReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 64, 72 }, new String[] { "feed_type", "feed_id", "video_recorder", "video_owner", "video_anchor", "reply_user", "content", "is_aggregate_short_video", "reply_comment_id" }, new Object[] { Long.valueOf(0L), "", null, null, null, null, null, Integer.valueOf(0), Long.valueOf(0L) }, AddCommentNoFilterReq.class);
  public NowNearbyVideoCommentProto.CommentMsgBody content = new NowNearbyVideoCommentProto.CommentMsgBody();
  public final PBStringField feed_id = PBField.initString("");
  public final PBUInt64Field feed_type = PBField.initUInt64(0L);
  public final PBUInt32Field is_aggregate_short_video = PBField.initUInt32(0);
  public final PBUInt64Field reply_comment_id = PBField.initUInt64(0L);
  public NowNearbyVideoCommentProto.UserInfo reply_user = new NowNearbyVideoCommentProto.UserInfo();
  public NowNearbyVideoCommentProto.UserInfo video_anchor = new NowNearbyVideoCommentProto.UserInfo();
  public NowNearbyVideoCommentProto.UserInfo video_owner = new NowNearbyVideoCommentProto.UserInfo();
  public NowNearbyVideoCommentProto.UserInfo video_recorder = new NowNearbyVideoCommentProto.UserInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.now.NowNearbyVideoCommentProto.AddCommentNoFilterReq
 * JD-Core Version:    0.7.0.1
 */