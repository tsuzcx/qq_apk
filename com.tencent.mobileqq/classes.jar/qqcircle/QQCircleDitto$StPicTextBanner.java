package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StImage;

public final class QQCircleDitto$StPicTextBanner
  extends MessageMicro<StPicTextBanner>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58 }, new String[] { "banner_id", "title", "content", "backgroundImage", "actionType", "actionUrl", "buttons" }, new Object[] { "", "", "", null, Integer.valueOf(1), "", null }, StPicTextBanner.class);
  public final PBEnumField actionType = PBField.initEnum(1);
  public final PBStringField actionUrl = PBField.initString("");
  public FeedCloudMeta.StImage backgroundImage = new FeedCloudMeta.StImage();
  public final PBStringField banner_id = PBField.initString("");
  public final PBRepeatMessageField<QQCircleDitto.StButton> buttons = PBField.initRepeatMessage(QQCircleDitto.StButton.class);
  public final PBStringField content = PBField.initString("");
  public final PBStringField title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleDitto.StPicTextBanner
 * JD-Core Version:    0.7.0.1
 */