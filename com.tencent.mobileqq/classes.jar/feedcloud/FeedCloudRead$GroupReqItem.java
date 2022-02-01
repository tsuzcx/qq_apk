package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudRead$GroupReqItem
  extends MessageMicro<GroupReqItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "gid", "attachInfo" }, new Object[] { "", "" }, GroupReqItem.class);
  public final PBStringField attachInfo = PBField.initString("");
  public final PBStringField gid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudRead.GroupReqItem
 * JD-Core Version:    0.7.0.1
 */