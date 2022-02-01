package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;

public final class QQCircleFeedBase$StNewUserPymkPageData
  extends MessageMicro<StNewUserPymkPageData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "backgroundImage", "friends", "content" }, new Object[] { null, null, "" }, StNewUserPymkPageData.class);
  public FeedCloudMeta.StImage backgroundImage = new FeedCloudMeta.StImage();
  public final PBStringField content = PBField.initString("");
  public final PBRepeatMessageField<FeedCloudMeta.StUser> friends = PBField.initRepeatMessage(FeedCloudMeta.StUser.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StNewUserPymkPageData
 * JD-Core Version:    0.7.0.1
 */