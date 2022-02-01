package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StTagMedalInfo;

public final class QQCircleRankinglist$CircleFuelMedalInfo
  extends MessageMicro<CircleFuelMedalInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "uid", "medalList" }, new Object[] { "", null }, CircleFuelMedalInfo.class);
  public final PBRepeatMessageField<FeedCloudMeta.StTagMedalInfo> medalList = PBField.initRepeatMessage(FeedCloudMeta.StTagMedalInfo.class);
  public final PBStringField uid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleRankinglist.CircleFuelMedalInfo
 * JD-Core Version:    0.7.0.1
 */