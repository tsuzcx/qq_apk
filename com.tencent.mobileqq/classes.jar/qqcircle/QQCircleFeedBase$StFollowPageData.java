package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StDittoFeed;

public final class QQCircleFeedBase$StFollowPageData
  extends MessageMicro<StFollowPageData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "recomCircileCertification", "tipsTitle", "dittoFeed" }, new Object[] { null, "", null }, StFollowPageData.class);
  public FeedCloudMeta.StDittoFeed dittoFeed = new FeedCloudMeta.StDittoFeed();
  public QQCircleBase.UserCircleInfo recomCircileCertification = new QQCircleBase.UserCircleInfo();
  public final PBStringField tipsTitle = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StFollowPageData
 * JD-Core Version:    0.7.0.1
 */