package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;

public final class QQCircleFeedBase$StBusiInfoCommentListData
  extends MessageMicro<StBusiInfoCommentListData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "comment", "reply" }, new Object[] { null, null }, StBusiInfoCommentListData.class);
  public FeedCloudMeta.StComment comment = new FeedCloudMeta.StComment();
  public FeedCloudMeta.StReply reply = new FeedCloudMeta.StReply();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StBusiInfoCommentListData
 * JD-Core Version:    0.7.0.1
 */