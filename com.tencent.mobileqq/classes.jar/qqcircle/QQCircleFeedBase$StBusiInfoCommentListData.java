package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;

public final class QQCircleFeedBase$StBusiInfoCommentListData
  extends MessageMicro<StBusiInfoCommentListData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "comment", "reply", "reqType" }, new Object[] { null, null, Integer.valueOf(0) }, StBusiInfoCommentListData.class);
  public FeedCloudMeta.StComment comment = new FeedCloudMeta.StComment();
  public FeedCloudMeta.StReply reply = new FeedCloudMeta.StReply();
  public final PBInt32Field reqType = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StBusiInfoCommentListData
 * JD-Core Version:    0.7.0.1
 */