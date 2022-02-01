package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class FeedCloudRead$StClearCountInfo
  extends MessageMicro<StClearCountInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "countType", "clearType", "delayTimeInterval", "rewriteClearTime" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, StClearCountInfo.class);
  public final PBInt32Field clearType = PBField.initInt32(0);
  public final PBInt32Field countType = PBField.initInt32(0);
  public final PBInt64Field delayTimeInterval = PBField.initInt64(0L);
  public final PBInt64Field rewriteClearTime = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StClearCountInfo
 * JD-Core Version:    0.7.0.1
 */