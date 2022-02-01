package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class FeedCloudRead$StClearCountRspInfo
  extends MessageMicro<StClearCountRspInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "countType", "clearTime" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, StClearCountRspInfo.class);
  public final PBInt64Field clearTime = PBField.initInt64(0L);
  public final PBInt32Field countType = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StClearCountRspInfo
 * JD-Core Version:    0.7.0.1
 */