package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRankinglist$BatchGetCircleFuelMedalReq
  extends MessageMicro<BatchGetCircleFuelMedalReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "queryInfo", "listTime" }, new Object[] { null, null, Integer.valueOf(0) }, BatchGetCircleFuelMedalReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBUInt32Field listTime = PBField.initUInt32(0);
  public final PBRepeatMessageField<QQCircleRankinglist.CircleFuelMedalQueryItem> queryInfo = PBField.initRepeatMessage(QQCircleRankinglist.CircleFuelMedalQueryItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleRankinglist.BatchGetCircleFuelMedalReq
 * JD-Core Version:    0.7.0.1
 */