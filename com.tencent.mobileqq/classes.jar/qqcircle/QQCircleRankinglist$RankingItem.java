package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import feedcloud.FeedCloudMeta.StRelationInfo;
import feedcloud.FeedCloudMeta.StUser;

public final class QQCircleRankinglist$RankingItem
  extends MessageMicro<RankingItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "user", "relation", "score", "grade" }, new Object[] { null, null, Long.valueOf(0L), Integer.valueOf(0) }, RankingItem.class);
  public final PBInt32Field grade = PBField.initInt32(0);
  public FeedCloudMeta.StRelationInfo relation = new FeedCloudMeta.StRelationInfo();
  public final PBInt64Field score = PBField.initInt64(0L);
  public FeedCloudMeta.StUser user = new FeedCloudMeta.StUser();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleRankinglist.RankingItem
 * JD-Core Version:    0.7.0.1
 */