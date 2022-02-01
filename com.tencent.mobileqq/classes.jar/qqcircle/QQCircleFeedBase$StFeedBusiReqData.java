package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StPushList;

public final class QQCircleFeedBase$StFeedBusiReqData
  extends MessageMicro<StFeedBusiReqData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "allPushList", "pushList", "uninterest_buttons", "recomFeedTypeDescribe" }, new Object[] { null, null, Integer.valueOf(0), "" }, StFeedBusiReqData.class);
  public FeedCloudMeta.StLike allPushList = new FeedCloudMeta.StLike();
  public FeedCloudMeta.StPushList pushList = new FeedCloudMeta.StPushList();
  public final PBStringField recomFeedTypeDescribe = PBField.initString("");
  public final PBRepeatField<Integer> uninterest_buttons = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StFeedBusiReqData
 * JD-Core Version:    0.7.0.1
 */