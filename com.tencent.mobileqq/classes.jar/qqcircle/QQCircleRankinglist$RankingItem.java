package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import feedcloud.FeedCloudMeta.StRelationInfo;
import feedcloud.FeedCloudMeta.StUser;

public final class QQCircleRankinglist$RankingItem
  extends MessageMicro<RankingItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "user", "relation", "score" }, new Object[] { null, null, Long.valueOf(0L) }, RankingItem.class);
  public FeedCloudMeta.StRelationInfo relation = new FeedCloudMeta.StRelationInfo();
  public final PBInt64Field score = PBField.initInt64(0L);
  public FeedCloudMeta.StUser user = new FeedCloudMeta.StUser();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleRankinglist.RankingItem
 * JD-Core Version:    0.7.0.1
 */