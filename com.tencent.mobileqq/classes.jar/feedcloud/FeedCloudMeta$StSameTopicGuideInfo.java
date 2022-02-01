package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudMeta$StSameTopicGuideInfo
  extends MessageMicro<StSameTopicGuideInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50 }, new String[] { "isSameTopicGuide", "stayShowTime", "hashTag", "words", "jumpUrl", "reportExt" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "", "", "", "" }, StSameTopicGuideInfo.class);
  public final PBStringField hashTag = PBField.initString("");
  public final PBUInt32Field isSameTopicGuide = PBField.initUInt32(0);
  public final PBStringField jumpUrl = PBField.initString("");
  public final PBStringField reportExt = PBField.initString("");
  public final PBInt64Field stayShowTime = PBField.initInt64(0L);
  public final PBStringField words = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StSameTopicGuideInfo
 * JD-Core Version:    0.7.0.1
 */