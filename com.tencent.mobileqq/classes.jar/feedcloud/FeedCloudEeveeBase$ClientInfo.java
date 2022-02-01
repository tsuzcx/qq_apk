package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudEeveeBase$ClientInfo
  extends MessageMicro<ClientInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "clientAppVersion" }, new Object[] { "" }, ClientInfo.class);
  public final PBStringField clientAppVersion = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudEeveeBase.ClientInfo
 * JD-Core Version:    0.7.0.1
 */