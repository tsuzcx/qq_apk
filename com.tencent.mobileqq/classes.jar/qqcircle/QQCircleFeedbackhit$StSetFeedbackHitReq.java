package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleFeedbackhit$StSetFeedbackHitReq
  extends MessageMicro<StSetFeedbackHitReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "feedbackInfo", "type" }, new Object[] { null, null, Integer.valueOf(0) }, StSetFeedbackHitReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public QQCircleFeedbackhit.StFeedbackCommonInfo feedbackInfo = new QQCircleFeedbackhit.StFeedbackCommonInfo();
  public final PBEnumField type = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleFeedbackhit.StSetFeedbackHitReq
 * JD-Core Version:    0.7.0.1
 */