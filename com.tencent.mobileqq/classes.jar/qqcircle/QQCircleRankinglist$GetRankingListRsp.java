package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRankinglist$GetRankingListRsp
  extends MessageMicro<GetRankingListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "items", "startTime", "endTime" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0) }, GetRankingListRsp.class);
  public final PBUInt32Field endTime = PBField.initUInt32(0);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<QQCircleRankinglist.RankingItem> items = PBField.initRepeatMessage(QQCircleRankinglist.RankingItem.class);
  public final PBUInt32Field startTime = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleRankinglist.GetRankingListRsp
 * JD-Core Version:    0.7.0.1
 */