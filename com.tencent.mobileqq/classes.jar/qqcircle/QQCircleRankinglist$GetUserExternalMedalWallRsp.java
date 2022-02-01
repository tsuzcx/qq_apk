package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StMedalInfo;

public final class QQCircleRankinglist$GetUserExternalMedalWallRsp
  extends MessageMicro<GetUserExternalMedalWallRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "medalInfos", "needRedPoint" }, new Object[] { null, null, Boolean.valueOf(false) }, GetUserExternalMedalWallRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<FeedCloudMeta.StMedalInfo> medalInfos = PBField.initRepeatMessage(FeedCloudMeta.StMedalInfo.class);
  public final PBBoolField needRedPoint = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleRankinglist.GetUserExternalMedalWallRsp
 * JD-Core Version:    0.7.0.1
 */