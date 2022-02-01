package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StTagInfo;

public final class QQCircleFeedBase$StTagPageData
  extends MessageMicro<StTagPageData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "tagInfo", "tagDesc" }, new Object[] { null, "" }, StTagPageData.class);
  public final PBStringField tagDesc = PBField.initString("");
  public FeedCloudMeta.StTagInfo tagInfo = new FeedCloudMeta.StTagInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StTagPageData
 * JD-Core Version:    0.7.0.1
 */