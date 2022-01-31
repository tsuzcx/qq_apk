package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StImage;

public final class QQCircleDitto$StItemInfo
  extends MessageMicro<StItemInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "id", "name", "des", "images", "buttonInfo", "urlInfo", "busiInfo" }, new Object[] { "", "", "", null, null, null, null }, StItemInfo.class);
  public final PBRepeatMessageField<FeedCloudCommon.Entry> busiInfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
  public QQCircleDitto.StButton buttonInfo = new QQCircleDitto.StButton();
  public final PBRepeatField<String> des = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField id = PBField.initString("");
  public final PBRepeatMessageField<FeedCloudMeta.StImage> images = PBField.initRepeatMessage(FeedCloudMeta.StImage.class);
  public final PBStringField name = PBField.initString("");
  public final PBRepeatMessageField<FeedCloudCommon.Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleDitto.StItemInfo
 * JD-Core Version:    0.7.0.1
 */