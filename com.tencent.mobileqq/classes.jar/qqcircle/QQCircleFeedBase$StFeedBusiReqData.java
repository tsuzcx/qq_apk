package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StPushList;

public final class QQCircleFeedBase$StFeedBusiReqData
  extends MessageMicro<StFeedBusiReqData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "allPushList", "pushList" }, new Object[] { null, null }, StFeedBusiReqData.class);
  public FeedCloudMeta.StLike allPushList = new FeedCloudMeta.StLike();
  public FeedCloudMeta.StPushList pushList = new FeedCloudMeta.StPushList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StFeedBusiReqData
 * JD-Core Version:    0.7.0.1
 */