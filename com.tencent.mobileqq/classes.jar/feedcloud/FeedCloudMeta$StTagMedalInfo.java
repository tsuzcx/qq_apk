package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedCloudMeta$StTagMedalInfo
  extends MessageMicro<StTagMedalInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "tagID", "tagName", "rank" }, new Object[] { "", "", Long.valueOf(0L) }, StTagMedalInfo.class);
  public final PBUInt64Field rank = PBField.initUInt64(0L);
  public final PBStringField tagID = PBField.initString("");
  public final PBStringField tagName = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StTagMedalInfo
 * JD-Core Version:    0.7.0.1
 */