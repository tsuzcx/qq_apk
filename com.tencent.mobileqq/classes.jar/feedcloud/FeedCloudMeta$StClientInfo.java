package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudMeta$StClientInfo
  extends MessageMicro<StClientInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "feedclientkey", "clientMap" }, new Object[] { "", null }, StClientInfo.class);
  public final PBRepeatMessageField<FeedCloudCommon.Entry> clientMap = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
  public final PBStringField feedclientkey = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StClientInfo
 * JD-Core Version:    0.7.0.1
 */