package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;

public final class QQCircleFeedBase$StBackflowPymkPageData
  extends MessageMicro<StBackflowPymkPageData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50 }, new String[] { "enterBackflowTimestamp", "isFrequencyHit", "backgroundImage", "backflowPymkDescEntry", "friends", "content" }, new Object[] { Long.valueOf(0L), Boolean.valueOf(false), null, null, null, "" }, StBackflowPymkPageData.class);
  public final PBRepeatMessageField<QQCircleFeedBase.BackflowPymkDescEntry> backflowPymkDescEntry = PBField.initRepeatMessage(QQCircleFeedBase.BackflowPymkDescEntry.class);
  public FeedCloudMeta.StImage backgroundImage = new FeedCloudMeta.StImage();
  public final PBStringField content = PBField.initString("");
  public final PBUInt64Field enterBackflowTimestamp = PBField.initUInt64(0L);
  public final PBRepeatMessageField<FeedCloudMeta.StUser> friends = PBField.initRepeatMessage(FeedCloudMeta.StUser.class);
  public final PBBoolField isFrequencyHit = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StBackflowPymkPageData
 * JD-Core Version:    0.7.0.1
 */