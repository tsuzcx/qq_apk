package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowNearbyVideoCommentProto$Comment
  extends MessageMicro<Comment>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field comment_id = PBField.initUInt64(0L);
  public NowNearbyVideoCommentProto.CommentMsgBody content = new NowNearbyVideoCommentProto.CommentMsgBody();
  public final PBUInt64Field create_time = PBField.initUInt64(0L);
  public NowNearbyVideoCommentProto.UserInfo publish_info = new NowNearbyVideoCommentProto.UserInfo();
  public NowNearbyVideoCommentProto.UserInfo reply_info = new NowNearbyVideoCommentProto.UserInfo();
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt64Field update_time = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 56 }, new String[] { "comment_id", "publish_info", "reply_info", "content", "create_time", "update_time", "type" }, new Object[] { localLong, null, null, null, localLong, localLong, Integer.valueOf(0) }, Comment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.NowNearbyVideoCommentProto.Comment
 * JD-Core Version:    0.7.0.1
 */