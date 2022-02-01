package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class FeedCloudEeveeUndealmsg$IntervalControl
  extends MessageMicro<IntervalControl>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field homeSwitchInterval = PBField.initInt32(0);
  public final PBInt32Field pollingInterval = PBField.initInt32(0);
  public final PBInt32Field sceneSwitchInterval = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "pollingInterval", "sceneSwitchInterval", "homeSwitchInterval" }, new Object[] { localInteger, localInteger, localInteger }, IntervalControl.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudEeveeUndealmsg.IntervalControl
 * JD-Core Version:    0.7.0.1
 */