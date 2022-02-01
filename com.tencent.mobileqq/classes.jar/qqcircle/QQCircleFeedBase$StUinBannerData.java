package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StUser;

public final class QQCircleFeedBase$StUinBannerData
  extends MessageMicro<StUinBannerData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "text", "jumpUrl", "userList" }, new Object[] { "", "", null }, StUinBannerData.class);
  public final PBStringField jumpUrl = PBField.initString("");
  public final PBStringField text = PBField.initString("");
  public final PBRepeatMessageField<FeedCloudMeta.StUser> userList = PBField.initRepeatMessage(FeedCloudMeta.StUser.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StUinBannerData
 * JD-Core Version:    0.7.0.1
 */