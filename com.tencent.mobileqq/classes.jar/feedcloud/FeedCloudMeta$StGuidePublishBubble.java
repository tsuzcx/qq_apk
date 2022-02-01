package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudMeta$StGuidePublishBubble
  extends MessageMicro<StGuidePublishBubble>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "id", "backgroundImage", "jumpUrl" }, new Object[] { "", null, "" }, StGuidePublishBubble.class);
  public FeedCloudMeta.StImage backgroundImage = new FeedCloudMeta.StImage();
  public final PBStringField id = PBField.initString("");
  public final PBStringField jumpUrl = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StGuidePublishBubble
 * JD-Core Version:    0.7.0.1
 */