package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRankinglist$SetUserScoreReq
  extends MessageMicro<SetUserScoreReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "extInfo", "listType", "listTime", "userScores" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), null }, SetUserScoreReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBUInt32Field listTime = PBField.initUInt32(0);
  public final PBInt32Field listType = PBField.initInt32(0);
  public final PBRepeatMessageField<QQCircleRankinglist.UserScore> userScores = PBField.initRepeatMessage(QQCircleRankinglist.UserScore.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleRankinglist.SetUserScoreReq
 * JD-Core Version:    0.7.0.1
 */