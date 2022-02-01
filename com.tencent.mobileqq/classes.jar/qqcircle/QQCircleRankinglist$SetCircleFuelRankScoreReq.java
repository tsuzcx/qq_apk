package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRankinglist$SetCircleFuelRankScoreReq
  extends MessageMicro<SetCircleFuelRankScoreReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 24, 34, 42 }, new String[] { "extInfo", "listTime", "userScores", "tid" }, new Object[] { null, Integer.valueOf(0), null, "" }, SetCircleFuelRankScoreReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBUInt32Field listTime = PBField.initUInt32(0);
  public final PBStringField tid = PBField.initString("");
  public final PBRepeatMessageField<QQCircleRankinglist.UserScore> userScores = PBField.initRepeatMessage(QQCircleRankinglist.UserScore.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleRankinglist.SetCircleFuelRankScoreReq
 * JD-Core Version:    0.7.0.1
 */