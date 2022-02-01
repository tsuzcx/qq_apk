package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StShare;

public final class QQCircleFeedBase$StGpsPageData
  extends MessageMicro<StGpsPageData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "pageDesc", "subsidiaryFieldDesc", "poiName", "shareInfo" }, new Object[] { "", null, "", null }, StGpsPageData.class);
  public final PBStringField pageDesc = PBField.initString("");
  public final PBStringField poiName = PBField.initString("");
  public FeedCloudMeta.StShare shareInfo = new FeedCloudMeta.StShare();
  public final PBRepeatMessageField<FeedCloudCommon.Entry> subsidiaryFieldDesc = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StGpsPageData
 * JD-Core Version:    0.7.0.1
 */