package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StMedalInfo;

public final class QQCircleRankinglist$SetUserWearingMedalReq
  extends MessageMicro<SetUserWearingMedalReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "uid", "medalInfos" }, new Object[] { null, "", null }, SetUserWearingMedalReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<FeedCloudMeta.StMedalInfo> medalInfos = PBField.initRepeatMessage(FeedCloudMeta.StMedalInfo.class);
  public final PBStringField uid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleRankinglist.SetUserWearingMedalReq
 * JD-Core Version:    0.7.0.1
 */