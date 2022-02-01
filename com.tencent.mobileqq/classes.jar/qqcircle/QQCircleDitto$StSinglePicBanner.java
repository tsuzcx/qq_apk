package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StImage;
import tianshu.QQCircleTianShu.AdItem;

public final class QQCircleDitto$StSinglePicBanner
  extends MessageMicro<StSinglePicBanner>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42 }, new String[] { "image", "actionType", "actionUrl", "buttons", "tianshuAdItem" }, new Object[] { null, Integer.valueOf(1), "", null, null }, StSinglePicBanner.class);
  public final PBEnumField actionType = PBField.initEnum(1);
  public final PBStringField actionUrl = PBField.initString("");
  public final PBRepeatMessageField<QQCircleDitto.StNegativeFbButton> buttons = PBField.initRepeatMessage(QQCircleDitto.StNegativeFbButton.class);
  public FeedCloudMeta.StImage image = new FeedCloudMeta.StImage();
  public QQCircleTianShu.AdItem tianshuAdItem = new QQCircleTianShu.AdItem();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleDitto.StSinglePicBanner
 * JD-Core Version:    0.7.0.1
 */