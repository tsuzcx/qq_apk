package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagsvr$FeedsKeyItem
  extends MessageMicro<FeedsKeyItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "feedsKey", "feedsTime" }, new Object[] { "", "" }, FeedsKeyItem.class);
  public final PBStringField feedsKey = PBField.initString("");
  public final PBStringField feedsTime = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudTagsvr.FeedsKeyItem
 * JD-Core Version:    0.7.0.1
 */