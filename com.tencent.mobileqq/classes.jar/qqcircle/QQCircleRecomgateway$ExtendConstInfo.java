package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StRelationInfo;

public final class QQCircleRecomgateway$ExtendConstInfo
  extends MessageMicro<ExtendConstInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "followList", "frdList" }, new Object[] { null, "" }, ExtendConstInfo.class);
  public final PBRepeatMessageField<FeedCloudMeta.StRelationInfo> followList = PBField.initRepeatMessage(FeedCloudMeta.StRelationInfo.class);
  public final PBRepeatField<String> frdList = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleRecomgateway.ExtendConstInfo
 * JD-Core Version:    0.7.0.1
 */