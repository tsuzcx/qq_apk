package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRankinglist$BatchGetCircleFuelMedalRsp
  extends MessageMicro<BatchGetCircleFuelMedalRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "data" }, new Object[] { null, null }, BatchGetCircleFuelMedalRsp.class);
  public final PBRepeatMessageField<QQCircleRankinglist.CircleFuelMedalInfo> data = PBField.initRepeatMessage(QQCircleRankinglist.CircleFuelMedalInfo.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleRankinglist.BatchGetCircleFuelMedalRsp
 * JD-Core Version:    0.7.0.1
 */