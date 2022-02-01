package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta.StFeed;

public final class QQCircleDitto$StBackCardDP
  extends MessageMicro<StBackCardDP>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "recomFeed", "buttons" }, new Object[] { null, null }, StBackCardDP.class);
  public final PBRepeatMessageField<QQCircleDitto.StButton> buttons = PBField.initRepeatMessage(QQCircleDitto.StButton.class);
  public FeedCloudMeta.StFeed recomFeed = new FeedCloudMeta.StFeed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleDitto.StBackCardDP
 * JD-Core Version:    0.7.0.1
 */