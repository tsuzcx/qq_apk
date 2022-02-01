package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StTagInfo;

public final class QQCircleFeedBase$StTagPageData
  extends MessageMicro<StTagPageData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "tagInfo", "tagDesc", "fuelCircleRankItem", "subsidiaryFieldDesc", "urlInfo", "rankName", "activityCopywritingDesc" }, new Object[] { null, "", null, null, null, "", "" }, StTagPageData.class);
  public final PBStringField activityCopywritingDesc = PBField.initString("");
  public final PBRepeatMessageField<QQCircleRankinglist.RankingItem> fuelCircleRankItem = PBField.initRepeatMessage(QQCircleRankinglist.RankingItem.class);
  public final PBStringField rankName = PBField.initString("");
  public final PBRepeatMessageField<FeedCloudCommon.Entry> subsidiaryFieldDesc = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
  public final PBStringField tagDesc = PBField.initString("");
  public FeedCloudMeta.StTagInfo tagInfo = new FeedCloudMeta.StTagInfo();
  public final PBRepeatMessageField<FeedCloudCommon.Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StTagPageData
 * JD-Core Version:    0.7.0.1
 */