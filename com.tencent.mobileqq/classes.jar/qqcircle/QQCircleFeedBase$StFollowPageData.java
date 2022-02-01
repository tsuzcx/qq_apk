package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StDittoFeed;

public final class QQCircleFeedBase$StFollowPageData
  extends MessageMicro<StFollowPageData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiReport = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedCloudMeta.StDittoFeed dittoFeed = new FeedCloudMeta.StDittoFeed();
  public QQCircleBase.UserCircleInfo recomCircileCertification = new QQCircleBase.UserCircleInfo();
  public final PBStringField tipsTitle = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "recomCircileCertification", "tipsTitle", "dittoFeed", "busiReport" }, new Object[] { null, "", null, localByteStringMicro }, StFollowPageData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StFollowPageData
 * JD-Core Version:    0.7.0.1
 */