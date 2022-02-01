package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.Entry;

public final class QQCircleFeedBase$StNoticeBusiData
  extends MessageMicro<StNoticeBusiData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "urlInfo", "busiInfo", "pattonInfo", "messageBoxRedPointInfo" }, new Object[] { null, null, null, null }, StNoticeBusiData.class);
  public final PBRepeatMessageField<FeedCloudCommon.Entry> busiInfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
  public QQCircleFeedBase.MessageBoxRedPointInfo messageBoxRedPointInfo = new QQCircleFeedBase.MessageBoxRedPointInfo();
  public QQCircleFeedBase.StNoticePattonInfo pattonInfo = new QQCircleFeedBase.StNoticePattonInfo();
  public final PBRepeatMessageField<FeedCloudCommon.Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StNoticeBusiData
 * JD-Core Version:    0.7.0.1
 */