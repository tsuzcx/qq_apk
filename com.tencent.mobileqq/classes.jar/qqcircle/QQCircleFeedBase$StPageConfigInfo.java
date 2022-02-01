package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.Entry;

public final class QQCircleFeedBase$StPageConfigInfo
  extends MessageMicro<StPageConfigInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "tagPageConfig" }, new Object[] { null }, StPageConfigInfo.class);
  public final PBRepeatMessageField<FeedCloudCommon.Entry> tagPageConfig = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StPageConfigInfo
 * JD-Core Version:    0.7.0.1
 */