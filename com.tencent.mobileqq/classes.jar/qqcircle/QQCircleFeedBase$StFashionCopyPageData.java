package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StShare;

public final class QQCircleFeedBase$StFashionCopyPageData
  extends MessageMicro<StFashionCopyPageData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "simulateInfo", "pageDesc", "subTitleEntry", "shareInfo" }, new Object[] { null, "", null, null }, StFashionCopyPageData.class);
  public final PBStringField pageDesc = PBField.initString("");
  public FeedCloudMeta.StShare shareInfo = new FeedCloudMeta.StShare();
  public QQCircleFeedBase.StSimulateData simulateInfo = new QQCircleFeedBase.StSimulateData();
  public final PBRepeatMessageField<FeedCloudCommon.Entry> subTitleEntry = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StFashionCopyPageData
 * JD-Core Version:    0.7.0.1
 */