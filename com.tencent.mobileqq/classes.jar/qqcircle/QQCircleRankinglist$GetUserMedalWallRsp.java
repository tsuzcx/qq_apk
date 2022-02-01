package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StMedalInfo;
import feedcloud.FeedCloudMeta.StWearingMedal;

public final class QQCircleRankinglist$GetUserMedalWallRsp
  extends MessageMicro<GetUserMedalWallRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "medalInfos", "wearingMedal" }, new Object[] { null, null, null }, GetUserMedalWallRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<FeedCloudMeta.StMedalInfo> medalInfos = PBField.initRepeatMessage(FeedCloudMeta.StMedalInfo.class);
  public FeedCloudMeta.StWearingMedal wearingMedal = new FeedCloudMeta.StWearingMedal();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleRankinglist.GetUserMedalWallRsp
 * JD-Core Version:    0.7.0.1
 */