package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import feedcloud.FeedCloudCommon.Result;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleFeedbackhit$StSetFeedbackHitRsp
  extends MessageMicro<StSetFeedbackHitRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "result" }, new Object[] { null, null }, StSetFeedbackHitRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudCommon.Result result = new FeedCloudCommon.Result();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleFeedbackhit.StSetFeedbackHitRsp
 * JD-Core Version:    0.7.0.1
 */