package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudToastshowsvr$StShowTime
  extends MessageMicro<StShowTime>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field showDuration = PBField.initInt64(0L);
  public final PBUInt32Field showTimeType = PBField.initUInt32(0);
  public final PBInt64Field value = PBField.initInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "showTimeType", "value", "showDuration" }, new Object[] { Integer.valueOf(0), localLong, localLong }, StShowTime.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudToastshowsvr.StShowTime
 * JD-Core Version:    0.7.0.1
 */